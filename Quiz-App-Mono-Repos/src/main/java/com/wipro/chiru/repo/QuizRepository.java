package com.wipro.chiru.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.chiru.entities.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

}
