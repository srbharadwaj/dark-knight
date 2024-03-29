/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GamesPanelUI.java
 *
 * Created on 16 Dec, 2009, 9:14:55 PM
 */
package srb;

import java.util.*;
import javax.swing.*;

/**
 *
 * @author Suhas Bharadwaj
 */
public class GamesPanelUI extends JPanel {

    ChessBoardJFrameUI njf = null;

    /** Creates new form GamesPanelUI */
    public GamesPanelUI(ChessBoardJFrameUI n) {
        njf = n;
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        butFirstGame = new javax.swing.JButton();
        butPrevGame = new javax.swing.JButton();
        butNextGame = new javax.swing.JButton();
        butLastGame = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        labGameNo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labWhitePlayerName = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labBlackPlayerName = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        labGameResult = new javax.swing.JLabel();
        butBrowseGames = new javax.swing.JButton();

        butFirstGame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/srb/images/start.gif"))); // NOI18N
        butFirstGame.setToolTipText("First Game");
        butFirstGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butFirstGameActionPerformed(evt);
            }
        });

        butPrevGame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/srb/images/prev.gif"))); // NOI18N
        butPrevGame.setToolTipText("Previous Game");
        butPrevGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butPrevGameActionPerformed(evt);
            }
        });

        butNextGame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/srb/images/next.gif"))); // NOI18N
        butNextGame.setToolTipText("Next Game");
        butNextGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butNextGameActionPerformed(evt);
            }
        });

        butLastGame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/srb/images/end.gif"))); // NOI18N
        butLastGame.setToolTipText("Last Game");
        butLastGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butLastGameActionPerformed(evt);
            }
        });

        jLabel1.setText("Game No.   : ");

        labGameNo.setText(Integer.toString(njf.gameList.size()));

        jLabel3.setText("White          : ");

        labWhitePlayerName.setText("Suhas");

        jLabel5.setText("Black          : ");

        labBlackPlayerName.setText("Player1");

        jLabel7.setText("Result         : ");

        labGameResult.setText("*");

        butBrowseGames.setText("....");
        butBrowseGames.setToolTipText("Browse Games");
        butBrowseGames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butBrowseGamesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labGameNo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(butBrowseGames, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(labGameResult)
                            .addComponent(labBlackPlayerName)
                            .addComponent(labWhitePlayerName)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(butFirstGame, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(butPrevGame, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(butNextGame, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(butLastGame, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labGameNo)
                    .addComponent(butBrowseGames, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(labWhitePlayerName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(labBlackPlayerName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(labGameResult))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(butLastGame, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(butNextGame, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(butPrevGame, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(butFirstGame, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void butFirstGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butFirstGameActionPerformed

        if (njf.currentGameNo > 1) {
            njf.currentGameNo = 1;
            callLoadGame();
        }

    }//GEN-LAST:event_butFirstGameActionPerformed

    private void butPrevGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butPrevGameActionPerformed

        if (njf.currentGameNo > 1) {
            njf.currentGameNo--;
            callLoadGame();
        }
    }//GEN-LAST:event_butPrevGameActionPerformed

    private void butNextGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butNextGameActionPerformed

        if (njf.currentGameNo < njf.gameList.size()) {
            njf.currentGameNo++;
            callLoadGame();
        }
    }//GEN-LAST:event_butNextGameActionPerformed

    private void butLastGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butLastGameActionPerformed

        if (njf.currentGameNo < njf.gameList.size()) {
            njf.currentGameNo = njf.gameList.size();
            callLoadGame();
        }
    }//GEN-LAST:event_butLastGameActionPerformed

    private void butBrowseGamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butBrowseGamesActionPerformed
        // TODO add your handling code here:
        BrowseGamesDialogUI nj = new BrowseGamesDialogUI(njf, true, njf);
        nj.setVisible(true);
        njf.currentGameNo = nj.selGame;
        callLoadGame();
    }//GEN-LAST:event_butBrowseGamesActionPerformed

    public void callLoadGame() {
        updateGamesPanelUI(njf.gameList);
        for (int i = 0; i < njf.gameList.size(); i++) {
            Game g = (Game) njf.gameList.get(i);
            g.moveList.clear();
        }
        for (int i = 0; i < njf.gameList.size(); i++) {
            Game g = (Game) njf.gameList.get(i);
            if (g.gameno == njf.currentGameNo) {
                njf.game = g;
                EachPGNGame e = new EachPGNGame(njf, g.gameno);
                njf.loadGame(g);
                ArrayList v = new ArrayList();
                for (int k = 0; k < g.allBWMoves.size(); k++) {
                    System.out.println(("Class : callLoadGame :: " + g.allBWMoves.get(k)));
                    v.add(g.allBWMoves.get(k));
                }

                e.convertPGNMoveToGUIFormat(v);
                labGameNo.setText(Integer.toString(g.gameno));
                labWhitePlayerName.setText(g.wPlayersName);
                labBlackPlayerName.setText(g.bPlayerName);
                labGameResult.setText(g.gameResult);

                break;
            }
        }
    }

    public void updateGamesPanelUI(ArrayList gameList) {

        for (int i = 0; i < gameList.size(); i++) {
            Game g = (Game) gameList.get(i);
            if (g.gameno == njf.currentGameNo) {
                labGameNo.setText(Integer.toString(g.gameno));
                labWhitePlayerName.setText(g.wPlayersName);
                labBlackPlayerName.setText(g.bPlayerName);
                labGameResult.setText(g.gameResult);
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butBrowseGames;
    private javax.swing.JButton butFirstGame;
    private javax.swing.JButton butLastGame;
    private javax.swing.JButton butNextGame;
    private javax.swing.JButton butPrevGame;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    public javax.swing.JLabel labBlackPlayerName;
    public javax.swing.JLabel labGameNo;
    public javax.swing.JLabel labGameResult;
    public javax.swing.JLabel labWhitePlayerName;
    // End of variables declaration//GEN-END:variables
}
