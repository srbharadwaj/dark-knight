/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SetupPositionControlsPanelUI.java
 *
 * Created on 2 Jan, 2010, 10:54:03 PM
 */

package srb;

import java.awt.*;
import javax.swing.*;


/**
 *
 * @author suhas
 */
public class SetupPositionControlsPanelUI extends javax.swing.JPanel implements CConst {
private SetupPositionDialogUI aThis = null;
    /** Creates new form SetupPositionControlsPanelUI */
    public SetupPositionControlsPanelUI(SetupPositionDialogUI aThis) {
        this.aThis = aThis;
        initComponents();
    }

    public void setPieceSelected(String s)
    {
        this.selected = s;

        //Set the cursor
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Point cursorHotSpot = new Point(0,0);
          Image cursorImage = null;
        if(s.equals("WR"))
            cursorImage = toolkit.getImage(getClass().getResource(whiteRook));
        else if(s.equals("WN"))
            cursorImage = toolkit.getImage(getClass().getResource(whiteKnight));
        else if(s.equals("WB"))
            cursorImage = toolkit.getImage(getClass().getResource(whiteBishop));
        else if(s.equals("WQ"))
            cursorImage = toolkit.getImage(getClass().getResource(whiteQueen));
        else if(s.equals("WK"))
            cursorImage = toolkit.getImage(getClass().getResource(whiteKing));
        else if(s.equals("WP"))
            cursorImage = toolkit.getImage(getClass().getResource(whitePawn));
        else if(s.equals("BR"))
            cursorImage = toolkit.getImage(getClass().getResource(blackRook));
        else if(s.equals("BN"))
            cursorImage = toolkit.getImage(getClass().getResource(blackKnight));
        else if(s.equals("BB"))
            cursorImage = toolkit.getImage(getClass().getResource(blackBishop));
        else if(s.equals("BQ"))
            cursorImage = toolkit.getImage(getClass().getResource(blackQueen));
        else if(s.equals("BK"))
            cursorImage = toolkit.getImage(getClass().getResource(blackKing));
        else if(s.equals("BP"))
            cursorImage = toolkit.getImage(getClass().getResource(blackPawn));
        else
            cursorImage = toolkit.getImage(getClass().getResource(blackPawn)); //not req but still

        Cursor customCursor = toolkit.createCustomCursor(cursorImage, cursorHotSpot, "Cursor");
        aThis.chessBoard.setCursor(customCursor);

        if(s.equals("R"))
            aThis.chessBoard.setCursor(Cursor.getDefaultCursor());

    }

