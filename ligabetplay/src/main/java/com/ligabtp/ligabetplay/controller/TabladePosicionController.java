package com.ligabtp.ligabetplay.controller;


import com.ligabtp.ligabetplay.domain.TablaDePosicion;
import com.ligabtp.ligabetplay.repository.TabladePosicionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tabladePosicion")
public class TabladePosicionController {

    //inyeccion independencia
    private TabladePosicionRepository tabladePosicionRepository;


    public TabladePosicionController(TabladePosicionRepository tabladePosicioneRepository) {
        this.tabladePosicionRepository =  tabladePosicioneRepository;
    }


    @GetMapping(value = "/obtenerTablasdePosiciones")
    public List<TablaDePosicion> obtenerTablasdePosiciones (){
        List<TablaDePosicion> listaTablasdePosiciones = tabladePosicionRepository.findAll();
        return listaTablasdePosiciones;

    }



}