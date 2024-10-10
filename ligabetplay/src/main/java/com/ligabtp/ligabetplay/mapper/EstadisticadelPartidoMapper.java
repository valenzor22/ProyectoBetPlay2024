package com.ligabtp.ligabetplay.mapper;


import com.ligabtp.ligabetplay.domain.EstadisticadelPartido;
import com.ligabtp.ligabetplay.dto.EstadisticadelPartidoDTO;

import java.util.List;

public class EstadisticasdelPartidoMapper {

    public static EstadisticadelPartido dtoToDomain(EstadisticadelPartidoDTO estadisticasdelPartidoDTO){

        return EstadisticadelPartido.builder()
                .id(estadisticasdelPartidoDTO.getId())
                .posicion(estadisticasdelPartidoDTO.getPosicion())
                .tiros_a_puerta(estadisticasdelPartidoDTO.getTirosapuerta())
                .tiros_fuera(estadisticasdelPartidoDTO.getTirosfuera())
                .faltas(estadisticasdelPartidoDTO.getFaltas())
                .corners(estadisticasdelPartidoDTO.getCorners())
                .tarjetas_amarilla(estadisticasdelPartidoDTO.getTarjetasamarillas())
                .tarjetas_rojas(estadisticasdelPartidoDTO.getTarjetasrojas())
                .tiroesquina_resultado(estadisticasdelPartidoDTO.getTirosesquina_resultado())
                .rematearco_resultado(estadisticasdelPartidoDTO.getRematearco_resultado())
                .build();
    }

    public static EstadisticadelPartidoDTO domainToDto (EstadisticadelPartido estadisticasdelPartido){

        return  EstadisticadelPartidoDTO.builder()
                .id(estadisticadelPartidoDTO.getId())
                .posicion(estadisticadelPartidoDTO.getPosicion())
                .tiros_a_puerta(estadisticsdelPartidoDTO.getTirosapuerta())
                .tiros_fuera(estadisticsdelPartidoDTO.getTirosfuera())
                .faltas(estadisticadelPartidoDTO.getFaltas())
                .corners(estadisticadelPartidoDTO.getCorners())
                .tarjetas_amarilla(estadisticadelPartidoDTO.getTarjetasamarillas())
                .tarjetas_rojas(estadisticadelPartidoDTO.getTarjetasrojas())
                .tiroesquina_resultado(estadisticadelPartidoDTO.getTirosesquina_resultado())
                .rematearco_resultado(estadisticadelPartidoDTO.getRematearco_resultado())
                .partidoId((estadisticasdelPartido.getPartido() != null) ? estadisticasdelPartido.getEquipo().getId() : null)
                .equipoId((estadisticasdelPartido.getEquipo() != null) ? estadisticasdelPartido.getEquipo().getId() : null)
                .build();
    }

    public static List<EstadisticadelPartido> dtoToDomainList(List<EstadisticadelPartidoDTO> estadisticasdelPartidoDTO) {
        return estadisticasdelPartidoDTO.stream().map(EstadisticasdelPartidoMapper::dtoToDomain).toList();
    }
    public static List<EstadisticadelPartidoDTO> domainToDTOList(List<EstadisticadelPartido> estadisticasdelPartido) {
        return estadisticasdelPartido.stream().map(EstadisticasdelPartidoMapper::domainToDto).toList();
    }
}