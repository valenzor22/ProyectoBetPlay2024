package com.ligabtp.ligabetplay.repository.service;

import com.ligabtp.ligabetplay.domain.PartidoyArbitro;
import com.ligabtp.ligabetplay.dto.PartidoyArbitroDTO;

public interface PartidoyArbitroService {
    PartidoyArbitroDTO guardarNuevoPartidoyArbitro(PartidoyArbitroDTO partidoyArbitroDTO) throws Exception;
    PartidoyArbitroDTO buscarPartidoyArbitroPorId(Integer id) throws Exception;
    PartidoyArbitroDTO modificarPartidoyArbitro (PartidoyArbitro PartidoyArbitroDTO) throws Exception;
}
