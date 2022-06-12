package com.sagarkhurana.quizforfun.Classes;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sagarkhurana.quizforfun.R;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {
    private int currentQuestionIndex = 0;
    private TextView tvQuestion, tvQuestionNumber;
    private Button btnNext;
    private RadioGroup radioGroup;
    private RadioButton radioButton1, radioButton2, radioButton3, radioButton4;
    private List<QuestionModel> questionsList;
    public int totalQuestions;
    public int qCounter=0;
    private QuestionModel currentQuestion;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        questionsList= new ArrayList<>();
        tvQuestion = findViewById(R.id.textView78);
        tvQuestionNumber = findViewById(R.id.textView18);
        btnNext = findViewById(R.id.btnNextQuestionLiteratureAndGeography);
        radioGroup = findViewById(R.id.radioGroup);

        radioButton1 = findViewById(R.id.radioButton5);
        radioButton2 = findViewById(R.id.radioButton6);
        radioButton3 = findViewById(R.id.radioButton7);
        radioButton4 = findViewById(R.id.radioButton8);
        //addQuestions();
        totalQuestions= questionsList.size();
        showNextQuestion();
    }

    private void showNextQuestion() {
        if(qCounter<totalQuestions){
            currentQuestion=questionsList.get(qCounter);
            tvQuestion.setText(currentQuestion.getQuestion());
            radioButton1.setText(currentQuestion.getOption1());
            radioButton2.setText(currentQuestion.getOption2());
            radioButton3.setText(currentQuestion.getOption3());
            radioButton4.setText(currentQuestion.getOption4());

            qCounter ++;
        }else {
            finish();
        }
    }

    private void addQuestions(){
        questionsList.add(new QuestionModel("C'est quoi un BroadCastReceiver chez android?",
                "un système qui permet de recevoir des vidéos",
                "un système qui permet de gérer une file d'attente asynchrone",
                "un système qui permet de gérer le sms non sollicités",
                "un système qui permet de faire communiquer grâce à des messages, pour de multiples utilisations ",
                1));

        questionsList.add(new QuestionModel("quelles sont les composantes qui existe sous Android?",
                "Activity",
                "Service",
                "Content Provider",
                "Wave Provider",
                4));

    }
}
