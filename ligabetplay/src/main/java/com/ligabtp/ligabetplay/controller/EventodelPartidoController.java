package com.ligabtp.ligabetplay.controller;


import com.ligabtp.ligabetplay.domain.EventodelPartido;
import com.ligabtp.ligabetplay.repository.EventodelPartidoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/eventodelPartido")
public class EventodelPartidoController {

    //inyeccion independencia
    private EventodelPartidoRepository eventodelPartidoRepository;


    public EventodelPartidoController(EventodelPartidoRepository eventodelPartidoRepository) {
        this.eventodelPartidoRepository = eventodelPartidoRepository;
    }


    @GetMapping(value = "/obtenerEventodelPartido")
    public List<EventodelPartido> obtenereventodelPartido (){
        List<EventodelPartido> listaEventodelPartido = eventodelPartidoRepository.findAll();
        return listaEventodelPartido;
    }
}
