package com.ligabtp.ligabetplay.repository.service.implementation;


import com.ligabtp.ligabetplay.domain.EventoDelPartido;
import com.ligabtp.ligabetplay.dto.EventoDelPartidoDTO;
import com.ligabtp.ligabetplay.mapper.EstadisticaDelPartidoMapper;
import com.ligabtp.ligabetplay.mapper.EventoDelPartidoMapper;
import com.ligabtp.ligabetplay.repository.EventoDelPartidoRepository;
import com.ligabtp.ligabetplay.repository.TipoEventoRepository;
import com.ligabtp.ligabetplay.repository.service.EventoDelPartidoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EventoDelPartidoServicelmpl implements EventoDelPartidoService {

    private final  EventoDelPartidoRepository eventoDelPartidoRepository;


    public EventoDelPartidoServicelmpl(EventoDelPartidoRepository eventoDelPartidoRepository, TipoEventoRepository tipoEventoRepository) {
        this.eventoDelPartidoRepository = eventoDelPartidoRepository;

    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public EventoDelPartidoDTO guardarNuevoEventoDelPartido(EventoDelPartidoDTO eventoDelPartidoDTO) throws Exception {
        if (eventoDelPartidoDTO == null) {
            throw new Exception("El Evento Del Partido no puede ser nulo");
        }

       if (eventoDelPartidoDTO.getId() != null) {
           throw new Exception("No deberia tener ID puesto enevento del partido");
       }

       if (eventoDelPartidoDTO.getPartidoId() == null) {
           throw new Exception("El Evento Del Partido no puede ser nulo");
       }

       if (eventoDelPartidoDTO.getMinuto() == null) {
           throw new Exception("El Evento Del Partido no puede ser nulo");
       }

       if (eventoDelPartidoDTO.getJugadorId() == null) {  // prwguntar si este con partido id tambien va porque estas son forean key
           throw new Exception("El Evento Del Partido no puede ser nulo");
       }

       EventoDelPartido eventoDelPartido = EstadisticaDelPartidoMapper.dtoToDomain(eventoDelPartidoDTO);
       eventoDelPartido = eventoDelPartidoRepository.save(eventoDelPartido);
       return EventoDelPartidoMapper.domainToDto(eventoDelPartido);


    }


    @Override
    @Transactional(readOnly = true)
    public EventoDelPartidoDTO buscarEventoDelPartidoPorId(Integer id) throws Exception {
        if (id == null || id.equals(0)) {
            throw new Exception("El id del EventoDelPartido no puede ser estar vacio ni ser cero (0)");
        }

        EventoDelPartido eventoDelPartido = eventoDelPartidoRepository.findById(id)
                .orElseThrow(() -> new Exception("No se encuentra el EventoDelPartido con el id" + id));

        return EventoDelPartidoMapper.domainToDto(eventoDelPartido);
    }


    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public EventoDelPartidoDTO modificarEventoDelPartido(EventoDelPartidoDTO eventoDelPartidoDTO) throws Exception {
        if (eventoDelPartidoDTO == null) {
            throw new Exception("El EventoDelPartido no puede ser nulo");
        }

        if (eventoDelPartidoDTO.getId() != null) {
            throw new Exception("No deberia tener ID puesto enevento del partido");
        }

        if (eventoDelPartidoDTO.getPartidoId() == null) {
            throw new Exception("El Evento Del Partido no puede ser nulo");
        }

        if (eventoDelPartidoDTO.getMinuto() == null) {
            throw new Exception("El Evento Del Partido no puede ser nulo");
        }

        if (eventoDelPartidoDTO.getJugadorId() == null) {  // prwguntar si este con partido id tambien va porque estas son forean key
            throw new Exception("El Evento Del Partido no puede ser nulo");
        }

        EventoDelPartido eventoDelPartido = EventoDelPartidoMapper.dtoToDomain(eventoDelPartidoDTO);
        eventoDelPartido = eventoDelPartidoRepository.save(eventoDelPartido);
        return EventoDelPartidoMapper.domainToDto(eventoDelPartido);

    }

    @Override
    @Transactional(readOnly = true)

    public List<EventoDelPartidoDTO> obtenerEventoDelPartidos() {
        List<EventoDelPartido> listaEventoDelPartidos = eventoDelPartidoRepository.findAll();
        List <EventoDelPartidoDTO> eventoDelPartidosDTO = EventoDelPartidoMapper.domainToDTOList(listaEventoDelPartidos);
        return eventoDelPartidosDTO;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void eliminarEventoDelPartido(Integer id) throws Exception {
        if (id == null || id.equals(0)) {
            throw new Exception("El id del EventoDelPartido no puede ser nulo o cero");
        }

        //hay que completar
    }



}