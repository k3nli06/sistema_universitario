package com.uni.sistemaUniversitario.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uni.sistemaUniversitario.persistence.entity.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    public Optional<UserEntity> findByNumeroCarnetOrCorreo(String numeroCarnet, String Correo);

    public Optional<UserEntity> findByNombres(String nombres);

}
