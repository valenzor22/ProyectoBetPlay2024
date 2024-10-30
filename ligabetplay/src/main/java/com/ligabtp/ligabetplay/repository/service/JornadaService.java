package com.ligabtp.ligabetplay.repository.service;


import com.ligabtp.ligabetplay.dto.JornadaDTO;

import java.util.List;

public interface JornadaService {
    JornadaDTO buscarJornadaPorId(Integer id) throws Exception;

    JornadaDTO guardarNuevaJornada(JornadaDTO jornadaDTO) throws Exception;

    List<JornadaDTO> obtenerJornadas();

    JornadaDTO modificarJornada(JornadaDTO jornadaDTO) throws Exception;

    JornadaDTO buscarJornadaPorNombre(String nombre) throws Exception;

    void eliminarJornada(Integer id) throws Exception;


}
