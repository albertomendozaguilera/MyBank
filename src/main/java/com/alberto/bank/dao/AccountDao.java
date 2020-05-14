package com.alberto.bank.dao;

import com.alberto.bank.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Sergio
 */
@Repository
public interface AccountDao extends JpaRepository<Account, Integer>{
    
}