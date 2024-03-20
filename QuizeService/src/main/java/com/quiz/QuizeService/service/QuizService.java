package com.quiz.QuizeService.service;

import com.quiz.QuizeService.entities.Quiz;

import java.util.List;

public interface QuizService {
    Quiz add(Quiz quiz);
    List<Quiz> get();
    Quiz get(Long id);

}
