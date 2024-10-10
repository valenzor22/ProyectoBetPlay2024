package com.ligabtp.ligabetplay.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventoDelPartidoDTO {
    private Integer id;
    private Integer minuto;
    private Integer partidoId;
    private Integer jugadorId;
}
