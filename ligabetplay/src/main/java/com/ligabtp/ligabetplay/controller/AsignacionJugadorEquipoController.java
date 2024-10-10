package com.ligabtp.ligabetplay.controller;


import com.ligabtp.ligabetplay.domain.AsignacionJugadorEquipo;
import com.ligabtp.ligabetplay.dto.AsignacionJugadorEquipoDTO;
import com.ligabtp.ligabetplay.mapper.AsignacionJugadorEquipoMapper;
import com.ligabtp.ligabetplay.repository.AsignacionJugadorEquipoRepository;
import com.ligabtp.ligabetplay.repository.service.AsignacionJugadorEquipoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/AsignacionJugadorEquipo")
public class AsignacionJugadorEquipoController {

    //inyeccion independencia
    private AsignacionJugadorEquipoRepository asignacionJugadorEquipoRepository;
    private AsignacionJugadorEquipoService asignacionJugadorEquipoService;


    public AsignacionJugadorEquipoController(AsignacionJugadorEquipoRepository asignacionJugadorEquipoRepository, AsignacionJugadorEquipoService asignacionJugadorEquipoService) {
        this.asignacionJugadorEquipoRepository = asignacionJugadorEquipoRepository;
        this.asignacionJugadorEquipoService = asignacionJugadorEquipoService;
    }


    @GetMapping(value = "/obtenerAsignacionJugadorEquipo")
    public List<AsignacionJugadorEquipo> obtenerAsignacionJugadorEquipo (){
        List<AsignacionJugadorEquipo> listaAsignacionesJugadoresEquipos = asignacionJugadorEquipoRepository.findAll();
        return listaAsignacionesJugadoresEquipos;

    }

    @PostMapping(value = "guardarNuevaAsignacionJugadorEquipo")
    public ResponseEntity<AsignacionJugadorEquipoDTO> guardarNuevaAsignacionJugadorEquipo(@RequestBody AsignacionJugadorEquipoDTO asignacionJugadorEquipoDTO) throws Exception {
        AsignacionJugadorEquipoDTO asignacionJugadorEquipoResponse = asignacionJugadorEquipoService.guardarNuevaAsignacionJugadorEquipo(asignacionJugadorEquipoDTO);
        return new ResponseEntity<>(asignacionJugadorEquipoResponse, HttpStatus.CREATED);

    }

    @GetMapping(value = "/obtenerAsignacionJugadorEquipo")
    public List<AsignacionJugadorEquipoDTO> obtenerAsignacionJugadorEquipoList(){
        List<AsignacionJugadorEquipo> listaAsignacionesJugadores = asignacionJugadorEquipoRepository.findAll();
        return AsignacionJugadorEquipoMapper.domainToDTOList(listaAsignacionesJugadores);
    }

    @GetMapping(value = "/buscarAsignacionJugadorEquipoPorId/{id}")
    public ResponseEntity<AsignacionJugadorEquipoDTO> buscarAsignacionJugadorEquipoPorId(@PathVariable Integer id) throws Exception {
        AsignacionJugadorEquipoDTO asignacionJugadorEquipoResponse = asignacionJugadorEquipoService.buscarAsignacionJugadorPorId(id);
        return new ResponseEntity<>(asignacionJugadorEquipoResponse, HttpStatus.OK);
    }

    @PutMapping(value = "/modificarNuevaAsignacionJugadorEquipo")
    public ResponseEntity<AsignacionJugadorEquipoDTO> modificarNuevaAsignacionJugadorEquipo(@RequestBody AsignacionJugadorEquipoDTO asignacionJugadorEquipoDTO) throws Exception {
        AsignacionJugadorEquipoDTO asignacionJugadorEquipoResponse = asignacionJugadorEquipoService.guardarNuevaAsignacionJugadorEquipo(asignacionJugadorEquipoDTO);
        return new ResponseEntity<>(asignacionJugadorEquipoResponse, HttpStatus.CREATED);

    }
}