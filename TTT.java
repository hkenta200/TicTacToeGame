/********************************************                       
 *Tic-Tac-Toe GUI              
 *******************************************/

import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class TTT extends JFrame implements MouseMotionListener {
    //Most of these fields are static because we want to use these in multiple methods and in the action listeners.
    //For some reason, if we create an object in the methods we want to use, a new JFrame pops up, even though we have a method for making a JFrame. 
    private static String getWinner;
    private static int userWin = 0;
    private static int user1Win = 0;
    private static int user2Win = 0;
    private static int compWins = 0;
    private static int roundCount = 0;
    private static int draws = 0;
    private static String currPlayer;
    private static int compChoice;
    private static String against; //This is for if the player wants to play against another player or the computer
    private static String versus; //This is for if the player wants to be player 1 or player 2 if they play against another player

    private static JLabel roundLabel;
    private static JTextField roundField;
    private static JLabel winnerLabel;
    private static JTextField winnerField;
    private static JLabel drawsCount;
    private static JTextField drawField;
    private static JLabel userWins1;
    private static JTextField userField1;
    private static JLabel userWins2;
    private static JTextField userField2;
    private static JLabel userWins;
    private static JTextField userField;
    private static JLabel cWins;
    private static JTextField compField;

    private static JButton r1c1;
    private static JButton r1c2;
    private static JButton r1c3;
    private static JButton r2c1;
    private static JButton r2c2;
    private static JButton r2c3;
    private static JButton r3c1;
    private static JButton r3c2;
    private static JButton r3c3;

    // GUI Constructors
    public TTT() {
        super("Tic-Tac-Toe Program");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(620, 330);
        setSize(600, 420);
        setVisible(true);
    }

    public TTT(String n) {
        super(n);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(620, 330);
        setSize(600, 420);
        setVisible(true);
    }

    public static void setPlayer(String p) {
        currPlayer = p;
    }

    public static String getPlayer() {
        return currPlayer;
    }

    public static void setVersus(String v) {
        versus = v;
    }

    public static String getVersus() {
        return versus;
    }

    public static void setAgainst(String a) { //Sets who you are playing against
        against = a;
    }

    public static String getAgainst() { //Gets who you are playing against
        return against;
    }

    public static void setWinner(String w) { //Sets the winner
        getWinner = w;
    }

    public static String getWinner() { //Gets the winner
        return getWinner;
    }

    public static void setRound(int r) { //Sets the round
        roundCount = r;
    }

    public static int getRound() { //Gets the current round
        return roundCount;
    }

    public static int getDraws() { //Gets the current draws count
        return draws;
    }

    public static int getUserWins() { //Gets the current user wins count
        return userWin;
    }
    
    public static int getUser1Wins() { //Gets the current user1 wins count
        return user1Win;
    }

    public static int getUser2Wins() { //Gets the current user2 wins count
        return user2Win;
    }

    public static int getCompWins() { //Gets the current computer wins count
        return compWins;
    }

    public static void increaseRound() { //Increases round by one. Used after the user clicks their choice
        roundCount++;
    }

    public static void drawIncrease() { //Increases draws by one. Used after the result is a tie
        draws++;
    }

    public static void userIncrease() { //Increases user wins by one. Used after the winner is the user
        userWin++;
    }

    public static void user1Increase() { //Increases user1 wins by one. Used after the winner is the user
        user1Win++;
    }

    public static void user2Increase() { //Increases user2 wins by one. Used after the winner is the user
        user2Win++;
    }

    public static void compIncrease() { //Increases computer wins by one. Used after the winner is the computer
        compWins++;
    }

    public void mouseDragged(MouseEvent arg0) {
    }

    public void mouseMoved(MouseEvent arg0) {
    }

    public static void setGUIComponents() { //Put all the GUI components in a separate because we don't want to have to copy and paste it twice in the main
        // Making GUI Window
        TTT m = new TTT();

        m.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        roundLabel = new JLabel("Round: "); // Adds a label called round
        roundField = new JTextField(JTextField.HORIZONTAL); // Adds a text field where the current round can be displayed
        roundField.setText(String.valueOf(getRound())); // Sets the current round to be 0 since the game just started
        roundField.setEditable(false);
        roundField.setVisible(true);
        roundField.setBorder(javax.swing.BorderFactory.createEmptyBorder()); // Gets rid of the border around the text field

        winnerLabel = new JLabel("Winner: "); // Adds a label called winner
        winnerField = new JTextField(JTextField.HORIZONTAL); // Adds a text field where the current winner can be displayed
        winnerField.setEditable(false);
        winnerField.setVisible(false); // Is not visible yet because there is no winner yet
        winnerField.setBorder(javax.swing.BorderFactory.createEmptyBorder()); // Gets rid of the border around the text field

        drawsCount = new JLabel("Draws: "); // Adds a label called draws
        drawField = new JTextField(JTextField.HORIZONTAL); // Adds a text field where the number of ties can be displayed
        drawField.setText(String.valueOf(getDraws())); // Sets the current draws to be 0 since the game just started
        drawField.setEditable(false);
        drawField.setVisible(true);
        drawField.setBorder(javax.swing.BorderFactory.createEmptyBorder()); // Gets rid of the border around the text field

        userWins = new JLabel("User wins: ");
        userField = new JTextField(JTextField.HORIZONTAL); // Adds a text field where the number of ties can be displayed
        userField.setText(String.valueOf(getUserWins())); // Sets the current user wins to be 0 since the game just started
        userField.setEditable(false);
        userField.setVisible(true);
        userField.setBorder(javax.swing.BorderFactory.createEmptyBorder()); // Gets rid of the border around the text field

        userWins1 = new JLabel("User1 wins: ");
        userField1 = new JTextField(JTextField.HORIZONTAL); // Adds a text field where the number of ties can be displayed
        userField1.setText(String.valueOf(getUser1Wins())); // Sets the current user wins to be 0 since the game just started
        userField1.setEditable(false);
        userField1.setVisible(true);
        userField1.setBorder(javax.swing.BorderFactory.createEmptyBorder()); // Gets rid of the border around the text field

        userWins2 = new JLabel("User2 wins: ");
        userField2 = new JTextField(JTextField.HORIZONTAL); // Adds a text field where the number of ties can be displayed
        userField2.setText(String.valueOf(getUser2Wins())); // Sets the current user wins to be 0 since the game just started
        userField2.setEditable(false);
        userField2.setVisible(true);
        userField2.setBorder(javax.swing.BorderFactory.createEmptyBorder()); // Gets rid of the border around the text field

        cWins = new JLabel("Computer wins: ");
        compField = new JTextField(JTextField.HORIZONTAL); // Adds a text field where the number of ties can be displayed
        compField.setText(String.valueOf(getCompWins())); // Sets the current computer wins to be 0 since the game just started
        compField.setEditable(false);
        compField.setVisible(true);
        compField.setBorder(javax.swing.BorderFactory.createEmptyBorder()); // Gets rid of the border around the text field

        // Adds everything to the top panel
        topPanel.add(roundLabel);
        topPanel.add(roundField);
        //topPanel.add(winnerLabel);
        //topPanel.add(winnerField);
        topPanel.add(drawsCount);
        topPanel.add(drawField);
        if (getAgainst().equalsIgnoreCase("player")) {
            topPanel.add(userWins1);
            topPanel.add(userField1);
            topPanel.add(userWins2);
            topPanel.add(userField2);
        }
        else if (getAgainst().equalsIgnoreCase("computer")) {
            topPanel.add(userWins);
            topPanel.add(userField);
            topPanel.add(cWins);
            topPanel.add(compField);
        }
        else {
            JOptionPane.showInputDialog(null, "Not an option. Try again.", "Another player or Computer?", JOptionPane.INFORMATION_MESSAGE);
        }

        JPanel boardPanel = new JPanel(new GridLayout(0, 3, 6, 5));

        //Adding Buttons
        r1c1 = new JButton("");
        r1c2 = new JButton("");
        r1c3 = new JButton("");
        r2c1 = new JButton("");
        r2c2 = new JButton("");
        r2c3 = new JButton("");
        r3c1 = new JButton("");
        r3c2 = new JButton("");
        r3c3 = new JButton("");

        //Setting Size for buttons
        r1c1.setPreferredSize(new Dimension(160, 45));

        //Adding Buttons                                  
        r1c1.setBackground(Color.WHITE);
        boardPanel.add(r1c1);

        r1c2.setBackground(Color.WHITE);
        boardPanel.add(r1c2);

        r1c3.setBackground(Color.WHITE);
        boardPanel.add(r1c3);

        r2c1.setBackground(Color.WHITE);
        boardPanel.add(r2c1);

        r2c2.setBackground(Color.WHITE);
        boardPanel.add(r2c2);

        r2c3.setBackground(Color.WHITE);
        boardPanel.add(r2c3);

        r3c1.setBackground(Color.WHITE);
        boardPanel.add(r3c1);

        r3c2.setBackground(Color.WHITE);
        boardPanel.add(r3c2);

        r3c3.setBackground(Color.WHITE);
        boardPanel.add(r3c3);

        boardPanel.setBackground(Color.BLACK);
        m.setBackground(Color.white);
        m.add(topPanel, BorderLayout.NORTH);
        m.add(boardPanel, BorderLayout.CENTER);

        // ActionListeners for all buttons
        r1c1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    r1c1.setFont(new Font("Calibri", Font.PLAIN, 72));

                    if (currPlayer.equalsIgnoreCase("X")) {
                        r1c1.setText("X");
                    } else if (currPlayer.equalsIgnoreCase("O")) {
                        r1c1.setText("O");
                    }

                    if(getAgainst().equalsIgnoreCase("player")) {
                        changePlayer(currPlayer);
                    }

                    if(getAgainst().equalsIgnoreCase("computer")) {
                        computerChoice();
                        changePlayer(currPlayer);
                    }

                    winningGame();
                }
            });
        r1c2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    r1c2.setFont(new Font("Calibri", Font.PLAIN, 72));

                    if (currPlayer.equalsIgnoreCase("X")) {
                        r1c2.setText("X");
                    } else if (currPlayer.equalsIgnoreCase("O")) {
                        r1c2.setText("O");
                    }

                    if(getAgainst().equalsIgnoreCase("player")) {
                        changePlayer(currPlayer);
                    }

                    if(getAgainst().equalsIgnoreCase("computer")) {
                        computerChoice();
                        changePlayer(currPlayer);
                    }

                    winningGame();
                }
            });
        r1c3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    r1c3.setFont(new Font("Calibri", Font.PLAIN, 72));

                    if (currPlayer.equalsIgnoreCase("X")) {
                        r1c3.setText("X");
                    } else if (currPlayer.equalsIgnoreCase("O")) {
                        r1c3.setText("O");
                    }

                    if(getAgainst().equalsIgnoreCase("player")) {
                        changePlayer(currPlayer);
                    }

                    if(getAgainst().equalsIgnoreCase("computer")) {
                        computerChoice();
                        changePlayer(currPlayer);
                    }

                    winningGame();
                }
            });
        r2c1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    r2c1.setFont(new Font("Calibri", Font.PLAIN, 72));

                    if (currPlayer.equalsIgnoreCase("X")) {
                        r2c1.setText("X");
                    } else if (currPlayer.equalsIgnoreCase("O")) {
                        r2c1.setText("O");
                    }

                    if(getAgainst().equalsIgnoreCase("player")) {
                        changePlayer(currPlayer);
                    }

                    if(getAgainst().equalsIgnoreCase("computer")) {
                        computerChoice();
                        changePlayer(currPlayer);
                    }

                    winningGame();
                }
            });
        r2c2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    r2c2.setFont(new Font("Calibri", Font.PLAIN, 72));

                    if (currPlayer.equalsIgnoreCase("X")) {
                        r2c2.setText("X");
                    } else if (currPlayer.equalsIgnoreCase("O")) {
                        r2c2.setText("O");
                    }

                    if(getAgainst().equalsIgnoreCase("player")) {
                        changePlayer(currPlayer);
                    }

                    if(getAgainst().equalsIgnoreCase("computer")) {
                        computerChoice();
                         changePlayer(currPlayer);
                    }

                    winningGame();
                }
            });
        r2c3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    r2c3.setFont(new Font("Calibri", Font.PLAIN, 72));

                    if (currPlayer.equalsIgnoreCase("X")) {
                        r2c3.setText("X");
                    } else if (currPlayer.equalsIgnoreCase("O")) {
                        r2c3.setText("O");
                    }

                    if(getAgainst().equalsIgnoreCase("player")) {
                        changePlayer(currPlayer);
                    }

                    if(getAgainst().equalsIgnoreCase("computer")) {
                        computerChoice();
                        changePlayer(currPlayer);
                    }

                    winningGame();
                }
            });
        r3c1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    r3c1.setFont(new Font("Calibri", Font.PLAIN, 72));

                    if (currPlayer.equalsIgnoreCase("X")) {
                        r3c1.setText("X");
                    } else if (currPlayer.equalsIgnoreCase("O")) {
                        r3c1.setText("O");
                    }

                    if(getAgainst().equalsIgnoreCase("player")) {
                        changePlayer(currPlayer);
                    }

                    if(getAgainst().equalsIgnoreCase("computer")) {
                        computerChoice();
                         changePlayer(currPlayer);
                    }

                    winningGame();
                }
            });
        r3c2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    r3c2.setFont(new Font("Calibri", Font.PLAIN, 72));

                    if (currPlayer.equalsIgnoreCase("X")) {
                        r3c2.setText("X");
                    } else if (currPlayer.equalsIgnoreCase("O")) {
                        r3c2.setText("O");
                    }

                    if(getAgainst().equalsIgnoreCase("player")) {
                        changePlayer(currPlayer);
                    }

                    if(getAgainst().equalsIgnoreCase("computer")) {
                        computerChoice();
                        changePlayer(currPlayer);
                    }

                    winningGame();
                }
            });
        r3c3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    r3c3.setFont(new Font("Calibri", Font.PLAIN, 72));

                    if (currPlayer.equalsIgnoreCase("X")) {
                        r3c3.setText("X");
                    } else if (currPlayer.equalsIgnoreCase("O")) {
                        r3c3.setText("O");
                    }

                    if(getAgainst().equalsIgnoreCase("player")) {
                        changePlayer(currPlayer);
                    }

                    if(getAgainst().equalsIgnoreCase("computer")) {
                        computerChoice();
                        changePlayer(currPlayer);
                    }

                    winningGame();
                }
            });

        m.setVisible(true);
    }

    //Changes player. Should be used after a button/box is clicked
    public static String changePlayer(String p) {
        // Check current player: if x, then switch to o. If o, then switch to x. Return new player.
        if (currPlayer.equalsIgnoreCase("x")) {
            currPlayer = "o";
        } else if (currPlayer.equalsIgnoreCase("o")) {
            currPlayer = "x";
        }
        return currPlayer;
    }

    // generate random number from 1-16
    public static void computerChoice() {
        int compChoice = 0;

        int rpt = 0; 
        Random random = new Random();

        if(!r1c1.getText().equals("") && !r1c2.getText().equals("") && !r1c3.getText().equals("") 
        && !r2c1.getText().equals("")  && !r2c2.getText().equals("")  && !r2c3.getText().equals("")
        && !r3c1.getText().equals("")  && !r3c2.getText().equals("")  && !r3c3.getText().equals("")) {
            winningGame();
            rpt = 1;
        }
        while(rpt == 0){
            compChoice = random.nextInt(18);
            if (currPlayer.equalsIgnoreCase("X")) {
                //compChoice = random.nextInt(9);

                if (compChoice == 0 && r1c1.getText() == "") {
                    r1c1.setFont(new Font("Calibri", Font.PLAIN, 72));
                    r1c1.setText("O");
                    changePlayer(currPlayer);
                    winningGame();
                    rpt = 1;
                } 
                else if (compChoice == 1 && r1c2.getText() == "") {
                    r1c2.setFont(new Font("Calibri", Font.PLAIN, 72));
                    r1c2.setText("O");
                    changePlayer(currPlayer);
                    winningGame();
                    rpt = 1;
                } 
                else if (compChoice == 2 && r1c3.getText() == "") {
                    r1c3.setFont(new Font("Calibri", Font.PLAIN, 72));
                    r1c3.setText("O");
                    changePlayer(currPlayer);
                    winningGame();
                    rpt = 1;
                } 
                else if (compChoice == 3 && r2c1.getText() == "") {
                    r2c1.setFont(new Font("Calibri", Font.PLAIN, 72));
                    r2c1.setText("O");
                    changePlayer(currPlayer);
                    winningGame();
                    rpt = 1;
                } 
                else if (compChoice == 4 && r2c2.getText() == "") {
                    r2c2.setFont(new Font("Calibri", Font.PLAIN, 72));
                    r2c2.setText("O");
                    changePlayer(currPlayer);
                    winningGame();
                    rpt = 1;
                } 
                else if (compChoice == 5 && r2c3.getText() == "") {
                    r2c3.setFont(new Font("Calibri", Font.PLAIN, 72));
                    r2c3.setText("O");
                    changePlayer(currPlayer);
                    winningGame();
                    rpt = 1;
                } 
                else if (compChoice == 6 && r3c1.getText() == "") {
                    r3c1.setFont(new Font("Calibri", Font.PLAIN, 72));
                    r3c1.setText("O");
                    changePlayer(currPlayer);
                    winningGame();
                    rpt = 1;
                } 
                else if (compChoice == 7 && r3c2.getText() == "") {
                    r3c2.setFont(new Font("Calibri", Font.PLAIN, 72));
                    r3c2.setText("O");
                    changePlayer(currPlayer);
                    winningGame();
                    rpt = 1;
                } 
                else if (compChoice == 8 && r3c3.getText() == "") {
                    r3c3.setFont(new Font("Calibri", Font.PLAIN, 72));
                    r3c3.setText("O");
                    changePlayer(currPlayer);
                    winningGame();
                    rpt = 1;
                }
            } else if(currPlayer.equalsIgnoreCase("O")) {
                //compChoice = random.nextInt(9);

                if (compChoice == 9 && r1c1.getText() == "") {
                    r1c1.setFont(new Font("Calibri", Font.PLAIN, 72));
                    r1c1.setText("X");
                    changePlayer(currPlayer);
                    winningGame();
                    rpt = 1;
                } 
                else if (compChoice == 10 && r1c2.getText() == "") {
                    r1c2.setFont(new Font("Calibri", Font.PLAIN, 72));
                    r1c2.setText("X");
                    changePlayer(currPlayer);
                    winningGame();
                    rpt = 1;
                } 
                else if (compChoice == 11 && r1c3.getText() == "") {
                    r1c3.setFont(new Font("Calibri", Font.PLAIN, 72));
                    r1c3.setText("X");
                    changePlayer(currPlayer);
                    winningGame();
                    rpt = 1;
                } 
                else if (compChoice == 12 && r2c1.getText() == "") {
                    r2c1.setFont(new Font("Calibri", Font.PLAIN, 72));
                    r2c1.setText("X");
                    changePlayer(currPlayer);
                    winningGame();
                    rpt = 1;
                } 
                else if (compChoice == 13 && r2c2.getText() == "") {
                    r2c2.setFont(new Font("Calibri", Font.PLAIN, 72));
                    r2c2.setText("X");
                    changePlayer(currPlayer);
                    winningGame();
                    rpt = 1;
                } 
                else if (compChoice == 14 && r2c3.getText() == "") {
                    r2c3.setFont(new Font("Calibri", Font.PLAIN, 72));
                    r2c3.setText("X");
                    changePlayer(currPlayer);
                    winningGame();
                    rpt = 1;
                } 
                else if (compChoice == 15 && r3c1.getText() == "") {
                    r3c1.setFont(new Font("Calibri", Font.PLAIN, 72));
                    r3c1.setText("X");
                    changePlayer(currPlayer);
                    winningGame();
                    rpt = 1;
                } 
                else if (compChoice == 16 && r3c2.getText() == "") {
                    r3c2.setFont(new Font("Calibri", Font.PLAIN, 72));
                    r3c2.setText("X");
                    changePlayer(currPlayer);
                    winningGame();
                    rpt = 1;
                } 
                else if (compChoice == 17 && r3c3.getText() == "") {
                    r3c3.setFont(new Font("Calibri", Font.PLAIN, 72));
                    r3c3.setText("X");
                    changePlayer(currPlayer);
                    winningGame();
                    rpt = 1;
                }
            }
        }
        //changePlayer(currPlayer);
    }


    //8 Ways to win: 3 horizontals, 3 veticals, 2 diagonals. Checks who won and adds to their score
    public static void winningGame(){
        if (r1c1.getText() == "X" && r2c2.getText() == "X" && r3c3.getText() == "X" || r1c1.getText() == "O" && r2c2.getText() == "O" && r3c3.getText() == "O") {
            JOptionPane.showMessageDialog(null, "Player " + r1c1.getText() + " wins");
            clearBoard();
            if (getAgainst().equalsIgnoreCase("player") && getPlayer().equalsIgnoreCase("x") && getVersus().equalsIgnoreCase("player 1")) {
                user1Increase();
                userField1.setText(String.valueOf(getUser1Wins()));
                setWinner(getVersus());
            }
            else if (getAgainst().equalsIgnoreCase("player") && getPlayer().equalsIgnoreCase("x") && getVersus().equalsIgnoreCase("player 2")) {
                user2Increase();
                userField2.setText(String.valueOf(getUser2Wins()));
                setWinner(getVersus());
            }
            else if (getAgainst().equalsIgnoreCase("player") && getPlayer().equalsIgnoreCase("o") && getVersus().equalsIgnoreCase("player 1")) {
                user1Increase();
                userField1.setText(String.valueOf(getUser1Wins()));
                setWinner(getVersus());
            }
            else if (getAgainst().equalsIgnoreCase("player") && getPlayer().equalsIgnoreCase("o") && getVersus().equalsIgnoreCase("player 2")) {
                user2Increase();
                userField2.setText(String.valueOf(getUser2Wins()));
                setWinner(getVersus());
            }
            else if(getAgainst().equalsIgnoreCase("computer")) {
                compIncrease();
            }
        }
        if (r1c3.getText() == "X" && r2c2.getText() == "X" && r3c1.getText() == "X" || r1c3.getText() == "O" && r2c2.getText() == "O" && r3c1.getText() == "O") {
            JOptionPane.showMessageDialog(null, "Player " + r1c3.getText() + " wins");
            clearBoard();
            if (getAgainst().equalsIgnoreCase("player") && getPlayer().equalsIgnoreCase("x") && getVersus().equalsIgnoreCase("player 1")) {
                user1Increase();
                userField1.setText(String.valueOf(getUser1Wins()));
                setWinner(getVersus());
            }
            else if (getAgainst().equalsIgnoreCase("player") && getPlayer().equalsIgnoreCase("x") && getVersus().equalsIgnoreCase("player 2")) {
                user2Increase();
                userField2.setText(String.valueOf(getUser2Wins()));
                setWinner(getVersus());
            }
            else if (getAgainst().equalsIgnoreCase("player") && getPlayer().equalsIgnoreCase("o") && getVersus().equalsIgnoreCase("player 1")) {
                user1Increase();
                userField1.setText(String.valueOf(getUser1Wins()));
                setWinner(getVersus());
            }
            else if (getAgainst().equalsIgnoreCase("player") && getPlayer().equalsIgnoreCase("o") && getVersus().equalsIgnoreCase("player 2")) {
                user2Increase();
                userField2.setText(String.valueOf(getUser2Wins()));
                setWinner(getVersus());
            }
            else if(getAgainst().equalsIgnoreCase("computer")) {
                compIncrease();
                setWinner(getVersus());
            }
        }
        if (r1c1.getText() == "X" && r1c2.getText() == "X" && r1c3.getText() == "X" || r1c1.getText() == "O" && r1c2.getText() == "O" && r1c3.getText() == "O") {
            JOptionPane.showMessageDialog(null, "Player " + r1c1.getText() + " wins");
            clearBoard();
            if (getAgainst().equalsIgnoreCase("player") && getPlayer().equalsIgnoreCase("x") && getVersus().equalsIgnoreCase("player 1")) {
                user1Increase();
                userField1.setText(String.valueOf(getUser1Wins()));
                setWinner(getVersus());
            }
            else if (getAgainst().equalsIgnoreCase("player") && getPlayer().equalsIgnoreCase("x") && getVersus().equalsIgnoreCase("player 2")) {
                user2Increase();
                userField2.setText(String.valueOf(getUser2Wins()));
                setWinner(getVersus());
            }
            else if (getAgainst().equalsIgnoreCase("player") && getPlayer().equalsIgnoreCase("o") && getVersus().equalsIgnoreCase("player 1")) {
                user1Increase();
                userField1.setText(String.valueOf(getUser1Wins()));
                setWinner(getVersus());
            }
            else if (getAgainst().equalsIgnoreCase("player") && getPlayer().equalsIgnoreCase("o") && getVersus().equalsIgnoreCase("player 2")) {
                user2Increase();
                userField2.setText(String.valueOf(getUser2Wins()));
                setWinner(getVersus());
            }
            else if(getAgainst().equalsIgnoreCase("computer")) {
                compIncrease();
                setWinner(getVersus());
            }
        }
        if (r2c1.getText() == "X" && r2c2.getText() == "X" && r2c3.getText() == "X" || r2c1.getText() == "O" && r2c2.getText() == "O" && r2c3.getText() == "O") {
            JOptionPane.showMessageDialog(null, "Player " + r2c1.getText() + " wins");
            clearBoard();
            if (getAgainst().equalsIgnoreCase("player") && getPlayer().equalsIgnoreCase("x") && getVersus().equalsIgnoreCase("player 1")) {
                user1Increase();
                userField1.setText(String.valueOf(getUser1Wins()));
                setWinner(getVersus());
            }
            else if (getAgainst().equalsIgnoreCase("player") && getPlayer().equalsIgnoreCase("x") && getVersus().equalsIgnoreCase("player 2")) {
                user2Increase();
                userField2.setText(String.valueOf(getUser2Wins()));
                setWinner(getVersus());
            }
            else if (getAgainst().equalsIgnoreCase("player") && getPlayer().equalsIgnoreCase("o") && getVersus().equalsIgnoreCase("player 1")) {
                user1Increase();
                userField1.setText(String.valueOf(getUser1Wins()));
                setWinner(getVersus());
            }
            else if (getAgainst().equalsIgnoreCase("player") && getPlayer().equalsIgnoreCase("o") && getVersus().equalsIgnoreCase("player 2")) {
                user2Increase();
                userField2.setText(String.valueOf(getUser2Wins()));
                setWinner(getVersus());
            }
            else if(getAgainst().equalsIgnoreCase("computer")) {
                compIncrease();
                setWinner(getVersus());
            }
        }
        if (r3c1.getText() == "X" && r3c2.getText() == "X" && r3c3.getText() == "X" || r3c1.getText() == "O" && r3c2.getText() == "O" && r3c3.getText() == "O") {
            JOptionPane.showMessageDialog(null, "Player " + r3c1.getText() + " wins");
            clearBoard();
            if (getAgainst().equalsIgnoreCase("player") && getPlayer().equalsIgnoreCase("x") && getVersus().equalsIgnoreCase("player 1")) {
                user1Increase();
                userField1.setText(String.valueOf(getUser1Wins()));
                setWinner(getVersus());
            }
            else if (getAgainst().equalsIgnoreCase("player") && getPlayer().equalsIgnoreCase("x") && getVersus().equalsIgnoreCase("player 2")) {
                user2Increase();
                userField2.setText(String.valueOf(getUser2Wins()));
                setWinner(getVersus());
            }
            else if (getAgainst().equalsIgnoreCase("player") && getPlayer().equalsIgnoreCase("o") && getVersus().equalsIgnoreCase("player 1")) {
                user1Increase();
                userField1.setText(String.valueOf(getUser1Wins()));
                setWinner(getVersus());
            }
            else if (getAgainst().equalsIgnoreCase("player") && getPlayer().equalsIgnoreCase("o") && getVersus().equalsIgnoreCase("player 2")) {
                user2Increase();
                userField2.setText(String.valueOf(getUser2Wins()));
                setWinner(getVersus());
            }
            else if(getAgainst().equalsIgnoreCase("computer")) {
                compIncrease();
                setWinner(getVersus());
            }
        }
        if (r1c1.getText() == "X" && r2c1.getText() == "X" && r3c1.getText() == "X" || r1c1.getText() == "O" && r2c1.getText() == "O" && r3c1.getText() == "O") {
            JOptionPane.showMessageDialog(null, "Player " + r1c1.getText() + " wins");
            clearBoard();
            if (getAgainst().equalsIgnoreCase("player") && getPlayer().equalsIgnoreCase("x") && getVersus().equalsIgnoreCase("player 1")) {
                user1Increase();
                userField1.setText(String.valueOf(getUser1Wins()));
                setWinner(getVersus());
            }
            else if (getAgainst().equalsIgnoreCase("player") && getPlayer().equalsIgnoreCase("x") && getVersus().equalsIgnoreCase("player 2")) {
                user2Increase();
                userField2.setText(String.valueOf(getUser2Wins()));
                setWinner(getVersus());
            }
            else if (getAgainst().equalsIgnoreCase("player") && getPlayer().equalsIgnoreCase("o") && getVersus().equalsIgnoreCase("player 1")) {
                user1Increase();
                userField1.setText(String.valueOf(getUser1Wins()));
                setWinner(getVersus());
            }
            else if (getAgainst().equalsIgnoreCase("player") && getPlayer().equalsIgnoreCase("o") && getVersus().equalsIgnoreCase("player 2")) {
                user2Increase();
                userField2.setText(String.valueOf(getUser2Wins()));
                setWinner(getVersus());
            }
            else if(getAgainst().equalsIgnoreCase("computer")) {
                compIncrease();
                setWinner(getVersus());
            }
        }
        if (r1c2.getText() == "X" && r2c2.getText() == "X" && r3c2.getText() == "X" || r1c2.getText() == "O" && r2c2.getText() == "O" && r3c2.getText() == "O") {
            JOptionPane.showMessageDialog(null, "Player " + r1c2.getText() + " wins");
            clearBoard();
            if (getAgainst().equalsIgnoreCase("player") && getPlayer().equalsIgnoreCase("x") && getVersus().equalsIgnoreCase("player 1")) {
                user1Increase();
                userField1.setText(String.valueOf(getUser1Wins()));
                setWinner(getVersus());
            }
            else if (getAgainst().equalsIgnoreCase("player") && getPlayer().equalsIgnoreCase("x") && getVersus().equalsIgnoreCase("player 2")) {
                user2Increase();
                userField2.setText(String.valueOf(getUser2Wins()));
                setWinner(getVersus());
            }
            else if (getAgainst().equalsIgnoreCase("player") && getPlayer().equalsIgnoreCase("o") && getVersus().equalsIgnoreCase("player 1")) {
                user1Increase();
                userField1.setText(String.valueOf(getUser1Wins()));
                setWinner(getVersus());
            }
            else if (getAgainst().equalsIgnoreCase("player") && getPlayer().equalsIgnoreCase("o") && getVersus().equalsIgnoreCase("player 2")) {
                user2Increase();
                userField2.setText(String.valueOf(getUser2Wins()));
                setWinner(getVersus());
            }
            else if(getAgainst().equalsIgnoreCase("computer")) {
                compIncrease();
                setWinner(getVersus());
            }
        }
        if (r1c3.getText() == "X" && r2c3.getText() == "X" && r3c3.getText() == "X" || r1c3.getText() == "O" && r2c3.getText() == "O" && r3c3.getText() == "O") {
            JOptionPane.showMessageDialog(null, "Player " + r1c3.getText() + " wins");
            clearBoard();
            if (getAgainst().equalsIgnoreCase("player") && getPlayer().equalsIgnoreCase("x") && getVersus().equalsIgnoreCase("player 1")) {
                user1Increase();
                userField1.setText(String.valueOf(getUser1Wins()));
                setWinner(getVersus());
            }
            else if (getAgainst().equalsIgnoreCase("player") && getPlayer().equalsIgnoreCase("x") && getVersus().equalsIgnoreCase("player 2")) {
                user2Increase();
                userField2.setText(String.valueOf(getUser2Wins()));
                setWinner(getVersus());
            }
            else if (getAgainst().equalsIgnoreCase("player") && getPlayer().equalsIgnoreCase("o") && getVersus().equalsIgnoreCase("player 1")) {
                user1Increase();
                userField1.setText(String.valueOf(getUser1Wins()));
                setWinner(getVersus());
            }
            else if (getAgainst().equalsIgnoreCase("player") && getPlayer().equalsIgnoreCase("o") && getVersus().equalsIgnoreCase("player 2")) {
                user2Increase();
                userField2.setText(String.valueOf(getUser2Wins()));
                setWinner(getVersus());
            }
            else if(getAgainst().equalsIgnoreCase("computer")) {
                compIncrease();
                setWinner(getVersus());
            }
        }
        if ((r1c1.getText() == "X" || r1c1.getText() == "O") && (r1c2.getText() == "X" || r1c2.getText() == "O") && (r1c3.getText() == "X" || r1c3.getText() == "O")
        && (r2c1.getText() == "X" || r2c1.getText() == "O") && (r2c2.getText() == "X" || r2c2.getText() == "O") && (r2c3.getText() == "X" || r2c3.getText() == "O")
        && (r3c1.getText() == "X" || r3c1.getText() == "O") &&(r3c2.getText() == "X" || r3c2.getText() == "O") && (r3c3.getText() == "X" || r3c3.getText() == "O")) {
            JOptionPane.showMessageDialog(null, "It's a draw!");
            drawIncrease();
            clearBoard();
            setWinner("No one");
        }
    }

    //Resets board for next round. Asks if player wants to play another round and if yes, clears the buttons and starts another round
    public static void clearBoard() {
        try {
            String s = JOptionPane.showInputDialog(null, "Good round. Do you want to play another round?", "Play again?", JOptionPane.INFORMATION_MESSAGE);
            r1c1.setText("");
            r1c2.setText("");
            r1c3.setText("");
            r2c1.setText("");
            r2c2.setText("");
            r2c3.setText("");
            r3c1.setText("");
            r3c2.setText("");
            r3c3.setText("");
            increaseRound(); //Increases round by one because a round was just played
            roundField.setText(String.valueOf(getRound()));
            drawField.setText(String.valueOf(getDraws()));
            compField.setText(String.valueOf(getCompWins()));
            winnerField.setText(getWinner());
            changePlayer(currPlayer);
            while (!s.equals("yes")) {
                JOptionPane.showMessageDialog(null, "Thanks for playing!");
                System.exit(0);
            }
        } 
        catch (Exception ee) {
            JOptionPane.showMessageDialog(null, "Try Again!");
        }
    }

    public static void main(String[] args) {

        String who = "player"; //Who the player wants to play against

        //Beginning of main 
        JOptionPane.showMessageDialog(null, "Hi. Welcome to Tic-Tac-Toe. In order to win, you have to get whichever charatcer you are(X or O) placed in 3 boxes in a row. "
            + "\nEither diagonally, horizontally or vertically. "
            + "\nIf you play against the Computer, the computer goes first."); //Instructions

        //Asks the player what they want to be
        currPlayer = JOptionPane.showInputDialog(null, "Which do you want to be? X or O", "X or O", JOptionPane.INFORMATION_MESSAGE);
        //Make another variable so that it does't keep switching
        do { //Makes sure the player enters either X or O. Will keep asking until one is choosen
            try {
                if (currPlayer.equalsIgnoreCase("X")) { // They can enter lowercase so this checks if they do
                    currPlayer = "X";
                    setPlayer(currPlayer);
                } 
                else if (currPlayer.equalsIgnoreCase("O")) { // They can enter lowercase so this checks if they do
                    currPlayer = "O";
                    setPlayer(currPlayer);
                } 
                else {
                    throw new playerException();
                }
            } 
            catch (playerException pe) {
                JOptionPane.showMessageDialog(null, pe.getMessage());
                currPlayer = JOptionPane.showInputDialog(null, "Which do you want to be? X or O", "X or O",JOptionPane.INFORMATION_MESSAGE);
            }
        } while (!currPlayer.equalsIgnoreCase("X") && !currPlayer.equalsIgnoreCase("O")); //I don't know why I should use && instead of || but && worked for some reason

        String playAgainst = JOptionPane.showInputDialog(null, "Hi! Do you want to play against another player or against the computer?", "Another player or Computer?", JOptionPane.INFORMATION_MESSAGE); //Asks who they want to play against
        do {
            try {
                if (playAgainst.trim().equalsIgnoreCase("player")) {
                    String pVS = JOptionPane.showInputDialog(null, "Do you want to be player 1 or player 2? Player 1 will go first.", "Player 1 or Player 2?",JOptionPane.INFORMATION_MESSAGE);
                    setVersus(pVS);
                    playAgainst.equals("player");
                    who = playAgainst;
                    setAgainst(who);
                }
                else if (playAgainst.trim().equalsIgnoreCase("computer")) {
                    playAgainst.equals("computer");
                    who = playAgainst;
                    setAgainst(who);
                }
                else {
                    throw new againstException();
                }
            }
            catch (againstException ae) {
                JOptionPane.showMessageDialog(null, ae.getMessage());
                playAgainst = JOptionPane.showInputDialog(null, "Do you want to play against another player or against the computer?", "Another player or Computer?", JOptionPane.INFORMATION_MESSAGE);
            }
        } while (!playAgainst.equalsIgnoreCase("player") && !playAgainst.equalsIgnoreCase("computer"));
        //I don't know why I should use && instead of || but && worked for some reason

        //Player vs player
        if (playAgainst.equalsIgnoreCase("player")) {
            setGUIComponents(); 
            winningGame();
        }

        //Player vs computer
        if (playAgainst.equalsIgnoreCase("computer")) {
            //changePlayer(currPlayer);
            setGUIComponents(); 
            computerChoice();
            winningGame();
            changePlayer(currPlayer);
        }

    }
}