package com.ligabtp.ligabetplay.controller;

import com.ligabtp.ligabetplay.domain.Arbitro;
import com.ligabtp.ligabetplay.dto.ArbitroDTO;
import com.ligabtp.ligabetplay.mapper.ArbitroMapper;
import com.ligabtp.ligabetplay.repository.ArbitroRepository;
import com.ligabtp.ligabetplay.repository.service.ArbitroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/arbitro")
public class ArbitroController {

    //inyeccion independencia
    private ArbitroService arbitroService;


    public ArbitroController(ArbitroRepository arbitroRepository) {
        this.arbitroService = arbitroService;
    }


    @GetMapping(value = "/obtenerArbitros")
    public List<ArbitroDTO> obtenerArbitros (){
      return arbitroService.obtenerArbitros();

    }

    @PostMapping(value = "/crearNuevoArbitro")
    public ResponseEntity<ArbitroDTO> crearNuevoArbitro(@RequestBody ArbitroDTO arbitroDTO) throws Exception{
        ArbitroDTO arbitroDTOResponse = arbitroService.guardarNuevoArbitro(arbitroDTO);
        return new ResponseEntity<>(arbitroDTOResponse, HttpStatus.CREATED);
    }

    @GetMapping(value = "/buscarArbitroPorId/{id}")
    public ResponseEntity<ArbitroDTO> buscarArbitroPorId(@PathVariable ("id") Integer id) throws Exception{
        ArbitroDTO arbitroDTO = arbitroService.buscarArbitroPorId(id);
        return new ResponseEntity<>(arbitroDTO, HttpStatus.OK);
    }

    @PutMapping(value = "/modificarArbitro")
    public ResponseEntity<ArbitroDTO> modificarArbitro(@RequestBody ArbitroDTO arbitroDTO) throws Exception{
        ArbitroDTO arbitroResponse = arbitroService.modificarArbitro(arbitroDTO);
        return new ResponseEntity<>(arbitroResponse, HttpStatus.CREATED);
    }

    @GetMapping (value = "/buscarArbitroPorNombre/{nombre}")
    public ResponseEntity<ArbitroDTO> buscarArbitroPorNombre(@PathVariable ("nombre") String nombre) throws Exception{
        ArbitroDTO arbitroResponse = arbitroService.buscarArbitroPorNombre(nombre);
        return new ResponseEntity<>(arbitroResponse, HttpStatus.OK);
    }

    @DeleteMapping (value = "/eliminarArbitro/{id}")
    public ResponseEntity<Void> eliminarArbitro(@PathVariable ("id") Integer idArbitro) throws Exception{
        arbitroService.eliminarArbitro(idArbitro);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
