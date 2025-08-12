package com.wipro.chiru.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.wipro.chiru.entities.QuestionWrapper;
import com.wipro.chiru.entities.Quiz;
import com.wipro.chiru.entities.Response;
import com.wipro.chiru.service.QuizService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/quiz")
public class QuizController {

    private final QuizService quizservice;

    @PostMapping("/create")
    public Quiz createquiz(
            @RequestParam String category,
            @RequestParam String level,
            @RequestParam String title) {
        return quizservice.createQuiz(category, level, title);
    }

    @GetMapping("/getquizbyid/{id}")
    public List<QuestionWrapper> getQuizQuestions(@PathVariable Long id) {
        return quizservice.getQuizquestions(id);
    }

    @PostMapping("/submitQuiz/{id}")
    public Integer submitQuiz(@PathVariable int id, @RequestBody List<Response> responses) {
        return quizservice.calculateResult(id, responses);
    }
}
