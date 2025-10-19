package com.example.tasks.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tasks.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // Repository methods would be defined here
    public User findByUsername(String username);
    boolean existsByUsername(String username);

}
