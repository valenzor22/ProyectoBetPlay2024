
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
public class EstadisticaDelPartido {

    @Id
    @Column(nullable = false, name = "id_estadistica")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @Column(length = 100)
    private  Float posesion;
    @Column(length = 100, name = "tiros_a_puerta")
    private  Integer tirosAPuerta;
    @Column(length = 100, name = "tiros_fuera")
    private  Integer tirosFuera;
    @Column(length = 100)
    private  Integer faltas;
    @Column(length = 100)
    private  Integer corners;
    @Column(length = 100, name = "tarjetas_amarillas")
    private  Integer tarjetasAmarillas;
    @Column(length = 100, name = "tarjetas_rojas")
    private  Integer tarjetasRojas;
    @Column(length = 100, name = "tiroesquina_resultado")
    private  Integer tiroEsquinaResultado;
    @Column(length = 100, name = "rematearco_resultado")
    private  Integer remateArcoResultado;




    @ManyToOne
    @JoinColumn(name = "id_partido",referencedColumnName = "id_partido")
    private Partido partido;
    @ManyToOne
    @JoinColumn(name = "id_equipo", referencedColumnName = "id_equipo")
    private Equipo equipo;


}

