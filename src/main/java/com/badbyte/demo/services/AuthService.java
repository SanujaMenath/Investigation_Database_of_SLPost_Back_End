package com.badbyte.demo.services;

import com.badbyte.demo.dto.AuthenticateUserDTO;
import com.badbyte.demo.entity.Users;
import com.badbyte.demo.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class AuthService {
    @Autowired
    private UserRepo userRepository;

    public Users authenticateUser(String email ) {
        AuthenticateUserDTO authenticateUserDTO = new AuthenticateUserDTO();
        Optional<Users> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            return user.get();
        }
        else {
            return user.orElseThrow(() -> new RuntimeException("User not found"));
        }
    }
}
