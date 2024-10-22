package com.ligabtp.ligabetplay.mapper;


import com.ligabtp.ligabetplay.domain.EventoDelPartido;
import com.ligabtp.ligabetplay.dto.EventoDelPartidoDTO;

import java.util.List;

public class EventoDelPartidoMapper {

    public static EventoDelPartido dtoToDomain(EventoDelPartidoDTO eventoDelPartidoDTO){

        return EventoDelPartido.builder()
                .id(eventoDelPartidoDTO.getId())
                .minuto(eventoDelPartidoDTO.getMinuto())
                .build();
    }

    public static EventoDelPartidoDTO domainToDto (EventoDelPartido eventoDelPartido){

        return  EventoDelPartidoDTO.builder()
                .id(eventoDelPartido.getId())
                .partidoId((eventoDelPartido.getPartido() != null) ? eventoDelPartido.getPartido().getId() : null)
                .jugadorId((eventoDelPartido.getJugador() != null) ? eventoDelPartido.getJugador().getId() : null)
                .build();
    }


    public static List<EventoDelPartidoDTO> domainToDTOList(List<EventoDelPartido> eventoDelPartido) {
        return eventoDelPartido.stream().map(EventoDelPartidoMapper::domainToDto).toList();
    }
}