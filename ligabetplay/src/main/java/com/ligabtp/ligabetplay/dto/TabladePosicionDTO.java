package com.ligabtp.ligabetplay.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TabladePosicionDTO {
    private Integer id;
    private Integer puntos;
    private Integer partidos_jugados;
    private Integer ganados;
    private Integer empatados;
    private Integer perdidos;
    private Integer goles_favor;
    private Integer goles_contral;
    private Integer diferencia_goles;
}
