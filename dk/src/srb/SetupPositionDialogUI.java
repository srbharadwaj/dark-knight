/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package srb;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Class Name - SetupPositionDialogUI
 * Description - 
 *
 * @author suhas
 */
public class SetupPositionDialogUI  extends JDialog implements ActionListener,CConst
{
    public JPanel mainP = new JPanel(new BorderLayout());
    public JPanel cP = new JPanel(new BorderLayout());
    public JPanel nP = new JPanel(new BorderLayout());
    public JPanel sP = new JPanel(new BorderLayout());
    public JPanel eP = new JPanel(new BorderLayout());
    public JPanel wP = new JPanel(new BorderLayout());

    public JPanel chessBoardContainer = new JPanel(new BorderLayout());
    public JPanel chessBoard = new JPanel(new GridLayout(8,8));
    public JPanel butJPanel = new JPanel(new FlowLayout());

    public JButton ok = new JButton("Ok");
    public JButton reset = new JButton("Reset");
    public JButton clear = new JButton("Clear");
    public JButton cancel = new JButton("Cancel");
    public JButton flip = new JButton("Flip");
    public JButton openfen = new JButton("Open FEN");
    public JButton savefen = new JButton("Save FEN");
    public String pieceSelected = WHITE;
    public MyJToggleButtonSetupUI jtb[];
    public MyJToggleButtonSetupUI prevButSel;

    public SetupPositionControlsPanelUI spc = null;

    public SetupPositionDialogUI(ChessBoardJFrameUI cs, boolean modal)
    {
        super(cs, modal);

        mainP.add(processCenterPanel(),BorderLayout.CENTER);
        mainP.add(nP,BorderLayout.NORTH);
        mainP.add(processSouthPanel(),BorderLayout.SOUTH);
        mainP.add(processEastPanel(),BorderLayout.EAST);
        
        setContentPane(mainP);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        ImageIcon imageIcon16 = new ImageIcon(ChessBoardJFrameUI.class.getClassLoader().getResource(APPICON));
        setIconImage(imageIcon16.getImage());
        setSize(770, 600);
        //Display the window.
        //setVisible(true);
        setResizable(false);
        setTitle("Setup Position: "+TITLE);

        resetChessBoardUI(false);

        ok.addActionListener(this);
        reset.addActionListener(this);
        clear.addActionListener(this);
        cancel.addActionListener(this);
        flip.addActionListener(this);
        openfen.addActionListener(this);
        savefen.addActionListener(this);

    }

    public void resetChessBoardUI(boolean b)
    {
        if(b)
        {
            processCenterPanel();
        }
        prevButSel=null;
       
    }

    public JPanel processCenterPanel()
    {
        cP.removeAll();
        cP.revalidate();
        cP.add(resetChessContainerUI1(),BorderLayout.CENTER);
      
        return cP;
    }

    public JPanel processSouthPanel()
    {
        sP.removeAll();
        sP.revalidate();
       
        sP.add(createButPanel());
        return sP;

    }

    public JPanel processEastPanel()
    {
        eP.removeAll();
        eP.revalidate();
      
        spc=new SetupPositionControlsPanelUI(this);
        eP.add(spc);

        return eP;

    }

    public JPanel resetChessContainerUI1()
    {
        chessBoardContainer.removeAll();
        chessBoardContainer.revalidate();
        chessBoard.removeAll();
        chessBoard.revalidate();
        jtb = new MyJToggleButtonSetupUI[64];
        int c = 0;
        int counter=0;
        for(int i=0;i<64;i++)
        {
            jtb[i] = new MyJToggleButtonSetupUI(this);
            jtb[i].setText("");
            jtb[i].setPiece("");
            //jtb[i].setValue(mtbVal);
            if(i%2==c)
            {
                //light
                jtb[i].setLightBgColor();
            }
            else
            {
                //dark
                jtb[i].setDarkBgColor();
            }
           counter++;
           if(counter==8)
           {
               if(c==0)
               {
                    c=1;
               }
               else
               {
                   c=0;
               }
               counter=0;
           }
           chessBoard.add(jtb[i]);
        }

        setPieceUI();
        chessBoardContainer.add(chessBoard,BorderLayout.CENTER);

        chessBoardContainer.add(addA_Hpanel(true),BorderLayout.NORTH);

        return chessBoardContainer;
    }

