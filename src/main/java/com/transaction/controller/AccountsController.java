package com.transaction.controller;

import com.transaction.entity.Account;
import com.transaction.exception.ResourceNotFoundException;
import com.transaction.model.AccountRequestDTO;
import com.transaction.model.AccountResponseDTO;
import com.transaction.model.ApiResponse;
import com.transaction.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;


@RestController
@RequestMapping("api/v1/accounts")
@Validated
public class AccountsController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<ApiResponse<AccountResponseDTO>> createAccount(@Valid @RequestBody AccountRequestDTO accountRequestDTO) {

        Account account = accountService.createAccount(accountRequestDTO);

        AccountResponseDTO responseDTO = transformToAccountResponseDTO(account);

        ApiResponse<AccountResponseDTO> response = new ApiResponse<>(true, "Account created successfully", responseDTO);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<AccountResponseDTO>> getAccountById(@PathVariable Long id) {
        Account account = accountService.getAccountById(id);

        if (account == null) {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }

        AccountResponseDTO responseDTO = transformToAccountResponseDTO(account);

        ApiResponse<AccountResponseDTO> response = new ApiResponse<>(true, "Account fetched successfully", responseDTO);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    private AccountResponseDTO transformToAccountResponseDTO(Account account) {

        AccountResponseDTO responseDTO = new AccountResponseDTO();
        responseDTO.setAccountId(account.getAccountId());
        responseDTO.setDocumentNumber(account.getDocumentNumber());

        return responseDTO;
    }
}
