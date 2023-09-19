package com.codebind;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;


public class App {
    private JButton buttonMain;
    public JPanel panelMain;
    private JTextField UsernameField;
    private JLabel userLabel;
    private JPasswordField passwordField;
    private JLabel passwordLabel;

    private String username = "Sol";


    public App() {


        panelMain = new JPanel();
        panelMain.setLayout(null);
        panelMain.setBackground(new Color(200,200,200));

        userLabel = new JLabel("Username");
        userLabel.setBounds(150, 20, 100, 20);
        userLabel.setForeground(new Color(0, 0, 0));

        UsernameField = new JTextField();
        UsernameField.setBounds(150, 40, 100, 20);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(150, 70, 100, 20);
        passwordLabel.setForeground(new Color(0, 0, 0));

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 90, 100, 20);




        buttonMain = new JButton("Login");
        buttonMain.setBounds(150, 140, 100, 30);


        panelMain.add(userLabel);
        panelMain.add(UsernameField);
        panelMain.add(passwordLabel);
        panelMain.add(passwordField);
        panelMain.add(buttonMain);


        buttonMain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = UsernameField.getText();
                char[] input = passwordField.getPassword();
                if (user.equals(username) && isPasswordCorrect(input)) {
                    JOptionPane.showMessageDialog(null,"Login Successful!! ");

                } else {
                    JOptionPane.showMessageDialog(null, "Unsuccessful Login. Who are you!");
                }

            }
        });
    }

    private static boolean isPasswordCorrect(char[] input) {
        boolean isCorrect = true;
        char[] correctPassword = {'L', 'o', 's', 't', '!'};
        isCorrect= Arrays.equals(input, correctPassword);

        Arrays.fill(correctPassword, '0');
        return isCorrect;
    }

    public static void main(String[] args) {
        loginFrame logFrame = new loginFrame();

    }


}
