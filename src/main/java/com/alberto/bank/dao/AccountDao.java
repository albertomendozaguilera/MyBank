package com.alberto.bank.dao;

import com.alberto.bank.model.Account;
import com.alberto.bank.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Sergio
 */
@Repository
public interface AccountDao extends JpaRepository<Account, Integer>{
    
    //List<Customer> findByName(String name);
    List<Account> findByUserId(String userId);
}
