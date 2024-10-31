package com.ligabtp.ligabetplay.service;


import com.ligabtp.ligabetplay.dto.JornadaDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface JornadaService {
    JornadaDTO buscarJornadaPorId(Integer id) throws Exception;

    JornadaDTO guardarNuevaJornada(JornadaDTO jornadaDTO) throws Exception;
    List<JornadaDTO> obtenerJornadas();
    JornadaDTO modificarJornada(JornadaDTO jornadaDTO) throws Exception;
    JornadaDTO buscarJornadaPorNumero(Integer numero) throws Exception;

    void eliminarJornada(Integer id) throws Exception;


}
