package com.example.studentcrud.Service;

import com.example.studentcrud.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    Student getStudentById(Long id);

    Student saveStudent(Student student);

    Student updateStudent(Long id, Student student);

    void deleteStudentById(Long id);

    // Custom method examples
    List<Student> getStudentsByCourse(String course);

    Student getStudentByEmail(String email);

    List<Student> searchStudentsByName(String keyword);
}
