package com.ligabtp.ligabetplay.service.implementation;


import com.ligabtp.ligabetplay.domain.Jugador;
import com.ligabtp.ligabetplay.dto.JugadorDTO;
import com.ligabtp.ligabetplay.mapper.JugadorMapper;
import com.ligabtp.ligabetplay.repository.AsignacionJugadorEquipoRepository;
import com.ligabtp.ligabetplay.repository.JugadorRepository;
import com.ligabtp.ligabetplay.service.JugadorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.Date;
import java.util.List;

@Service
public class JugadorServicelmpl implements JugadorService {

    private final JugadorRepository jugadorRepository;
    private final AsignacionJugadorEquipoRepository asignacionJugadorEquipoRepository;

    public JugadorServicelmpl(JugadorRepository jugadorRepository, AsignacionJugadorEquipoRepository asignacionJugadorEquipoRepository) {
        this.jugadorRepository = jugadorRepository;
        this.asignacionJugadorEquipoRepository = asignacionJugadorEquipoRepository;
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

        if (jugadorDTO.getNombre() == null || jugadorDTO.getNombre().isEmpty()) {
            throw new Exception("El nombre del jugador no puede ser nulo");
        }
        if (jugadorDTO.getPiernaHabilJugador() == null || jugadorDTO.getPiernaHabilJugador().isEmpty()) {
            throw new Exception("La pierna habil del jugador no puede ser nulo");
        }
        if (jugadorDTO.getPosicion() == null || jugadorDTO.getPosicion().isEmpty()) {
            throw new Exception("La posicion del jugador no puede ser nulo");
        }
        if (jugadorDTO.getNacionalidad() == null || jugadorDTO.getNacionalidad().isEmpty()) {
            throw new Exception("La nacionalidad del jugador no puede ser nulo");
        }
        if (jugadorDTO.getNumeroCamisa() == null || jugadorDTO.getNumeroCamisa().equals(0)) {
            throw new Exception("El numero de camiseta del jugador no puede ser nulo");
        }
        if (jugadorDTO.getFechaNacimiento() == null || jugadorDTO.getFechaNacimiento().after(new Date())) {
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
        return JugadorMapper.domainToDTOList(listaJugadores);
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
        if (jugadorDTO.getNombre() == null || jugadorDTO.getNombre().isEmpty()) {
            throw new Exception("El nombre del jugador no puede ser nulo");
        }
        if (jugadorDTO.getPiernaHabilJugador() == null || jugadorDTO.getPiernaHabilJugador().isEmpty()) {
            throw new Exception("El nombre del jugador no puede ser nulo");
        }
        if (jugadorDTO.getPosicion() == null || jugadorDTO.getPosicion().isEmpty()) {
            throw new Exception("El nombre del jugador no puede ser nulo");
        }
        if (jugadorDTO.getNacionalidad() == null || jugadorDTO.getNacionalidad().isEmpty()) {
            throw new Exception("El nombre del jugador no puede ser nulo");
        }
        if (jugadorDTO.getNumeroCamisa() == null || jugadorDTO.getNumeroCamisa().equals(0)) {
            throw new Exception("El nombre del jugador no puede ser nulo");
        }
        if (jugadorDTO.getFechaNacimiento() == null || jugadorDTO.getFechaNacimiento().after(new Date())) {
            throw new Exception("El nombre del jugador no puede ser nulo");
        }

        Jugador jugador = JugadorMapper.dtoToDomain(jugadorDTO);
        jugador = jugadorRepository.save(jugador);
        return JugadorMapper.domainToDTO(jugador);
    }

    @Override
    @Transactional(readOnly = true)
    public JugadorDTO buscarJugadorPorNombre(String nombre) throws Exception {
       if(nombre == null || nombre.isEmpty()) {
           throw new Exception("El nombre del jugador no puede ser nulo o estar vacio");
       }

       Jugador jugador = jugadorRepository.findByNombre(nombre)
               .orElseThrow(() -> new Exception("El nombre del jugador no existe" + nombre));

       return JugadorMapper.domainToDTO(jugador);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void eliminarJugador(Integer id) throws Exception {

        if (id == null || id.equals(0)) {
            throw new Exception("El id del jugador no puede ser nulo o cero");
        }

        boolean existeJugador = jugadorRepository.existsById(id);
        if(!existeJugador) {
            throw new Exception("El jugador no existe"+ id + "por lo tanto no se puede eliminar");
        }

        boolean existeAlgunaAsignacionJugadorEquipoAlJugador = asignacionJugadorEquipoRepository.existsByJugadorId(id);
        if (!existeAlgunaAsignacionJugadorEquipoAlJugador){
            throw new Exception("El jugador con el id"+ id + "tiene asignaciones jugadores equipo por lo tanto no se puede eliminar");
        }

        jugadorRepository.deleteById(id);
    }


}


