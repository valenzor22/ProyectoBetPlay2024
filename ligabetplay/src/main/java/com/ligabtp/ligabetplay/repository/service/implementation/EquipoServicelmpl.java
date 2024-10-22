package com.ligabtp.ligabetplay.repository.service.implementation;

import com.ligabtp.ligabetplay.domain.Equipo;
import com.ligabtp.ligabetplay.dto.EquipoDTO;
import com.ligabtp.ligabetplay.mapper.EquipoMapper;
import com.ligabtp.ligabetplay.mapper.JugadorMapper;
import com.ligabtp.ligabetplay.repository.EquipoRepository;
import com.ligabtp.ligabetplay.repository.service.EquipoService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class EquipoServicelmpl implements EquipoService {

    private final EquipoRepository equipoRepository;

    public EquipoServicelmpl(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public EquipoDTO buscarEquipoPorId(Integer id) throws Exception {
        if (id == null || id.equals(0)) {
            throw new Exception("El id del equipo no puede estar vacio ni ser cero (0)");
        }

        Equipo equipo = equipoRepository.findById(id)
                .orElseThrow(() -> new Exception("El equipo no existe con el id" + id));

        return EquipoMapper.domainToDTO(equipo);
    }

    @Override
    public EquipoDTO guardarNuevaEquipo(EquipoDTO equipoDTO) throws Exception {
        if (equipoDTO == null) {
            throw new Exception("El equipo no puede ser nulo");
        }

        if (equipoDTO.getNombre() == null || equipoDTO.getNombre().equals("")) {
            throw new Exception("El nombre del equipo no puede ser nulo");
        }

        if (equipoDTO.getCiudad() == null || equipoDTO.getCiudad().equals("")) {
            throw new Exception("La ciudad no puede ser nulo");
        }

        if (equipoDTO.getEstadio() == null || equipoDTO.getEstadio().equals("")) {
            throw new Exception("El estadio no puede ser nulo");
        }

        if (equipoDTO.getEntrenador() == null || equipoDTO.getEntrenador().equals("")) {
            throw new Exception("El estadio no puede ser nulo");
        }

        
    }

    @Override
    public List<EquipoDTO> obtenerEqupos() {
        return List.of();
    }

    @Override
    public EquipoDTO modificarEquipo(EquipoDTO equipoDTO) throws Exception {
        return null;
    }

    @Override
    public EquipoDTO buscarEquipoPorNombre(String nombre) throws Exception {
        return null;
    }
}
