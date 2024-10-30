package com.ligabtp.ligabetplay.repository.service.implementation;

import com.ligabtp.ligabetplay.domain.Jornada;
import com.ligabtp.ligabetplay.dto.JornadaDTO;
import com.ligabtp.ligabetplay.mapper.JornadaMapper;
import com.ligabtp.ligabetplay.repository.JornadaRepository;
import com.ligabtp.ligabetplay.repository.service.JornadaService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class JornadaServicelmpl implements JornadaService {

    private JornadaRepository jornadaRepository;

    public JornadaServicelmpl(JornadaRepository jornadaRepository) {
        this.jornadaRepository = jornadaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public JornadaDTO buscarJornadaPorId(Integer id) throws Exception {
        if (id == null || id.equals(0)) {
            throw new Exception("El id del jornada no puede estar vacio ni ser cero (0)");
        }

        Jornada jornada = jornadaRepository.findById(id)
                .orElseThrow(() -> new Exception("No se encuentra jornada con el id" + id));

        return JornadaMapper.domainToDTO(jornada);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public JornadaDTO guardarNuevaJornada(JornadaDTO jornadaDTO) throws Exception {
        if (jornadaDTO == null || jornadaDTO.getId() == null) {
            throw new Exception("El id del jornada no puede se nulo");
        }
        if (jornadaDTO.getId() != null) {
            throw new Exception("No debería tener ID puesto que es un Nuevo Jornada");
        }
        if (jornadaDTO.getNumero() == null || jornadaDTO.getNumero().equals("")) {
            throw new Exception("El nombre del jugador no puede ser nulo");
        }
        if (jornadaDTO.getFechaInicio() == null || jornadaDTO.getFechaInicio().equals("")) {
            throw new Exception("El nombre del jugador no puede ser nulo");
        }
        if (jornadaDTO.getFechaFin() == null || jornadaDTO.getFechaFin().equals("")) {
            throw new Exception("El nombre del jugador no puede ser nulo");
        }

        Jornada jornada = JornadaMapper.dtoToDomain(jornadaDTO);
        jornada = jornadaRepository.save(jornada);
        return JornadaMapper.domainToDTO(jornada);
    }

    @Override
    @Transactional(readOnly = true)
    public List<JornadaDTO> obtenerJornadas() {
        List<Jornada> jornadas = jornadaRepository.findAll();
        List<JornadaDTO> jornadaDTO = JornadaMapper.domainToDTOList(jornadas);
        return jornadaDTO;
    }


    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public JornadaDTO modificarJornada(JornadaDTO jornadaDTO) throws Exception {
        if (jornadaDTO == null || jornadaDTO.getId() == null) {
            throw new Exception("El id del jornada no puede se nulo");
        }
        if (jornadaDTO.getId() != null) {
            throw new Exception("No debería tener ID puesto que es un Nuevo Jornada");
        }
        if (jornadaDTO.getNumero() == null || jornadaDTO.getNumero().equals("")) {
            throw new Exception("El nombre del jugador no puede ser nulo");
        }
        if (jornadaDTO.getFechaInicio() == null || jornadaDTO.getFechaInicio().equals("")) {
            throw new Exception("El nombre del jugador no puede ser nulo");
        }
        if (jornadaDTO.getFechaFin() == null || jornadaDTO.getFechaFin().equals("")) {
            throw new Exception("El nombre del jugador no puede ser nulo");
        }

        Jornada jornada = JornadaMapper.dtoToDomain(jornadaDTO);
        jornada = jornadaRepository.save(jornada);
        return JornadaMapper.domainToDTO(jornada);
    }

    @Override
    public JornadaDTO buscarJornadaPorNombre(String nombre) throws Exception {
        if (nombre == null || nombre.equals("")) {
            throw new Exception("El nombre del jornada no puede ser nulo");
        }
        Jornada jornada = jornadaRepository.findByNombre(nombre)
                .orElseThrow(() -> new Exception("El nombre del jornada no existe" + nombre));
        return JornadaMapper.domainToDTO(jornada);

    }

    @Override
    public void eliminarJornada(Integer id) throws Exception {
        if (id == null || id.equals(0)) {
            throw new Exception("El id del jornada no puede ser negativo");
        }
    }



}
