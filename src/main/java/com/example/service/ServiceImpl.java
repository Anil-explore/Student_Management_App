package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Repo.StudentRepo;
import com.example.entity.Student;
@Service
public class ServiceImpl implements StudentService {
	
	private StudentRepo repo;
	
	public ServiceImpl(StudentRepo repo) {
		this.repo=repo;
	}
	

	@Override
	public List<Student> getStudentsData() {
		List<Student> list = repo.findAll();
		return list;
	}

	@Override
	public String saveStudent(Student s) {
		Student data = repo.save(s);
		if (data!=null) {
			return "Student Data Saved";
		}
		else {
			return "not saved";
	}

}
}
