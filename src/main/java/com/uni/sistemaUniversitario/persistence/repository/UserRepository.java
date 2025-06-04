package com.uni.sistemaUniversitario.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uni.sistemaUniversitario.persistence.entity.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
