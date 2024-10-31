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
@Table(name = "partidos_y_arbitros")
public class PartidoyArbitro {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, name = "tipo_arbitro", nullable = false)
    private String tipoArbitro;


    @ManyToOne
    @JoinColumn(name = "id_partido", referencedColumnName = "id_partido")
    private Partido partido;

    @ManyToOne
    @JoinColumn(name = "id_arbitro", referencedColumnName = "id_arbitro")
    private Arbitro arbitro;


}

