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
public class AccountToAccountDTOConverter {
    public AccountDTO populate(Account account){
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUserId(account.getUserID());
        accountDTO.setIban(account.getIban());
        accountDTO.setName(account.getName());
        accountDTO.setBalance(account.getBalance());
        return accountDTO;
    } 
}
