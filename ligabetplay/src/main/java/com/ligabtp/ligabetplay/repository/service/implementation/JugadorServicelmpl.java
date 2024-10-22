package com.ligabtp.ligabetplay.repository.service.implementation;


import com.ligabtp.ligabetplay.domain.Jugador;
import com.ligabtp.ligabetplay.dto.JugadorDTO;
import com.ligabtp.ligabetplay.mapper.JugadorMapper;
import com.ligabtp.ligabetplay.repository.JugadorRepository;
import com.ligabtp.ligabetplay.repository.service.JugadorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JugadorServicelmpl implements JugadorService {

    private final JugadorRepository jugadorRepository;

    public JugadorServicelmpl(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public JugadorDTO buscarJugadorPorId(Integer id) throws Exception {
        if (id == null || id.equals(0)) {
            throw new Exception("El id del jugador no puede ser estar vacio ni ser cero (0)");
        }

        Jugador jugador = jugadorRepository.findById(id)
                .orElseThrow(() -> new Exception("No se encuentra el jugador con el id" + id));

        return JugadorMapper.domainToDTO(jugador);
    }


    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public JugadorDTO guardarNuevoJugador(JugadorDTO jugadorDTO) throws Exception {
        if (jugadorDTO == null) {
            throw new Exception("El jugador no puede ser nulo");
        }

        if (jugadorDTO.getId() != null) {
            throw new Exception("No debería tener ID puesto que es un Nuevo Jugador");
        }

        if (jugadorDTO.getNombre() == null || jugadorDTO.getNombre().equals("")) {
            throw new Exception("El nombre del jugador no puede ser nulo");
        }
        if (jugadorDTO.getPiernaHabilJugador() == null || jugadorDTO.getPiernaHabilJugador().equals("")) {
            throw new Exception("La pierna habil del jugador no puede ser nulo");
        }
        if (jugadorDTO.getPosicion() == null || jugadorDTO.getPosicion().equals("")) {
            throw new Exception("La posicion del jugador no puede ser nulo");
        }
        if (jugadorDTO.getNacionalidad() == null || jugadorDTO.getNacionalidad().equals("")) {
            throw new Exception("La nacionalidad del jugador no puede ser nulo");
        }
        if (jugadorDTO.getNumeroCamisa() == null || jugadorDTO.getNumeroCamisa().equals("")) {
            throw new Exception("El numero de camiseta del jugador no puede ser nulo");
        }
        if (jugadorDTO.getFechaNacimiento() == null || jugadorDTO.getFechaNacimiento().equals("")) {
            throw new Exception("La fecha de nacimiento del jugador no puede ser nulo");
        }

        Jugador jugador = JugadorMapper.dtoToDomain(jugadorDTO);
        jugador = jugadorRepository.save(jugador);
        return JugadorMapper.domainToDTO(jugador);
    }


    @Override
    @Transactional(readOnly = true)
    public List<JugadorDTO> obtenerJugadores() {
        List<Jugador> listaJugadores = jugadorRepository.findAll();
        List<JugadorDTO> jugadoresDTO = JugadorMapper.domainToDTOList(listaJugadores);
        return jugadoresDTO;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public JugadorDTO modificarJugador(JugadorDTO jugadorDTO) throws Exception {
        if (jugadorDTO == null) {
            throw new Exception("El jugadorDTO no puede ser nulo");
        }

        if (jugadorDTO.getId() == null) {
            throw new Exception("No se puede actualizar un jugador si no tenemos su ID");
        }
        if (jugadorDTO.getNombre() == null || jugadorDTO.getNombre().equals("")) {
            throw new Exception("El nombre del jugador no puede ser nulo");
        }
        if (jugadorDTO.getPiernaHabilJugador() == null || jugadorDTO.getPiernaHabilJugador().equals("")) {
            throw new Exception("El nombre del jugador no puede ser nulo");
        }
        if (jugadorDTO.getPosicion() == null || jugadorDTO.getPosicion().equals("")) {
            throw new Exception("El nombre del jugador no puede ser nulo");
        }
        if (jugadorDTO.getNacionalidad() == null || jugadorDTO.getNacionalidad().equals("")) {
            throw new Exception("El nombre del jugador no puede ser nulo");
        }
        if (jugadorDTO.getNumeroCamisa() == null || jugadorDTO.getNumeroCamisa().equals("")) {
            throw new Exception("El nombre del jugador no puede ser nulo");
        }
        if (jugadorDTO.getFechaNacimiento() == null || jugadorDTO.getFechaNacimiento().equals("")) {
            throw new Exception("El nombre del jugador no puede ser nulo");
        }

        Jugador jugador = JugadorMapper.dtoToDomain(jugadorDTO);
        jugador = jugadorRepository.save(jugador);
        return JugadorMapper.domainToDTO(jugador);
    }

    @Override
    public JugadorDTO buscarJugadorPorNombre(String nombre) throws Exception {
       if(nombre == null || nombre.equals("")) {
           throw new Exception("El nombre del jugador no puede ser nulo o estar vacio");
       }

       Jugador jugador = jugadorRepository.findByNombre(nombre)
               .orElseThrow(() -> new Exception("El nombre del jugador no existe" + nombre));

       return JugadorMapper.domainToDTO(jugador);
    }


}


