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
@Table(name = "jornadas")
public class Jornada {

    @Id
    @Column(nullable = false, name = "id_jornada")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @Column(length = 100)
    private Integer numero;
    @Column(length = 100)
    private Date fecha_inicio;
    @Column(length = 100)
    private Date fecha_fin;
}

