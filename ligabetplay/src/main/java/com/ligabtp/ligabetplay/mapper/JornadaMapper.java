package com.ligabtp.ligabetplay.mapper;

import com.ligabtp.ligabetplay.domain.Jornada;
import com.ligabtp.ligabetplay.dto.JornadaDTO;

import java.util.List;

public class JornadaMapper {

    public static Jornada dtoToDomain(JornadaDTO jornadaDTO){

        return Jornada.builder()
                .id(jornadaDTO.getId())
                .numero(jornadaDTO.getNumero())
                .fecha_inicio(jornadaDTO.getFechaInicio())
                .fecha_fin(jornadaDTO.getTirosFechaFin())
                .build();
    }

    public static JornadaDTO domainToDTO(Jornada jornada) {

        return Jornada.builder()
                .id(jornadaDTO.getId())
                .numero(jornadaDTO.getNumero())
                .fecha_inicio(jornadaDTO.getFechaInicio())
                .fecha_fin(jornadaDTO.getTirosFechaFin())
                .build();
    }

    public static List<JornadaDTO> domainToDTOList(List<Jornada> jornada) {
        return jornada.stream().map(JornadaMapper::domainToDTO).toList();
    }
}