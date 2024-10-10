package com.ligabtp.ligabetplay.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EquipoDTO {
    private Integer id;
    private String nombre;
    private String ciudad;
    private String estadio;
    private String entrenador;
}
