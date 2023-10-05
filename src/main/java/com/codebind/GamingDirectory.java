package com.codebind;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamingDirectory extends JFrame {

    JPanel[] gamingPanels = new JPanel[9];

    JButton OXButton = new JButton();

    public GamingDirectory() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setPreferredSize(new Dimension(600,600));
        this.setLayout(new GridLayout(3,3));

        for (int i=0; i<9; i++) {
            gamingPanels[i] = new JPanel();
            gamingPanels[i].setPreferredSize(new Dimension(200,200));
            gamingPanels[i].setLayout(new BorderLayout());
            this.add(gamingPanels[i]);
        }

        OXButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NoughtsAndCrosses();
                dispose();
            }
        });
        gamingPanels[0].add(OXButton);

        this.pack();
        this.setVisible(true);





    }
}
