package com.ligabtp.ligabetplay.controller;


import com.ligabtp.ligabetplay.dto.JugadorDTO;
import com.ligabtp.ligabetplay.repository.service.JugadorService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/jugador")
public class JugadorController {

    //inyeccion independencia
    private JugadorService jugadorService;


    public JugadorController() {
        this.jugadorService = jugadorService;
    }


    @GetMapping(value = "/obtenerJugador")
    public List<JugadorDTO> obtenerjugador() {
        return jugadorService.obtenerJugadores();
    }

    @PostMapping(value = "/crearNuevoJugador")
    public ResponseEntity<JugadorDTO> crearNuevoJugador(@RequestBody JugadorDTO jugadorDTO) throws Exception {
        JugadorDTO jugadorResponse = jugadorService.guardarNuevoJugador(jugadorDTO);
        return new ResponseEntity<>(jugadorResponse, HttpStatus.CREATED);
    }


    @GetMapping(value = "/buscarJugadorPorId/{id}")
    public ResponseEntity<JugadorDTO> buscarJugadorPorId(@PathVariable("id") Integer id) throws Exception {
        JugadorDTO jugadorDTO = jugadorService.buscarJugadorPorId(id);
        return new ResponseEntity<>(jugadorDTO, HttpStatus.OK);
    }


    @PutMapping(value = "/modificarJugador")
    public ResponseEntity<JugadorDTO> modificarJugador(@RequestBody JugadorDTO jugadorDTO) throws Exception {
        JugadorDTO jugadorResponse = jugadorService.modificarJugador(jugadorDTO);
        return new ResponseEntity<>(jugadorResponse, HttpStatus.CREATED);
    }

    @GetMapping(value = "/buscarJugadorPorNombre/{nombre}")
    public ResponseEntity<JugadorDTO> buscarJugadorPorNombre(@PathVariable("nombre") String nombre) throws Exception {
        JugadorDTO jugadorDTO = jugadorService.buscarJugadorPorNombre(nombre);
        return new ResponseEntity<>(jugadorDTO, HttpStatus.OK);
    }
}