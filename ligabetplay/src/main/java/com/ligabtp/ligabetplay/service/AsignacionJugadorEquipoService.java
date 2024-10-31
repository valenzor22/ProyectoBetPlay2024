package com.ligabtp.ligabetplay.service;

import com.ligabtp.ligabetplay.dto.AsignacionJugadorEquipoDTO;

import java.util.List;

public interface AsignacionJugadorEquipoService {

   AsignacionJugadorEquipoDTO guardarNuevaAsignacionJugadorEquipo (AsignacionJugadorEquipoDTO AsignacionJugadorEquipoDTO) throws Exception;

   AsignacionJugadorEquipoDTO buscarAsignacionJugadorEquipoPorId (Integer id) throws Exception;

   AsignacionJugadorEquipoDTO modificarAsignacionJugadorEquipo (AsignacionJugadorEquipoDTO AsignacionJugadorEquipoDTO) throws Exception;

   List<AsignacionJugadorEquipoDTO> obtenerAsignacionJugadorEquipos ();

   void eliminarAsignacionJugadorEquipo (Integer id) throws Exception;


}
