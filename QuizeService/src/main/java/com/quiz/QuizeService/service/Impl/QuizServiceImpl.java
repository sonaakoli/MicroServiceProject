package com.quiz.QuizeService.service.Impl;

import com.quiz.QuizeService.entities.Question;
import com.quiz.QuizeService.entities.Quiz;
import com.quiz.QuizeService.repository.QuizRepository;
import com.quiz.QuizeService.service.QuestionClient;
import com.quiz.QuizeService.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class QuizServiceImpl implements QuizService {

    private QuizRepository quizRepository;

    private QuestionClient questionClient;

    public QuizServiceImpl(QuizRepository quizRepository, QuestionClient questionClient) {
        this.quizRepository = quizRepository;
        this.questionClient = questionClient;
    }

    @Override
    public Quiz add(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> get()
    {
        List<Quiz>quizzes=quizRepository.findAll();
      List<Quiz> newQuizList= quizzes.stream().map(quiz->{quiz.setQuestion(questionClient.getQuestionQuiz(quiz.getId()));
       return quiz;
       }).collect(Collectors.toList());
        return newQuizList;
    }

    @Override
    public Quiz get(Long id) {
       Quiz quiz= quizRepository.findById(id).orElseThrow(()->new RuntimeException("This Id is not Found"));
       quiz.setQuestion(questionClient.getQuestionQuiz(quiz.getId()));
        return quiz;
    }
}
