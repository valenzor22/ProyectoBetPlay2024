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
    @Column(length = 100)
    private  Integer numero_camisa;
    @Column(length = 100)
    private  String nacionalidad;
    @Column(length = 100)
    private  String piernahabil_jugador;
    @Column(length = 100)
    private Date fecha_nacimiento;
}
