package com.ligabtp.ligabetplay.controller;

import com.ligabtp.ligabetplay.domain.EstadisticadelPartido;
import com.ligabtp.ligabetplay.repository.EstadisticadelPartidoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estadisticadelPartido")
public class EstadisticadelPartidoController {

    //inyeccion independencia
    private EstadisticadelPartidoRepository estadisticadelPartidoRepository;


    public EstadisticadelPartidoController(EstadisticadelPartidoRepository estadisticadelPartidoRepository) {
        this.estadisticadelPartidoRepository = estadisticadelPartidoRepository;
    }


    @GetMapping(value = "/obtenerEstadisticasdelPartidos")
    public List<EstadisticadelPartido> obtenerEstadisticasdelPartidos (){
        List<EstadisticadelPartido> listaEstadisticasdelPartidos = estadisticadelPartidoRepository.findAll();
        return listaEstadisticasdelPartidos;


    }
}
