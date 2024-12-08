//package com.badbyte.demo.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.DisabledException;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Component;
//
//@Component
//public class JwtAuthenticationController {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private JwtTokenUtils jwtTokenUtils;
//
//    @Autowired
//    private UserDetailsService jwtUserDetailsService;
//
//    public JwtResponse generateAuthenticationToken(JwtRequest authenticationRequest)
//            throws DisabledException, BadCredentialsException {
//
//        authenticate          (authenticationRequest.getUsername(), authenticationRequest.getPassword());
//
//        final UserDetails userDetails = jwtUserDetailsService
//                .loadUserByUsername(authenticationRequest.getUsername());
//
//        final String token = jwtTokenUtils.generateToken(userDetails);
//
//        return new JwtResponse(token);
//    }
//}
