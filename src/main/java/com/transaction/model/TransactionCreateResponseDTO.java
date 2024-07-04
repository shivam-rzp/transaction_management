package com.transaction.model;

import lombok.Data;

@Data
public class TransactionCreateResponseDTO {

    private Long transactionId;
    private Long accountId;
    private Double amount;
    private Long operationTypeId;

}
