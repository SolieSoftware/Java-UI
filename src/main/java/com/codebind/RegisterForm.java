package com.codebind;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

public class RegisterForm extends JPanel {

    JFrame RegisterForm = new JFrame("Register");

    JPanel form = new JPanel();

    JLabel[] fieldNames = new JLabel[3];

    private JTextField username = new JTextField();

    private JPasswordField password = new JPasswordField();

    private JTextField email = new JTextField();

    JButton registerButton = new JButton();

    private String url = "jdbc:postgresql://postgres/Login_Details";
    private String user_post = "postgres";
    private String password_post = "postgres";


    RegisterForm() {
        /*
        RegisterForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        RegisterForm.setPreferredSize(new Dimension(400,350));
        RegisterForm.setLayout(null);

         */

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

        registerButton.setPreferredSize(new Dimension(250, 130);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    Connection connection = DriverManager.getConnection(url, user_post, password_post);
                    Statement statement = connection.createStatement();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        this.add(form);
        this.setVisible(true);

    }

    public boolean checkEmptyFields() {
        boolean check;
        String temp;
        for (int i=0; i<3; i++) {
            temp = fieldNames[i].getText();
            if (temp.isEmpty()) {
                check = false;
            }
        }
    }
}
