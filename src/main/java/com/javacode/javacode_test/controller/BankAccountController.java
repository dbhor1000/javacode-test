package com.javacode.javacode_test.controller;

import com.javacode.javacode_test.dto.GetWalletInfo;
import com.javacode.javacode_test.dto.UpdateBalance;
import com.javacode.javacode_test.model.BankAccount;
import com.javacode.javacode_test.service.BankAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class BankAccountController {

    private final BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @PostMapping("/wallet")
    public ResponseEntity<?> modifyBalance(@RequestBody UpdateBalance updateBalance) {

        GetWalletInfo bankAccountFound = bankAccountService.updateBalanceOfBankAccount(updateBalance);
        if(bankAccountFound != null) {
            return ResponseEntity.ok(bankAccountFound);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/wallets/{uuid}")
    public ResponseEntity<?> modifyBalance(@PathVariable UUID uuid) {

        GetWalletInfo bankAccountFound = bankAccountService.getBankAccountByUUID(uuid);
        if(bankAccountFound != null) {
            return ResponseEntity.ok(bankAccountFound);
        }
        return ResponseEntity.notFound().build();
    }


}
