package com.quiz.QuizeService.service;


import com.quiz.QuizeService.entities.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(url = "http://localhost:8082",value = "Question-Client")
@FeignClient(name = "SERVICE-QUESTION")
public interface QuestionClient {
    //
    @GetMapping("/question/quiz/{quizId}")
    List<Question> getQuestionQuiz(@PathVariable Long quizId);
}
