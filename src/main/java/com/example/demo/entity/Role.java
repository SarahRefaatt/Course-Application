package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	
	private String roleName;
	
	

	private double salary;
	
	
	public Role() {}
	public Role(Long id, String roleName, double salary) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.salary = salary;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}






	public String getRoleName() {
		return roleName;
	}



	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}



	public double getSalary() {
		return salary;
	}



	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	

}
