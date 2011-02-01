package srb;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class EngineProcess extends JFrame implements WindowListener
{
  private JScrollPane textScroll;
    private JTextArea textArea;

  private ChessBoardJFrameUI chessEditor;
  private String engineFileName; 

  private Process engine = null;
  private Thread engineThread;
  private Thread engineInput;
  private Thread engineOutput;
  private PrintWriter writer;

  public EngineProcess(ChessBoardJFrameUI chessEditor, String engineFileName) {
    this.chessEditor = chessEditor; 
    this.engineFileName = engineFileName; 

 /*   try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch (InstantiationException e) {}
    catch (ClassNotFoundException e) {}
    catch (UnsupportedLookAndFeelException e) {}
    catch (IllegalAccessException e) {}*/


    /*if (!(new File(engineFileName)).exists()) {
      FileIO.getInstance().alert(
        chessEditor,  "Chess engine " + engineFileName + " not found");
      System.exit(0);
    }*/

    textArea = new JTextArea("", 15, 60);
    textArea.setEditable(false);
    textScroll = new JScrollPane(textArea);

     textArea.setFont(new java.awt.Font("Monospaced", 0, 12));
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        //setViewportView(textArea);

    this.setTitle("Chess Engine");
    this.addWindowListener(this);
    this.getContentPane().setLayout(new BorderLayout());
    this.getContentPane().add(textScroll);
    this.pack();
    this.setSize(1000, 150);
    //this.setResizable(false);
    this.setLocation(new Point(100, 600));
    this.setVisible(true);
  }

  public void runEngineThread() {
    try {
      engine = Runtime.getRuntime().exec(engineFileName);

      Runnable r2 = new Runnable() {
        public void run() {
          openEngineInput(engine);
	}
      };

      Runnable r1 = new Runnable() {
        public void run() {
          getEngineOutput(engine);
	}
      };

      engineInput = new Thread(r2);
      engineInput.setDaemon(true);
      engineOutput = new Thread(r1);
      engineOutput.setDaemon(true);
      engineInput.start();
      engineOutput.start();
    }
    catch(Exception e) {
    }
  }

  public void runEngine() {
    Runnable r1 = new Runnable() {
      public void run() {
        runEngineThread();
      }
    };

    engineThread = new Thread(r1);
    engineThread.setDaemon(true);
    engineThread.start();

    try {
      while (writer == null)
        Thread.sleep(500);
            
    }
    catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void openEngineInput(Process engine) {
    try {
      writer =
        new PrintWriter(
          new OutputStreamWriter(engine.getOutputStream()));
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  public void talkToEngine(String string) {
    try {
      if (writer != null) {
//      System.out.println(string);
        writer.println(string);
        writer.flush();
      }
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  private void getEngineOutput(Process engine) {
    try {
      BufferedReader reader =
        new BufferedReader(new InputStreamReader(engine.getInputStream()), 1);
      String lineRead = null;
      while((lineRead = reader.readLine()) != null) {
        textArea.append(lineRead);
        textArea.append("\n");
	textArea.setCaretPosition(textArea.getDocument().getLength() - 1);
        //Thread.sleep(3000);
      }
    System.out.println(("EOF"));
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  public void stopEngine() {
      getMove();
    if (isEngineRunning()) {
      try {
        writer.close();
      }
      catch(Exception e) {
        e.printStackTrace();
      }
      writer = null;
      engine.destroy();
      engine = null;
      dispose();
      
      //CHECK
      chessEditor.menuItemEngineOff.setSelected(true);
      chessEditor.engineProcess = null;
    }
  }

  public boolean isEngineRunning() {
    return engine != null;
  }

  public void getMove()
  {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(EngineProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] s = textArea.getText().split("\n");
        for(int i=s.length-1;i>=0;i--)
        {
            if(s[i].trim().startsWith("8"))
            {
                System.out.println(("MOVE IS " + s[i].trim()));
                break;
            }
        }

         
  }
  public void windowOpened(WindowEvent e) {
  }

  public void windowIconified(WindowEvent e) {
  }

  public void windowDeiconified(WindowEvent e) {
  }

  public void windowActivated(WindowEvent e) {
  }

  public void windowDeactivated(WindowEvent e) {
  }

  public void windowClosing(WindowEvent e) {
    stopEngine();
  }

  public void windowClosed(WindowEvent e) {
  }
}
