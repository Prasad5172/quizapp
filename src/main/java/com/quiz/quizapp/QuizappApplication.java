package com.quiz.quizapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.quiz.quizapp.model") 
public class QuizappApplication {
	
	public static void main(String[] args){
		SpringApplication.run(QuizappApplication.class, args);
	}

}
