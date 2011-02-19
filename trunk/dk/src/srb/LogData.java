/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package srb;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.swing.JTextArea;

/**
 *
 * @author subharad
 */
class LogData implements CConst {

    JTextArea jta;
    Logger logger;

    public LogData(ChessBoardJFrameUI aThis) {
        jta = aThis.txtAreaLog;
        jta.setFont(new java.awt.Font("Monospaced", 0, 11));

        // Get a logger
        logger = Logger.getLogger("dk.srb");

        // Create a new handler that uses the simple formatter
        try {
            // Create a file handler that uses 3 logfiles, each with a limit of 1Mbyte
            String pattern = "Dark-Knight.log";
            int limit = 1000000; // 1 Mb
            FileHandler fh = new FileHandler(pattern, limit, 1);
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
        } catch (IOException e) {
        }
    }

    // This method logs the data to a file
    // It also prints the data on the log text area in the GUI
    // If level = 1 then printf,gui
    // If level = 2 then printf
    public void logLine(String line, int level) {
        System.out.println(line);

        if (level == 0) {
            jta.append(line + '\n');
        }
    }

    public void logLine(String line) {
        logLine(line, 0);
    }

    public void logLine(String line, Level l) {
        logger.setLevel(Level.ALL);
        if (l == Level.CONFIG) {
            logger.config(line);
        } else if (l == Level.SEVERE) {
            logger.severe(line);
        } else if (l == Level.INFO) {
            logger.info(line);
        } else if (l == Level.WARNING) {
            logger.warning(line);
        } else {
            logger.finest(line);
        }
    }
}
