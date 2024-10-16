package com.ligabtp.ligabetplay.controller;


import com.ligabtp.ligabetplay.domain.PartidoyArbitro;
import com.ligabtp.ligabetplay.dto.PartidoyArbitroDTO;
import com.ligabtp.ligabetplay.mapper.PartidoyArbitroMapper;
import com.ligabtp.ligabetplay.repository.PartidoyArbitroRepository;
import com.ligabtp.ligabetplay.repository.service.PartidoyArbitroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/PartidoyArbitro")
public class PartidoyArbitroController {

    //inyeccion independencia
    private PartidoyArbitroRepository partidoyArbitroRepository;
    private PartidoyArbitroService partidoyArbitroService;


    public PartidoyArbitroController(PartidoyArbitroRepository partidoyArbitroRepository, PartidoyArbitroService partidoyArbitroService) {
        this.partidoyArbitroRepository = partidoyArbitroRepository;
        this.partidoyArbitroService = partidoyArbitroService;
    }


    @GetMapping(value = "/obtenerPartidoyArbitro")
    public List<PartidoyArbitro> obtenerPartidoyArbitro (){
        List<PartidoyArbitro> listaPartidoyArbitro = partidoyArbitroRepository.findAll();
        return listaPartidoyArbitro;

    }

    @PostMapping(value = "guardarNuevoPartidoyArbitro")
    public ResponseEntity<PartidoyArbitroDTO> guardarNuevoPartidoyArbitro(@RequestBody PartidoyArbitroDTO partidoyArbitroDTO) throws Exception {
        PartidoyArbitroDTO partidoyArbitroResponse = partidoyArbitroService.guardarNuevoPartidoyArbitro(partidoyArbitroDTO);
        return new ResponseEntity<>(partidoyArbitroResponse, HttpStatus.CREATED);

    }

    @GetMapping(value = "/obtenerPartidoyArbitro")
    public List<PartidoyArbitroDTO> obtenerPartidoyArbitroList(){
        List<PartidoyArbitro> listaPartidosyArbitros = partidoyArbitroRepository.findAll();
        return PartidoyArbitroMapper.domainToDTOList(listaPartidosyArbitros);
    }

    @GetMapping(value = "/buscarPartidoyArbitroPorId/{id}")
    public ResponseEntity<PartidoyArbitroDTO> buscarPartidoyArbitroPorId(@PathVariable Integer id) throws Exception {
        PartidoyArbitroDTO partidoyArbitroResponse = partidoyArbitroService.buscarPartidoyArbitroPorId(id);
        return new ResponseEntity<>(partidoyArbitroResponse, HttpStatus.OK);
    }

    @PutMapping(value = "/modificarNuevoPartidoyArbitro")
    public ResponseEntity<PartidoyArbitroDTO> modificarNuevoPartidoyArbitro(@RequestBody PartidoyArbitroDTO partidoyArbitroDTO) throws Exception {
        PartidoyArbitroDTO partidoyArbitroResponse = partidoyArbitroService.guardarNuevoPartidoyArbitro(partidoyArbitroDTO);
        return new ResponseEntity<>(partidoyArbitroResponse, HttpStatus.CREATED);
    }
}