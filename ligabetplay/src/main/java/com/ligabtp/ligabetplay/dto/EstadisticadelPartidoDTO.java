package com.ligabtp.ligabetplay.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EstadisticadelPartidoDTO {
    private Integer id;
    private Float posicion;
    private Integer tiros_a_puerta;
    private Integer tiros_fuera;
    private Integer faltas;
    private Integer corners;
    private Integer tarjetas_amarillas;
    private Integer tarjetas_rojas;
    private Integer tiroesquina_resultado;
    private Integer rematearco_resultado;

}