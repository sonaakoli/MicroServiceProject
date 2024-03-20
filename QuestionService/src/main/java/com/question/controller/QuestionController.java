package com.question.controller;

import com.question.entities.Question;
import com.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private  QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    //create question
    @PostMapping
    public Question createQue(@RequestBody Question question)
    {
       return questionService.create(question);
    }
    //get all questions
    @GetMapping
    public List<Question> getAllQue()
    {
        return questionService.get();
    }

    //get question by id
    @GetMapping("/{id}")
    public Question getQueById(@PathVariable Long id)
    {
        return questionService.getOne(id);
    }

//get all question of specific quiz
    @GetMapping("/quiz/{quizId}")
    public List<Question> gtQuestionQuiz(@PathVariable Long quizId)
    {
        return questionService.getQuestionOfQuiz(quizId);
    }
}
