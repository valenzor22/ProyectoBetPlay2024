package com.ligabtp.ligabetplay.repository.service;

import com.ligabtp.ligabetplay.dto.AsignacionJugadorEquipoDTO;

public interface AsignacionJugadorEquipoService {

    AsignacionJugadorEquipoDTO guardarNuevaAsignacionJugadorEquipo(AsignacionJugadorEquipoDTO jugadorEquipoDTO) throws Exception;
    AsignacionJugadorEquipoDTO buscarAsignacionJugadorEquipoPorId(Integer id) throws Exception;
    AsignacionJugadorEquipoDTO modificarAsignacionJugadorEquipo (AsignacionJugadorEquipoDTO asignacionJugadorEquipoDTO) throws Exception;
    AsignacionJugadorEquipoDTO buscarAsignacionJugadorPorId(Integer id) throws Exception;
}
