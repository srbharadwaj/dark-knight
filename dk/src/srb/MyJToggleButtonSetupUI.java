package srb;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * position of jtogglebuttons
 *  00 01 02 03 04 05 06 07
 *  08 09 10 11 12 13 14 15
 *  16 17 18 19 20 21 22 23
 *  24 25 26 27 28 29 30 31
 *  32 33 34 35 36 37 38 39
 *  40 41 42 43 44 45 46 47
 *  48 49 50 51 52 53 54 55
 *  56 57 58 59 60 61 62 63  
 *
 */
/**
 * Class Name - MyJToggleButtonUI
 * Description - 
 *
 * @author Suhas Bharadwaj
 */
public class MyJToggleButtonSetupUI extends JToggleButton implements ItemListener, CConst {

    Color darkORlight;
    SetupPositionDialogUI sp;
    public String piece = "";

    //test constructor
    public MyJToggleButtonSetupUI(SetupPositionDialogUI sp) {
        super();
        //System.out.println("Created");
        this.sp = sp;
        addItemListener(this);
    }

    public void setDefaultBgColor() {
        this.setBackground(darkORlight);
    }

    public void setHighlightingBgColor() {
        this.setBackground(cHighlight);
    }

    public void setLightBgColor() {
        this.setBackground(cLight);
        darkORlight = cLight;
    }

    public void setDarkBgColor() {
        this.setBackground(cDark);
        darkORlight = cDark;
    }

    public void setPiece(String s) {
        this.piece = s;
    }

    public String getPiece() {
        return this.piece;
    }

    public void itemStateChanged(ItemEvent e) {
        MyJToggleButtonSetupUI j = (MyJToggleButtonSetupUI) e.getSource();
        if (j.isSelected()) {
            j.setPiece(sp.spc.getPieceSelected());
            if (sp.spc.getPieceSelected().equals("WR")) {
                j.setIcon(new ImageIcon(getClass().getResource(whiteRook)));
                j.setPiece("WR");
            } else if (sp.spc.getPieceSelected().equals("WN")) {
                j.setIcon(new ImageIcon(getClass().getResource(whiteKnight)));
                j.setPiece("WN");
            } else if (sp.spc.getPieceSelected().equals("WB")) {
                j.setIcon(new ImageIcon(getClass().getResource(whiteBishop)));
                j.setPiece("WB");
            } else if (sp.spc.getPieceSelected().equals("WQ")) {
                j.setIcon(new ImageIcon(getClass().getResource(whiteQueen)));
                j.setPiece("WQ");
            } else if (sp.spc.getPieceSelected().equals("WK")) {
                j.setIcon(new ImageIcon(getClass().getResource(whiteKing)));
                j.setPiece("WK");
            } else if (sp.spc.getPieceSelected().equals("WP")) {
                j.setIcon(new ImageIcon(getClass().getResource(whitePawn)));
                j.setPiece("WP");
            } else if (sp.spc.getPieceSelected().equals("BR")) {
                j.setIcon(new ImageIcon(getClass().getResource(blackRook)));
                j.setPiece("BR");
            } else if (sp.spc.getPieceSelected().equals("BN")) {
                j.setIcon(new ImageIcon(getClass().getResource(blackKnight)));
                j.setPiece("BN");
            } else if (sp.spc.getPieceSelected().equals("BB")) {
                j.setIcon(new ImageIcon(getClass().getResource(blackBishop)));
                j.setPiece("BB");
            } else if (sp.spc.getPieceSelected().equals("BQ")) {
                j.setIcon(new ImageIcon(getClass().getResource(blackQueen)));
                j.setPiece("BQ");
            } else if (sp.spc.getPieceSelected().equals("BK")) {
                j.setIcon(new ImageIcon(getClass().getResource(blackKing)));
                j.setPiece("BK");
            } else if (sp.spc.getPieceSelected().equals("BP")) {
                j.setIcon(new ImageIcon(getClass().getResource(blackPawn)));
                j.setPiece("BP");
            } else {
                j.setIcon(null);
                j.setPiece("");
            }

            j.setSelected(false);
            sp.chkCastlingAndEditCheckBox();
        }
    }
}
