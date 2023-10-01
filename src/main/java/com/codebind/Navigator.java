package com.codebind;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Navigator {
    private JFrame navFrame = new JFrame("Navigator");
    private JPanel quizPanel = new JPanel();

    private JLabel quizPanelLabel = new JLabel("<html>In this area you will find a button " +
            "to different quizzes than you can attempt." +
            " Beware these quizzes were devised to test you! <html>");

    private JButton quizPageLaunchButton = new JButton("Start Quiz...");
    Navigator() {
        navFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        navFrame.setPreferredSize(new Dimension(600, 400));
        navFrame.setLocationRelativeTo(null);

        quizPanel.setBackground(new Color(200, 50, 200));
        quizPanel.setLayout(new BorderLayout());

        quizPanelLabel.setHorizontalAlignment(SwingConstants.CENTER);
        quizPanelLabel.setForeground(new Color(0, 255, 0));

        quizPageLaunchButton.setPreferredSize(new Dimension(120, 40));
        quizPageLaunchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navFrame.dispose();
                new QuizDir();
            }
        });

        quizPanel.add(quizPanelLabel, BorderLayout.CENTER);
        quizPanel.add(quizPageLaunchButton, BorderLayout.SOUTH);

        navFrame.add(quizPanel);
        navFrame.pack();
        navFrame.setVisible(true);
    }

}