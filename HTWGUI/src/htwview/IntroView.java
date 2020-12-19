package htwview;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.border.EmptyBorder;

import htwcontroller.HtwController;

/**
 * This method represents the Menu view of the game. It consists of menubars
 * that lets the user select the type of maze, open a settings form and choose
 * the player mode. It also let's the play start the game, view the rules of the
 * game and quit the game.
 */
public class IntroView {

  private String mazeType;
  private boolean playermode;
  private int rowNum;
  private int colNum;
  private int wallNum;
  private int batNum;
  private int pitNum;
  private int arrowNum;
  private HtwController hc;

  /**
   * Constructor to create a IntroView given the Controller Object.
   * 
   * @param hc Controller Object
   */
  public IntroView(HtwController hc) {
    this.hc = hc;
    openMenu();
  }

  /**
   * This method opens the Menu view of the game with all the buttons and menu
   * items.
   * 
   */
  public void openMenu() {
    JFrame frame;
    frame = new JFrame("Hunt The Wumpus");

    frame.setResizable(false);

    JMenuBar menubar = new JMenuBar();
    menubar.setPreferredSize(new Dimension(40, 40));
    frame.setJMenuBar(menubar);

    ImageIcon targetIcon = new ImageIcon("res/images/target.png");
    ImageIcon wumpusIcon = new ImageIcon("res/images/wumpus.png");
    ImageIcon pitIcon = new ImageIcon("res/images/slime-pit.png");

    JPanel images = new JPanel(new GridLayout(1, 3));

    Image image = wumpusIcon.getImage();
    Image newimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
    wumpusIcon = new ImageIcon(newimg);
    images.add(new JLabel(wumpusIcon), 0);

    image = targetIcon.getImage();
    newimg = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
    targetIcon = new ImageIcon(newimg);
    images.add(new JLabel(targetIcon), 1);

    image = pitIcon.getImage();
    newimg = image.getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH);
    pitIcon = new ImageIcon(newimg);
    images.add(new JLabel(pitIcon), 2);

    JMenu mazeConfig = new JMenu("Maze Configuration");
    mazeConfig.setText("Maze Configuration");
    mazeConfig.setFont(new Font("Serif", Font.BOLD, 17));
    menubar.add(mazeConfig);
    JMenu mazetype = new JMenu("Maze Type");
    mazetype.setFont(new Font("Serif", Font.BOLD, 17));
    mazeConfig.add(mazetype);

    JRadioButtonMenuItem wrapped = new JRadioButtonMenuItem("Wrapped Maze");
    wrapped.setFont(new Font("Serif", Font.BOLD, 17));
    mazetype.add(wrapped);
    JRadioButtonMenuItem unwrapped = new JRadioButtonMenuItem("Non-Wrapped Maze");
    unwrapped.setFont(new Font("Serif", Font.BOLD, 17));
    mazetype.add(unwrapped);

    JMenuItem mazeSettings = new JMenuItem("Maze Settings");
    mazeSettings.setFont(new Font("Serif", Font.BOLD, 17));
    mazeConfig.add(mazeSettings);

    JMenu playerMode = new JMenu("Player Mode");
    playerMode.setFont(new Font("Serif", Font.BOLD, 17));
    menubar.add(playerMode);
    JRadioButtonMenuItem onePlayer = new JRadioButtonMenuItem("1-Player");
    onePlayer.setFont(new Font("Serif", Font.BOLD, 17));
    playerMode.add(onePlayer);
    JRadioButtonMenuItem twoPlayer = new JRadioButtonMenuItem("2-Player");
    twoPlayer.setFont(new Font("Serif", Font.BOLD, 17));
    playerMode.add(twoPlayer);

    JPanel intro = new JPanel();

    intro.setBorder(new EmptyBorder(10, 10, 10, 10));
    intro.setLayout(new GridBagLayout());

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridwidth = GridBagConstraints.REMAINDER;
    gbc.anchor = GridBagConstraints.NORTH;

