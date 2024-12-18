package com.ligabtp.ligabetplay.controller;



import com.ligabtp.ligabetplay.dto.EquipoDTO;
import com.ligabtp.ligabetplay.service.EquipoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipo")
public class EquipoController {

    //inyeccion independencia
    private EquipoService equipoService;


    public EquipoController() {

        this.equipoService = equipoService;
    }


    @GetMapping(value = "/obtenerEquipo")
    public List<EquipoDTO> obtenerequipo (){
        return equipoService.obtenerEquipos();
    }

    @PostMapping(value = "/crearNuevoEquipo")
    public ResponseEntity<EquipoDTO> crearNuevoEquipo (@RequestBody EquipoDTO equipoDTO) throws Exception{
        EquipoDTO equipoDTOResponse = equipoService.guardarNuevaEquipo(equipoDTO);
        return new ResponseEntity<>(equipoDTOResponse, HttpStatus.CREATED);
    }

    @GetMapping(value = "buscarEquipoPorId/{id}")
    public ResponseEntity<EquipoDTO> buscarEquipoPorId(@PathVariable("id") Integer id)throws Exception{
        EquipoDTO equipoDTO = equipoService.buscarEquipoPorId(id);
        return new ResponseEntity<>(equipoDTO, HttpStatus.OK);
    }

    @PutMapping (value = "/modificarEquipo")
    public ResponseEntity<EquipoDTO> modificarEquipo(@RequestBody EquipoDTO equipoDTO) throws Exception{
        EquipoDTO equipoResponseDTO = equipoService.modificarEquipo(equipoDTO);
        return new ResponseEntity<>(equipoResponseDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/buscarEquipoPorNombre/{nombre}")
    public ResponseEntity<EquipoDTO> buscarEquipoPorNombre(@PathVariable("nombre") String nombre) throws Exception{
        EquipoDTO equipoDTO = equipoService.buscarEquipoPorNombre(nombre);
        return new ResponseEntity<>(equipoDTO, HttpStatus.OK);
    }

    @DeleteMapping("/eliminarEquipo/{id}")
    public ResponseEntity<Void> eliminarEquipo(@PathVariable ("id") Integer idEquipo) throws Exception {
        equipoService.eliminarEquipo(idEquipo);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}

