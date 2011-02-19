/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EditTags.java
 *
 * Created on 13 Mar, 2010, 2:11:09 PM
 */
package srb;

import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author suhas
 */
public class EditTags extends JDialog implements CConst {

    ArrayList alltags;
    Game gameLocal;

    /** Creates new form EditTags */
    public EditTags(java.awt.Frame parent, boolean modal, Game g) {
        super(parent, modal);
        gameLocal = g;
        alltags = g.tags;
        //System.out.println(alltags.size());
        //createViewPanel(alltags);
        initComponents();

        // Center in parent
        //Rectangle parentBounds = new Rectangle();
        Rectangle parentBounds = parent.getBounds();
        Dimension size = getSize();
        //parent.getBounds(parentBounds);
        int x = Math.max(0, parentBounds.x + (parentBounds.width - size.width) / 2);
        int y = Math.max(0, parentBounds.y + (parentBounds.height - size.height) / 2);
        setLocation(new Point(x, y));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        addPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfAddTagName = new javax.swing.JTextField();
        tfAddTagValue = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        bClear = new javax.swing.JButton();
        deletePanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cbSelectTagNameForDeletePanel = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        tfDelTagValue = new javax.swing.JTextField();
        bDel = new javax.swing.JButton();
        editPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cbSelectTagName = new javax.swing.JComboBox();
        tfEditValue = new javax.swing.JTextField();
        bEdit = new javax.swing.JButton();
        rbEditTagName = new javax.swing.JRadioButton();
        rbEditTagValue = new javax.swing.JRadioButton();
        tfEditName = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit-Tags : " + TITLE);

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jScrollPane1.setName("viewPanel"); // NOI18N
        jTabbedPane1.addTab("View", jScrollPane1);

        addPanel.setName("addPanel"); // NOI18N

        jLabel1.setText("Tag Name  : ");

        jLabel2.setText("Tag Value : ");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/srb/images/icons/add.png"))); // NOI18N
        jButton3.setText("Add");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        bClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/srb/images/icons/broom.png"))); // NOI18N
        bClear.setText("Clear");
        bClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addPanelLayout = new javax.swing.GroupLayout(addPanel);
        addPanel.setLayout(addPanelLayout);
        addPanelLayout.setHorizontalGroup(
            addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(addPanelLayout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tfAddTagName, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(addPanelLayout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(tfAddTagValue)))
                    .addGroup(addPanelLayout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(bClear)))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        addPanelLayout.setVerticalGroup(
            addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfAddTagName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfAddTagValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(bClear))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Add", addPanel);

        deletePanel.setName("deletePanel"); // NOI18N

        jLabel3.setText("Tag Name  : ");

        cbSelectTagNameForDeletePanel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Select Tag Name --" }));
        cbSelectTagNameForDeletePanel.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbSelectTagNameForDeletePanelItemStateChanged(evt);
            }
        });

        jLabel4.setText("Tag Value : ");

        tfDelTagValue.setEditable(false);

        bDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/srb/images/icons/delete.png"))); // NOI18N
        bDel.setText("Delete");
        bDel.setEnabled(false);
        bDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout deletePanelLayout = new javax.swing.GroupLayout(deletePanel);
        deletePanel.setLayout(deletePanelLayout);
        deletePanelLayout.setHorizontalGroup(
            deletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deletePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(deletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(32, 32, 32)
                .addGroup(deletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bDel)
                    .addGroup(deletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tfDelTagValue)
                        .addComponent(cbSelectTagNameForDeletePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(136, 136, 136))
        );
        deletePanelLayout.setVerticalGroup(
            deletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deletePanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(deletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbSelectTagNameForDeletePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(deletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfDelTagValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addComponent(bDel)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Delete", deletePanel);

        editPanel.setName("editPanel"); // NOI18N

        jLabel5.setText("Tag Name  : ");

        cbSelectTagName.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Select Tag Name --" }));
        cbSelectTagName.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbSelectTagNameItemStateChanged(evt);
            }
        });

        tfEditValue.setEditable(false);

        bEdit.setText("Apply");
        bEdit.setEnabled(false);
        bEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbEditTagName);
        rbEditTagName.setSelected(true);
        rbEditTagName.setText("Edit Tag Name");
        rbEditTagName.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbEditTagNameItemStateChanged(evt);
            }
        });

        buttonGroup1.add(rbEditTagValue);
        rbEditTagValue.setText("Edit Tag Value");

        javax.swing.GroupLayout editPanelLayout = new javax.swing.GroupLayout(editPanel);
        editPanel.setLayout(editPanelLayout);
        editPanelLayout.setHorizontalGroup(
            editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editPanelLayout.createSequentialGroup()
                        .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbEditTagValue)
                            .addComponent(rbEditTagName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bEdit)
                            .addComponent(tfEditName, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(tfEditValue, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)))
                    .addGroup(editPanelLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbSelectTagName, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(160, 160, 160))
        );
        editPanelLayout.setVerticalGroup(
            editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbSelectTagName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbEditTagName)
                    .addComponent(tfEditName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbEditTagValue)
                    .addComponent(tfEditValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(bEdit)
                .addGap(46, 46, 46))
        );

        jTabbedPane1.addTab("Edit", editPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bClearActionPerformed

        tfAddTagName.setText("");
        tfAddTagValue.setText("");
    }//GEN-LAST:event_bClearActionPerformed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged

        //System.out.println(jTabbedPane1.getSelectedComponent().getName());
        if (jTabbedPane1.getSelectedComponent().getName().equals("viewPanel")) {
            createViewPanel(alltags);
        } else if (jTabbedPane1.getSelectedComponent().getName().equals("addPanel")) {
            createAddPanel(alltags);
        } else if (jTabbedPane1.getSelectedComponent().getName().equals("deletePanel")) {
            createDeletePanel(alltags);
        } else {
            createEditPanel(alltags);
        }
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void rbEditTagNameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbEditTagNameItemStateChanged

        if (rbEditTagName.isSelected()) {
            tfEditValue.setEditable(false);
            tfEditName.setEditable(true);
        } else {
            tfEditValue.setEditable(true);
            tfEditName.setEditable(false);
        }

    }//GEN-LAST:event_rbEditTagNameItemStateChanged

    private void cbSelectTagNameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbSelectTagNameItemStateChanged

        if (cbSelectTagName.getSelectedIndex() == 0) {
            tfEditValue.setText("");
            tfEditName.setText("");
            bEdit.setEnabled(false);
        } else {
            bEdit.setEnabled(true);
            for (int i = 0; i < alltags.size(); i++) {
                System.out.println((alltags.get(i)));

                String s = (String) alltags.get(i);
                String[] t = s.split("~");
                if (t[0].equals(cbSelectTagName.getSelectedItem())) {
                    tfEditValue.setText(t[1]);
                    tfEditName.setText(t[0]);
                    break;
                }
            }
        }
    }//GEN-LAST:event_cbSelectTagNameItemStateChanged

    private void cbSelectTagNameForDeletePanelItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbSelectTagNameForDeletePanelItemStateChanged
        if (cbSelectTagNameForDeletePanel.getSelectedIndex() == 0) {
            tfDelTagValue.setText("");
            bDel.setEnabled(false);
        } else {
            bDel.setEnabled(true);
            for (int i = 0; i < alltags.size(); i++) {
                System.out.println((alltags.get(i)));

                String s = (String) alltags.get(i);
                String[] t = s.split("~");
                if (t[0].equals(cbSelectTagNameForDeletePanel.getSelectedItem())) {
                    tfDelTagValue.setText(t[1]);
                    break;
                }
            }
        }
    }//GEN-LAST:event_cbSelectTagNameForDeletePanelItemStateChanged

    private void bDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDelActionPerformed

        if (JOptionPane.showConfirmDialog(this, "Do you really want to remove the selected tag?", "Delete Tag?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            String o = (String) cbSelectTagNameForDeletePanel.getSelectedItem();
            if ((o.contains("Date")) || (o.contains("White")) || (o.contains("Blaack")) || (o.contains("Result"))) {
                JOptionPane.showMessageDialog(this, "Cannot delete this tag", "Tag not removed!!!", JOptionPane.ERROR_MESSAGE);
            } else {
                for (int i = 0; i < alltags.size(); i++) {
                    //System.out.println(alltags.get(i));
                    String s = (String) alltags.get(i);
                    String[] t = s.split("~");
                    if (o.equals(t[0])) {
                        System.out.println((alltags.remove(s)));
                    }
                }

            }

        }
    }//GEN-LAST:event_bDelActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void bEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bEditActionPerformed
    /**
     * @param args the command line arguments
     */
    /* public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
    public void run() {
    EditTags dialog = new EditTags(new javax.swing.JFrame(), true);
    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
    public void windowClosing(java.awt.event.WindowEvent e) {
    System.exit(0);
    }
    });
    dialog.setVisible(true);
    }
    });
    }*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addPanel;
    private javax.swing.JButton bClear;
    private javax.swing.JButton bDel;
    private javax.swing.JButton bEdit;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbSelectTagName;
    private javax.swing.JComboBox cbSelectTagNameForDeletePanel;
    private javax.swing.JPanel deletePanel;
    private javax.swing.JPanel editPanel;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rbEditTagName;
    private javax.swing.JRadioButton rbEditTagValue;
    private javax.swing.JTextField tfAddTagName;
    private javax.swing.JTextField tfAddTagValue;
    private javax.swing.JTextField tfDelTagValue;
    private javax.swing.JTextField tfEditName;
    private javax.swing.JTextField tfEditValue;
    // End of variables declaration//GEN-END:variables

    private void createViewPanel(ArrayList tags) {
        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(tags.size(), 2));
        jScrollPane1.setViewportView(jp);

        for (int i = 0; i < tags.size(); i++) {
            System.out.println((tags.get(i)));
            JLabel tn = new JLabel();
            JLabel tv = new JLabel();

            String s = (String) tags.get(i);
            String[] t = s.split("~");

            tn.setText(t[0]);
            tv.setText(t[1]);

            jp.add(tn);
            jp.add(tv);
        }
    }

    private void createAddPanel(ArrayList alltags) {
        //throw new UnsupportedOperationException("Not yet implemented");
        getRootPane().setDefaultButton(jButton3);
        tfAddTagName.requestFocusInWindow();
    }

    private void createDeletePanel(ArrayList alltags) {
        clearupComboBox(cbSelectTagNameForDeletePanel);
        for (int i = 0; i < alltags.size(); i++) {
            //System.out.println(alltags.get(i));

            String s = (String) alltags.get(i);
            String[] t = s.split("~");

            cbSelectTagNameForDeletePanel.addItem(t[0]);

        }
    }

    private void createEditPanel(ArrayList alltags) {

        clearupComboBox(cbSelectTagName);
        for (int i = 0; i < alltags.size(); i++) {
            //System.out.println(alltags.get(i));

            String s = (String) alltags.get(i);
            String[] t = s.split("~");

            cbSelectTagName.addItem(t[0]);

        }
    }

    public void clearupComboBox(JComboBox cb) {
        cb.removeAllItems();
        cb.addItem("-- Select Tag Name --");
    }
}
