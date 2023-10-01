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

    JPanel[] answerPanel = new JPanel[10];
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

    ButtonGroup[] answerGroups;
    ArrayList<String> capitalList = getCapitals();

    JButton submitButton = new JButton("Submit Answers");

    int totalCorrect;


    CapitalQuizOne() {
        euroQuizFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        euroQuizFrame.setPreferredSize(new Dimension(800, 800));
        euroQuizFrame.setLocation(600, 200);

        euroPanelMain.setLayout(new GridLayout(10, 1, 10, 10));

        capitalList.remove(0);

        Font f1 = new Font("SansSerif", Font.BOLD, 20);
        answerGroups = new ButtonGroup[10];

        for (int i = 0; i < 10; i++) {
            euroPanels[i] = new JPanel();
            euroPanels[i].setLayout(new BorderLayout());
            euroPanels[i].setBackground(new Color(255, 255, 255));
            euroPanels[i].setBorder(BorderFactory.createLineBorder(Color.black));

            questions[i] = new JLabel(QuestionList[i]);
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

            euroPanels[i].add(questions[i], BorderLayout.NORTH);
            answerPanel[i] = new JPanel();
            answerPanel[i].setLayout(new FlowLayout());
            euroPanels[i].add(answerPanel[i], BorderLayout.SOUTH);
            for (int j = 0; j < 4; j++) {
                answerPanel[i].add(answerOptions[i][j]);
            }

            euroPanelMain.add(euroPanels[i]);
        }
        submitButton.setSize(250, 140);
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                totalCorrect = 0;
                String[] answers = new String[10];

                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (answerOptions[i][j].isSelected()) {
                            answers[i] = answerOptions[i][j].getText();
                        }
                    }

                }
                for (int i = 0; i < 10; i++) {
                    if (answers[i] == correctAnswers[i]) {
                        totalCorrect += 1;
                    }
                }
                String output = "You got " + totalCorrect + "/10";
                JOptionPane.showMessageDialog(null, output);
            }
        });

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
}








