package com.codebind;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;



public class CapitalQuizOne {
    JFrame euroQuizFrame = new JFrame("Europe Capitals Quiz");

    JPanel euroPanelMain = new JPanel();

    JPanel[] euroPanels = new JPanel[10];
    JLabel[] questions = new JLabel[10];
    JRadioButton[][] answerOptions = new JRadioButton[10][4];

    String[] QuestionList = {"Capital of Germany?",
            "Capital of Poland?",
            "Capital of Bulgaria?",
            "Capital of Sweden?",
            "Capital of Norway?",
            "Capital of Greece?",
            "Capital of Austria?",
            "Capital of Ireland?",
            "Capital of Portugal?",
            "Capital of Spain?"
    };

    String[] correctAnswers = {
            "Berlin",
            "Warsaw",
            "Sofia",
            "Stockholm",
            "Oslo",
            "Athens",
            "Vienna",
            "Dublin",
            "Lisbon",
            "Madrid"
    };

    ArrayList<String> capitalList = getCapitals();

    JButton submitButton = new JButton("Submit Answers");


    CapitalQuizOne() {
        euroQuizFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        euroQuizFrame.setPreferredSize(new Dimension(1000, 1000));
        euroQuizFrame.setLocationRelativeTo(null);

        euroPanelMain.setLayout(new GridLayout(10, 1, 10, 10));

        capitalList.remove(0);

        Font f1 = new Font("SansSerif", Font.BOLD, 20);

        for (int i = 0; i < 10; i++) {
            euroPanels[i] = new JPanel();
            euroPanels[i].setLayout(new FlowLayout(FlowLayout.LEFT));
            euroPanels[i].setBackground(new Color(255, 255, 255));
            euroPanels[i].setBorder(BorderFactory.createLineBorder(Color.black));

            questions[i] = new JLabel(QuestionList[i]);
            questions[i].setFont(f1);

            answerOptions[i] = new JRadioButton[4];
            Random rand = new Random();
            int posCorrect = rand.nextInt(4);
            for (int j = 0; j < 4; j++) {
                if (j == posCorrect) {
                    answerOptions[i][j] = new JRadioButton(correctAnswers[i]);
                } else {

                    answerOptions[i][j] = new JRadioButton(getWrongAnswer(correctAnswers[i]));
                }
            }

            euroPanels[i].add(questions[i]);
            for (int j = 0; j < 4; j++) {
                euroPanels[i].add(answerOptions[i][j]);
            }

            euroPanelMain.add(euroPanels[i]);
        }
        submitButton.setSize(250, 140);
        euroPanelMain.add(submitButton);

        euroQuizFrame.add(euroPanelMain);


        euroQuizFrame.pack();
        euroQuizFrame.setVisible(true);
    }

    public ArrayList<String> getCapitals() {
        String file = "C:\\Users\\solsh\\IdeaProjects\\Java-UI\\src\\com\\codebind\\europe-capital-cities.csv";
        ArrayList<String> capitals = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into fields using a comma as the delimiter
                String[] fields = line.split(",");
                // Process the fields as needed
                int count = 0;
                for (String field : fields) {
                    count += 1;
                    if (count == 2) {
                        capitals.add(field);
                    }
                }// Move to the next line
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return capitals;
    }

    public String getWrongAnswer(String correctAnswer) {
        Random rand = new Random();
        int capitalNum = 0;
        String wrongCapital = correctAnswer;
        while (wrongCapital.equals(correctAnswer)) {
            capitalNum = rand.nextInt(capitalList.size());
            wrongCapital = capitalList.get(capitalNum);
        }
        return wrongCapital;

    }

   public static void main(String[] args) {
        CapitalQuizOne one = new CapitalQuizOne();

    }
}








