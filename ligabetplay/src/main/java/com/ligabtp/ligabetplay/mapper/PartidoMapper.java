package com.ligabtp.ligabetplay.mapper;

import com.ligabtp.ligabetplay.domain.Partido;
import com.ligabtp.ligabetplay.dto.PartidoDTO;

import java.util.List;

public class PartidoMapper {

    public static Partido dtoToDomain(PartidoDTO partidoDTO){

        return Partido.builder()
                .id(partidoDTO.getId())
                .fecha(partidoDTO.getFecha())
                .estadio(partidoDTO.getEstadio())
                .equipo_local(partidoDTO.getEquipolocal())
                .equipo_visitante(partidoDTO.getEquipovisitante())
                .goles_local(partidoDTO.getGoleslocal())
                .goles_visitante(partidoDTO.getGolesvisitante())
                .build();
    }

    public static PartidoDTO domainToDTO(Partido partido) {

        return PartidoDTO.builder()
                .id(partido.getId())
                .fecha(partido.getFecha())
                .estadio(partido.getEstadio())
                .equipolocal(partido.getEquipo_local())
                .equipovisitante(partido.getEquipo_visitante())
                .goleslocal(partido.getGoles_local())
                .golesvisitante(partido.getGoles_visitante())
                .build();
    }

    public static List<PartidoDTO> domainToDTOList(List<Partido> partido) {
        return partido.stream().map(PartidoMapper::domainToDTO).toList();
    }
}