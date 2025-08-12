package com.wipro.chiru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.chiru.entities.Question;
import com.wipro.chiru.service.QuestionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class QuestionController {
	
	@Autowired
	private  QuestionService qservice;
	
	@PostMapping("/addquestions")
	public Question addquestions(@RequestBody Question question) {
		return qservice.save(question);
	}
	
	@GetMapping("/getallquestions")
	public List<Question> getquestions(){
		return qservice.getquestions();
	}
	
	@PatchMapping("/updatequestion/{id}")
	public Question patchupdate(@PathVariable Long id , @RequestBody Question question) {
		return qservice.patchupdatequestions(id,question);
	}
	
	@DeleteMapping("/deletequestion/{id}")
	public void delete(@PathVariable Long id) {
		 qservice.deletequestion(id);
	}
	
	

}
