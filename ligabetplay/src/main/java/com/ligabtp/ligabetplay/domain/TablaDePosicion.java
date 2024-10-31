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
@Table(name = "tabladeposiciones")
public class TablaDePosicion {

    @Id
    @Column(nullable = false, name = "id_posicion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @Column(length = 100)
    private  Integer puntos;
    @Column(length = 100, name = " partidos_jugados")
    private  Integer partidosJugados;
    @Column(length = 100)
    private  Integer ganados;
    @Column(length = 100)
    private  Integer empatados;
    @Column(length = 100)
    private  Integer perdidos;
    @Column(length = 100, name = "goles_favor ")
    private  Integer golesFavor;
    @Column(length = 100, name = "goles_contra")
    private  Integer golesContra;
    @Column(length = 100, name = "diferencia_goles")
    private  Integer diferenciaGoles;


    @ManyToOne
    @JoinColumn(name = "id_equipo", referencedColumnName = "id_equipo")
    private Equipo equipo;

    @ManyToOne
    @JoinColumn(name = "id_jornada", referencedColumnName = "id_jornada")
    private Jornada jornada;


}

