package com.transaction.controller;

import com.transaction.entity.Account;
import com.transaction.entity.Transaction;
import com.transaction.model.AccountRequestDTO;
import com.transaction.model.TransactionCreateRequestDTO;
import com.transaction.service.AccountService;
import com.transaction.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(TransactionController.class)
public class TransactionControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransactionService transactionService;

    @Test
    public void testCreateTransaction() throws Exception {

        Transaction transaction = new Transaction();
        transaction.setOperationTypeId(1l);
        transaction.setAmount(121d);
        transaction.setAccountId(2l);

        Mockito.when(transactionService.createTransaction(Mockito.any(TransactionCreateRequestDTO.class))).thenReturn(transaction);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/transactions")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"accountId\": 2, \"amount\": 121, \"operationTypeId\":1  }")) // Example JSON payload
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.amount").exists());
    }

}
