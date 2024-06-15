package com.jsp.wh.security;

import javax.naming.AuthenticationException;

import org.springdoc.core.properties.SwaggerUiConfigProperties.Csrf;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    @Bean
	PasswordEncoder  passwordEncoder() {
		return new BCryptPasswordEncoder(12);  

	}
    @Bean
    SecurityFilterChain securityFilterChain( HttpSecurity security) throws Exception {
    	return security.csrf(csrf -> csrf.disable())
    			.authorizeHttpRequests( authorize ->authorize.requestMatchers("/api/v1/register" ,"/login/**")
    					.permitAll().anyRequest().authenticated())
    			.formLogin( Customizer.withDefaults()).build(); 
    			
    }
     
    
    
}
