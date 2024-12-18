package com.ligabtp.ligabetplay.service.implementation;

import com.ligabtp.ligabetplay.domain.Equipo;
import com.ligabtp.ligabetplay.dto.EquipoDTO;
import com.ligabtp.ligabetplay.mapper.EquipoMapper;
import com.ligabtp.ligabetplay.repository.AsignacionJugadorEquipoRepository;
import com.ligabtp.ligabetplay.repository.EquipoRepository;
import com.ligabtp.ligabetplay.service.EquipoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class EquipoServiceImpl implements EquipoService {

    private final EquipoRepository equipoRepository;
    private final AsignacionJugadorEquipoRepository asignacionJugadorEquipoRepository;

    public EquipoServiceImpl(EquipoRepository equipoRepository, AsignacionJugadorEquipoRepository asignacionJugadorEquipoRepository) {
        this.equipoRepository = equipoRepository;
        this.asignacionJugadorEquipoRepository = asignacionJugadorEquipoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public EquipoDTO buscarEquipoPorId(Integer id) throws Exception {
        if (id == null || id.equals(0)) {
            throw new Exception("El id no puede estar vacío ni ser cero (0)");
        }

        Equipo equipo = equipoRepository.findById(id).orElseThrow(() -> new Exception("No se encuentra el equipo con el id " + id));

        return EquipoMapper.domainToDTO(equipo);
    }

    @Override
    public EquipoDTO guardarNuevaEquipo(EquipoDTO equipoDTO) throws Exception {
        if (equipoDTO == null) {
            throw new Exception("El equipo no puede ser nulo");
        }

        if (equipoDTO.getNombre() == null || equipoDTO.getNombre().isEmpty()) {
            throw new Exception("El nombre del equipo no puede ser nulo o vacío");
        }
        if (equipoDTO.getCiudad() == null || equipoDTO.getCiudad().isEmpty()) {
            throw new Exception("La ciudad del Equipo no puede ser nula o vacía");
        }
        if (equipoDTO.getEstadio() == null || equipoDTO.getEstadio().isEmpty()) {
            throw new Exception("El estadio del Equipo no puede ser nulo o vacío");
        }
        if (equipoDTO.getEntrenador() == null || equipoDTO.getEntrenador().isEmpty()) {
            throw new Exception("El entrenador del equipo no puede ser nulo o vacío");
        }

        Equipo equipo = EquipoMapper.dtoToDomain(equipoDTO);
        equipo = equipoRepository.save(equipo);

        return EquipoMapper.domainToDTO(equipo);
    }


    @Override
    public List<EquipoDTO> obtenerEquipos() {
        List<Equipo> listaEquipos = equipoRepository.findAll();
        return EquipoMapper.domainToDTOList(listaEquipos);
    }


    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public EquipoDTO modificarEquipo(EquipoDTO equipoDTO) throws Exception {
        if (equipoDTO == null) {
            throw new Exception("El equipoDTO o su id no pueden ser nulos");
        }

        if (equipoDTO.getId() == null || equipoDTO.getId().equals(0)) {
            throw new Exception("El id del Equipo no puede ser nulo o cero");
        }

        if (equipoDTO.getNombre() == null || equipoDTO.getNombre().isEmpty()) {
            throw new Exception("El nombre del Equipo no puede ser nulo o cero");
        }

        if (equipoDTO.getCiudad() == null || equipoDTO.getCiudad().isEmpty()) {
            throw new Exception("La ciudad del Equipo no puede ser nulo o cero");
        }
        if (equipoDTO.getEstadio() == null || equipoDTO.getEstadio().isEmpty()) {
            throw new Exception("El estadio del Equipo no puede ser nulo o vacío");
        }
        if (equipoDTO.getEntrenador() == null || equipoDTO.getEntrenador().isEmpty()) {
            throw new Exception("El entrenador del equipo no puede ser nulo o vacío");
        }

        Equipo equipo = EquipoMapper.dtoToDomain(equipoDTO);
        equipo = equipoRepository.save(equipo);

        return EquipoMapper.domainToDTO(equipo);
    }

    @Override
    @Transactional(readOnly = true)
    public EquipoDTO buscarEquipoPorNombre(String nombre) throws Exception {
        if (nombre == null || nombre.isEmpty()) {
            throw new Exception("El nombre del equipo no puede ser nulo o vacío");
        }

        Equipo equipo = equipoRepository.findByNombre(nombre).orElseThrow(() -> new Exception("No se encuentra el equipo con el nombre " + nombre));

        return EquipoMapper.domainToDTO(equipo);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void eliminarEquipo(Integer id) throws Exception {
        if (id == null || id.equals(0)) {
            throw new Exception("El id del equipo no puede ser nulo o cero");
        }

        boolean existeEquipo = equipoRepository.existsById(id);
        if (existeEquipo) {
            throw new Exception("No existe el equipo con el id" + id + "por lo tanto no se puede eliminar");
        }

        boolean existeAsignacionJugadorEquipo = asignacionJugadorEquipoRepository.existsByEquipoId(id);
        if (existeAsignacionJugadorEquipo) {
            throw new Exception("El equipo con id "+id+" no se puede eliminar porque tiene relacion con AsignacionJugadorEquipo");
        }

        equipoRepository.deleteById(id);

    }
}