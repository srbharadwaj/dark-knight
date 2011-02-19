/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package srb;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.logging.Level;
import javax.swing.*;

/**
 * Class Name - ChessBoardJFrameUI
 * Description - 
 *
 * @author Suhas Bharadwaj
 */
public class ChessBoardJFrameUI extends JFrame implements WindowListener, ActionListener, ItemListener, CConst {

    private JMenuItem menuItemLocateEngine;
    private JMenu menuItemEngine;
    private ButtonGroup engineGroup;
    public JRadioButtonMenuItem menuItemEngineOff;
    private JRadioButtonMenuItem menuItemEngineOn;
    public EngineProcess engineProcess = null;
    public String engineFileName = null;
    public JPanel mainP = new JPanel(new BorderLayout());
    public JPanel cP = new JPanel(new BorderLayout());
    public JPanel nP = new JPanel(new BorderLayout());
    public JPanel sP = new JPanel(new BorderLayout());
    public JPanel eP = new JPanel(new BorderLayout());
    public JPanel wP = new JPanel(new BorderLayout());
    public JPanel chessBoardContainer = new JPanel(new BorderLayout());
    //public JPanel chessBoardContainer = new JPanel(new GridBagLayout());
    public JPanel chessBoard = new JPanel(new GridLayout(8, 8));
    public JPanel butJPanel = new JPanel(new FlowLayout());
    public JPanel whiteCapPanel = new JPanel(new GridLayout(4, 4));
    public JPanel blackCapPanel = new JPanel(new GridLayout(4, 4));
    public JTextArea txtAreaMoves = new JTextArea();
    public JTextArea txtAreaLog = new JTextArea();
    public JButton first = new JButton("First");
    public JButton prev = new JButton("Prev");
    public JButton next = new JButton("Next");
    public JButton last = new JButton("Last");
    public JCheckBoxMenuItem jcbMi = new JCheckBoxMenuItem("Flip Board");
    public JMenuBar menuBar = new JMenuBar();
    public CB cbo;
    public MyJToggleButtonUI jtb[];
    public MyJToggleButtonUI prevButSel;
    public int noOfButSelected = 0;
    public String whoseTurn = WHITE;
    private boolean highlight = true;
    //public EachPGNGame eachGame = null;
    //public AllPGNGames allGames = null;
    //private String turn = null;
    public int currentMoveNo = 0;
    public int currentGameNo = 0;
    public ArrayList gameList = new ArrayList();
    public Game game = null;
    public GamesPanelUI gamesPanelUI = null;
    public LogData log = null;
    public JToolBar toolBar = new JToolBar();
    public JButton toolBarButtonOpen = new JButton();
    public JButton toolBarButtonSaveAsPGN = new JButton();
    public JButton toolBarButtonSaveAsFEN = new JButton();

    public static void main(String args[]) throws IOException {
        new ChessBoardJFrameUI();
    }

    public ChessBoardJFrameUI() throws IOException {
        cbo = new CB();

        currentGameNo++;
        game = new Game(cbo, currentGameNo, true);
        gameList.add(game);

        gamesPanelUI = new GamesPanelUI(this);
        setJMenuBar(createMenuBar());


        mainP.add(processCenterPanel(), BorderLayout.CENTER);
        mainP.add(nP, BorderLayout.NORTH);
        mainP.add(processSouthPanel(), BorderLayout.SOUTH);
        mainP.add(processEastPanel(), BorderLayout.EAST);
        mainP.add(processWestPanel(), BorderLayout.WEST);

        //nP.add(createToolBar());

        setContentPane(mainP);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addWindowListener(this);
        setSize(760, 760);
        //Display the window.
        setVisible(true);
        setResizable(false);
        setTitle(TITLE);

        resetChessBoardUI(false);

        first.addActionListener(this);
        prev.addActionListener(this);
        next.addActionListener(this);
        last.addActionListener(this);

        ImageIcon imageIcon16 = new ImageIcon(ChessBoardJFrameUI.class.getClassLoader().getResource(APPICON));
        setIconImage(imageIcon16.getImage());
        //setIconImage(new ImageIcon(ChessBoardJFrameUI.class.getClassLoader().getResource(APPICON)));

        log = new LogData(this);

        log.logLine("*****************************************************************");
        log.logLine("\t\t" + TITLE);
        log.logLine("   Copyright (C) 2009  Suhas Bharadwaj (srbharadwaj@gmail.com)");
        log.logLine("*****************************************************************");

        log.logLine("*****************************************************************", Level.CONFIG);
        log.logLine("\t\t" + TITLE, Level.CONFIG);
        log.logLine("   Copyright (C) 2009  Suhas Bharadwaj (srbharadwaj@gmail.com)", Level.CONFIG);
        log.logLine("*****************************************************************", Level.CONFIG);


    }

    public void resetChessBoardUI(boolean b) {
        if (b) {
            processCenterPanel();
            txtAreaMoves.setText("");
        }
        prevButSel = null;
        noOfButSelected = 0;
        whoseTurn = WHITE;
        //highlight = true;
        //eachGame = null;
        //turn = null;
        //currentMoveNo = 0;
        assignCps();
    }

    public JPanel processCenterPanel() {
        cP.removeAll();
        cP.revalidate();
        cP.add(resetChessContainerUI(), BorderLayout.CENTER);
        cP.add(createButPanel(), BorderLayout.SOUTH);

        return cP;
    }

    public JPanel processSouthPanel() {
        sP.removeAll();
        sP.revalidate();
        JScrollPane jScrollPane2 = new JScrollPane();
        jScrollPane2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Log"));

        txtAreaLog.setColumns(20);
        txtAreaLog.setEditable(false);
        txtAreaLog.setLineWrap(true);
        txtAreaLog.setRows(5);
        txtAreaLog.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txtAreaLog);

        sP.add(jScrollPane2);

