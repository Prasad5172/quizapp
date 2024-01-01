package com.quiz.quizapp.dao;

import java.util.List;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.jpa.repository.JpaRepository;
import com.quiz.quizapp.model.Question;

import org.springframework.stereotype.Repository;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer>{
    List<Question> findBycategory(String category);
    @Query("SELECT q FROM Question q WHERE q.category = :category ORDER BY rand() LIMIT :numQ")
    List<Question> findRandomQuestionsByCategory(String category, int numQ);
}
