package com.dentti.service.dentalapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacienteDTO {
    private String idDocumento;
    private String tipoDocumento;
    private String apellidos;
    private String nombres;
    private String direccion;
    private String celular;
    private String email;
    private Date fechaNacimiento;
    private String tipoPaciente;
    private String tipoContacto;
    private ApoderadoDTO apoderadoDTO;
}
