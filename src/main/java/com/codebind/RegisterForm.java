package com.codebind;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class RegisterForm extends JPanel {

    JPanel form = new JPanel();

    JLabel[] fieldNames = new JLabel[3];

    public static JTextField username = new JTextField();

    public static JPasswordField password = new JPasswordField();

    public static JTextField email = new JTextField();

    JButton registerButton = new JButton("Submit");

    private String url = "jdbc:postgresql://localhost:5432/Login_Details";
    private String user_post = "postgres";
    private String password_post = "postgres";

    Font f1 = new Font("Arial", Font.BOLD, 15);

    JPanel[] gridPanels = new JPanel[9];
    JPanel[] southPanel = new JPanel[3];
    RegisterForm() {
        try {
            // Set the Nimbus look and feel
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setPreferredSize(new Dimension(500,500));

        form.setPreferredSize(new Dimension(500,500));
        form.setLocation(0,0);
        form.setLayout(new GridLayout(9, 1));

        Dimension fieldDimension = new Dimension(200,30);

        for (int i=0; i<9;i++) {
            gridPanels[i] = new JPanel();
        }


        for (int i=0; i<3; i++) {
            fieldNames[i] = new JLabel();
            fieldNames[i].setFont(f1);
            southPanel[i] = new JPanel();
            southPanel[i].setLayout(new FlowLayout(FlowLayout.CENTER));
            southPanel[i].add(fieldNames[i]);
            if (i==0) {
                fieldNames[i].setText("Enter your username:");
                gridPanels[1].setLayout(new BorderLayout());
                gridPanels[1].add(southPanel[i], BorderLayout.SOUTH);
                username.setPreferredSize(fieldDimension);
                gridPanels[2].add(username);
                form.add(gridPanels[1]);
                form.add(gridPanels[2]);
            } else if (i==1) {
                fieldNames[i].setText("Enter your new password: ");
                gridPanels[3].setLayout(new BorderLayout());
                gridPanels[3].add(southPanel[i], BorderLayout.SOUTH);
                password.setPreferredSize(fieldDimension);
                gridPanels[4].add(password);
                form.add(gridPanels[3]);
                form.add(gridPanels[4]);
            } else if (i==2) {
                fieldNames[i].setText("Enter in your email: ");
                gridPanels[5].setLayout(new BorderLayout());
                gridPanels[5].add(southPanel[i], BorderLayout.SOUTH);
                email.setPreferredSize(fieldDimension);
                gridPanels[6].add(email);
                form.add(gridPanels[5]);
                form.add(gridPanels[6]);
            }
        }




        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkEmptyFields() == false) {
                    JOptionPane.showMessageDialog(null, "You must fill in all the necessary fields. ");
                    return;
                }

                String user = username.getText();
                char[] pass = password.getPassword();
                String mail = email.getText();


                if (checkUsernameExists(user) == false) {
                    JOptionPane.showMessageDialog(null, "This username already exists please pick another one. ");
                    username.setText("");
                    password.setText("");
                    email.setText("");
                    return;
                }

                addRecord(user, pass.toString(), mail);

                username.setText("");
                password.setText("");
                email.setText("");

                JOptionPane.showMessageDialog(null, "Welcome to the Club!! Please login on the login page. ");
            }
        });


        registerButton.setPreferredSize(new Dimension(200,40));
        gridPanels[7].add(registerButton);
        form.add(gridPanels[7]);

        form.add(gridPanels[7]);

        this.add(form);
        this.setVisible(true);

    }

    public static boolean checkEmptyFields() {
        if (!username.getText().isEmpty() && !password.getText().isEmpty() && !email.getText().isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

    public boolean checkUsernameExists(String user) {
        try {
            Connection connection = DriverManager.getConnection(url, user_post, password_post);
            Statement statement = connection.createStatement();

            String query = "SELECT username FROM login_details WHERE username=\'"+user+"\';";
            ResultSet resultSet = statement.executeQuery(query);

            String checkUser = null;
            while (resultSet.next()) {
                checkUser = resultSet.getString("username");
            }

            if (checkUser == null) {
                return true;
            } else {
                return false;
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public void addRecord(String user, String pass, String email) {
        try {
            Connection connection = DriverManager.getConnection(url, user_post, password_post);
            Statement statement = connection.createStatement();
            String query = "INSERt INTO login_details (username, password, email) VALUES (\'" +
                    user + "\', \'" + pass + "\', \'" + email +"\');";
            statement.executeUpdate(query);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