    intro.add(
        new JLabel("<html><h1><strong><em><span style='color: rgb(243, 121, 52); "
            + "font-family: \"Comic Sans MS\", sans-serif; font-size: 28px'>"
            + "HUNT THE WUMPUS</span></em></strong></h1>\r\n" + "<hr>\r\n" + "<p><br></p></html>"),
        gbc);

    gbc.anchor = GridBagConstraints.CENTER;
    gbc.fill = GridBagConstraints.HORIZONTAL;

    JPanel buttons = new JPanel(new GridBagLayout());
    JButton start = new JButton("START");
    start.setPreferredSize(new Dimension(190, 50));
    start.setFont(new Font("Serif", Font.BOLD, 20));
    start.setBackground(Color.LIGHT_GRAY);
    buttons.add(start, gbc);
    JButton help = new JButton("HELP");
    help.setPreferredSize(new Dimension(190, 50));
    help.setFont(new Font("Serif", Font.BOLD, 20));
    help.setBackground(Color.LIGHT_GRAY);
    buttons.add(help, gbc);
    JButton exitButton = new JButton("QUIT");
    exitButton.setPreferredSize(new Dimension(190, 50));
    exitButton.setFont(new Font("Serif", Font.BOLD, 20));
    exitButton.setBackground(Color.LIGHT_GRAY);
    buttons.add(exitButton, gbc);

    gbc.weighty = 3;
    intro.add(images, gbc);
    intro.add(buttons, gbc);
    // intro.setBackground(Color.white);
    frame.add(intro);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 700);
    frame.setBackground(Color.WHITE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);

    mazeSettings.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        MazeConfigurationView mcv = settingsForm();
        mcv.openDialogBox();

      }
    });

    onePlayer.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {

        playermode = false;
        twoPlayer.setSelected(false);

      }
    });

    twoPlayer.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {

        playermode = true;
        onePlayer.setSelected(false);

      }
    });

    start.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {

        hc.startGUI(playermode, mazeType, rowNum, colNum, wallNum, batNum, pitNum, arrowNum);

      }
    });

    wrapped.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        mazeType = "W";
        unwrapped.setSelected(false);

      }
    });

    unwrapped.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        mazeType = "U";
        wrapped.setSelected(false);

      }
    });

    exitButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        hc.quit();

      }
    });

    help.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        MessageView mv = new MessageView();
        mv.displayRules();
      }
    });

  }

  /**
   * This method creates a new MazeConfigurationView for the button listener.
   * 
   * @return MazeConfigurationView
   */
  private MazeConfigurationView settingsForm() {
    MazeConfigurationView mcv = new MazeConfigurationView(this);
    return mcv;
  }

  /**
   * This method sets the number of rows entered by the user.
   * 
   * @param inputRowNum Input row number
   */
  public void setRows(int inputRowNum) {
    rowNum = inputRowNum;
  }

  /**
   * This method sets the number of columns entered by the user.
   * 
   * @param inputColNum Input row number
   */
  public void setColumns(int inputColNum) {
    colNum = inputColNum;
  }

  /**
   * This method sets the number of walls entered by the user.
   * 
   * @param inputWalNum Input wall number
   */
  public void setWalls(int inputWalNum) {
    wallNum = inputWalNum;
  }

  /**
   * This method sets the number of bats entered by the user.
   * 
   * @param inputBatNum Input bat number
   */
  public void setBats(int inputBatNum) {
    batNum = inputBatNum;
  }

  /**
   * This method sets the number of pits entered by the user.
   * 
   * @param inputPitNum Input pit number
   */
  public void setPits(int inputPitNum) {
    pitNum = inputPitNum;
  }

  /**
   * This method sets the number of arrows entered by the user.
   * 
   * @param inputArrowNum Input Arrow number
   */
  public void setArrows(int inputArrowNum) {
    arrowNum = inputArrowNum;
  }

}