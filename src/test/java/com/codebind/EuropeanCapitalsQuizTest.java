package com.codebind;

import com.opencsv.exceptions.CsvValidationException;
import org.junit.jupiter.api.Test;

import static java.lang.System.in;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import java.io.FileReader;
import java.io.IOException;


class EuropeanCapitalsQuizTest {
    EuropeanCapitalsQuiz eu = new EuropeanCapitalsQuiz();

    List<String> euroCities = new ArrayList<String>();
    List<String> euroCountries = new ArrayList<String>();

    @Test
    void getQuestions() {
        //Check questions contain the right text format
        String questionRegex = "^Capital\\sof\\s\\w+?";
        Pattern pattern = Pattern.compile(questionRegex);
        for (int i=0; i<10; i++) {
            Matcher matcher = pattern.matcher(eu.questions[i].getText());
            assertTrue(matcher.matches());
        }

        //Check questions contain a capital city from europe
        getEuropeanCities();
        getEuropeanCountries();

        for (int i=0;i<10;i++) {
            String country = eu.countryList.get(i);
            //check if persistent country has been stored in the question
            assertTrue(eu.questions[i].getText().contains(country));
            //check if persistent string from database and put into question is indeed a european country
            assertTrue(euroCountries.contains(country));
        }

        for (int i=0; i<10; i++) {
            String capital = eu.capitalList.get(i);
            //check if capital has been transferred to correct answers
            assertEquals(capital, eu.correctAnswers[i]);
            //check if capital obtained is indeed a european city
            assertTrue(euroCities.contains(capital));
        }

        //check if capital in eu.correctAnswers matches the question



    }

    @Test
    void getWrongAnswer() {
    }

    @Test
    void main() {
    }

    void getEuropeanCities() {
        String file = "./Data_Sets/europe-capital-cities.csv";
        try (CSVReader reader = new CSVReaderBuilder(new FileReader(file)).withSkipLines(1).build()) {
            String[] nextRecord;
            while ((nextRecord = reader.readNext()) != null) {
                        euroCities.add(nextRecord[1]);

            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

    }

    void getEuropeanCountries() {
        String file = "./Data_Sets/Countries-Europe.csv";
        try (CSVReader reader = new CSVReaderBuilder(new FileReader(file)).withSkipLines(1).build()) {
            String[] nextRecord;
            while ((nextRecord = reader.readNext()) != null) {
                euroCountries.add(nextRecord[1]);

            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

    }
    }

}