package com.transaction.service;

import com.transaction.entity.Account;
import com.transaction.model.AccountRequestDTO;
import com.transaction.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;


import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;

    private Account account;

    @BeforeEach
    public void setUp() {
        account = new Account();
        account.setAccountId(1l);
        account.setDocumentNumber(1233l);
    }

    @Test
    public void whenCreateByDocumentNumber_thenAccountShouldBeCreated() {
        when(accountRepository.save(Mockito.any(Account.class))).thenReturn(account);

        AccountRequestDTO accountRequestDTO = new AccountRequestDTO();
        accountRequestDTO.setDocumentNumber(1233l);

        Account found = accountService.createAccount(accountRequestDTO);

        assertThat(found.getDocumentNumber()).isEqualTo(1233l);
    }

}
