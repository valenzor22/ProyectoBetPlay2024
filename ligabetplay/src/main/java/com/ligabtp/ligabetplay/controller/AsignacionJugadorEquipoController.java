package com.ligabtp.ligabetplay.controller;

import com.ligabtp.ligabetplay.dto.AsignacionJugadorEquipoDTO;
import com.ligabtp.ligabetplay.repository.service.AsignacionJugadorEquipoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/AsignacionJugadorEquipo")
public class AsignacionJugadorEquipoController {

    //inyeccion independencia
    private final AsignacionJugadorEquipoService asignacionJugadorEquipoService;


    public AsignacionJugadorEquipoController(AsignacionJugadorEquipoService asignacionJugadorEquipoService) {
        this.asignacionJugadorEquipoService = asignacionJugadorEquipoService;
    }

    @PostMapping(value = "/guardarNuevaAsignacionJugadorEquipo")
    public ResponseEntity<AsignacionJugadorEquipoDTO> guardarNuevaAsignacionJugadorEquipo(@RequestBody AsignacionJugadorEquipoDTO asignacionJugadorEquipoDTO) throws Exception {
        AsignacionJugadorEquipoDTO asignacionJugadorEquipoResponse = asignacionJugadorEquipoService.guardarNuevaAsignacionJugadorEquipo(asignacionJugadorEquipoDTO);
        return new ResponseEntity<>(asignacionJugadorEquipoResponse, HttpStatus.CREATED);

    }

    @GetMapping(value = "/obtenerAsignacionJugadorEquipo")
    public List<AsignacionJugadorEquipoDTO> obtenerAsignacionJugadorEquipo (){
        return asignacionJugadorEquipoService.obtenerAsignacionJugadorEquipos();

    }

    @GetMapping(value = "/buscarAsignacionJugadorEquipoPorId/{id}")
    public ResponseEntity<AsignacionJugadorEquipoDTO> buscarAsignacionJugadorEquipoPorId(@PathVariable Integer id) throws Exception {
        AsignacionJugadorEquipoDTO asignacionJugadorEquipoResponse = asignacionJugadorEquipoService.buscarAsignacionJugadorEquipoPorId(id);
        return new ResponseEntity<>(asignacionJugadorEquipoResponse, HttpStatus.OK);
    }

    @PutMapping(value = "/modificarNuevaAsignacionJugadorEquipo")
    public ResponseEntity<AsignacionJugadorEquipoDTO> modificarAsignacionJugadorEquipo(@RequestBody AsignacionJugadorEquipoDTO asignacionJugadorEquipoDTO) throws Exception {
        AsignacionJugadorEquipoDTO asignacionJugadorEquipoResponse = asignacionJugadorEquipoService.modificarAsignacionJugadorEquipo(asignacionJugadorEquipoDTO);
        return new ResponseEntity<>(asignacionJugadorEquipoResponse, HttpStatus.OK);
    }

    @DeleteMapping(value = "/eliminarAsignacionJUgadorEquipo/{id}")
    public ResponseEntity<Void> eliminarAsignacionJugadorEquipo(@PathVariable ("id")Integer idAsignacionJugadorEquipo) throws Exception {
        asignacionJugadorEquipoService.eliminarAsignacionJugadorEquipo(idAsignacionJugadorEquipo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}