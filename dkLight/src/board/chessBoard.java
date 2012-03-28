package board;

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
public class chessBoard implements chessConstants {

    public ArrayList allPieces = new ArrayList();
    public ArrayList capturedPieces = new ArrayList();
    public ArrayList allMoves = new ArrayList();
    public ArrayList allFENMoves = new ArrayList();
    public ArrayList allPGNMoves = new ArrayList();
    public String castle = "kqKQ"; //
    public int totalHalfMoves = 0;
    public int totalHalfMovesWithNoPawn = 0;
    public int currentMoveNumber = 0;
    public String whoseTurn = WHITE;
    public int enPassentPosition = -1;

    //changeTurn();
    //incrTotalHalfMoves(); set currentmove as well
    //whoseTurnIsIt();
    //getTotalMoves();
    //getTotalHalfMoves();
    //getEnPassentPosition();

    /*
     * bacup -- b_cp = chessPiece; b_mp = mp; mp.clear;
     *       -- chessPiece=b_mp[i] ; if still chk then dont add else add to mp
     * restore -- chessPiece = b_cp ; b_mp.clear
     *
     */

    public void incrCurrMoveNum() {
        currentMoveNumber++;
    }
    public void decCurrMoveNum() {
        currentMoveNumber--;
    }
    public chessPiece getLastCapturedPiece()
    {
        return (chessPiece) (capturedPieces.get(capturedPieces.size()-1));
    }
    public int getEnPassentPosition() {
        return enPassentPosition;
    }
    public void incrTotalHalfMoves()
    {
        totalHalfMoves++;
        //currentMoveNumber = totalHalfMoves/2;
    }
    public int getTotalHalfMoves()
    {
        return totalHalfMoves;
    }
    public int getTotalMoves()
    {
        return (totalHalfMoves/2);
    }
    public String whoseTurnIsIt()
    {
        return whoseTurn;
    }

    public void changeTurn()
    {
         //change 'whoseturn'
        if (whoseTurn.equals(WHITE)) {
            whoseTurn = BLACK;
        } else {
            whoseTurn = WHITE;
        }
    }

    public chessBoard() {
        resetCB();
    }

   
    public void validateFEN(String s)
    {
        String[] slist = s.split(" ");
        if(slist.length!=6)
            System.out.println("INVALID STRING "+s);
        String s1 = slist[0];
        String s2 = slist[1];
        String s3 = slist[2];
        String s4 = slist[3];
        String s5 = slist[4];
        String s6 = slist[5];

        String[] s1list = s1.split("/");
        if(s1list.length!=8)
            System.out.println("INVALID STRING1 "+s1);
        if(!(s2.matches("w|b")))
            System.out.println("INVALID STRING2 "+s2);
        if(!(s3.matches("[-kqKQ]+")))
            System.out.println("INVALID STRING3 "+s3);
        if(!(s4.matches("[-a-h1-8]+")))
            System.out.println("INVALID STRING3 "+s4);
        if(!(s5.matches("[0-9]+")))
            System.out.println("INVALID STRING3 "+s5);
        if(!(s6.matches("[0-9]+")))
            System.out.println("INVALID STRING3 "+s6);

        populatePositions(s1list);

        if(s2.equals("w"))
            whoseTurn = WHITE;
        else
            whoseTurn = BLACK;
        this.castle = s3;
        if(s4.equals("-"))
            this.enPassentPosition = -1;
        else
            this.enPassentPosition = convertNumRowToNumVal(s4.toCharArray()[1]) + convertAlphaColToNumVal(s4.toCharArray()[0]);
        if(s5.equals("-"))
            this.totalHalfMovesWithNoPawn = 0;
        else
            this.totalHalfMovesWithNoPawn = Integer.parseInt(s5);
        this.totalHalfMoves = Integer.parseInt(s6)*2;
    }

