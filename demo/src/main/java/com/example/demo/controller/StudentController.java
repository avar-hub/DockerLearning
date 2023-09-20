package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/getById")
	public ResponseEntity<Student> getById(@RequestParam Integer id)
	{
		return new ResponseEntity<>(studentService.getById(id),HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Student>> getAll()
	{
		return new ResponseEntity<>(studentService.getAllStudent(),HttpStatus.OK);
	}
	
	@PostMapping("/addStudent")
	public ResponseEntity<Student> addStudent(@RequestBody Student student)
	{
		 return new ResponseEntity<>(studentService.addStudent(student),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteStudent")
	public ResponseEntity<String> deleteStudent(@RequestParam Integer id)
	{
		studentService.deleteStudent(id);
		return new ResponseEntity<>("Student deleted",HttpStatus.OK);
	}
	
	@PutMapping("/updateStudent")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student,@RequestParam Integer id)
	{
	return new ResponseEntity<>(studentService.updateStudent(student, id),HttpStatus.OK);
	}
}
