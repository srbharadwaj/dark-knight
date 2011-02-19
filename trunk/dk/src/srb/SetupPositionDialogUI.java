/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package srb;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;

/**
 * Class Name - SetupPositionDialogUI
 * Description - 
 *
 * @author suhas
 */
public class SetupPositionDialogUI extends JDialog implements ActionListener, CConst {

    public JPanel mainP = new JPanel(new BorderLayout());
    public JPanel cP = new JPanel(new BorderLayout());
    public JPanel nP = new JPanel(new BorderLayout());
    public JPanel sP = new JPanel(new BorderLayout());
    public JPanel eP = new JPanel(new BorderLayout());
    public JPanel wP = new JPanel(new BorderLayout());
    public JPanel chessBoardContainer = new JPanel(new BorderLayout());
    public JPanel chessBoard = new JPanel(new GridLayout(8, 8));
    public JPanel butJPanel = new JPanel(new FlowLayout());
    public JButton ok = new JButton("Ok");
    public JButton reset = new JButton("Reset");
    public JButton clear = new JButton("Clear");
    public JButton cancel = new JButton("Cancel");
    public JButton flip = new JButton("Flip");
    public JButton openfen = new JButton("Open FEN");
    public JButton savefen = new JButton("Save FEN");
    public JButton pastefen = new JButton("Paste FEN");
    public String pieceSelected = WHITE;
    public MyJToggleButtonSetupUI jtb[];
    public MyJToggleButtonSetupUI prevButSel;
    public SetupPositionControlsPanelUI spc = null;

    public SetupPositionDialogUI(ChessBoardJFrameUI cs, boolean modal) {
        super(cs, modal);

        mainP.add(processCenterPanel(), BorderLayout.CENTER);
        mainP.add(nP, BorderLayout.NORTH);
        mainP.add(processSouthPanel(), BorderLayout.SOUTH);
        mainP.add(processEastPanel(), BorderLayout.EAST);

        setContentPane(mainP);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        ImageIcon imageIcon16 = new ImageIcon(ChessBoardJFrameUI.class.getClassLoader().getResource(APPICON));
        setIconImage(imageIcon16.getImage());
        setSize(825, 600);
        //Display the window.
        //setVisible(true);
        setResizable(false);
        setTitle("Setup Position: " + TITLE);

        resetChessBoardUI(false);

        ok.addActionListener(this);
        reset.addActionListener(this);
        clear.addActionListener(this);
        cancel.addActionListener(this);
        flip.addActionListener(this);
        openfen.addActionListener(this);
        savefen.addActionListener(this);
        pastefen.addActionListener(this);

    }

    public void resetChessBoardUI(boolean b) {
        if (b) {
            processCenterPanel();
        }
        prevButSel = null;

    }

    public JPanel processCenterPanel() {
        cP.removeAll();
        cP.revalidate();
        cP.add(resetChessContainerUI1(), BorderLayout.CENTER);

        return cP;
    }

    public JPanel processSouthPanel() {
        sP.removeAll();
        sP.revalidate();

        sP.add(createButPanel());
        return sP;

    }

    public JPanel processEastPanel() {
        eP.removeAll();
        eP.revalidate();

        spc = new SetupPositionControlsPanelUI(this);
        eP.add(spc);

        return eP;

    }

    public JPanel resetChessContainerUI1() {
        chessBoardContainer.removeAll();
        chessBoardContainer.revalidate();
        chessBoard.removeAll();
        chessBoard.revalidate();
        jtb = new MyJToggleButtonSetupUI[64];
        int c = 0;
        int counter = 0;
        for (int i = 0; i < 64; i++) {
            jtb[i] = new MyJToggleButtonSetupUI(this);
            jtb[i].setText("");
            jtb[i].setPiece("");
            //jtb[i].setValue(mtbVal);
            if (i % 2 == c) {
                //light
                jtb[i].setLightBgColor();
            } else {
                //dark
                jtb[i].setDarkBgColor();
            }
            counter++;
            if (counter == 8) {
                if (c == 0) {
                    c = 1;
                } else {
                    c = 0;
                }
                counter = 0;
            }
            chessBoard.add(jtb[i]);
        }

        setPieceUI();
        chessBoardContainer.add(chessBoard, BorderLayout.CENTER);
        chessBoardContainer.add(addA_Hpanel(true), BorderLayout.PAGE_START);
        chessBoardContainer.add(addA_Hpanel(true), BorderLayout.PAGE_END);
        chessBoardContainer.add(add1_8panel(true), BorderLayout.LINE_START);
        chessBoardContainer.add(add1_8panel(true), BorderLayout.LINE_END);


        return chessBoardContainer;
    }

