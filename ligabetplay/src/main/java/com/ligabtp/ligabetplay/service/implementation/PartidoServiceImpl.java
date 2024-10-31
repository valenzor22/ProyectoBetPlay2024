package com.ligabtp.ligabetplay.service.implementation;


import com.ligabtp.ligabetplay.domain.Partido;
import com.ligabtp.ligabetplay.domain.Equipo;
import com.ligabtp.ligabetplay.domain.Jornada;
import com.ligabtp.ligabetplay.dto.PartidoDTO;
import com.ligabtp.ligabetplay.mapper.PartidoMapper;
import com.ligabtp.ligabetplay.repository.EventoDelPartidoRepository;
import com.ligabtp.ligabetplay.repository.PartidoRepository;
import com.ligabtp.ligabetplay.repository.EquipoRepository;
import com.ligabtp.ligabetplay.repository.JornadaRepository;
import com.ligabtp.ligabetplay.service.PartidoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PartidoServiceImpl implements PartidoService {

    private final PartidoRepository partidoRepository;
    private final EquipoRepository equipoRepository;
    private final JornadaRepository jornadaRepository;
    private final EventoDelPartidoRepository eventoDelPartidoRepository;


    public PartidoServiceImpl(PartidoRepository partidoRepository, EquipoRepository equipoRepository, JornadaRepository jornadaRepository, EventoDelPartidoRepository eventoDelPartidoRepository) {
        this.partidoRepository = partidoRepository;
        this.equipoRepository = equipoRepository;
        this.jornadaRepository = jornadaRepository;
        this.eventoDelPartidoRepository = eventoDelPartidoRepository;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public PartidoDTO guardarNuevoPartido(PartidoDTO partidoDTO) throws Exception {
        //Validacion 1 id debe ser null
        if (partidoDTO.getId() != null) {
            throw new Exception("El debe de ser nulo");
        }

        //Validacion 2 llegue al fecha inicio
        if (partidoDTO.getFecha() == null || partidoDTO.getFecha().equals("")) {
            throw new Exception("La fecha debe ser no nula");
        }
        if (partidoDTO.getEstadio() == null || partidoDTO.getEstadio().equals("")) {
            throw new Exception("El estadio debe ser no nula");
        }
        if (partidoDTO.getEquipolocalId() == null || partidoDTO.getEquipolocalId().equals("")) {
            throw new Exception("El equipo local debe ser no nula");
        }
        if (partidoDTO.getEquipovisitanteId() == null || partidoDTO.getEquipovisitanteId().equals("")) {
            throw new Exception("El equipo visitante debe ser no nula");
        }
        if (partidoDTO.getGolesLocal() == null || partidoDTO.getGolesLocal().equals("")) {
            throw new Exception("Los goles local debe ser no nula");
        }
        if (partidoDTO.getGolesVisitante() == null || partidoDTO.getGolesVisitante().equals("")) {
            throw new Exception("Los goles visitante debe ser no nula");
        }
        if (partidoDTO.getJornada() == null || partidoDTO.getJornada().equals("")) {
            throw new Exception("La jornada debe ser no nula");
        }

        //Validacion 3 llegue al fecha fin
        if (partidoDTO.getFecha() == null || partidoDTO.getFecha().equals("")) {
            throw new Exception("La fecha debe ser no nula");
        }

        if (partidoDTO.getEstadio() == null || partidoDTO.getEstadio().equals("")) {
            throw new Exception("El estadio debe ser no nula");
        }

        if (partidoDTO.getEquipolocalId() == null || partidoDTO.getEquipolocalId().equals("")) {
            throw new Exception("El equipo local debe ser no nula");
        }

        if (partidoDTO.getEquipovisitanteId() == null || partidoDTO.getEquipovisitanteId().equals("")) {
            throw new Exception("El equipo visitante debe ser no nula");
        }

        if (partidoDTO.getGolesLocal() == null || partidoDTO.getGolesLocal().equals("")) {
            throw new Exception("Los goles local debe ser no nula");
        }

        if (partidoDTO.getGolesVisitante() == null || partidoDTO.getGolesVisitante().equals("")) {
            throw new Exception("Los goles visitante debe ser no nula");
        }
        if (partidoDTO.getJornada() == null || partidoDTO.getJornada().equals("")) {
            throw new Exception("Los goles visitante debe ser no nula");
        }

        if (partidoDTO.getEquipolocalId() == null) {
            throw new Exception("El equipo no debe ser nulo");
        }

// no entiendo desto de aqui para abajo !!!!!
        Partido partido = PartidoMapper.dtoToDomain(partidoDTO);
        Equipo equipoLocal = equipoRepository.getReferenceById(partidoDTO.getEquipolocalId());
        Equipo equipoVisitante = equipoRepository.getReferenceById(partidoDTO.getEquipovisitanteId());


        if (equipoLocal == null) {
            throw new Exception("El equipo local no existe");
        }

        if (equipoVisitante == null) {
            throw new Exception("El equipo visitante no existe");
        }

        Jornada jornada = jornadaRepository.getReferenceById(partidoDTO.getJornada());

        if (jornada == null) {
            throw new Exception("La jornada no existe");
        }


        partido.setEquipoLocal(equipoLocal);
        partido.setEquipoVisitante(equipoVisitante);
        partido.setJornada(jornada);
        partido = partidoRepository.save(partido);

        return PartidoMapper.domainToDTO(partido);

    }


    @Override
    @Transactional(readOnly = true)
    public PartidoDTO buscarPartidoPorId(Integer id) throws Exception {
        if (id == null || id.equals(0)) {
            throw new Exception("El id del partido no puede estar vacio ni se cero (0)");
        }
        Partido partido = partidoRepository.findById(id)
                .orElseThrow(() -> new Exception("No se encuentra el partido con el id" + id));

        return PartidoMapper.domainToDTO(partido);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public PartidoDTO modificarPartido(PartidoDTO partidoDTO) throws Exception {
        //Validacion 1 id debe ser null
        if (partidoDTO.getId() != null) {
            throw new Exception("El debe de ser nulo");
        }

        //Validacion 2 llegue al fecha inicio
        if (partidoDTO.getFecha() == null || partidoDTO.getFecha().equals("")) {
            throw new Exception("La fecha debe ser no nula");
        }
        if (partidoDTO.getEstadio() == null || partidoDTO.getEstadio().equals("")) {
            throw new Exception("El estadio debe ser no nula");
        }
        if (partidoDTO.getEquipolocalId() == null || partidoDTO.getEquipolocalId().equals(0)) {
            throw new Exception("El equipo local debe ser no nula");
        }
        if (partidoDTO.getEquipovisitanteId() == null || partidoDTO.getEquipovisitanteId().equals(0)) {
            throw new Exception("El equipo visitante debe ser no nula");
        }
        if (partidoDTO.getGolesLocal() == null || partidoDTO.getGolesLocal().equals(0)) {
            throw new Exception("Los goles local debe ser no nula");
        }
        if (partidoDTO.getGolesVisitante() == null || partidoDTO.getGolesVisitante().equals(0)) {
            throw new Exception("Los goles visitante debe ser no nula");
        }
        if (partidoDTO.getJornada() == null) {
            throw new Exception("La jornada debe ser no nula");
        }


        //Validacion 3 llegue al fecha fin
        if (partidoDTO.getFecha() == null) {
            throw new Exception("La fecha debe ser no nula");
        }

        if (partidoDTO.getEstadio() == null || partidoDTO.getEstadio().isEmpty()) {
            throw new Exception("El estadio debe ser no nula");
        }

        if (partidoDTO.getEquipolocalId() == null || partidoDTO.getEquipolocalId().equals(0)) {
            throw new Exception("El equipo local debe ser no nula");
        }

        if (partidoDTO.getEquipovisitanteId() == null || partidoDTO.getEquipovisitanteId().equals(0)) {
            throw new Exception("El equipo visitante debe ser no nula");
        }

        if (partidoDTO.getGolesLocal() == null || partidoDTO.getGolesLocal().equals(0)) {
            throw new Exception("Los goles local debe ser no nula");
        }

        if (partidoDTO.getGolesVisitante() == null || partidoDTO.getGolesVisitante().equals(0)) {
            throw new Exception("Los goles visitante debe ser no nula");
        }
        if (partidoDTO.getJornada() == null || partidoDTO.getJornada().equals(0)) {
            throw new Exception("Los goles visitante debe ser no nula");
        }

        if (partidoDTO.getEquipolocalId() == null) {
            throw new Exception("El equipo no debe ser nulo");
        }

// no entiendo desto de aqui para abajo !!!!!
        Partido partido = PartidoMapper.dtoToDomain(partidoDTO);
        Equipo equipoLocal = equipoRepository.getReferenceById(partidoDTO.getEquipolocalId());
        Equipo equipoVisitante = equipoRepository.getReferenceById(partidoDTO.getEquipovisitanteId());


        if (equipoLocal == null) {
            throw new Exception("El equipo local no existe");
        }

        if (equipoVisitante == null) {
            throw new Exception("El equipo visitante no existe");
        }

        Jornada jornada = jornadaRepository.getReferenceById(partidoDTO.getJornada());

        if (jornada == null) {
            throw new Exception("La jornada no existe");
        }


        partido.setEquipoLocal(equipoLocal);
        partido.setEquipoVisitante(equipoVisitante);
        partido.setJornada(jornada);
        partido = partidoRepository.save(partido);

        return PartidoMapper.domainToDTO(partido);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PartidoDTO> obtenerPartidos() {
        List<Partido> partidos = partidoRepository.findAll();
        return PartidoMapper.domainToDTOList(partidos);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void eliminarPartido(Integer id) throws Exception {
        if (id == null || id.equals(0)) {
            throw new Exception("El id del partido no puede ser nulo o cero");
        }

        if (!partidoRepository.existsById(id)) {
            throw new Exception("No se ha encontrado el partido con el Id " + id);
        }

        if (eventoDelPartidoRepository.existsByPartidoId(id)) {
            throw new Exception("No se puede eliminar el partido con id " + id + " porque tiene eventos registrados");
        }

        partidoRepository.deleteById(id);
    }
}