package com.ligabtp.ligabetplay.repository.service.implementation;

import com.ligabtp.ligabetplay.domain.PartidoyArbitro;
import com.ligabtp.ligabetplay.dto.PartidoyArbitroDTO;
import com.ligabtp.ligabetplay.mapper.PartidoyArbitroMapper;
import com.ligabtp.ligabetplay.repository.PartidoyArbitroRepository;
import com.ligabtp.ligabetplay.repository.service.PartidoyArbitroService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class PartidoyArbitroServicelmpl implements PartidoyArbitroService {

    private final PartidoyArbitroRepository partidoyArbitroRepository;

    public PartidoyArbitroServicelmpl(PartidoyArbitroRepository partidoyArbitroRepository) {
        this.partidoyArbitroRepository = partidoyArbitroRepository;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public PartidoyArbitroDTO guardarNuevoPartidoyArbitro(PartidoyArbitroDTO partidoyArbitroDTO) throws Exception {
        if(partidoyArbitroDTO == null) {
            throw new Exception("El partido y arbitro no puede ser nuelo");
        }

        if(partidoyArbitroDTO.getId() == null) {
            throw new Exception("El ID de partido y arbitro no puede ser null");
        }
        if (partidoyArbitroDTO.getArbitroId() == null) {
            throw new Exception("El id del arbitro no puede ser null");
        }
        if (partidoyArbitroDTO.getPartidoId() == null) {
            throw new Exception("El id partido no puede ser null");
        }
        if (partidoyArbitroDTO.getTipoArbitro() == null) {
            throw new Exception("El tipo de arbitro no puede ser null");
        }

        PartidoyArbitro partidoyArbitro = PartidoyArbitroMapper.dtoToDomain(partidoyArbitroDTO);
        partidoyArbitro = partidoyArbitroRepository.save(partidoyArbitro);
        return PartidoyArbitroMapper.domainToDTO(partidoyArbitro);
    }

    @Override
    @Transactional(readOnly = true)
    public PartidoyArbitroDTO buscarPartidoyArbitroPorId(Integer id) throws Exception {
        if(id == null || id.equals(0)) {
            throw new Exception("El id del arbitro no puede ser null");
        }
        PartidoyArbitro partidoyArbitro = partidoyArbitroRepository.findById(id)
                .orElseThrow(() -> new Exception("No se encuentra el partido y arbitro con el id" + id));

        return PartidoyArbitroMapper.domainToDTO(partidoyArbitro);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public PartidoyArbitroDTO modificarPartidoyArbitro(PartidoyArbitroDTO partidoyArbitroDTO) throws Exception {
        if(partidoyArbitroDTO == null) {
            throw new Exception("El partido y arbitro no puede ser nuelo");
        }

        if(partidoyArbitroDTO.getId() == null) {
            throw new Exception("El ID de partido y arbitro no puede ser null");
        }
        if (partidoyArbitroDTO.getArbitroId() == null) {
            throw new Exception("El id del arbitro no puede ser null");
        }
        if (partidoyArbitroDTO.getPartidoId() == null) {
            throw new Exception("El id partido no puede ser null");
        }
        if (partidoyArbitroDTO.getTipoArbitro() == null) {
            throw new Exception("El tipo de arbitro no puede ser null");
        }

        PartidoyArbitro partidoyArbitro = PartidoyArbitroMapper.dtoToDomain(partidoyArbitroDTO);
        partidoyArbitro = partidoyArbitroRepository.save(partidoyArbitro);
        return PartidoyArbitroMapper.domainToDTO(partidoyArbitro);
    }


    @Override
    @Transactional(readOnly = true)
    public List<PartidoyArbitroDTO> obtenerPartidoyArbitros() {
        List<PartidoyArbitro> listaPartidoyArbitros = partidoyArbitroRepository.findAll();
        List<PartidoyArbitroDTO> partidoyArbitrosDTO = PartidoyArbitroMapper.domainToDTOList(listaPartidoyArbitros);
        return partidoyArbitrosDTO;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void eliminarPartidoyArbitro(Integer id) throws Exception {
        if(id == null || id.equals(0)) {
            throw new Exception("El id del arbitro no puede ser null");
        }
        //hay que completar

    }
}
