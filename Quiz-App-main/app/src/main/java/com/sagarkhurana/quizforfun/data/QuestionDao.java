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
public interface QuestionDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    void insertQuestion(QuestionModel question);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAttempt(Attempt attempt);

    @Update
    void updateQuestion(QuestionModel question);

    @Query("SELECT * FROM question")
    List<QuestionModel> observeAllQuestions();

    @Delete
    void deleteQuestion(QuestionModel question);

}
