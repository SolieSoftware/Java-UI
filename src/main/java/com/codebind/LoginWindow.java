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

    JPanel[] gridPanels = new JPanel[5];
    JPanel[] blankPanels = new JPanel[4];

    Font f1 = new Font("Arial", Font.BOLD, 20);

    public LoginWindow(){
        try {
            // Set the Nimbus look and feel
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.setPreferredSize(new Dimension(500,500));
        this.setLayout(new BorderLayout());

        loginPanel.setLayout(new GridLayout(8,1));
        loginPanel.setPreferredSize(new Dimension(450,450));
        loginPanel.setBackground(new Color(200,200,200));

        JPanel container = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        container.add(loginPanel);
        this.add(container, BorderLayout.CENTER);


        Dimension fieldSize = new Dimension(150,30);
        GridBagConstraints constraints = new GridBagConstraints();

        for (int i=0; i<4; i++) {
            blankPanels[i] = new JPanel();
        }

        loginPanel.add(blankPanels[0]);

        userLabel.setForeground(new Color(0, 0, 0));
        userLabel.setFont(f1);
        gridPanels[0] = new JPanel();
        gridPanels[0].add(userLabel);
        loginPanel.add(gridPanels[0]);

        UsernameField.setPreferredSize(fieldSize);
        gridPanels[1] = new JPanel();
        gridPanels[1].add(UsernameField);
        loginPanel.add(gridPanels[1]);


        passwordLabel.setForeground(new Color(0, 0, 0));
        passwordLabel.setFont(f1);
        gridPanels[2] = new JPanel();
        gridPanels[2].add(passwordLabel);
        loginPanel.add(gridPanels[2]);

        passwordField.setPreferredSize(fieldSize);
        gridPanels[3] = new JPanel();
        gridPanels[3].add(passwordField);
        loginPanel.add(gridPanels[3]);


        buttonMain.setPreferredSize(new Dimension(200, 50));
        gridPanels[4] = new JPanel();
        gridPanels[4].add(buttonMain);
        loginPanel.add(gridPanels[4]);

        loginPanel.add(blankPanels[1]);

        loginPanel.add(blankPanels[2]);

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

        this.setVisible(true);

    }

    public void launchNavigator() {

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

                resultSet.close();
                statement.close();
                connection.close();

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