package com.rapidrise.task1.controller;

import com.rapidrise.task1.dto.AuthRequest;
import com.rapidrise.task1.dto.AuthResponse;
import com.rapidrise.task1.dto.ResponseStructure;
import com.rapidrise.task1.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseStructure<AuthResponse>> login(@RequestBody AuthRequest request) {
        AuthResponse response = authService.authenticate(request);
        return new ResponseEntity<>(
                new ResponseStructure<>(200, "Login Successful", response),
                HttpStatus.OK
        );
    }
}
