package com.codebind;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;


public class App {

    public App() {





    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pages");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500,500));
        JTabbedPane tab = new JTabbedPane();
        JPanel login = new LoginWindow();
        RegisterForm register = new RegisterForm();
        tab.addTab("Login",null,  login, null);
        tab.addTab("Register",null,  register, null);
        frame.add(tab);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }



}
