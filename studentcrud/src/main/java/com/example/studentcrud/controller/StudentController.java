package com.example.studentcrud.controller;

import com.example.studentcrud.model.Student;
import com.example.studentcrud.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // 📄 Show all students
    @GetMapping
    public String listStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "students"; // HTML page: students.html
    }

    // ➕ Show form to add new student
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("student", new Student());
        return "create_student"; // HTML page: create_student.html
    }

    // 💾 Save student
    @PostMapping
    public String saveStudent(@ModelAttribute("Student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    // ✏️ Show form to update student
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "edit_student"; // HTML page: edit_student.html
    }

    // 📝 Update student
    @PostMapping("/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student) {
        studentService.updateStudent(id, student);
        return "redirect:/students";
    }

    // ❌ Delete student
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }

    // 🔍 Search students by name
    @GetMapping("/search")
    public String searchStudents(@RequestParam("keyword") String keyword, Model model) {
        List<Student> results = studentService.searchStudentsByName(keyword);
        model.addAttribute("students", results);
        return "students";
    }
}
