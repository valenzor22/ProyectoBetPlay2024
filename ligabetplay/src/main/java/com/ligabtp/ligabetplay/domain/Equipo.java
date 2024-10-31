package com.ligabtp.ligabetplay.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "equipos")
public class Equipo {

    @Id
    @Column(nullable = false, name = "id_equipo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @Column(length = 100, nullable = false)
    private  String nombre;
    @Column(length = 100)
    private  String ciudad;
    @Column(length = 100)
    private  String estadio;
    @Column(length = 100)
    private  String entrenador;
}

