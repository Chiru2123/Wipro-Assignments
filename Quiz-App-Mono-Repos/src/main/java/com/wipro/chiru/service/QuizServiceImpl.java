package com.wipro.chiru.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.chiru.entities.CategoryLevel;
import com.wipro.chiru.entities.DifficultyLevel;
import com.wipro.chiru.entities.Question;
import com.wipro.chiru.entities.QuestionWrapper;
import com.wipro.chiru.entities.Quiz;
import com.wipro.chiru.entities.Response;
import com.wipro.chiru.exception.USER_NOT_FOUND_EXCEPTION;
import com.wipro.chiru.repo.QuizRepository;
import com.wipro.chiru.repo.QuestionRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuestionRepository qrepo;

    @Autowired
    private QuizRepository qr;

    @Override
    public Quiz createQuiz(String category, String level, String title) {
        CategoryLevel categoryEnum;
        DifficultyLevel levelEnum;

        try {
            categoryEnum = CategoryLevel.valueOf(category.toUpperCase());
            levelEnum = DifficultyLevel.valueOf(level.toUpperCase());
        } catch (IllegalArgumentException e) {
        	
            throw new RuntimeException("Invalid category or difficulty level");
        }

        List<Question> questions = qrepo.findByCategoryAndDifficulty(categoryEnum, levelEnum);

        if (questions.isEmpty()) {
            throw new RuntimeException("No questions found for category: " + category + " and level: " + level);
        }

        Quiz quiz = new Quiz();
        quiz.setQuizTitle(title);
        quiz.setQuestions(questions);
        return qr.save(quiz);
    }


    @Override
    public List<QuestionWrapper> getQuizquestions(Long id) {
        Optional<Quiz> quiz = qr.findById(id);
        if (quiz.isEmpty()) {
        	log.warn("Exception occcured");
            throw new RuntimeException("Quiz not found with id: " + id);
        }

        List<Question> questionsFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUser = new ArrayList<>();
        for (Question q : questionsFromDB) {
            QuestionWrapper qw = new QuestionWrapper(
                q.getId(),
                q.getQuestionTitle(),  
                q.getOption1(),
                q.getOption2(),
                q.getOption3(),
                q.getOption4()
            );
            questionsForUser.add(qw);
        }

        return questionsForUser;
    }

    @Override
    public Integer calculateResult(int id, List<Response> responses) {
        Quiz quiz = qr.findById((long) id)
                .orElseThrow(() -> new USER_NOT_FOUND_EXCEPTION("Quiz not found with id: " + id));

        List<Question> questions = quiz.getQuestions();
        int rightAnswerScore = 0;

        for (Response response : responses) {
            for (Question question : questions) {
                if (question.getId().equals(response.getId())) {
                    String correctAnswer = question.getCorrectAnswer();
                    String userAnswer = response.getResponse();
                    if (correctAnswer != null && userAnswer != null &&
                            correctAnswer.trim().equalsIgnoreCase(userAnswer.trim())) {
                        rightAnswerScore++;
                    }
                    break;
                }
            }
        }
        return rightAnswerScore;
    }

}

