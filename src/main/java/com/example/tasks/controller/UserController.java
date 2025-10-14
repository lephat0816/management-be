package com.example.tasks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tasks.dto.UserDTO;
import com.example.tasks.entity.User;
import com.example.tasks.service.UserServiceImp;

import jakarta.validation.Valid;


@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class UserController {
    
    @Autowired
    private UserServiceImp userServiceImp;

    @PostMapping("/user")
    public ResponseEntity<?> newUser(@Valid @RequestBody User newUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getAllErrors());            
        }
        UserDTO savedUser = userServiceImp.createUser(newUser);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("/users")
    public List<UserDTO> getAllUsers() {
        return userServiceImp.getAllUsers() ;
    }

    @GetMapping("/user/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return userServiceImp.getUserById(id);  
    }

    @PutMapping("/user/{id}")
    public UserDTO updateUser(@RequestBody User newUser, @PathVariable Long id) {
        return userServiceImp.updateUser(id, newUser);
        
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable Long id) {
        userServiceImp.deleteUser(id);
        return "User with id " + id + " has been deleted successfully.";
    }
    
}
