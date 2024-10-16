package com.ligabtp.ligabetplay.repository.service;

import com.ligabtp.ligabetplay.dto.TablaDePosicionDTO;

public interface TablaDePosicionService {
    TablaDePosicionDTO guardarNuevaTablaDePosiciones(TablaDePosicionDTO tablaDePosicionesDTO) throws Exception;
    TablaDePosicionDTO buscarTablaDePosicionPorId(Integer idTablaDePosicion) throws Exception;
    TablaDePosicionDTO modificarTablaDePosicionPorId(Integer idTablaDePosicion) throws Exception;
}
