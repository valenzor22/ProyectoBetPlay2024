package com.ligabtp.ligabetplay.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jugadores")
public class Jugador {

    @Id
    @Column(nullable = false, name = "id_jugador")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @Column(length = 100)
    private  String nombre;
    @Column(length = 100)
    private  String posicion;
    @Column(length = 100, name = "numero_camisa")
    private  Integer numeroCamisa;
    @Column(length = 100)
    private  String nacionalidad;
    @Column(length = 100, name = "piernahabil_jugador")
    private  String piernaHabilJugador;
    @Column(length = 100, name = "fecha_nacimiento")
    private Date fechaNacimiento;
}
