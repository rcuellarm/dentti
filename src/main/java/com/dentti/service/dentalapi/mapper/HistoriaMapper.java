package com.dentti.service.dentalapi.mapper;

import com.dentti.service.dentalapi.dto.HistoriaDTO;
import com.dentti.service.dentalapi.entity.Historia;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HistoriaMapper {
    Historia map(HistoriaDTO source);

    @InheritInverseConfiguration
    HistoriaDTO map(Historia source);

}
