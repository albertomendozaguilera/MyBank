package com.alberto.bank.service;

import com.alberto.bank.dao.AccountDao;
import com.alberto.bank.dto.AccountDTO;
import com.alberto.bank.model.Account;
import com.alberto.bank.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
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
    
    public List<AccountDTO> getAccountsByUserId(String userId){
        List<Account> accounts;
        List<AccountDTO> accountsList = new ArrayList();
        
        ExampleMatcher caseInsensitiveExampleMatcher = ExampleMatcher.matchingAll().withIgnoreCase();
        Account account = new Account();
        User user = new User();
        user.setId(userId);
        account.setUser(user);

        //Example<Account> example = Example.of(account, caseInsensitiveExampleMatcher);
        
        //accounts = (List<Account>) this.accountDao.findAll(example);
        accounts =  this.accountDao.findByUserId(user.getId());
        
        accounts.forEach((accountItem) -> {
            accountsList.add(accountToAccountDTOConverter.populate(accountItem));
        });
        
        return accountsList;
    }
 
     public AccountDTO addAccount(AccountDTO accountDTO) {
         return accountToAccountDTOConverter.populate(accountDao.save(accountDTOToAccountConverter.populate(accountDTO)));
     }
    
}
