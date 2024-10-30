package com.ligabtp.ligabetplay.repository.service.implementation;

import com.ligabtp.ligabetplay.domain.EstadisticaDelPartido;
import com.ligabtp.ligabetplay.dto.EstadisticaDelPartidoDTO;
import com.ligabtp.ligabetplay.mapper.EstadisticaDelPartidoMapper;
import com.ligabtp.ligabetplay.repository.EstadisticaDelPartidoRepository;
import com.ligabtp.ligabetplay.repository.service.EstadisticaDelPartidoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
public class EstadisticaDelPartidoServicelmpl implements EstadisticaDelPartidoService {

    private final EstadisticaDelPartidoRepository estadisticaDelPartidoRepository;

    public EstadisticaDelPartidoServicelmpl(EstadisticaDelPartidoRepository estadisticaDelPartidoRepository) {
        this.estadisticaDelPartidoRepository = estadisticaDelPartidoRepository;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public EstadisticaDelPartidoDTO guardarNuevaEstadisticaDelPartido(EstadisticaDelPartidoDTO estadisticaDelPartidoDTO) throws Exception {
        if (estadisticaDelPartidoDTO == null) {
            throw new Exception("Estadistica Del Partido no puede ser nulo");
        }

        if (estadisticaDelPartidoDTO.getId() != null) {
            throw new Exception("Estadistica Del Partido no puede ser null");
        }
        if (estadisticaDelPartidoDTO.getPosesion() != null) {
            throw new Exception("La posesion no deberia de ser nulo");
        }
        if (estadisticaDelPartidoDTO.getTirosAPuerta() == null) {
            throw new Exception("Los tiros a puerta no puede ser nulo");
        }
        if (estadisticaDelPartidoDTO.getTirosFuera() == null) {
            throw new Exception("Los tiros fuera no puede ser nulo");
        }
        if (estadisticaDelPartidoDTO.getFaltas() == null) {
            throw new Exception("Los faltas no puede ser nulo");
        }
        if (estadisticaDelPartidoDTO.getCorners() == null) {
            throw new Exception("Los corners no puede ser nulo");
        }
        if (estadisticaDelPartidoDTO.getTarjetasAmarillas() == null) {
            throw new Exception("Los tarjetas amarillas no puede ser nulo");
        }
        if (estadisticaDelPartidoDTO.getTarjetasRojas() == null) {
            throw new Exception("Los tarjetas rojas no puede ser nulo");
        }
        if (estadisticaDelPartidoDTO.getTiroEsquinaResultado() == null) {
            throw new Exception("Los tiro esquina resultado no puede ser nulo");
        }
        if (estadisticaDelPartidoDTO.getRemateArcoResultado() == null) {
            throw new Exception("Los remate arco resultado no puede ser nulo");
        }


        if (estadisticaDelPartidoDTO.getPartidoId() == null) {
            throw new Exception("Los partido id no puede ser nulo");
        }
        if (estadisticaDelPartidoDTO.getEquipoId() == null) {
            throw new Exception("Los equipo id no puede ser nulo");
        }

        EstadisticaDelPartido estadisticaDelPartido = EstadisticaDelPartidoMapper.dtoToDomain(estadisticaDelPartidoDTO);
        estadisticaDelPartidoRepository.save(estadisticaDelPartido);
        return EstadisticaDelPartidoMapper.domainToDto(estadisticaDelPartido);
    }

    @Override
    @Transactional(readOnly = true)
    public EstadisticaDelPartidoDTO buscarEstadisticaDelPartidoPorId(Integer id) throws Exception {
        if (id == null || id.equals(0)) {
            throw new Exception("Estadistica Del Partido no puede estar vacio o ser cero (0)");
        }
        EstadisticaDelPartido estadisticaDelPartido = estadisticaDelPartidoRepository.findById(id)
                .orElseThrow(() -> new Exception("No se encuentra estadistica del partido con el id" + id));

        return EstadisticaDelPartidoMapper.domainToDto(estadisticaDelPartido);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public EstadisticaDelPartidoDTO modificarNuevaEstadisticaDelPartido(EstadisticaDelPartidoDTO estadisticaDelPartidoDTO) throws Exception {
        if (estadisticaDelPartidoDTO == null) {
            throw new Exception("Estadistica Del Partido no puede ser nulo");
        }

        if (estadisticaDelPartidoDTO.getId() != null) {
            throw new Exception("Estadistica Del Partido no puede ser null");
        }
        if (estadisticaDelPartidoDTO.getPosesion() != null) {
            throw new Exception("La posesion no deberia de ser nulo");
        }
        if (estadisticaDelPartidoDTO.getTirosAPuerta() == null) {
            throw new Exception("Los tiros a puerta no puede ser nulo");
        }
        if (estadisticaDelPartidoDTO.getTirosFuera() == null) {
            throw new Exception("Los tiros fuera no puede ser nulo");
        }
        if (estadisticaDelPartidoDTO.getFaltas() == null) {
            throw new Exception("Los faltas no puede ser nulo");
        }
        if (estadisticaDelPartidoDTO.getCorners() == null) {
            throw new Exception("Los corners no puede ser nulo");
        }
        if (estadisticaDelPartidoDTO.getTarjetasAmarillas() == null) {
            throw new Exception("Los tarjetas amarillas no puede ser nulo");
        }
        if (estadisticaDelPartidoDTO.getTarjetasRojas() == null) {
            throw new Exception("Los tarjetas rojas no puede ser nulo");
        }
        if (estadisticaDelPartidoDTO.getTiroEsquinaResultado() == null) {
            throw new Exception("Los tiro esquina resultado no puede ser nulo");
        }
        if (estadisticaDelPartidoDTO.getRemateArcoResultado() == null) {
            throw new Exception("Los remate arco resultado no puede ser nulo");
        }


        if (estadisticaDelPartidoDTO.getPartidoId() == null) {
            throw new Exception("Los partido id no puede ser nulo");
        }
        if (estadisticaDelPartidoDTO.getEquipoId() == null) {
            throw new Exception("Los equipo id no puede ser nulo");
        }

        EstadisticaDelPartido estadisticaDelPartido = EstadisticaDelPartidoMapper.dtoToDomain(estadisticaDelPartidoDTO);
        estadisticaDelPartidoRepository.save(estadisticaDelPartido);
        return EstadisticaDelPartidoMapper.domainToDto(estadisticaDelPartido);
    }

    @Override
    public List<EstadisticaDelPartidoDTO> obtenerEstadisticadelPartidos() {
        List<EstadisticaDelPartido> listaEstadisticaDelPartidos = estadisticaDelPartidoRepository.findAll();
        List<EstadisticaDelPartidoDTO> listaEstadisticaDelPartidosDTO = EstadisticaDelPartidoMapper.domainToDTOList(listaEstadisticaDelPartidos);
        return listaEstadisticaDelPartidosDTO;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void eliminarEstadisticaDelPartido(Integer id) throws Exception {
        if (id == null || id.equals(0)) {
            throw new Exception("Estadistica Del Partido no puede ser nulo");
        }
        //hay que completar

    }
}
