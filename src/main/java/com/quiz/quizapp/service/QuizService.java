package com.quiz.quizapp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quiz.quizapp.dao.QuestionDao;
import com.quiz.quizapp.dao.QuizDao;
import com.quiz.quizapp.model.Question;
import com.quiz.quizapp.model.QuestionWrapper;
import com.quiz.quizapp.model.Quiz;
import com.quiz.quizapp.model.Responce;

import java.util.*;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, String title, int numQ){
        List<Question> questions = questionDao.findRandomQuestionsByCategory(category,numQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        System.out.println(quiz);
        quizDao.save(quiz);
        return new ResponseEntity<>("success",HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuiz(int id){

        try {
            
            Quiz quiz = quizDao.findById(id).get();
            System.out.println(quiz);
            List<Question> questionsFromDb = quiz.getQuestions(); 
            List<QuestionWrapper> questionForUser = new ArrayList<>();
            for(Question q : questionsFromDb){
                QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestiontitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4(), q.getDifficultylevel());
                questionForUser.add(qw);
            }
            return new ResponseEntity<>(questionForUser, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Integer> submitQuiz(int id, List<Responce> responce) {
        int score =0;
        Quiz quiz = quizDao.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int i=0;
        for(Responce tempResponce : responce){
            if(tempResponce.getResponce().equals(questions.get(i).getRightanswer())){
                score++;
            }
            i++;
        }
        return new ResponseEntity<Integer>(score, HttpStatus.OK);
    }


}
