package com.uni.sistemaUniversitario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.uni.sistemaUniversitario.persistence.entity.Role;
import com.uni.sistemaUniversitario.persistence.entity.UserEntity;
import com.uni.sistemaUniversitario.persistence.repository.UserRepository;

@SpringBootApplication
public class SistemaUniversitarioApplication {

    public static void main(String[] args) {
        SpringApplication.run(SistemaUniversitarioApplication.class, args);
    }

    @Autowired
    UserRepository repository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Bean
    CommandLineRunner runner() {
        return args -> {
            UserEntity user = new UserEntity(1L, "610-0000000-9999Y",
                    "25-009044-0040", "hhhh@hh.com",
                    "k l", "m l", Role.ESTUDIANTE,
                    null, null, passwordEncoder.encode("1234"));
            repository.save(user);
        };
    }

}
