package com.ligabtp.ligabetplay.repository.service;


import com.ligabtp.ligabetplay.dto.ArbitroDTO;

import java.util.List;

public interface ArbitroService {

    ArbitroDTO buscarArbitroPorId(Integer id) throws Exception;

    ArbitroDTO guardarNuevoArbitro(ArbitroDTO arbitroDTO) throws Exception;

    List<ArbitroDTO> obtenerArbitros();

    ArbitroDTO modificarArbitro(ArbitroDTO arbitroDTO) throws Exception;

    ArbitroDTO buscarArbitroPorNombre(String nombre) throws Exception;


}
