package com.codebind;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

public class AsianCapitalsQuiz extends CentreScreen{

    JPanel panelMain = new JPanel();

    JPanel[] panels = new JPanel[11];
    JPanel[] answerPanel = new JPanel[10];

    JLabel[] questions = new JLabel[10];
    JRadioButton[][] answerOptions = new JRadioButton[10][4];

    String[] correctAnswers = new String[10];
    ButtonGroup[] answerGroups = new ButtonGroup[10];
    JButton submitButton = new JButton("Submit Answers");
    JButton retryButton = new JButton("Reset");
    JButton backButton = new JButton("Exit");

    ArrayList<String> countryList = new ArrayList<>();
    ArrayList<String> capitalList = new ArrayList<>();

    int totalCorrect;

    private String url = "jdbc:postgresql://localhost:5432/Capitals";
    private String username = "postgres";
    private String password = "postgres";

    Font f1 = new Font("SansSerif", Font.BOLD, 20);
    AsianCapitalsQuiz() {
        this.setPreferredSize(new Dimension(800, 800));
        this.setTitle("Asian Capitals Quiz");
        panelMain.setLayout(new GridLayout(10, 1, 10, 10));
        setUpFrame();


        getQuestions();


        for (int i = 0; i < 10; i++) {
            panels[i] = new JPanel();
            panels[i].setLayout(new BorderLayout());
            panels[i].setBackground(new Color(255, 255, 255));
            panels[i].setBorder(BorderFactory.createLineBorder(Color.black));


            questions[i].setFont(f1);

            answerOptions[i] = new JRadioButton[4];
            answerGroups[i] = new ButtonGroup();
            Random rand = new Random();
            int posCorrect = rand.nextInt(4);
            for (int j = 0; j < 4; j++) {
                if (j == posCorrect) {
                    answerOptions[i][j] = new JRadioButton(correctAnswers[i]);
                } else {
                    answerOptions[i][j] = new JRadioButton(getWrongAnswer(correctAnswers[i]));
                }
                answerGroups[i].add(answerOptions[i][j]);
            }

            panels[i].add(questions[i], BorderLayout.NORTH);

            answerPanel[i] = new JPanel();
            answerPanel[i].setLayout(new FlowLayout());
            panels[i].add(answerPanel[i], BorderLayout.SOUTH);

            for (int j = 0; j < 4; j++) {
                answerPanel[i].add(answerOptions[i][j]);
            }

            panelMain.add(panels[i]);
        }

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                totalCorrect = 0;
                String[] answers = new String[10];

                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (answerOptions[i][j].isSelected()) {
                            answers[i] = answerOptions[i][j].getText();
                            if (answers[i] == correctAnswers[i]) {
                                totalCorrect += 1;
                            }
                        }
                    }
                }

                String output = "You got " + totalCorrect + "/10";
                JOptionPane.showMessageDialog(null, output);
            }
        });

        retryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AsianCapitalsQuiz();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new QuizDir();
            }
        });

        submitButton.setSize(250, 140);
        retryButton.setSize(250,140);
        backButton.setSize(250,140);

        panels[10] = new JPanel();
        panelMain.add(panels[10]);

        panels[10].setLayout(new FlowLayout(FlowLayout.CENTER));

        panels[10].add(submitButton);
        panels[10].add(retryButton);
        panels[10].add(backButton);


        this.add(panelMain);


        this.pack();
        this.setVisible(true);
    }

    public void getQuestions() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String sqlQuery = "Select * FROM world_capitals WHERE continent = 'Asia'";
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            String country;
            String capital;
            while (resultSet.next()) {
                country = resultSet.getString("country");
                capital = resultSet.getString("capital");
                countryList.add(country);
                capitalList.add(capital);
            }
            resultSet.close();
            statement.close();
            connection.close();


        } catch(Exception e) {
            e.printStackTrace();
        }

        Random rand = new Random();
        int num;
        for (int i=0;i<10;i++) {
            num = rand.nextInt(countryList.size());
            questions[i] = new JLabel();

            questions[i].setText("Capital of " + countryList.get(num) + "?");
            correctAnswers[i] = capitalList.get(num);
            countryList.remove(num);
            capitalList.remove(num);
        }
    }

    public String getWrongAnswer(String correctAnswer) {
        Random rand = new Random();
        int capitalNum;
        String wrongCapital = correctAnswer;
        while (wrongCapital.equals(correctAnswer)) {
            capitalNum = rand.nextInt(capitalList.size());
            wrongCapital = capitalList.get(capitalNum);
        }
        return wrongCapital;

    }
    public static void main(String args[]) {
        new AsianCapitalsQuiz();
    }
}
