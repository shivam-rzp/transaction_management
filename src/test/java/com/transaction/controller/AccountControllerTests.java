package com.transaction.controller;

import com.transaction.entity.Account;
import com.transaction.model.AccountRequestDTO;
import com.transaction.service.AccountService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(AccountsController.class)
public class AccountControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    @Test
    public void testCreateAccount() throws Exception {

        Account account = new Account();
        account.setAccountId(2l);
        account.setDocumentNumber(11213l);

        Mockito.when(accountService.createAccount(Mockito.any(AccountRequestDTO.class))).thenReturn(account);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/accounts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"documentNumber\": 1234 }")) // Example JSON payload
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.accountId").exists());
    }


}
