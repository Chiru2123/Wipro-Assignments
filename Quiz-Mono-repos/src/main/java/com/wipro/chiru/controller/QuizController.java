package com.wipro.chiru.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.chiru.entities.QuestionWrapper;
import com.wipro.chiru.entities.Quiz;
import com.wipro.chiru.entities.Response;
import com.wipro.chiru.repository.QuizRepository;
import com.wipro.chiru.service.QuizService;



@RestController
@RequestMapping("/quiz")
public class QuizController {
	
	private final QuizRepository quizrepo;
	
	private final QuizService quizserv;
	
	
	
	public QuizController(QuizRepository quizrepo,QuizService quizserv ) {
		this.quizrepo=quizrepo;
		this.quizserv= quizserv;
	}

     @PostMapping
     public Quiz createQuiz(@RequestBody Quiz quiz) {
    	 return quizrepo.save(quiz);
     }
     
     
 	@GetMapping("/{id}/questions")
 	public ResponseEntity<List<QuestionWrapper>> getquizques(@PathVariable Long id){
 		return ResponseEntity.ok(quizserv.getquizques(id));
 	}
     
     @GetMapping("/{id}")
     public Quiz getQuizById(@PathVariable Long id) {
    	 return quizrepo.findById(id).orElseThrow();
     }
     
     @PostMapping("/{id}/score")
     public int calScore(@PathVariable Long id, @RequestBody List<Response> response) {
    	  Quiz quiz = quizrepo.findById(id).orElseThrow();

    	    AtomicInteger score = new AtomicInteger(0);
    	  for(Response res : response) {
    		  quiz.getQuestions().stream()
    		  .filter(q -> q.getId().equals(res.getId()))
    		  .findFirst()
    		  .ifPresent(q ->{
    			  if (q.getCorrectans().equalsIgnoreCase(res.getResponse())) {

                      score.incrementAndGet();
    			  }
    		  });
    	  }
    	  return score.get();
     }
	

}