package com.alberto.bank.service;

import com.alberto.bank.dto.AccountDTO;
import com.alberto.bank.model.Account;
import com.alberto.bank.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author wutuf
 */
@Service
public class AccountDTOToAccountConverter {
    
    @Autowired
    UserDTOToUserConverter userDTOToUserConverter;
    
    public Account populate(AccountDTO accountDTO){
        Account account = new Account();
        account.setUser(userDTOToUserConverter.populate(accountDTO.getUserDTO()));
        account.setIban(accountDTO.getIban());
        account.setName(accountDTO.getName());
        account.setBalance(accountDTO.getBalance());
        return account;
    }
}
