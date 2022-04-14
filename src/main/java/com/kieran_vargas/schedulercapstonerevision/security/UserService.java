package com.kieran_vargas.schedulercapstonerevision.security;

import com.kieran_vargas.schedulercapstonerevision.dtos.UserRegistrationDto;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}
