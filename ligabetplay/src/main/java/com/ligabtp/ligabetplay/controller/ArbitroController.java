package com.ligabtp.ligabetplay.controller;

import com.ligabtp.ligabetplay.domain.Arbitro;
import com.ligabtp.ligabetplay.dto.ArbitroDTO;
import com.ligabtp.ligabetplay.mapper.ArbitroMapper;
import com.ligabtp.ligabetplay.repository.ArbitroRepository;
import com.ligabtp.ligabetplay.repository.service.ArbitroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/arbitro")
public class ArbitroController {

    //inyeccion independencia
    private ArbitroRepository arbitroRepository;
    private ArbitroService arbitroService;


    public ArbitroController(ArbitroRepository arbitroRepository) {
        this.arbitroRepository = arbitroRepository;
        this.arbitroService = arbitroService;
    }


    @GetMapping(value = "/obtenerArbitros")
    public List<ArbitroDTO> obtenerArbitros (){
        List<Arbitro> listaArbitros = arbitroRepository.findAll();
        List<ArbitroDTO> arbitrosDTO = ArbitroMapper.domainToDTOList(listaArbitros);
        return arbitrosDTO;

    }

    @PostMapping(value = "/crearNuevoArbitro")
    public ResponseEntity<ArbitroDTO> crearNuevoArbitro(@RequestBody ArbitroDTO arbitroDTO){
        Arbitro arbitro = ArbitroMapper.dtoToDomain(arbitroDTO);
        arbitro = arbitroRepository.save(arbitro);
        ArbitroDTO arbitroDTOResponse = ArbitroMapper.domainToDTO(arbitro);
        return new ResponseEntity<>(arbitroDTOResponse, HttpStatus.CREATED);
    }
}
