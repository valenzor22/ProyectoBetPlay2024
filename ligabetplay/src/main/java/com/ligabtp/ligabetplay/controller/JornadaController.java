package com.ligabtp.ligabetplay.controller;


import com.ligabtp.ligabetplay.domain.Jornada;
import com.ligabtp.ligabetplay.repository.JornadaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jornada")
public class JornadaController {

    //inyeccion independencia
    private JornadaRepository jornadaRepository;


    public JornadaController(JornadaRepository jornadaRepository) {
        this.jornadaRepository = jornadaRepository;
    }


    @GetMapping(value = "/obtenerJornada")
    public List<Jornada> obtenerJornada (){
        List<Jornada> listaJornadas = jornadaRepository.findAll();
        return listaJornadas;
    }
}
