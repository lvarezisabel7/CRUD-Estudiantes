package com.example.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cursos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Curso implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private int id;
    private String descripcion;
    private Horario horario;



@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "curso")
private List<Estudiante> estudiante;

}
