package com.codebind;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.font.TextAttribute.FONT;

public class NoughtsAndCrosses {

    JFrame frame = new JFrame();
    JPanel titlePanel = new JPanel();

    JLabel title = new JLabel("Tic Tac Toe");
    JPanel mainPanel = new JPanel();
    JPanel[] gridPanels = new JPanel[9];

    JButton[] gridButtons = new JButton[9];

    Font f2 = new Font("Arial", Font.BOLD, 100);

    int turn = 0;

    public NoughtsAndCrosses() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600,700));
        frame.setLayout(new BorderLayout());
        frame.setBackground(Color.BLACK);

        Font f1 = new Font("Arial", Font.BOLD, 60);
        title.setForeground(Color.GREEN);
        title.setFont(f1);
        titlePanel.add(title);
        titlePanel.setPreferredSize(new Dimension(600, 100));
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

            gridButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (turn == 0) {
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
                        ;
                    }

                }
            });
            gridPanels[i].add(gridButtons[i]);
            mainPanel.add(gridPanels[i]);
        }




        frame.pack();
        frame.setVisible(true);


    }


    public void changeTurn() {
        if (turn==0) {
            turn =1;
        } else {
            turn = 0;
        }
    }
}
