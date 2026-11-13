package com.example.dictionaryquiz;

import java.util.ArrayList;

public class Question {

    String word;
    ArrayList<String> answers = new ArrayList<>();

    int correctAnswer;

    public Question(String word, String a1, String a2, String a3, String a4, int correctAnswer) {
        this.word = word;
        answers.add(a1);
        answers.add(a2);
        answers.add(a3);
        answers.add(a4);
        this.correctAnswer = correctAnswer;
    }
}
