package com.example.tasks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tasks.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // Repository methods would be defined here
    public List<User> findByUsername(String username);
    boolean existsByUsername(String username);

}
