package com.uni.sistemaUniversitario.persistence.repository;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.uni.sistemaUniversitario.persistence.entity.UserEntity;

@DataJpaTest(showSql = true)
public class UserRepositoryTest {

    @Autowired
    UserRepository repository;

    @Test
    public void userRepositoryTest() {
        UserEntity user = new UserEntity(1L, "610-061207-1000Y", "0008998990", null, null, null, null, null, null, null);

        repository.save(user);
        assertNotNull(repository.findById(1L));

    }

}
