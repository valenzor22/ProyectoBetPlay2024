package com.ligabtp.ligabetplay.service.implementation;

import com.ligabtp.ligabetplay.domain.TablaDePosicion;
import com.ligabtp.ligabetplay.dto.TablaDePosicionDTO;
import com.ligabtp.ligabetplay.mapper.TablaDePosicionMapper;
import com.ligabtp.ligabetplay.repository.EquipoRepository;
import com.ligabtp.ligabetplay.repository.JornadaRepository;
import com.ligabtp.ligabetplay.repository.TablaDePosicionRepository;
import com.ligabtp.ligabetplay.service.TablaDePosicionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class TablaDePosicionServiceImpl implements TablaDePosicionService {

    private final TablaDePosicionRepository tablaDePosicionRepository;
    private final JornadaRepository jornadaRepository;
    private final EquipoRepository equipoRepository;


    public TablaDePosicionServiceImpl(TablaDePosicionRepository tablaDePosicionRepository, JornadaRepository jornadaRepository, EquipoRepository equipoRepository) {
        this.tablaDePosicionRepository = tablaDePosicionRepository;
        this.jornadaRepository = jornadaRepository;
        this.equipoRepository = equipoRepository;
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
        return TablaDePosicionMapper.domainToDTOList(tablaDePosiciones);
    }

    @Override
    public void eliminarTablaDePosicion(Integer id) throws Exception {
        if (id == null || id.equals(0)) {
            throw new Exception("El id del tabla de posiciones no puede ser nula");
        }

    boolean existeAlgunaJornada = tablaDePosicionRepository.existsById(id);
        if(tablaDePosicionRepository.existsByJornadaId(id)){
            throw new Exception("La jornada con id" + id + " ya existe en la tabla de posiciones");
        }

        tablaDePosicionRepository.deleteById(id);
    }
}
