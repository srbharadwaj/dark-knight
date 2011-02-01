package srb;

import java.util.*;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *  81 82 83 84 85 86 87 88
 *  71 72 73 74 75 76 77 78
 *  61 62 63 64 65 66 67 68
 *  51 52 53 54 55 56 57 58
 *  41 42 43 44 45 46 47 48
 *  31 32 33 34 35 36 37 38
 *  21 22 23 24 25 26 27 28
 *  11 12 13 14 15 16 17 18
 */
/**
 * pos/10 = 1 to 8
 * pos%10 = A to H
 */
/**
 *  A8 B8 C8 D8 E8 F8 G8 H8
 *  A7 B7 C7 D7 E7 F7 G7 H7
 *  A6 B6 C6 D6 E6 F6 G6 H6
 *  A5 B5 C5 D5 E5 F5 G5 H5
 *  A4 B4 C4 D4 E4 F4 G4 H4
 *  A3 B3 C3 D3 E3 F3 G3 H3
 *  A2 B2 C2 D2 E2 F2 G2 H2
 *  A1 B1 C1 D1 E1 F1 G1 H1
 */

/**
 *
 * @author Suhas Bharadwaj
 */
public class CB implements CConst
{
    public ArrayList allPieces = new ArrayList();
    public ArrayList capturedPieces = new ArrayList();
    public ArrayList allMoves = new ArrayList();


    /*
     * bacup -- b_cp = cp; b_mp = mp; mp.clear;
     *       -- cp=b_mp[i] ; if still chk then dont add else add to mp
     * restore -- cp = b_cp ; b_mp.clear
     *
     */
    
    public void resetCB()
    {
        allPieces.clear();
        capturedPieces.clear();
        allMoves.clear();

        createPieces();

    }

    public void createPieces()
    {
        //Second row of White pieces only pawns
        CP pWPawnA2 = new CP(this,PAWN,WHITE,21);
         allPieces.add(pWPawnA2);
        CP pWPawnB2 = new CP(this,PAWN,WHITE,22);
         allPieces.add(pWPawnB2);
        CP pWPawnC2 = new CP(this,PAWN,WHITE,23);
         allPieces.add(pWPawnC2);
        CP pWPawnD2 = new CP(this,PAWN,WHITE,24);
         allPieces.add(pWPawnD2);
        CP pWPawnE2 = new CP(this,PAWN,WHITE,25);
         allPieces.add(pWPawnE2);
        CP pWPawnF2 = new CP(this,PAWN,WHITE,26);
         allPieces.add(pWPawnF2);
        CP pWPawnG2 = new CP(this,PAWN,WHITE,27);
         allPieces.add(pWPawnG2);
        CP pWPawnH2 = new CP(this,PAWN,WHITE,28);
         allPieces.add(pWPawnH2);


        //First row of White pieces
        CP pWRookA1 = new CP(this,ROOK,WHITE,11);
         allPieces.add(pWRookA1);
        CP pWKnightB1 = new CP(this,KNIGHT,WHITE,12);
         allPieces.add(pWKnightB1);
        CP pWBishopC1 = new CP(this,BISHOP,WHITE,13);
         allPieces.add(pWBishopC1);
        CP pWQueenD1 = new CP(this,QUEEN,WHITE,14);
         allPieces.add(pWQueenD1);
        CP pWKingE1 = new CP(this,KING,WHITE,15);
         allPieces.add(pWKingE1);
        CP pWBishopF1 = new CP(this,BISHOP,WHITE,16);
         allPieces.add(pWBishopF1);
        CP pWKnightG1 = new CP(this,KNIGHT,WHITE,17);
         allPieces.add(pWKnightG1);
        CP pWRookH1 = new CP(this,ROOK,WHITE,18);
         allPieces.add(pWRookH1);

        //Second row of BLACK pieces only pawns
        CP pBPawnA7 = new CP(this,PAWN,BLACK,71);
         allPieces.add(pBPawnA7);
        CP pBPawnB7 = new CP(this,PAWN,BLACK,72);
         allPieces.add(pBPawnB7);
        CP pBPawnC7 = new CP(this,PAWN,BLACK,73);
         allPieces.add(pBPawnC7);
        CP pBPawnD7 = new CP(this,PAWN,BLACK,74);
         allPieces.add(pBPawnD7);
        CP pBPawnE7 = new CP(this,PAWN,BLACK,75);
         allPieces.add(pBPawnE7);
        CP pBPawnF7 = new CP(this,PAWN,BLACK,76);
         allPieces.add(pBPawnF7);
        CP pBPawnG7 = new CP(this,PAWN,BLACK,77);
         allPieces.add(pBPawnG7);
        CP pBPawnH7 = new CP(this,PAWN,BLACK,78);
         allPieces.add(pBPawnH7);


        //First row of BLACK pieces
        CP pBRookA8 = new CP(this,ROOK,BLACK,81);
         allPieces.add(pBRookA8);
        CP pBKnightB8 = new CP(this,KNIGHT,BLACK,82);
         allPieces.add(pBKnightB8);
        CP pBBishopC8 = new CP(this,BISHOP,BLACK,83);
         allPieces.add(pBBishopC8);
        CP pBQueenD8 = new CP(this,QUEEN,BLACK,84);
         allPieces.add(pBQueenD8);
        CP pBKingE8 = new CP(this,KING,BLACK,85);
         allPieces.add(pBKingE8);
        CP pBBishopF8 = new CP(this,BISHOP,BLACK,86);
         allPieces.add(pBBishopF8);
        CP pBKnightG8 = new CP(this,KNIGHT,BLACK,87);
         allPieces.add(pBKnightG8);
        CP pBRookH8 = new CP(this,ROOK,BLACK,88);
         allPieces.add(pBRookH8);

    }

