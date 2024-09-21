package com.ligabtp.ligabetplay.controller;


import com.ligabtp.ligabetplay.domain.Jugador;
import com.ligabtp.ligabetplay.repository.JugadorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jugador")
public class JugadorController {

    //inyeccion independencia
    private JugadorRepository jugadorRepository;


    public JugadorController(JugadorRepository JugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }


    @GetMapping(value = "/obtenerJugador")
    public List<Jugador> obtenerjugador (){
        List<Jugador> listaJugador = jugadorRepository.findAll();
        return listaJugador;

}
}