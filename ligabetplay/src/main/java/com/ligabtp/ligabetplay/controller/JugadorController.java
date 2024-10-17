package com.ligabtp.ligabetplay.controller;


import com.ligabtp.ligabetplay.domain.Jugador;
import com.ligabtp.ligabetplay.dto.JugadorDTO;
import com.ligabtp.ligabetplay.mapper.JugadorMapper;
import com.ligabtp.ligabetplay.repository.JugadorRepository;
import com.ligabtp.ligabetplay.repository.service.JugadorService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jugador")
public class JugadorController {

    //inyeccion independencia
    private JugadorRepository jugadorRepository;
    private JugadorService jugadorService;


    public JugadorController(JugadorRepository JugadorRepository) {
        this.jugadorRepository = jugadorRepository;
        this.jugadorService = jugadorService;
    }


    @GetMapping(value = "/obtenerJugador")
    public List<Jugador> obtenerjugador (){
        List<Jugador> listaJugador = jugadorRepository.findAll();
        return listaJugador;
    }

    @PostMapping (value = "/crearNuevoJugador")
    public ResponseEntity<JugadorDTO> crearNuevoJugador (@RequestBody JugadorDTO jugadorDTO){
        Jugador jugador = JugadorMapper.dtoToDomain(jugadorDTO);
        jugador = jugadorRepository.save(jugador);
        JugadorDTO jugadorDTOResponse = JugadorMapper.domainToDTO(jugador);
        return new ResponseEntity<>(jugadorDTOResponse, HttpStatus.CREATED);
    }
}