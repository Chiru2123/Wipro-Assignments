package com.wipro.chiru.service;

import java.util.List;

import com.wipro.chiru.entities.QuestionWrapper;
import com.wipro.chiru.entities.Quiz;
import com.wipro.chiru.entities.Response;

public interface QuizService {

    Quiz createQuiz(String category, String level, String title);

    List<QuestionWrapper> getQuizquestions(Long id);

    Integer calculateResult(int id, List<Response> responses);
}