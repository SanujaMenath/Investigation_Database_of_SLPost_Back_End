package com.badbyte.demo.controller;

import com.badbyte.demo.entity.Users;
import com.badbyte.demo.dto.UserDTO;
import com.badbyte.demo.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:8080")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    // Create a new user
    @PostMapping("/add")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        // Map DTO to entity
        Users users = modelMapper.map(userDTO, Users.class);
        Users savedUsers = userService.registerUser(users);

        // Map entity back to DTO
        UserDTO savedUserDTO = modelMapper.map(savedUsers, UserDTO.class);
        return ResponseEntity.ok(savedUserDTO);
    }

    // Get all users
    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<Users> users = userService.getAllUsers();

        // Map list of entities to list of DTOs
        List<UserDTO> userDTOs = users.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(userDTOs);
    }

    // Get a user by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        Users users = userService.getUserById(id);


        UserDTO userDTO = modelMapper.map(users, UserDTO.class);
        return ResponseEntity.ok(userDTO);
    }

}
