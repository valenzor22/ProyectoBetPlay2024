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
@Table(name = "asignacionesjugadoresequipos")
public class AsignacionJugadorEquipo {

    @Id
    @Column(nullable = false, name = "id_asignacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100, name = "fecha_inicio", nullable = false)
    private Date fechaInicio;
    @Column(length = 100, name = "fecha_fin")
    private Date fechaFin;


    @ManyToOne
    @JoinColumn(name = "id_jugador", referencedColumnName = "id_jugador", nullable = false)
    private Jugador jugador;

    @ManyToOne
    @JoinColumn(name = "id_equipo", referencedColumnName = "id_equipo", nullable = false)
    private Equipo equipo;


}
