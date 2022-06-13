package com.dentti.service.dentalapi.config.persistence;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.dentti.service.dentalapi.audit.CustomAuditEntityListener;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@EqualsAndHashCode
@EntityListeners(CustomAuditEntityListener.class)
public class BaseEntity<ID> implements Serializable {
    @DynamoDBAttribute
    private String ipNumberUpdate;

    @DynamoDBAttribute
    private Long userCreate;

    @DynamoDBAttribute
    private Long userUpdate;

    @DynamoDBAttribute
    @LastModifiedDate
    private LocalDateTime dateUpdate;

    @DynamoDBAttribute
    private String ipNumberCreate;

    @DynamoDBAttribute
    @CreatedDate
    private LocalDateTime dateCreate;
}
