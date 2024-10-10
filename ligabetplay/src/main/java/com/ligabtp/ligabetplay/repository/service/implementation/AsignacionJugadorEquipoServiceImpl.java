package com.ligabtp.ligabetplay.repository.service.implementation;


import com.ligabtp.ligabetplay.domain.AsignacionJugadorEquipo;
import com.ligabtp.ligabetplay.domain.Equipo;
import com.ligabtp.ligabetplay.domain.Jugador;
import com.ligabtp.ligabetplay.dto.AsignacionJugadorEquipoDTO;
import com.ligabtp.ligabetplay.mapper.AsignacionJugadorEquipoMapper;
import com.ligabtp.ligabetplay.repository.AsignacionJugadorEquipoRepository;
import com.ligabtp.ligabetplay.repository.EquipoRepository;
import com.ligabtp.ligabetplay.repository.JugadorRepository;
import com.ligabtp.ligabetplay.repository.service.AsignacionJugadorEquipoService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
        //Validacion 1 id debe ser null
        if(asignacionJugadorEquipoDTO.getId() != null){
            throw new Exception("El debe de ser nulo");
        }

        //Validacion 2 llegue al fecha inicio
        if(asignacionJugadorEquipoDTO.getFechaInicio() == null || asignacionJugadorEquipoDTO.getFechaInicio().equals("")){
            throw new Exception("La fecha inicio debe ser no nula");
        }

        //Validacion 3 llegue al fecha fin
        if(asignacionJugadorEquipoDTO.getFechaFin() == null || asignacionJugadorEquipoDTO.getFechaFin().equals("")){
            throw new Exception("La fecha fin debe ser no nula");
        }

        if(asignacionJugadorEquipoDTO.getEquipoId() ==null){
            throw new Exception("El equipo no debe ser nulo");
        }


        AsignacionJugadorEquipo asignacionJugadorEquipo = AsignacionJugadorEquipoMapper.dtoToDomain(asignacionJugadorEquipoDTO);
        Equipo equipo = equipoRepository.getReferenceById(asignacionJugadorEquipoDTO.getEquipoId());

        if(equipo == null){
            throw new Exception("El equipo no existe");
        }

        Jugador jugador = jugadorRepository.getReferenceById(asignacionJugadorEquipoDTO.getJugadorId());

        if (jugador == null){
            throw new Exception("El jugador no existe");
        }


        asignacionJugadorEquipo.setEquipo(equipo);
        asignacionJugadorEquipo.setJugador(jugador);
        asignacionJugadorEquipo = asignacionJugadorEquipoRepository.save(asignacionJugadorEquipo);

        return AsignacionJugadorEquipoMapper.domainToDto(asignacionJugadorEquipo);

    }

    @Override
    @Transactional(readOnly = true)
    public AsignacionJugadorEquipoDTO buscarAsignacionJugadorPorId(Integer id) throws Exception {
        //Logica para buscar ASIGNACION por id retornando DTO
        //Validación del id que llega por parametro
        if(id == null || id.equals(0)) {
            throw new Exception("El id del asignacion no puede ser null");
        }

        AsignacionJugadorEquipo asignacionJugadorEquipo = asignacionJugadorEquipoRepository.getReferenceById(id);
        if(asignacionJugadorEquipo == null){
            throw new Exception("El asignacion no existe"+ id);
        }

        AsignacionJugadorEquipoDTO asignacionJugadorEquipoDTO = AsignacionJugadorEquipoMapper.domainToDto(asignacionJugadorEquipo);
        return null;
    }


}