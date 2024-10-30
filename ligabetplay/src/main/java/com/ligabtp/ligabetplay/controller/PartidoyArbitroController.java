package com.ligabtp.ligabetplay.controller;

import com.ligabtp.ligabetplay.dto.PartidoyArbitroDTO;
import com.ligabtp.ligabetplay.repository.service.PartidoyArbitroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partidoyArbitro")
public class PartidoyArbitroController {

    // Inyección de dependencias hacia PartidoyArbitroService
    private final PartidoyArbitroService partidoyArbitroService;

    public PartidoyArbitroController(PartidoyArbitroService partidoyArbitroService) {
        this.partidoyArbitroService = partidoyArbitroService;
    }

    @PostMapping("/guardarPartidoyArbitro")
    public ResponseEntity<PartidoyArbitroDTO> guardarNuevoPartidoyArbitro(@RequestBody PartidoyArbitroDTO partidoyArbitroDTO) throws Exception {
        PartidoyArbitroDTO partidoyArbitroResponse = partidoyArbitroService.guardarNuevoPartidoyArbitro(partidoyArbitroDTO);
        return new ResponseEntity<>(partidoyArbitroResponse, HttpStatus.CREATED);
    }

    @GetMapping(value = "/obtenerPartidoyArbitro")
    public List<PartidoyArbitroDTO> obtenerPartidoyArbitro() {
        return partidoyArbitroService.obtenerPartidoyArbitros();
    }

    @GetMapping("/buscarPartidoyArbitro/{id}")
    public ResponseEntity<PartidoyArbitroDTO> buscarPartidoyArbitroPorId(@PathVariable Integer id) throws Exception {
        PartidoyArbitroDTO partidoyArbitroResponse = partidoyArbitroService.buscarPartidoyArbitroPorId(id);
        return new ResponseEntity<>(partidoyArbitroResponse, HttpStatus.OK);
    }

    @PutMapping("/modificarPartidoyArbitro")
    public ResponseEntity<PartidoyArbitroDTO> modificarPartidoyArbitro(@RequestBody PartidoyArbitroDTO partidoyArbitroDTO) throws Exception {
        PartidoyArbitroDTO partidoyArbitroResponse = partidoyArbitroService.modificarPartidoyArbitro(partidoyArbitroDTO);
        return new ResponseEntity<>(partidoyArbitroResponse, HttpStatus.OK);
    }

    @DeleteMapping("/eliminarPartidoyArbitro/{id}")
    public ResponseEntity<Void> eliminarPartidoyArbitro(@PathVariable("id") Integer idPartidoyArbitro) throws Exception {
        partidoyArbitroService.eliminarPartidoyArbitro(idPartidoyArbitro);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}