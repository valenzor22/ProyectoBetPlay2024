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
@Table(name = "resultados")
public class Resultado {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;


    @Column(length = 100)
    private String goles_resultado;

    @Column(length = 100)
    private String tarjetasrojas_resultado;

    @Column(length = 100)
    private String tarjetasamarillas_resultado;

    @Column(length = 100)
    private Double posesionbalon_resultado;

    @Column(length = 100)
    private String tiroesquina_resultado;

    @Column(length = 100)
    private String rematearco_resultado;

    @Column(length = 100)
    private Double precisionremates_resultado;


}
