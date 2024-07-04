package com.transaction.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "account")
public class Account extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "document_number")
    private Long documentNumber;


}
