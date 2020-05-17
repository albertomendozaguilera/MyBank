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
public class AccountDTOToAccountConverter {
    
    @Autowired
    UserDTOToUserConverter userDTOToUserConverter;
    
    public AccountDAO populate(AccountDTO accountDTO){
        AccountDAO accountDAO = new AccountDAO();
        accountDAO.setUserDAO(userDTOToUserConverter.populate(accountDTO.getUserDTO()));
        accountDAO.setIban(accountDTO.getIban());
        accountDAO.setName(accountDTO.getName());
        accountDAO.setBalance(accountDTO.getBalance());
        return accountDAO;
    }
}
