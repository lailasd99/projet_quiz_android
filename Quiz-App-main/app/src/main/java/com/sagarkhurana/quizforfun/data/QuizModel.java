package com.sagarkhurana.quizforfun.data;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.sagarkhurana.quizforfun.Classes.QuestionModel;
import com.sagarkhurana.quizforfun.adapter.questionConverter;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "quiz")
public class QuizModel {
    @PrimaryKey
    @NonNull
    private String titre;
    //@TypeConverters(questionConverter.class)
    //private List<QuestionModel> questions;

    public QuizModel(){

    }
    public QuizModel(String titre) {
        this.titre = titre;
        //this.questions = questions;
    }

    public String getTitre() {
        return titre;
    }

    /*public List<QuestionModel> getQuestions() {
        return questions;
    }*/

    public void setTitre(String titre) {
        this.titre = titre;
    }

    /*public void setQuestions(List<QuestionModel> questions) {
        this.questions = questions;
    }*/
}
