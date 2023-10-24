package com.codebind;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Navigator extends CentreScreen{
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
        this.setSize(new Dimension(600, 600));
        this.setLayout(new BorderLayout());
        setUpFrame();

        //quizPanel.setBackground(new Color(200, 50, 200));
        quizPanel.setPreferredSize((new Dimension(150,600)));
        quizPanel.setLayout(new BorderLayout());

        quizPageLaunchButton.setPreferredSize(new Dimension(150,600));
        quizPageLaunchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new QuizDir();
            }
        });

        LaunchGames.setPreferredSize(new Dimension(150,600));
        LaunchGames.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GamingDirectory();
            }
        });


        quizPanel.add(quizPageLaunchButton, BorderLayout.CENTER);
        gamingPanel.add(LaunchGames);

        this.add(gamingPanel, BorderLayout.EAST);
        this.add(quizPanel, BorderLayout.WEST);

        this.pack();
        this.setVisible(true);
    }

    public static void main(String args[]) {

        new Navigator();

    }

}