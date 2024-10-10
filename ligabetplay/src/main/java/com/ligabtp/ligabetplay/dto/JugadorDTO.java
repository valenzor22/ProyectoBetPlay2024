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
    private Integer numeroCamisa;
    private String nacionalidad;
    private String piernaHabilJugador;
    private Date fechaNacimiento;

}
