/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package srb;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JTextArea;

/**
 *
 * @author subharad
 */
class LogData {

    JTextArea jta;
    FileWriter fstream;
    BufferedWriter out;
    public LogData(ChessBoardJFrameUI aThis) {
        jta = aThis.txtAreaLog;
        jta.setFont(new java.awt.Font("Monospaced", 0, 11));
        try{
            // Create file
            fstream = new FileWriter("Dark-Knight.log");
            out = new BufferedWriter(fstream);
        }catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }

    // This method logs the data to a file
    // It also prints the data on the log text area in the GUI
    // If level = 1 then printf,file,gui
    // If level = 2 then printf,file
    public void logLine(String line, int level) throws IOException
    {
        
            System.out.println(line);
           
            //File
            out.write(DateFormat.getDateTimeInstance().format(new Date()) + " : " + line);
        //Close the output stream
        //out.close();
            //System.out.println(DateFormat.getDateTimeInstance().format(new Date()) + " : " + line);
         if(level == 0)
        {
             jta.append(line + '\n');
         }
    }

    public void logLine(String line) throws IOException
    {
        logLine(line, 0);
    }
}
