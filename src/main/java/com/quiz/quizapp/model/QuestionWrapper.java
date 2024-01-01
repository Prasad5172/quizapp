package com.quiz.quizapp.model;

import lombok.Data;

@Data

public class QuestionWrapper {
    private long id;
    private String questiontitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String difficultylevel;

    public QuestionWrapper(long id, String questiontitle, String option1, String option2, String option3,
        String option4, String difficultylevel) {
        this.id = id;
        this.questiontitle = questiontitle;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.difficultylevel = difficultylevel;
    }

}
