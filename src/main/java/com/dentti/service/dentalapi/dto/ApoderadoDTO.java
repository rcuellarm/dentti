package com.dentti.service.dentalapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApoderadoDTO {
    private String nombresApellidos;
    private String idDocumento;
    private String tipoDocumento;
}
