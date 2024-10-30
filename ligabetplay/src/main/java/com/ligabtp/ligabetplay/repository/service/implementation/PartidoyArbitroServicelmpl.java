package com.ligabtp.ligabetplay.repository.service.implementation;

import com.ligabtp.ligabetplay.domain.PartidoyArbitro;
import com.ligabtp.ligabetplay.dto.PartidoyArbitroDTO;
import com.ligabtp.ligabetplay.mapper.PartidoyArbitroMapper;
import com.ligabtp.ligabetplay.repository.ArbitroRepository;
import com.ligabtp.ligabetplay.repository.PartidoRepository;
import com.ligabtp.ligabetplay.repository.PartidoyArbitroRepository;
import com.ligabtp.ligabetplay.repository.service.ArbitroService;
import com.ligabtp.ligabetplay.repository.service.PartidoyArbitroService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
public class PartidoyArbitroServicelmpl implements PartidoyArbitroService {

    private final PartidoyArbitroRepository partidoyArbitroRepository;
    private final ArbitroRepository arbitroRepository;
    private final PartidoRepository partidoRepository;

    public PartidoyArbitroServicelmpl(PartidoyArbitroRepository partidoyArbitroRepository ,ArbitroRepository arbitroRepository, PartidoRepository partidoRepository) {
        this.partidoyArbitroRepository = partidoyArbitroRepository;
        this.arbitroRepository = arbitroRepository;
        this.partidoRepository = partidoRepository;
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
        if (id == null || id.equals(0)) {
            throw new Exception("El id de PartidoyArbitro no puede ser nulo o cero");
        }

        // Validar la existencia del PartidoyArbitro
        if (!partidoyArbitroRepository.existsById(id)) {
            throw new Exception("No existe el PartidoyArbitro con el id " + id);
        }

        // Validar que no tenga partidos o árbitros asociados
        if (partidoyArbitroRepository.existsIdPartidos(id)) {
            throw new Exception("El PartidoyArbitro con id " + id + " tiene partidos asociados, no se puede eliminar");
        }
        if (partidoyArbitroRepository.existsIdArbitro(id)) {
            throw new Exception("El PartidoyArbitro con id " + id + " tiene árbitros asociados, no se puede eliminar");
        }

        partidoyArbitroRepository.deleteById(id);
    }
}

