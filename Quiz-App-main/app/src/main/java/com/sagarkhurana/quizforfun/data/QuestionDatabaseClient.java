package com.sagarkhurana.quizforfun.data;

import android.content.Context;

import androidx.room.Room;

import com.sagarkhurana.quizforfun.adapter.questionConverter;

public class QuestionDatabaseClient {
    private static final String DB_NAME = "question_db";
    private static QuestionDatabase  instance;

    public static synchronized QuestionDatabase getQuestionInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(
                    context.getApplicationContext(), QuestionDatabase.class,DB_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    public QuestionDatabase getQuestionDatabase() {
        return instance;
    }
}
