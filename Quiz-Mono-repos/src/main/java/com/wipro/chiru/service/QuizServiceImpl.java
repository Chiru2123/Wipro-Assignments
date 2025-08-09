package com.wipro.chiru.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.wipro.chiru.entities.Question;
import com.wipro.chiru.entities.QuestionWrapper;
import com.wipro.chiru.repository.QuestionRepository;


@Service
public class QuizServiceImpl implements QuizService {

    
    private final QuestionRepository quesrepo;

    public QuizServiceImpl( QuestionRepository quesrepo ) {
    
        this.quesrepo= quesrepo;
    }

    @Override
    public List<QuestionWrapper> getquizques(Long quizId) {
    	
    	List<Question> question = quesrepo.findByQuizId(quizId);


        return question.stream()
                .map(q -> new QuestionWrapper(
                		q.getId(),
                		q.getQuestiontitle(),
                		q.getOption1(),
                		q.getOption2(),
                		q.getOption3(),
                		q.getOption4()
                		
          
                ))
                .collect(Collectors.toList());
    }
}
