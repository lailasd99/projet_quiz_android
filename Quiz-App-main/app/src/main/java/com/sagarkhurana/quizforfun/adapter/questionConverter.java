package com.sagarkhurana.quizforfun.adapter;

import androidx.room.TypeConverter;

import com.sagarkhurana.quizforfun.Classes.QuestionModel;
import com.sagarkhurana.quizforfun.data.QuestionPOJO;

import java.util.Arrays;
import java.util.List;


public class questionConverter {
    @TypeConverter
    public QuestionModel storedStringToQuestions(String value) {
        List<String> questions = Arrays.asList(value.split("\\s*,\\s*"));
        return new QuestionModel(questions.get(0), questions.get(1), questions.get(2), questions.get(3), questions.get(4));
    }

    @TypeConverter
    public String questionsToStoredString(QuestionModel qs) {
        String value = "";

        value = qs.getQuestion() +"," +qs.getOption1()+"," +qs.getOption2()+"," +qs.getOption3()+"," +
                qs.getOption4()+"," +qs.getCorrectAnNum();
        /*for (String question :qs.getQuestion())
            value += question + ",";*/
        return value;
    }
}
