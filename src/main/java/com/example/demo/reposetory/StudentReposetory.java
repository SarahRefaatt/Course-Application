package com.example.demo.reposetory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;
@Repository
public interface StudentReposetory extends JpaRepository<Student, Long> {

}
