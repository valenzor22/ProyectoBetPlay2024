package com.ligabtp.ligabetplay.controller;


import com.ligabtp.ligabetplay.domain.TipoEvento;
import com.ligabtp.ligabetplay.dto.ArbitroDTO;
import com.ligabtp.ligabetplay.dto.TipoEventoDTO;
import com.ligabtp.ligabetplay.mapper.ArbitroMapper;
import com.ligabtp.ligabetplay.mapper.TipoEventoMapper;
import com.ligabtp.ligabetplay.repository.TipoEventoRepository;
import com.ligabtp.ligabetplay.repository.service.TipoEventoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipoEvento")
public class TipoEventoController {

    //inyeccion independencia
    private TipoEventoRepository tipoEventoRepository;
    private TipoEventoService tipoEventoService;


    public TipoEventoController(TipoEventoRepository tipoEventoRepository) {
        this.tipoEventoRepository = tipoEventoRepository;
        this.tipoEventoService = tipoEventoService;
    }


    @GetMapping(value = "/obtenerTipoEventos")
    public List<TipoEventoDTO> obtenerTipoEventos(){
        List<TipoEvento> listaTipoEventos = tipoEventoRepository.findAll();
        List<TipoEventoDTO> tipoEventosDTO = TipoEventoMapper.domainToDTOList(listaTipoEventos);
        return tipoEventosDTO;

    }

    @PostMapping(value = "/crearNuevoTipoEvento")
    public ResponseEntity<TipoEventoDTO> creaTipoEvento(@RequestBody TipoEventoDTO tipoEventoDTO){
        TipoEvento tipoEvento = TipoEventoMapper.dtoToDomain(tipoEventoDTO);
        tipoEvento = tipoEventoRepository.save(tipoEvento);
        TipoEventoDTO tipoEventoDTOResponse = TipoEventoMapper.domainToDTO(tipoEvento);
        return new ResponseEntity<>(tipoEventoDTOResponse, HttpStatus.CREATED);
    }
}