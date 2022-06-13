package com.dentti.service.dentalapi.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamoDBDocument
public class Paciente {
    @DynamoDBAttribute
    private String idDocumento;
    @DynamoDBAttribute
    private String tipoDocumento;
    @DynamoDBAttribute
    private String apellidos;
    @DynamoDBAttribute
    private String nombres;
    @DynamoDBAttribute
    private String direccion;
    @DynamoDBAttribute
    private String celular;
    @DynamoDBAttribute
    private String email;
    @DynamoDBAttribute
    private Date fechaNacimiento;
    @DynamoDBAttribute
    private String tipoPaciente;
    @DynamoDBAttribute
    private String tipoContacto;
    @DynamoDBAttribute
    private Apoderado apoderado;
}
