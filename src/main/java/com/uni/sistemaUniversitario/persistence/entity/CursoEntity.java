package com.uni.sistemaUniversitario.persistence.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cursos")
public class CursoEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nombre;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "curso_user",
            joinColumns = {@JoinColumn(name = "curso_id") },
            inverseJoinColumns = {@JoinColumn(name = "user_id") })
    private Set<UserEntity> participantes;

    public void addUser(UserEntity user) {
        this.participantes.add(user);
        user.getCursos().add(this);
    }

    public void unregisterUser(UserEntity user) {
        this.participantes.remove(user);
        user.getCursos().remove(this);
    }

}
