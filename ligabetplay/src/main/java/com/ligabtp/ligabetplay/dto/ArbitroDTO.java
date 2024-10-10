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
public class ArbitroDTO {
    private Integer id;
    private String nombre;
    private String apellido;
    private String nacionalidad;
    private Date fecha_nacimiento;
}
