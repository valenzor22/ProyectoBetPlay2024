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
    private Integer equipolocalId;
    private Integer equipovisitanteId;
    private Integer goleslocal;
    private Integer golesvisitante;
    private Integer jornada;

}
