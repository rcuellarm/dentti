package com.dentti.service.dentalapi.mapper;

import com.dentti.service.dentalapi.dto.EvolucionDTO;
import com.dentti.service.dentalapi.entity.Evolucion;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EvolucionMapper {
    Evolucion map(EvolucionDTO source);

    @InheritInverseConfiguration
    @Mapping(target = "evolucionId", source = "id")
    EvolucionDTO map(Evolucion source);
}