    public CB()
    {
        resetCB();
    }

    public CB(String s)
    {
        allPieces.clear();
        capturedPieces.clear();
        allMoves.clear();
    }

    public void printAll()
    {

        System.out.println(("***********************"));
        for(int i=0;i<allPieces.size();i++)
        {
            CP c = (CP) allPieces.get(i);
            System.out.println(("Piece : " + c.getPieceName()));
            System.out.println(("Color : " + c.getPieceColor()));
            System.out.println(("IniPos: " + c.getInitialPosition()));
            System.out.println(("CurPos: " + c.getCurrentPosition()));
            String s = "";
            for(int j=0;j<c.movesPossible.size();j++)
            {
                s=s + "," + c.movesPossible.get(j);
            }
            System.out.println(("MovPos: " + s));
            System.out.println(("--------------------------------"));
        }
    }

     //Will be called to chk if piece is captured
    public CP isCurPosOfSomePiece(int newpos)
    {
        for(int i=0;i<allPieces.size();i++)
        {
            CP p1 = (CP) allPieces.get(i);
            if(p1.getCurrentPosition()==newpos)
            {
                //yes piece is captured
                //System.out.println("Captured at" + newpos);
                //System.out.println("Captured at" + p1);
                return p1;
            }
        }
        //System.out.println("Captured at null");
        return null;
    }

    public void calculateAllPossibleMoves1(String col,int newpos)
    {
        for(int i=0;i<allPieces.size();i++)
        {
            CP c = (CP) allPieces.get(i);
            if(col.equals(c.getPieceColor()))
            {
                if(c.getCurrentPosition()!=newpos)
                {
                    String  pName = c.getPieceName();
                    
                    if(pName.equals(PAWN))
                    {
                        c.calculatePossibleMovesForPawn();
                    }
                    if(pName.equals(ROOK))
                    {
                        c.calculatePossibleMovesForRook();
                    }
                    if(pName.equals(KNIGHT))
                    {
                        c.calculatePossibleMovesForKnight();
                    }
                    if(pName.equals(BISHOP))
                    {
                        c.calculatePossibleMovesForBishop();
                    }
                    if(pName.equals(QUEEN))
                    {
                        c.calculatePossibleMovesForQueen();
                    }
                    if(pName.equals(KING))
                    {
                        c.calculatePossibleMovesForKing();
                    }
                }
                else
                {
                    c.movesPossible.clear();
                }
            }
        }
    }


