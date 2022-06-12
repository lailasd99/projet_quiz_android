package com.sagarkhurana.quizforfun.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.sagarkhurana.quizforfun.Classes.QuestionModel;

@Database(
        entities = {QuizModel.class,Attempt.class},
        exportSchema = false,
        version = 1
)

public abstract class QuizDatabase extends RoomDatabase{
    public abstract QuizDao quizDao();
}
