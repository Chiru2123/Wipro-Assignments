package com.wipro.chiru.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String questionTitle;   

    private String option1;
    private String option2;
    private String option3;
    private String option4;

    private String correctAnswer;   

    @Enumerated(EnumType.STRING)
    private DifficultyLevel difficulty;

    @Enumerated(EnumType.STRING)
    private CategoryLevel category;
}
