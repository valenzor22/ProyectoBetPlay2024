package com.ligabtp.ligabetplay.controller;


import com.ligabtp.ligabetplay.domain.Partido;
import com.ligabtp.ligabetplay.dto.PartidoDTO;
import com.ligabtp.ligabetplay.mapper.PartidoMapper;
import com.ligabtp.ligabetplay.repository.PartidoRepository;
import com.ligabtp.ligabetplay.repository.service.PartidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partido")
public class PartidoController {

    //inyeccion independencia
    private final PartidoService partidoService;


    public PartidoController(PartidoRepository partidoRepository) {
        this.partidoService = partidoService;
    }


    @PostMapping (value = "guardarNuevoPartido")
    public ResponseEntity<PartidoDTO>guardarNuevoPartido(@RequestBody PartidoDTO partidoDTO) throws Exception{
        PartidoDTO partidoResponse = partidoService.guardarNuevoPartido(partidoDTO);
        return new ResponseEntity<>(partidoResponse, HttpStatus.CREATED);
    }

    @GetMapping(value = "/obtenerPartido")
    public List<PartidoDTO> obtenerPartidos(){
        return partidoService.obtenerPartidos();
    }

    @GetMapping(value = "/buscarPartidoPorId/{id}")
    public ResponseEntity<PartidoDTO> buscarPartidoPorId(@PathVariable Integer id) throws Exception{
        PartidoDTO partidoResponse = partidoService.buscarPartidoPorId(id);
        return new ResponseEntity<>(partidoResponse, HttpStatus.OK);
    }

    @PutMapping(value = "/modificarPartido")
    public ResponseEntity<PartidoDTO> modificarPartido(@RequestBody PartidoDTO partidoDTO) throws Exception{
        PartidoDTO partidoResponse = partidoService.modificarPartido(partidoDTO);
        return new ResponseEntity<>(partidoResponse, HttpStatus.CREATED);
    }
}

@DeleteMapping(value = "/eliminarPartido/{id}")
public ResponseEntity<PartidoDTO> eliminarPartido(@PathVariable ("id") Integer idPartido) throws Exception{
    partidoService.eliminarPartido(idPartido);
    return new ResponseEntity<>(new PartidoDTO(), HttpStatus.OK);
}
}