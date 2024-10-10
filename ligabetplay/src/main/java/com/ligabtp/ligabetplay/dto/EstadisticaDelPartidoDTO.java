package com.ligabtp.ligabetplay.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EstadisticaDelPartidoDTO {
    private Integer id;
    private Float posesion;
    private Integer tirosAPuerta;
    private Integer tirosFuera;
    private Integer faltas;
    private Integer corners;
    private Integer tarjetasAmarillas;
    private Integer tarjetasRojas;
    private Integer tiroEsquinaResultado;
    private Integer remateArcoResultado;
    private Integer partidoId;
    private Integer equipoId;

}