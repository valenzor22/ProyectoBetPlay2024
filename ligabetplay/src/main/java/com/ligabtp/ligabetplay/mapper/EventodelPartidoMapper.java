package com.ligabtp.ligabetplay.mapper;


import com.ligabtp.ligabetplay.domain.EventodelPartido;
import com.ligabtp.ligabetplay.dto.EventodelPartidoDTO;

import java.util.List;

public class EventodelPartidoMapper {

    public static EventodelPartido dtoToDomain(EventodelPartidoDTO eventodelPartidoDTO){

        return EventodelPartido.builder()
                .id(eventodelPartidoDTO.getId())
                .tipo_evento(eventodelPartidoDTO.getTipo_evento())
                .build();
    }

    public static EventodelPartidoDTO domainToDto (EventodelPartido eventodelPartido){

        return  EventodelPartidoDTO.builder()
                .id(eventodelPartidoDTO.getId())
                .tipo_evento(eventodelPartidoDTO.getTipo_evento())
                .partidoId((eventodelPartido.getEquipo() != null) ? eventodelPartido.getPartido().getId() : null)
                .jugadorId((eventodelPartido.getEquipo() != null) ? eventodelPartido.getJugador().getId() : null)
                .build();
    }

    public static List<EventodelPartido> dtoToDomainList(List<EventodelPartidoDTO> eventodelPartidoDTO) {
        return eventodelPartido.stream().map(EventodelPartidoMapper::dtoToDomain).toList();
    }
    public static List<EventodelPartidoDTO> domainToDTOList(List<EventodelPartido> eventodelPartido) {
        return eventodelPartido.stream().map(EventodelPartidoMapper::domainToDto).toList();
    }
}