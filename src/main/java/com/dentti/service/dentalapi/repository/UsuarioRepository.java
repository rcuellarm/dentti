package com.dentti.service.dentalapi.repository;

import com.dentti.service.dentalapi.entity.Usuario;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@EnableScan
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, String> {
    boolean existsByNombre(String nombre);
}
