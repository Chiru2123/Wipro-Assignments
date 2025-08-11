package com.example.studentcrud.Repository;

import com.example.studentcrud.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // 🔍 Custom Methods

    // Find students by course name
    List<Student> findByCourse(String course);

    // Find students by email
    Student findByEmail(String email);

    // Find students whose name contains a keyword (case-insensitive)
    List<Student> findByNameContainingIgnoreCase(String keyword);
}