    public void populatePositions(String[] s)
    {
        for(int index=0;index<8;index++)
        {
            int val=0;
            switch (index)
            {
                case 0: val=81; break;
                case 1: val=71; break;
                case 2: val=61; break;
                case 3: val=51; break;
                case 4: val=41; break;
                case 5: val=31; break;
                case 6: val=21; break;
                case 7: val=11; break;

            }
            // rnbqkbnr/pppppppp/8/8/4P3/8/PPPP1PPP/RNBQKBNR
            char[] slist = s[index].toCharArray();
            for(int j=0;j<slist.length;j++)
            {
                chessPiece cp = null;
                switch (slist[j])
                {
                    case '1': val = val+1;break;
                    case '2': val = val+2;break;
                    case '3': val = val+3;break;
                    case '4': val = val+4;break;
                    case '5': val = val+5;break;
                    case '6': val = val+6;break;
                    case '7': val = val+7;break;
                    case '8': val = val+8;break;
                    case 'p': cp = new chessPiece(this, PAWN, BLACK, val, val);val++;allPieces.add(cp);break;
                    case 'r': cp = new chessPiece(this, ROOK, BLACK, val, val);val++;allPieces.add(cp);break;
                    case 'n': cp = new chessPiece(this, KNIGHT, BLACK, val, val);val++;allPieces.add(cp);break;
                    case 'b': cp = new chessPiece(this, BISHOP, BLACK, val, val);val++;allPieces.add(cp);break;
                    case 'q': cp = new chessPiece(this, QUEEN, BLACK, val, val);val++;allPieces.add(cp);break;
                    case 'k': cp = new chessPiece(this, KING, BLACK, val, val);val++;allPieces.add(cp);break;
                    case 'P': cp = new chessPiece(this, PAWN, WHITE, val, val);val++;allPieces.add(cp);break;
                    case 'R': cp = new chessPiece(this, ROOK, WHITE, val, val);val++;allPieces.add(cp);break;
                    case 'N': cp = new chessPiece(this, KNIGHT, WHITE, val, val);val++;allPieces.add(cp);break;
                    case 'B': cp = new chessPiece(this, BISHOP, WHITE, val, val);val++;allPieces.add(cp);break;
                    case 'Q': cp = new chessPiece(this, QUEEN, WHITE, val, val);val++;allPieces.add(cp);break;
                    case 'K': cp = new chessPiece(this, KING, WHITE, val, val);val++;allPieces.add(cp);break;
                }
            }
        }
    }

     public int convertAlphaColToNumVal(char c) {
        if (c == 'a') {
            return 1;
        } else if (c == 'b') {
            return 2;
        } else if (c == 'c') {
            return 3;
        } else if (c == 'd') {
            return 4;
        } else if (c == 'e') {
            return 5;
        } else if (c == 'f') {
            return 6;
        } else if (c == 'g') {
            return 7;
        } else if (c == 'h') {
            return 8;
        } else {
            return -1;
        }
    }

      public int convertNumRowToNumVal(char c) {

        if (c == '1') {
            return 10;
        } else if (c == '2') {
            return 20;
        } else if (c == '3') {
            return 30;
        } else if (c == '4') {
            return 40;
        } else if (c == '5') {
            return 50;
        } else if (c == '6') {
            return 60;
        } else if (c == '7') {
            return 70;
        } else if (c == '8') {
            return 80;
        } else {
            return -1;
        }
    }

