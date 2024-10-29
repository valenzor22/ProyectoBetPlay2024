package com.ligabtp.ligabetplay.repository.service.implementation;

import com.ligabtp.ligabetplay.domain.EventoDelPartido;
import com.ligabtp.ligabetplay.dto.EventoDelPartidoDTO;
import com.ligabtp.ligabetplay.mapper.EventoDelPartidoMapper;
import com.ligabtp.ligabetplay.repository.EventoDelPartidoRepository;
import com.ligabtp.ligabetplay.repository.TipoEventoRepository;
import com.ligabtp.ligabetplay.repository.service.EventoDelPartidoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class EventoDelPartidoServiceImpl implements EventoDelPartidoService {

    private final EventoDelPartidoRepository eventoDelPartidoRepository;
    private final TipoEventoRepository tipoEventoRepository;

    public EventoDelPartidoServiceImpl(EventoDelPartidoRepository eventoDelPartidoRepository, TipoEventoRepository tipoEventoRepository) {
        this.eventoDelPartidoRepository = eventoDelPartidoRepository;
        this.tipoEventoRepository = tipoEventoRepository;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public EventoDelPartidoDTO guardarNuevoEventoDelPartido(EventoDelPartidoDTO eventoDelPartidoDTO) throws Exception {
        if (eventoDelPartidoDTO == null) {
            throw new Exception("El Evento Del Partido no puede ser nulo");
        }

        if (eventoDelPartidoDTO.getId() != null) {
            throw new Exception("El ID no debería estar presente en un nuevo evento del partido");
        }

        if (eventoDelPartidoDTO.getPartidoId() == null) {
            throw new Exception("El ID del partido no puede ser nulo");
        }

        if (eventoDelPartidoDTO.getMinuto() == null) {
            throw new Exception("El minuto del evento no puede ser nulo");
        }

        if (eventoDelPartidoDTO.getJugadorId() == null) {
            throw new Exception("El ID del jugador no puede ser nulo");
        }

        EventoDelPartido eventoDelPartido = EventoDelPartidoMapper.dtoToDomain(eventoDelPartidoDTO);
        eventoDelPartido = eventoDelPartidoRepository.save(eventoDelPartido);
        return EventoDelPartidoMapper.domainToDto(eventoDelPartido);
    }

    @Override
    @Transactional(readOnly = true)
    public EventoDelPartidoDTO buscarEventoDelPartidoPorId(Integer id) throws Exception {
        if (id == null || id.equals(0)) {
            throw new Exception("El ID del EventoDelPartido no puede ser nulo o cero");
        }

        EventoDelPartido eventoDelPartido = eventoDelPartidoRepository.findById(id)
                .orElseThrow(() -> new Exception("No se encuentra el EventoDelPartido con el ID " + id));

        return EventoDelPartidoMapper.domainToDto(eventoDelPartido);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public EventoDelPartidoDTO modificarEventoDelPartido(EventoDelPartidoDTO eventoDelPartidoDTO) throws Exception {
        if (eventoDelPartidoDTO == null) {
            throw new Exception("El EventoDelPartido no puede ser nulo");
        }

        if (eventoDelPartidoDTO.getId() == null) {
            throw new Exception("El ID debe estar presente para modificar un evento del partido");
        }

        if (eventoDelPartidoDTO.getPartidoId() == null) {
            throw new Exception("El ID del partido no puede ser nulo");
        }

        if (eventoDelPartidoDTO.getMinuto() == null) {
            throw new Exception("El minuto del evento no puede ser nulo");
        }

        if (eventoDelPartidoDTO.getJugadorId() == null) {
            throw new Exception("El ID del jugador no puede ser nulo");
        }

        EventoDelPartido eventoDelPartido = EventoDelPartidoMapper.dtoToDomain(eventoDelPartidoDTO);
        eventoDelPartido = eventoDelPartidoRepository.save(eventoDelPartido);
        return EventoDelPartidoMapper.domainToDto(eventoDelPartido);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EventoDelPartidoDTO> obtenerEventoDelPartidos() {
        List<EventoDelPartido> listaEventoDelPartidos = eventoDelPartidoRepository.findAll();
        return EventoDelPartidoMapper.domainToDTOList(listaEventoDelPartidos);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void eliminarEventoDelPartido(Integer id) throws Exception {
        if (id == null || id.equals(0)) {
            throw new Exception("El ID del EventoDelPartido no puede ser nulo o cero");
        }

        if (!eventoDelPartidoRepository.existsById(id)) {
            throw new Exception("No existe el evento Del Partido con el ID " + id + ", por lo tanto no se puede eliminar");
        }

        if (tipoEventoRepository.existsByEventoDelPartidoId(id)) {
            throw new Exception("El tipo de evento con el ID " + id + " tiene jugadores asociados, por lo tanto no se puede eliminar");
        }

        eventoDelPartidoRepository.deleteById(id);
    }
}