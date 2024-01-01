package com.quiz.quizapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class RegisterationRequest {
    private final String name;
    private final  String username;
    private final String email;
    private final String password;
}
