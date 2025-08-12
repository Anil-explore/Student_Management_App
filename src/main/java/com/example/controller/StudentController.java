package com.example.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.entity.Student;
import com.example.service.StudentService;

@Controller
public class StudentController {

    private final StudentService service;

    // ✅ Constructor-based Dependency Injection
    public StudentController(StudentService service) {
        this.service = service;
    }

    // ✅ Show list of students (home page)
    @GetMapping("/")
    public String getStudents(Model model) {
        List<Student> list = service.getStudentsData();
        model.addAttribute("students", list); // ✅ Give a name for Thymeleaf
        return "index"; // maps to index.html
    }

    // ✅ Show form
    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        return "studentform"; // maps to studentform.html
    }

    // ✅ Handle form submission
    @PostMapping("/form")
    public String saveStudent(@ModelAttribute("student") Student stu) {
        String res = service.saveStudent(stu);
        System.out.println(res);
        return "redirect:/"; // ✅ redirect back to home after save
    }
}
