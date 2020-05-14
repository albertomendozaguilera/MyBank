package com.alberto.bank.service;

import com.alberto.bank.dao.AccountDao;
import com.alberto.bank.dto.AccountDTO;
import com.alberto.bank.model.Account;
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
    AccountDao accountDao;
    
    @Autowired
    AccountToAccountDTOConverter accountToAccountDTOConverter;
    
    @Autowired
    AccountDTOToAccountConverter accountDTOToAccountConverter;
    
    public List<AccountDTO> getAllAccounts() {
        List<AccountDTO> accountDTOList = new ArrayList();
        List<Account> accounts = this.accountDao.findAll();
        accounts.forEach((account) -> {
            accountDTOList.add(accountToAccountDTOConverter.populate(account));
        });
         return accountDTOList;
     }
 
     public AccountDTO addAccount(AccountDTO accountDTO) {
         return accountToAccountDTOConverter.populate(accountDao.save(accountDTOToAccountConverter.populate(accountDTO)));
     }
    
}
