package com.codebind;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Navigator {
    private JFrame navFrame = new JFrame("Navigator");
    private JPanel quizPanel = new JPanel();

    private JPanel gamingPanel = new JPanel();

    private JButton quizPageLaunchButton = new JButton("Start Quizzing...");

    private JButton LaunchGames = new JButton("Start Gaming...");
    Navigator() {
        try {
            // Set the Nimbus look and feel
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        navFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        navFrame.setPreferredSize(new Dimension(600, 600));
        navFrame.setLocationRelativeTo(null);
        navFrame.setLayout(new BorderLayout());


        //quizPanel.setBackground(new Color(200, 50, 200));
        quizPanel.setPreferredSize((new Dimension(150,600)));
        quizPanel.setLayout(new BorderLayout());

        quizPageLaunchButton.setPreferredSize(new Dimension(150,600));
        quizPageLaunchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navFrame.dispose();
                new QuizDir();
            }
        });

        LaunchGames.setPreferredSize(new Dimension(150,600));
        LaunchGames.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navFrame.dispose();
                new GamingDirectory();
            }
        });


        quizPanel.add(quizPageLaunchButton, BorderLayout.CENTER);
        gamingPanel.add(LaunchGames);

        navFrame.add(gamingPanel, BorderLayout.EAST);
        navFrame.add(quizPanel, BorderLayout.WEST);

        navFrame.pack();
        navFrame.setVisible(true);
    }

    public static void main(String args[]) {

        new Navigator();

    }

}