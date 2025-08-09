package com.wipro.chiru.service;

import java.util.List;

import com.wipro.chiru.entities.Question;


public interface QuestionService {

	
	
	Question addQues(Question que);
	
	List<Question> getAllQues();
	
	Question updateQues(Long id, Question que);

	void deleque(Long id);
	
}
