
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
@Table(name = "estadisticasdelpartidos")
public class EstadisticadelPartido {

    @Id
    @Column(nullable = false, name = "id_estadistica")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @Column(length = 100)
    private  Float posesion;
    @Column(length = 100)
    private  Integer tirosapuerta;
    @Column(length = 100)
    private  Integer tirosfuera;
    @Column(length = 100)
    private  Integer faltas;
    @Column(length = 100)
    private  Integer corners;
    @Column(length = 100)
    private  Integer tarjetasamarillas;
    @Column(length = 100)
    private  Integer tarjetasrojas;
    @Column(length = 100)
    private  Integer tiroesquinaresultado;
    @Column(length = 100)
    private  Integer rematearcoresultado;




    @ManyToOne
    @JoinColumn(name = "id_partido",referencedColumnName = "id_partido", nullable = false)
    private Partido partido;
    @ManyToOne
    @JoinColumn(name = "id_equipo", referencedColumnName = "id_equipo", nullable = false)
    private Equipo equipo;


}

