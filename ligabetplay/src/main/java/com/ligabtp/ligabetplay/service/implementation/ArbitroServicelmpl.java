package com.ligabtp.ligabetplay.service.implementation;

import com.ligabtp.ligabetplay.domain.Arbitro;
import com.ligabtp.ligabetplay.dto.ArbitroDTO;
import com.ligabtp.ligabetplay.mapper.ArbitroMapper;
import com.ligabtp.ligabetplay.repository.ArbitroRepository;
import com.ligabtp.ligabetplay.repository.PartidoyArbitroRepository;
import com.ligabtp.ligabetplay.service.ArbitroService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.Date;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class ArbitroServicelmpl implements ArbitroService {

    private final ArbitroRepository arbitroRepository;
    private PartidoyArbitroRepository partidoyArbitroRepository = null;

    public ArbitroServicelmpl(ArbitroRepository arbitroRepository, PartidoyArbitroRepository partidoyArbitroRepository) {
        this.arbitroRepository = arbitroRepository;
        this.partidoyArbitroRepository = partidoyArbitroRepository;
    }


    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public ArbitroDTO guardarNuevoArbitro(ArbitroDTO arbitroDTO) throws Exception {
        if(arbitroDTO == null) {
            throw new Exception("El arbitro no puede ser nulo");
        }
        if (arbitroDTO.getId() != null) {
            throw new Exception("No debería tener ID puesto que es un Nuevo Arbitro");
        }
        if (arbitroDTO.getNombre() == null || arbitroDTO.getNombre().isEmpty()) {
            throw new Exception("El nombre del arbitro no puede ser nulo");
        }
        if (arbitroDTO.getApellido() == null || arbitroDTO.getApellido().isEmpty()) {
            throw new Exception("El apellido del arbitro no puede ser nulo");
        }
        if (arbitroDTO.getNacionalidad() == null || arbitroDTO.getNacionalidad().isEmpty()) {
            throw new Exception("La nacionalidad del arbitro no puede ser nulo");
        }
        if (arbitroDTO.getFechaNacimiento() == null || arbitroDTO.getFechaNacimiento().after(new Date())) {
            throw new Exception("La fecha de nacimiento del jugador no puede ser nulo, ni puede ser posterior a la fecha actual");
        }
        Arbitro arbitro = ArbitroMapper.dtoToDomain(arbitroDTO);
        arbitro = arbitroRepository.save(arbitro);
        return ArbitroMapper.domainToDTO(arbitro);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ArbitroDTO> obtenerArbitros() {
        List<Arbitro> arbitros = arbitroRepository.findAll();
        return ArbitroMapper.domainToDTOList(arbitros);
    }


    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public ArbitroDTO modificarArbitro(ArbitroDTO arbitroDTO) throws Exception {
        if(arbitroDTO == null ) {
            throw new Exception("El arbitro no puede ser nulo");
        }
        if (arbitroDTO.getId() != null) {
            throw new Exception("No debería tener ID puesto que es un Nuevo Arbitro");
        }
        if (arbitroDTO.getNombre() == null || arbitroDTO.getNombre().isEmpty()) {
            throw new Exception("El nombre del arbitro no puede ser nulo");
        }
        if (arbitroDTO.getApellido() == null || arbitroDTO.getApellido().isEmpty()) {
            throw new Exception("El apellido del arbitro no puede ser nulo");
        }
        if (arbitroDTO.getNacionalidad() == null || arbitroDTO.getNacionalidad().isEmpty()) {
            throw new Exception("La nacionalidad del arbitro no puede ser nulo");
        }
        if (arbitroDTO.getFechaNacimiento() == null || arbitroDTO.getFechaNacimiento().after(new Date())) {
            throw new Exception("La fecha de nacimiento del jugador no puede ser nulo, ni puede ser posterior a la fecha de hoy");
        }
        Arbitro arbitro = ArbitroMapper.dtoToDomain(arbitroDTO);
        arbitro = arbitroRepository.save(arbitro);
        return ArbitroMapper.domainToDTO(arbitro);
    }

    @Override
    @Transactional(readOnly = true)
    public ArbitroDTO buscarArbitroPorNombre(String nombre) throws Exception {
        if (id == null) {
            throw new Exception("El id del arbitro no puede ser nulo o vacío");
        }

        Arbitro arbitro = (Arbitro) arbitroRepository.findByNombre(nombre)
                .orElseThrow(() -> new Exception("No se encuentra el arbitro con el nombre " + nombre));

        return ArbitroMapper.domainToDTO(arbitro);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void eliminarArbitro(Integer id) throws Exception {
        if(id == null) {
            throw new Exception("El id del arbitro no puede ser nulo o cero");
        }

        boolean existeArbitro = arbitroRepository.existsById(id);
        if (!existeArbitro) {
            throw new Exception("El arbitro no existe" + id + "por lo tanto no se puede eliminar");
        }

        boolean existeAlgunPartidoyArbitroAlArbitro = partidoyArbitroRepository.existsByArbitroId(id);
        if (!existeAlgunPartidoyArbitroAlArbitro) {
            throw new Exception("El arbitro con el id" + id + "tiene partido y arbitro por lo tanto no se puede eliminar");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public ArbitroDTO buscarArbitroPorId(Integer id) throws Exception{
        if(id == null || id.equals(0)) {
            throw new Exception("No ha llegado el id para buscar el Árbitro");
        }

        Arbitro arbitro = arbitroRepository.getReferenceById(id);

        return ArbitroMapper.domainToDTO(arbitro);
    }


}