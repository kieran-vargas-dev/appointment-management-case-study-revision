package com.kieran_vargas.schedulercapstonerevision.repository;

import com.kieran_vargas.schedulercapstonerevision.security.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
