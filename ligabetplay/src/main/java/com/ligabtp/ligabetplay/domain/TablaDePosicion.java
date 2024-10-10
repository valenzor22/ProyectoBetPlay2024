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
    @Column(length = 100)
    private  Integer partidosjugados;
    @Column(length = 100)
    private  Integer ganados;
    @Column(length = 100)
    private  Integer empatados;
    @Column(length = 100)
    private  Integer perdidos;
    @Column(length = 100)
    private  Integer golesfavor;
    @Column(length = 100)
    private  Integer golescontra;
    @Column(length = 100)
    private  Integer diferenciagoles;


    @ManyToOne
    @JoinColumn(name = "id_equipo", referencedColumnName = "id_equipo", nullable = false)
    private Equipo equipo;

    @ManyToOne
    @JoinColumn(name = "id_jornada", referencedColumnName = "id_jornada", nullable = false)
    private Jornada jornada;


}

