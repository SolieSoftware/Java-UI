package com.codebind;

import javax.swing.*;
import java.awt.*;

import static java.awt.Font.DIALOG;
import static java.awt.font.TextAttribute.FONT;
import static java.awt.font.TextAttribute.WEIGHT_BOLD;

public class QuizDir{

    JFrame quizFrame = new JFrame("Quiz Directory");

    JPanel infoPanel = new JPanel();

    JLabel info = new JLabel("Below are the different quiz Topics!");

    JPanel capitalPanel = new JPanel();

    JButton capitalButton1 = new JButton("Capital Quiz 1");
    JButton capitalButton2 = new JButton("Capital Quiz 2");
    JButton capitalButton3 = new JButton("Capital Quiz 3");
    JButton capitalButton4 = new JButton("Capital Quiz 4");
    JButton capitalButton5 = new JButton("Capital Quiz 5");

    JButton capitalButton6 = new JButton("Capital Quiz 6");




    QuizDir() {
        quizFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        quizFrame.setSize(600, 600);
        quizFrame.setLocationRelativeTo(null);
        quizFrame.setLayout(null);

        infoPanel.setSize(600, 30);
        infoPanel.setAlignmentY(Component.TOP_ALIGNMENT);
        infoPanel.setLayout(new FlowLayout());
        quizFrame.add(infoPanel);

        Font f1 = new Font(Font.SERIF, Font.BOLD, 20);

        info.setForeground(new Color(0,0,0));
        info.setFont(f1);
        info.setVerticalAlignment(SwingConstants.CENTER);
        infoPanel.add(info);

        capitalPanel.setBounds(0, 30, 600, 100);
        capitalPanel.setBackground(new Color(255,255,255));
        capitalPanel.setLayout(new FlowLayout());
        quizFrame.add(capitalPanel);

        capitalButton1.setSize(80,40);
        capitalButton2.setSize(80,40);
        capitalButton3.setSize(80,40);
        capitalButton4.setSize(80,40);
        capitalButton5.setSize(80,40);
        capitalButton6.setSize(80,40);




        capitalPanel.add(capitalButton1);
        capitalPanel.add(capitalButton2);
        capitalPanel.add(capitalButton3);
        capitalPanel.add(capitalButton4);
        capitalPanel.add(capitalButton5);
        capitalPanel.add(capitalButton6);






        quizFrame.setVisible(true);


    }

}