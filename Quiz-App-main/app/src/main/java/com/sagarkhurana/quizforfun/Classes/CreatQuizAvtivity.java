package com.sagarkhurana.quizforfun.Classes;

import android.content.Intent;
import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sagarkhurana.quizforfun.MainActivity;
import com.sagarkhurana.quizforfun.MainActivityADMIN;
import com.sagarkhurana.quizforfun.R;
import com.sagarkhurana.quizforfun.RuleActivity;
import com.sagarkhurana.quizforfun.data.QuizDatabase;
import com.sagarkhurana.quizforfun.data.QuizDatabaseClient;
import com.sagarkhurana.quizforfun.data.QuizModel;

import java.util.ArrayList;
import java.util.List;


public class CreatQuizAvtivity extends AppCompatActivity {
    private EditText tvQuestion;
    private EditText CorrectAnswerNumber;
    private EditText a1, a2, a3, a4;
    private List<QuestionModel> questionsList;
    private Button AddQuestion;
    private Button Done;
    private RadioGroup radioGroup;
    private ImageView back;
    private EditText title;
    private Button done;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creat_quiz);

        questionsList= new ArrayList<>();
        tvQuestion = findViewById(R.id.question);
        CorrectAnswerNumber = findViewById(R.id.correct);
        Done = findViewById(R.id.btnNextQuestionLiteratureAndGeography);
        radioGroup = findViewById(R.id.radioGroup);
        AddQuestion = findViewById(R.id.add);
        back = findViewById(R.id.back);
        title = findViewById(R.id.titleQuiz);
        done = findViewById(R.id.donequiz);

        a1 = findViewById(R.id.answer1);
        a2 = findViewById(R.id.answer2);
        a3 = findViewById(R.id.answer3);
        a4 = findViewById(R.id.answer4);
        //totalQuestions= questionsList.size();
        //showNextQuestion();

        AddQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addQuestions();
                title.setText("");
                tvQuestion.setText("");
                a1.setText("");
                a2.setText("");
                a3.setText("");
                a4.setText("");
                CorrectAnswerNumber.setText("");
                Toast.makeText(CreatQuizAvtivity.this, "Question Added successfully", Toast.LENGTH_SHORT).show();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CreatQuizAvtivity.this, MainActivityADMIN.class));
            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Done();
            }
        });
    }

    /*private void showNextQuestion() {
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
    }*/

    public void addQuestions(){
        String question=this.tvQuestion.getText().toString().trim();
        String op1=this.a1.getText().toString().trim();
        String op2=this.a2.getText().toString().trim();
        String op3=this.a3.getText().toString().trim();
        String op4=this.a4.getText().toString().trim();
        try{
            int correct= Integer.parseInt(this.CorrectAnswerNumber.getText().toString());
            questionsList.add(new QuestionModel(question,op1,op2,op3,op4,correct));
        } catch(NumberFormatException ex){
            System.out.println(ex);
        }

    }

    public void Done(){
        //String titre = this.title.getText().toString().trim();
        /*QuizModel quizModel = new QuizModel(titre, questionsList);
        QuizDatabase quizDatabase = new QuizDatabaseClient().getQuizInstance(getApplicationContext());
        try {
            quizDatabase.quizDao().insertQuiz(quizModel);
            Toast.makeText(CreatQuizAvtivity.this, "Quiz added successfully", Toast.LENGTH_SHORT).show();
        }catch (SQLiteConstraintException e){
            System.out.println(e);
        }*/
        Toast.makeText(CreatQuizAvtivity.this, "Quiz added successfully", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(CreatQuizAvtivity.this, MainActivityADMIN.class));
    }

}









