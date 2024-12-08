package com.badbyte.demo.controller;

import com.badbyte.demo.dto.AuthenticateUserDTO;
import com.badbyte.demo.entity.Users;
import com.badbyte.demo.services.AuthService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthenticationController {
    @Autowired
    private AuthService authService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/login")
    public AuthenticateUserDTO login(@RequestBody AuthenticateUserDTO authenticateUserDTO) {
        String email = authenticateUserDTO.getEmail();
        Users user = authService.authenticateUser(email);
        AuthenticateUserDTO authenticateUser = modelMapper.map(user, AuthenticateUserDTO.class);
        return authenticateUser;
    }
}
