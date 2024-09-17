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
@Table(name = "estadisticas")
public class Estadistica {


    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(length = 100)
    private String goles_estadistica;

    @Column(length = 100)
    private String amarillas_estadistica;

    @Column(length = 100)
    private String rojas_estadistica;



}
