package com.example.demo.reposetory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.AppUser;

@Repository
public interface AppUserReposetry extends JpaRepository<AppUser, Long>{
	
	
	List<AppUser> findByUserNameContaining(String name);
	Optional<AppUser> findByUserName(String name);
	Boolean existsByUserName(String name);

}
