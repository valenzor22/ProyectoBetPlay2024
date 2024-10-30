package com.ligabtp.ligabetplay.repository.service.implementation;

import com.ligabtp.ligabetplay.domain.Arbitro;
import com.ligabtp.ligabetplay.dto.ArbitroDTO;
import com.ligabtp.ligabetplay.mapper.ArbitroMapper;
import com.ligabtp.ligabetplay.repository.ArbitroRepository;
import com.ligabtp.ligabetplay.repository.PartidoyArbitroRepository;
import com.ligabtp.ligabetplay.repository.service.ArbitroService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


public class ArbitroServicelmpl implements ArbitroService {

    private final ArbitroRepository arbitroRepository;
    private final PartidoyArbitroRepository partidoyArbitroRepository;

    public ArbitroServicelmpl(ArbitroRepository arbitroRepository, PartidoyArbitroRepository arbitroService) {
        this.arbitroRepository = arbitroRepository;
        this.partidoyArbitroRepository = partidoyArbitroRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public ArbitroDTO buscarArbitroPorId (Integer id) throws Exception {
        if (id == null || id <= 0) {
            throw new Exception("El id de arbitro no puede estar vac io ni ser cero (0)");
        }
        Arbitro arbitro = arbitroRepository.findById(id)
                .orElseThrow(() -> new Exception("El id de arbitro no existe"));
        return ArbitroMapper.domainToDTO(arbitro);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public ArbitroDTO guardarNuevoArbitro(ArbitroDTO arbitroDTO) throws Exception {
        if(arbitroDTO == null ) {
            throw new Exception("El arbitro no puede ser nulo");
        }
        if (arbitroDTO.getId() != null) {
            throw new Exception("No debería tener ID puesto que es un Nuevo Arbitro");
        }
        if (arbitroDTO.getNombre() == null || arbitroDTO.getNombre().equals("")) {
            throw new Exception("El nombre del arbitro no puede ser nulo");
        }
        if (arbitroDTO.getApellido() == null || arbitroDTO.getApellido().equals("")) {
            throw new Exception("El apellido del arbitro no puede ser nulo");
        }
        if (arbitroDTO.getNacionalidad() == null || arbitroDTO.getNacionalidad().equals("")) {
            throw new Exception("La nacionalidad del arbitro no puede ser nulo");
        }
        if (arbitroDTO.getFechaNacimiento() == null || arbitroDTO.getFechaNacimiento().equals("")) {
            throw new Exception("La fecha de nacimiento del jugador no puede ser nulo");
        }
        Arbitro arbitro = ArbitroMapper.dtoToDomain(arbitroDTO);
        arbitro = arbitroRepository.save(arbitro);
        return ArbitroMapper.domainToDTO(arbitro);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ArbitroDTO> obtenerArbitros() {
        List<Arbitro> arbitros = arbitroRepository.findAll();
        List<ArbitroDTO> arbitroDTO = ArbitroMapper.domainToDTOList(arbitros);
        return arbitroDTO;
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
        if (arbitroDTO.getNombre() == null || arbitroDTO.getNombre().equals("")) {
            throw new Exception("El nombre del arbitro no puede ser nulo");
        }
        if (arbitroDTO.getApellido() == null || arbitroDTO.getApellido().equals("")) {
            throw new Exception("El apellido del arbitro no puede ser nulo");
        }
        if (arbitroDTO.getNacionalidad() == null || arbitroDTO.getNacionalidad().equals("")) {
            throw new Exception("La nacionalidad del arbitro no puede ser nulo");
        }
        if (arbitroDTO.getFechaNacimiento() == null || arbitroDTO.getFechaNacimiento().equals("")) {
            throw new Exception("La fecha de nacimiento del jugador no puede ser nulo");
        }
        Arbitro arbitro = ArbitroMapper.dtoToDomain(arbitroDTO);
        arbitro = arbitroRepository.save(arbitro);
        return ArbitroMapper.domainToDTO(arbitro);
    }

    @Override
    @Transactional(readOnly = true)
    public ArbitroDTO buscarArbitroPorNombre(String nombre) throws Exception {
        if (nombre == null || nombre.equals("")) {
            throw new Exception("El nombre del arbitro no puede ser nulo o vacío");
        }

        Arbitro arbitro = arbitroRepository.findByNombre(nombre)
                .orElseThrow(() -> new Exception("No se encuentra el arbitro con el nombre " + nombre));

        return ArbitroMapper.domainToDTO(arbitro);
    }

    @Override
    public void eliminarArbitro(Integer id) throws Exception {
        if(id == null || id.equals(0)) {
            throw new Exception("El id del arbitro no puede ser nulo o cero");
        }

        Boolean existeArbotro = arbitroRepository.existsById(id);
        if (existeArbotro == false) {
            throw new Exception("El arbitro no existe" + id + "por lo tanto no se puede eliminar");
        }

        Boolean existeAlgunPartidoyArbitroAlArbitro = partidoyArbitroRepository.existsByArbitroId(id);
        if (existeAlgunPartidoyArbitroAlArbitro == true) {
            throw new Exception("El arbitro con el id" + id + "tiene partido y arbitro por lo tanto no se puede eliminar");
        }
    }




}