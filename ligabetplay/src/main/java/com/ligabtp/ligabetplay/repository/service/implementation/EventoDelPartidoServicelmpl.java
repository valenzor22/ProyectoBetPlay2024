package com.ligabtp.ligabetplay.repository.service.implementation;


import com.ligabtp.ligabetplay.domain.EventoDelPartido;
import com.ligabtp.ligabetplay.dto.EventoDelPartidoDTO;
import com.ligabtp.ligabetplay.mapper.EventoDelPartidoMapper;
import com.ligabtp.ligabetplay.repository.EventoDelPartidoRepository;
import com.ligabtp.ligabetplay.repository.service.EventoDelPartidoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EventoDelPartidoServicelmpl implements EventoDelPartidoService {

    private final  EventoDelPartidoRepository eventoDelPartidoRepository;

    public EventoDelPartidoServicelmpl(EventoDelPartidoRepository eventoDelPartidoRepository) {
        this.eventoDelPartidoRepository = eventoDelPartidoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public EventoDelPartidoDTO buscarEventoDelPartidoPorId(Integer id) throws Exception {
        if (id == null || id.equals(0)) {
            throw new Exception("El id del EventoDelPartido no puede ser estar vacio ni ser cero (0)");
        }

        EventoDelPartido eventoDelPartido = EventoDelPartidoRepository.findById(id)
                .orElseThrow(() -> new Exception("No se encuentra el EventoDelPartido con el id" + id));

        return EventoDelPartidoMapper.domainToDTO(eventoDelPartido);
    }


    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public EventoDelPartidoDTO guardarNuevoEventoDelPartido(EventoDelPartidoDTO EventoDelPartidoDTO) throws Exception {
        if (EventoDelPartidoDTO == null) {
            throw new Exception("El EventoDelPartido no puede ser nulo");
        }

        if (EventoDelPartidoDTO.getId() == null) {
            throw new Exception("No debería tener ID puesto que es un Nuevo EventoDelPartido");
        }

        if (EventoDelPartidoDTO.getIdJugador() == null || EventoDelPartidoDTO.getIdJugador().equals("")) {
            throw new Exception("El Jugador no puede ser nulo");
        }
        if (EventoDelPartidoDTO.getMinuto() == null || EventoDelPartidoDTO.getMinuto().equals("")) {
            throw new Exception("El minuto del Evento Del Partido no puede ser nulo");
        }
        if (EventoDelPartidoDTO.getTipoEvento() == null || EventoDelPartidoDTO.getTipoEvento().equals("")) {
            throw new Exception("El Tipo Evento del Evento Del Partido no puede ser nulo");
        }


        EventoDelPartido EventoDelPartido = EventoDelPartidoMapper.dtoToDomain(EventoDelPartidoDTO);
        EventoDelPartido = EventoDelPartidoRepository.save(EventoDelPartido);
        return EventoDelPartidoMapper.domainToDTO(EventoDelPartido);
    }

    @Override
    public List<EventoDelPartidoDTO> obtenerEventoDelPartido() {
        return List.of();
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public EventoDelPartidoDTO modificarEventoDelPartido(EventoDelPartidoDTO EventoDelPartidoDTO) throws Exception {

        if (EventoDelPartidoDTO == null) {
            throw new Exception("El EventoDelPartido no puede ser nulo");
        }

        if (EventoDelPartidoDTO.getId() == null) {
            throw new Exception("No debería tener ID puesto que es un Nuevo EventoDelPartido");
        }

        if (EventoDelPartidoDTO.getIdJugador() == null || EventoDelPartidoDTO.getIdJugador().equals("")) {
            throw new Exception("El Jugador no puede ser nulo");
        }
        if (EventoDelPartidoDTO.getMinuto() == null || EventoDelPartidoDTO.getMinuto().equals("")) {
            throw new Exception("El minuto del Evento Del Partido no puede ser nulo");
        }
        if (EventoDelPartidoDTO.getTipoEvento() == null || EventoDelPartidoDTO.getTipoEvento().equals("")) {
            throw new Exception("El Tipo Evento del Evento Del Partido no puede ser nulo");
        }

        EventoDelPartido eventoDelPartido = EventoDelPartidoMapper.dtoToDomain(EventoDelPartidoDTO);
        EventoDelPartido = EventoDelPartidoRepository.save(eventoDelPartido);
        return EventoDelPartidoMapper.domainToDTO(eventoDelPartido);
    }

    @Override
    public EventoDelPartidoDTO buscarEventoDelPartidoPorNombre(String nombre) throws Exception {
        if(nombre == null || nombre.equals("")) {
            throw new Exception("El nombre del EventoDelPartido no puede ser nulo o estar vacio");
        }

        EventoDelPartido eventoDelPartido = EventoDelPartidoRepository.findByNombre(nombre)
                .orElseThrow(() -> new Exception("El nombre del EventoDelPartido no existe" + nombre));

        return EventoDelPartidoMapper.domainToDTO(eventoDelPartido);
    }


}