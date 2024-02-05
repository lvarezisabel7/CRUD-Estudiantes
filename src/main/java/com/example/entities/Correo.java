package com.example.entities;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "correos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Correo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private int id;
    private String correo;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private Estudiante estudiante;


}
