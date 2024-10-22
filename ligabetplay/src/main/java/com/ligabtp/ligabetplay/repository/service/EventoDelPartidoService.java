package com.ligabtp.ligabetplay.repository.service;

import com.ligabtp.ligabetplay.dto.EventoDelPartidoDTO;


import java.util.List;

public interface EventoDelPartidoService {
    EventoDelPartidoDTO buscarEventoDelPartidoPorId(Integer id) throws Exception;

    EventoDelPartidoDTO guardarNuevoEventoDelPartido(EventoDelPartidoDTO eventoDelPartidoDTO) throws Exception;

    List<EventoDelPartidoDTO> obtenerEventoDelPartido();

    EventoDelPartidoDTO modificarEventoDelPartido(EventoDelPartidoDTO eventoDelPartidoDTO) throws Exception;

    EventoDelPartidoDTO buscarEventoDelPartidoPorNombre(String nombre) throws Exception;


}