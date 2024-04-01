package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/stud")
public class StudentController {
	
	@Autowired
	StudentService studentservice;
	
	
	//@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/hi")
	public String hello() {
		return "<h1>helloooo</h1>";
	}
	
	@PostMapping("/add")
	public void adddStudent(@RequestBody Student student) {
		studentservice.addStudent(student);
	}
	
	@PostMapping("/addall")
	public void adddAllStudent(@RequestBody List<Student> students) {
		studentservice.addAllStudent(students);
	}
	@GetMapping("/get/{id}")
	public Student gettStudent(@PathVariable Long id) {
		return studentservice.getStudent(id);
	}
	
	@GetMapping("/getall")
	public List<Student> gettAllStudent(){
		return studentservice.getAllStudent();
	}
	
	/*@PutExchange("/update")
	public void updateeStudent(@RequestBody Student student) {
		studentservice.updateStudent(student);
	}*/
	
	@DeleteMapping("/delete/{id}")
	public void deleteeStudent(@PathVariable Long id) {
		studentservice.deleteById(id);
	}
	

}
