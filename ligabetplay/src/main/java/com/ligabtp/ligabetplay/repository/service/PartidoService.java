package com.ligabtp.ligabetplay.repository.service;

import com.ligabtp.ligabetplay.dto.PartidoDTO;

public interface PartidoService {
    PartidoDTO guardarNuevaPartido(PartidoDTO partidoDTO) throws Exception;
    PartidoDTO buscarPartidoPorId(Integer id) throws Exception;
    PartidoDTO modificarPartido(PartidoDTO partidoDTO) throws Exception;
}
