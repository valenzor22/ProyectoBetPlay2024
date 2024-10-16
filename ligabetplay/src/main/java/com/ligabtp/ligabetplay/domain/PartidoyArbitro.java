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
@Table(name = "partidosyarbitros")
public class PartidoyArbitro {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100, name = "tipo_arbitro")
    private String tipoArbitro;


    @ManyToOne
    @JoinColumn(name = "id_partido", referencedColumnName = "id_partido", nullable = false)
    private Partido partido;

    @ManyToOne
    @JoinColumn(name = "id_arbitro", referencedColumnName = "id_arbitro", nullable = false)
    private Arbitro arbitro;


}

