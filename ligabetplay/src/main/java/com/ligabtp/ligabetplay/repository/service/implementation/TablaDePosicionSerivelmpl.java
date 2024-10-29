package com.ligabtp.ligabetplay.repository.service.implementation;

import com.ligabtp.ligabetplay.domain.TablaDePosicion;
import com.ligabtp.ligabetplay.dto.TablaDePosicionDTO;
import com.ligabtp.ligabetplay.mapper.TablaDePosicionMapper;
import com.ligabtp.ligabetplay.repository.TablaDePosicionRepository;
import com.ligabtp.ligabetplay.repository.service.TablaDePosicionService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

public class TablaDePosicionSerivelmpl implements TablaDePosicionService {

    private final TablaDePosicionRepository tablaDePosicionRepository;

    public TablaDePosicionSerivelmpl(TablaDePosicionRepository tablaDePosicionRepository) {
        this.tablaDePosicionRepository = tablaDePosicionRepository;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public TablaDePosicionDTO guardarNuevaTablaDePosicion(TablaDePosicionDTO tablaDePosicionDTO) throws Exception {
        if (tablaDePosicionDTO == null) {
            throw new Exception("La tabla de posiciones no puede ser nula");
        }

        if (tablaDePosicionDTO.getId() == null) {
            throw new Exception("El ID de tabla de posiciones no puede ser nula");
        }
        if (tablaDePosicionDTO.getPuntos() != null) {
            throw new Exception("La puntos no puede ser nula");
        }
        if (tablaDePosicionDTO.getPartidosJugados() != null) {
            throw new Exception("La partidos jugados no puede ser nula");
        }
        if (tablaDePosicionDTO.getGanados() != null) {
            throw new Exception("La ganadores no puede ser nula");
        }
        if (tablaDePosicionDTO.getEmpatados() != null) {
            throw new Exception("La empatadores no puede ser nula");
        }
        if (tablaDePosicionDTO.getPerdidos() != null) {
            throw new Exception("La perdidores no puede ser nula");
        }
        if (tablaDePosicionDTO.getGolesFavor() != null) {
            throw new Exception("La goles favor nula");
        }
        if (tablaDePosicionDTO.getGolesContra() != null) {
            throw new Exception("La goles contra nula");
        }
        if (tablaDePosicionDTO.getDiferenciaGoles() != null) {
            throw new Exception("La goles diferencia goles nula");
        }


        if (tablaDePosicionDTO.getEquipoId() != null) {
            throw new Exception("La equipo id nula");
        }
        if (tablaDePosicionDTO.getJornadaId() != null) {
            throw new Exception("La jornada id nula");
        }

        TablaDePosicion tablaDePosicion = TablaDePosicionMapper.dtoToDomain(tablaDePosicionDTO);
        tablaDePosicion = tablaDePosicionRepository.save(tablaDePosicion);
        return TablaDePosicionMapper.domainToDto(tablaDePosicion);
    }

    @Override
    @Transactional(readOnly = true)
    public TablaDePosicionDTO buscarTablaDePosicionPorId(Integer id) throws Exception {
        if (id == null || id.equals(0)) {
            throw new Exception("El id del tabla de posiciones no puede estar vacio ni se cero (0)");
        }

        TablaDePosicion tablaDePosicion = tablaDePosicionRepository.findById(id)
                .orElseThrow(() -> new Exception("No se encuentra la tabla de posicion con el id" + id));

        return TablaDePosicionMapper.domainToDto(tablaDePosicion);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public TablaDePosicionDTO modificarTablaDePosicion(TablaDePosicionDTO tablaDePosicionDTO) throws Exception {
        if (tablaDePosicionDTO == null) {
            throw new Exception("La tabla de posiciones no puede ser nula");
        }

        if (tablaDePosicionDTO.getId() == null) {
            throw new Exception("El ID de tabla de posiciones no puede ser nula");
        }
        if (tablaDePosicionDTO.getPuntos() != null) {
            throw new Exception("La puntos no puede ser nula");
        }
        if (tablaDePosicionDTO.getPartidosJugados() != null) {
            throw new Exception("La partidos jugados no puede ser nula");
        }
        if (tablaDePosicionDTO.getGanados() != null) {
            throw new Exception("La ganadores no puede ser nula");
        }
        if (tablaDePosicionDTO.getEmpatados() != null) {
            throw new Exception("La empatadores no puede ser nula");
        }
        if (tablaDePosicionDTO.getPerdidos() != null) {
            throw new Exception("La perdidores no puede ser nula");
        }
        if (tablaDePosicionDTO.getGolesFavor() != null) {
            throw new Exception("La goles favor nula");
        }
        if (tablaDePosicionDTO.getGolesContra() != null) {
            throw new Exception("La goles contra nula");
        }
        if (tablaDePosicionDTO.getDiferenciaGoles() != null) {
            throw new Exception("La goles diferencia goles nula");
        }


        if (tablaDePosicionDTO.getEquipoId() != null) {
            throw new Exception("La equipo id nula");
        }
        if (tablaDePosicionDTO.getJornadaId() != null) {
            throw new Exception("La jornada id nula");
        }

        TablaDePosicion tablaDePosicion = TablaDePosicionMapper.dtoToDomain(tablaDePosicionDTO);
        tablaDePosicion = tablaDePosicionRepository.save(tablaDePosicion);
        return TablaDePosicionMapper.domainToDto(tablaDePosicion);
    }


    @Override
    @Transactional(readOnly = true)
    public List<TablaDePosicionDTO> obtenerTablaDePosiciones() {
        List<TablaDePosicion> tablaDePosiciones = tablaDePosicionRepository.findAll();
        List<TablaDePosicionDTO> tablaDePosicionesDTO = TablaDePosicionMapper.domainToDTOList(tablaDePosiciones);
        return tablaDePosicionesDTO;
    }

    @Override
    public void eliminarTablaDePosicion(Integer id) throws Exception {
        if (id == null || id.equals(0)) {
            throw new Exception("El id del tabla de posiciones no puede ser nula");
        }

        //hay que completar
    }
}
