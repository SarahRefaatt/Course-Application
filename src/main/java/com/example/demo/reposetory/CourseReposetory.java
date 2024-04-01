package com.example.demo.reposetory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Coursee;

@Repository
public interface CourseReposetory extends JpaRepository<Coursee, Long>{
	
	
	List<Coursee> findByNameContaining (String name);
	
	List<Coursee> findByNameContainingAndEnrolledStudents_FacultyContaining(String name,String studfaculty);
	List<Coursee> findByDescriptionContaining (String des);
	
	@Query(value="select c from Coursee c where c.price<=:p")
	List<Coursee> lowPrice(@Param("p") double price);

}
