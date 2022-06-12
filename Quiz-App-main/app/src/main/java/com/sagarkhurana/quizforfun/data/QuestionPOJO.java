package com.sagarkhurana.quizforfun.data;

import com.sagarkhurana.quizforfun.Classes.QuestionModel;

import java.util.List;

public class QuestionPOJO {
    private List<String> questions;
    public QuestionPOJO(List<String> questions) {
        this.questions = questions;
    }

    public List<String> getQuestions() {
        return questions;
    }

    public void setQuestions(List<String> questions) {
        this.questions = questions;
    }
}
