package com.ligabtp.ligabetplay.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JugadorDTO {
    private Integer id;
    private String nombre;
    private String posicion;
    private String numero_camisa;
    private String nacionalidad;
    private String piernahabil_jugador;
    private Date fecha_nacimiento;

}
