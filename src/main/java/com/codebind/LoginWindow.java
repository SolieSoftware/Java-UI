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

public class LoginWindow extends JPanel {
   // private JFrame loginFrame = new JFrame("Login");
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
    public LoginWindow(){
/*
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setPreferredSize(new Dimension(400, 250));
        loginFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        loginFrame.add(loginPanel);
*/
        this.setPreferredSize(new Dimension(500,500));
        this.setLayout(new BorderLayout());

        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
        loginPanel.setPreferredSize(new Dimension(450,450));
        loginPanel.setBackground(new Color(200,200,200));


        Dimension fieldSize = new Dimension(150,30);

        loginPanel.add(Box.createRigidArea(new Dimension(450,50)));
        userLabel.setPreferredSize(fieldSize);
        userLabel.setMaximumSize(fieldSize);
        userLabel.setForeground(new Color(0, 0, 0));
        loginPanel.add(userLabel);

        loginPanel.add(Box.createRigidArea(new Dimension(450,20)));

        UsernameField.setPreferredSize(fieldSize);
        UsernameField.setMaximumSize(fieldSize);
        loginPanel.add(UsernameField);

        loginPanel.add(Box.createRigidArea(new Dimension(450,20)));

        passwordLabel.setPreferredSize(fieldSize);
        passwordLabel.setMaximumSize(fieldSize);
        passwordLabel.setForeground(new Color(0, 0, 0));
        loginPanel.add(passwordLabel);

        loginPanel.add(Box.createRigidArea(new Dimension(450,20)));

        passwordField.setPreferredSize(fieldSize);
        passwordField.setMaximumSize(fieldSize);
        loginPanel.add(passwordField);

        loginPanel.add(Box.createRigidArea(new Dimension(450,50)));

        buttonMain.setPreferredSize(new Dimension(200, 50));

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
                        //loginFrame.dispose();
                    } else {
                        UsernameField.setText("");
                        passwordField.setText("");
                    }
                }

            }

        });

        this.add(loginPanel, BorderLayout.CENTER);
        this.setVisible(true);

       // loginFrame.pack();
        //loginFrame.setVisible(true);

    }

    public void launchNavigator() {
        //loginFrame.dispose();
        Navigator nav = new Navigator();

    }

    public boolean isUsernameAndPasswordCorrect(String user, char[] password) {

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