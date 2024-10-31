package com.ligabtp.ligabetplay.controller;


import com.ligabtp.ligabetplay.dto.TipoEventoDTO;
import com.ligabtp.ligabetplay.service.TipoEventoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/tipoEvento")
public class TipoEventoController {

    //inyeccion independencia
    private final TipoEventoService tipoEventoService;


    public TipoEventoController(TipoEventoService tipoEventoService) {
        this.tipoEventoService = tipoEventoService;
    }

    @PostMapping(value = "/guardarTipoEvento")
    public ResponseEntity<TipoEventoDTO> guardarTipoEvento(@RequestBody TipoEventoDTO tipoEventoDTO) throws Exception {
        TipoEventoDTO tipoEventoResponse = tipoEventoService.guardarNuevoTipoEvento(tipoEventoDTO);
        return new ResponseEntity<>(tipoEventoResponse, HttpStatus.CREATED);
    }


    @GetMapping(value = "/obtenerTipoEvento")
    public List<TipoEventoDTO> obtenertipoEvento() {
        return tipoEventoService.obtenerTipoEventos();
    }

    @GetMapping(value = "/buscarTipoEventoPorId/{id}")
    public ResponseEntity<TipoEventoDTO> buscarTipoEventoPorId(@PathVariable Integer id) throws Exception {
        TipoEventoDTO tipoEventoDTO = tipoEventoService.buscarTipoEventoPorId(id);
        return new ResponseEntity<>(tipoEventoDTO, HttpStatus.OK);
    }

    @PutMapping(value = "/modificarTipoEvento")
    public ResponseEntity<TipoEventoDTO> modificarTipoEvento(@RequestBody TipoEventoDTO tipoEventoDTO) throws Exception {
        TipoEventoDTO tipoEventoResponse = tipoEventoService.modificarTipoEvento(tipoEventoDTO);
        return new ResponseEntity<>(tipoEventoResponse, HttpStatus.OK);
    }

   @DeleteMapping(value = "/eliminarTipoEvento/{id}")
    public ResponseEntity<TipoEventoDTO> eliminarTipoEvento(@PathVariable("id") Integer idTipoEvento) throws Exception {
        tipoEventoService.eliminarTipoEvento(idTipoEvento);
        return new ResponseEntity<>(HttpStatus.OK);
   }
}