package com.codebind;

import javax.swing.*;
import java.awt.*;

public class RegisterForm {

    JFrame RegisterForm = new JFrame("Register");

    JPanel form = new JPanel();

    JLabel[] fieldNames = new JLabel[3];

    private JTextField username = new JTextField();

    private JPasswordField password = new JPasswordField();

    private JTextField email = new JTextField();


    RegisterForm() {
        RegisterForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        RegisterForm.setPreferredSize(new Dimension(400,350));
        RegisterForm.setLocationRelativeTo(null);
        RegisterForm.setLayout(null);

        form.setPreferredSize(new Dimension(400,350));
        form.setLocation(0,0);
        form.setLayout(new FlowLayout(FlowLayout.CENTER));

        Dimension fieldDimension = new Dimension(100,50);


        for (int i=0; i<3; i++) {
            fieldNames[i] = new JLabel();
            if (i==0) {
                fieldNames[i].setText("Enter your username:");
                username.setPreferredSize(fieldDimension);
                form.add(fieldNames[i]);
                form.add(username);
            } else if (i==1) {
                fieldNames[i].setText("Enter your new password: ");
                password.setPreferredSize(fieldDimension);
                form.add(fieldNames[i]);
                form.add(password);
            } else if (i==2) {
                fieldNames[i].setText("Enter in your email: ");
                email.setPreferredSize(fieldDimension);
                form.add(fieldNames[i]);
                form.add(email);
            }
        }

        RegisterForm.add(form);
        RegisterForm.pack();
        RegisterForm.setVisible(true);




    }
}
