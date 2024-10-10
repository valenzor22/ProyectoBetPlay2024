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
                .numero_camisa(jugadorDTO.getNumeroCamisa())
                .nacionalidad(jugadorDTO.getNacionalidad())
                .pierna_habil(jugadorDTO.getPiernaHabil())
                .build();
    }

    public static JugadorDTO domainToDTO(Jugador jugador) {

        return Jugador.builder()
                .id(jugador.getId())
                .nombre(jugador.getNombre())
                .posicion(jugador.getPosicion())
                .numero_camisa(jugador.getNumeroCamisa())
                .nacionalidad(jugador.getNacionalidad())
                .pierna_habil(jugador.getPiernaHabil())
                .build();
    }

    public static List<JugadorDTO> domainToDTOList(List<Jugador> jugador) {
        return jugador.stream().map(JugadorMapper::domainToDTO).toList();
    }
}