package com.ligabtp.ligabetplay.controller;


import com.ligabtp.ligabetplay.domain.AsignacionJugadorEquipo;
import com.ligabtp.ligabetplay.repository.AsignacionJugadorEquipoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/AsignacionJugadorEquipo")
public class AsignacionJugadorEquipoController {

    //inyeccion independencia
    private AsignacionJugadorEquipoRepository asignacionJugadorEquipoRepository;


    public AsignacionJugadorEquipoController(AsignacionJugadorEquipoRepository asignacionJugadorEquipoRepository) {
        this.asignacionJugadorEquipoRepository = asignacionJugadorEquipoRepository;
    }


    @GetMapping(value = "/obtenerAsignacionJugadorEquipo")
    public List<AsignacionJugadorEquipo> obtenerAsignacionJugadorEquipo (){
        List<AsignacionJugadorEquipo> listaAsignacionesJugadoresEquipos = asignacionJugadorEquipoRepository.findAll();
        return listaAsignacionesJugadoresEquipos;

    }
}
