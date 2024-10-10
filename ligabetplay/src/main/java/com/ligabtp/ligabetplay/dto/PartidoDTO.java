package com.ligabtp.ligabetplay.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PartidoDTO {
    private Integer id;
    private LocalTime fecha;
    private String estadio;
    private Integer golesLocal;
    private Integer golesVisitante;
    private Integer jornada;
    private Integer equipolocalId;
    private Integer equipovisitanteId;

}
