package com.ligabtp.ligabetplay.service;


import com.ligabtp.ligabetplay.dto.EstadisticaDelPartidoDTO;

import java.util.List;

public interface EstadisticaDelPartidoService {
    EstadisticaDelPartidoDTO guardarNuevaEstadisticaDelPartido(EstadisticaDelPartidoDTO estadisticaDelPartidoDTO) throws Exception;

    EstadisticaDelPartidoDTO buscarEstadisticaDelPartidoPorId(Integer id) throws Exception;

    EstadisticaDelPartidoDTO modificarNuevaEstadisticaDelPartido(EstadisticaDelPartidoDTO estadisticaDelPartidoDTO) throws Exception;

    List<EstadisticaDelPartidoDTO> obtenerEstadisticadelPartidos();

    void eliminarEstadisticaDelPartido(Integer id) throws Exception;



}
