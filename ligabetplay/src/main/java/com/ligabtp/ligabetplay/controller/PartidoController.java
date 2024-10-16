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
    private PartidoRepository partidoRepository;
    private PartidoService partidoService;



    public PartidoController(PartidoRepository partidoRepository) {
        this.partidoRepository = partidoRepository;
        this.partidoService = partidoService;
    }


    @GetMapping(value = "/obtenerPartido")
    public List<Partido> obtenerPartidos (){
        List<Partido> listaPartidos = partidoRepository.findAll();
        return listaPartidos;
    }

    @PostMapping (value = "guardarNuevoPartido")
    public ResponseEntity<PartidoDTO>guardarNuevoPartido(@RequestBody PartidoDTO partidoDTO) throws Exception{
        PartidoDTO partidoResponse = partidoService.guardarNuevaPartido(partidoDTO);
        return new ResponseEntity<>(partidoResponse, HttpStatus.CREATED);
    }

    @GetMapping(value = "/obtenerPartido")
    public List<PartidoDTO> obtenerPartidoList(){
        List<Partido> listaPartidos = partidoRepository.findAll();
        return PartidoMapper.domainToDTOList(listaPartidos);
    }

    @GetMapping(value = "/buscarPartidoPorId/{id}")
    public ResponseEntity<PartidoDTO> buscarPartidoPorId(@PathVariable Integer id) throws Exception{
        PartidoDTO partidoResponse = partidoService.buscarPartidoPorId(id);
        return new ResponseEntity<>(partidoResponse, HttpStatus.OK);
    }

    @PutMapping(value = "/modificarPartido")
    public ResponseEntity<PartidoDTO> modificarPartido(@RequestBody PartidoDTO partidoDTO) throws Exception{
        PartidoDTO partidoResponse = partidoService.guardarNuevaPartido(partidoDTO);
        return new ResponseEntity<>(partidoResponse, HttpStatus.CREATED);
    }
}