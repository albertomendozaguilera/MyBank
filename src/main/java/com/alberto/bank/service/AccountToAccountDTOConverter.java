package com.alberto.bank.service;

import com.alberto.bank.dto.AccountDTO;
import com.alberto.bank.dao.AccountDAO;
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
    
    public AccountDTO populate(AccountDAO accountDAO){
        AccountDTO accountDTO = new AccountDTO();
        
        accountDTO.setUserDTO(userToUserDTOConverter.populate(accountDAO.getUserDAO()));
        accountDTO.setIban(accountDAO.getIban());
        accountDTO.setName(accountDAO.getName());
        accountDTO.setBalance(accountDAO.getBalance());
        return accountDTO;
    } 
}
