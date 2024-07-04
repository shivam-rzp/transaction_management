package com.transaction.service;

import com.transaction.entity.Account;
import com.transaction.model.AccountRequestDTO;
import com.transaction.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(AccountRequestDTO accountRequestDTO) {
        Account account = transformToAccountEntity(accountRequestDTO);
        return accountRepository.save(account);
    }

    public Account getAccountById(Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    private Account transformToAccountEntity(AccountRequestDTO accountRequestDTO) {
        Account account = new Account();
        account.setDocumentNumber(accountRequestDTO.getDocumentNumber());

        return account;
    }
}
