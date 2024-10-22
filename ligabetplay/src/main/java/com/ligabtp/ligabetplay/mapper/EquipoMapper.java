package com.ligabtp.ligabetplay.mapper;

import com.ligabtp.ligabetplay.domain.Equipo;
import com.ligabtp.ligabetplay.dto.EquipoDTO;

import java.util.List;

public class EquipoMapper {

    public static Equipo dtoToDomain(EquipoDTO equipoDTO){

        return Equipo.builder()
                .id(equipoDTO.getId())
                .nombre(equipoDTO.getNombre())
                .ciudad(equipoDTO.getCiudad())
                .estadio(equipoDTO.getEstadio())
                .entrenador(equipoDTO.getEntrenador())
                .build();
    }

    public static EquipoDTO domainToDTO(Equipo equipo) {

        return EquipoDTO.builder()
                .id(equipo.getId())
                .nombre(equipo.getNombre())
                .ciudad(equipo.getCiudad())
                .estadio(equipo.getEstadio())
                .entrenador(equipo.getEntrenador())
                .build();
    }

    public static List<EquipoDTO> domainToDTOList(List<Equipo> equipo) {
        return equipo.stream().map(EquipoMapper::domainToDTO).toList();
    }
}