package com.example.demo.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.RegisterDTO;
import com.example.demo.entity.AppUser;
import com.example.demo.reposetory.AppUserReposetry;
import com.example.demo.reposetory.RoleReposetry;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private  AuthenticationManager authenticationManager;
    private  AppUserReposetry appUserRepository;
    private  RoleReposetry roleRepository;
    private  PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, AppUserReposetry appUserRepository,
            RoleReposetry roleRepository, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.appUserRepository = appUserRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }
    
    
    @PostMapping("/login")
    
    public ResponseEntity<String > login(@RequestBody LoginDto logindto){
    	
    	
    	org.springframework.security.core.Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(logindto.getUsername(), 
    			logindto.getPassword()));
    	
    	SecurityContextHolder.getContext().setAuthentication(authentication);
		return new ResponseEntity<>("User signed success!",HttpStatus.OK);
    	
    }
    
    
    
    

    @PostMapping("/reg")
    public ResponseEntity<String> register(@RequestBody RegisterDTO registerDto) {
        if (appUserRepository.existsByUserName(registerDto.getUsername())) {
            return new ResponseEntity<>("Username is taken!", HttpStatus.BAD_REQUEST);
        }

        AppUser user = new AppUser();
        user.setUserName(registerDto.getUsername());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        List<com.example.demo.entity.Role> roles = Collections.singletonList(roleRepository.findByRoleName("USER").get(0));

        user.setRoles(roles);

        appUserRepository.save(user);

        return new ResponseEntity<>("Registration successful!", HttpStatus.OK);
    }
}