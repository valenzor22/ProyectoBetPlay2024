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
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;




    @Column(length = 100)
    private String nombre_jugador;

    @Column(length = 100)
    private String apellido_jugador;

    @Column(length = 100)
    private Date fechanacimiento_jugador;

    @Column(length = 100)
    private String posicion_jugador;

    @Column(length = 100)
    private String dorsal_jugador;

    @Column(length = 100)
    private String nacionalidad_jugador;

    @Column(length = 100)
    private String piernahabil_jugador;

}


