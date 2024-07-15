package com.example.myapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.example.myapp.model.User;

@Configuration
@EnableWebMvc
public class SessionConfig {

    @Bean
    @SessionScope
    public User sessionUser() {
        return new User();
    }
}
