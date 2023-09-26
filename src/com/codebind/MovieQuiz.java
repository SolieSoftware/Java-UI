package com.codebind;

import javax.swing.*;
import java.awt.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MovieQuiz {
    JFrame movieFrame = new JFrame("Movie Quiz!!");

    JPanel[] moviePanel = new JPanel[10];

    private String url = "jdbc:postgresql://localhost:5432/movies";
    private String username = "postgres";
    private String password = "Joke100v";

    ArrayList<String> movie_titles = new ArrayList<>();




    MovieQuiz() {

        movieFrame.setSize(new Dimension(500,500));
        movieFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        movieFrame.setLayout(new BorderLayout());

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String sqlQuery = "Select * FROM public.imdb_top_100";
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            String temp = "";

            while (resultSet.next()) {
                temp = resultSet.getString("original_movie_title");
                movie_titles.add(temp);
            }

            resultSet.close();
            statement.close();
            connection.close();


        } catch(Exception e) {
            e.printStackTrace();
        }






        for (int i = 0; i<5; i++) {
            moviePanel[i] = new JPanel();
            moviePanel[i].setPreferredSize(new Dimension(100,100));

        }

        moviePanel[0].setBackground(Color.red);
        moviePanel[1].setBackground(Color.green);
        moviePanel[2].setBackground(Color.blue);
        moviePanel[3].setBackground(Color.magenta);
        moviePanel[4].setBackground(Color.yellow);


        movieFrame.add(moviePanel[0], BorderLayout.NORTH);
        movieFrame.add(moviePanel[1], BorderLayout.SOUTH);
        movieFrame.add(moviePanel[2], BorderLayout.CENTER);
        movieFrame.add(moviePanel[3], BorderLayout.WEST);
        movieFrame.add(moviePanel[4], BorderLayout.EAST);






        movieFrame.pack();
        movieFrame.setVisible(true);



    }
}
