package com.ligabtp.ligabetplay.controller;


import com.ligabtp.ligabetplay.domain.PartidoyArbitro;
import com.ligabtp.ligabetplay.dto.PartidoyArbitroDTO;
import com.ligabtp.ligabetplay.mapper.PartidoyArbitroMapper;
import com.ligabtp.ligabetplay.repository.PartidoyArbitroRepository;
import com.ligabtp.ligabetplay.repository.service.PartidoyArbitroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/PartidoyArbitro")
public class PartidoyArbitroController {

    //inyeccion independencia
    private final PartidoyArbitroService partidoyArbitroService;


    public PartidoyArbitroController(PartidoyArbitroService partidoyArbitroService) {
       this.partidoyArbitroService = partidoyArbitroService;
    }

    @PostMapping(value = "guardarNuevoPartidoyArbitro")
    public ResponseEntity<PartidoyArbitroDTO> guardarNuevoPartidoyArbitro(@RequestBody PartidoyArbitroDTO partidoyArbitroDTO) throws Exception {
        PartidoyArbitroDTO partidoyArbitroResponse = partidoyArbitroService.guardarNuevoPartidoyArbitro(partidoyArbitroDTO);
        return new ResponseEntity<>(partidoyArbitroResponse, HttpStatus.CREATED);
    }

    @GetMapping(value = "/obtenerPartidoyArbitro")
     public List<PartidoyArbitroDTO> obtenerPartidoyArbitro() {
        return partidoyArbitroService.obtenerPartidoyArbitros();
    }


    @GetMapping(value = "/buscarPartidoyArbitroPorId/{id}")
    public ResponseEntity<PartidoyArbitroDTO> buscarPartidoyArbitroPorId(@PathVariable Integer id) throws Exception {
        PartidoyArbitroDTO partidoyArbitroResponse = partidoyArbitroService.buscarPartidoyArbitroPorId(id);
        return new ResponseEntity<>(partidoyArbitroResponse, HttpStatus.OK);
    }

    @PutMapping(value = "/modificarNuevoPartidoyArbitro")
    public ResponseEntity<PartidoyArbitroDTO> modificarNuevoPartidoyArbitro(@RequestBody PartidoyArbitroDTO partidoyArbitroDTO) throws Exception {
        PartidoyArbitroDTO partidoyArbitroResponse = partidoyArbitroService.guardarNuevoPartidoyArbitro(partidoyArbitroDTO);
        return new ResponseEntity<>(partidoyArbitroResponse, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/eliminarPartidoyArbitro/{id}")
    public ResponseEntity<String> eliminarPartidoyArbitro(@PathVariable ("id") Integer idPartidoyArbitro) throws Exception {
        partidoyArbitroService.eliminarPartidoyArbitro(idPartidoyArbitro);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}