package com.codebind;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Font.DIALOG;
import static java.awt.font.TextAttribute.FONT;
import static java.awt.font.TextAttribute.WEIGHT_BOLD;

public class QuizDir{

    JFrame quizFrame = new JFrame("Quiz Directory");

    JPanel infoPanel = new JPanel();

    JLabel info = new JLabel("Below are the different quiz Topics!");

    JPanel capitalPanel = new JPanel();

    JButton[] capitalButtons;

    JPanel moviePanel = new JPanel();

    JButton movieButton = new JButton("Movie Quiz!!!");







    QuizDir() {
        try {
            // Set the Nimbus look and feel
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        quizFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        quizFrame.setSize(600, 600);
        quizFrame.setLocationRelativeTo(null);
        quizFrame.setLayout(null);

        infoPanel.setSize(600, 100);
        infoPanel.setAlignmentY(Component.TOP_ALIGNMENT);
        infoPanel.setLayout(new FlowLayout());
        quizFrame.add(infoPanel);

        Font f1 = new Font(Font.SERIF, Font.BOLD, 20);

        info.setForeground(new Color(0,0,0));
        info.setFont(f1);
        info.setVerticalAlignment(SwingConstants.CENTER);
        infoPanel.add(info);

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
                CapitalQuizOne capitalQuizOne = new CapitalQuizOne();

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
                MovieQuiz movieQuiz = new MovieQuiz();
            }

        });
        moviePanel.add(movieButton);

        quizFrame.setVisible(true);


    }


    public static void main (String[] args) {
        QuizDir quizDirectory = new QuizDir();

    }

}