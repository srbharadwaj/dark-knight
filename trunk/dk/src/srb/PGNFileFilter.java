/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package srb;

/**
 * Class Name - PGNFileFilter
 * Description - 
 *
 * @author suhas
 */
class PGNFileFilter extends javax.swing.filechooser.FileFilter {

    public String getDescription() {
        return "PGN Files (*.pgn)";
    }

    public boolean accept(java.io.File file) {
        return file.exists() && file.canRead() && (file.getName().endsWith(".pgn") || file.isDirectory());
    }
}
