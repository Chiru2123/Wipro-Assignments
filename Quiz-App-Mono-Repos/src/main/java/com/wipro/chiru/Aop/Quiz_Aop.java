package com.wipro.chiru.Aop;

import java.time.LocalDateTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Aspect 
@Component 
@Slf4j
public class Quiz_Aop {
	@Before("execution(* com.quizapp.example.service.QuizserviceImpl.calculateResult(..))")
    public void beforeSubmitQuiz(JoinPoint joinPoint) {
        LocalDateTime time = LocalDateTime.now();
        log.info("About to submit quiz at: {}",time);

    }
}
