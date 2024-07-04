package com.transaction.controller;

import com.transaction.entity.Account;
import com.transaction.entity.Transaction;
import com.transaction.model.AccountResponseDTO;
import com.transaction.model.ApiResponse;
import com.transaction.model.TransactionCreateRequestDTO;
import com.transaction.model.TransactionCreateResponseDTO;
import com.transaction.repository.TransactionRepository;
import com.transaction.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@Validated
@RequestMapping("api/v1/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<ApiResponse<TransactionCreateResponseDTO>> createTransaction(@Valid @RequestBody TransactionCreateRequestDTO transactionCreateRequestDTO) {

        Transaction transaction = transactionService.createTransaction(transactionCreateRequestDTO);

        TransactionCreateResponseDTO responseDTO = transformToTransactionResponseDTO(transaction);

        ApiResponse<TransactionCreateResponseDTO> response = new ApiResponse<>(true, "Transaction created successfully", responseDTO);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    private TransactionCreateResponseDTO transformToTransactionResponseDTO (Transaction transaction) {

        TransactionCreateResponseDTO responseDTO = new TransactionCreateResponseDTO();
        responseDTO.setTransactionId(transaction.getTransactionId());
        responseDTO.setAmount(transaction.getAmount());
        responseDTO.setAccountId(transaction.getAccountId());
        responseDTO.setOperationTypeId(transaction.getOperationTypeId());

        return responseDTO;
    }
}
