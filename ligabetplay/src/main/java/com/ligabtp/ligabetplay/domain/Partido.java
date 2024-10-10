package com.ligabtp.ligabetplay.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "partidos")
public class Partido {

    @Id
    @Column(nullable = false, name = "id_partido")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100)
    private LocalTime fecha;
    @Column(length = 100)
    private String estadio;
    @Column(length = 100)
    private Integer goles_local;
    @Column(length = 100)
    private Integer goles_visitante;


    @ManyToOne
    @JoinColumn(name = "id_jornada", referencedColumnName = "id_jornada", nullable = false)
    private Jornada jornada;

    @ManyToOne
    @JoinColumn(name = "equipo_local", referencedColumnName = "id_equipo", nullable = false)
    private Equipo equipoLocal;

    @ManyToOne
    @JoinColumn(name = "equipo_visitante", referencedColumnName = "id_equipo", nullable = false)
    private Equipo equipoVisitante;
}

