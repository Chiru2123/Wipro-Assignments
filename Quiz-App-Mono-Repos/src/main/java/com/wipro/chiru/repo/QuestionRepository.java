package com.wipro.chiru.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.chiru.entities.CategoryLevel;
import com.wipro.chiru.entities.DifficultyLevel;
import com.wipro.chiru.entities.Question;


public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findByCategoryAndDifficulty(CategoryLevel categoryEnum, DifficultyLevel levelEnum);

}