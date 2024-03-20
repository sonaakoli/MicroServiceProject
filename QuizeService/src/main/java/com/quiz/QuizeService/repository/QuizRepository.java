package com.quiz.QuizeService.repository;

import com.quiz.QuizeService.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz,Long> {
}
