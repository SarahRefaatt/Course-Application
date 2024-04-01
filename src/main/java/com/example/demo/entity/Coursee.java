package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Coursee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	String name;
	String description;
	double price;
	int star;
	
	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name="course_id"),inverseJoinColumns = @JoinColumn(name="stud_id"))
	List<Student> enrolledStudents;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public List<Student> getEnrolledStudents() {
		return enrolledStudents;
	}

	public void setEnrolledStudents(List<Student> enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}

	

}
