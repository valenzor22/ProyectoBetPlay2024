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
public class JornadaDTO {
    private Integer id;
    private Integer numero;
    private Date fecha_inicio;
    private Date fecha_fin;

}