package com.ligabtp.ligabetplay.service;

import com.ligabtp.ligabetplay.domain.PartidoyArbitro;
import com.ligabtp.ligabetplay.dto.PartidoyArbitroDTO;

import java.util.List;

public interface PartidoyArbitroService {
    PartidoyArbitroDTO guardarNuevoPartidoyArbitro(PartidoyArbitroDTO partidoyArbitroDTO) throws Exception;

    PartidoyArbitroDTO buscarPartidoyArbitroPorId(Integer id) throws Exception;

    PartidoyArbitroDTO modificarPartidoyArbitro (PartidoyArbitroDTO partidoyArbitroDTO) throws Exception;

    List<PartidoyArbitroDTO> obtenerPartidoyArbitros();

    void eliminarPartidoyArbitro(Integer id) throws Exception;
}
