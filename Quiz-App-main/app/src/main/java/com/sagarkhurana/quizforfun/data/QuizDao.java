package com.sagarkhurana.quizforfun.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.sagarkhurana.quizforfun.Classes.QuestionModel;

import java.util.List;

@Dao
public interface QuizDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    void insertQuiz(QuizModel quiz);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAttempt(Attempt attempt);

    @Update
    void updateQuiz(QuizModel quiz);

    @Query("SELECT * FROM quiz")
    List<QuizModel> observeAllQuiz();

    @Transaction
    @Query("SELECT * FROM quiz")
    List<QuizModel> getQuiz();

    @Delete
    void deleteQuiz(QuizModel quiz);

}
