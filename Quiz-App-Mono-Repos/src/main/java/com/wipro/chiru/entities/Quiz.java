package com.wipro.chiru.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String quizTitle; 

    @ManyToMany
    @JoinTable(
        name = "quiz_question",
        joinColumns = @JoinColumn(name = "quiz_id"),
        inverseJoinColumns = @JoinColumn(name = "question_id")
    )
    private List<Question> questions; // ✅ spacing and naming

}
