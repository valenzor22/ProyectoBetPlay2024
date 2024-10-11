package com.ligabtp.ligabetplay.controller;

import com.ligabtp.ligabetplay.domain.EstadisticaDelPartido;
import com.ligabtp.ligabetplay.dto.EstadisticaDelPartidoDTO;
import com.ligabtp.ligabetplay.mapper.EstadisticaDelPartidoMapper;
import com.ligabtp.ligabetplay.repository.EstadisticaDelPartidoRepository;
import com.ligabtp.ligabetplay.repository.service.EstadisticaDelPartidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estadisticaDelPartido")
public class EstadisticaDelPartidoController {

    //inyeccion independencia
    private EstadisticaDelPartidoRepository estadisticaDelPartidoRepository;
    private EstadisticaDelPartidoService estadisticaDelPartidoService;


    public EstadisticaDelPartidoController(EstadisticaDelPartidoRepository estadisticaDelPartidoRepository) {
        this.estadisticaDelPartidoRepository = estadisticaDelPartidoRepository;
        this.estadisticaDelPartidoService = estadisticaDelPartidoService;
    }


    @GetMapping(value = "/obtenerEstadisticadelPartidos")
    public List<EstadisticaDelPartido> obtenerEstadisticaDelPartidos (){
        List<EstadisticaDelPartido> listaEstadisticasDelPartidos = estadisticaDelPartidoRepository.findAll();
        return listaEstadisticasDelPartidos;
    }

    @PostMapping(value = "/obtenerEstadisticaDelPartido")
    public ResponseEntity<EstadisticaDelPartidoDTO> obtenerEstadisticaDelPartidoList(@RequestBody EstadisticaDelPartidoDTO estadisticaDelPartidoDTO) throws Exception{
        EstadisticaDelPartidoDTO estadisticaDelPartidoResponse = estadisticaDelPartidoService.guardarNuevaEstadisticaDelPartido(estadisticaDelPartidoDTO);
        return new ResponseEntity<>(estadisticaDelPartidoResponse, HttpStatus.CREATED);
    }

    @GetMapping(value = "/obtenerEstadisticaDelPartidos")
    public List<EstadisticaDelPartidoDTO> obtenerEstadisticaDelPartidosList (){
        List<EstadisticaDelPartido> listaEstadisticasDelPartidos = estadisticaDelPartidoRepository.findAll();
        return EstadisticaDelPartidoMapper.domainToDTOList(listaEstadisticasDelPartidos);
    }

   @GetMapping(value = "buscarEstadisticaDelPartidoPorId/{id}")
   public ResponseEntity<EstadisticaDelPartidoDTO> obtenerEstadisticaDelPartidoPorId(@PathVariable Integer id)throws Exception{
       EstadisticaDelPartidoDTO estadisticaDelPartidoDTO = estadisticaDelPartidoService.buscarEstadisticaDelPartidoPorId(id);
       return new ResponseEntity<>(estadisticaDelPartidoDTO, HttpStatus.OK);
   }

    @PutMapping(value = "/modificarEstadisticadelPartidos")
    public ResponseEntity<EstadisticaDelPartidoDTO> modificarNuevaEstadisticaDelPartidoDTO(@RequestBody EstadisticaDelPartidoDTO estadisticaDelPartidoDTO) throws Exception {
        EstadisticaDelPartidoDTO estadisticaDelPartidoResponse = estadisticaDelPartidoService.guardarNuevaEstadisticaDelPartido(estadisticaDelPartidoDTO);
        return new ResponseEntity<>(estadisticaDelPartidoResponse, HttpStatus.CREATED);

    }
}