    public String getPieceSelected()
    {
        return this.selected;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jtbWK = new javax.swing.JToggleButton();
        jtbBK = new javax.swing.JToggleButton();
        jtbWQ = new javax.swing.JToggleButton();
        jtbBQ = new javax.swing.JToggleButton();
        jtbWR = new javax.swing.JToggleButton();
        jtbBR = new javax.swing.JToggleButton();
        jtbWN = new javax.swing.JToggleButton();
        jtbBN = new javax.swing.JToggleButton();
        jtbWB = new javax.swing.JToggleButton();
        jtbBB = new javax.swing.JToggleButton();
        jtbWP = new javax.swing.JToggleButton();
        jtbBP = new javax.swing.JToggleButton();
        jtbRemove = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        rbWhite = new javax.swing.JRadioButton();
        rbBlack = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        cbWhiteKingCastle = new javax.swing.JCheckBox();
        cbWhiteQueenCastle = new javax.swing.JCheckBox();
        cbBlackKingCastle = new javax.swing.JCheckBox();
        cbBlackQueenCastle = new javax.swing.JCheckBox();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Pieces"));

        buttonGroup1.add(jtbWK);
        jtbWK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/srb/images/WK.gif"))); // NOI18N
        jtbWK.setMaximumSize(new java.awt.Dimension(50, 50));
        jtbWK.setMinimumSize(new java.awt.Dimension(50, 50));
        jtbWK.setPreferredSize(new java.awt.Dimension(50, 50));
        jtbWK.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jtbWKItemStateChanged(evt);
            }
        });

        buttonGroup1.add(jtbBK);
        jtbBK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/srb/images/BK.gif"))); // NOI18N
        jtbBK.setMaximumSize(new java.awt.Dimension(50, 50));
        jtbBK.setMinimumSize(new java.awt.Dimension(50, 50));
        jtbBK.setPreferredSize(new java.awt.Dimension(50, 50));
        jtbBK.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jtbBKItemStateChanged(evt);
            }
        });

        buttonGroup1.add(jtbWQ);
        jtbWQ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/srb/images/WQ.gif"))); // NOI18N
        jtbWQ.setMaximumSize(new java.awt.Dimension(50, 50));
        jtbWQ.setMinimumSize(new java.awt.Dimension(50, 50));
        jtbWQ.setPreferredSize(new java.awt.Dimension(50, 50));
        jtbWQ.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jtbWQItemStateChanged(evt);
            }
        });

        buttonGroup1.add(jtbBQ);
        jtbBQ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/srb/images/BQ.gif"))); // NOI18N
        jtbBQ.setMaximumSize(new java.awt.Dimension(50, 50));
        jtbBQ.setMinimumSize(new java.awt.Dimension(50, 50));
        jtbBQ.setPreferredSize(new java.awt.Dimension(50, 50));
        jtbBQ.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jtbBQItemStateChanged(evt);
            }
        });

        buttonGroup1.add(jtbWR);
        jtbWR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/srb/images/WR.gif"))); // NOI18N
        jtbWR.setMaximumSize(new java.awt.Dimension(50, 50));
        jtbWR.setMinimumSize(new java.awt.Dimension(50, 50));
        jtbWR.setPreferredSize(new java.awt.Dimension(50, 50));
        jtbWR.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jtbWRItemStateChanged(evt);
            }
        });

        buttonGroup1.add(jtbBR);
        jtbBR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/srb/images/BR.gif"))); // NOI18N
        jtbBR.setMaximumSize(new java.awt.Dimension(50, 50));
        jtbBR.setMinimumSize(new java.awt.Dimension(50, 50));
        jtbBR.setPreferredSize(new java.awt.Dimension(50, 50));
        jtbBR.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jtbBRItemStateChanged(evt);
            }
        });

        buttonGroup1.add(jtbWN);
        jtbWN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/srb/images/WN.gif"))); // NOI18N
        jtbWN.setMaximumSize(new java.awt.Dimension(50, 50));
        jtbWN.setMinimumSize(new java.awt.Dimension(50, 50));
        jtbWN.setPreferredSize(new java.awt.Dimension(50, 50));
        jtbWN.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jtbWNItemStateChanged(evt);
            }
        });

        buttonGroup1.add(jtbBN);
        jtbBN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/srb/images/BN.gif"))); // NOI18N
        jtbBN.setMaximumSize(new java.awt.Dimension(50, 50));
        jtbBN.setMinimumSize(new java.awt.Dimension(50, 50));
        jtbBN.setPreferredSize(new java.awt.Dimension(50, 50));
        jtbBN.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jtbBNItemStateChanged(evt);
            }
        });

        buttonGroup1.add(jtbWB);
        jtbWB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/srb/images/WB.gif"))); // NOI18N
        jtbWB.setMaximumSize(new java.awt.Dimension(50, 50));
        jtbWB.setMinimumSize(new java.awt.Dimension(50, 50));
        jtbWB.setPreferredSize(new java.awt.Dimension(50, 50));
        jtbWB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jtbWBItemStateChanged(evt);
            }
        });

        buttonGroup1.add(jtbBB);
        jtbBB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/srb/images/BB.gif"))); // NOI18N
        jtbBB.setMaximumSize(new java.awt.Dimension(50, 50));
        jtbBB.setMinimumSize(new java.awt.Dimension(50, 50));
        jtbBB.setPreferredSize(new java.awt.Dimension(50, 50));
        jtbBB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jtbBBItemStateChanged(evt);
            }
        });

        buttonGroup1.add(jtbWP);
        jtbWP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/srb/images/WP.gif"))); // NOI18N
        jtbWP.setMaximumSize(new java.awt.Dimension(50, 50));
        jtbWP.setMinimumSize(new java.awt.Dimension(50, 50));
        jtbWP.setPreferredSize(new java.awt.Dimension(50, 50));
        jtbWP.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jtbWPItemStateChanged(evt);
            }
        });

        buttonGroup1.add(jtbBP);
        jtbBP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/srb/images/BP.gif"))); // NOI18N
        jtbBP.setMaximumSize(new java.awt.Dimension(50, 50));
        jtbBP.setMinimumSize(new java.awt.Dimension(50, 50));
        jtbBP.setPreferredSize(new java.awt.Dimension(50, 50));
        jtbBP.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jtbBPItemStateChanged(evt);
            }
        });

        buttonGroup1.add(jtbRemove);
        jtbRemove.setSelected(true);
        jtbRemove.setText("Remove");
        jtbRemove.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jtbRemoveItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jtbWN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtbWK, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtbBK, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtbBN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jtbWB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtbWP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jtbWQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtbWR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jtbBQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtbBR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jtbBB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtbBP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jtbRemove))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jtbWK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtbWN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtbBK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtbBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtbWQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtbWR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtbWB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtbWP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtbBQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtbBR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtbBP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtbBB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtbRemove, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Turn"));

        buttonGroup2.add(rbWhite);
        rbWhite.setSelected(true);
        rbWhite.setText("White");

        buttonGroup2.add(rbBlack);
        rbBlack.setText("Black");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(rbWhite)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbBlack)
                .addContainerGap(86, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbWhite)
                    .addComponent(rbBlack))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), " Castling Possible?"));

        cbWhiteKingCastle.setSelected(true);
        cbWhiteKingCastle.setText("White can castle Kingside");
        cbWhiteKingCastle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbWhiteKingCastleActionPerformed(evt);
            }
        });

        cbWhiteQueenCastle.setSelected(true);
        cbWhiteQueenCastle.setText("White can castle Queen side");
        cbWhiteQueenCastle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbWhiteQueenCastleActionPerformed(evt);
            }
        });

        cbBlackKingCastle.setSelected(true);
        cbBlackKingCastle.setText("Black can castle King side");
        cbBlackKingCastle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBlackKingCastleActionPerformed(evt);
            }
        });

        cbBlackQueenCastle.setSelected(true);
        cbBlackQueenCastle.setText("Black can castle Queen side");
        cbBlackQueenCastle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBlackQueenCastleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbWhiteKingCastle)
                    .addComponent(cbWhiteQueenCastle)
                    .addComponent(cbBlackKingCastle)
                    .addComponent(cbBlackQueenCastle))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbWhiteKingCastle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbWhiteQueenCastle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbBlackKingCastle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbBlackQueenCastle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtbRemoveItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jtbRemoveItemStateChanged
        setPieceSelected("R");
    }//GEN-LAST:event_jtbRemoveItemStateChanged

    private void jtbWBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jtbWBItemStateChanged
        setPieceSelected("WB");
    }//GEN-LAST:event_jtbWBItemStateChanged

    private void jtbWKItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jtbWKItemStateChanged
        setPieceSelected("WK");
    }//GEN-LAST:event_jtbWKItemStateChanged

    private void jtbWQItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jtbWQItemStateChanged
        setPieceSelected("WQ");
    }//GEN-LAST:event_jtbWQItemStateChanged

    private void jtbWRItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jtbWRItemStateChanged
        setPieceSelected("WR");
    }//GEN-LAST:event_jtbWRItemStateChanged

    private void jtbWNItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jtbWNItemStateChanged
        setPieceSelected("WN");
    }//GEN-LAST:event_jtbWNItemStateChanged

    private void jtbWPItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jtbWPItemStateChanged
        setPieceSelected("WP");
    }//GEN-LAST:event_jtbWPItemStateChanged

    private void jtbBKItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jtbBKItemStateChanged
        setPieceSelected("BK");
    }//GEN-LAST:event_jtbBKItemStateChanged

    private void jtbBQItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jtbBQItemStateChanged
        setPieceSelected("BQ");
    }//GEN-LAST:event_jtbBQItemStateChanged

    private void jtbBRItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jtbBRItemStateChanged
        setPieceSelected("BR");
    }//GEN-LAST:event_jtbBRItemStateChanged

    private void jtbBNItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jtbBNItemStateChanged
        setPieceSelected("BN");
    }//GEN-LAST:event_jtbBNItemStateChanged

    private void jtbBBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jtbBBItemStateChanged
        setPieceSelected("BB");
    }//GEN-LAST:event_jtbBBItemStateChanged

    private void jtbBPItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jtbBPItemStateChanged
        setPieceSelected("BP");
    }//GEN-LAST:event_jtbBPItemStateChanged

    private void cbWhiteKingCastleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbWhiteKingCastleActionPerformed
        JCheckBox cb = (JCheckBox) evt.getSource();
        if(cb.isSelected())
        {
            aThis.chkCastlingAndEditCheckBox();
        }
    }//GEN-LAST:event_cbWhiteKingCastleActionPerformed

    private void cbWhiteQueenCastleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbWhiteQueenCastleActionPerformed
        JCheckBox cb = (JCheckBox) evt.getSource();
        if(cb.isSelected())
        {
            aThis.chkCastlingAndEditCheckBox();
        }
    }//GEN-LAST:event_cbWhiteQueenCastleActionPerformed

    private void cbBlackQueenCastleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBlackQueenCastleActionPerformed
        JCheckBox cb = (JCheckBox) evt.getSource();
        if(cb.isSelected())
        {
            aThis.chkCastlingAndEditCheckBox();
        }
    }//GEN-LAST:event_cbBlackQueenCastleActionPerformed

    private void cbBlackKingCastleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBlackKingCastleActionPerformed
        JCheckBox cb = (JCheckBox) evt.getSource();
        if(cb.isSelected())
        {
            aThis.chkCastlingAndEditCheckBox();
        }
    }//GEN-LAST:event_cbBlackKingCastleActionPerformed

public String selected = "R";

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    public javax.swing.JCheckBox cbBlackKingCastle;
    public javax.swing.JCheckBox cbBlackQueenCastle;
    public javax.swing.JCheckBox cbWhiteKingCastle;
    public javax.swing.JCheckBox cbWhiteQueenCastle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JToggleButton jtbBB;
    private javax.swing.JToggleButton jtbBK;
    private javax.swing.JToggleButton jtbBN;
    private javax.swing.JToggleButton jtbBP;
    private javax.swing.JToggleButton jtbBQ;
    private javax.swing.JToggleButton jtbBR;
    private javax.swing.JToggleButton jtbRemove;
    private javax.swing.JToggleButton jtbWB;
    private javax.swing.JToggleButton jtbWK;
    private javax.swing.JToggleButton jtbWN;
    private javax.swing.JToggleButton jtbWP;
    private javax.swing.JToggleButton jtbWQ;
    private javax.swing.JToggleButton jtbWR;
    public javax.swing.JRadioButton rbBlack;
    public javax.swing.JRadioButton rbWhite;
    // End of variables declaration//GEN-END:variables

}
