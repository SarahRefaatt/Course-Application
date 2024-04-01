package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.example.demo.entity.Role;
import com.example.demo.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	RoleService roleService;
	
	@PostMapping("/add")
	public void addRol(@RequestBody Role role) {
		
		roleService.addRole(role);
		
		
	}
	
	@PostMapping("/addall")
	public void addallRoles(@RequestBody List<Role> roles) {
		
		roleService.addallRole(roles);
		
	}
	
	
	@GetMapping("/get")
	public Role getRol(@Param(value = "id") Long id) {
		return roleService.getRole(id);
	}
	
	@GetMapping("/getall")
	public List<Role> getallRoles() {
		return roleService.getRoles();
		
	}
	
	@PutExchange("/update")
	public void updateRol(@RequestBody Role role) {
		roleService.updateRole(role);
		
	}
	
	
	@GetMapping("/name")
	public List<Role> findByRoleName(@Param(value = "name") String role) {
		return roleService.findByRoleNam(role);
	}
	
	@GetMapping("/salary")

	public List<Role> moresalaryComp(@Param(value = "salary") double salary){
		return roleService.moresalary(salary);
	}
	
	@GetMapping("/namecomp")

	public List<Role> nameComp(@Param(value = "name") String name){
		return roleService.namecomp(name);
	}
	
	
	
	

}
