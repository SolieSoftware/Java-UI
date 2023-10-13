package com.codebind;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;


public class App extends JFrame {
    public App() {
        try {
            // Set the Nimbus look and feel
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setTitle("Login");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(500,500));
        JTabbedPane tab = new JTabbedPane();
        JPanel login = new LoginWindow();
        RegisterForm register = new RegisterForm();
        tab.addTab("Login",null,  login, null);
        tab.addTab("Register",null,  register, null);
        this.add(tab);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }
    public static void main(String[] args) {
        new App();
    }



}
