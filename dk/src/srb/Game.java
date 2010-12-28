/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package srb;

import java.text.*;
import java.util.*;

/**
 * Class Name - Game
 * Description - 
 *
 * @author suhas
 */
public class Game implements CConst
{
    public ArrayList moveList = new ArrayList();
    public CB cbGame = null;
    public int gameMoveNo = 0;
    public String gameResult = "*";
    public int gameno=0;
    public String white = HUMAN;
    public String black = HUMAN;
    public String wPlayersName = "Suhas";
    public String bPlayerName = "Player"+gameno;
    public ArrayList tags = new ArrayList();
    public ArrayList allBWMoves = new ArrayList();

    public Game(CB cb,int i,boolean shouldAddTags)
    {
        cbGame = cb;
        gameno=i;
        wPlayersName = "Suhas";
        bPlayerName = "Player"+gameno;
        if(shouldAddTags)
            addTags();
        white = HUMAN;
        black = HUMAN;
    }

    public void addMove(int mn,String s)
    {
        //a new move is done after clicking prev button and taking back a move
        //hence remove the rest of the moves which was there previously
        while(true)
        {
            try {
            //moveList.removeElementAt(mn-1);
            moveList.remove(mn-1);
            } catch(IndexOutOfBoundsException e) {
                try {
                    //allBWMoves.removeElementAt(mn-1);
                    allBWMoves.remove(mn-1);
                } catch(IndexOutOfBoundsException e1) {
                    break;
                }
            }
        }
        System.out.println("MM "+s);
        System.out.println("BW "+s.split(" ")[1]);
        //allBWMoves.add(s.split(" ")[1]);
        if(s.contains("."))
            allBWMoves.add(s.split("\\.")[1].trim());
        else
            allBWMoves.add(s.trim());
        Move m = new Move(mn,s,cbGame);
        moveList.add(m);
        gameMoveNo++;
    }

    public void getMove(int mn)
    {
        //System.out.println("mn"+mn);
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
                String[] sa = s.split("~");
                if(sa[0].equals("White"))
                {
                    wPlayersName = s.split("~")[1];
                }
                else if(sa[0].equals("Black"))
                {
                    bPlayerName = s.split("~")[1];
                }
                else if(sa[0].equals("Result"))
                {
                    gameResult = s.split("~")[1];
                }
            }
        }
    }

    private void addTags() {
        if(tags.isEmpty())
        {
            DateFormat df = new SimpleDateFormat("yyyy.MM.dd");
            Date d = new Date();
            String ev = "Event~"+TITLE;
            String da = "Date~"+df.format(d);
            String wp = "White~"+wPlayersName;
            String bp = "Black~"+bPlayerName;
            String re = "Result~"+gameResult;

            tags.add(ev);
            tags.add(da);
            tags.add(wp);
            tags.add(bp);
            tags.add(re);
        }
    }
}
