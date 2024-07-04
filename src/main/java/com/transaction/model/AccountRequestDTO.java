package com.transaction.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;

@Data
public class AccountRequestDTO {

    @NotNull(message = "DocumentNumber is mandatory")
    private Long documentNumber;
}
