package com.ligabtp.ligabetplay.controller;


import com.ligabtp.ligabetplay.dto.TablaDePosicionDTO;
import com.ligabtp.ligabetplay.service.TablaDePosicionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/TablaDePosicion")
public class TablaDePosicionController {

    //inyeccion independencia
    private final TablaDePosicionService tablaDePosicionService;


    public TablaDePosicionController(TablaDePosicionService tablaDePosicionService) {
        this.tablaDePosicionService = tablaDePosicionService;
    }

    @PostMapping(value = "/guardarTablaDePosicion")
    public ResponseEntity<TablaDePosicionDTO> guardarNuevaTablaDePosicion(@RequestBody TablaDePosicionDTO tablaDePosicionDTO) throws Exception {
        TablaDePosicionDTO tablaDePosicionResponse = tablaDePosicionService.guardarNuevaTablaDePosicion(tablaDePosicionDTO);
        return new ResponseEntity<>(tablaDePosicionResponse, HttpStatus.CREATED);

    }

    @GetMapping(value = "/obtenerTablaDePosicion")
    public List<TablaDePosicionDTO> obtenerTablaDePosicion (){
        return tablaDePosicionService.obtenerTablaDePosiciones();

    }

    @GetMapping(value = "/buscarTablaDePosicionPorId/{id}")
    public ResponseEntity<TablaDePosicionDTO> buscarTablaDePosicionPorId(@PathVariable Integer id) throws Exception {
        TablaDePosicionDTO tablaDePosicionResponse = tablaDePosicionService.buscarTablaDePosicionPorId(id);
        return new ResponseEntity<>(tablaDePosicionResponse, HttpStatus.OK);
    }

    @PutMapping(value = "/modificarNuevaTablaDePosicion")
    public ResponseEntity<TablaDePosicionDTO> modificarNuevaTablaDePosicion(@RequestBody TablaDePosicionDTO tablaDePosicionDTO) throws Exception {
        TablaDePosicionDTO tablaDePosicionResponse = tablaDePosicionService.guardarNuevaTablaDePosicion(tablaDePosicionDTO);
        return new ResponseEntity<>(tablaDePosicionResponse, HttpStatus.OK);
    }

    @DeleteMapping(value = "/eliminarTablaDePosicion/{id}")
    public ResponseEntity<TablaDePosicionDTO> eliminarTablaDePosicion(@PathVariable ("id") Integer idTablaDePosicion) throws Exception {
        tablaDePosicionService.eliminarTablaDePosicion(idTablaDePosicion);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}