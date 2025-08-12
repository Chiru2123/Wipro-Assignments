package com.wipro.chiru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.chiru.entities.Question;
import com.wipro.chiru.exception.USER_NOT_FOUND_EXCEPTION;
import com.wipro.chiru.repo.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository qrepo;

    @Override
    public List<Question> getquestions() {
        return qrepo.findAll();
    }

    @Override
    public Question save(Question question) {
        return qrepo.save(question);
    }

    @Override
    public Question patchupdatequestions(Long id, Question question) {
        Question existing = qrepo.findById(id)
            .orElseThrow(() -> new USER_NOT_FOUND_EXCEPTION("Question not found with id: " + id));

        if (question.getQuestionTitle() != null)
            existing.setQuestionTitle(question.getQuestionTitle());

        if (question.getOption1() != null)
            existing.setOption1(question.getOption1());

        if (question.getOption2() != null)
            existing.setOption2(question.getOption2());

        if (question.getOption3() != null)
            existing.setOption3(question.getOption3());

        if (question.getOption4() != null)
            existing.setOption4(question.getOption4());

        if (question.getCorrectAnswer() != null)
            existing.setCorrectAnswer(question.getCorrectAnswer());

        if (question.getDifficulty() != null)
            existing.setDifficulty(question.getDifficulty());

        if (question.getCategory() != null)
            existing.setCategory(question.getCategory());

        return qrepo.save(existing);
    }

    @Override
    public void deletequestion(Long id) {
        qrepo.deleteById(id);
    }
}
