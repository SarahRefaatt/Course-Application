package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@EnableMethodSecurity
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	CustomeUserDetailsService customerUserService;

	@Autowired
    public SecurityConfig(CustomeUserDetailsService customerUserService) {
		super();
		this.customerUserService = customerUserService;
	}


	@Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain configure(HttpSecurity http ) throws Exception{

        http
                .authorizeHttpRequests((auth)->auth.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());
        return http.build();


    }

    @Bean
    public UserDetailsService userDetailsService(){

        UserDetails admin= User.builder()
                .username("sarah")
                .password(passwordEncoder().encode("sarah"))
                .roles("ADMIN")
                .build();

        UserDetails user= User.builder()
                .username("user")
                .password(passwordEncoder().encode("user"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin,user);



    }
    
    @Bean
    public AuthenticationManager authenticationManger(AuthenticationConfiguration authenticationConfiguerer) throws Exception{
		return authenticationConfiguerer.getAuthenticationManager();
    	
    }
    
    @Bean
    PasswordEncoder passwordEncoder1() {
    	return new BCryptPasswordEncoder();
    }



}
