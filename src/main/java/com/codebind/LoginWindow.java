package com.codebind;

import com.codebind.App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;

public class LoginWindow {
    private JFrame loginFrame = new JFrame("Login");
    private JPanel loginPanel = new JPanel();
    private JLabel userLabel = new JLabel("Username");
    private JTextField UsernameField = new JTextField();

    private JLabel passwordLabel = new JLabel("Password");

    private JPasswordField passwordField = new JPasswordField();

    private JButton buttonMain = new JButton("Login");

    private String url = "jdbc:postgresql://localhost:5432/Login_Details";

    private String postgres_username = "postgres";

    private String postgres_password = "postgres";

    JButton RegisterButton = new JButton();
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
                    int ans = JOptionPane.showConfirmDialog(null, "Would you like to try again?",
                            "Incorrect Login",
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

    private boolean isUsernameAndPasswordCorrect(String user, char[] password) {

        try {
            Connection connection = DriverManager.getConnection(url, postgres_username, postgres_password);
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM login_details WHERE username=\'" + user + "\';";

            String resultPassword = null;
            try {
                ResultSet resultSet = statement.executeQuery(query);
                resultPassword = null;
                while (resultSet.next()) {
                    resultPassword = resultSet.getString("password");
                }
                char[] correctPassword = resultPassword.toCharArray();
                boolean isCorrectP = Arrays.equals(password, correctPassword);

                if (isCorrectP) {
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "The password was incorrect.");
                    return false;
                }


            } catch (Exception e) {
                if (resultPassword == null) {
                    JOptionPane.showMessageDialog(null, "This username does not exist in the database.");
                }
                e.printStackTrace();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cannot Connect to server at the moment. Please retry again soon!");
            e.printStackTrace();

        }

        return false;

    }
}