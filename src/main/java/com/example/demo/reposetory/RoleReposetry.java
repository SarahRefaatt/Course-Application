package com.example.demo.reposetory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Role;

@Repository
public interface RoleReposetry extends JpaRepository<Role, Long>{
	
	List<Role> findByRoleName(String role);
	
	@Query(value="select r from Role r where r.salary>:salary")
	List<Role> moresalary(@Param("salary") double salary);
	
	@Query(value="select r from Role r where r.roleName>=:name")
	List<Role> resname(@Param("name") String name);


}
