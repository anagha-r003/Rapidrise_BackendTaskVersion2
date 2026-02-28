package com.rapidrise.task1.service;

import com.rapidrise.task1.dto.AuthRequest;
import com.rapidrise.task1.dto.AuthResponse;
import com.rapidrise.task1.exception.InvalidCredentialsException;
import com.rapidrise.task1.security.JwtUtil;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final JwtUtil jwtUtil;

    public AuthService(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    public AuthResponse authenticate(AuthRequest request) {

        if ("admin".equals(request.getUsername()) &&
                "admin123".equals(request.getPassword())) {

            String token = jwtUtil.generateToken(request.getUsername());
            return new AuthResponse(token);

        } else {
            throw new InvalidCredentialsException("Invalid Username or Password");
        }
    }
}
