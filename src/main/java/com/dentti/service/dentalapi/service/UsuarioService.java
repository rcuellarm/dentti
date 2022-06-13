package com.dentti.service.dentalapi.service;

import com.dentti.service.dentalapi.dto.EvolucionDTO;
import com.dentti.service.dentalapi.dto.UsuarioDTO;
import com.dentti.service.dentalapi.entity.Apoderado;
import com.dentti.service.dentalapi.entity.Evolucion;
import com.dentti.service.dentalapi.entity.Usuario;
import com.dentti.service.dentalapi.exceptions.EntityNotFoundException;
import com.dentti.service.dentalapi.mapper.*;
import com.dentti.service.dentalapi.repository.EvolucionRepository;
import com.dentti.service.dentalapi.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    EvolucionRepository evolucionRepository;

    UsuarioMapper usuarioMapper;
    HistoriaMapper historiaMapper;
    PacienteMapper pacienteMapper;
    ApoderadoMapper apoderadoMapper;
    EvolucionMapper evolucionMapper;

    public List<UsuarioDTO> listarUsuarios() {
        return StreamSupport.stream(
                usuarioRepository.findAll().spliterator(), false)
                .map(usuarioMapper::map).collect(Collectors.toList());
    }

    public UsuarioDTO obtenerUsuario(String usuarioId) {
        return usuarioRepository.findById(usuarioId).map(usuario -> {
            UsuarioDTO usuarioDTO = usuarioMapper.map(usuario);
            usuarioDTO.setEvolucionesDTO(StreamSupport.stream(
                    evolucionRepository.findByUsuarioId(usuarioId).spliterator(), false)
                    .map(evolucionMapper::map).collect(Collectors.toList()));
            return usuarioDTO;
        }).<EntityNotFoundException>orElseThrow(() -> {
            throw new EntityNotFoundException("Usuario no encontrado");
        });
    }

    public EvolucionDTO obtenerEvolucion(String evolucionId) {
        return evolucionRepository.findById(evolucionId).map(evolucionMapper::map).<EntityNotFoundException>orElseThrow(() -> {
            throw new EntityNotFoundException("Registro de evolucion del paciente no encontrado");
        });
    }

    public UsuarioDTO guardarUsuario(UsuarioDTO dto) {
        Usuario usuario = usuarioMapper.map(dto);
        return usuarioMapper.map(usuarioRepository.save(usuario));
    }

    public List<EvolucionDTO> guardarEvolucion(EvolucionDTO dto, String usuarioId) {
        Evolucion evolucion = evolucionMapper.map(dto);
        evolucion.setUsuarioId(usuarioId);
        evolucionRepository.save(evolucion);
        return StreamSupport.stream(
                        evolucionRepository.findByUsuarioId(usuarioId).spliterator(), false)
                .map(evolucionMapper::map).collect(Collectors.toList());
    }

    public UsuarioDTO actualizarUsuario(UsuarioDTO dto) {
        return usuarioRepository.findById(dto.getId()).map(usuario -> {
            usuario.setNombre(dto.getNombre());
            usuario.setHistoria(historiaMapper.map(dto.getHistoriaDTO()));
            usuario.setPaciente(pacienteMapper.map(dto.getPacienteDTO()));
            usuario.getPaciente().setApoderado(apoderadoMapper.map(dto.getPacienteDTO().getApoderadoDTO()));
            return usuarioMapper.map(usuarioRepository.save(usuario));
        }).<EntityNotFoundException>orElseThrow(() -> {
            throw new EntityNotFoundException("Usuario no encontrado");
        });
    }

    public List<EvolucionDTO> actualizarEvolucion(EvolucionDTO dto) {
        return evolucionRepository.findById(dto.getEvolucionId()).map(evolucion -> {
            evolucion.setNombre(dto.getNombre());
            evolucion.setHistoria(historiaMapper.map(dto.getHistoriaDTO()));
            evolucion.setPaciente(pacienteMapper.map(dto.getPacienteDTO()));
            evolucion.getPaciente().setApoderado(apoderadoMapper.map(dto.getPacienteDTO().getApoderadoDTO()));
            return evolucionMapper.map(evolucionRepository.save(evolucion));
        }).<EntityNotFoundException>orElseThrow(() -> {
            throw new EntityNotFoundException("Registro de evolucion del paciente no encontrado");
        });
    }

    public void borrarUsuario(String usuarioId) {
        usuarioRepository.deleteById(usuarioId);
    }

    public boolean existePorId(String usuarioId) {
        return usuarioRepository.existsById(usuarioId);
    }

    public boolean existePorNombre(String nombre) {
        return usuarioRepository.existsByNombre(nombre);
    }
}
