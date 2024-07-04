package com.transaction.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TransactionCreateRequestDTO {

    @NotNull(message = "Operation type is mandatory")
    private Long operationTypeId;
    @NotNull(message = "Amount is mandatory")
    private Double amount;
    @NotNull(message = "AccountId  is mandatory")
    private Long accountId;
}
