package com.quiz.quizapp.model;

import lombok.Data;

@Data

public class Responce {
    private int id;
    private String responce;
    public Responce(int id, String rightAnswer) {
        this.id = id;
        this.responce = rightAnswer;
    }
}
