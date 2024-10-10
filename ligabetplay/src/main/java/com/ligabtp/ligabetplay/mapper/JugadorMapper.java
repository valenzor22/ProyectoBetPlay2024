package com.ligabtp.ligabetplay.mapper;

import com.ligabtp.ligabetplay.domain.Jugador;
import com.ligabtp.ligabetplay.dto.JugadorDTO;

import java.util.List;

public class JugadorMapper {

    public static Jugador dtoToDomain(JugadorDTO jugadorDTO){

        return Jugador.builder()
                .id(jugadorDTO.getId())
                .nombre(jugadorDTO.getNombre())
                .posicion(jugadorDTO.getPosicion())
                .numeroCamisa(jugadorDTO.getNumeroCamisa())
                .nacionalidad(jugadorDTO.getNacionalidad())
                .piernaHabilJugador(jugadorDTO.getPiernaHabilJugador())
                .build();
    }

    public static JugadorDTO domainToDTO(Jugador jugador) {

        return JugadorDTO.builder()
                .id(jugador.getId())
                .nombre(jugador.getNombre())
                .posicion(jugador.getPosicion())
                .numeroCamisa(jugador.getNumeroCamisa())
                .nacionalidad(jugador.getNacionalidad())
                .piernaHabilJugador(jugador.getPiernaHabilJugador())
                .build();
    }

    public static List<JugadorDTO> domainToDTOList(List<Jugador> jugador) {
        return jugador.stream().map(JugadorMapper::domainToDTO).toList();
    }
}