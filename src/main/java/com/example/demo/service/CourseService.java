package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Coursee;
import com.example.demo.reposetory.CourseReposetory;
@Service
public class CourseService {
	@Autowired
	CourseReposetory coursereposetry;
	
	public void addCourse(Coursee course) {
		coursereposetry.save(course);
	}
	
	public Coursee getCourse(Long id) {
		return coursereposetry.findById(id).orElseThrow();
	}
	
	public void addAllCourse(List<Coursee> courses) {
		coursereposetry.saveAll(courses);
	}
	
	
	
	public List<Coursee> getAllCourse() {
		return coursereposetry.findAll();
	}
	
	public void updateCourse(Coursee course) {
		Coursee current=coursereposetry.findById(course.getId()).orElseThrow();
		
		current.setId(course.getId());
		current.setName(course.getName());
		current.setDescription(course.getDescription());
		current.setPrice(course.getPrice());
		current.setEnrolledStudents(course.getEnrolledStudents());
		current.setStar(course.getStar());
		coursereposetry.save(current);

		
	}
	
	public void deleteById(Long id) {
		coursereposetry.delete(coursereposetry.findById(id).orElseThrow());
	}
	
	
	public List<Coursee> findByNameCont (String name){
		return coursereposetry.findByNameContaining(name);
	}

	
	public List<Coursee> findByDescriptionCont(String des){
		return coursereposetry.findByDescriptionContaining(des);
	}

	public 	List<Coursee> findByNameAndEnrolledStudentsName(String name,String studfaculty){
		return coursereposetry.findByNameContainingAndEnrolledStudents_FacultyContaining(name,studfaculty);
	}
	
	
	public List<Coursee> lowPricee( double price){
		return coursereposetry.lowPrice(price);
	}


	

}
