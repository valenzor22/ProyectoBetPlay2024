package com.ligabtp.ligabetplay.service;


import com.ligabtp.ligabetplay.dto.ArbitroDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ArbitroService {

    ArbitroDTO guardarNuevoArbitro(ArbitroDTO arbitroDTO) throws Exception;

    List<ArbitroDTO> obtenerArbitros();

    ArbitroDTO modificarArbitro(ArbitroDTO arbitroDTO) throws Exception;

    ArbitroDTO buscarArbitroPorNombre(String nombre) throws Exception;

    void eliminarArbitro(Integer id) throws Exception;


    ArbitroDTO buscarArbitroPorId(Integer id) throws Exception;
}
