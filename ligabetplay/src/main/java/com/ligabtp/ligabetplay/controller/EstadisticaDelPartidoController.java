package com.ligabtp.ligabetplay.controller;

import com.ligabtp.ligabetplay.dto.EstadisticaDelPartidoDTO;
import com.ligabtp.ligabetplay.service.EstadisticaDelPartidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estadisticaDelPartido")
public class EstadisticaDelPartidoController {

    //inyeccion independencia
    private final EstadisticaDelPartidoService estadisticaDelPartidoService;


    public EstadisticaDelPartidoController(EstadisticaDelPartidoService estadisticaDelPartidoService) {
        this.estadisticaDelPartidoService = estadisticaDelPartidoService;
    }

    @PostMapping(value = "/guardarEstadisticadelPartido")
    public ResponseEntity<EstadisticaDelPartidoDTO> guardarEstadisticadelPartido(@RequestBody EstadisticaDelPartidoDTO estadisticaDelPartidoDTO) throws Exception {
        EstadisticaDelPartidoDTO estadisticasDelPartidoResponse = estadisticaDelPartidoService.guardarNuevaEstadisticaDelPartido(estadisticaDelPartidoDTO);
        return new ResponseEntity<>(estadisticasDelPartidoResponse, HttpStatus.CREATED);
    }

    @GetMapping(value = "/obtenerEstadisticadelPartido")
    public List<EstadisticaDelPartidoDTO> obtenerestadisticaDelPartido (){
        return estadisticaDelPartidoService.obtenerEstadisticadelPartidos();
    }


   @GetMapping(value = "buscarEstadisticaDelPartidoPorId/{id}")
   public ResponseEntity<EstadisticaDelPartidoDTO> obtenerEstadisticaDelPartidoPorId(@PathVariable Integer id)throws Exception{
       EstadisticaDelPartidoDTO estadisticaDelPartidoDTO = estadisticaDelPartidoService.buscarEstadisticaDelPartidoPorId(id);
       return new ResponseEntity<>(estadisticaDelPartidoDTO, HttpStatus.OK);
   }

    @PutMapping(value = "/modificarEstadisticadelPartidos")
    public ResponseEntity<EstadisticaDelPartidoDTO> modificarEstadisticaDelPartido(@RequestBody EstadisticaDelPartidoDTO estadisticaDelPartidoDTO) throws Exception {
        EstadisticaDelPartidoDTO estadisticaDelPartidoResponse = estadisticaDelPartidoService.modificarNuevaEstadisticaDelPartido(estadisticaDelPartidoDTO);
        return new ResponseEntity<>(estadisticaDelPartidoResponse, HttpStatus.OK);
    }

    @DeleteMapping(value = "/eliminarEstadisticaDelPartido/{id}")
    public ResponseEntity<EstadisticaDelPartidoDTO> eliminarNuevaEstadisticaDelPartido(@PathVariable ("id") Integer idEstadisticaDelPartido) throws Exception {
        estadisticaDelPartidoService.eliminarEstadisticaDelPartido(idEstadisticaDelPartido);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
