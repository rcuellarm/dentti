package com.dentti.service.dentalapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoriaDTO {
    private String enfermedades;
    private String medicamentos;
    private String alergias;
    private String cirugias;
    private String hospitalizaciones;
}
