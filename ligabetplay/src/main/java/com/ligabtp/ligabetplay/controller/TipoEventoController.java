package com.ligabtp.ligabetplay.controller;


import com.ligabtp.ligabetplay.domain.TipoEvento;
import com.ligabtp.ligabetplay.repository.TipoEventoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tipoEvento")
public class TipoEventoController {

    //inyeccion independencia
    private TipoEventoRepository tipoEventoRepository;


    public TipoEventoController(TipoEventoRepository tipoEventoRepository) {
        this.tipoEventoRepository = tipoEventoRepository;
    }


    @GetMapping(value = "/obtenerTipoEvento")
    public List<TipoEvento> obtenerTipoEventos(){
        List<TipoEvento> listaTipoEvento = tipoEventoRepository.findAll();
        return listaTipoEvento;

    }
}