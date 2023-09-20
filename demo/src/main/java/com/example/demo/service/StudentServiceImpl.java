package com.example.demo.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.StudentRepo;
import com.example.demo.entity.Student;
import com.example.demo.exception.UserNotFoundException;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepo studentRepo;
	
	@Override
	public Student getById(Integer id) {
		return studentRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
	}
	@Override
	public List<Student> getAllStudent() {
		return studentRepo.findAll();
	}

	@Override
	public Student addStudent(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public void deleteStudent(Integer id) {
		if(studentRepo.existsById(id))
			studentRepo.deleteById(id);
		else {
			throw new UserNotFoundException("User not found");
		}		
	}

	@Override
	public Student updateStudent(Student student, Integer id) {
		Student student2= studentRepo.findById(id).orElseThrow(()-> new UserNotFoundException("User not found"));
		BeanUtils.copyProperties(student, student2);
		return studentRepo.save(student2);
	}	
}
