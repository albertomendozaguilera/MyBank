package com.alberto.bank.service;

import com.alberto.bank.repository.AccountRepository;
import com.alberto.bank.dto.AccountDTO;
import com.alberto.bank.dao.AccountDAO;
import com.alberto.bank.dao.UserDAO;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author wutuf
 */
@Service
public class AccountService {
    
    @Autowired
    AccountRepository accountRepository;
    
    @Autowired
    AccountToAccountDTOConverter accountToAccountDTOConverter;
    
    @Autowired
    AccountDTOToAccountConverter accountDTOToAccountConverter;
    
    public List<AccountDTO> getAllAccounts() {
        List<AccountDTO> accountDTOList = new ArrayList();
        List<AccountDAO> accountDAOS = this.accountRepository.findAll();
        accountDAOS.forEach((account) -> {
            accountDTOList.add(accountToAccountDTOConverter.populate(account));
        });
         return accountDTOList;
     }
    
    public List<AccountDTO> getAccountsByUserId(String userId){
        List<AccountDAO> accountDAOS;
        List<AccountDTO> accountsList = new ArrayList();

        UserDAO userDAO = new UserDAO();
        userDAO.setId(userId);

        accountDAOS =  this.accountRepository.findByUserDAO(userDAO);

        accountDAOS.forEach((accountItem) -> {
            accountsList.add(accountToAccountDTOConverter.populate(accountItem));
        });
        
        return accountsList;
    }
 
     public AccountDTO addAccount(AccountDTO accountDTO) {
         return accountToAccountDTOConverter.populate(accountRepository.save(accountDTOToAccountConverter.populate(accountDTO)));
     }
    
}
