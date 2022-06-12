package com.sagarkhurana.quizforfun;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.sagarkhurana.quizforfun.data.QuizDao;
import com.sagarkhurana.quizforfun.data.QuizModel;

import java.util.ArrayList;
import java.util.List;

public class AllQuizActivity extends AppCompatActivity {
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_QuizForFun);
        setContentView(R.layout.activity_repertoire);
        ArrayList<QuizModel> quiz = new ArrayList<>();

        //List<QuizModel> quizModels = db.QuizDao.getQuiz

    }
}
