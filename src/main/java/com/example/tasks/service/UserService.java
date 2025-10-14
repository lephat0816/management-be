package com.example.tasks.service;

import java.util.List;

import com.example.tasks.dto.UserDTO;
import com.example.tasks.entity.User;

public interface UserService {
    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
    UserDTO createUser(User user);
    UserDTO updateUser(Long id, User user);
    void deleteUser(Long id);
}
