package com.ligabtp.ligabetplay.controller;


import com.ligabtp.ligabetplay.domain.Jornada;
import com.ligabtp.ligabetplay.dto.JornadaDTO;
import com.ligabtp.ligabetplay.mapper.JornadaMapper;
import com.ligabtp.ligabetplay.repository.JornadaRepository;
import com.ligabtp.ligabetplay.repository.service.JornadaService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jornada")
public class JornadaController {

    //inyeccion independencia
    private JornadaService jornadaService;


    public JornadaController() {
        this.jornadaService = jornadaService;
    }


    @GetMapping(value = "/obtenerJornada")
    public List<JornadaDTO> obtenerJornada (){
        return jornadaService.obtenerJornadas();
    }

    @PostMapping(value = "/crearNuevaJornada")
    public ResponseEntity<JornadaDTO> crearNuvaJornada (@RequestBody JornadaDTO jornadaDTO) throws Exception{
        JornadaDTO jornadaResponse = jornadaService.guardarNuevaJornada(jornadaDTO);
        return new ResponseEntity<>(jornadaResponse, HttpStatus.CREATED);
    }

    @GetMapping (value = "/buscarJornadaPorId/{id}")
    public ResponseEntity<JornadaDTO> buscarJornadaPorId (@PathVariable ("id") Integer id) throws Exception{
        JornadaDTO jornadaDTO = jornadaService.buscarJornadaPorId(id);
        return new ResponseEntity<>(jornadaDTO, HttpStatus.OK);
    }

    @PutMapping (value = "/modificarJornada")
    public ResponseEntity<JornadaDTO> modificarJornada (@RequestBody JornadaDTO jornadaDTO) throws Exception{
        JornadaDTO jornadaResponse = jornadaService.modificarJornada(jornadaDTO);
        return new ResponseEntity<>(jornadaResponse, HttpStatus.CREATED);
    }

    @GetMapping (value = "/buscarJornadaPorNombre/{nombre}")
    public ResponseEntity<JornadaDTO> buscarJornadaPorNombre (@PathVariable ("nombre") String nombre) throws Exception{
        JornadaDTO jornadaResponse = jornadaService.buscarJornadaPorNombre(nombre);
        return new ResponseEntity<>(jornadaResponse, HttpStatus.OK);
    }

    @DeleteMapping(value = "/eliminarJornada/{id}")
    public ResponseEntity<Void> eliminarJornada (@PathVariable("id") Integer idJornada) throws Exception{
        jornadaService.eliminarJornada(idJornada);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
