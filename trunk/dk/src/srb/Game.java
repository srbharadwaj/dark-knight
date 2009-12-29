/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package srb;

import java.util.Vector;

/**
 * Class Name - Game
 * Description - 
 *
 * @author suhas
 */
public class Game
{
    public Vector moveList = new Vector();
    public CB cbGame = null;
    public int gameMoveNo = 0;
    public String gameResult = "*";
    public int gameno=0;
    public String wPlayer = "Suhas";
    public String bPlayer = "Player"+gameno;
    public Vector tags = new Vector();
    public Vector allBWMoves = new Vector();

    public Game(CB cb,int i)
    {
        cbGame = cb;
        gameno=i;
        wPlayer = "Suhas";
        bPlayer = "Player"+gameno;
    }

    public void addMove(int mn,String s)
    {
        //a new move is done after clicking prev button and taking back a move
        //hence remove the rest of the moves which was there previously
        while(true)
        {
            try {
            moveList.removeElementAt(mn-1);
            } catch(ArrayIndexOutOfBoundsException e) {
                try {
                    allBWMoves.removeElementAt(mn-1);
                } catch(ArrayIndexOutOfBoundsException e1) {
                    break;
                }
            }
        }
        System.out.println("MM "+s);
        System.out.println("BW "+s.split(" ")[1]);
        allBWMoves.add(s.split(" ")[1]);
        Move m = new Move(mn,s,cbGame);
        moveList.add(m);
        gameMoveNo++;
    }

    public void getMove(int mn)
    {
        System.out.println("mn"+mn);
        Move m = (Move) moveList.get(mn-1);
        m.getMoveData(cbGame);
    }

    public void setGameResult(String res)
    {
        gameResult = res;
        Move m = (Move) moveList.get(moveList.size()-1);
        if(m.moveNo%2==0)
        {
            m.movePGNString = m.movePGNString+"\n"+res;
        }
        else
        {
            m.movePGNString = m.movePGNString+" "+res;
        }
    }

    public void updateGame()
    {
        if(tags.size()>0)
        {
            for(int i=0;i<tags.size();i++)
            {
                String s = (String) tags.get(i);
                String[] sa = s.split(":");
                if(sa[0].equals("White"))
                {
                    wPlayer = s.split(":")[1];
                }
                else if(sa[0].equals("Black"))
                {
                    bPlayer = s.split(":")[1];
                }
                else if(sa[0].equals("Result"))
                {
                    gameResult = s.split(":")[1];
                }
            }
        }
    }

}
