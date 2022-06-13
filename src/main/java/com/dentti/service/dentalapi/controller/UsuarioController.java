package com.dentti.service.dentalapi.controller;

import com.dentti.service.dentalapi.dto.EvolucionDTO;
import com.dentti.service.dentalapi.dto.UsuarioDTO;
import com.dentti.service.dentalapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/usuario")
    public ResponseEntity<List<UsuarioDTO>> listar() {
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<UsuarioDTO> obtenerUsuario(@PathVariable("usuarioId") String usuarioId) {
        if(!usuarioService.existePorId(usuarioId))
            return new ResponseEntity("No existe", HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(usuarioService.obtenerUsuario(usuarioId));
    }

    @GetMapping("/evolucion/{evolucionId}")
    public ResponseEntity<EvolucionDTO> obtenerEvolucion(@PathVariable("evolucionId") String evolucionId) {
        return ResponseEntity.ok(usuarioService.obtenerEvolucion(evolucionId));
    }

    @PostMapping("/usuario")
    public ResponseEntity<UsuarioDTO> crearUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        if(usuarioService.existePorNombre(usuarioDTO.getNombre()))
            return new ResponseEntity("El nombre ya existe", HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok(usuarioService.guardarUsuario(usuarioDTO));
    }

    @PostMapping("/usuario/{usuarioId}/evolucion")
    public ResponseEntity<List<EvolucionDTO>> crearEvolucion(@RequestBody EvolucionDTO evolucionDTO, @PathVariable("usuarioId") String usuarioId) {
        return ResponseEntity.ok(usuarioService.guardarEvolucion(evolucionDTO, usuarioId));
    }

    @PutMapping("/usuario")
    public ResponseEntity<UsuarioDTO> actualizarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        if(!usuarioService.existePorId(usuarioDTO.getId()))
            return new ResponseEntity("El id NO existe", HttpStatus.NOT_FOUND);
        if(usuarioService.existePorNombre(usuarioDTO.getNombre()) &&
            !usuarioService.obtenerUsuario(usuarioDTO.getId()).getNombre().equals(usuarioDTO.getNombre()))
            return new ResponseEntity("El nombre ya existe", HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok(usuarioService.actualizarUsuario(usuarioDTO));
    }

    @DeleteMapping("/usuario/{usuarioId}")
    public ResponseEntity<?> borrarUsuario(@PathVariable("usuarioId") String usuarioId) {
        if(!usuarioService.existePorId(usuarioId))
            return new ResponseEntity("No existe", HttpStatus.NOT_FOUND);
        usuarioService.borrarUsuario(usuarioId);
        return new ResponseEntity("Usuario eliminado", HttpStatus.OK);
    }
}