    public JPanel addA_Hpanel(Boolean straight)
    {

        JPanel jpN = new JPanel();
        jpN.setLayout(new GridLayout(1,8));

        JToggleButton l1 = new JToggleButton("a");
        JToggleButton l2 = new JToggleButton("b");
        JToggleButton l3 = new JToggleButton("c");
        JToggleButton l4 = new JToggleButton("d");
        JToggleButton l5 = new JToggleButton("e");
        JToggleButton l6 = new JToggleButton("f");
        JToggleButton l7 = new JToggleButton("g");
        JToggleButton l8 = new JToggleButton("h");

        l1.setEnabled(false);
        l2.setEnabled(false);
        l3.setEnabled(false);
        l4.setEnabled(false);
        l5.setEnabled(false);
        l6.setEnabled(false);
        l7.setEnabled(false);
        l8.setEnabled(false);

        if(straight)
        {
            jpN.add(l1);
            jpN.add(l2);
            jpN.add(l3);
            jpN.add(l4);
            jpN.add(l5);
            jpN.add(l6);
            jpN.add(l7);
            jpN.add(l8);
        }
        else
        {
            jpN.add(l8);
            jpN.add(l7);
            jpN.add(l6);
            jpN.add(l5);
            jpN.add(l4);
            jpN.add(l3);
            jpN.add(l2);
            jpN.add(l1);
        }

        return jpN;

    }

    private JPanel createButPanel()
    {
        butJPanel.removeAll();
        butJPanel.revalidate();

      /*  ok.setIcon(new ImageIcon(getClass().getResource(START)));
        reset.setIcon(new ImageIcon(getClass().getResource(PREV)));
        clear.setIcon(new ImageIcon(getClass().getResource(NEXT)));
        cancel.setIcon(new ImageIcon(getClass().getResource(LAST)));
     */
        butJPanel.add(ok);
        butJPanel.add(reset);
        butJPanel.add(clear);
        butJPanel.add(cancel);
        butJPanel.add(flip);
        butJPanel.add(openfen);
        butJPanel.add(savefen);
        return butJPanel;
    }

    public void setPieceUI()
    {
        for(int i=0;i<jtb.length;i++)
        {
            //jtb[i].setChessp(null);
            jtb[i].setIcon(null);
            jtb[i].setSelected(false);
        }
        

        jtb[56].setIcon(new ImageIcon(getClass().getResource(whiteRook)));
        jtb[56].setPiece("WR");
        jtb[63].setIcon(new ImageIcon(getClass().getResource(whiteRook)));
        jtb[63].setPiece("WR");
        jtb[57].setIcon(new ImageIcon(getClass().getResource(whiteKnight)));
        jtb[57].setPiece("WN");
        jtb[62].setIcon(new ImageIcon(getClass().getResource(whiteKnight)));
        jtb[62].setPiece("WN");
        jtb[58].setIcon(new ImageIcon(getClass().getResource(whiteBishop)));
        jtb[58].setPiece("WB");
        jtb[61].setIcon(new ImageIcon(getClass().getResource(whiteBishop)));
        jtb[61].setPiece("WB");
        jtb[59].setIcon(new ImageIcon(getClass().getResource(whiteQueen)));
        jtb[59].setPiece("WQ");
        jtb[60].setIcon(new ImageIcon(getClass().getResource(whiteKing)));
        jtb[60].setPiece("WK");
        for(int i=48;i<=55;i++)
        {
            jtb[i].setIcon(new ImageIcon(getClass().getResource(whitePawn)));
            jtb[i].setPiece("WP");
        }

        jtb[0].setIcon(new ImageIcon(getClass().getResource(blackRook)));
        jtb[0].setPiece("BR");
        jtb[7].setIcon(new ImageIcon(getClass().getResource(blackRook)));
        jtb[7].setPiece("BR");
        jtb[1].setIcon(new ImageIcon(getClass().getResource(blackKnight)));
        jtb[1].setPiece("BN");
        jtb[6].setIcon(new ImageIcon(getClass().getResource(blackKnight)));
        jtb[6].setPiece("BN");
        jtb[2].setIcon(new ImageIcon(getClass().getResource(blackBishop)));
        jtb[2].setPiece("BB");
        jtb[5].setIcon(new ImageIcon(getClass().getResource(blackBishop)));
        jtb[5].setPiece("BB");
        jtb[3].setIcon(new ImageIcon(getClass().getResource(blackQueen)));
        jtb[3].setPiece("BQ");
        jtb[4].setIcon(new ImageIcon(getClass().getResource(blackKing)));
        jtb[4].setPiece("BK");
        for(int i=8;i<=15;i++)
        {
            jtb[i].setIcon(new ImageIcon(getClass().getResource(blackPawn)));     
            jtb[i].setPiece("BP");
        }
    }

