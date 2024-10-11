package com.ligabtp.ligabetplay.repository.service;

import com.ligabtp.ligabetplay.domain.EventoDelPartido;
import com.ligabtp.ligabetplay.dto.EventoDelPartidoDTO;

public interface EventoDelPartidoService {
    EventoDelPartidoDTO guardarNuevaEventoDePartido(EventoDelPartido eventoDePartidoDTO) throws Exception;
}
