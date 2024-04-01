package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.example.demo.entity.Coursee;
import com.example.demo.service.CourseService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/course")
public class CourseController {
	

	@Autowired
	CourseService courseservice;
	
	@PostMapping("/add")
	public void adddCourse(@RequestBody Coursee course) {
		courseservice.addCourse(course);
	}
	
	@PostMapping("/addall")
	public void adddAllCourse(@RequestBody List<Coursee> courses) {
		courseservice.addAllCourse(courses);
	}
	@GetMapping("/get/{id}")
	public Coursee gettCourse(@PathVariable Long id) {
		return courseservice.getCourse(id);
	}
	
	@GetMapping("/getall")
	public List<Coursee> gettAllCourse(){
		return courseservice.getAllCourse();
	}
	
	@PutExchange("/update")
	public void updateeCourse(@RequestBody Coursee course) {
		courseservice.updateCourse(course);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteeCourse(@PathVariable Long id) {
		courseservice.deleteById(id);
	}
	
	@GetMapping("/namecont")
	public List<Coursee> findByNameCon (@PathParam(value = "name") String name){
		return courseservice.findByNameCont(name);
	}
	
	@GetMapping("/des/cont")
	public List<Coursee> findByDescriptionCon (@PathParam(value = "des") String des){
		return courseservice.findByDescriptionCont(des);
	}
	
	@GetMapping("/name/fac/cont")
	public 	List<Coursee> findByAndEnrolledStudents(@PathParam(value = "name") String name,@PathParam(value = "fac")String studfaculty){
		return courseservice.findByNameAndEnrolledStudentsName(name, studfaculty);
	}
	
	
	@GetMapping("/lowprice")

	public List<Coursee> lowPrice(@PathParam(value="price") double price){
		return courseservice.lowPricee(price);
	}

	
	

}
