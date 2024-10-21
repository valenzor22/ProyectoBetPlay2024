package com.ligabtp.ligabetplay.controller;


import com.ligabtp.ligabetplay.domain.Equipo;
import com.ligabtp.ligabetplay.dto.EquipoDTO;
import com.ligabtp.ligabetplay.mapper.EquipoMapper;
import com.ligabtp.ligabetplay.repository.EquipoRepository;
import com.ligabtp.ligabetplay.repository.service.EquipoService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return equipoService.obtenerEqupos();
    }

    @PostMapping(value = "/crearNuevoEquipo")
    public ResponseEntity<EquipoDTO> crearNuevoEquipo (@RequestBody EquipoDTO equipoDTO) throws Exception{
        EquipoDTO equipoDTOResponse = equipoService.guardarNuevaEquipo(equipoDTO);
        return new ResponseEntity<>(equipoDTOResponse, HttpStatus.CREATED);
    }


}

