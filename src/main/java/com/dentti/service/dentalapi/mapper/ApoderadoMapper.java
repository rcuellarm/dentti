package com.dentti.service.dentalapi.mapper;

import com.dentti.service.dentalapi.dto.ApoderadoDTO;
import com.dentti.service.dentalapi.entity.Apoderado;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApoderadoMapper {
    Apoderado map(ApoderadoDTO source);

    @InheritInverseConfiguration
    ApoderadoDTO map(Apoderado source);
}
