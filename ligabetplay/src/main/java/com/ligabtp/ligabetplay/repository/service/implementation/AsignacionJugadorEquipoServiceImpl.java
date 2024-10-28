package com.ligabtp.ligabetplay.repository.service.implementation;


import com.ligabtp.ligabetplay.domain.AsignacionJugadorEquipo;
import com.ligabtp.ligabetplay.domain.Equipo;
import com.ligabtp.ligabetplay.dto.AsignacionJugadorEquipoDTO;
import com.ligabtp.ligabetplay.mapper.AsignacionJugadorEquipoMapper;
import com.ligabtp.ligabetplay.repository.AsignacionJugadorEquipoRepository;
import com.ligabtp.ligabetplay.repository.EquipoRepository;
import com.ligabtp.ligabetplay.repository.JugadorRepository;
import com.ligabtp.ligabetplay.repository.service.AsignacionJugadorEquipoService;

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
        Equipo equipo = EquipoRepository.finById(AsignacionJugadorEquipoDTO.getEquipoId())
                .orElseThrow(() -> new Exception("El equipo no existe"));

        asignacionJugadorEquipo.setEquipo(equipo);
        asignacionJugadorEquipo =  asignacionJugadorEquipoRepository.save(asignacionJugadorEquipo);

        return AsignacionJugadorEquipoMapper.domainToDto(asignacionJugadorEquipo);
    }


    @Override
    @Transactional(readOnly = true)
    public AsignacionJugadorEquipoDTO buscarAsignacionJugadorEquipoPorId(Integer id) throws Exception {

        if(id == null || id.equals(0)) {
            throw new Exception("El id del asignacion no puede ser null");
        }

       AsignacionJugadorEquipo asignacionJugadorEquipo = asignacionJugadorEquipoRepository.findById(id)
               .orElseThrow(() -> new Exception("No se encuentra la asignacion jugador equipo con el id" +id));

        AsignacionJugadorEquipoDTO asignacionJugadorEquipoDTO = AsignacionJugadorEquipoMapper.domainToDto(asignacionJugadorEquipo);
        return asignacionJugadorEquipoDTO;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public AsignacionJugadorEquipoDTO modificarAsignacionJugadorEquipo(AsignacionJugadorEquipoDTO asignacionJugadorEquipoDTO) throws Exception {
        //Logica de
        if(asignacionJugadorEquipoDTO.getId() == null){
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
        Equipo equipo = EquipoRepository.finById(AsignacionJugadorEquipoDTO.getEquipoId())
                .orElseThrow(() -> new Exception("El equipo no existe"));

        asignacionJugadorEquipo.setEquipo(equipo);
        asignacionJugadorEquipo =  asignacionJugadorEquipoRepository.save(asignacionJugadorEquipo);

        return AsignacionJugadorEquipoMapper.domainToDto(asignacionJugadorEquipo);

    }

    @Override
    @Transactional(readOnly = true)
    public List<AsignacionJugadorEquipoDTO> obtenerAsignacionJugadorEquipos() {
       List<AsignacionJugadorEquipo> listaAsignacionJugadorEquipos = asignacionJugadorEquipoRepository.findAll();
       List<AsignacionJugadorEquipoDTO> listaAsignacionJugadorEquiposDTO = AsignacionJugadorEquipoMapper.domainToDTOList(listaAsignacionJugadorEquipos);
       return listaAsignacionJugadorEquiposDTO;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void eliminarAsignacionJugadorEquipo(Integer id) throws Exception {
        if(id == null || id.equals(0)) {
            throw new Exception("El id del asignacion no puede ser null o cero");
        }

        Boolean existe = asignacionJugadorEquipoRepository.existsById(id);
        if(existeAsignacionJugadorEquipo == false) {
            throw new Exception("No existe la asigancion con el id" + id + "por lo tanto no se puede eliminar");
        }

        Boolean existeJugador = jugadorRepository.existsByAsignacionJugadorEquipoId(id);
        if(existeJugador == true) {
            throw new Exception("La asignacion con el id" + id + "tiene jugadores asociados por lo tanto no se puede eliminar");
        }

        asignacionJugadorEquipoRepository.deleteById(id);

    }


}