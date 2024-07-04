package com.transaction.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "transaction")
@Data
public class Transaction extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long transactionId;

    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "operation_type_id")
    private Long operationTypeId;

    private Double amount;

}
