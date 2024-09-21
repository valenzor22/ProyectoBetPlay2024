package com.ligabtp.ligabetplay.controller;


import com.ligabtp.ligabetplay.domain.PartidoyArbitro;
import com.ligabtp.ligabetplay.repository.PartidoyArbitroRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/partidoyarbitro")
public class PartidoyArbitroController {

    //inyeccion independencia
    private PartidoyArbitroRepository partidoyArbitroRepository;


    public PartidoyArbitroController(PartidoyArbitroRepository partidoyArbitroRepository) {
        this.partidoyArbitroRepository = partidoyArbitroRepository;
    }


    @GetMapping(value = "/obtenerPartidoyArbitro")
    public List<PartidoyArbitro> obtenerPartidosyArbitros (){
        List<PartidoyArbitro> listaPartidosyArbitros = partidoyArbitroRepository.findAll();
        return listaPartidosyArbitros;

    }
}