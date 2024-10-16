package com.ligabtp.ligabetplay.mapper;


import com.ligabtp.ligabetplay.domain.TablaDePosicion;
import com.ligabtp.ligabetplay.dto.TablaDePosicionDTO;


import java.util.List;

public class TablaDePosicionMapper {

    public static TablaDePosicion dtoToDomain(TablaDePosicionDTO tablaDePosicionesDTO){

        return TablaDePosicion.builder()
                .id(tablaDePosicionesDTO.getId())
                .puntos(tablaDePosicionesDTO.getPuntos())
                .partidosJugados(tablaDePosicionesDTO.getPartidosJugados())
                .ganados(tablaDePosicionesDTO.getGanados())
                .empatados(tablaDePosicionesDTO.getEmpatados())
                .perdidos(tablaDePosicionesDTO.getPerdidos())
                .golesFavor(tablaDePosicionesDTO.getGolesFavor())
                .golesContra(tablaDePosicionesDTO.getGolesContra())
                .diferenciaGoles(tablaDePosicionesDTO.getDiferenciaGoles())
                .build();
    }

    public static TablaDePosicionDTO domainToDto (TablaDePosicion tablaDePosiciones){

        return  TablaDePosicionDTO.builder()
                .id(tablaDePosiciones.getId())
                .puntos(tablaDePosiciones.getPuntos())
                .partidosJugados(tablaDePosiciones.getPartidosJugados())
                .ganados(tablaDePosiciones.getGanados())
                .empatados(tablaDePosiciones.getEmpatados())
                .perdidos(tablaDePosiciones.getPerdidos())
                .golesFavor(tablaDePosiciones.getGolesFavor())
                .golesContra(tablaDePosiciones.getGolesContra())
                .diferenciaGoles(tablaDePosiciones.getDiferenciaGoles())
                .jornadaId((tablaDePosiciones.getJornada() != null) ? tablaDePosiciones.getJornada().getId() : null)
                .equipoId((tablaDePosiciones.getEquipo() != null) ? tablaDePosiciones.getEquipo().getId() : null)
                .build();
    }

    public static List<TablaDePosicion> dtoToDomainList(List<TablaDePosicionDTO> tablaDePosicionesDTO) {
        return tablaDePosicionesDTO.stream().map(TablaDePosicionMapper::dtoToDomain).toList();
    }
    public static List<TablaDePosicionDTO> domainToDTOList(List<TablaDePosicion> tablaDePosiciones) {
        return tablaDePosiciones.stream().map(TablaDePosicionMapper::domainToDto).toList();
    }
}