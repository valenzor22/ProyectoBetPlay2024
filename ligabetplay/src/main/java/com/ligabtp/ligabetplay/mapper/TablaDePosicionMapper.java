package com.ligabtp.ligabetplay.mapper;


import com.ligabtp.ligabetplay.domain.TablaDePosicion;
import com.ligabtp.ligabetplay.dto.TabladePosicionDTO;


import java.util.List;

public class TablaDePosicionMapper {

    public static TablaDePosicion dtoToDomain(TabladePosicionDTO tabladePosicionesDTO){

        return TablaDePosicion.builder()
                .id(tabladePosicionesDTO.getId())
                .puntos(tabladePosicionesDTO.getPuntos())
                .partidosJugados(tabladePosicionesDTO.getPartidosJugados())
                .ganados(tabladePosicionesDTO.getGanados())
                .empatados(tabladePosicionesDTO.getEmpatados())
                .perdidos(tabladePosicionesDTO.getPerdidos())
                .golesFavor(tabladePosicionesDTO.getGolesFavor())
                .golesContra(tabladePosicionesDTO.getGolesContra())
                .diferenciaGoles(tabladePosicionesDTO.getDiferenciaGoles())
                .build();
    }

    public static TabladePosicionDTO domainToDto (TablaDePosicion tabladePosiciones){

        return  TabladePosicionDTO.builder()
                .id(tabladePosiciones.getId())
                .puntos(tabladePosiciones.getPuntos())
                .partidosJugados(tabladePosiciones.getPartidosJugados())
                .ganados(tabladePosiciones.getGanados())
                .empatados(tabladePosiciones.getEmpatados())
                .perdidos(tabladePosiciones.getPerdidos())
                .golesFavor(tabladePosiciones.getGolesFavor())
                .golesContra(tabladePosiciones.getGolesContra())
                .diferenciaGoles(tabladePosiciones.getDiferenciaGoles())
                .jornadaId((tabladePosiciones.getJornada() != null) ? tabladePosiciones.getJornada().getId() : null)
                .equipoId((tabladePosiciones.getEquipo() != null) ? tabladePosiciones.getEquipo().getId() : null)
                .build();
    }

    public static List<TablaDePosicion> dtoToDomainList(List<TabladePosicionDTO> tabladePosicionesDTO) {
        return tabladePosicionesDTO.stream().map(TablaDePosicionMapper::dtoToDomain).toList();
    }
    public static List<TabladePosicionDTO> domainToDTOList(List<TablaDePosicion> tabladePosiciones) {
        return tabladePosiciones.stream().map(TablaDePosicionMapper::domainToDto).toList();
    }
}