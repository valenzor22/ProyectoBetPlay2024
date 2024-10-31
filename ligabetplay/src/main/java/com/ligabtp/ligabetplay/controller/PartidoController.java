package com.ligabtp.ligabetplay.controller;

import com.ligabtp.ligabetplay.dto.PartidoDTO;
import com.ligabtp.ligabetplay.service.PartidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partido")
public class PartidoController {

    // Inyección de dependencias hacia PartidoService
    private final PartidoService partidoService;

    public PartidoController(PartidoService partidoService) {
        this.partidoService = partidoService;
    }

    @PostMapping(value = "/guardarNuevoPartido")
    public ResponseEntity<PartidoDTO> guardarNuevoPartido(@RequestBody PartidoDTO partidoDTO) throws Exception {
        PartidoDTO partidoResponse = partidoService.guardarNuevoPartido(partidoDTO);
        return new ResponseEntity<>(partidoResponse, HttpStatus.CREATED);
    }

    @GetMapping(value = "/obtenerPartidos")
    public List<PartidoDTO> obtenerPartidos() {
        return partidoService.obtenerPartidos();
    }

    @GetMapping(value = "/buscarPartidoPorId/{id}")
    public ResponseEntity<PartidoDTO> buscarPartidoPorId(@PathVariable Integer id) throws Exception {
        PartidoDTO partidoResponse = partidoService.buscarPartidoPorId(id);
        return new ResponseEntity<>(partidoResponse, HttpStatus.OK);
    }

    @PutMapping(value = "/modificarPartido")
    public ResponseEntity<PartidoDTO> modificarPartido(@RequestBody PartidoDTO partidoDTO) throws Exception {
        PartidoDTO partidoResponse = partidoService.modificarPartido(partidoDTO);
        return new ResponseEntity<>(partidoResponse, HttpStatus.OK);
    }

    @DeleteMapping(value = "/eliminarPartido/{id}")
    public ResponseEntity<Void> eliminarPartido(@PathVariable("id") Integer idPartido) throws Exception {
        partidoService.eliminarPartido(idPartido);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}