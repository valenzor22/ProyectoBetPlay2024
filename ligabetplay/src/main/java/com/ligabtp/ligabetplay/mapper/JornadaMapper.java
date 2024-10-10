package com.ligabtp.ligabetplay.mapper;

import com.ligabtp.ligabetplay.domain.Jornada;
import com.ligabtp.ligabetplay.dto.JornadaDTO;

import java.util.List;

public class JornadaMapper {

    public static Jornada dtoToDomain(JornadaDTO jornadaDTO){

        return Jornada.builder()
                .id(jornadaDTO.getId())
                .numero(jornadaDTO.getNumero())
                .fechaInicio(jornadaDTO.getFechaInicio())
                .fechaFin(jornadaDTO.getFechaFin())
                .build();
    }

    public static JornadaDTO domainToDTO(Jornada jornada) {

        return JornadaDTO.builder()
                .id(jornada.getId())
                .numero(jornada.getNumero())
                .fechaInicio(jornada.getFechaInicio())
                .fechaFin(jornada.getFechaFin())
                .build();
    }

    public static List<JornadaDTO> domainToDTOList(List<Jornada> jornada) {
        return jornada.stream().map(JornadaMapper::domainToDTO).toList();
    }
}