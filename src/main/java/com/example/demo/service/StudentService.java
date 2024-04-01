package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.reposetory.StudentReposetory;

@Service
public class StudentService {
	
	@Autowired
	StudentReposetory studentreposetry;
	
	public void addStudent(Student student) {
		studentreposetry.save(student);
	}
	
	public Student getStudent(Long id) {
		return studentreposetry.findById(id).orElseThrow();
	}
	
	public void addAllStudent(List<Student> students) {
		studentreposetry.saveAll(students);
	}
	
	
	
	public List<Student> getAllStudent() {
		return studentreposetry.findAll();
	}
	
/*	public void updateStudent(Student student) {
		Student current=studentreposetry.findById(student.getId()).orElseThrow();
		
		current.setId(student.getId());
		current.setName(student.getName());
		current.setExperience(student.getExperience());
		current.setFaculty(student.getFaculty());
		current.setDoneCourses(student.getDoneCourses());
		
		studentreposetry.save(current);

		
	}*/
	
	public void deleteById(Long id) {
		studentreposetry.delete(studentreposetry.findById(id).orElseThrow());
	}
	

}
