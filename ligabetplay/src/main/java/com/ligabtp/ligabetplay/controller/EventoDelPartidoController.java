package com.ligabtp.ligabetplay.controller;


import com.ligabtp.ligabetplay.domain.EventoDelPartido;
import com.ligabtp.ligabetplay.dto.EventoDelPartidoDTO;
import com.ligabtp.ligabetplay.mapper.EventoDelPartidoMapper;
import com.ligabtp.ligabetplay.repository.EventoDelPartidoRepository;
import com.ligabtp.ligabetplay.repository.service.EventoDelPartidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/EventoDelPartido")
public class EventoDelPartidoController {

    //inyeccion independencia
    private EventoDelPartidoRepository eventoDelPartidoRepository;
    private EventoDelPartidoService eventoDelPartidoService;


    public EventoDelPartidoController(EventoDelPartidoRepository eventoDelPartidoRepository, EventoDelPartidoService eventoDelPartidoService) {
        this.eventoDelPartidoRepository = eventoDelPartidoRepository;
        this.eventoDelPartidoService = eventoDelPartidoService;
    }


    @GetMapping(value = "/obtenerEventoDelPartido")
    public List<EventoDelPartido> obtenerEventoDelPartido (){
        List<EventoDelPartido> listaEventoDelPartido = eventoDelPartidoRepository.findAll();
        return listaEventoDelPartido;

    }

    @PostMapping(value = "guardarNuevaEventoDelPartido")
    public ResponseEntity<EventoDelPartidoDTO> guardarNuevaEventoDelPartido(@RequestBody EventoDelPartidoDTO eventoDelPartidoDTO) throws Exception {
        EventoDelPartidoDTO eventoDelPartidoResponse = eventoDelPartidoService.guardarNuevaEventoDelPartido(eventoDelPartidoDTO);
        return new ResponseEntity<>(eventoDelPartidoResponse, HttpStatus.CREATED);

    }

    @GetMapping(value = "/obtenerEventoDelPartido")
    public List<EventoDelPartidoDTO> obtenerEventoDelPartidoList(){
        List<EventoDelPartido> listaEventoDelPartidos = eventoDelPartidoRepository.findAll();
        return EventoDelPartidoMapper.domainToDTOList(listaEventoDelPartidos);
    }

    @GetMapping(value = "/buscarEventoDelPartidoPorId/{id}")
    public ResponseEntity<EventoDelPartidoDTO> buscarEventoDelPartidoPorId(@PathVariable Integer id) throws Exception {
        EventoDelPartidoDTO eventoDelPartidoResponse = eventoDelPartidoService.buscarEventoDelPartidoPorId(id);
        return new ResponseEntity<>(eventoDelPartidoResponse, HttpStatus.OK);
    }

    @PutMapping(value = "/modificarNuevaEventoDelPartido")
    public ResponseEntity<EventoDelPartidoDTO> modificarNuevaEventoDelPartido(@RequestBody EventoDelPartidoDTO eventoDelPartidoDTO) throws Exception {
        EventoDelPartidoDTO eventoDelPartidoResponse = eventoDelPartidoService.guardarNuevaEventoDelPartido(eventoDelPartidoDTO);
        return new ResponseEntity<>(eventoDelPartidoResponse, HttpStatus.CREATED);

    }
}