package com.ligabtp.ligabetplay.controller;


import com.ligabtp.ligabetplay.domain.Equipo;
import com.ligabtp.ligabetplay.repository.EquipoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/equipo")
public class EquipoController {

    //inyeccion independencia
    private EquipoRepository equipoRepository;


    public EquipoController(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }


    @GetMapping(value = "/obtenerEquipo")
    public List<Equipo> obtenerEquipo (){
        List<Equipo> listaEquipos = equipoRepository.findAll();
        return listaEquipos;
    }
}