package TicTacToe;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel title_textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    Random random = new Random();
    // this will be player 1 turn if it is true and player 2 turn if it is false.
    boolean player_turn;

    TicTacToe() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // sets the size of the frame
        frame.setSize(800, 800);
        // creates the background color
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        title_textfield.setBackground(new Color(25, 25, 25));
        title_textfield.setForeground(new Color(25, 255, 0));
        title_textfield.setFont(new Font("Comic Sans", Font.BOLD, 75));
        title_textfield.setHorizontalAlignment(JLabel.CENTER);
        title_textfield.setText("Java Tic-Tac-Toe");
        title_textfield.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 100);

        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(new Color(150, 150, 150));

        // Creates the buttons
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("Pristina", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        // Title for the window
        title_panel.add(title_textfield);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);

        startingTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player_turn) {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        player_turn = false;
                        title_textfield.setText("O's Turn");
                        checkForWinner();
                        checkForTie();
                    }
                } else {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        player_turn = true;
                        title_textfield.setText("X's Turn");
                        checkForWinner();
                        checkForTie();
                    }
                }
            }
        }

    }

    public void startingTurn() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (random.nextInt(2) == 0) {
            player_turn = true;
            title_textfield.setText("X Goes First");
        } else {
            player_turn = false;
            title_textfield.setText("O Goes First");
        }
    }

    public void checkForWinner() {
        // X player win conditions
        if (buttons[0].getText().equals("X") && buttons[1].getText().equals("X") && buttons[2].getText().equals("X")) {
            xWinner(0, 1, 2);
        }
        if (buttons[3].getText().equals("X") && buttons[4].getText().equals("X") && buttons[5].getText() .equals("X")) {
            xWinner(3, 4, 5);
        }
        if (buttons[6].getText().equals("X") && buttons[7].getText().equals("X") && buttons[8].getText().equals("X")) {
            xWinner(6, 7, 8);
        }
        if (buttons[0].getText().equals("X") && buttons[3].getText().equals("X") && buttons[6].getText().equals("X")) {
            xWinner(0, 3, 6);
        }
        if (buttons[1].getText().equals("X") && buttons[4].getText().equals("X") && buttons[7].getText().equals("X")) {
            xWinner(1, 4, 7);
        }
        if (buttons[2].getText().equals("X") && buttons[5].getText().equals("X") && buttons[8].getText().equals("X")) {
            xWinner(2, 5, 8);
        }
        if (buttons[0].getText().equals("X") && buttons[4].getText().equals("X") && buttons[8].getText().equals("X")) {
            xWinner(0, 4, 8);
        }
        if (buttons[2].getText().equals("X") && buttons[4].getText().equals("X") && buttons[6].getText().equals("X")) {
            xWinner(2, 4, 6);
        }

        // O player win conditions
        if (buttons[0].getText().equals("O") && buttons[1].getText().equals("O") && buttons[2].getText().equals("O")) {
            oWinner(0, 1, 2);
        }
        if (buttons[3].getText().equals("O") && buttons[4].getText().equals("O") && buttons[5].getText().equals("O")) {
            oWinner(3, 4, 5);
        }
        if (buttons[6].getText().equals("O") && buttons[7].getText().equals("O") && buttons[8].getText().equals("O")) {
            oWinner(6, 7, 8);
        }
        if (buttons[0].getText().equals("O") && buttons[3].getText().equals("O") && buttons[6].getText().equals("O")) {
            oWinner(0, 3, 6);
        }
        if (buttons[1].getText().equals("O") && buttons[4].getText().equals("O") && buttons[7].getText().equals("O")) {
            oWinner(1, 4, 7);
        }
        if (buttons[2].getText().equals("O") && buttons[5].getText().equals("O") && buttons[8].getText().equals("O")) {
            oWinner(2, 5, 8);
        }
        if (buttons[0].getText().equals("O") && buttons[4].getText().equals("O") && buttons[8].getText().equals("O")) {
            oWinner(0, 4, 8);
        }
        if (buttons[2].getText().equals("O") && buttons[4].getText().equals("O") && buttons[6].getText().equals("O")) {
            oWinner(2, 4, 6);
        }
    }

    public void checkForTie() {
        boolean[] arr = {!(buttons[0].getText().equals("X") && buttons[1].getText().equals("X") && buttons[2].getText().equals("X")), 
            !(buttons[3].getText().equals("X") && buttons[4].getText().equals("X") && buttons[5].getText().equals("X")), 
            !(buttons[6].getText().equals("X") && buttons[7].getText().equals("X") && buttons[8].getText().equals("X")), 
            !(buttons[0].getText().equals("X") && buttons[3].getText().equals("X") && buttons[6].getText().equals("X")), 
            !(buttons[1].getText().equals("X") && buttons[4].getText().equals("X") && buttons[7].getText().equals("X")), 
            !(buttons[2].getText().equals("X") && buttons[5].getText().equals("X") && buttons[8].getText().equals("X")), 
            !(buttons[0].getText().equals("X") && buttons[4].getText().equals("X") && buttons[8].getText().equals("X")), 
            !(buttons[2].getText().equals("X") && buttons[4].getText().equals("X") && buttons[6].getText().equals("X")), 
            !(buttons[0].getText().equals("O") && buttons[1].getText().equals("O") && buttons[2].getText().equals("O")), 
            !(buttons[3].getText().equals("O") && buttons[4].getText().equals("O") && buttons[5].getText().equals("O")), 
            !(buttons[6].getText().equals("O") && buttons[7].getText().equals("O") && buttons[8].getText().equals("O")), 
            !(buttons[0].getText().equals("O") && buttons[3].getText().equals("O") && buttons[6].getText().equals("O")), 
            !(buttons[2].getText().equals("O") && buttons[5].getText().equals("O") && buttons[8].getText().equals("O")), 
            !(buttons[2].getText().equals("O") && buttons[5].getText().equals("O") && buttons[8].getText().equals("O")), 
            !(buttons[0].getText().equals("O") && buttons[4].getText().equals("O") && buttons[8].getText().equals("O")), 
            !(buttons[2].getText().equals("O") && buttons[4].getText().equals("O") && buttons[6].getText().equals("O"))};
        
        if (!(buttons[0].getText().equals("")) && !(buttons[1].getText().equals("")) && !(buttons[2].getText().equals("")) 
        && !(buttons[3].getText().equals("")) && !(buttons[4].getText().equals("")) && !(buttons[5].getText().equals("")) 
        && !(buttons[6].getText().equals("")) && !(buttons[7].getText().equals("")) && !(buttons[8].getText().equals(""))) {
            for (boolean i : arr) {
                if (i) {
                    tie();
                }
            }
        }
    }

    // Changes the button color of the winning player
    public void xWinner(int a, int b, int c) {
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);

        // disable all buttons after the game
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        title_textfield.setText("X Wins!");
    }

    public void oWinner(int a, int b, int c) {
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);

        // disable all buttons after the game
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        title_textfield.setText("O Wins!");
    }

    public void tie() {
        for (int i = 0; i < 9; i++) {
            buttons[i].setBackground(Color.red);
            buttons[i].setEnabled(false);
        }
        title_textfield.setText("Tie!");
    }
}
