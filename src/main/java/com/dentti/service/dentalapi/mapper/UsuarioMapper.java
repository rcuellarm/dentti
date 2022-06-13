package com.dentti.service.dentalapi.mapper;

import com.dentti.service.dentalapi.dto.UsuarioDTO;
import com.dentti.service.dentalapi.entity.Usuario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { PacienteMapper.class, HistoriaMapper.class, EvolucionMapper.class })
public interface UsuarioMapper {
    @Mapping(target = "historia", source = "historiaDTO")
    @Mapping(target = "paciente", source = "pacienteDTO")
    @Mapping(target = "evoluciones", source = "evolucionesDTO")
    Usuario map(UsuarioDTO source);

    @InheritInverseConfiguration
    @Mapping(target = "id", source = "usuarioId")
    @Mapping(target = "historiaDTO", source = "historia")
    @Mapping(target = "pacienteDTO", source = "paciente")
    @Mapping(target = "evolucionesDTO", source = "evoluciones")
    UsuarioDTO map(Usuario source);
}
