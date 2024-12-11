package com.badbyte.demo.config;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;

public class JwtAuthentication extends AbstractAuthenticationToken {

    private final String email;
    private final Object claims;

    public JwtAuthentication(String email, Object claims) {
        super(Collections.singletonList(new SimpleGrantedAuthority("USER"))); // Update roles as needed
        this.email = email;
        this.claims = claims;
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return email;
    }

    public Object getClaims() {
        return claims;
    }
}
