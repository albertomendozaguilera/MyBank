package com.alberto.bank.service;

import com.alberto.bank.dto.AccountDTO;
import com.alberto.bank.model.Account;
import org.springframework.stereotype.Service;

/**
 *
 * @author wutuf
 */
@Service
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
