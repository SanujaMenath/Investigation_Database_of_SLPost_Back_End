package com.badbyte.demo.controller;

import com.badbyte.demo.dto.LoginRequest;
import com.badbyte.demo.dto.LoginResponse;
import com.badbyte.demo.services.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:8080")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        LoginResponse response = authenticationService.authenticateUser(loginRequest);
        return ResponseEntity.ok(response);
    }
}

