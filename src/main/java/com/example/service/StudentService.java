package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Student;
@Service
public interface StudentService {
	
	public List<Student> getStudentsData();
	public String saveStudent(Student s);
	

}
