package com.ligabtp.ligabetplay.repository.service;

import com.ligabtp.ligabetplay.domain.EventoDelPartido;
import com.ligabtp.ligabetplay.dto.EventoDelPartidoDTO;

public interface EventoDelPartidoService {
    EventoDelPartidoDTO guardarNuevaEventoDelPartido(EventoDelPartido eventoDePartidoDTO) throws Exception;
    EventoDelPartidoDTO buscarEventoDelPartidoPorId(Integer id) throws Exception;
    EventoDelPartidoDTO modificarEventoDelPartido(EventoDelPartido eventoDePartidoDTO) throws Exception;
}