    /*
     * Example :
     *
     * turn - white
        calpos for all white
        bacup posmov for all white
        clear posmov for all white
        for each white piece
            for each white's buposmoves
                bacup white currpos
                bacup black's posmov
                set curpos as white's bacposmoves

                calpos for all black
                if white is not in chk
                    add to white's curr pos to movposs

                restore white currpos
                restore black's posmov

     *
     *
     */
    public void calculateMoves(String col)
    {
        String oppCol;
        if(col.equals(WHITE))
            oppCol = BLACK;
        else
            oppCol = WHITE;

        calculateAllPossibleMoves1(oppCol,0);
        calculateAllPossibleMoves1(col,0);
        backupPossibleMovesForAllPieces(col);
        for(int i=0;i<allPieces.size();i++)
        {
            CP c = (CP) allPieces.get(i);
            if(col.equals(c.getPieceColor()))
            {
                for(int j=0;j<c.b_movesPossible.size();j++)
                {
                    c.backupCurrentPosition();
                    backupPossibleMovesForAllPieces(oppCol);
                    int newCurrPos = Integer.parseInt(c.b_movesPossible.get(j).toString());
                    c.setCurrentPosition(newCurrPos);
                    calculateAllPossibleMoves1(oppCol,newCurrPos);
                    if(!(isKingInCheck(col)))
                    {
                        c.movesPossible.add(newCurrPos);
                    }
                    c.restoreCurrentPosition();
                    restorePossibleMovesForAllPieces(oppCol);
                }
            }
        }
        aBugFixForCalculateKingPos(col); //Check the proc for more details
    }
    
    //If king's possible pos and opposite col's knight's possible moves coincide
    //then king was able to mov into knight's area
    //could'nt find root cause for bug so added this proc as workaround
    public void aBugFixForCalculateKingPos(String col)
    {
        ArrayList kingV = new ArrayList();
        ArrayList knightV = new ArrayList();
        String oppCol;
        CP kingcp =null;
        
        if(col.equals(WHITE))
            oppCol = BLACK;
        else
            oppCol = WHITE;

        for(int i=0;i<allPieces.size();i++)
        {
            //find the current pos of col king
            //get all the moves for tht king
            //is oppcol knight controls that pos?
            //if yes then remove that element from
            CP p = (CP) allPieces.get(i);
            if((p.getPieceName().equals(KING)) && (p.getPieceColor().equals(col)))
            {
                kingcp = p;
                System.out.println((p.getPieceColor() +" KING found at "+p.getCurrentPosition()));
                kingV.add(p.getCurrentPosition() + 9);
                kingV.add(p.getCurrentPosition() + 10);
                kingV.add(p.getCurrentPosition() + 11);
                kingV.add(p.getCurrentPosition() - 9);
                kingV.add(p.getCurrentPosition() - 10);
                kingV.add(p.getCurrentPosition() - 11);
                kingV.add(p.getCurrentPosition() + 1);
                kingV.add(p.getCurrentPosition() - 1);
            }
            if((p.getPieceName().equals(KNIGHT)) && (p.getPieceColor().equals(oppCol)))
            {
                System.out.println((p.getPieceColor() +" KNIGHT found at "+p.getCurrentPosition()));
                knightV.add(p.getCurrentPosition() + 8);
                knightV.add(p.getCurrentPosition() + 12);
                knightV.add(p.getCurrentPosition() + 19);
                knightV.add(p.getCurrentPosition() + 21);
                knightV.add(p.getCurrentPosition() - 8);
                knightV.add(p.getCurrentPosition() - 12);
                knightV.add(p.getCurrentPosition() - 19);
                knightV.add(p.getCurrentPosition() - 21);
            }
        }

        for(int i=0;i<knightV.size();i++)
        {
            if(kingV.contains(knightV.get(i)))
            {
                System.out.println((knightV.get(i)+"is being removed"));
                //kingcp.movesPossible.removeElement(knightV.get(i));
                kingcp.movesPossible.remove(knightV.get(i));
            }
        }
    }

    public void backupPossibleMovesForAllPieces(String col)
    {
        for(int i=0;i<allPieces.size();i++)
        {
            CP c = (CP) allPieces.get(i);
            if(col.equals(c.getPieceColor()))
            {
                c.backupPossibleMoves();
                c.movesPossible.clear();
            }
        }
    }

    public void restorePossibleMovesForAllPieces(String col)
    {
        for(int i=0;i<allPieces.size();i++)
        {
            CP c = (CP) allPieces.get(i);
            if(col.equals(c.getPieceColor()))
            {
                c.restorePossibleMoves();
            }
        }
    }

