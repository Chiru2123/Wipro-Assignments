package com.wipro.chiru.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.chiru.entities.Question;
import com.wipro.chiru.service.QuestionService;


@RestController
@RequestMapping("/questions")
public class QuestionController {
	
	private final QuestionService quesserv;
	
	public QuestionController(QuestionService quesserv) {
		this.quesserv = quesserv;
		
	}
	
	
	@PostMapping
	public Question addQues(@RequestBody Question ques) {
		return quesserv.addQues(ques);
	}
	

	
	
	@GetMapping
	public List<Question> getAllQues(){
		return quesserv.getAllQues();
		
	}
	
	@PutMapping("/{id}")
	public Question updateQues(@PathVariable Long id, @RequestBody Question que) {
		return quesserv.updateQues(id, que);
	}
	
	@DeleteMapping("/{id}")
	public void deleque(@PathVariable Long id) {
		quesserv.deleque(id);
	}
	

	//(@PathVariable Long id, @RequestBody Question que );
	
	
}
