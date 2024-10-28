package com.ligabtp.ligabetplay.repository.service;

import com.ligabtp.ligabetplay.dto.TipoEventoDTO;


import java.util.List;

public interface TipoEventoService {
    TipoEventoDTO guardarNuevoTipoEvento(TipoEventoDTO tipoEventoDTO) throws Exception;

    TipoEventoDTO buscarTipoEventoPorId(Integer id) throws Exception;

    TipoEventoDTO modificarTipoEvento(TipoEventoDTO tipoEventoDTO) throws Exception;

    List<TipoEventoDTO> obtenerTipoEventos();

   void eliminarTipoEvento(Integer id) throws Exception;


}