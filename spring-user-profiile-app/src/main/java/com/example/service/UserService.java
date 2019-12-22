package com.example.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.model.User;
import com.example.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}
