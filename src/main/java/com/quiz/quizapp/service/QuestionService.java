package com.quiz.quizapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quiz.quizapp.dao.QuestionDao;
import com.quiz.quizapp.model.Question;

@Service
public class QuestionService {
    
    
    @Autowired
    QuestionDao questionDao;
    public ResponseEntity<List<Question>> getAllQuestions(){
        try {
            return new ResponseEntity<>(questionDao.findAll(),HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return  new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
       
    }

    public ResponseEntity<List<Question>> getQuestionsBycategory(String category)
    {
        try{
        return new ResponseEntity<>(questionDao.findBycategory(category),HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return  new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question question){
        try{
        questionDao.save(question);
        return new ResponseEntity<>("created",HttpStatus.CREATED);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return  new ResponseEntity<>("",HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deleteQuestion(int id) {
        try{
            
        questionDao.deleteById(id);
        return new ResponseEntity<>("deleted",HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return  new ResponseEntity<>("",HttpStatus.BAD_REQUEST);
    }
    
}
