package com.codebind;

import com.codebind.App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class LoginWindow {
    private JFrame loginFrame = new JFrame("Login");
    private JPanel loginPanel = new JPanel();
    private JLabel userLabel = new JLabel("Username");
    private JTextField UsernameField = new JTextField();

    private JLabel passwordLabel = new JLabel("Password");

    private JPasswordField passwordField = new JPasswordField();

    private JButton buttonMain = new JButton("Login");
    LoginWindow() {

        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setPreferredSize(new Dimension(400, 250));
        loginFrame.setLocation(600, 300);
        loginFrame.add(loginPanel);
        loginFrame.pack();




        loginPanel.setLayout(null);
        loginPanel.setBackground(new Color(200,200,200));


        userLabel.setBounds(150, 20, 100, 20);
        userLabel.setForeground(new Color(0, 0, 0));


        UsernameField.setBounds(150, 40, 100, 20);


        passwordLabel.setBounds(150, 70, 100, 20);
        passwordLabel.setForeground(new Color(0, 0, 0));


        passwordField.setBounds(150, 90, 100, 20);

        loginPanel.add(userLabel);
        loginPanel.add(UsernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);



        buttonMain.setBounds(150, 140, 100, 30);

        loginPanel.add(buttonMain);


        buttonMain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = UsernameField.getText();
                char[] input = passwordField.getPassword();
                if (isUsernameAndPasswordCorrect(user, input)) {
                    launchNavigator();
                } else {
                    JOptionPane.showMessageDialog(null, "Unsuccessful Login. Who are you!");
                    int ans = JOptionPane.showConfirmDialog(null, "Are you sure you are in the right place?",
                            "Time to go!",
                            JOptionPane.YES_NO_OPTION);
                    if (ans==1) {
                        loginFrame.dispose();
                    } else {
                        UsernameField.setText("");
                        passwordField.setText("");
                    }
                }

            }
        });

        loginFrame.setVisible(true);
    }

    public void launchNavigator() {
        loginFrame.dispose();
        Navigator nav = new Navigator();

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