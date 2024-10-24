package com.ligabtp.ligabetplay.mapper;


import com.ligabtp.ligabetplay.domain.AsignacionJugadorEquipo;
import com.ligabtp.ligabetplay.dto.AsignacionJugadorEquipoDTO;

import java.util.List;

public class AsignacionJugadorEquipoMapper {

    public static AsignacionJugadorEquipo dtoToDomain(AsignacionJugadorEquipoDTO asignacionJugadorEquipoDTO){

        return AsignacionJugadorEquipo.builder()
                .id(asignacionJugadorEquipoDTO.getId())
                .fechaInicio(asignacionJugadorEquipoDTO.getFechaInicio())
                .fechaFin(asignacionJugadorEquipoDTO.getFechaFin())
                .build();
    }

    public static AsignacionJugadorEquipoDTO domainToDto (AsignacionJugadorEquipo asignacionJugadorEquipo){

        return  AsignacionJugadorEquipoDTO.builder()
                .id(asignacionJugadorEquipo.getId())
                .fechaInicio(asignacionJugadorEquipo.getFechaInicio())
                .fechaFin(asignacionJugadorEquipo.getFechaFin())
                .equipoId((asignacionJugadorEquipo.getEquipo() != null) ? asignacionJugadorEquipo.getEquipo().getId() : null)
                .jugadorId((asignacionJugadorEquipo.getEquipo() != null) ? asignacionJugadorEquipo.getJugador().getId() : null)
                .build();
    }

    public static List<AsignacionJugadorEquipo> dtoToDomainList(List<AsignacionJugadorEquipoDTO> asignacionJugadorEquiposDTO) {
        return asignacionJugadorEquiposDTO.stream().map(AsignacionJugadorEquipoMapper::dtoToDomain).toList();
    }
    public static List<AsignacionJugadorEquipoDTO> domainToDTOList(List<AsignacionJugadorEquipo> asignacionJugadorEquipos) {
        return asignacionJugadorEquipos.stream().map(AsignacionJugadorEquipoMapper::domainToDto).toList();
    }
}