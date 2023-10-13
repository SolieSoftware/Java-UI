package com.codebind;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import static java.awt.font.TextAttribute.FONT;

public class NoughtsAndCrosses implements ActionListener {

    JFrame frame = new JFrame();
    JPanel titlePanel = new JPanel();
    JLabel title = new JLabel("Tic Tac Toe");

    JPanel scorePanel = new JPanel();
    JButton retryButton = new JButton("Retry");
    JLabel winner = new JLabel();

    JPanel backPanel = new JPanel();
    JButton exitButton = new JButton("Exit");
    JPanel mainPanel = new JPanel();
    JPanel[] gridPanels = new JPanel[9];

    JButton[] gridButtons = new JButton[9];
    ButtonGroup[] gridButtonGroup = new ButtonGroup[2];

    Font f2 = new Font("Arial", Font.BOLD, 100);
    Font f3 = new Font("Arial", Font.BOLD, 15);

    int turn = 0;

    public NoughtsAndCrosses() {
        try {
            // Set the Nimbus look and feel
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600,700));
        frame.setLayout(new BorderLayout());
        frame.setBackground(Color.BLACK);

        Font f1 = new Font("Arial", Font.BOLD, 60);
        title.setForeground(Color.GREEN);
        title.setFont(f1);

        titlePanel.setPreferredSize(new Dimension(400, 100));
        titlePanel.setLayout(new BorderLayout());

        retryButton.setPreferredSize(new Dimension(80,25));
        retryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i=0; i<9; i++) {
                    gridButtons[i].setText("");
                    winner.setText("");
                    winner.setVisible(false);
                    retryButton.setVisible(false);
                }
            }

        });

        retryButton.setVisible(false);
        winner.setFont(f3);
        winner.setVisible(false);


        scorePanel.setPreferredSize(new Dimension(100,100));
        scorePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        scorePanel.add(winner);
        scorePanel.add(retryButton);

        exitButton.setPreferredSize(new Dimension(80,40));
        exitButton.setMaximumSize(new Dimension(80,40));
        exitButton.setVerticalAlignment(SwingConstants.CENTER);

        exitButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               frame.dispose();
               GamingDirectory gd = new GamingDirectory();
           }
        });

        backPanel.setPreferredSize(new Dimension(100,100));
        backPanel.add(exitButton, BorderLayout.CENTER);




        titlePanel.add(scorePanel, BorderLayout.EAST);
        titlePanel.add(backPanel, BorderLayout.WEST);
        titlePanel.add(title, BorderLayout.CENTER);
        frame.add(titlePanel, BorderLayout.NORTH);

        mainPanel.setLayout(new GridLayout(3,3,5,5));
        mainPanel.setBackground(Color.BLACK);
        mainPanel.setPreferredSize(new Dimension(600,600));
        frame.add(mainPanel, BorderLayout.CENTER);

        for (int i=0; i<9; i++) {
            gridPanels[i] = new JPanel();
            gridPanels[i].setBackground(Color.GRAY);
            gridButtons[i] = new JButton();
            gridButtons[i].putClientProperty("GridNum", i);
            gridButtons[i].setPreferredSize(new Dimension(200,200));

            gridButtons[i].addActionListener(this);
            gridPanels[i].add(gridButtons[i]);
            mainPanel.add(gridPanels[i]);
        }



        frame.pack();
        frame.setVisible(true);
    }


    public void changeTurn() {
        if (turn==0) {
            turn = 1;
        } else {
            turn = 0;
        }
    }

    public static void main(String[] args) {
        NoughtsAndCrosses NC = new NoughtsAndCrosses();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int num = (Integer) ((JButton) (e.getSource())).getClientProperty("GridNum");
        if (gridButtons[num].getText() == "") {
            if (turn == 0) {
                gridButtons[num].setText("X");
                gridButtons[num].setForeground(Color.BLUE);
            } else {
                gridButtons[num].setText("O");
                gridButtons[num].setForeground(Color.RED);
            }
            gridButtons[num].setFont(f2);
            changeTurn();
        }

        Vector<String> set = new Vector();
        set.add(gridButtons[0].getText());
        set.add(gridButtons[1].getText());
        set.add(gridButtons[2].getText());
        checkWin(set);
        set.clear();
        set.add(gridButtons[3].getText());
        set.add(gridButtons[4].getText());
        set.add(gridButtons[5].getText());
        checkWin(set);
        set.clear();
        set.add(gridButtons[6].getText());
        set.add(gridButtons[7].getText());
        set.add(gridButtons[8].getText());
        checkWin(set);
        set.clear();
        set.add(gridButtons[0].getText());
        set.add(gridButtons[3].getText());
        set.add(gridButtons[6].getText());
        checkWin(set);
        set.clear();
        set.add(gridButtons[1].getText());
        set.add(gridButtons[4].getText());
        set.add(gridButtons[7].getText());
        checkWin(set);
        set.clear();
        set.add(gridButtons[2].getText());
        set.add(gridButtons[5].getText());
        set.add(gridButtons[8].getText());
        checkWin(set);
        set.clear();
        set.add(gridButtons[0].getText());
        set.add(gridButtons[4].getText());
        set.add(gridButtons[8].getText());
        checkWin(set);
        set.clear();
        set.add(gridButtons[2].getText());
        set.add(gridButtons[4].getText());
        set.add(gridButtons[6].getText());
        checkWin(set);
        set.clear();
    }

    public void checkWin(Vector<String> set) {
        for (String s: set) {
            if (!s.equals(set.get(0)) | s == "") {
                return;
            }
        }
        if (set.get(0) == "X") {
            winner.setText("Crosses Won!");
        } else {
            winner.setText("Noughts Won!");
        }
        winner.setVisible(true);

        retryButton.setVisible(true);

    }
}
