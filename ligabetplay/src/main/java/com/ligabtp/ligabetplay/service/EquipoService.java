package com.ligabtp.ligabetplay.service;

import com.ligabtp.ligabetplay.dto.EquipoDTO;


import java.util.List;

public interface EquipoService {
    EquipoDTO buscarEquipoPorId(Integer id) throws Exception;

    EquipoDTO guardarNuevaEquipo(EquipoDTO equipoDTO) throws Exception;

    List<EquipoDTO> obtenerEquipos();

    EquipoDTO modificarEquipo(EquipoDTO equipoDTO) throws Exception;

    EquipoDTO buscarEquipoPorNombre(String nombre) throws Exception;

    void eliminarEquipo(Integer id) throws Exception;


}
