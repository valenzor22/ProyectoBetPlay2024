package com.ligabtp.ligabetplay.controller;


import com.ligabtp.ligabetplay.domain.TablaDePosicion;
import com.ligabtp.ligabetplay.dto.TablaDePosicionDTO;
import com.ligabtp.ligabetplay.mapper.TablaDePosicionMapper;
import com.ligabtp.ligabetplay.repository.TablaDePosicionRepository;
import com.ligabtp.ligabetplay.repository.service.TablaDePosicionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/TablaDePosicion")
public class TablaDePosicionController {

    //inyeccion independencia
    private TablaDePosicionRepository tablaDePosicionRepository;
    private TablaDePosicionService tablaDePosicionService;


    public TablaDePosicionController(TablaDePosicionRepository tablaDePosicionRepository, TablaDePosicionService tablaDePosicionService) {
        this.tablaDePosicionRepository = tablaDePosicionRepository;
        this.tablaDePosicionService = tablaDePosicionService;
    }


    @GetMapping(value = "/obtenerTablaDePosicion")
    public List<TablaDePosicion> obtenerTablaDePosicion (){
        List<TablaDePosicion> listaTablaDePosicion = tablaDePosicionRepository.findAll();
        return listaTablaDePosicion;

    }

    @PostMapping(value = "guardarNuevaTablaDePosicion")
    public ResponseEntity<TablaDePosicionDTO> guardarNuevaTablaDePosicion(@RequestBody TablaDePosicionDTO tablaDePosicionDTO) throws Exception {
        TablaDePosicionDTO tablaDePosicionResponse = tablaDePosicionService.guardarNuevaTablaDePosicion(tablaDePosicionDTO);
        return new ResponseEntity<>(tablaDePosicionResponse, HttpStatus.CREATED);

    }

    @GetMapping(value = "/obtenerTablaDePosicion")
    public List<TablaDePosicionDTO> obtenerTablaDePosicionList(){
        List<TablaDePosicion> listaTablaDePosiciones = tablaDePosicionRepository.findAll();
        return TablaDePosicionMapper.domainToDTOList(listaTablaDePosiciones);
    }

    @GetMapping(value = "/buscarTablaDePosicionPorId/{id}")
    public ResponseEntity<TablaDePosicionDTO> buscarTablaDePosicionPorId(@PathVariable Integer id) throws Exception {
        TablaDePosicionDTO tablaDePosicionResponse = tablaDePosicionService.buscarTablaDePosicionPorId(id);
        return new ResponseEntity<>(tablaDePosicionResponse, HttpStatus.OK);
    }

    @PutMapping(value = "/modificarNuevaTablaDePosicion")
    public ResponseEntity<TablaDePosicionDTO> modificarNuevaTablaDePosicion(@RequestBody TablaDePosicionDTO tablaDePosicionDTO) throws Exception {
        TablaDePosicionDTO tablaDePosicionResponse = tablaDePosicionService.guardarNuevaTablaDePosicion(tablaDePosicionDTO);
        return new ResponseEntity<>(tablaDePosicionResponse, HttpStatus.CREATED);

    }
}