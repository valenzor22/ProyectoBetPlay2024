package com.ligabtp.ligabetplay.service.implementation;

import com.ligabtp.ligabetplay.domain.Jornada;
import com.ligabtp.ligabetplay.dto.JornadaDTO;
import com.ligabtp.ligabetplay.mapper.JornadaMapper;
import com.ligabtp.ligabetplay.repository.PartidoRepository;
import com.ligabtp.ligabetplay.repository.TablaDePosicionRepository;
import com.ligabtp.ligabetplay.repository.JornadaRepository;
import com.ligabtp.ligabetplay.service.JornadaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class JornadaServicelmpl implements JornadaService {

    private final JornadaRepository jornadaRepository;
    private final TablaDePosicionRepository tablaDePosicionRepository;
    private final PartidoRepository partidoRepository;

    public JornadaServicelmpl(JornadaRepository jornadaRepository, TablaDePosicionRepository tablaDePosicionRepository, PartidoRepository partidoRepository) {
        this.jornadaRepository = jornadaRepository;
        this.tablaDePosicionRepository = tablaDePosicionRepository;
        this.partidoRepository = partidoRepository;
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
        if (jornadaDTO == null) {
            throw new Exception("El id del jornada no puede se nulo");
        }
        if (jornadaDTO.getId() != null) {
            throw new Exception("No debería tener ID puesto que es un Nuevo Jornada");
        }
        if (jornadaDTO.getNumero() == null || jornadaDTO.getNumero().equals(0)) {
            throw new Exception("El nombre del jugador no puede ser nulo");
        }
        if (jornadaDTO.getFechaInicio() == null || jornadaDTO.getFechaInicio().after(new Date())) {
            throw new Exception("El nombre del jugador no puede ser nulo");
        }
        if (jornadaDTO.getFechaFin() == null || jornadaDTO.getFechaFin().after(new Date())) {
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
        return JornadaMapper.domainToDTOList(jornadas);
    }


    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public JornadaDTO modificarJornada(JornadaDTO jornadaDTO) throws Exception {
        if (jornadaDTO == null || jornadaDTO.getId() == null) {
            throw new Exception("El id del jornada no puede se nulo");
        }

        if (jornadaDTO.getNumero() == null || jornadaDTO.getNumero().equals(0)) {
            throw new Exception("El nombre del jugador no puede ser nulo");
        }
        if (jornadaDTO.getFechaInicio() == null || jornadaDTO.getFechaInicio().after(new Date())) {
            throw new Exception("El nombre del jugador no puede ser nulo");
        }
        if (jornadaDTO.getFechaFin() == null || jornadaDTO.getFechaFin().after(new Date())) {
            throw new Exception("El nombre del jugador no puede ser nulo");
        }

        Jornada jornada = JornadaMapper.dtoToDomain(jornadaDTO);
        jornada = jornadaRepository.save(jornada);
        return JornadaMapper.domainToDTO(jornada);
    }

    @Override
    @Transactional(readOnly = true)
    public JornadaDTO buscarJornadaPorNumero(Integer numero) throws Exception {
        if (numero == null || numero.equals(0)) {
            throw new Exception("El numero del jornada no puede ser nulo");
        }
        Jornada jornada = (Jornada) jornadaRepository.findByNumero(numero)
                .orElseThrow(() -> new Exception("No se encuentra la jornada con el numero" + numero));
        return null;
    }


    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void eliminarJornada(Integer id) throws Exception {
        if (id == null || id.equals(0)) {
            throw new Exception("El id del jornada no puede ser negativo");
        }

        boolean existeAlgunaTablaDePosicionEnJornada = tablaDePosicionRepository.existsByJornadaId(id);
        if (existeAlgunaTablaDePosicionEnJornada) {
            throw new Exception("La Jornada con id " + id + " tiene asociada una tabla de posicion, no se puede eliminar");
        }

        boolean existeAlgunPartidoEnJornada = partidoRepository.existsByJornadaId(id);
        if (existeAlgunPartidoEnJornada) {
            throw new Exception("La Jornada con id "+ id + "tiene partidos asociados, no se puede eliminar");
        }
        jornadaRepository.deleteById(id);
    }



}
