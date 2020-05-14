/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alberto.bank.service;

import com.alberto.bank.dto.AccountDTO;
import com.alberto.bank.model.Account;

/**
 *
 * @author wutuf
 */
public class AccountDTOToAccountConverter {
    public Account populate(AccountDTO accountDTO){
        Account account = new Account();
        account.setUserID(accountDTO.getUserId());
        account.setIban(accountDTO.getIban());
        account.setName(accountDTO.getName());
        account.setBalance(accountDTO.getBalance());
        return account;
    }
}
