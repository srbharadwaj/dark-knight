/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package srb;

import java.util.*;

/**
 * Class Name - Move
 * Description - 
 *
 * @author suhas
 */
public class Move
{
    public int moveNo;
    public String movePGNString;
    public CB cbMove;
    
    Move(int mn,String i,CB cbo)
    {
        moveNo = mn;
        movePGNString = i;
        cbMove = new CB(null);
        setMoveData(cbo);
    }

    public void setMoveData(CB cbo)
    {
        for(int i=0;i<cbo.allPieces.size();i++)
        {
            cbMove.allPieces.add(copyCPdata(  (CP) cbo.allPieces.get(i)));
        }

        for(int i=0;i<cbo.capturedPieces.size();i++)
        {
            cbMove.capturedPieces.add(copyCPdata(  (CP) cbo.capturedPieces.get(i)));
        }

        for(int i=0;i<cbo.allMoves.size();i++)
        {
            cbMove.allMoves.add(cbo.allMoves.get(i));
        }
    }

    public void getMoveData(CB cbo)
    {
        cbo.allPieces.clear();
        cbo.capturedPieces.clear();
        cbo.allMoves.clear();

        for(int i=0;i<cbMove.allPieces.size();i++)
        {
            cbo.allPieces.add(copyCPdata(  (CP) cbMove.allPieces.get(i)));
        }

        for(int i=0;i<cbMove.capturedPieces.size();i++)
        {
            cbo.capturedPieces.add(copyCPdata(  (CP) cbMove.capturedPieces.get(i)));
        }

        for(int i=0;i<cbMove.allMoves.size();i++)
        {
            cbo.allMoves.add(cbMove.allMoves.get(i));
        }
    }

    public CP copyCPdata(CP p)
    {
        CP pMove = new CP();

        pMove.cbObj = p.cbObj;
        pMove.pieceName = p.pieceName;
        pMove.pieceColor = p.pieceColor;
        pMove.initialPosition = p.initialPosition;
        pMove.currentPosition = p.currentPosition;
        pMove.captured = p.captured;
        pMove.b_currentPosition = p.b_currentPosition;

        if(p.movesDone!=null)
        {
            pMove.movesDone = new ArrayList();
            for(int k=0;k<p.movesDone.size();k++)
            {
                pMove.movesDone.add(p.movesDone.get(k));
            }
        }

        if(p.movesPossible!=null)
        {
            pMove.movesPossible = new ArrayList();
            for(int k=0;k<p.movesPossible.size();k++)
            {
                pMove.movesPossible.add(p.movesPossible.get(k));
            }
        }

        if(p.b_movesPossible!=null)
        {
            pMove.b_movesPossible = new ArrayList();
            for(int k=0;k<p.b_movesPossible.size();k++)
            {
                pMove.b_movesPossible.add(p.b_movesPossible.get(k));
            }
        }

        //System.out.println("Copied");
        return pMove;
    }

}
