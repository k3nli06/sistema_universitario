package com.uni.sistemaUniversitario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uni.sistemaUniversitario.dto.AuthenticationResponse;
import com.uni.sistemaUniversitario.dto.LoginRequest;
import com.uni.sistemaUniversitario.dto.RegisterRequest;
import com.uni.sistemaUniversitario.service.AuthenticationService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/v1/")
public class AuthController {

    @Autowired
    AuthenticationService authService;

    @PostMapping("login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok().body(authService.login(request));        
    }

    @PostMapping("register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.created(null).body(authService.register(request));
    }
    

}