    public void resetCB() {
        allPieces.clear();
        capturedPieces.clear();
        allMoves.clear();
        allFENMoves.clear();
        allPGNMoves.clear();

        allFENMoves.add("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
        allPGNMoves.add("new");
        createPieces();

    }

    public void resetCB(String fen) {
        allPieces.clear();
        capturedPieces.clear();
        allMoves.clear();

        validateFEN(fen);
    }

    public void createPieces() {
        //Second row of White pieces only pawns
        chessPiece pWPawnA2 = new chessPiece(this, PAWN, WHITE, 21,21);
        allPieces.add(pWPawnA2);
        chessPiece pWPawnB2 = new chessPiece(this, PAWN, WHITE, 22,22);
        allPieces.add(pWPawnB2);
        chessPiece pWPawnC2 = new chessPiece(this, PAWN, WHITE, 23,23);
        allPieces.add(pWPawnC2);
        chessPiece pWPawnD2 = new chessPiece(this, PAWN, WHITE, 24,24);
        allPieces.add(pWPawnD2);
        chessPiece pWPawnE2 = new chessPiece(this, PAWN, WHITE, 25,25);
        allPieces.add(pWPawnE2);
        chessPiece pWPawnF2 = new chessPiece(this, PAWN, WHITE, 26,26);
        allPieces.add(pWPawnF2);
        chessPiece pWPawnG2 = new chessPiece(this, PAWN, WHITE, 27,27);
        allPieces.add(pWPawnG2);
        chessPiece pWPawnH2 = new chessPiece(this, PAWN, WHITE, 28,28);
        allPieces.add(pWPawnH2);


        //First row of White pieces
        chessPiece pWRookA1 = new chessPiece(this, ROOK, WHITE, 11,11);
        allPieces.add(pWRookA1);
        chessPiece pWKnightB1 = new chessPiece(this, KNIGHT, WHITE, 12,12);
        allPieces.add(pWKnightB1);
        chessPiece pWBishopC1 = new chessPiece(this, BISHOP, WHITE, 13,13);
        allPieces.add(pWBishopC1);
        chessPiece pWQueenD1 = new chessPiece(this, QUEEN, WHITE, 14,14);
        allPieces.add(pWQueenD1);
        chessPiece pWKingE1 = new chessPiece(this, KING, WHITE, 15,15);
        allPieces.add(pWKingE1);
        chessPiece pWBishopF1 = new chessPiece(this, BISHOP, WHITE, 16,16);
        allPieces.add(pWBishopF1);
        chessPiece pWKnightG1 = new chessPiece(this, KNIGHT, WHITE, 17,17);
        allPieces.add(pWKnightG1);
        chessPiece pWRookH1 = new chessPiece(this, ROOK, WHITE, 18,18);
        allPieces.add(pWRookH1);

        //Second row of BLACK pieces only pawns
        chessPiece pBPawnA7 = new chessPiece(this, PAWN, BLACK, 71,71);
        allPieces.add(pBPawnA7);
        chessPiece pBPawnB7 = new chessPiece(this, PAWN, BLACK, 72,72);
        allPieces.add(pBPawnB7);
        chessPiece pBPawnC7 = new chessPiece(this, PAWN, BLACK, 73,73);
        allPieces.add(pBPawnC7);
        chessPiece pBPawnD7 = new chessPiece(this, PAWN, BLACK, 74,74);
        allPieces.add(pBPawnD7);
        chessPiece pBPawnE7 = new chessPiece(this, PAWN, BLACK, 75,75);
        allPieces.add(pBPawnE7);
        chessPiece pBPawnF7 = new chessPiece(this, PAWN, BLACK, 76,76);
        allPieces.add(pBPawnF7);
        chessPiece pBPawnG7 = new chessPiece(this, PAWN, BLACK, 77,77);
        allPieces.add(pBPawnG7);
        chessPiece pBPawnH7 = new chessPiece(this, PAWN, BLACK, 78,78);
        allPieces.add(pBPawnH7);


        //First row of BLACK pieces
        chessPiece pBRookA8 = new chessPiece(this, ROOK, BLACK, 81,81);
        allPieces.add(pBRookA8);
        chessPiece pBKnightB8 = new chessPiece(this, KNIGHT, BLACK, 82,82);
        allPieces.add(pBKnightB8);
        chessPiece pBBishopC8 = new chessPiece(this, BISHOP, BLACK, 83,83);
        allPieces.add(pBBishopC8);
        chessPiece pBQueenD8 = new chessPiece(this, QUEEN, BLACK, 84,84);
        allPieces.add(pBQueenD8);
        chessPiece pBKingE8 = new chessPiece(this, KING, BLACK, 85,85);
        allPieces.add(pBKingE8);
        chessPiece pBBishopF8 = new chessPiece(this, BISHOP, BLACK, 86,86);
        allPieces.add(pBBishopF8);
        chessPiece pBKnightG8 = new chessPiece(this, KNIGHT, BLACK, 87,87);
        allPieces.add(pBKnightG8);
        chessPiece pBRookH8 = new chessPiece(this, ROOK, BLACK, 88,88);
        allPieces.add(pBRookH8);

    }

    public void printAll() {

        System.out.println("***********************");
        for (int i = 0; i < allPieces.size(); i++) {
            chessPiece c = (chessPiece) allPieces.get(i);
            System.out.println("Piece : " + c.getPieceName());
            System.out.println("Color : " + c.getPieceColor());
            System.out.println("IniPos: " + c.getInitialPosition());
            System.out.println("CurPos: " + c.getCurrentPosition());
            String s = "";
            for (int j = 0; j < c.movesPossible.size(); j++) {
                s = s + "," + c.movesPossible.get(j);
            }
            System.out.println("MovPos: " + s);
            System.out.println("--------------------------------");
        }
    }

    //Will be called to chk if piece is captured
    public chessPiece isCurPosOfSomePiece(int newpos) {
        for (int i = 0; i < allPieces.size(); i++) {
            chessPiece p1 = (chessPiece) allPieces.get(i);
            if (p1.getCurrentPosition() == newpos) {
                //yes piece is captured
                //System.out.println("Captured at" + newpos);
                //System.out.println("Captured at" + p1);
                return p1;
            }
        }
        //System.out.println("Captured at null");
        return null;
    }

    public void calculateAllPossibleMoves1(String col, int newpos) {
        for (int i = 0; i < allPieces.size(); i++) {
            chessPiece c = (chessPiece) allPieces.get(i);
            if (col.equals(c.getPieceColor())) {
                if (c.getCurrentPosition() != newpos) {
                    String pName = c.getPieceName();

                    if (pName.equals(PAWN)) {
                        c.calculatePossibleMovesForPawn();
                    }
                    if (pName.equals(ROOK)) {
                        c.calculatePossibleMovesForRook();
                    }
                    if (pName.equals(KNIGHT)) {
                        c.calculatePossibleMovesForKnight();
                    }
                    if (pName.equals(BISHOP)) {
                        c.calculatePossibleMovesForBishop();
                    }
                    if (pName.equals(QUEEN)) {
                        c.calculatePossibleMovesForQueen();
                    }
                    if (pName.equals(KING)) {
                        c.calculatePossibleMovesForKing();
                    }
                } else {
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
    public void calculateMoves(String col) {
        String oppCol;
        if (col.equals(WHITE)) {
            oppCol = BLACK;  
        } else {
            oppCol = WHITE;
        }

        calculateAllPossibleMoves1(oppCol, 0);
        calculateAllPossibleMoves1(col, 0);
        backupPossibleMovesForAllPieces(col);
        for (int i = 0; i < allPieces.size(); i++) {
            chessPiece c = (chessPiece) allPieces.get(i);
            if (col.equals(c.getPieceColor())) {
                for (int j = 0; j < c.b_movesPossible.size(); j++) {
                    c.backupCurrentPosition();
                    backupPossibleMovesForAllPieces(oppCol);
                    int newCurrPos = Integer.parseInt(c.b_movesPossible.get(j).toString());
                    c.setCurrentPosition(newCurrPos);
                    calculateAllPossibleMoves1(oppCol, newCurrPos);
                    if (!(isKingInCheck(col))) {
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
    public void aBugFixForCalculateKingPos(String col) {
        ArrayList kingV = new ArrayList();
        ArrayList knightV = new ArrayList();
        String oppCol;
        chessPiece kingcp = null;

        if (col.equals(WHITE)) {
            oppCol = BLACK;
            
        } else {
            oppCol = WHITE;


        }
        for (int i = 0; i < allPieces.size(); i++) {
            //find the current pos of col king
            //get all the moves for tht king
            //is oppcol knight controls that pos?
            //if yes then remove that element from
            chessPiece p = (chessPiece) allPieces.get(i);
            if ((p.getPieceName().equals(KING)) && (p.getPieceColor().equals(col))) {
                kingcp = p;
                System.out.println(p.getPieceColor() + " KING found at " + p.getCurrentPosition());
                kingV.add(p.getCurrentPosition() + 9);
                kingV.add(p.getCurrentPosition() + 10);
                kingV.add(p.getCurrentPosition() + 11);
                kingV.add(p.getCurrentPosition() - 9);
                kingV.add(p.getCurrentPosition() - 10);
                kingV.add(p.getCurrentPosition() - 11);
                kingV.add(p.getCurrentPosition() + 1);
                kingV.add(p.getCurrentPosition() - 1);
            }
            if ((p.getPieceName().equals(KNIGHT)) && (p.getPieceColor().equals(oppCol))) {
                System.out.println(p.getPieceColor() + " KNIGHT found at " + p.getCurrentPosition());
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

        for (int i = 0; i < knightV.size(); i++) {
            if (kingV.contains(knightV.get(i))) {
                System.out.println(knightV.get(i) + "is being removed");
                //kingcp.movesPossible.removeElement(knightV.get(i));
                kingcp.movesPossible.remove(knightV.get(i));
            }
        }
    }

    public void backupPossibleMovesForAllPieces(String col) {
        for (int i = 0; i < allPieces.size(); i++) {
            chessPiece c = (chessPiece) allPieces.get(i);
            if (col.equals(c.getPieceColor())) {
                c.backupPossibleMoves();
                c.movesPossible.clear();
            }
        }
    }

    public void restorePossibleMovesForAllPieces(String col) {
        for (int i = 0; i < allPieces.size(); i++) {
            chessPiece c = (chessPiece) allPieces.get(i);
            if (col.equals(c.getPieceColor())) {
                c.restorePossibleMoves();
            }
        }
    }

    public boolean isKingInCheck(String kingCol) {
        int pos = 0;
        for (int k = 0; k < allPieces.size(); k++) {
            chessPiece p1 = (chessPiece) allPieces.get(k);
            if ((p1.getPieceName().equals(KING)) && p1.getPieceColor().equals(kingCol)) {
                pos = p1.getCurrentPosition();
            }
        }

        for (int k = 0; k < allPieces.size(); k++) {
            chessPiece p1 = (chessPiece) allPieces.get(k);
            if (!p1.getPieceColor().equals(kingCol)) {
                if (p1.movesPossible.contains(pos)) {
                    return true;
                }
            }
        }
        return false;
    }

     public String calculateCastlingStringForFEN() {
        chessPiece wQR = null, wKR = null, wK = null, bQR = null, bKR = null, bK = null;
        String noCastling = "-";
        String castling = "";
        for (int i = 0; i < allPieces.size(); i++) {
            chessPiece c = (chessPiece) allPieces.get(i);
            //white
            if ((c.getPieceColor().equals(WHITE)) && (c.getPieceName().equals(ROOK)) && (c.getInitialPosition() == 11)) {
                wQR = c;
            }
            if ((c.getPieceColor().equals(WHITE)) && (c.getPieceName().equals(ROOK)) && (c.getInitialPosition() == 18)) {
                wKR = c;
            }
            if ((c.getPieceColor().equals(WHITE)) && (c.getPieceName().equals(KING))) {
                wK = c;
            }

            //black
            if ((c.getPieceColor().equals(BLACK)) && (c.getPieceName().equals(ROOK)) && (c.getInitialPosition() == 81)) {
                bQR = c;
            }
            if ((c.getPieceColor().equals(BLACK)) && (c.getPieceName().equals(ROOK)) && (c.getInitialPosition() == 88)) {
                bKR = c;
            }
            if ((c.getPieceColor().equals(BLACK)) && (c.getPieceName().equals(KING))) {
                bK = c;
            }
        }

        //white
        if ((wKR != null) && (wK != null)) {
            if ((wKR.movesDone.isEmpty()) && (wK.movesDone.isEmpty())) {
                castling = castling +"K";
            }
        }
        if ((wQR != null) && (wK != null)) {
            if ((wQR.movesDone.isEmpty()) && (wK.movesDone.isEmpty())) {
                castling = castling +"Q";
            }
        }
        //black
        if ((bKR != null) && (bK != null)) {
            if ((bKR.movesDone.isEmpty()) && (bK.movesDone.isEmpty())) {
                castling = castling +"k";
            }
        }
        if ((bQR != null) && (bK != null)) {
            if ((bQR.movesDone.isEmpty()) && (bK.movesDone.isEmpty())) {
                castling = castling +"q";
            }
        }

        if(castling.equals(""))
            castle = noCastling;
        else
            castle = castling;

        return castle;
    }

    public void calculateIfCastlingIsPossible() {
        chessPiece wQR = null, wKR = null, wK = null, bQR = null, bKR = null, bK = null;
        for (int i = 0; i < allPieces.size(); i++) {
            chessPiece c = (chessPiece) allPieces.get(i);
            //white
            if ((c.getPieceColor().equals(WHITE)) && (c.getPieceName().equals(ROOK)) && (c.getInitialPosition() == 11)) {
                wQR = c;
            }
            if ((c.getPieceColor().equals(WHITE)) && (c.getPieceName().equals(ROOK)) && (c.getInitialPosition() == 18)) {
                wKR = c;
            }
            if ((c.getPieceColor().equals(WHITE)) && (c.getPieceName().equals(KING))) {
                wK = c;
            }

            //black
            if ((c.getPieceColor().equals(BLACK)) && (c.getPieceName().equals(ROOK)) && (c.getInitialPosition() == 81)) {
                bQR = c;
            }
            if ((c.getPieceColor().equals(BLACK)) && (c.getPieceName().equals(ROOK)) && (c.getInitialPosition() == 88)) {
                bKR = c;
            }
            if ((c.getPieceColor().equals(BLACK)) && (c.getPieceName().equals(KING))) {
                bK = c;
            }
        }


        //white
        if ((wQR != null) && (wK != null)) {
            if ((wQR.movesDone.isEmpty()) && (wK.movesDone.isEmpty())) {
                //12,13,14 goes thru then
                //0-0-0 possible
                if ((!wQR.isAnyPiecePresent(12)) && (!wQR.isAnyPiecePresent(13)) && (!wQR.isAnyPiecePresent(14))) {
                    if (!isKingAttackedAt(WHITE, 13)) {
                        if (!isKingAttackedAt(WHITE, 14)) {
                            //add
                            System.out.println("White Queen side castling possible");
                            wK.movesPossible.add(13);
                        }
                    }
                }
            }
        }
        if ((wKR != null) && (wK != null)) {
            if ((wKR.movesDone.isEmpty()) && (wK.movesDone.isEmpty())) {
                //16,17  goes thru then
                //0-0 possible
                if ((!wKR.isAnyPiecePresent(16)) && (!wKR.isAnyPiecePresent(17))) {
                    if (!isKingAttackedAt(WHITE, 16)) {
                        if (!isKingAttackedAt(WHITE, 17)) {
                            //add
                            System.out.println("White King side castling possible");
                            wK.movesPossible.add(17);
                        }
                    }
                }
            }
        }

        //black
        if ((bQR != null) && (bK != null)) {
            if ((bQR.movesDone.isEmpty()) && (bK.movesDone.isEmpty())) {
                //82,83,84 goes thru then
                //0-0-0 possible
                if ((!bQR.isAnyPiecePresent(82)) && (!bQR.isAnyPiecePresent(83)) && (!bQR.isAnyPiecePresent(84))) {
                    if (!isKingAttackedAt(BLACK, 83)) {
                        if (!isKingAttackedAt(BLACK, 84)) {
                            //add
                            System.out.println("Black Queen side castling possible");
                            bK.movesPossible.add(83);
                        }
                    }
                }
            }
        }
        if ((bKR != null) && (bK != null)) {
            if ((bKR.movesDone.isEmpty()) && (bK.movesDone.isEmpty())) {
                //86,87 goes thru then
                //0-0 possible
                if ((!bKR.isAnyPiecePresent(86)) && (!bKR.isAnyPiecePresent(87))) {
                    if (!isKingAttackedAt(BLACK, 86)) {
                        if (!isKingAttackedAt(BLACK, 87)) {
                            //add
                            System.out.println("Black King side castling possible");
                            bK.movesPossible.add(87);
                        }
                    }
                }
            }
        }
    }

    public void calculateIfCastlingIsPossible(String fenstring) {
        boolean wKC = false;
        boolean wQC = false;
        boolean bKC = false;
        boolean bQC = false;

        char[] s = castle.toCharArray();
        for (int i = 0; i < s.length; i++) {
            if (s[i] == 'K') {
                wKC = true;
            }
            if (s[i] == 'Q') {
                wQC = true;
            }
            if (s[i] == 'k') {
                bKC = true;
            }
            if (s[i] == 'q') {
                bQC = true;
            }
        }



        chessPiece wQR = null, wKR = null, wK = null, bQR = null, bKR = null, bK = null;
        for (int i = 0; i < allPieces.size(); i++) {
            chessPiece c = (chessPiece) allPieces.get(i);
            //white
            if ((c.getPieceColor().equals(WHITE)) && (c.getPieceName().equals(ROOK)) && (c.getInitialPosition() == 11)) {
                wQR = c;
            }
            if ((c.getPieceColor().equals(WHITE)) && (c.getPieceName().equals(ROOK)) && (c.getInitialPosition() == 18)) {
                wKR = c;
            }
            if ((c.getPieceColor().equals(WHITE)) && (c.getPieceName().equals(KING))) {
                wK = c;
            }

            //black
            if ((c.getPieceColor().equals(BLACK)) && (c.getPieceName().equals(ROOK)) && (c.getInitialPosition() == 81)) {
                bQR = c;
            }
            if ((c.getPieceColor().equals(BLACK)) && (c.getPieceName().equals(ROOK)) && (c.getInitialPosition() == 88)) {
                bKR = c;
            }
            if ((c.getPieceColor().equals(BLACK)) && (c.getPieceName().equals(KING))) {
                bK = c;
            }
        }


        //white
        if(wQC) {
        if ((wQR != null) && (wK != null)) {
            if ((wQR.movesDone.isEmpty()) && (wK.movesDone.isEmpty())) {
                //12,13,14 goes thru then
                //0-0-0 possible
                if ((!wQR.isAnyPiecePresent(12)) && (!wQR.isAnyPiecePresent(13)) && (!wQR.isAnyPiecePresent(14))) {
                    if (!isKingAttackedAt(WHITE, 13)) {
                        if (!isKingAttackedAt(WHITE, 14)) {
                            //add
                            System.out.println("White Queen side castling possible");
                            wK.movesPossible.add(13);
                        }
                    }
                }
            }
        }
        }

        if (wKC) {
        if ((wKR != null) && (wK != null)) {
            if ((wKR.movesDone.isEmpty()) && (wK.movesDone.isEmpty())) {
                //16,17  goes thru then
                //0-0 possible
                if ((!wKR.isAnyPiecePresent(16)) && (!wKR.isAnyPiecePresent(17))) {
                    if (!isKingAttackedAt(WHITE, 16)) {
                        if (!isKingAttackedAt(WHITE, 17)) {
                            //add
                            System.out.println("White King side castling possible");
                            wK.movesPossible.add(17);
                        }
                    }
                }
            }
        }
        }

        //black
        if (bQC) {
        if ((bQR != null) && (bK != null)) {
            if ((bQR.movesDone.isEmpty()) && (bK.movesDone.isEmpty())) {
                //82,83,84 goes thru then
                //0-0-0 possible
                if ((!bQR.isAnyPiecePresent(82)) && (!bQR.isAnyPiecePresent(83)) && (!bQR.isAnyPiecePresent(84))) {
                    if (!isKingAttackedAt(BLACK, 83)) {
                        if (!isKingAttackedAt(BLACK, 84)) {
                            //add
                            System.out.println("Black Queen side castling possible");
                            bK.movesPossible.add(83);
                        }
                    }
                }
            }
        }
        }

        if (bKC) {
        if ((bKR != null) && (bK != null)) {
            if ((bKR.movesDone.isEmpty()) && (bK.movesDone.isEmpty())) {
                //86,87 goes thru then
                //0-0 possible
                if ((!bKR.isAnyPiecePresent(86)) && (!bKR.isAnyPiecePresent(87))) {
                    if (!isKingAttackedAt(BLACK, 86)) {
                        if (!isKingAttackedAt(BLACK, 87)) {
                            //add
                            System.out.println("Black King side castling possible");
                            bK.movesPossible.add(87);
                        }
                    }
                }
            }
        }
        }
    }

    private boolean isKingAttackedAt(String kingCol, int pos) {
        for (int k = 0; k < allPieces.size(); k++) {
            chessPiece p = (chessPiece) allPieces.get(k);
            if (!p.getPieceColor().equals(kingCol)) {
                if (p.movesPossible.contains(pos)) {
                    return true;
                }
            }
        }

        return false;
    }

    public int getLatestMove() {
        int s = allMoves.size();
        if (s == 0) {
            return -1;
            
        } else {
            Object i = allMoves.get(s - 1);
            String s1 = i.toString();
            return (Integer.parseInt(s1));
        }
    }
}
