package com.ligabtp.ligabetplay.controller;


import com.ligabtp.ligabetplay.domain.Partido;
import com.ligabtp.ligabetplay.repository.PartidoRepository;
import com.ligabtp.ligabetplay.repository.service.PartidoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/partido")
public class PartidoController {

    //inyeccion independencia
    private PartidoRepository partidoRepository;
    private PartidoService partidoService;



    public PartidoController(PartidoRepository partidoRepository) {
        this.partidoRepository = partidoRepository;
    }


    @GetMapping(value = "/obtenerPartido")
    public List<Partido> obtenerPartidos (){
        List<Partido> listaPartidos = partidoRepository.findAll();
        return listaPartidos;

    }
}