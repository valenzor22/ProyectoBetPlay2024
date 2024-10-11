package com.ligabtp.ligabetplay.controller;

import com.ligabtp.ligabetplay.domain.EstadisticaDelPartido;
import com.ligabtp.ligabetplay.repository.EstadisticaDelPartidoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estadisticaDelPartido")
public class EstadisticaDelPartidoController {

    //inyeccion independencia
    private EstadisticaDelPartidoRepository estadisticaDelPartidoRepository;


    public EstadisticaDelPartidoController(EstadisticaDelPartidoRepository estadisticaDelPartidoRepository) {
        this.estadisticaDelPartidoRepository = estadisticaDelPartidoRepository;
    }


    @GetMapping(value = "/obtenerEstadisticasdelPartidos")
    public List<EstadisticaDelPartido> obtenerEstadisticasDelPartidos (){
        List<EstadisticaDelPartido> listaEstadisticasDelPartidos = estadisticaDelPartidoRepository.findAll();
        return listaEstadisticasDelPartidos;


    }
}
