/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package srb;

/**
 * Class Name - FENFileFilter
 * Description - 
 *
 * @author suhas
 */
    class FENFileFilter extends javax.swing.filechooser.FileFilter
    {
        public String getDescription() {
            return "FEN Files (*.fen)";
        }
        public boolean accept(java.io.File file) {
            return file.exists() && file.canRead() && 
                    (file.getName().endsWith(".fen") || file.isDirectory());
        }
    }
