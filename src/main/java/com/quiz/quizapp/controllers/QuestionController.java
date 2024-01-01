package com.quiz.quizapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.quizapp.model.Question;
import com.quiz.quizapp.service.QuestionService;


@RestController
@RequestMapping("question")
public class QuestionController {


    @Autowired
    QuestionService questionService;


    @GetMapping("/getallquestions")
    public ResponseEntity<List<Question>>  getAllQuestions() 
    {
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsBycategory(@PathVariable String category)
    {
        return questionService.getQuestionsBycategory(category);
    }

    @PostMapping("addquestion")
    public ResponseEntity<String> addQuestion(@RequestBody Question question)
    {
        System.out.println(question);
        return questionService.addQuestion(question);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable int id)
    {
        return questionService.deleteQuestion(id);
    }
}
