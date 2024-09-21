package com.ligabtp.ligabetplay.controller;

import com.ligabtp.ligabetplay.domain.Arbitro;
import com.ligabtp.ligabetplay.repository.ArbitroRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Arbitro> obtenerArbitros (){
        List<Arbitro> listaArbitros = arbitroRepository.findAll();
        return listaArbitros;


    }
}
