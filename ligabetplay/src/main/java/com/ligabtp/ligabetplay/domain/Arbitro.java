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
@Table(name = "arbitros")
public class Arbitro {

    @Id
    @Column(nullable = false, name = "id_arbitro")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @Column(length = 100, name = "nombre")
    private String nombre;
    @Column(length = 100)
    private String apellido;
    @Column(length = 100)
    private String nacionalidad;
    @Column(length = 100)
    private Date fecha_nacimiento;
}





