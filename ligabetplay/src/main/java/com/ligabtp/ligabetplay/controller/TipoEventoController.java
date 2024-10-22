package com.ligabtp.ligabetplay.controller;


import com.ligabtp.ligabetplay.dto.TipoEventoDTO;
import com.ligabtp.ligabetplay.repository.service.TipoEventoService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/tipoEvento")
public class TipoEventoController {

    //inyeccion independencia
    private TipoEventoService tipoEventoService;


    public TipoEventoController() {
        this.tipoEventoService = tipoEventoService;
    }


    @GetMapping(value = "/obtenerTipoEvento")
    public List<TipoEventoDTO> obtenertipoEvento() {
        return tipoEventoService.obtenerTipoEventos();
    }

    @PostMapping(value = "/crearNuevoTipoEvento")
    public ResponseEntity<TipoEventoDTO> crearNuevoTipoEvento(@RequestBody TipoEventoDTO tipoEventoDTO) throws Exception {
        TipoEventoDTO tipoEventoResponse = tipoEventoService.guardarNuevoTipoEvento(tipoEventoDTO);
        return new ResponseEntity<>(tipoEventoResponse, HttpStatus.CREATED);
    }


    @GetMapping(value = "/buscarTipoEventoPorId/{id}")
    public ResponseEntity<TipoEventoDTO> buscarTipoEventoPorId(@PathVariable("id") Integer id) throws Exception {
        TipoEventoDTO tipoEventoDTO = tipoEventoService.buscarTipoEventoPorId(id);
        return new ResponseEntity<>(tipoEventoDTO, HttpStatus.OK);
    }


    @PutMapping(value = "/modificarTipoEvento")
    public ResponseEntity<TipoEventoDTO> modificarTipoEvento(@RequestBody TipoEventoDTO tipoEventoDTO) throws Exception {
        TipoEventoDTO tipoEventoResponse = tipoEventoService.modificarTipoEvento(tipoEventoDTO);
        return new ResponseEntity<>(tipoEventoResponse, HttpStatus.CREATED);
    }

    @GetMapping(value = "/buscarTipoEventoPorNombre/{nombre}")
    public ResponseEntity<TipoEventoDTO> buscarTipoEventoPorNombre(@PathVariable("nombre") String nombre) throws Exception {
        TipoEventoDTO tipoEventoDTO = tipoEventoService.buscarTipoEventoPorNombre(nombre);
        return new ResponseEntity<>(tipoEventoDTO, HttpStatus.OK);
    }
}