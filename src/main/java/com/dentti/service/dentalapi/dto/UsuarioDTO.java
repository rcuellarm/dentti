package com.dentti.service.dentalapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsuarioDTO {
    private String id;
    private String nombre;
    private PacienteDTO pacienteDTO;
    private HistoriaDTO historiaDTO;
    private List<EvolucionDTO> evolucionesDTO;
}
