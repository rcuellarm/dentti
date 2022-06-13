package com.dentti.service.dentalapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvolucionDTO {
    private String evolucionId;
    private String usuarioId;
    private Date fechaRegistro;
    private String detalle;
    private String atendidoPor;
    private BigDecimal pagoRecibido;
}
