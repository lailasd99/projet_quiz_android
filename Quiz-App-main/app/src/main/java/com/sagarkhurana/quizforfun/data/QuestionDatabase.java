package com.sagarkhurana.quizforfun.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.sagarkhurana.quizforfun.Classes.QuestionModel;
import com.sagarkhurana.quizforfun.adapter.questionConverter;

@Database(
        entities = {QuestionModel.class,Attempt.class},
        exportSchema = false,
        version = 1
)
@TypeConverters({questionConverter.class})
public abstract class QuestionDatabase extends RoomDatabase{
    public abstract QuestionDao questionDao();
}
