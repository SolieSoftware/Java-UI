package com.codebind;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;


public class App {

    public App() {

    }


    public static void main(String[] args) {
        try {
            // Set the Nimbus look and feel
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        JFrame frame = new JFrame("Pages");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500,500));
        JTabbedPane tab = new JTabbedPane();
        JPanel login = new LoginWindow();
        RegisterForm register = new RegisterForm();
        tab.addTab("Login",null,  login, null);
        tab.addTab("Register",null,  register, null);
        frame.add(tab);

        WindowListener listener = new WindowAdapter() {
            public void WindowOpened(WindowEvent evt) {
                Frame newFrame = (Frame) evt.getSource();
                if ("Navigator".equals(frame.getTitle())) {
                    frame.dispose();
                };
            }
        };

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }



}
