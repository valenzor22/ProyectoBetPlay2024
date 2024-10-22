package com.ligabtp.ligabetplay.repository.service.implementation;


import com.ligabtp.ligabetplay.domain.TipoEvento;
import com.ligabtp.ligabetplay.dto.TipoEventoDTO;
import com.ligabtp.ligabetplay.mapper.TipoEventoMapper;
import com.ligabtp.ligabetplay.repository.TipoEventoRepository;
import com.ligabtp.ligabetplay.repository.service.TipoEventoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TipoEventoServicelmpl implements TipoEventoService {

    private final TipoEventoRepository tipoEventoRepository;

    public TipoEventoServicelmpl(TipoEventoRepository tipoEventoRepository) {
        this.tipoEventoRepository = tipoEventoRepository;
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
    public TipoEventoDTO guardarNuevoTipoEvento(TipoEventoDTO tipoEventoDTO) throws Exception {
        if (tipoEventoDTO == null) {
            throw new Exception("El tipo evento no puede ser nulo");
        }

        if (tipoEventoDTO.getId() != null) {
            throw new Exception("No debería tener ID puesto que es un Nuevo Tipo de evento");
        }
        if (tipoEventoDTO.getNombre() != null) {
            throw new Exception("No debería tener ID puesto que es un Nuevo Nombre del eveneto");
        }



        TipoEvento tipoEvento = TipoEventoMapper.dtoToDomain(tipoEventoDTO);
        tipoEvento = tipoEventoRepository.save(tipoEvento);
        return TipoEventoMapper.domainToDTO(tipoEvento);
    }


    @Override
    @Transactional(readOnly = true)
    public List<TipoEventoDTO> obtenerTipoEventos() {
        List<TipoEvento> listaTipoEventos = tipoEventoRepository.findAll();
        List<TipoEventoDTO> tipoEventoDTO = TipoEventoMapper.domainToDTOList(listaTipoEventos);
        return tipoEventoDTO;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public TipoEventoDTO modificarTipoEvento(TipoEventoDTO tipoEventoDTO) throws Exception {
        if (tipoEventoDTO == null) {
            throw new Exception("El tipoEventoDTO no puede ser nulo");
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
    public TipoEventoDTO buscarTipoEventoPorNombre(String nombre) throws Exception {
        if(nombre == null || nombre.equals("")) {
            throw new Exception("El nombre del tipo de evento no puede ser nulo o estar vacio");
        }

        TipoEvento tipoEvento = tipoEventoRepository.findByNombre(nombre)
                .orElseThrow(() -> new Exception("El nombre del Tipo Evento no existe" + nombre));

        return TipoEventoMapper.domainToDTO(tipoEvento);
    }


}