    public JPanel addA_Hpanel(Boolean straight) {

        JPanel jpN = new JPanel(new GridBagLayout());

        GridBagConstraints gbc100 = new GridBagConstraints();
        gbc100.fill = GridBagConstraints.HORIZONTAL;
        gbc100.ipadx = -9;
        gbc100.gridx = 0;
        gbc100.gridy = 0;

        GridBagConstraints gbc101 = new GridBagConstraints();
        gbc101.fill = GridBagConstraints.HORIZONTAL;
        gbc101.ipadx = -9;
        gbc101.gridx = 9;
        gbc101.gridy = 0;

        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.fill = GridBagConstraints.HORIZONTAL;
        gbc1.ipadx = 20;
        gbc1.gridx = 1;
        gbc1.gridy = 0;

        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.fill = GridBagConstraints.HORIZONTAL;
        gbc2.ipadx = 20;
        gbc2.gridx = 2;
        gbc2.gridy = 0;

        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.fill = GridBagConstraints.HORIZONTAL;
        gbc3.ipadx = 20;
        gbc3.gridx = 3;
        gbc3.gridy = 0;

        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.fill = GridBagConstraints.HORIZONTAL;
        gbc4.ipadx = 20;
        gbc4.gridx = 4;
        gbc4.gridy = 0;

        GridBagConstraints gbc5 = new GridBagConstraints();
        gbc5.fill = GridBagConstraints.HORIZONTAL;
        gbc5.ipadx = 20;
        gbc5.gridx = 5;
        gbc5.gridy = 0;

        GridBagConstraints gbc6 = new GridBagConstraints();
        gbc6.fill = GridBagConstraints.HORIZONTAL;
        gbc6.ipadx = 20;
        gbc6.gridx = 6;
        gbc6.gridy = 0;

        GridBagConstraints gbc7 = new GridBagConstraints();
        gbc7.fill = GridBagConstraints.HORIZONTAL;
        gbc7.ipadx = 20;
        gbc7.gridx = 7;
        gbc7.gridy = 0;

        GridBagConstraints gbc8 = new GridBagConstraints();
        gbc8.fill = GridBagConstraints.HORIZONTAL;
        gbc8.ipadx = 20;
        gbc8.gridx = 8;
        gbc8.gridy = 0;

        GridBagConstraints gbc9 = new GridBagConstraints();
        gbc9.fill = GridBagConstraints.HORIZONTAL;
        gbc9.ipadx = -10;
        gbc9.gridx = 0;
        gbc9.gridy = 0;

        JButton l100 = new JButton();
        l100.setIcon(new ImageIcon(getClass().getResource(REVERSE)));
        l100.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (pieceSelected.equals(WHITE)) {
                    reverseBoard(BLACK);
                    pieceSelected = BLACK;
                } else {
                    reverseBoard(WHITE);
                    pieceSelected = WHITE;
                }
            }
        });
        JButton l101 = new JButton();
        l101.setIcon(new ImageIcon(getClass().getResource(REVERSE)));
        l101.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (pieceSelected.equals(WHITE)) {
                    reverseBoard(BLACK);
                    pieceSelected = BLACK;
                } else {
                    reverseBoard(WHITE);
                    pieceSelected = WHITE;
                }
            }
        });
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

        if (straight) {
            jpN.add(l100, gbc100);
            jpN.add(l1, gbc1);
            jpN.add(l2, gbc2);
            jpN.add(l3, gbc3);
            jpN.add(l4, gbc4);
            jpN.add(l5, gbc5);
            jpN.add(l6, gbc6);
            jpN.add(l7, gbc7);
            jpN.add(l8, gbc8);
            jpN.add(l101, gbc101);
        } else {
            jpN.add(l100, gbc101);
            jpN.add(l8, gbc1);
            jpN.add(l7, gbc2);
            jpN.add(l6, gbc3);
            jpN.add(l5, gbc4);
            jpN.add(l4, gbc5);
            jpN.add(l3, gbc6);
            jpN.add(l2, gbc7);
            jpN.add(l1, gbc8);
            jpN.add(l101, gbc100);
        }

        return jpN;

    }

    public JPanel add1_8panel(Boolean straight) {

        JPanel jpN = new JPanel();
        jpN.setLayout(new GridLayout(8, 1));

        MyJToggleButtonUI l1 = new MyJToggleButtonUI("1");
        MyJToggleButtonUI l2 = new MyJToggleButtonUI("2");
        MyJToggleButtonUI l3 = new MyJToggleButtonUI("3");
        MyJToggleButtonUI l4 = new MyJToggleButtonUI("4");
        MyJToggleButtonUI l5 = new MyJToggleButtonUI("5");
        MyJToggleButtonUI l6 = new MyJToggleButtonUI("6");
        MyJToggleButtonUI l7 = new MyJToggleButtonUI("7");
        MyJToggleButtonUI l8 = new MyJToggleButtonUI("8");

        l1.setEnabled(false);
        l2.setEnabled(false);
        l3.setEnabled(false);
        l4.setEnabled(false);
        l5.setEnabled(false);
        l6.setEnabled(false);
        l7.setEnabled(false);
        l8.setEnabled(false);

        if (!straight) {
            jpN.add(l1);
            jpN.add(l2);
            jpN.add(l3);
            jpN.add(l4);
            jpN.add(l5);
            jpN.add(l6);
            jpN.add(l7);
            jpN.add(l8);
        } else {
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

    private JPanel createButPanel() {
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
        butJPanel.add(pastefen);
        butJPanel.add(savefen);
        return butJPanel;
    }

    public void setPieceUI() {
        for (int i = 0; i < jtb.length; i++) {
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
        for (int i = 48; i <= 55; i++) {
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
        for (int i = 8; i <= 15; i++) {
            jtb[i].setIcon(new ImageIcon(getClass().getResource(blackPawn)));
            jtb[i].setPiece("BP");
        }
    }

    public void chkCastlingAndEditCheckBox() {
        if ((jtb[0].getPiece().equals("BR")) && (jtb[4].getPiece().equals("BK"))) {
            //enable black queen castling
            spc.cbBlackQueenCastle.setSelected(true);
        } else {
            //disable black queen castling
            spc.cbBlackQueenCastle.setSelected(false);
        }

        if ((jtb[7].getPiece().equals("BR")) && (jtb[4].getPiece().equals("BK"))) {
            //enable black king castling
            spc.cbBlackKingCastle.setSelected(true);
        } else {
            //disable black king castling
            spc.cbBlackKingCastle.setSelected(false);
        }

        if ((jtb[56].getPiece().equals("WR")) && (jtb[60].getPiece().equals("WK"))) {
            //enable white queen castling
            spc.cbWhiteQueenCastle.setSelected(true);
        } else {
            //disable white queen castling
            spc.cbWhiteQueenCastle.setSelected(false);
        }

        if ((jtb[63].getPiece().equals("WR")) && (jtb[60].getPiece().equals("WK"))) {
            //enable white king castling
            spc.cbWhiteKingCastle.setSelected(true);
        } else {
            //disable white king castling
            spc.cbWhiteKingCastle.setSelected(false);
        }

    }

    private void reverseBoard(String col) {
        chessBoardContainer.removeAll();
        chessBoardContainer.revalidate();

        if (col.equals(BLACK)) {
            chessBoard.removeAll();
            chessBoard.revalidate();
            for (int i = 63; i >= 0; i--) {
                chessBoard.add(jtb[i]);
            }
            chessBoardContainer.add(addA_Hpanel(false), BorderLayout.PAGE_START);
            chessBoardContainer.add(addA_Hpanel(false), BorderLayout.PAGE_END);
            chessBoardContainer.add(add1_8panel(false), BorderLayout.LINE_START);
            chessBoardContainer.add(add1_8panel(false), BorderLayout.LINE_END);
        } else {
            chessBoard.removeAll();
            chessBoard.revalidate();
            for (int i = 0; i < 64; i++) {
                chessBoard.add(jtb[i]);
            }
            chessBoardContainer.add(addA_Hpanel(true), BorderLayout.PAGE_START);
            chessBoardContainer.add(addA_Hpanel(true), BorderLayout.PAGE_END);
            chessBoardContainer.add(add1_8panel(true), BorderLayout.LINE_START);
            chessBoardContainer.add(add1_8panel(true), BorderLayout.LINE_END);
        }
        chessBoard.repaint();

        chessBoardContainer.add(chessBoard, BorderLayout.CENTER);
        chessBoardContainer.repaint();

    }

    public void actionPerformed(ActionEvent e) {

        JButton j = (JButton) e.getSource();
        if (j.getText().equals("Flip")) {
            if (pieceSelected.equals(WHITE)) {
                reverseBoard(BLACK);
                pieceSelected = BLACK;
            } else {
                reverseBoard(WHITE);
                pieceSelected = WHITE;
            }
        }
        if (j.getText().equals("Cancel")) {
            this.dispose();
        }
        if (j.getText().equals("Clear")) {
            for (int i = 0; i <= 63; i++) {
                jtb[i].setIcon(null);
                jtb[i].setPiece("");
            }
            chkCastlingAndEditCheckBox();
        }
        if (j.getText().equals("Reset")) {
            setPieceUI();
            chkCastlingAndEditCheckBox();
        }
        if (j.getText().equals("Paste FEN")) {
            Object obj = JOptionPane.showInputDialog(this, " Paste the FEN in the text box below "
                    + "\n\n Please note that this version of " + APP_NAME + " cannot"
                    + "\n process the following information of FEN data"
                    + "\n 1)Enpassent 2)half move number and 3)fullmove number"
                    + "\n\n Click Ok to continue or click Cancel to abort\n ", "Please note",
                    JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (obj == null) {
                System.out.println(("CANCEL SELECTED"));
            } else {
                System.out.println(("OK SELECTED " + obj));
                validateFENData((String) obj);
            }


        }
        if (j.getText().equals("Save FEN")) {
            String str = calculateFENfromPosition();
            System.out.println(("Val is : " + str));
            String[] strs = {str};

            Object obj = JOptionPane.showInputDialog(this, " FEN generated is as shown in the text field below "
                    + "\n\n Please note that this version of " + APP_NAME + " cannot "
                    + "\n process the following information of FEN data "
                    + "\n 1)Enpassent 2)half move number and 3)fullmove number "
                    + "\n\n Hence these values are set to default, you need to modify"
                    + "\n these data manually according to your requirement "
                    + "\n\n Click Ok to save this FEN or click Cancel to abort \n ", "Please note",
                    JOptionPane.QUESTION_MESSAGE, null, null, str);
            if (obj == null) {
                System.out.println(("CANCEL SELECTED"));
            } else {
                System.out.println(("OK SELECTED " + obj));
                //TODO
                //Save the file with obj in it
            }

        }
        if (j.getText().equals("Open FEN")) {
            if (JOptionPane.showConfirmDialog(this, "Please note that this version of " + APP_NAME + " cannot"
                    + "\nprocess the following information of FEN data/file"
                    + "\n1)Enpassent 2)half move number and 3)fullmove number"
                    + "\n\nClick Ok to continue or click Cancel to abort\n ", "Please note", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                System.out.println(("OPEN FEN SELECTED"));
                //TODO
                processOpenFenButton();
            }
        }
        if (j.getText().equals("Ok")) {
            //TODO
        }
    }

    public String calculateFENfromPosition() {
        String fen;
        int b = 0;
        String s;
        String str = "";
        for (int i = 0; i <= 63; i++) {
            s = jtb[i].getPiece();
            if (s.equals("")) {
                b++;
            }
            if (s.startsWith("B")) {
                if (b != 0) {
                    str = str + b;
                    b = 0;
                }
                s = s.toLowerCase();
                str = str + s.toCharArray()[1];
            }
            if (s.startsWith("W")) {
                if (b != 0) {
                    str = str + b;
                    b = 0;
                }
                s = s.toUpperCase();
                str = str + s.toCharArray()[1];
            }

            if (((i + 1) % 8) == 0) {
                if (b != 0) {
                    str = str + b;
                    b = 0;
                }
                if (i != 63) {
                    str = str + "/";
                }
            }
        }

        //Get the active color, the one to move next
        if (spc.rbWhite.isSelected()) {
            str = str + " w ";
        } else {
            str = str + " b ";
        }

        s = "";
        //Get info abt castling
        if (spc.cbWhiteKingCastle.isSelected()) {
            s = s + "K";
        }
        if (spc.cbWhiteQueenCastle.isSelected()) {
            s = s + "Q";
        }
        if (spc.cbBlackKingCastle.isSelected()) {
            s = s + "k";
        }
        if (spc.cbBlackQueenCastle.isSelected()) {
            s = s + "q";
        }
        if (s.equals("")) {
            str = str + "-";
        } else {
            str = str + s;
        }

        //TODO
        //Currently cannot process FEN's enpassent,half move and fullmove so setting it to default
        str = str + " - 0 1";

        return str;
    }

    public void processOpenFenButton() {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.resetChoosableFileFilters();
        fileChooser.addChoosableFileFilter(new FENFileFilter());
        int choice = fileChooser.showOpenDialog(this);
        if (choice == JFileChooser.APPROVE_OPTION) {
            System.out.println((fileChooser.getSelectedFile()));
            File file = fileChooser.getSelectedFile();
            String record = "";
            try {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);

                record = new String();
                while ((record = br.readLine()) != null) {
                    record = record.trim();
                    if (record.matches("^[1-8rnbqkRNBQK].*")) {
                        System.out.println(("GOT A VALID STRING"));
                        System.out.println((record));
                        this.validateFENData(record);
                        break;
                    } else {
                        record = "";
                    }
                }
                fr.close();
                br.close();
            } catch (IOException e) {
                // catch possible io errors from readLine()
                System.out.println(("Uh oh, got an IOException error!"));
                e.printStackTrace();
            }
        }
    }

    public void validateFENData(String s) {
        //TODO
        String[] slist = s.split(" ");
        if (slist.length != 6) {
            System.out.println(("INVALID STRING " + s));
        }
        String s1 = slist[0];
        String s2 = slist[1];
        String s3 = slist[2];
        String s4 = slist[3];
        String s5 = slist[4];
        String s6 = slist[5];

        String[] s1list = s1.split("/");
        if (s1list.length != 8) {
            System.out.println(("INVALID STRING1 " + s1));
        }
        if (!(s2.matches("w|b"))) {
            System.out.println(("INVALID STRING2 " + s2));
        }
        if (!(s3.matches("[-kqKQ]+"))) {
            System.out.println(("INVALID STRING3 " + s3));
        }
        if (!(s4.matches("[-a-h1-8]+"))) {
            System.out.println(("INVALID STRING4 " + s4));
        }
        if (!(s5.matches("[0-9]+"))) {
            System.out.println(("INVALID STRING5 " + s5));
        }
        if (!(s6.matches("[0-9]+"))) {
            System.out.println(("INVALID STRING6 " + s6));
        }

        //setup pieces
        populatePositions(s1list);

        //check whose turn is it
        if (s2.matches("w")) {
            spc.rbWhite.setSelected(true);
        } else {
            spc.rbBlack.setSelected(true);
        }

        //check castling
        char[] s3list = s3.toCharArray();
        spc.cbBlackKingCastle.setSelected(false);
        spc.cbBlackQueenCastle.setSelected(false);
        spc.cbWhiteKingCastle.setSelected(false);
        spc.cbWhiteQueenCastle.setSelected(false);
        for (int i = 0; i < s3list.length; i++) {
            if (s3list[i] == 'K') {
                spc.cbWhiteKingCastle.setSelected(true);
            }
            if (s3list[i] == 'Q') {
                spc.cbWhiteQueenCastle.setSelected(true);
            }
            if (s3list[i] == 'k') {
                spc.cbBlackKingCastle.setSelected(true);
            }
            if (s3list[i] == 'q') {
                spc.cbBlackQueenCastle.setSelected(true);
            }
        }
    }

    public void populatePositions(String[] s) {
        for (int index = 0; index < 8; index++) {
            int bIndex = index * 8;
            char[] slist = s[index].toCharArray();
            for (int i = 0; i < slist.length; i++) {
                String sa = "" + slist[i];
                //System.out.println(sa);
                if (sa.matches("[0-9]")) {
                    int k = Integer.parseInt(sa);
                    for (int a = 0; a < k; a++) {
                        //set but[a] to blank
                        jtb[bIndex].setIcon(null);
                        jtb[bIndex].setPiece("");
                        bIndex++;
                    }
                } else if (sa.matches("r")) {
                    //set but(bIndex) to black rook
                    jtb[bIndex].setIcon(new ImageIcon(getClass().getResource(blackRook)));
                    jtb[bIndex].setPiece("BR");
                    bIndex++;
                } else if (sa.matches("n")) {
                    //set but(bIndex) to black knight
                    jtb[bIndex].setIcon(new ImageIcon(getClass().getResource(blackKnight)));
                    jtb[bIndex].setPiece("BN");
                    bIndex++;
                } else if (sa.matches("b")) {
                    //set but(bIndex) to black bishop
                    jtb[bIndex].setIcon(new ImageIcon(getClass().getResource(blackBishop)));
                    jtb[bIndex].setPiece("BB");
                    bIndex++;
                } else if (sa.matches("q")) {
                    //set but(bIndex) to black queen
                    jtb[bIndex].setIcon(new ImageIcon(getClass().getResource(blackQueen)));
                    jtb[bIndex].setPiece("BQ");
                    bIndex++;
                } else if (sa.matches("k")) {
                    //set but(bIndex) to black king
                    jtb[bIndex].setIcon(new ImageIcon(getClass().getResource(blackKing)));
                    jtb[bIndex].setPiece("BK");
                    bIndex++;
                } else if (sa.matches("p")) {
                    //set but(bIndex) to black pawn
                    jtb[bIndex].setIcon(new ImageIcon(getClass().getResource(blackPawn)));
                    jtb[bIndex].setPiece("BP");
                    bIndex++;
                } else if (sa.matches("R")) {
                    //set but(bIndex) to white rook
                    jtb[bIndex].setIcon(new ImageIcon(getClass().getResource(whiteRook)));
                    jtb[bIndex].setPiece("WR");
                    bIndex++;
                } else if (sa.matches("N")) {
                    //set but(bIndex) to white knight
                    jtb[bIndex].setIcon(new ImageIcon(getClass().getResource(whiteKnight)));
                    jtb[bIndex].setPiece("WN");
                    bIndex++;
                } else if (sa.matches("B")) {
                    //set but(bIndex) to white bishop
                    jtb[bIndex].setIcon(new ImageIcon(getClass().getResource(whiteBishop)));
                    jtb[bIndex].setPiece("WB");
                    bIndex++;
                } else if (sa.matches("Q")) {
                    //set but(bIndex) to white queen
                    jtb[bIndex].setIcon(new ImageIcon(getClass().getResource(whiteQueen)));
                    jtb[bIndex].setPiece("WQ");
                    bIndex++;
                } else if (sa.matches("K")) {
                    //set but(bIndex) to white king
                    jtb[bIndex].setIcon(new ImageIcon(getClass().getResource(whiteKing)));
                    jtb[bIndex].setPiece("WK");
                    bIndex++;
                } else if (sa.matches("P")) {
                    //set but(bIndex) to white pawn
                    jtb[bIndex].setIcon(new ImageIcon(getClass().getResource(whitePawn)));
                    jtb[bIndex].setPiece("WP");
                    bIndex++;
                }
            }
        }
    }
}
