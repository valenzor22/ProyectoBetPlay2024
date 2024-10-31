package com.ligabtp.ligabetplay.service.implementation;

import com.ligabtp.ligabetplay.domain.AsignacionJugadorEquipo;
import com.ligabtp.ligabetplay.domain.Equipo;
import com.ligabtp.ligabetplay.dto.AsignacionJugadorEquipoDTO;
import com.ligabtp.ligabetplay.mapper.AsignacionJugadorEquipoMapper;
import com.ligabtp.ligabetplay.repository.AsignacionJugadorEquipoRepository;
import com.ligabtp.ligabetplay.repository.EquipoRepository;
import com.ligabtp.ligabetplay.repository.JugadorRepository;
import com.ligabtp.ligabetplay.service.AsignacionJugadorEquipoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AsignacionJugadorEquipoServiceImpl implements AsignacionJugadorEquipoService {

    private final AsignacionJugadorEquipoRepository asignacionJugadorEquipoRepository;
    private final EquipoRepository equipoRepository;
    private final JugadorRepository jugadorRepository;

    public AsignacionJugadorEquipoServiceImpl(AsignacionJugadorEquipoRepository asignacionJugadorEquipoRepository, EquipoRepository equipoRepository, JugadorRepository jugadorRepository) {
        this.asignacionJugadorEquipoRepository = asignacionJugadorEquipoRepository;
        this.equipoRepository = equipoRepository;
        this.jugadorRepository = jugadorRepository;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public AsignacionJugadorEquipoDTO guardarNuevaAsignacionJugadorEquipo(AsignacionJugadorEquipoDTO asignacionJugadorEquipoDTO) throws Exception {
        if (asignacionJugadorEquipoDTO.getId() != null) {
            throw new Exception("El ID debe ser nulo");
        }

        if (asignacionJugadorEquipoDTO.getFechaInicio() == null) {
            throw new Exception("La fecha de inicio debe ser no nula");
        }

        if (asignacionJugadorEquipoDTO.getFechaFin() == null) {
            throw new Exception("La fecha de fin debe ser no nula");
        }

        if (asignacionJugadorEquipoDTO.getEquipoId() == null) {
            throw new Exception("El equipo no debe ser nulo");
        }

        AsignacionJugadorEquipo asignacionJugadorEquipo = AsignacionJugadorEquipoMapper.dtoToDomain(asignacionJugadorEquipoDTO);
        Equipo equipo = equipoRepository.findById(asignacionJugadorEquipoDTO.getEquipoId())
                .orElseThrow(() -> new Exception("El equipo no existe"));

        asignacionJugadorEquipo.setEquipo(equipo);
        asignacionJugadorEquipo = asignacionJugadorEquipoRepository.save(asignacionJugadorEquipo);

        return AsignacionJugadorEquipoMapper.domainToDto(asignacionJugadorEquipo);
    }

    @Override
    @Transactional(readOnly = true)
    public AsignacionJugadorEquipoDTO buscarAsignacionJugadorEquipoPorId(Integer id) throws Exception {
        if (id == null || id.equals(0)) {
            throw new Exception("El ID de la asignación no puede ser nulo o cero");
        }

        AsignacionJugadorEquipo asignacionJugadorEquipo = asignacionJugadorEquipoRepository.findById(id)
                .orElseThrow(() -> new Exception("No se encuentra la asignación jugador equipo con el ID " + id));

        return AsignacionJugadorEquipoMapper.domainToDto(asignacionJugadorEquipo);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public AsignacionJugadorEquipoDTO modificarAsignacionJugadorEquipo(AsignacionJugadorEquipoDTO asignacionJugadorEquipoDTO) throws Exception {
        if (asignacionJugadorEquipoDTO.getId() == null) {
            throw new Exception("El ID no debe ser nulo");
        }

        if (asignacionJugadorEquipoDTO.getFechaInicio() == null) {
            throw new Exception("La fecha de inicio debe ser no nula");
        }

        if (asignacionJugadorEquipoDTO.getFechaFin() == null) {
            throw new Exception("La fecha de fin debe ser no nula");
        }

        if (asignacionJugadorEquipoDTO.getEquipoId() == null) {
            throw new Exception("El equipo no debe ser nulo");
        }

        AsignacionJugadorEquipo asignacionJugadorEquipo = AsignacionJugadorEquipoMapper.dtoToDomain(asignacionJugadorEquipoDTO);
        Equipo equipo = equipoRepository.findById(asignacionJugadorEquipoDTO.getEquipoId())
                .orElseThrow(() -> new Exception("El equipo no existe"));

        asignacionJugadorEquipo.setEquipo(equipo);
        asignacionJugadorEquipo = asignacionJugadorEquipoRepository.save(asignacionJugadorEquipo);

        return AsignacionJugadorEquipoMapper.domainToDto(asignacionJugadorEquipo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AsignacionJugadorEquipoDTO> obtenerAsignacionJugadorEquipos() {
        List<AsignacionJugadorEquipo> listaAsignacionJugadorEquipos = asignacionJugadorEquipoRepository.findAll();
        return AsignacionJugadorEquipoMapper.domainToDTOList(listaAsignacionJugadorEquipos);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void eliminarAsignacionJugadorEquipo(Integer id) throws Exception {
        if (id == null || id.equals(0)) {
            throw new Exception("El ID de la asignación no puede ser nulo o cero");
        }

        boolean existeAlgunEquipo = equipoRepository.existsById(id);
        if (asignacionJugadorEquipoRepository.existsByEquipoId(id)) {
            throw new Exception("No existe la asignación con el ID " + id + ", por lo tanto no se puede eliminar");
        }

        boolean existeAlgunJugador = jugadorRepository.existsById(id);
        if (asignacionJugadorEquipoRepository.existsByJugadorId(id)) {
                throw new Exception("La asignación con el ID " + id + " tiene jugadores asociados, por lo tanto no se puede eliminar");
        }

        asignacionJugadorEquipoRepository.deleteById(id);
    }
}