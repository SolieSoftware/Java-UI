package com.codebind;

import com.codebind.App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class LoginWindow {
    LoginWindow() {
        JPanel loginPanel = new JPanel();
        JFrame loginFrame = new JFrame("Login");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setPreferredSize(new Dimension(400, 250));
        loginFrame.setLocation(600, 300);
        loginFrame.add(loginPanel);

        loginFrame.pack();




        loginPanel.setLayout(null);
        loginPanel.setBackground(new Color(200,200,200));

        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(150, 20, 100, 20);
        userLabel.setForeground(new Color(0, 0, 0));

        JTextField UsernameField = new JTextField();
        UsernameField.setBounds(150, 40, 100, 20);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(150, 70, 100, 20);
        passwordLabel.setForeground(new Color(255, 0, 0));

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(150, 90, 100, 20);

        loginPanel.add(userLabel);
        loginPanel.add(UsernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);


        JButton buttonMain = new JButton("Login");
        buttonMain.setBounds(150, 140, 100, 30);

        loginPanel.add(buttonMain);


        buttonMain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = UsernameField.getText();
                char[] input = passwordField.getPassword();
                if (isUsernameAndPasswordCorrect(user, input)) {



                } else {
                    JOptionPane.showMessageDialog(null, "Unsuccessful Login. Who are you!");
                }

            }
        });

        loginFrame.setVisible(true);
    }

    private static boolean isUsernameAndPasswordCorrect(String user, char[] password) {
        boolean isCorrect = true;
        String correctUsername = "Sol";
        char[] correctPassword = {'L', 'o', 's', 't', '!'};
        boolean isCorrectUser = user.equals(correctUsername);
        boolean isCorrectP = Arrays.equals(password, correctPassword);



        if (isCorrectUser && isCorrectP) {
            return true;
        } else {
            return false;
        }

    }




}