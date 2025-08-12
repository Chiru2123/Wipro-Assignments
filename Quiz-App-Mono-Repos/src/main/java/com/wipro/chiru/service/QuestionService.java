package com.wipro.chiru.service;

import java.util.List;

import com.wipro.chiru.entities.Question;
public interface QuestionService {

	List<Question> getquestions();

	Question save(Question question);
	
	
	Question patchupdatequestions(Long id, Question question);

	void  deletequestion(Long id);

	

}
