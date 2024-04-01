package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Role;
import com.example.demo.reposetory.RoleReposetry;

@Service
public class RoleService {
	
	@Autowired
	RoleReposetry roleReposetry;
	
	public void addRole(Role role) {
		
		roleReposetry.save(role);
		
	}
	
	public void addallRole(List<Role> roles) {
		
		roleReposetry.saveAll(roles);
		
	}
	
	
	public Role getRole(Long id) {
		return roleReposetry.findById(id).orElseThrow();
	}
	
	public List<Role> getRoles() {
		return roleReposetry.findAll();
	}
	
	public void updateRole(Role role) {
		
		Role current=roleReposetry.findById(role.getId()).orElseThrow();
		current.setId(role.getId());
		current.setRoleName(role.getRoleName());
		current.setSalary(role.getSalary());
		
		roleReposetry.save(current);
	}
	
	
	
	public List<Role> findByRoleNam(String role) {
		return roleReposetry.findByRoleName(role);
	}
	
	
	public List<Role> moresalary(double salary){
		return roleReposetry.moresalary(salary);
	}
	
	public List<Role> namecomp(String name){
		return roleReposetry.resname(name);
	}
	
	
	
	

}
