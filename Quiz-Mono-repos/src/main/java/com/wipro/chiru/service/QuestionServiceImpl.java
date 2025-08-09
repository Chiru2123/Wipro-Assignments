package com.wipro.chiru.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wipro.chiru.entities.Question;
import com.wipro.chiru.repository.QuestionRepository;



@Service
public class QuestionServiceImpl implements QuestionService {
	
	
	private final QuestionRepository quesrepo;
	
	public QuestionServiceImpl(QuestionRepository quesrepo) {
		this.quesrepo = quesrepo;
		
	}

	@Override
	public Question addQues(Question que) {
		// TODO Auto-generated method stub
		return quesrepo.save(que);
	}

	@Override
	public List<Question> getAllQues() {
		// TODO Auto-generated method stub
		return quesrepo.findAll();
	}

	@Override
	public Question updateQues(Long id, Question que) {
		// TODO Auto-generated method stub
		
		Question exist = quesrepo.findById(id).orElseThrow();
		exist.setQuestiontitle(que.getQuestiontitle());
		exist.setOption1(que.getOption1());
		exist.setOption2(que.getOption2());
		exist.setOption3(que.getOption3());
		exist.setOption4(que.getOption4());
		exist.setCorrectans(que.getCorrectans());
		exist.setDifficultylvl(que.getDifficultylvl());
		exist.setCategory(que.getCategory());
		
		return quesrepo.save(exist);
	}

	@Override
	public void deleque(Long id) {
		// TODO Auto-generated method stub
		quesrepo.deleteById(id);
		
	}
	
	

}

