package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Student;

public interface StudentService {

	Student getById(Integer id);
	List<Student> getAllStudent();
	Student addStudent(Student student);
	void deleteStudent(Integer id);
	Student updateStudent(Student student, Integer id);
}
