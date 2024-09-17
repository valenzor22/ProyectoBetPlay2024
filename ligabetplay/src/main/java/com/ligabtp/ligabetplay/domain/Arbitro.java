package com.ligabtp.ligabetplay.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.mapping.Set;

import java.util.ArrayList;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "arbitros")
public class Arbitro {

    @Id
    @Column(name = "id_arbitro" , nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @Column(name = "nombre_arbitro" , length = 100)
    private  String nombreArbitro;

    @Column(length = 100)
    private  String paisnacimiento_arbitro;




}




