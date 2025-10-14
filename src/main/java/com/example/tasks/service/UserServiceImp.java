package com.example.tasks.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.tasks.dto.UserDTO;
import com.example.tasks.entity.User;
import com.example.tasks.exception.UserNotFoundException;
import com.example.tasks.mapper.UserMapper;
import com.example.tasks.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return UserMapper.toDTOList(users);
    }
    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return UserMapper.toDTO(user);}
    @Override
    public UserDTO createUser(User user) {
        User savedUser = userRepository.save(user);
        return UserMapper.toDTO(savedUser);
    }
    @Override
    public UserDTO updateUser(Long id, User newUser) {
        User updatedUser = userRepository.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    return userRepository.save(user);
                }).orElseThrow(() -> new UserNotFoundException(id));
        return UserMapper.toDTO(updatedUser);
    }
    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
    }
}
