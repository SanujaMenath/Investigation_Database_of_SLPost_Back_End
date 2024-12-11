package com.badbyte.demo.services;

import com.badbyte.demo.config.JwtTokenUtils;
import com.badbyte.demo.dto.LoginRequest;
import com.badbyte.demo.dto.LoginResponse;
import com.badbyte.demo.entity.Users;
import com.badbyte.demo.repository.UserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenUtils jwtTokenUtils;

    public AuthenticationService(UserRepo userRepo, PasswordEncoder passwordEncoder, JwtTokenUtils jwtTokenUtils) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenUtils = jwtTokenUtils;
    }

    public LoginResponse authenticateUser(LoginRequest loginRequest) {
        // Find user by email
        Users user = userRepo.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        // Validate password
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        // Prepare claims for JWT
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", user.getRole());
        claims.put("locationType", user.getLocationType());
        claims.put("locationId", user.getLocationId());

        // Generate JWT token
        String token = jwtTokenUtils.generateToken(user.getEmail(), claims);

        // Return response
        return new LoginResponse(user.getId(), user.getEmail(), token);
    }
}

