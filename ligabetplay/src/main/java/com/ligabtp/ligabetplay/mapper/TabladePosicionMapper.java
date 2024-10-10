package com.ligabtp.ligabetplay.mapper;


import com.ligabtp.ligabetplay.domain.TabladePosicion;
import com.ligabtp.ligabetplay.dto.TabladePosicionDTO;


import java.util.List;

public class TabladePosicionesMapper {

    public static TabladePosicion dtoToDomain(TabladePosicionDTO tabladePosicionesDTO){

        return TabladePosicion.builder()
                .id(tabladePosicionesDTO.getId())
                .puntos(tabladePosicionesDTO.getPuntos())
                .partidos_jugados(tabladePosicionesDTO.getPartidos_jugados())
                .ganados(tabladePosicionesDTO.getGanados())
                .empatados(tabladePosicionesDTO.getEmpatados())
                .perdidos(tabladePosicionesDTO.getPerdidos())
                .goles_favor(tabladePosicionesDTO.getGoles_favor())
                .goles_contra(tabladePosicionesDTO.getGoles_contra())
                .diferencia_goles(tabladePosicionesDTO.getDiferencia_goles())
                .build();
    }

    public static TabladePosicionDTO domainToDto (TabladePosicion tabladePosiciones){

        return  TabladePosicionDTO.builder()
                .id(tabladePosicionDTO.getId())
                .puntos(tabladePosicionDTO.getPuntos())
                .partidos_jugados(tabladePosicionDTO.getPartidos_jugados())
                .ganados(tabladePosicionDTO.getGanados())
                .empatados(tabladePosicionDTO.getEmpatados())
                .perdidos(tabladePosicionDTO.getPerdidos())
                .goles_favor(tabladePosicionDTO.getGoles_favor())
                .goles_contra(tabladePosicionDTO.getGoles_contra())
                .diferencia_goles(tabladePosicionDTO.getDiferencia_goles())
                .jornadaId((tabladePosiciones.getEquipo() != null) ? tabladePosiciones.getJornada().getId() : null)
                .equipoId((tabladePosiciones.getEquipo() != null) ? tabladePosiciones.getEquipo().getId() : null)
                .build();
    }

    public static List<TabladePosicion> dtoToDomainList(List<TabladePosicionDTO> tabladePosicionesDTO) {
        return tabladePosicionesDTO.stream().map(TabladePosicionesMapper::dtoToDomain).toList();
    }
    public static List<TabladePosicionDTO> domainToDTOList(List<TabladePosicion> tabladePosiciones) {
        return tabladePosiciones.stream().map(TabladePosicionesMapper::domainToDto).toList();
    }
}