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

    @Column(length = 100)
    private Date fecha_inicio;
    @Column(length = 100)
    private Date fecha_fin;


        @ManyToOne
        @JoinColumn(name = "id_jugador", referencedColumnName = "id_jugador", nullable = false)
        private Jugador jugador;

        @ManyToOne
        @JoinColumn(name = "id_equipo", referencedColumnName = "id_equipo", nullable = false)
        private Equipo equipo;


}
