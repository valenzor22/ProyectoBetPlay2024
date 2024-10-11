package com.ligabtp.ligabetplay.controller;


import com.ligabtp.ligabetplay.domain.EventoDelPartido;
import com.ligabtp.ligabetplay.repository.EventoDelPartidoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/eventoDelPartido")
public class EventoDelPartidoController {

    //inyeccion independencia
    private EventoDelPartidoRepository eventoDelPartidoRepository;


    public EventoDelPartidoController(EventoDelPartidoRepository eventoDelPartidoRepository) {
        this.eventoDelPartidoRepository = eventoDelPartidoRepository;
    }


    @GetMapping(value = "/obtenerEventoDelPartido")
    public List<EventoDelPartido> obtenereventoDelPartido (){
        List<EventoDelPartido> listaEventoDelPartido = eventoDelPartidoRepository.findAll();
        return listaEventoDelPartido;
    }
}
