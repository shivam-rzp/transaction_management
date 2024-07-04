package com.transaction.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "operation-type")
public class OperationType extends Auditable {

    @Id
    @Column(name = "operation_type_id")
    private Long operationTypeId;

    @Column(name = "description")
    private String description;


}
