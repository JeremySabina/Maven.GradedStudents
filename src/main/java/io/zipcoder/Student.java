package io.zipcoder;

import com.sun.scenario.effect.impl.prism.PrImage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//JEREMY

        // JEREMY


public class Student {
    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;
    Double[] testScores;


    public Student(String firstName, String lastName, Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<>(Arrays.asList(testScores));

    }


    public int getNumberOfExamsTaken() {
        return this.testScores.length;
    }


    public String getExamScores() {
        StringBuilder stringOfScores = new StringBuilder();


        for (int i = 0; i < testScores.length; i++) {
            stringOfScores.append(testScores[i] + " | ");
            stringOfScores = stringOfScores.append(i);
        }

        return Arrays.toString(testScores);
    }

    public void setExamScore(int examNumber, double newScore) {
        this.examScores.set(examNumber, newScore);
    }

    public void addExamScore(double testScore) {
        this.examScores.add(testScore);
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getAverageExamScore() {
        // ArrayList<Double> newAverage = new ArrayList<>(getAverageExamScore());
        // Collections.addAll(newAverage);
        Double result = 0.00;
        for (int i = 0; i < testScores.length; i++) {
            result += testScores[i];
        }

        return result / testScores.length;
    }


    }


    @Override

    public String toString() {
        return String.format("Hello World %s", getAverageExamScore());
    }
}
// I want it to look pretty..
// DONE


