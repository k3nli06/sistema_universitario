package com.uni.sistemaUniversitario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.uni.sistemaUniversitario.dto.*;
import com.uni.sistemaUniversitario.persistence.entity.UserEntity;
import com.uni.sistemaUniversitario.persistence.repository.UserRepository;

@Service
public class AuthenticationService {
    
    @Autowired
    JwtService jwtService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserRepository repository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public AuthenticationResponse login(LoginRequest userRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userRequest.carnet(), userRequest.contraseña()));
        UserEntity user = repository.findByNumeroCarnetOrCorreo(userRequest.carnet(), userRequest.carnet()).get();

        return new AuthenticationResponse(jwtService.getToken(user));
    }

    public AuthenticationResponse register(RegisterRequest request) {
        UserEntity userEntity = new UserEntity(null, request.numeroIdentificacion(), null, null, request.nombres(), request.apellidos(), request.role(), null, null, request.contraseña());
        repository.save(userEntity);
        return new AuthenticationResponse(jwtService.getToken(userEntity));
    }

}
