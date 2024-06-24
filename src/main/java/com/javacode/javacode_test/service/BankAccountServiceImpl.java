package com.javacode.javacode_test.service;

import com.javacode.javacode_test.dto.DepositOrWithdraw;
import com.javacode.javacode_test.dto.GetWalletInfo;
import com.javacode.javacode_test.dto.UpdateBalance;
import com.javacode.javacode_test.mapping.BankAccountMappingImpl;
import com.javacode.javacode_test.model.BankAccount;
import com.javacode.javacode_test.repository.BankAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Transactional
@Service
public class BankAccountServiceImpl implements BankAccountService {

    private final BankAccountRepository bankAccountRepository;
    private final BankAccountMappingImpl bankAccountMapping;

    public BankAccountServiceImpl(BankAccountRepository bankAccountRepository, BankAccountMappingImpl bankAccountMapping) {
        this.bankAccountRepository = bankAccountRepository;
        this.bankAccountMapping = bankAccountMapping;
    }

    public GetWalletInfo getBankAccountByUUID(UUID uuid) {

        BankAccount bankAccountFound = bankAccountRepository.getReferenceByWalletId(uuid);
        return bankAccountMapping.BankAccountToGetWalletInfoMap(bankAccountFound);
    }

    public GetWalletInfo updateBalanceOfBankAccount(UpdateBalance updateBalance) {

        BankAccount bankAccountFound = bankAccountRepository.getReferenceByWalletId(updateBalance.getWalletUUID());

        if (bankAccountFound != null) {
            if (updateBalance.getOperationType().equals(DepositOrWithdraw.DEPOSIT)) {
                bankAccountRepository.updateBalance(updateBalance.getWalletUUID(), updateBalance.getAmount());
                bankAccountFound.setAccountBalance(bankAccountFound.getAccountBalance() + updateBalance.getAmount());
            } else if (updateBalance.getOperationType().equals(DepositOrWithdraw.WITHDRAW)) {
                if(bankAccountFound.getAccountBalance() < updateBalance.getAmount()){
                    return null;
                }
                bankAccountRepository.updateBalance(updateBalance.getWalletUUID(), (-updateBalance.getAmount()));
                bankAccountFound.setAccountBalance(bankAccountFound.getAccountBalance() - updateBalance.getAmount());
            }
            return bankAccountMapping.BankAccountToGetWalletInfoMap(bankAccountFound);
        } else {
            return null;
        }

    }
}
