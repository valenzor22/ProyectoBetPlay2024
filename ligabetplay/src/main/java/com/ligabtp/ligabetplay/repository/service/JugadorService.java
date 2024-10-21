package com.ligabtp.ligabetplay.repository.service;

import com.ligabtp.ligabetplay.dto.ArbitroDTO;
import com.ligabtp.ligabetplay.dto.JugadorDTO;
import com.ligabtp.ligabetplay.dto.PartidoDTO;

import java.util.List;

public interface JugadorService {
    JugadorDTO buscarJugadorPorId(Integer id) throws Exception;

    JugadorDTO guardarNuevoJugador(JugadorDTO jugadorDTO) throws Exception;

    List<JugadorDTO> obtenerJugadores();

    JugadorDTO modificarJugador(JugadorDTO jugadorDTO) throws Exception;

    JugadorDTO buscarJugadorPorNombre(String nombre) throws Exception;


}
