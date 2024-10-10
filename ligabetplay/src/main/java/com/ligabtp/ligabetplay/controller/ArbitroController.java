package com.ligabtp.ligabetplay.controller;

import com.ligabtp.ligabetplay.domain.Arbitro;
import com.ligabtp.ligabetplay.dto.ArbitroDTO;
import com.ligabtp.ligabetplay.mapper.ArbitroMapper;
import com.ligabtp.ligabetplay.repository.ArbitroRepository;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/arbitro")
public class ArbitroController {

    //inyeccion independencia
    private ArbitroRepository arbitroRepository;


    public ArbitroController(ArbitroRepository arbitroRepository) {
        this.arbitroRepository = arbitroRepository;
    }


    @GetMapping(value = "/obtenerArbitros")
    public List<ArbitroDTO> obtenerArbitros (){
        List<Arbitro> listaArbitros = arbitroRepository.findAll();
        List<ArbitroDTO> arbitrosDTO = ArbitroMapper.domainToDTOList(listaArbitros);
        return arbitrosDTO;

    }

    @PostMapping(value = "/crearNuevoArbitro")
    public ResponseEntity<ArbitroDTO> crearNuevoArbitro(@RequestBody ArbitroDTO arbitroDTO){

        //Convertimos el DTO que llega desde el cliente a un Entity de Arbitro
        Arbitro arbitro = ArbitroMapper.dtoToDomain(arbitroDTO);

        //Guardamos el nuesbo Arbitro haciendo uso de Repository
        arbitro = arbitroRepository.save(arbitro);

        //Convierto el pais que ya fue almacenado en DB a un objeto de tipo DTO
        ArbitroDTO arbitroDTOResponse = ArbitroMapper.domainToDTO(arbitro);

        return new ResponseEntity<>(arbitroDTOResponse, HttpStatus.CREATED);
    }
}
