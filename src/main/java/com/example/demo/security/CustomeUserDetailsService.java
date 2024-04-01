package com.example.demo.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AppUser;
import com.example.demo.entity.Role;
import com.example.demo.reposetory.AppUserReposetry;

@Service
public class CustomeUserDetailsService implements UserDetailsService{
	
	AppUserReposetry userReposetry;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		AppUser user=userReposetry.findByUserName(username).orElseThrow(()->new UsernameNotFoundException("usernot found"));
		
		
		
		// TODO Auto-generated method stub
		return new User(user.getUserName(),user.getPassword(),mapRolesToAuthorties(user.getRoles()));
	}
	
	
	Collection<GrantedAuthority> mapRolesToAuthorties(List<Role> roles){
		return roles.stream().map(role->new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
	}

	
}
