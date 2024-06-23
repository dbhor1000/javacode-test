package com.javacode.javacode_test.dto;

import java.util.UUID;

public class GetWalletInfo {
    private UUID walletId;
    private String clientName;
    private double accountBalance;

    public GetWalletInfo() {
    }

    public GetWalletInfo(UUID walletId, String clientName, double accountBalance) {
        this.walletId = walletId;
        this.clientName = clientName;
        this.accountBalance = accountBalance;
    }

    public UUID getWalletId() {
        return walletId;
    }

    public void setWalletId(UUID walletId) {
        this.walletId = walletId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
}

