package com.ligabtp.ligabetplay.repository.service.implementation;


import com.ligabtp.ligabetplay.domain.Partido;
import com.ligabtp.ligabetplay.domain.Equipo;
import com.ligabtp.ligabetplay.domain.Jornada;
import com.ligabtp.ligabetplay.dto.PartidoDTO;
import com.ligabtp.ligabetplay.mapper.PartidoMapper;
import com.ligabtp.ligabetplay.repository.PartidoRepository;
import com.ligabtp.ligabetplay.repository.EquipoRepository;
import com.ligabtp.ligabetplay.repository.JornadaRepository;
import com.ligabtp.ligabetplay.repository.service.PartidoService;
import org.springframework.stereotype.Service;

@Service
public class PartidoServiceImpl implements PartidoService {

    private final PartidoRepository partidoRepository;
    private final EquipoRepository equipoRepository;
    private final JornadaRepository jornadaRepository;

    public PartidoServiceImpl(PartidoRepository partidoRepository, EquipoRepository equipoRepository, JornadaRepository jornadaRepository) {
        this.partidoRepository = partidoRepository;
        this.equipoRepository = equipoRepository;
        this.jornadaRepository = jornadaRepository;
    }


    @Override
    public PartidoDTO guardarNuevaPartido(PartidoDTO partidoDTO) throws Exception {
        //Validacion 1 id debe ser null
        if(partidoDTO.getId() != null){
            throw new Exception("El debe de ser nulo");
        }

        //Validacion 2 llegue al fecha inicio
        if(partidoDTO.getFecha() == null || partidoDTO.getFecha().equals("")){
            throw new Exception("La fecha debe ser no nula");
        }
        if(partidoDTO.getEstadio() == null || partidoDTO.getEstadio().equals("")){
            throw new Exception("El estadio debe ser no nula");
        }
        if(partidoDTO.getEquipolocalId() == null || partidoDTO.getEquipolocalId().equals("")){
            throw new Exception("El equipo local debe ser no nula");
        }
        if(partidoDTO.getEquipovisitanteId() == null || partidoDTO.getEquipovisitanteId().equals("")){
            throw new Exception("El equipo visitante debe ser no nula");
        }
        if(partidoDTO.getGoleslocal() == null || partidoDTO.getGoleslocal().equals("")){
            throw new Exception("Los goles local debe ser no nula");
        }
        if(partidoDTO.getGolesvisitante() == null || partidoDTO.getGolesvisitante().equals("")){
            throw new Exception("Los goles visitante debe ser no nula");
        }
        if(partidoDTO.getJornada() == null || partidoDTO.getJornada().equals("")){
            throw new Exception("La jornada debe ser no nula");
        }

        //Validacion 3 llegue al fecha fin
        if(partidoDTO.getFecha() == null || partidoDTO.getFecha().equals("")){
            throw new Exception("La fecha debe ser no nula");
        }

        if(partidoDTO.getEstadio() == null || partidoDTO.getEstadio().equals("")){
            throw new Exception("El estadio debe ser no nula");
        }

        if(partidoDTO.getEquipolocalId() == null || partidoDTO.getEquipolocalId().equals("")){
            throw new Exception("El equipo local debe ser no nula");
        }

        if(partidoDTO.getEquipovisitanteId() == null || partidoDTO.getEquipovisitanteId().equals("")){
            throw new Exception("El equipo visitante debe ser no nula");
        }

        if(partidoDTO.getGoleslocal() == null || partidoDTO.getGoleslocal().equals("")){
            throw new Exception("Los goles local debe ser no nula");
        }

        if(partidoDTO.getGolesvisitante() == null || partidoDTO.getGolesvisitante().equals("")){
            throw new Exception("Los goles visitante debe ser no nula");
        }
        if(partidoDTO.getJornada() == null || partidoDTO.getJornada().equals("")){
            throw new Exception("Los goles visitante debe ser no nula");
        }



        if(partidoDTO.getEquipolocalId() ==null){
            throw new Exception("El equipo no debe ser nulo");
        }


        Partido partido = PartidoMapper.dtoToDomain(partidoDTO);
        Equipo equipoLocal = equipoRepository.getReferenceById(partidoDTO.getEquipolocalId());

        Equipo equipoVisitante = equipoRepository.getReferenceById(partidoDTO.getEquipovisitanteId());


        if(equipoLocal == null){
            throw new Exception("El equipo local no existe");
        }

        if(equipoVisitante == null){
            throw new Exception("El equipo visitante no existe");
        }

        Jornada jornada = jornadaRepository.getReferenceById(partidoDTO.getJornada());

        if (jornada == null){
            throw new Exception("La jornada no existe");
        }


        partido.setEquipoLocal(equipoLocal);
        partido.setEquipoVisitante(equipoVisitante);
        partido.setJornada(jornada);
        partido = partidoRepository.save(partido);

        return PartidoMapper.domainToDTO(partido);

    }
}