    public boolean isKingInCheck(String kingCol)
    {
        int pos=0;
        for(int k=0;k<allPieces.size();k++)
        {
            CP p1 = (CP) allPieces.get(k);
            if((p1.getPieceName().equals(KING))&& p1.getPieceColor().equals(kingCol))
            {
                pos = p1.getCurrentPosition();
            }
        }

        for(int k=0;k<allPieces.size();k++)
        {
            CP p1 = (CP) allPieces.get(k);
            if(!p1.getPieceColor().equals(kingCol))
            {
                if(p1.movesPossible.contains(pos))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public void calculateIfCastlingIsPossible()
    {
        CP wQR = null,wKR= null,wK = null,bQR= null,bKR= null,bK= null;
        for(int i=0;i<allPieces.size();i++)
        {
            CP c = (CP) allPieces.get(i);
            //white
            if((c.getPieceColor().equals(WHITE)) && (c.getPieceName().equals(ROOK)) && (c.getInitialPosition()==11))
            {
                wQR = c;
            }
            if((c.getPieceColor().equals(WHITE)) && (c.getPieceName().equals(ROOK)) && (c.getInitialPosition()==18))
            {
                wKR = c;
            }
            if((c.getPieceColor().equals(WHITE)) && (c.getPieceName().equals(KING)))
            {
                wK = c;
            }

            //black
            if((c.getPieceColor().equals(BLACK)) && (c.getPieceName().equals(ROOK)) && (c.getInitialPosition()==81))
            {
                bQR = c;
            }
            if((c.getPieceColor().equals(BLACK)) && (c.getPieceName().equals(ROOK)) && (c.getInitialPosition()==88))
            {
                bKR = c;
            }
            if((c.getPieceColor().equals(BLACK)) && (c.getPieceName().equals(KING)))
            {
                bK = c;
            }
        }

       
        //white
        if((wQR != null) && (wK!=null))
        {
            if((wQR.movesDone.isEmpty()) && (wK.movesDone.isEmpty()))
            {
                //12,13,14 goes thru then
                //0-0-0 possible
                if((!wQR.isAnyPiecePresent(12)) && (!wQR.isAnyPiecePresent(13)) && (!wQR.isAnyPiecePresent(14)))
                {
                    if(!isKingAttackedAt(WHITE,13))
                    {
                        if(!isKingAttackedAt(WHITE,14))
                        {
                            //add
                            System.out.println(("White Queen side castling possible"));
                            wK.movesPossible.add(13);
                        }
                    }
                }
            }
        }
        if((wKR !=null)&&(wK!=null))
        {
            if((wKR.movesDone.isEmpty()) && (wK.movesDone.isEmpty()))
            {
                //16,17  goes thru then
                //0-0 possible
                if((!wKR.isAnyPiecePresent(16)) && (!wKR.isAnyPiecePresent(17)))
                {
                    if(!isKingAttackedAt(WHITE,16))
                    {
                        if(!isKingAttackedAt(WHITE,17))
                        {
                            //add
                            System.out.println(("White King side castling possible"));
                            wK.movesPossible.add(17);
                        }
                    }
                }
            }
        }

        //black
        if((bQR !=null)&&(bK!=null))
        {
            if((bQR.movesDone.isEmpty()) && (bK.movesDone.isEmpty()))
            {
                //82,83,84 goes thru then
                //0-0-0 possible
                if((!bQR.isAnyPiecePresent(82)) && (!bQR.isAnyPiecePresent(83)) && (!bQR.isAnyPiecePresent(84)))
                {
                    if(!isKingAttackedAt(BLACK,83))
                    {
                        if(!isKingAttackedAt(BLACK,84))
                        {
                            //add
                            System.out.println(("Black Queen side castling possible"));
                            bK.movesPossible.add(83);
                        }
                    }
                }
            }
        }
        if((bKR !=null)&&(bK!=null))
        {
            if((bKR.movesDone.isEmpty()) && (bK.movesDone.isEmpty()))
            {
                //86,87 goes thru then
                //0-0 possible
                if((!bKR.isAnyPiecePresent(86)) && (!bKR.isAnyPiecePresent(87)))
                {
                    if(!isKingAttackedAt(BLACK,86))
                    {
                        if(!isKingAttackedAt(BLACK,87))
                        {
                            //add
                            System.out.println(("Black King side castling possible"));
                            bK.movesPossible.add(87);
                        }
                    }
                }
            }
        }
    }

    private boolean isKingAttackedAt(String kingCol, int pos)
    {
        for(int k=0;k<allPieces.size();k++)
        {
            CP p = (CP) allPieces.get(k);
            if(!p.getPieceColor().equals(kingCol))
            {
                if(p.movesPossible.contains(pos))
                {
                    return true;
                }
            }
        }

        return false;
    }

    public int getLatestMove()
    {
        int s = allMoves.size();
        if(s==0)
            return -1;
        else
        {
            Object i = allMoves.get(s-1);
            String s1 = i.toString();
            return (Integer.parseInt(s1));
        }
    }

}
