package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.example.demo.entity.AppUser;
import com.example.demo.service.UserService;

import jakarta.websocket.server.PathParam;
@Controller
@RestController
@RequestMapping("/user")
public class UserController {


	@Autowired
	UserService userservice;
	
	@PostMapping("/add")
	public void addAppUse(@RequestBody AppUser user) {
		userservice.addAppUser(user);
	}
	
	@GetMapping("/get")
	public AppUser getAppUse(@Param(value = "id") Long id) {
		return userservice.getAppUser(id);
	}
	
	@PostMapping("/addall")
	public void addAlluse(@RequestBody List<AppUser> user) {
		userservice.addAlluser(user);
	}
	
	
	@GetMapping("/getall")
	public List<AppUser> getAllAppUse() {
		return userservice.getAllAppUser();
	}
	
	@PutExchange("/update")
	public void updateAppUse(@RequestBody AppUser user) {
		
		userservice.updateAppUser(user);
		
	}
	
	@DeleteMapping("/delete")
	public void deleteByid(@Param(value = "id") Long id) {
		userservice.deleteById(id);
	}
	
	
	@GetMapping("/cont")
	public List<AppUser> findByNameContaining (@PathParam(value = "username") String name){
		return userservice.findByNameCont(name);
	}

	
	/*public List<Coursee> findByDescriptionCont(String des){
		return coursereposetry.findByDescriptionContaining(des);
	}

	public 	List<Coursee> findByNameAndEnrolledStudentsName(String name,String studfaculty){
		return coursereposetry.findByNameContainingAndEnrolledStudents_FacultyContaining(name,studfaculty);
	}
	
	
	public List<Coursee> lowPricee( double price){
		return coursereposetry.lowPrice(price);
	}
*/

	

}
