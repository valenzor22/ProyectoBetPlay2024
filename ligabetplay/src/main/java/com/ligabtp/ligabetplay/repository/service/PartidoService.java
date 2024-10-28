package com.ligabtp.ligabetplay.repository.service;

import com.ligabtp.ligabetplay.dto.PartidoDTO;

import java.util.List;

public interface PartidoService {
    PartidoDTO guardarNuevoPartido(PartidoDTO partidoDTO) throws Exception;

    PartidoDTO buscarPartidoPorId(Integer id) throws Exception;

    PartidoDTO modificarPartido(PartidoDTO partidoDTO) throws Exception;

    List<PartidoDTO> obtenerPartidos();

    void eliminarPartido(Integer id) throws Exception;
}
