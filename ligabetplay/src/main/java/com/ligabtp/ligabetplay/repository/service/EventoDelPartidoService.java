package com.ligabtp.ligabetplay.repository.service;

import com.ligabtp.ligabetplay.dto.EventoDelPartidoDTO;


import java.util.List;

public interface EventoDelPartidoService {
    EventoDelPartidoDTO guardarNuevoEventoDelPartido(EventoDelPartidoDTO eventoDelPartidoDTO) throws Exception;

    EventoDelPartidoDTO buscarEventoDelPartidoPorId(Integer id) throws Exception;

    EventoDelPartidoDTO modificarEventoDelPartido(EventoDelPartidoDTO eventoDelPartidoDTO) throws Exception;

    List<EventoDelPartidoDTO> obtenerEventoDelPartidos();

    void eliminarEventoDelPartido(Integer id) throws Exception;

}