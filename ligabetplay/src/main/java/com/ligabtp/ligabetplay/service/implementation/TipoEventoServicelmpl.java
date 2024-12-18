package com.ligabtp.ligabetplay.service.implementation;


import com.ligabtp.ligabetplay.domain.TipoEvento;
import com.ligabtp.ligabetplay.dto.TipoEventoDTO;
import com.ligabtp.ligabetplay.mapper.TipoEventoMapper;
import com.ligabtp.ligabetplay.repository.EventoDelPartidoRepository;
import com.ligabtp.ligabetplay.repository.TipoEventoRepository;
import com.ligabtp.ligabetplay.service.TipoEventoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TipoEventoServicelmpl implements TipoEventoService {

    private final TipoEventoRepository tipoEventoRepository;
    private final EventoDelPartidoRepository eventoDelPartidoRepository;

    public TipoEventoServicelmpl(TipoEventoRepository tipoEventoRepository, EventoDelPartidoRepository eventoDelPartidoRepository) {
        this.tipoEventoRepository = tipoEventoRepository;
        this.eventoDelPartidoRepository = eventoDelPartidoRepository;
    }


    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public TipoEventoDTO guardarNuevoTipoEvento(TipoEventoDTO tipoEventoDTO) throws Exception {
        if (tipoEventoDTO.getId() != null) {
            throw new Exception("No debería tener ID puesto que es un Nuevo Tipo de evento");
        }
        if (tipoEventoDTO.getNombre() == null) {
            throw new Exception("El nombre no deberia de ser nulo");
        }



        TipoEvento tipoEvento = TipoEventoMapper.dtoToDomain(tipoEventoDTO);
        tipoEvento = tipoEventoRepository.save(tipoEvento);
        return TipoEventoMapper.domainToDTO(tipoEvento);
    }


    @Override
    @Transactional(readOnly = true)
    public TipoEventoDTO buscarTipoEventoPorId(Integer id) throws Exception {
        if (id == null || id.equals(0)) {
            throw new Exception("El id del tipo evento no puede ser estar vacio ni ser cero (0)");
        }

        TipoEvento tipoEvento = tipoEventoRepository.findById(id)
                .orElseThrow(() -> new Exception("No se encuentra el tipo de evento con el id" + id));

        return TipoEventoMapper.domainToDTO(tipoEvento);
    }


    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public TipoEventoDTO modificarTipoEvento(TipoEventoDTO tipoEventoDTO) throws Exception {
        if (tipoEventoDTO == null) {
            throw new Exception("El tipoEvento no puede ser nulo");
        }

        if (tipoEventoDTO.getId() == null) {
            throw new Exception("No se puede actualizar un tipo evento si no tenemos su ID");
        }
        if (tipoEventoDTO.getNombre() == null) {
            throw new Exception("No se puede actualizar un nombre de evento si no tenemos su ID");
        }

        TipoEvento tipoEvento = TipoEventoMapper.dtoToDomain(tipoEventoDTO);
        tipoEvento = tipoEventoRepository.save(tipoEvento);
        return TipoEventoMapper.domainToDTO(tipoEvento);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TipoEventoDTO> obtenerTipoEventos(){
        List<TipoEvento> listaTipoEventos = tipoEventoRepository.findAll();
        return TipoEventoMapper.domainToDTOList(listaTipoEventos);
    }


    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void eliminarTipoEvento(Integer id) throws Exception {
        if (id == null || id.equals(0)) {
            throw new Exception("El id del tipo evento no puede ser nulo o cero");
        }

        boolean existeAlgunEventoDelPartidoAlTipoEvento = tipoEventoRepository.existsById(id);
        if (existeAlgunEventoDelPartidoAlTipoEvento) {
            throw new Exception("El Evento del partido con Id" + id + " ya existe en el tipo de evento del partido");
        }

        tipoEventoRepository.deleteById(id);
    }



}