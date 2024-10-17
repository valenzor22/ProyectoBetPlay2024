package com.ligabtp.ligabetplay.controller;


import com.ligabtp.ligabetplay.domain.Jornada;
import com.ligabtp.ligabetplay.dto.JornadaDTO;
import com.ligabtp.ligabetplay.mapper.JornadaMapper;
import com.ligabtp.ligabetplay.repository.JornadaRepository;
import com.ligabtp.ligabetplay.repository.service.JornadaService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jornada")
public class JornadaController {

    //inyeccion independencia
    private JornadaRepository jornadaRepository;
    private JornadaService jornadaService;


    public JornadaController(JornadaRepository jornadaRepository) {
        this.jornadaRepository = jornadaRepository;
        this.jornadaService = jornadaService;
    }


    @GetMapping(value = "/obtenerJornada")
    public List<Jornada> obtenerJornada (){
        List<Jornada> listaJornadas = jornadaRepository.findAll();
        return listaJornadas;
    }

    @PostMapping(value = "/crearNuevaJornada")
    public ResponseEntity<JornadaDTO> crearNuvaJornada (@RequestBody JornadaDTO jornadaDTO){
        Jornada jornada = JornadaMapper.dtoToDomain(jornadaDTO);
        jornada = jornadaRepository.save(jornada);
        JornadaDTO jornadaDTOResponse = JornadaMapper.domainToDTOList(jornada);
        return new ResponseEntity<>(JornadaDTOResponse, HttpStatus.CREATED);
    }
}
