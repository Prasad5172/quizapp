package com.quiz.quizapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.quizapp.model.QuestionWrapper;
import com.quiz.quizapp.model.Responce;
import com.quiz.quizapp.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String>  createQuiz(@RequestParam String category ,@RequestParam String title,@RequestParam int numQ )
    {
        return quizService.createQuiz(category,title,numQ);
    }
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable int id)
    {
        return quizService.getQuiz(id);
    }
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable int id,@RequestBody List<Responce> responce)
    {
        return quizService.submitQuiz(id,responce);
    }
}
