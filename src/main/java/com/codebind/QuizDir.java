package com.codebind;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizDir{
    JFrame quizFrame = new JFrame("Quiz Directory");
    JPanel infoPanel = new JPanel();
    JPanel infoSubPanel = new JPanel();
    JLabel info = new JLabel("Below are the different quiz Topics!");
    JButton exitButton = new JButton();
    JPanel capitalPanel = new JPanel();
    JButton[] capitalButtons;
    JPanel moviePanel = new JPanel();

    JButton movieButton = new JButton("Movie Quiz!!!");
    Font f1 = new Font(Font.SERIF, Font.BOLD, 35);

    QuizDir() {
        try {
            // Set the Nimbus look and feel
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        quizFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        quizFrame.setSize(600, 600);

        infoPanel.setSize(600, 100);
        infoPanel.setLayout(new GridLayout(2,1));

        exitButton.setSize(250,60);
        exitButton.setForeground(new Color(80,80,80));
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quizFrame.dispose();
                new Navigator();
            }
        });

        info.setForeground(new Color(0,0,0));
        info.setFont(f1);

        infoSubPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        infoSubPanel.add(exitButton);
        infoPanel.add(info);
        infoPanel.add(infoSubPanel);


        quizFrame.add(infoPanel);





        capitalPanel.setBounds(0, 100, 600, 100);
        capitalPanel.setBackground(new Color(255,255,255));
        capitalPanel.setLayout(new FlowLayout());
        quizFrame.add(capitalPanel);

        capitalButtons = new JButton[7];

        for (int i = 0; i<7; i++) {
            capitalButtons[i] = new JButton("Capital Quiz " + (i+1));
            capitalButtons[i].setSize(200,80);
            capitalPanel.add(capitalButtons[i]);
        }

        capitalButtons[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quizFrame.dispose();
                EuropeanCapitalsQuiz europeanCapitalsQuiz = new EuropeanCapitalsQuiz();

            }
        });

        capitalButtons[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quizFrame.dispose();
                new AsianCapitalsQuiz();
            }
        });

        capitalButtons[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quizFrame.dispose();
                new AfricanCapitalsQuiz();
            }
        });

        capitalButtons[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quizFrame.dispose();
                new AmericanCapitalsQuiz();
            }
        });

        capitalButtons[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quizFrame.dispose();
                new AustralianCapitalsQuiz();
            }
        });

        capitalButtons[5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quizFrame.dispose();
                new WorldCapitalsQuiz();
            }
        });




        moviePanel.setBounds(0, 200, 600, 100);
        moviePanel.setBackground(new Color(255,255,255));
        moviePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        quizFrame.add(moviePanel);

        movieButton.setSize(300, 130);

        movieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quizFrame.dispose();
                new MovieQuiz();
            }

        });
        moviePanel.add(movieButton);

        quizFrame.setVisible(true);


    }


    public static void main (String[] args) {
        new QuizDir();

    }

}