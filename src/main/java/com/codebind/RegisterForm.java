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
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));

        Dimension fieldDimension = new Dimension(200,30);

        form.add(Box.createRigidArea(new Dimension(500, 40)));
        for (int i=0; i<3; i++) {
            fieldNames[i] = new JLabel();
            if (i==0) {
                fieldNames[i].setText("Enter your username:");
                username.setMaximumSize(fieldDimension);
                username.setPreferredSize(fieldDimension);
                form.add(fieldNames[i]);
                form.add(username);
            } else if (i==1) {
                fieldNames[i].setText("Enter your new password: ");
                password.setMaximumSize(fieldDimension);
                password.setPreferredSize(fieldDimension);
                form.add(fieldNames[i]);
                form.add(password);
            } else if (i==2) {
                fieldNames[i].setText("Enter in your email: ");
                email.setMaximumSize(fieldDimension);
                email.setPreferredSize(fieldDimension);
                form.add(fieldNames[i]);
                form.add(email);
            }
            form.add(Box.createRigidArea(new Dimension(500, 40)));
        }

        registerButton.setPreferredSize(new Dimension(150, 50));
        registerButton.setMinimumSize(new Dimension(150, 50));
        registerButton.setMaximumSize(new Dimension(150, 50));
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

        form.add(registerButton);

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
