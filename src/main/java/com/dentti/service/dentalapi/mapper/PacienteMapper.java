package com.dentti.service.dentalapi.mapper;

import com.dentti.service.dentalapi.dto.PacienteDTO;
import com.dentti.service.dentalapi.entity.Paciente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { ApoderadoMapper.class })
public interface PacienteMapper {

    @Mapping(target = "apoderado", source = "apoderadoDTO")
    Paciente map(PacienteDTO source);

    @InheritInverseConfiguration
    @Mapping(target = "apoderadoDTO", source = "apoderado")
    PacienteDTO map(Paciente source);
}
