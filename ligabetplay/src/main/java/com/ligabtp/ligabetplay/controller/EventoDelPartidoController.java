package com.ligabtp.ligabetplay.controller;


import com.ligabtp.ligabetplay.dto.EventoDelPartidoDTO;
import com.ligabtp.ligabetplay.repository.service.EventoDelPartidoService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/eventoDelPartido")
public class EventoDelPartidoController {

    //inyeccion independencia
    private EventoDelPartidoService eventoDelPartidoService;


    public EventoDelPartidoController() {
        this.eventoDelPartidoService = eventoDelPartidoService;
    }


    @PostMapping(value = "/guardaeEventoDelPartido")
    public ResponseEntity<EventoDelPartidoDTO> guardarEventoDelPartido(@RequestBody EventoDelPartidoDTO eventoDelPartidoDTO) throws Exception {
        EventoDelPartidoDTO eventoDelPartidoResponse = eventoDelPartidoService.guardarNuevoEventoDelPartido(eventoDelPartidoDTO);
        return new ResponseEntity<>(eventoDelPartidoResponse, HttpStatus.CREATED);
    }

    @GetMapping(value = "/obtenerEventoDelPartido")
    public List<EventoDelPartidoDTO> obtenereventoDelPartido() {
       return eventoDelPartidoService.obtenerEventoDelPartidos();
    }

    @GetMapping(value = "/buscarEventoDelPartidoPorId/{id}")
    public ResponseEntity<EventoDelPartidoDTO> buscarEventoDelPartidoPorId(@PathVariable Integer id) throws Exception {
        EventoDelPartidoDTO eventoDelPartidoDTO = eventoDelPartidoService.buscarEventoDelPartidoPorId(id);
        return new ResponseEntity<>(eventoDelPartidoDTO, HttpStatus.OK);
    }

    @PutMapping(value = "/modificarEventoDelPartido")
    public ResponseEntity<EventoDelPartidoDTO> modificarEventoDelPartido(@RequestBody EventoDelPartidoDTO eventoDelPartidoDTO) throws Exception {
        EventoDelPartidoDTO eventoDelPartidoResponse = eventoDelPartidoService.modificarEventoDelPartido(eventoDelPartidoDTO);
        return new ResponseEntity<>(eventoDelPartidoResponse, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/eliminarEventoDelPartido/{id}")
    public ResponseEntity<Object> eliminarEventoDelPartido(@PathVariable("id") Integer idEventoDelPartido) throws Exception {
        eventoDelPartidoService.eliminarEventoDelPartido(idEventoDelPartido);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}