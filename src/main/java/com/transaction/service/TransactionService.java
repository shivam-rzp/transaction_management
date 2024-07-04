package com.transaction.service;

import com.transaction.entity.Account;
import com.transaction.entity.OperationType;
import com.transaction.entity.Transaction;
import com.transaction.exception.ResourceNotFoundException;
import com.transaction.model.TransactionCreateRequestDTO;
import com.transaction.repository.AccountRepository;
import com.transaction.repository.OperationTypeRepository;
import com.transaction.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private OperationTypeRepository operationTypeRepository;

    @Transactional
    public Transaction createTransaction(TransactionCreateRequestDTO transactionCreateRequestDTO) {

        Optional<Account> accountOpt = accountRepository.findById(transactionCreateRequestDTO.getAccountId());
        if (accountOpt.isEmpty()) {
            throw new ResourceNotFoundException("Account not found");
        }

        Optional<OperationType> operationTypeOpt = operationTypeRepository.findById(transactionCreateRequestDTO.getOperationTypeId());
        if (operationTypeOpt.isEmpty()){
            throw new ResourceNotFoundException("Operation type not found");
        }


        Transaction transaction = transformToTransactionEntity(transactionCreateRequestDTO);

        return transactionRepository.save(transaction);
    }

    private Transaction transformToTransactionEntity(TransactionCreateRequestDTO transactionCreateRequestDTO) {

        Transaction transaction = new Transaction();
        transaction.setAmount(transactionCreateRequestDTO.getAmount());
        transaction.setAccountId(transactionCreateRequestDTO.getAccountId());
        transaction.setOperationTypeId(transactionCreateRequestDTO.getOperationTypeId());

        return transaction;

    }
}
