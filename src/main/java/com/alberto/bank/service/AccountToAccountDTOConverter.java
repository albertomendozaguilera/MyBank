package com.alberto.bank.service;

import com.alberto.bank.dto.AccountDTO;
import com.alberto.bank.model.Account;
import org.springframework.stereotype.Service;

/**
 *
 * @author wutuf
 */
@Service
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
