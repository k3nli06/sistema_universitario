package com.uni.sistemaUniversitario.persistence.repository;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.uni.sistemaUniversitario.persistence.entity.CursoEntity;

@DataJpaTest(showSql = true)
public class CursoRepositoryTest {

    @Autowired
    CursoRepository repository;

    @Test
    public void cursoRepositoryTest() {
        CursoEntity curso = new CursoEntity(1, "introduccion", null);

        repository.save(curso);
        assertNotNull(repository.findById(1));
    
    }

}
