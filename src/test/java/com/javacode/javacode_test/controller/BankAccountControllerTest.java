package com.javacode.javacode_test.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.javacode.javacode_test.dto.DepositOrWithdraw;
import com.javacode.javacode_test.dto.GetWalletInfo;
import com.javacode.javacode_test.dto.UpdateBalance;
import com.javacode.javacode_test.service.BankAccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BankAccountController.class)
@Import(BankAccountController.class)
public class BankAccountControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BankAccountService bankAccountService;

    @Autowired
    private ObjectMapper objectMapper;

    static UUID uuid = UUID.fromString("1ad33264-449d-4ecc-b217-83b525599552");

    static UpdateBalance withdrawOrDepositTest = new UpdateBalance(UUID.fromString("1ad33264-449d-4ecc-b217-83b525599552"), DepositOrWithdraw.DEPOSIT, 1000.0);

    static GetWalletInfo withdrawOrDepositMethodReturn = new GetWalletInfo(UUID.fromString("1ad33264-449d-4ecc-b217-83b525599552"), "Dmitry", 3000.0);

    @Test
    void shouldReturnNewBalanceAfterDeposit() throws Exception {

        when(bankAccountService.updateBalanceOfBankAccount(any(UpdateBalance.class))).thenReturn(withdrawOrDepositMethodReturn);

        mvc.perform(MockMvcRequestBuilders.post("/api/v1/wallet")
                        .content(objectMapper.writeValueAsString(withdrawOrDepositTest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.walletId").value("1ad33264-449d-4ecc-b217-83b525599552"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.clientName").value("Dmitry"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.accountBalance").value(3000.0))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturnWalletInfoByUUID() throws Exception {

        when(bankAccountService.getBankAccountByUUID(uuid)).thenReturn(withdrawOrDepositMethodReturn);

        mvc.perform(MockMvcRequestBuilders.get("/api/v1/wallets/{uuid}", uuid)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.walletId").value("1ad33264-449d-4ecc-b217-83b525599552"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.clientName").value("Dmitry"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.accountBalance").value(3000.0))
                .andExpect(status().isOk());

        verify(bankAccountService, only()).getBankAccountByUUID(uuid);
    }
}
