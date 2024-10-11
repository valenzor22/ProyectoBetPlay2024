package com.ligabtp.ligabetplay.repository.service;


import com.ligabtp.ligabetplay.dto.EstadisticaDelPartidoDTO;

public interface EstadisticaDelPartidoService {
    EstadisticaDelPartidoDTO guardarNuevaEstadisticaDelPartido(EstadisticaDelPartidoDTO estadisticaDelPartidoDTO) throws Exception;
    EstadisticaDelPartidoDTO buscarEstadisticaDelPartidoPorId(Integer id) throws Exception;
    EstadisticaDelPartidoDTO modificarNuevaEstadisticaDelPartido(EstadisticaDelPartidoDTO estadisticaDelPartidoDTO) throws Exception;

}
