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
                .golesLocal(partidoDTO.getGolesLocal())
                .golesVisitante(partidoDTO.getGolesVisitante())
                .build();
    }

    public static PartidoDTO domainToDTO(Partido partido) {

        return PartidoDTO.builder()
                .id(partido.getId())
                .fecha(partido.getFecha())
                .estadio(partido.getEstadio())
                .golesLocal(partido.getGolesLocal())
                .golesVisitante(partido.getGolesVisitante())
                .equipolocalId((partido.getEquipoLocal() != null) ? partido.getEquipoLocal().getId() : null)
                .equipovisitanteId((partido.getEquipoVisitante() != null) ? partido.getEquipoVisitante().getId() : null)
                .build();
    }

    public static List<PartidoDTO> domainToDTOList(List<Partido> partido) {
        return partido.stream().map(PartidoMapper::domainToDTO).toList();
    }
}