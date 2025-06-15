package com.uni.sistemaUniversitario.dto;

import com.uni.sistemaUniversitario.persistence.entity.Role;

public record RegisterRequest(
        String numeroIdentificacion,
        String numeroCarnet,
        String correo,
        String nombres,
        String apellidos,
        Role role,
        String contraseña) {

}
