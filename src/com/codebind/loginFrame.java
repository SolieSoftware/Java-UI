package com.codebind;

import javax.swing.*;
import java.awt.*;

public class loginFrame {
    loginFrame(){
        JFrame frame = new JFrame("App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400, 250));
        frame.setLocation(600, 300);
        frame.setContentPane(new App().panelMain);

        frame.pack();

        frame.setVisible(true);
    }
}
