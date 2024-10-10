package com.ligabtp.ligabetplay.mapper;


import com.ligabtp.ligabetplay.domain.EstadisticaDelPartido;
import com.ligabtp.ligabetplay.dto.EstadisticaDelPartidoDTO;

import java.util.List;

public class EstadisticaDelPartidoMapper {

    public static EstadisticaDelPartido dtoToDomain(EstadisticaDelPartidoDTO estadisticasDelPartidoDTO){

        return EstadisticaDelPartido.builder()
                .id(estadisticasDelPartidoDTO.getId())
                .posesion(estadisticasDelPartidoDTO.getPosesion())
                .tirosAPuerta(estadisticasDelPartidoDTO.getTirosAPuerta())
                .tirosFuera(estadisticasDelPartidoDTO.getTirosFuera())
                .faltas(estadisticasDelPartidoDTO.getFaltas())
                .corners(estadisticasDelPartidoDTO.getCorners())
                .tarjetasAmarillas(estadisticasDelPartidoDTO.getTarjetasAmarillas())
                .tarjetasRojas(estadisticasDelPartidoDTO.getTarjetasRojas())
                .tiroEsquinaResultado(estadisticasDelPartidoDTO.getTiroEsquinaResultado())
                .remateArcoResultado(estadisticasDelPartidoDTO.getRemateArcoResultado())
                .build();
    }

    public static EstadisticaDelPartidoDTO domainToDto (EstadisticaDelPartido estadisticaDelPartido){

        return  EstadisticaDelPartidoDTO.builder()
                .id(estadisticaDelPartido.getId())
                .posesion(estadisticaDelPartido.getPosesion())
                .tirosAPuerta(estadisticaDelPartido.getTirosAPuerta())
                .tirosFuera(estadisticaDelPartido.getTirosFuera())
                .faltas(estadisticaDelPartido.getFaltas())
                .corners(estadisticaDelPartido.getCorners())
                .tarjetasAmarillas(estadisticaDelPartido.getTarjetasAmarillas())
                .tarjetasRojas(estadisticaDelPartido.getTarjetasRojas())
                .tiroEsquinaResultado(estadisticaDelPartido.getTiroEsquinaResultado())
                .remateArcoResultado(estadisticaDelPartido.getRemateArcoResultado())
                .partidoId((estadisticaDelPartido.getPartido() != null) ? estadisticaDelPartido.getEquipo().getId() : null)
                .equipoId((estadisticaDelPartido.getEquipo() != null) ? estadisticaDelPartido.getEquipo().getId() : null)
                .build();
    }

    public static List<EstadisticaDelPartido> dtoToDomainList(List<EstadisticaDelPartidoDTO> estadisticaDelPartidoDTO) {
        return estadisticaDelPartidoDTO.stream().map(EstadisticaDelPartidoMapper::dtoToDomain).toList();
    }
    public static List<EstadisticaDelPartidoDTO> domainToDTOList(List<EstadisticaDelPartido> estadisticaDelPartido) {
        return estadisticaDelPartido.stream().map(EstadisticaDelPartidoMapper::domainToDto).toList();
    }
}