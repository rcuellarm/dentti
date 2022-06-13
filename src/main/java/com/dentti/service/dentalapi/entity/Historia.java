package com.dentti.service.dentalapi.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamoDBDocument
public class Historia {
    @DynamoDBAttribute
    private String enfermedades;
    @DynamoDBAttribute
    private String medicamentos;
    @DynamoDBAttribute
    private String alergias;
    @DynamoDBAttribute
    private String cirugias;
    @DynamoDBAttribute
    private String hospitalizaciones;
}
