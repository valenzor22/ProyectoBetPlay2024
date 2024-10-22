package com.ligabtp.ligabetplay.repository.service;

import com.ligabtp.ligabetplay.dto.TipoEventoDTO;


import java.util.List;

public interface TipoEventoService {
    TipoEventoDTO buscarTipoEventoPorId(Integer id) throws Exception;

    TipoEventoDTO guardarNuevoTipoEvento(TipoEventoDTO tipoEventoDTO) throws Exception;

    List<TipoEventoDTO> obtenerTipoEventos();

    TipoEventoDTO modificarTipoEvento(TipoEventoDTO tipoEventoDTO) throws Exception;

    TipoEventoDTO buscarTipoEventoPorNombre(String nombre) throws Exception;


}