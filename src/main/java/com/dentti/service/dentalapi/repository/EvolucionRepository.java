package com.dentti.service.dentalapi.repository;

import com.dentti.service.dentalapi.entity.Evolucion;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EvolucionRepository extends CrudRepository<Evolucion, String> {
    List<Evolucion> findByUsuarioId(String usuarioId);
}
