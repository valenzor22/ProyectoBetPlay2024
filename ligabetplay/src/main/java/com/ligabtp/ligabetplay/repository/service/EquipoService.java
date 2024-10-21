package com.ligabtp.ligabetplay.repository.service;

import com.ligabtp.ligabetplay.dto.EquipoDTO;
import com.ligabtp.ligabetplay.dto.JugadorDTO;

import java.util.List;

public interface EquipoService {
    EquipoDTO buscarEquipoPorId(Integer id) throws Exception;

    EquipoDTO guardarNuevaEquipo(EquipoDTO equipoDTO) throws Exception;

    List<EquipoDTO> obtenerEqupos();

    EquipoDTO modificarEquipo(EquipoDTO equipoDTO) throws Exception;

    EquipoDTO borrarEquipo(EquipoDTO equipoDTO) throws Exception;


}
