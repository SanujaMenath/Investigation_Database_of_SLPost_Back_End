package com.badbyte.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LoginResponse {

    private Long userId;
    private String email;
    private String token;

}

