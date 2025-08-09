package com.wipro.chiru.service;

import java.util.List;

import com.wipro.chiru.entities.QuestionWrapper;


public interface QuizService {

	
	List<QuestionWrapper> getquizques(Long quizId);

}
