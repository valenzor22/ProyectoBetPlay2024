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


    @GetMapping(value = "/obtenerEventoDelPartido")
    public List<EventoDelPartidoDTO> obtenereventoDelPartido() {
       return eventoDelPartidoService.obtenerEventoDelPartido();
    }

    @PostMapping(value = "/crearNuevoEventoDelPartido")
    public ResponseEntity<EventoDelPartidoDTO> crearNuevoEventoDelPartido(@RequestBody EventoDelPartidoDTO eventoDelPartidoDTO) throws Exception {
        EventoDelPartidoDTO eventoDelPartidoResponse = eventoDelPartidoService.guardarNuevoEventoDelPartido(eventoDelPartidoDTO);
        return new ResponseEntity<>(eventoDelPartidoResponse, HttpStatus.CREATED);
    }


    @GetMapping(value = "/buscarEventoDelPartidoPorId/{id}")
    public ResponseEntity<EventoDelPartidoDTO> buscarEventoDelPartidoPorId(@PathVariable("id") Integer id) throws Exception {
        EventoDelPartidoDTO eventoDelPartidoDTO = EventoDelPartidoService.buscarEventoDelPartidoPorId(id);
        return new ResponseEntity<>(eventoDelPartidoDTO, HttpStatus.OK);
    }


    @PutMapping(value = "/modificarEventoDelPartido")
    public ResponseEntity<EventoDelPartidoDTO> modificarEventoDelPartido(@RequestBody EventoDelPartidoDTO eventoDelPartidoDTO) throws Exception {
        EventoDelPartidoDTO eventoDelPartidoResponse = eventoDelPartidoService.modificarEventoDelPartido(eventoDelPartidoDTO);
        return new ResponseEntity<>(eventoDelPartidoResponse, HttpStatus.CREATED);
    }

    @GetMapping(value = "/buscarEventoDelPartidoPorNombre/{nombre}")
    public ResponseEntity<EventoDelPartidoDTO> buscarEventoDelPartidoPorNombre(@PathVariable("nombre") String nombre) throws Exception {
        EventoDelPartidoDTO eventoDelPartidoDTO = eventoDelPartidoService.buscarEventoDelPartidoPorNombre(nombre);
        return new ResponseEntity<>(eventoDelPartidoDTO, HttpStatus.OK);
}
}