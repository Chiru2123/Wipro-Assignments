package com.example.studentcrud.Service;

import com.example.studentcrud.model.Student;
import com.example.studentcrud.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        Optional<Student> optional = studentRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long id, Student updatedStudent) {
        Student existing = getStudentById(id);
        if (existing != null) {
            existing.setName(updatedStudent.getName());
            existing.setEmail(updatedStudent.getEmail());
            existing.setCourse(updatedStudent.getCourse());
            existing.setDepartment(updatedStudent.getDepartment());
            existing.setCollege(updatedStudent.getCollege());
            existing.setCity(updatedStudent.getCity());
            return studentRepository.save(existing);
        }
        return null;
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getStudentsByCourse(String course) {
        return studentRepository.findByCourse(course);
    }

    @Override
    public Student getStudentByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    @Override
    public List<Student> searchStudentsByName(String keyword) {
        return studentRepository.findByNameContainingIgnoreCase(keyword);
    }
}
