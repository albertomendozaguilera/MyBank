package com.alberto.bank.service;

import com.alberto.bank.dto.AccountDTO;
import com.alberto.bank.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author wutuf
 */
@Service
public class AccountToAccountDTOConverter {
    
    @Autowired
    UserToUserDTOConverter userToUserDTOConverter;
    
    public AccountDTO populate(Account account){
        AccountDTO accountDTO = new AccountDTO();
        
        accountDTO.setUserDTO(userToUserDTOConverter.populate(account.getUser()));
        accountDTO.setIban(account.getIban());
        accountDTO.setName(account.getName());
        accountDTO.setBalance(account.getBalance());
        return accountDTO;
    } 
}
