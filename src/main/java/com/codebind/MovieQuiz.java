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
import java.util.Collections;

public class MovieQuiz extends CentreScreen{

    JPanel[] moviePanel = new JPanel[5];

    JPanel[] answerPanel = new JPanel[5];



    private String url = "jdbc:postgresql://localhost:5432/movies";
    private String username = "postgres";
    private String password = "postgres";

    String[][] movie = new String[100][3];

    String[] questionFormats = {
            "What year was X made in?",
            "Who directed X?"
    };

    JLabel[] questions = new JLabel[5];
    ArrayList<String> questionAnswer;

    JRadioButton[][] answerOptions = new JRadioButton[5][4];
    ButtonGroup[] answerGroups =  new ButtonGroup[5];

    JButton submitButton = new JButton("Submit Answers");

    ArrayList<String> correctAnswers = new ArrayList<>();




    MovieQuiz() {

        this.setSize(new Dimension(600,700));
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        setUpFrame();

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String sqlQuery = "Select * FROM public.imdb_top_100";
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            String title;
            String year;
            String director;
            int count = 0;
            while (resultSet.next()) {
                title = resultSet.getString("original_title");
                year = String.valueOf(resultSet.getInt("year"));
                director = resultSet.getString("director");

                movie[count][0] = title;
                movie[count][1] = year;
                movie[count][2] = director;

                count+=1;
            }
            resultSet.close();
            statement.close();
            connection.close();


        } catch(Exception e) {
            e.printStackTrace();
        }






        for (int i = 0; i<5; i++) {
            moviePanel[i] = new JPanel();
            moviePanel[i].setPreferredSize(new Dimension(600,100));
            moviePanel[i].setLayout(new BorderLayout());

            answerPanel[i] = new JPanel();
            answerPanel[i].setPreferredSize(new Dimension(600, 50));
            answerPanel[i].setLayout(new FlowLayout());

            questionAnswer = getQuestion();

            questions[i] = new JLabel(questionAnswer.get(4));
            questions[i].setLocation(400, 20);

            answerGroups[i] = new ButtonGroup();



            for (int j=0; j<4; j++) {
                answerOptions[i][j] = new JRadioButton();
                answerOptions[i][j].setActionCommand(questionAnswer.get(j));
                answerOptions[i][j].setText(questionAnswer.get(j));
                answerGroups[i].add(answerOptions[i][j]);
                answerPanel[i].add(answerOptions[i][j]);
            }



            moviePanel[i].add(questions[i], BorderLayout.NORTH);
            moviePanel[i].add(answerPanel[i], BorderLayout.SOUTH);

            this.add(moviePanel[i]);

        }
        submitButton.setPreferredSize(new Dimension(200,50));

        submitButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {
                int numCorrect = 0;
                String text;
                for (int i=0; i<5; i++) {

                    ButtonModel selectedButton = answerGroups[i].getSelection();
                    text = selectedButton.getActionCommand();
                    if (text.equals(correctAnswers.get(i))) {
                        numCorrect += 1;
                    }

                }

                JOptionPane.showMessageDialog(null, "You got " + numCorrect + "/5");

            }
        });


        this.add(submitButton);



        this.pack();
        this.setVisible(true);



    }

    public ArrayList<String> getQuestion() {

        Random rand = new Random();
        int num = rand.nextInt(2);
        String question = questionFormats[num];
        int num2 = rand.nextInt(100);
        String movieTitle = movie[num2][0];


        ArrayList<String> answers = new ArrayList<>();
        answers.add(movie[num2][num+1]);
        correctAnswers.add(movie[num2][num+1]);



        question = question.replace("X", movieTitle);
        while (answers.size() != 4) {
            num2 = rand.nextInt(100);
            if (movie[num2][num+1] != answers.get(0)) {
                answers.add(movie[num2][num+1]);
            }
        }

        Collections.shuffle(answers);

        answers.add(question);

        return answers;

    }

    public static void main(String args[]) {
        new MovieQuiz();
    }





}
