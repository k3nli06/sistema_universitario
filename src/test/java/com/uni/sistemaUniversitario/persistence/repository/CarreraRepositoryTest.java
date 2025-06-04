package com.uni.sistemaUniversitario.persistence.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.uni.sistemaUniversitario.persistence.entity.CarreraEntity;

@DataJpaTest(showSql = true)
public class CarreraRepositoryTest {
    @Autowired
    CarreraRepository repository;
    
    @Test
    public void testCarreraRepository() {

        CarreraEntity carrera = new CarreraEntity();
        carrera.setCarrera("ingenieria en sistemas");
        carrera.setAño(1);

        repository.save(carrera);

        assertNotNull(repository.findById(1));
    }

}
