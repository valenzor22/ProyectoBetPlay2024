package com.ligabtp.ligabetplay.repository.service;


import com.ligabtp.ligabetplay.dto.ArbitroDTO;

import java.util.List;

public interface ArbitroService {

    ArbitroDTO guardarNuevoArbitro(ArbitroDTO arbitroDTO) throws Exception;
    ArbitroDTO actualizarArbitro(ArbitroDTO arbitroDTO);
    ArbitroDTO buscarArbitroPorId(Long id);
    List<ArbitroDTO> listarArbitros();

}
