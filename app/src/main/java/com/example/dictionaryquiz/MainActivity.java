package com.example.dictionaryquiz;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button randomButton;
    Button b1, b2, b3, b4;
    ArrayList<Question> questions = new ArrayList<>();
    Random rnd = new Random();
    Question currentQuestion;
    TextView questionText;

    int questionId = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        randomButton = findViewById(R.id.button6);
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        questionText = findViewById(R.id.textView);

        CreateQuestions();

        currentQuestion = questions.get(rnd.nextInt( 4));
        DisplayQuestion();

        b1.setOnClickListener(view -> {
            if (currentQuestion.correctAnswer == 0){
                b1.setBackgroundColor(Color.parseColor("#00FF00"));
            }
            else{
                b1.setBackgroundColor(Color.parseColor("#FF0000"));
            }
        });

        b2.setOnClickListener(view -> {
            if (currentQuestion.correctAnswer == 1){
                b2.setBackgroundColor(Color.parseColor("#00FF00"));
            }
            else{
                b2.setBackgroundColor(Color.parseColor("#FF0000"));
            }
        });

        b3.setOnClickListener(view -> {
            if (currentQuestion.correctAnswer == 2){
                b3.setBackgroundColor(Color.parseColor("#00FF00"));
            }
            else{
                b3.setBackgroundColor(Color.parseColor("#FF0000"));
            }
        });

        b4.setOnClickListener(view -> {
            if (currentQuestion.correctAnswer == 3){
                b4.setBackgroundColor(Color.parseColor("#00FF00"));
            }
            else{
                b4.setBackgroundColor(Color.parseColor("#FF0000"));
            }
        });

        randomButton.setOnClickListener(view -> {
            currentQuestion = questions.get(rnd.nextInt(4));
            DisplayQuestion();
        });



    }
    private void CreateQuestions(){
        questions.add(new Question("Necesitar", "Ogień", "Wsparcie", "Potrzebować", "Pić", 2));
        questions.add(new Question("Imaginacion", "Wróg", "Wyobraźnia", "Kolega", "Prezydent", 1));
        questions.add(new Question("Gobierno", "Burmistrz", "Lekarz", "Fragmentacja", "Rząd", 3));
        questions.add(new Question("Melocoton", "Brzowskwinia", "Melon", "Dynia", "Jabłko", 0));
    }

    private void DisplayQuestion(){
        b1.setText(currentQuestion.answers.get(0));
        b1.setBackgroundColor(Color.parseColor("#004A5F"));
        b2.setText(currentQuestion.answers.get(1));
        b2.setBackgroundColor(Color.parseColor("#004A5F"));
        b3.setText(currentQuestion.answers.get(2));
        b3.setBackgroundColor(Color.parseColor("#004A5F"));
        b4.setText(currentQuestion.answers.get(3));
        b4.setBackgroundColor(Color.parseColor("#004A5F"));
        questionText.setText(currentQuestion.word);
    }

}