    public void chkCastlingAndEditCheckBox()
    {
        if((jtb[0].getPiece().equals("BR")) && (jtb[4].getPiece().equals("BK")))
        {
            //enable black queen castling
            spc.cbBlackQueenCastle.setSelected(true);
        }
        else
        {
            //disable black queen castling
            spc.cbBlackQueenCastle.setSelected(false);
        }

        if((jtb[7].getPiece().equals("BR")) && (jtb[4].getPiece().equals("BK")))
        {
            //enable black king castling
            spc.cbBlackKingCastle.setSelected(true);
        }
        else
        {
            //disable black king castling
            spc.cbBlackKingCastle.setSelected(false);
        }

        if((jtb[56].getPiece().equals("WR")) && (jtb[60].getPiece().equals("WK")))
        {
            //enable white queen castling
            spc.cbWhiteQueenCastle.setSelected(true);
        }
        else
        {
            //disable white queen castling
            spc.cbWhiteQueenCastle.setSelected(false);
        }

        if((jtb[63].getPiece().equals("WR")) && (jtb[60].getPiece().equals("WK")))
        {
            //enable white king castling
            spc.cbWhiteKingCastle.setSelected(true);
        }
        else
        {
            //disable white king castling
            spc.cbWhiteKingCastle.setSelected(false);
        }

    }

     private void reverseBoard(String col)
    {
        chessBoardContainer.removeAll();
        chessBoardContainer.revalidate();

        if(col.equals(BLACK))
        {
            chessBoard.removeAll();
            chessBoard.revalidate();
            for(int i=63;i>=0;i--)
            {
                chessBoard.add(jtb[i]);
            }
            chessBoardContainer.add(addA_Hpanel(false),BorderLayout.NORTH);
        }
        else
        {
            chessBoard.removeAll();
            chessBoard.revalidate();
            for(int i=0;i<64;i++)
            {
                chessBoard.add(jtb[i]);
            }
            chessBoardContainer.add(addA_Hpanel(true),BorderLayout.NORTH);
        }
        chessBoard.repaint();

        chessBoardContainer.add(chessBoard,BorderLayout.CENTER);
        chessBoardContainer.repaint();

    }

    public void actionPerformed(ActionEvent e) {

        JButton j = (JButton) e.getSource();
        if(j.getText().equals("Flip"))
        {
            if(pieceSelected.equals(WHITE))
            {
                reverseBoard(BLACK);
                pieceSelected = BLACK;
            }
            else
            {
                reverseBoard(WHITE);
                pieceSelected = WHITE;
            }
        }
        if(j.getText().equals("Cancel"))
        {
            this.dispose();
        }
        if(j.getText().equals("Clear"))
        {
            for(int i=0;i<=63;i++)
            {
                jtb[i].setIcon(null);
                jtb[i].setPiece("");
            }
            chkCastlingAndEditCheckBox();
        }
        if(j.getText().equals("Reset"))
        {
            setPieceUI();
            chkCastlingAndEditCheckBox();
        }
        if(j.getText().equals("Save FEN"))
        {
            System.out.println("Val is : "+calculateFENfromPosition());
        }
        if(j.getText().equals("Ok"))
        {
            //TODO
        }
    }


    public String calculateFENfromPosition()
    {
        String fen;
        int b=0;
        String s;
        String str="";
        for(int i=0;i<=63;i++)
        {
            s=jtb[i].getPiece();
            if(s=="")
                b++;
            if(s.startsWith("B"))
            {
                if(b!=0)
                {
                    str = str + b;
                    b=0;
                }
                s = s.toLowerCase();
                str = str + s.toCharArray()[1];
            }
            if(s.startsWith("W"))
            {
                if(b!=0)
                {
                    str = str + b;
                    b=0;
                }
                s = s.toUpperCase();
                str = str + s.toCharArray()[1];
            }

            if(((i+1)%8)==0)
            {
                if(b!=0)
                {
                    str = str + b;
                    b=0;
                }
                if(i!=63)
                    str = str + "/";
            }
        }
        return str;
    }
}
