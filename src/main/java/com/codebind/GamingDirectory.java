package com.codebind;

import com.seaglasslookandfeel.SeaGlassLookAndFeel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamingDirectory extends JFrame {

    JPanel titlePanel = new JPanel();
    JLabel title = new JLabel("Gaming Directory");
    JPanel mainPanel = new JPanel();

    JPanel exitPanel = new JPanel();
    JButton exitButton = new JButton("Exit");

    JPanel[] gamingPanels = new JPanel[9];

    JButton OXButton = new JButton();

    public GamingDirectory() {
        try {
            // Set the Nimbus look and feel
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setPreferredSize(new Dimension(600,700));
        this.setLayout(new BorderLayout());

        exitButton.setPreferredSize(new Dimension(100,50));
        exitButton.setVerticalAlignment(SwingConstants.CENTER);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Navigator();
            }
        });

        exitPanel.setPreferredSize(new Dimension(100,100));
        exitPanel.add(exitButton);

        title.setFont(new Font("Arial", Font.BOLD, 50));
        title.setHorizontalAlignment(SwingConstants.CENTER);


        titlePanel.setLayout(new BorderLayout());
        titlePanel.setPreferredSize(new Dimension(600,100));
        titlePanel.add(title, BorderLayout.CENTER);
        titlePanel.add(exitPanel, BorderLayout.WEST);

        mainPanel.setPreferredSize(new Dimension(600,600));
        mainPanel.setLayout(new GridLayout(3,3));

        for (int i=0; i<9; i++) {
            gamingPanels[i] = new JPanel();
            gamingPanels[i].setPreferredSize(new Dimension(200,200));
            gamingPanels[i].setLayout(new BorderLayout());
            mainPanel.add(gamingPanels[i]);
        }


        OXButton.setText("Noughts And Crosses");
        OXButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NoughtsAndCrosses();
                dispose();
            }
        });

        gamingPanels[0].add(OXButton);

        this.add(mainPanel, BorderLayout.CENTER);
        this.add(titlePanel, BorderLayout.NORTH);
        this.pack();
        this.setVisible(true);

    }

    public static void main (String args[]) {
        new GamingDirectory();
    }

}
