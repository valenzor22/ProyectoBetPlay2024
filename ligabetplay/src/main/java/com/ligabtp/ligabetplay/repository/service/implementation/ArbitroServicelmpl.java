package com.ligabtp.ligabetplay.repository.service.implementation;

import com.ligabtp.ligabetplay.dto.ArbitroDTO;
import com.ligabtp.ligabetplay.dto.AsignacionJugadorEquipoDTO;
import com.ligabtp.ligabetplay.repository.service.ArbitroService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ArbitroServicelmpl implements ArbitroService {

    @Override
    @Transactional(readOnly = true)
    public AsignacionJugadorEquipoDTO buscarAsignacionJugadorPorId(Integer id) throws Exception {

        if(id == null || id.equals(0)) {
            throw new Exception("El id del asignacion no puede ser null");
        }

    public ArbitroDTO guardarNuevoArbitro(ArbitroDTO arbitroDTO) throws Exception {
        return null;
    }

    @Override
    public ArbitroDTO actualizarArbitro(ArbitroDTO arbitroDTO) {
        return null;
    }

    @Override
    public ArbitroDTO buscarArbitroPorId(Long id) {
        return null;
    }

    @Override
    public List<ArbitroDTO> listarArbitros() {
        return List.of();
    }
}
