package com.ligabtp.ligabetplay.service;

import com.ligabtp.ligabetplay.dto.TablaDePosicionDTO;

import java.util.List;

public interface TablaDePosicionService {
    TablaDePosicionDTO guardarNuevaTablaDePosicion(TablaDePosicionDTO tablaDePosicionesDTO) throws Exception;

    TablaDePosicionDTO buscarTablaDePosicionPorId(Integer id) throws Exception;

    TablaDePosicionDTO modificarTablaDePosicion(TablaDePosicionDTO tablaDePosicionDTO) throws Exception;

    List<TablaDePosicionDTO> obtenerTablaDePosiciones();

    void eliminarTablaDePosicion(Integer id) throws Exception;
}