        return sP;

    }

    public JPanel processEastPanel() {
        eP.removeAll();
        eP.revalidate();
        JSplitPane jSplitPane1 = new JSplitPane();
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        JScrollPane jpMoves = new JScrollPane();
        jpMoves.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Moves"));

        txtAreaMoves.setColumns(15);
        txtAreaMoves.setFont(new java.awt.Font("Monospaced", 0, 12));
        txtAreaMoves.setEditable(false);
        txtAreaMoves.setLineWrap(true);
        txtAreaMoves.setWrapStyleWord(true);
        jpMoves.setViewportView(txtAreaMoves);

        JScrollPane jpGames = new JScrollPane();
        jpGames.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Games"));
        jpGames.setViewportView(gamesPanelUI);

        jSplitPane1.setTopComponent(jpGames);
        jSplitPane1.setBottomComponent(jpMoves);

        eP.add(jSplitPane1);

        return eP;

    }

    public JPanel processWestPanel() {
        wP.removeAll();
        wP.revalidate();
        /* wP.setLayout(new GridLayout(2,1));
        //JScrollPane jpGames = new JScrollPane();
        //jpGames.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Captured Pieces"));
        wP.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Captured Pieces"));
        wP.add(whiteCapPanel);
        wP.add(blackCapPanel);

        //wP.add(jpGames);
         */
        return (wP);

    }

    public JToolBar createToolBar() {
        toolBarButtonOpen.setIcon(new ImageIcon(getClass().getResource(openicon)));
        //toolBarButtonOpen.setText("open");
        toolBarButtonOpen.addActionListener(this);
        toolBar.add(toolBarButtonOpen);
        toolBar.setFloatable(false);
        return toolBar;
    }

    public JMenuBar createMenuBar() {

        JMenu menuOpt = new JMenu("File");
        menuOpt.setMnemonic(KeyEvent.VK_F);

        JMenuItem miO = new JMenuItem(OPEN);
        miO.setIcon(new ImageIcon(getClass().getResource(openicon)));
        miO.setMnemonic(KeyEvent.VK_L);
        miO.addActionListener(this);

        JMenuItem miS = new JMenuItem(SAVE_AS_PGN);
        miS.setMnemonic(KeyEvent.VK_P);
        miS.addActionListener(this);

        JMenuItem miS_FEN = new JMenuItem(SAVE_AS_FEN);
        miS_FEN.setMnemonic(KeyEvent.VK_F);
        miS_FEN.addActionListener(this);

        JSeparator js0 = new JSeparator();
        JSeparator js1 = new JSeparator();
        JSeparator js2 = new JSeparator();

        JMenuItem miE = new JMenuItem(EXIT);
        miE.setMnemonic(KeyEvent.VK_E);
        miE.addActionListener(this);

        menuOpt.add(miO);
        menuOpt.add(miS);
        menuOpt.add(miS_FEN);
        menuOpt.add(js0);

        //  menuItemLocateEngine = new JMenuItem("Locate Chess Engine");
        // menuItemLocateEngine.addActionListener(new LocateEngineListener());
        // menuOpt.add(menuItemLocateEngine);
    /*  menuItemEngine = new JMenu("Chess Engine");
        menuOpt.add(menuItemEngine);
        engineGroup = new ButtonGroup();
        menuItemEngineOff = new JRadioButtonMenuItem("Off");
        menuItemEngineOff.setSelected(true);
        menuItemEngineOff.addActionListener(new EngineOffListener());
        engineGroup.add(menuItemEngineOff);
        menuItemEngine.add(menuItemEngineOff);
        menuItemEngineOn = new JRadioButtonMenuItem("On");
        menuItemEngineOn.addActionListener(new EngineOnListener(this));
        engineGroup.add(menuItemEngineOn);
        menuItemEngine.add(menuItemEngineOn);
        menuOpt.add(js1);*/
        menuOpt.add(miE);
        menuBar.add(menuOpt);

        JMenu menuGame = new JMenu("Game");
        menuGame.setMnemonic(KeyEvent.VK_G);
        menuBar.add(menuGame);

        JMenuItem menuItemNew = new JMenuItem(NEW);
        menuItemNew.setIcon(new ImageIcon(getClass().getResource(addicon)));
        menuItemNew.setMnemonic(KeyEvent.VK_N);
        menuItemNew.addActionListener(this);
        menuGame.add(menuItemNew);

        JMenuItem menuItemRemove = new JMenuItem(REMOVE);
        menuItemRemove.setIcon(new ImageIcon(getClass().getResource(delicon)));
        menuItemRemove.setMnemonic(KeyEvent.VK_R);
        menuItemRemove.addActionListener(this);
        menuGame.add(menuItemRemove);
        JSeparator js3 = new JSeparator();
        menuGame.add(js3);
        JMenuItem menuEditTags = new JMenuItem(EDITTAGS);
        menuEditTags.setMnemonic(KeyEvent.VK_E);
        menuEditTags.addActionListener(this);
        menuGame.add(menuEditTags);
        JSeparator js4 = new JSeparator();
        menuGame.add(js4);
        JMenuItem menuItemWhiteWin = new JMenuItem(WHITEWIN);
        menuItemWhiteWin.addActionListener(this);
        menuGame.add(menuItemWhiteWin);
        JMenuItem menuItemDraw = new JMenuItem(DRAW);
        menuItemDraw.addActionListener(this);
        menuGame.add(menuItemDraw);
        JMenuItem menuItemBlackWin = new JMenuItem(BLACKWIN);
        menuItemBlackWin.addActionListener(this);
        menuGame.add(menuItemBlackWin);
        JMenuItem menuItemIncomplete = new JMenuItem(INCOMPLETEGAME);
        //menuItemIncomplete.addActionListener(new IncompleteMenuListener());
        menuGame.add(menuItemIncomplete);

        JMenuItem miP = new JMenuItem(SETUP);
        miP.setMnemonic(KeyEvent.VK_P);
        miP.addActionListener(this);
        menuGame.add(js2);
        menuGame.add(miP);

        JMenu menuOptions = new JMenu("Options");
        menuOptions.setMnemonic(KeyEvent.VK_O);
        JCheckBoxMenuItem jcbM = new JCheckBoxMenuItem("HighLight Possible Moves");
        jcbM.setSelected(true);
        menuOptions.add(jcbMi);
        menuOptions.add(jcbM);
        jcbMi.addItemListener(this);
        jcbM.addItemListener(this);
        menuBar.add(menuOptions);

        JMenu menuH = new JMenu("Help");
        menuH.setMnemonic(KeyEvent.VK_H);
        JMenuItem miHelp = new JMenuItem("Help Contents");
        miHelp.setIcon(new ImageIcon(getClass().getResource(helpicon)));
        miHelp.addActionListener(this);

        JMenuItem miAbout = new JMenuItem(ABOUT);
        miAbout.setIcon(new ImageIcon(getClass().getResource(abouticon)));
        miAbout.addActionListener(this);

        menuH.add(miHelp);
        menuH.add(miAbout);

        menuBar.add(menuH);
        return menuBar;
    }

    public String getFEN_Pawns() {
        String s = "";
        String str = "";
        int blank = 0;
        for (int i = 0; i < 64; i++) {
            if ((i % 8 == 0) && (i != 0)) {
                if (blank != 0) {
                    s = s + blank + "/";
                } else {
                    s = s + "/";
                }
                blank = 0;
            }

            CP p = jtb[i].getChessp();
            if (p == null) {
                blank++;
            } else if (p.getPieceName().equals(PAWN)) {
                str = "P";
            } else if (p.getPieceName().equals(ROOK)) {
                str = "R";
            } else if (p.getPieceName().equals(KNIGHT)) {
                str = "N";
            } else if (p.getPieceName().equals(BISHOP)) {
                str = "B";
            } else if (p.getPieceName().equals(QUEEN)) {
                str = "Q";
            } else if (p.getPieceName().equals(KING)) {
                str = "K";
            }


            if ((p != null) && (p.getPieceColor().equals(BLACK))) {
                if (blank != 0) {
                    s = s + blank;
                }
                str = str.toLowerCase();
                s = s + str;
                blank = 0;
            } else if ((p != null) && (p.getPieceColor().equals(WHITE))) {
                if (blank != 0) {
                    s = s + blank;
                }
                s = s + str;
                blank = 0;
            }
            if ((blank != 0) && (i == 63)) {
                s = s + blank;
                blank = 0;
            }
        }
        return s;
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
        //System.out.println(("closing");
        stopEngine();

    }

    public void windowClosed(WindowEvent e) {
        //System.out.println(("closed");
    }

    class LocateEngineListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            locateEngine();
        }
    }

    class EngineOffListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            stopEngine();
        }
    }

    class EngineOnListener implements ActionListener {

        ChessBoardJFrameUI a;

        private EngineOnListener(ChessBoardJFrameUI aThis) {
            a = aThis;
        }

        public void actionPerformed(ActionEvent e) {
            if (engineProcess == null) {
                if (engineFileName == null) {
                    locateEngine();
                }
                if (engineFileName.equals("")) {
                    return;
                }
                engineProcess =
                        new EngineProcess(a, engineFileName);
                engineProcess.runEngine();
                engineProcess.talkToEngine("log off");
                engineProcess.talkToEngine("noise 1000");
                engineProcess.talkToEngine("xboard");
                //engineProcess.talkToEngine("force");
                engineProcess.talkToEngine("post");
                engineProcess.talkToEngine("analyze");
                //engineProcess.talkToEngine("e4");

            }
        }
    }

    private void locateEngine() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        //fileChooser.resetChoosableFileFilters();
        //fileChooser.addChoosableFileFilter(new PGNFileFilter());

        //JFileChooser fileChooser = new JFileChooser(fileName);
        //fileChooser.setFileFilter(new PGNFileFilter());
        //fileChooser.setDialogTitle(title);

        int choice = fileChooser.showOpenDialog(this);
        fileChooser.setDialogTitle("Locate Engine");
        if (choice == JFileChooser.APPROVE_OPTION) {

            //System.out.println((fileChooser.getSelectedFile().toString());
            this.engineFileName = fileChooser.getSelectedFile().toString();
        }
        /* if (fileChooserParameter("engineFileName", "Locate Engine", null)) {
        String fileName = (String)parameter.get("engineFileName");
        if (!fileName.endsWith(".exe")) { // ???? not OS agnostic
        FileIO.getInstance().alert(this, fileName + " not executable");
        parameter.put("engineFileName", "");
        }
        file.saveParameters("chesseditor.ini", parameter);
        }*/
    }

    private void stopEngine() {
        if (engineProcess != null) {
            engineProcess.stopEngine();
            engineProcess = null;
        }
    }

    public JPanel resetChessContainerUI() {
        chessBoardContainer.removeAll();
        chessBoardContainer.revalidate();
        chessBoard.removeAll();
        chessBoard.revalidate();
        jtb = new MyJToggleButtonUI[64];
        int c = 0;
        int counter = 0;
        int mtbVal = 81;
        for (int i = 0; i < 64; i++) {
            jtb[i] = new MyJToggleButtonUI(this);
            jtb[i].setText("");
            jtb[i].setValue(mtbVal);
            if (i % 2 == c) {
                //light
                jtb[i].setLightBgColor();
            } else {
                //dark
                jtb[i].setDarkBgColor();
            }
            counter++;
            if (counter == 8) {
                if (c == 0) {
                    c = 1;
                } else {
                    c = 0;
                }
                counter = 0;
                mtbVal = mtbVal - 17;
            } else {
                mtbVal++;
            }
            chessBoard.add(jtb[i]);
        }

        setPieceUI();
        chessBoardContainer.add(chessBoard, BorderLayout.CENTER);
        chessBoardContainer.add(addA_Hpanel(true), BorderLayout.PAGE_START);
        chessBoardContainer.add(addA_Hpanel(true), BorderLayout.PAGE_END);
        chessBoardContainer.add(add1_8panel(true), BorderLayout.LINE_START);
        chessBoardContainer.add(add1_8panel(true), BorderLayout.LINE_END);

        return chessBoardContainer;
    }

    public JPanel addA_Hpanel(Boolean straight) {

        JPanel jpN = new JPanel(new GridBagLayout());

        GridBagConstraints gbc100 = new GridBagConstraints();
        gbc100.fill = GridBagConstraints.HORIZONTAL;
        gbc100.ipadx = -9;
        gbc100.gridx = 0;
        gbc100.gridy = 0;

        GridBagConstraints gbc101 = new GridBagConstraints();
        gbc101.fill = GridBagConstraints.HORIZONTAL;
        gbc101.ipadx = -9;
        gbc101.gridx = 9;
        gbc101.gridy = 0;

        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.fill = GridBagConstraints.HORIZONTAL;
        gbc1.ipadx = 20;
        gbc1.gridx = 1;
        gbc1.gridy = 0;

        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.fill = GridBagConstraints.HORIZONTAL;
        gbc2.ipadx = 20;
        gbc2.gridx = 2;
        gbc2.gridy = 0;

        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.fill = GridBagConstraints.HORIZONTAL;
        gbc3.ipadx = 20;
        gbc3.gridx = 3;
        gbc3.gridy = 0;

        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.fill = GridBagConstraints.HORIZONTAL;
        gbc4.ipadx = 20;
        gbc4.gridx = 4;
        gbc4.gridy = 0;

        GridBagConstraints gbc5 = new GridBagConstraints();
        gbc5.fill = GridBagConstraints.HORIZONTAL;
        gbc5.ipadx = 20;
        gbc5.gridx = 5;
        gbc5.gridy = 0;

        GridBagConstraints gbc6 = new GridBagConstraints();
        gbc6.fill = GridBagConstraints.HORIZONTAL;
        gbc6.ipadx = 20;
        gbc6.gridx = 6;
        gbc6.gridy = 0;

        GridBagConstraints gbc7 = new GridBagConstraints();
        gbc7.fill = GridBagConstraints.HORIZONTAL;
        gbc7.ipadx = 20;
        gbc7.gridx = 7;
        gbc7.gridy = 0;

        GridBagConstraints gbc8 = new GridBagConstraints();
        gbc8.fill = GridBagConstraints.HORIZONTAL;
        gbc8.ipadx = 20;
        gbc8.gridx = 8;
        gbc8.gridy = 0;

        GridBagConstraints gbc9 = new GridBagConstraints();
        gbc9.fill = GridBagConstraints.HORIZONTAL;
        gbc9.ipadx = -10;
        gbc9.gridx = 0;
        gbc9.gridy = 0;

        JButton l100 = new JButton();
        l100.setIcon(new ImageIcon(getClass().getResource(REVERSE)));
        l100.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (jcbMi.isSelected()) {
                    jcbMi.setSelected(false);
                } else {
                    jcbMi.setSelected(true);
                }
            }
        });
        JButton l101 = new JButton();
        l101.setIcon(new ImageIcon(getClass().getResource(REVERSE)));
        l101.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (jcbMi.isSelected()) {
                    jcbMi.setSelected(false);
                } else {
                    jcbMi.setSelected(true);
                }
            }
        });
        JToggleButton l1 = new JToggleButton("a");
        JToggleButton l2 = new JToggleButton("b");
        JToggleButton l3 = new JToggleButton("c");
        JToggleButton l4 = new JToggleButton("d");
        JToggleButton l5 = new JToggleButton("e");
        JToggleButton l6 = new JToggleButton("f");
        JToggleButton l7 = new JToggleButton("g");
        JToggleButton l8 = new JToggleButton("h");

        l1.setEnabled(false);
        l2.setEnabled(false);
        l3.setEnabled(false);
        l4.setEnabled(false);
        l5.setEnabled(false);
        l6.setEnabled(false);
        l7.setEnabled(false);
        l8.setEnabled(false);

        if (straight) {
            jpN.add(l100, gbc100);
            jpN.add(l1, gbc1);
            jpN.add(l2, gbc2);
            jpN.add(l3, gbc3);
            jpN.add(l4, gbc4);
            jpN.add(l5, gbc5);
            jpN.add(l6, gbc6);
            jpN.add(l7, gbc7);
            jpN.add(l8, gbc8);
            jpN.add(l101, gbc101);
        } else {
            jpN.add(l100, gbc101);
            jpN.add(l8, gbc1);
            jpN.add(l7, gbc2);
            jpN.add(l6, gbc3);
            jpN.add(l5, gbc4);
            jpN.add(l4, gbc5);
            jpN.add(l3, gbc6);
            jpN.add(l2, gbc7);
            jpN.add(l1, gbc8);
            jpN.add(l101, gbc100);
        }

        return jpN;

    }

    public JPanel add1_8panel(Boolean straight) {

        JPanel jpN = new JPanel();
        jpN.setLayout(new GridLayout(8, 1));

        MyJToggleButtonUI l1 = new MyJToggleButtonUI("1");
        MyJToggleButtonUI l2 = new MyJToggleButtonUI("2");
        MyJToggleButtonUI l3 = new MyJToggleButtonUI("3");
        MyJToggleButtonUI l4 = new MyJToggleButtonUI("4");
        MyJToggleButtonUI l5 = new MyJToggleButtonUI("5");
        MyJToggleButtonUI l6 = new MyJToggleButtonUI("6");
        MyJToggleButtonUI l7 = new MyJToggleButtonUI("7");
        MyJToggleButtonUI l8 = new MyJToggleButtonUI("8");

        l1.setEnabled(false);
        l2.setEnabled(false);
        l3.setEnabled(false);
        l4.setEnabled(false);
        l5.setEnabled(false);
        l6.setEnabled(false);
        l7.setEnabled(false);
        l8.setEnabled(false);

        if (!straight) {
            jpN.add(l1);
            jpN.add(l2);
            jpN.add(l3);
            jpN.add(l4);
            jpN.add(l5);
            jpN.add(l6);
            jpN.add(l7);
            jpN.add(l8);
        } else {
            jpN.add(l8);
            jpN.add(l7);
            jpN.add(l6);
            jpN.add(l5);
            jpN.add(l4);
            jpN.add(l3);
            jpN.add(l2);
            jpN.add(l1);
        }

        return jpN;

    }

    private JPanel createButPanel() {
        butJPanel.removeAll();
        butJPanel.revalidate();

        first.setIcon(new ImageIcon(getClass().getResource(START)));
        prev.setIcon(new ImageIcon(getClass().getResource(PREV)));
        next.setIcon(new ImageIcon(getClass().getResource(NEXT)));
        last.setIcon(new ImageIcon(getClass().getResource(LAST)));

        butJPanel.add(first);
        butJPanel.add(prev);
        butJPanel.add(next);
        butJPanel.add(last);

        return butJPanel;
    }

    public void loadGame(Game g) {
        currentMoveNo = 0;
        cbo.resetCB();
        resetChessBoardUI(true);
        setPieceUI();
    }

    public void setHighlightValue(boolean b) {
        highlight = b;
    }

    public void assignCps() {
        for (int i = 0; i < cbo.allPieces.size(); i++) {
            CP cp1 = (CP) cbo.allPieces.get(i);
            for (int j = 0; j < 64; j++) {
                if (jtb[j].getValue() == cp1.getInitialPosition()) {
                    jtb[j].setChessp(cp1);
                    break;
                }
            }
        }
    }

    public void ButtonSelected(MyJToggleButtonUI newButSel) {
        noOfButSelected++;

        /*  chk whose turn is it
        the selected button's chessp's color must be same else deselect that button
         */
        //one movePGNString done
        if (noOfButSelected == 1) {
            try {
                if (newButSel.getChessp().getPieceColor().equals(whoseTurn)) {
                    //System.out.println(("Good its a "+ whoseTurn +" piece");
                    prevButSel = newButSel;
                    if (highlight) {
                        HighlightPossibleMoves(newButSel.getChessp());
                    }
                } else {
                    //System.out.println(("Its not a "+whoseTurn+" piece");
                    newButSel.setSelected(false);
                }
            } catch (NullPointerException npe) {
                //System.out.println(("Its not a "+whoseTurn+" piece");
                newButSel.setSelected(false);
            }
        }

        //two moves done
        if (noOfButSelected == 2) {
            makeMove(newButSel, prevButSel, null);
        }

    }

    public void ButtonDeSelected(MyJToggleButtonUI jtbut) {
        noOfButSelected--;
        if (highlight) {
            undoHighlightPossibleMoves();
        }
    }

    public void HighlightPossibleMoves(CP p) {
        for (int i = 0; i < p.movesPossible.size(); i++) {
            for (int j = 0; j < 64; j++) {
                if (jtb[j].getValue() == p.movesPossible.get(i)) {
                    jtb[j].setBackground(cHighlight);
                    break;
                }
            }
        }
    }

    public void undoHighlightPossibleMoves() {
        for (int j = 0; j < 64; j++) {
            jtb[j].setDefaultBgColor();
        }
    }

    private String chkIfPawnPromoted(MyJToggleButtonUI but) {
        CP pi = but.getChessp();
        //System.out.println((pi.getPieceName());
        //System.out.println((pi.getCurrentPosition()/10);
        if ((pi.getPieceName().equals(PAWN)) && (pi.getCurrentPosition() > 80) && (pi.getCurrentPosition() < 89)) {
            //System.out.println(("Yes promote white pawn at "+pi.getCurrentPosition());
            PawnPromoDialogUI dia = new PawnPromoDialogUI(this, true, WHITE);
            dia.setVisible(true);
            //System.out.println(("selected is : "+ dia.selectedPiece);
            processPromotedPawn(but, dia.selectedPiece, WHITE);
            return dia.selectedPiece;
        } else if ((pi.getPieceName().equals(PAWN)) && (pi.getCurrentPosition() > 10) && (pi.getCurrentPosition() < 19)) {
            //System.out.println(("Yes promote black pawn at "+pi.getCurrentPosition());
            PawnPromoDialogUI dia = new PawnPromoDialogUI(this, true, BLACK);
            dia.setVisible(true);
            //System.out.println(("selected is : "+ dia.selectedPiece);
            processPromotedPawn(but, dia.selectedPiece, BLACK);
            return dia.selectedPiece;
        }
        return null;
    }

    public void processPromotedPawn(MyJToggleButtonUI but, String piecename, String col) {
        //cbo.allPieces.removeElement(but.getChessp());
        cbo.allPieces.remove(but.getChessp());
        CP pPromo = new CP(this.cbo, piecename, col, but.getChessp().getCurrentPosition());
        cbo.allPieces.add(pPromo);
    }

    public boolean isEnPassentAttempted(CP oldCP, int newposition) {
        if (oldCP.getPieceName().equals(PAWN)) {
            if (cbo.isCurPosOfSomePiece(newposition) == null) {
                int oldCPCurPos = oldCP.getCurrentPosition();
                int i = newposition - oldCPCurPos;
                //11,9,-11,-9
                if (i == 11) {
                    completeEnPassentMove(oldCP.getCurrentPosition(), newposition, oldCPCurPos + 1);
                    return true;
                } else if (i == 9) {
                    completeEnPassentMove(oldCP.getCurrentPosition(), newposition, oldCPCurPos - 1);
                    return true;
                } else if (i == -11) {
                    completeEnPassentMove(oldCP.getCurrentPosition(), newposition, oldCPCurPos - 1);
                    return true;
                } else if (i == -9) {
                    completeEnPassentMove(oldCP.getCurrentPosition(), newposition, oldCPCurPos + 1);
                    return true;
                }
            }
        } else {
            return false;
        }

        return false;
    }

    public void completeEnPassentMove(int currentPosition, int newposition, int captureButPos) {
        int butCurPos = currentPosition;
        int butNewPos = newposition;
        int capButPos = captureButPos;

        //System.out.println((butCurPos+" "+butNewPos+ " "+capButPos);
        MyJToggleButtonUI mjtbbutCurPos = null;
        MyJToggleButtonUI mjtbbutNewPos = null;
        MyJToggleButtonUI mjtbcapButPos = null;

        for (int i = 0; i < jtb.length; i++) {
            int curpos = jtb[i].getValue();

            if (curpos == butCurPos) {
                mjtbbutCurPos = jtb[i];
            } else if (curpos == butNewPos) {
                mjtbbutNewPos = jtb[i];
            } else if (curpos == capButPos) {
                mjtbcapButPos = jtb[i];
            }
        }

        //set the chesspiece of the buttons accordingly
        //but before setting the chesspiece for the enpassented/captured button
        //process the enpassented/captured piece
        CP p1 = mjtbcapButPos.getChessp();
        processCapturedPiece(p1);

        ///
        mjtbbutCurPos.getChessp().setCurrentPosition(newposition);
    }

    public String isCastlingAttempted(CP oldCP, int newposition) {
        //castleWhichSide = null;
        if (oldCP.getPieceName().equals(KING)) {
            int i = newposition - oldCP.getCurrentPosition();

            if (i == 2) {
                completeCastlingMove(oldCP.getCurrentPosition(), "kingside");
                //castleWhichSide = "KS";
                //return true;
                //System.out.println(("Castling done");
                return "KS";
            } else if (i == -2) {
                completeCastlingMove(oldCP.getCurrentPosition(), "queenside");
                //castleWhichSide = "QS";
                //return true;
                return "QS";
            } else {
                //return false;
                return null;
            }
        } else {
            //return false;
            return null;
        }
    }

    private void completeCastlingMove(int curPos, String whichSide) {
        int kCurrPos = 0;
        int rCurrPos = 0;
        int newkCurrPos = 0;
        int newrCurrPos = 0;

        MyJToggleButtonUI kCurBut = null;
        MyJToggleButtonUI rCurBut = null;

        if (whichSide.equals("kingside")) {
            kCurrPos = curPos;
            rCurrPos = curPos + 3;
            newkCurrPos = curPos + 2;
            newrCurrPos = curPos + 1;
        } else {
            kCurrPos = curPos;
            rCurrPos = curPos - 4;
            newkCurrPos = curPos - 2;
            newrCurrPos = curPos - 1;
        }

        for (int i = 0; i < jtb.length; i++) {
            int curpos = jtb[i].getValue();

            if (curpos == kCurrPos) {
                kCurBut = jtb[i];
            } else if (curpos == rCurrPos) {
                rCurBut = jtb[i];
            }
        }
        ///
        kCurBut.getChessp().setCurrentPosition(newkCurrPos);
        rCurBut.getChessp().setCurrentPosition(newrCurrPos);
        ///
    }

    private void processCapturedPiece(CP p) {
        //yes piece is captured
        p.setCapturedFlag(true);
        cbo.capturedPieces.add(p);
        //cbo.allPieces.removeElement(p);
        cbo.allPieces.remove(p);
    }

    public void makeMove(MyJToggleButtonUI newBut, MyJToggleButtonUI prevBut, ArrayList v) {
        /*
         * The format in data has to be fetched is
         * [ color(B/W),
         *   name(P/R/N/B/Q/K),
         *   fPos(11-88)
         *   tPos(11-88)
         *   cap(T/F),
         *   castle(KS/QS/null),
         *   chk(C/CM/null)
         *   promo(R/N/B/Q/null)
         * ]
         *
         */
        String col = null;
        String name = null;
        int fPos = -1;
        int tPos = -1;
        boolean cap = false;
        String castle = null;
        String check = null;
        String promo = null;

        boolean chk = false;
        int newpos = newBut.getValue();
        CP prevButCP = prevBut.getChessp();

        col = prevButCP.getPieceColor();
        name = prevButCP.getPieceName();
        fPos = prevButCP.getCurrentPosition();
        tPos = newpos;


        if (prevButCP.isMovePossible(newpos)) {
            currentMoveNo++;
            //System.out.println(("Can be moved");
            cbo.allMoves.add(newpos);

            //chk if castling attempted
            castle = isCastlingAttempted(prevButCP, newpos);
            if (castle != null) {
            } //chk if enpassent attempted
            else if (isEnPassentAttempted(prevButCP, newpos)) {
                cap = true;
                //System.out.println(("EnPassent done");
            } else {
                // if pice is captured
                //remove tht piece from 'allPieces'
                //add tht piece to 'capturedPieces'
                CP cpCap = cbo.isCurPosOfSomePiece(newpos);
                if (cpCap != null) {
                    cap = true;
                    processCapturedPiece(cpCap);
                }

                prevButCP.movesDone.add(newpos);
                prevButCP.setCurrentPosition(newpos);

                if (v == null) {
                    //chk pawn promo
                    promo = chkIfPawnPromoted(prevBut);
                } else if (v.get(8) != null) {
                    processPromotedPawn(prevBut, (String) v.get(8), prevBut.getChessp().getPieceColor());
                }
            }

            //change 'whoseturn'
            if (whoseTurn.equals(WHITE)) {
                whoseTurn = BLACK;
            } else {
                whoseTurn = WHITE;
            }

            //movePGNString done
            //so claculate all possible moves again
            //New
            cbo.calculateMoves(whoseTurn);

            if (cbo.isKingInCheck(whoseTurn)) {
                //System.out.println((whoseTurn + " IS IN CHECK");
                if (v == null) {
                    chk = true;
                    check = "C";
                }
            } else {
                cbo.calculateIfCastlingIsPossible();
            }

            //cbo.printAll();
            if (v == null) {
                if (chk) {
                    //if it return true then chkmate
                    if (isCheckMate(whoseTurn)) {
                        //System.out.println(("CHECKMATE..."+whoseTurn+" loses");
                        check = "CM";
                    }
                } else {
                    //if it returns true then stalemate
                    if (isCheckMate(whoseTurn)) {
                        //System.out.println(("STALEMATE... its a draw");
                        check = "SM";
                    }
                }
            }

            String m = calculatePGNMovesFromGUIMoves(col, name, fPos, tPos, cap, castle, check, promo);
            //System.out.println(("Move is : "+ m );
            //txtAreaMoves.append(m);
            appendMoves(m);
            game.addMove(currentMoveNo, m);
            game.gameResult = "*";
            if (col.equals(BLACK)) {
                txtAreaMoves.append("\n");
            }

            if (v == null) {
                if (check != null) {
                    if (check.equals("SM")) {
                        //stalemate - draw
                        itsADraw();
                    } else if (check.equals("CM")) {
                        if (whoseTurn.equals(WHITE)) {
                            //white loses
                            blackWins();
                        } else {
                            //black loses
                            whiteWins();
                        }
                    }
                }
            }
            ///
            //change UI
            setPieceUI();
            ///

            if (v == null) {
                String s = txtAreaMoves.getText();
                if (s.contains("1/2-1/2")) {
                    JOptionPane.showMessageDialog(this, "STALEMATE...!!! its a draw", "Game Over...", JOptionPane.INFORMATION_MESSAGE);
                } else if (s.contains("0-1")) {
                    JOptionPane.showMessageDialog(this, "CHECKMATE...!!!\nBlack Wins!!!", "Game Over...", JOptionPane.INFORMATION_MESSAGE);
                } else if (s.contains("1-0")) {
                    JOptionPane.showMessageDialog(this, "CHECKMATE...\nWhite Wins!!!", "Game Over...", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } else {
            //System.out.println(("Its not a valid move");
            newBut.setSelected(false);
            prevBut.setSelected(false);
        }
    }

    private void blackWins() {
        txtAreaMoves.append(" 0-1");
        game.setGameResult("0-1");
        gamesPanelUI.updateGamesPanelUI(gameList);
        //JOptionPane.showMessageDialog(this,"CheckMate...\nBlack Wins!!!","Game Over...",JOptionPane.INFORMATION_MESSAGE);
    }

    private void whiteWins() {
        txtAreaMoves.append(" 1-0");
        game.setGameResult("1-0");
        gamesPanelUI.updateGamesPanelUI(gameList);
        //JOptionPane.showMessageDialog(this,"CheckMate...\nWhite Wins!!!","Game Over...",JOptionPane.INFORMATION_MESSAGE);
    }

    private void itsADraw() {
        txtAreaMoves.append(" 1/2-1/2");
        game.setGameResult("1/2-1/2");
        gamesPanelUI.updateGamesPanelUI(gameList);
        //JOptionPane.showMessageDialog(this,"StaleMate.. its a draw","Game Over...",JOptionPane.INFORMATION_MESSAGE);
    }

    private void reverseBoard(String col) {
        chessBoardContainer.removeAll();
        chessBoardContainer.revalidate();

        if (col.equals(BLACK)) {
            chessBoard.removeAll();
            chessBoard.revalidate();
            for (int i = 63; i >= 0; i--) {
                chessBoard.add(jtb[i]);
            }
            chessBoardContainer.add(addA_Hpanel(false), BorderLayout.PAGE_START);
            chessBoardContainer.add(addA_Hpanel(false), BorderLayout.PAGE_END);
            chessBoardContainer.add(add1_8panel(false), BorderLayout.LINE_START);
            chessBoardContainer.add(add1_8panel(false), BorderLayout.LINE_END);
        } else {
            chessBoard.removeAll();
            chessBoard.revalidate();
            for (int i = 0; i < 64; i++) {
                chessBoard.add(jtb[i]);
            }
            chessBoardContainer.add(addA_Hpanel(true), BorderLayout.PAGE_START);
            chessBoardContainer.add(addA_Hpanel(true), BorderLayout.PAGE_END);
            chessBoardContainer.add(add1_8panel(true), BorderLayout.LINE_START);
            chessBoardContainer.add(add1_8panel(true), BorderLayout.LINE_END);
        }
        chessBoard.repaint();

        chessBoardContainer.add(chessBoard, BorderLayout.CENTER);
        chessBoardContainer.repaint();

    }

    public boolean isCheckMate(String col) {
        for (int i = 0; i < cbo.allPieces.size(); i++) {
            CP c = (CP) cbo.allPieces.get(i);
            if (col.equals(c.getPieceColor())) {
                if (c.movesPossible.size() > 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public String calculatePGNMovesFromGUIMoves(String col, String name, int fPos, int tPos, Boolean cap, String castle, String chk, String promo) {
        /*
         * The format is
         * [ color(B/W),
         *   name(P/R/N/B/Q/K),
         *   fPos(11-88)
         *   tPos(11-88)
         *   cap(T/F),
         *   castle(KS/QS/null),
         *   chk(C/CM/SM/null)
         *   promo(R/N/B/Q/null)
         * ]
         *
         */
        //AllPGNGames convertPGNMoveToGUIFormat = new AllPGNGames(this,null);

        //System.out.println(("col is : "+ col +"name is : "+ name +"fPos is : "+ fPos +"tPos is : "+ tPos +"cap is : "+ cap +"castle is : "+ castle +"chk is : "+ chk +"promo is : "+ promo);
        String s = "";
        if (col.equals(WHITE)) {
            int movno = (cbo.allMoves.size() / 2) + 1;
            if (movno < 10) {
                s = s + movno + ".  ";
            } else {
                s = s + movno + ". ";
            }
        } else {
            s = s + "  ";
        }
        if (castle != null) {
            if (castle.equals("KS")) {
                s = s + "O-O";
                if (chk != null) {
                    if (chk.equals("C")) {
                        s = s + "+";
                    } else if (chk.equals("CM")) {
                        s = s + "#";
                    }
                }
            } else if (castle.equals("QS")) {
                s = s + "O-O-O";
                if (chk != null) {
                    if (chk.equals("C")) {
                        s = s + "+";
                    } else if (chk.equals("CM")) {
                        s = s + "#";
                    }
                }
            }
            return s;
        }

        if (promo != null) {
            if (cap) {
                s = s + convertNumValToAlphaCol(fPos % 10) + "x" + convertNumValToAlphaCol(tPos % 10) + (tPos / 10) + "=";
            } else {
                s = s + convertNumValToAlphaCol(tPos % 10) + (tPos / 10) + "=";
            }
            if (promo.equals(QUEEN)) {
                s = s + "Q";
            } else if (promo.equals(ROOK)) {
                s = s + "R";
            } else if (promo.equals(KNIGHT)) {
                s = s + "N";
            } else if (promo.equals(BISHOP)) {
                s = s + "B";
            }

            if (chk != null) {
                if (chk.equals("C")) {
                    s = s + "+";
                } else if (chk.equals("CM")) {
                    s = s + "#";
                }
            }
            return s;
        }
        if (name.equals(PAWN)) {
            if (cap) {
                s = s + convertNumValToAlphaCol(fPos % 10) + "x" + convertNumValToAlphaCol(tPos % 10) + (tPos / 10);
            } else {
                s = s + convertNumValToAlphaCol(tPos % 10) + (tPos / 10);
            }
            if (chk != null) {
                if (chk.equals("C")) {
                    s = s + "+";
                } else if (chk.equals("CM")) {
                    s = s + "#";
                }
            }
            return s;
        } else {
            if (name.equals(QUEEN)) {
                s = s + "Q";
            } else if (name.equals(ROOK)) {
                s = s + "R";
            } else if (name.equals(KNIGHT)) {
                s = s + "N";
            } else if (name.equals(BISHOP)) {
                s = s + "B";
            } else {
                s = s + "K";
            }
            if (cap) {
                s = s + convertNumValToAlphaCol(fPos % 10) + (fPos / 10) + "x" + convertNumValToAlphaCol(tPos % 10) + (tPos / 10);
            } else {
                s = s + convertNumValToAlphaCol(fPos % 10) + (fPos / 10) + convertNumValToAlphaCol(tPos % 10) + (tPos / 10);
            }
            if (chk != null) {
                if (chk.equals("C")) {
                    s = s + "+";
                } else if (chk.equals("CM")) {
                    s = s + "#";
                }
            }
            return s;
        }
    }

    public String convertNumValToAlphaCol(int i) {
        switch (i) {
            case 1:
                return "a";
            case 2:
                return "b";
            case 3:
                return "c";
            case 4:
                return "d";
            case 5:
                return "e";
            case 6:
                return "f";
            case 7:
                return "g";
            case 8:
                return "h";
            default:
                return "ERROR";
        }
    }

    private void saveContentsToPGNFile(String file) throws IOException {
        FileWriter fr = new FileWriter(file);
        BufferedWriter br = new BufferedWriter(fr);

        for (int j = 0; j < gameList.size(); j++) {
            Game g = (Game) gameList.get(j);

            DateFormat df = new SimpleDateFormat("yyyy.MM.dd");
            Date d = new Date();

            br.newLine();
            br.write("[Event \"" + TITLE + "\"]\n");
            br.write("[Date \"" + df.format(d) + "\"]\n");
            br.write("[White \"" + g.wPlayersName + "\"]\n");
            br.write("[Black \"" + g.bPlayerName + "\"]\n");
            br.write("[Result \"" + g.gameResult + "\"]\n");
            br.newLine();

            for (int k = 0; k < g.moveList.size(); k++) {
                Move m = (Move) g.moveList.get(k);

                br.write(m.movePGNString);
                br.write(" ");

                if (m.moveNo % 10 == 0) {
                    br.newLine();
                }
            }
            br.newLine();
        }
        br.close();

    }

    public void setPieceUI() {
        for (int i = 0; i < jtb.length; i++) {
            jtb[i].setChessp(null);
            jtb[i].setIcon(null);
            jtb[i].setSelected(false);
        }
        for (int i = 0; i < cbo.allPieces.size(); i++) {
            int pos = -1;
            CP p = (CP) cbo.allPieces.get(i);
            int pPos = p.getCurrentPosition();
            String pName = p.getPieceName();
            String pColor = p.getPieceColor();

            if (pPos > 80 && pPos < 90) {
                //-81
                pos = pPos - 81;
            } else if (pPos > 70 && pPos < 80) {
                //-63
                pos = pPos - 63;
            } else if (pPos > 60 && pPos < 70) {
                //-45
                pos = pPos - 45;
            } else if (pPos > 50 && pPos < 60) {
                //-27
                pos = pPos - 27;
            } else if (pPos > 40 && pPos < 50) {
                //-9
                pos = pPos - 9;
            } else if (pPos > 30 && pPos < 40) {
                //9
                pos = pPos + 9;
            } else if (pPos > 20 && pPos < 30) {
                //27
                pos = pPos + 27;
            } else if (pPos > 10 && pPos < 20) {
                //45
                pos = pPos + 45;
            }

            jtb[pos].setChessp(p);

            if ((pName.equals(ROOK)) && pColor.equals(WHITE)) {
                jtb[pos].setIcon(new ImageIcon(getClass().getResource(whiteRook)));
            } else if ((pName.equals(KNIGHT)) && pColor.equals(WHITE)) {
                jtb[pos].setIcon(new ImageIcon(getClass().getResource(whiteKnight)));
            } else if ((pName.equals(BISHOP)) && pColor.equals(WHITE)) {
                jtb[pos].setIcon(new ImageIcon(getClass().getResource(whiteBishop)));
            } else if ((pName.equals(QUEEN)) && pColor.equals(WHITE)) {
                jtb[pos].setIcon(new ImageIcon(getClass().getResource(whiteQueen)));
            } else if ((pName.equals(KING)) && pColor.equals(WHITE)) {
                jtb[pos].setIcon(new ImageIcon(getClass().getResource(whiteKing)));
            } else if ((pName.equals(PAWN)) && pColor.equals(WHITE)) {
                jtb[pos].setIcon(new ImageIcon(getClass().getResource(whitePawn)));
            } else if ((pName.equals(ROOK)) && pColor.equals(BLACK)) {
                jtb[pos].setIcon(new ImageIcon(getClass().getResource(blackRook)));
            } else if ((pName.equals(KNIGHT)) && pColor.equals(BLACK)) {
                jtb[pos].setIcon(new ImageIcon(getClass().getResource(blackKnight)));
            } else if ((pName.equals(BISHOP)) && pColor.equals(BLACK)) {
                jtb[pos].setIcon(new ImageIcon(getClass().getResource(blackBishop)));
            } else if ((pName.equals(QUEEN)) && pColor.equals(BLACK)) {
                jtb[pos].setIcon(new ImageIcon(getClass().getResource(blackQueen)));
            } else if ((pName.equals(KING)) && pColor.equals(BLACK)) {
                jtb[pos].setIcon(new ImageIcon(getClass().getResource(blackKing)));
            } else if ((pName.equals(PAWN)) && pColor.equals(BLACK)) {
                jtb[pos].setIcon(new ImageIcon(getClass().getResource(blackPawn)));
            }
        }

        //System.out.println("MoveList: "+game.moveList.size());
        if (currentMoveNo == 0) {
            prev.setEnabled(false);
            first.setEnabled(false);
        }
        if (currentMoveNo > 0) {
            prev.setEnabled(true);
            first.setEnabled(true);
        }
        if (game.moveList.size() == 0) {
            next.setEnabled(false);
            last.setEnabled(false);
        }
        if (game.moveList.size() > 0) {
            next.setEnabled(true);
            last.setEnabled(true);
        }
        if (currentMoveNo == game.moveList.size()) {
            next.setEnabled(false);
            last.setEnabled(false);
        }

        gamesPanelUI.updateGamesPanelUI(gameList);
        butJPanel.repaint();
    }

    private void guiButtonIsClicked(int MoveNo) {
        txtAreaMoves.setText("");
        if (MoveNo == 0) {
            cbo.resetCB();
        } else {
            game.getMove(MoveNo);

            for (int i = 0; i < game.moveList.size(); i++) {
                Move m = (Move) game.moveList.get(i);
                //System.out.println(("GUIClicked "+ m.movePGNString);
                appendMoves(m.movePGNString);
                if (i % 2 == 1) {
                    txtAreaMoves.append("\n");
                }
                if (i == MoveNo - 1) {
                    break;
                }
            }
        }

        setPieceUI();

        //change 'whoseturn'
        if (MoveNo % 2 == 1) {
            whoseTurn = BLACK;
        } else {
            whoseTurn = WHITE;
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(EXIT)) {
            log.logLine("Clicked on " + EXIT, Level.WARNING);
            System.exit(0);
        } else if (e.getActionCommand().equals("Prev")) {
            //System.out.println(("Prev is clicked");
            //System.out.println((currentMoveNo);
            currentMoveNo--;
            guiButtonIsClicked(currentMoveNo);
        } else if (e.getActionCommand().equals("First")) {
            //System.out.println(("First is clicked");
            //System.out.println(currentMoveNo);
            currentMoveNo = 0;
            guiButtonIsClicked(currentMoveNo);
        } else if (e.getActionCommand().equals("Next")) {
            //System.out.println(("Next is clicked");
            //System.out.println(currentMoveNo);
            currentMoveNo++;
            guiButtonIsClicked(currentMoveNo);
        } else if (e.getActionCommand().equals("Last")) {
            //System.out.println(("Last is clicked");
            //System.out.println(currentMoveNo);
            currentMoveNo = game.moveList.size();
            guiButtonIsClicked(currentMoveNo);
        } else if (e.getActionCommand().equals(NEW)) {
            log.logLine("Clicked on " + NEW, Level.INFO);
            //System.out.println(("New is clicked");
            //NewGameDialog ngd = new NewGameDialog(this,true);
            //ngd.setVisible(true);
            currentMoveNo = 0;
            cbo.resetCB();
            resetChessBoardUI(true);
            currentGameNo = gameList.size() + 1;
            game = new Game(cbo, currentGameNo, true);
            gameList.add(game);
            setPieceUI();
            log.logLine("Current game number is " + currentGameNo, Level.INFO);
        } else if (e.getActionCommand().equals(OPEN)) {
            log.logLine("Clicked on " + OPEN, Level.INFO);
            // if (isFileChanged())
            //     askForSaving();
            JFileChooser fileChooser = new JFileChooser();
            //fileChooser.setCurrentDirectory(new java.io.File(fileChooserDir));
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.resetChoosableFileFilters();
            fileChooser.addChoosableFileFilter(new PGNFileFilter());
            int choice = fileChooser.showOpenDialog(this);
            if (choice == JFileChooser.APPROVE_OPTION) {
                log.logLine("PGN file selected is" + fileChooser.getSelectedFile(), Level.INFO);
                //System.out.println((fileChooser.getSelectedFile());
                AllPGNGames allGames = new AllPGNGames(this, fileChooser.getSelectedFile());

                gameList.clear();
                //setPieceUI();
                for (int i = 0; i < allGames.pgnGames.size(); i++) {
                    log.logLine("Processing PGN file number :" + i, Level.INFO);
                    EachPGNGame eg = (EachPGNGame) allGames.pgnGames.get(i);
                    //System.out.println("Game no "+ eg.getGameNumber());
                    currentGameNo = gameList.size() + 1;
                    game = new Game(cbo, currentGameNo, false);
                    gameList.add(game);

                    game.allBWMoves.clear();
                    for (int a = 0; a < eg.allBandWMoves.size(); a++) {
                        game.allBWMoves.add(eg.allBandWMoves.get(a));
                        //System.out.println(eg.allBandWMoves.get(a));
                    }
                    game.tags.clear();
                    for (int a = 0; a < eg.allTagDetails.size(); a++) {
                        game.tags.add(eg.allTagDetails.get(a));
                    }

                    //eg.convertPGNMoveToGUIFormat();

                }
                //System.out.println("HERE :"+ new Date());

                setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                for (int i = 0; i < gameList.size(); i++) {
                    game = (Game) gameList.get(i);
                    currentGameNo = i + 1;
                    EachPGNGame e1 = new EachPGNGame(this, currentGameNo);
                    loadGame(game);
                    game.updateGame();
                    ArrayList v = new ArrayList();
                    for (int k = 0; k < game.allBWMoves.size(); k++) {
                        v.add(game.allBWMoves.get(k));

                    }
                    //System.out.println(("tag; "+game.allBWMoves);
                    //System.out.println("Size "+v.size());
                    e1.convertPGNMoveToGUIFormat(v);
                }
                gamesPanelUI.updateGamesPanelUI(gameList);
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        } else if (e.getActionCommand().equals(REMOVE)) {
            int cg = 0;
            //System.out.println(("Remove is clicked");
            if (JOptionPane.showConfirmDialog(this, "Do you really want to remove the current game permenantly?", "Delete Game?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                log.logLine("Clicked on" + REMOVE, Level.INFO);
                //System.out.println(("Clicked Yes");
                //System.out.println(("Current game no is "+ currentGameNo);

                //list size should be more than 1
                if (gameList.size() > 1) {
                    //if currentgame is last game then after removal current game will be curr-1
                    //else it will remain the same no.
                    if (currentGameNo == gameList.size()) {
                        cg = currentGameNo - 1;
                    } else {
                        cg = currentGameNo;
                    }

                    //remove the game
                    for (int i = 0; i < gameList.size(); i++) {
                        Game g = (Game) gameList.get(i);
                        if (g.gameno == currentGameNo) {
                            //System.out.println(("Found a game with game no "+ currentGameNo);
                            //gameList.removeElementAt(i);
                            gameList.remove(i);
                            break;
                        }
                    }

                    //change the gameno of all the games
                    for (int i = 0; i < gameList.size(); i++) {
                        Game g = (Game) gameList.get(i);
                        g.gameno = i + 1;
                    }

                    //set the new current game
                    currentGameNo = cg;

                    //set the game obj and load it
                    for (int i = 0; i < gameList.size(); i++) {
                        Game g = (Game) gameList.get(i);
                        if (g.gameno == currentGameNo) {
                            game = g;
                            loadGame(g);
                            break;
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Cannot remove the current game!!! \nAs only one game is present in the list", "Game not removed!!!", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                //System.out.println(("Clicked no");
            }
        } else if (e.getActionCommand().equals(EDITTAGS)) {
            log.logLine("Clicked on " + EDITTAGS, Level.INFO);
            new EditTags(this, true, game).setVisible(true);
        } else if (e.getActionCommand().equals(SAVE_AS_FEN)) {
            log.logLine("Clicked on " + SAVE_AS_FEN, Level.INFO);
            //System.out.println("YOU CLICKED SAVE FEN : "+getFEN_Pawns());
            //System.out.println(("AllMoves size "+cbo.allMoves.size());
            //System.out.println(("All Moves "+game.allBWMoves);
            Object obj = JOptionPane.showInputDialog(this, " FEN generated is as shown in the text field below "
                    + "\n\n Please note that this version of " + APP_NAME + " cannot "
                    + "\n process the following information of FEN data "
                    + "\n 1)Enpassent 2)half move number and 3)fullmove number "
                    + "\n\n Hence these values are set to default, you need to modify"
                    + "\n these data manually according to your requirement "
                    + "\n\n Click Ok to save this FEN or click Cancel to abort \n ", "Please note",
                    JOptionPane.QUESTION_MESSAGE, null, null, getFEN_Pawns());
            if (obj == null) {
                //System.out.println(("CANCEL SELECTED");
            } else {
                //System.out.println(("OK SELECTED " + obj);
                //TODO
                //Save the file with obj in it
            }
        } else if (e.getActionCommand().equals(SAVE_AS_PGN)) {


            JFileChooser fileChooser = new JFileChooser();
            //fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            //fileChooser.resetChoosableFileFilters();
            //fileChooser.addChoosableFileFilter(new PGNFileFilter());

            //JFileChooser fileChooser = new JFileChooser(fileName);
            fileChooser.setFileFilter(new PGNFileFilter());
            //fileChooser.setDialogTitle(title);

            int choice = fileChooser.showSaveDialog(this);
            if (choice == JFileChooser.APPROVE_OPTION) {
                String file = fileChooser.getSelectedFile() + ".pgn";
                //System.out.println((file);
                try {
                    saveContentsToPGNFile(file);
                } catch (IOException ex) {
                    log.logger.log(Level.SEVERE, null, ex);
                }
            }
        } else if (e.getActionCommand().equals(SETUP)) {
            new SetupPositionDialogUI(this, true).setVisible(true);
        } else if (e.getActionCommand().equals(WHITEWIN)) {
            if (JOptionPane.showConfirmDialog(this, "Are you sure WHITE wins?", "Resign?", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.YES_OPTION) {
                //System.out.println(("white win");
                whiteWins();
            }
        } else if (e.getActionCommand().equals(BLACKWIN)) {
            if (JOptionPane.showConfirmDialog(this, "Are you sure BLACK wins?", "Resign?", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.YES_OPTION) {
                //System.out.println(("black win");
                blackWins();
            }
        } else if (e.getActionCommand().equals(DRAW)) {
            if (JOptionPane.showConfirmDialog(this, "Close this game as DRAW?", "Draw?", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.YES_OPTION) {
                //System.out.println(("Draw");
                itsADraw();
            }
        } else if (e.getActionCommand().equals(ABOUT)) {
            //System.out.println("ABOUT,,,");
            new AboutBoxDialogUI(this, true).setVisible(true);
        }
        if (e.getActionCommand().equals("Help Contents")) {
            JOptionPane.showMessageDialog(null, "Under Construction!! Please co-operate :-) ", "ERROR...", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void itemStateChanged(ItemEvent e) {
        JMenuItem j = (JMenuItem) e.getSource();
        if (j.getText().equals("Flip Board")) {
            if (j.isSelected()) {
                reverseBoard(BLACK);
            } else {
                reverseBoard(WHITE);
            }
        }

        if (j.getText().equals("HighLight Possible Moves")) {
            setHighlightValue(j.isSelected());
        }
    }

    private void appendMoves(String m) {
        String mm;
        if (m.contains(".")) {
            mm = m.split("\\.")[1].trim();
            //System.out.println(("Mov:"+mm);
        } else {
            mm = m.trim();
            //System.out.println(("Mov:"+mm);
        }

        if ((engineProcess != null) && (engineProcess.isEngineRunning())) {
            //System.out.println(("herermove:"+mm);
            this.engineProcess.talkToEngine(mm);
        }

        txtAreaMoves.append(m);
        game.allBWMoves.add(mm);
        if (m.contains(".")) {
            String[] mov = m.trim().split("\\.");
            int l = mov[1].trim().length();
            //System.out.println(("Len is "+l);
            if (l == 2) {
                txtAreaMoves.append("     ");
            } else if (l == 3) {
                txtAreaMoves.append("    ");
            } else if (l == 4) {
                txtAreaMoves.append("   ");
            } else if (l == 5) {
                txtAreaMoves.append("  ");
            } else if (l == 6) {
                txtAreaMoves.append(" ");
            }
        }
    }
}
