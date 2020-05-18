package com.alberto.bank.repository;

import com.alberto.bank.dao.AccountDAO;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Sergio
 */
@Repository
public interface AccountRepository extends JpaRepository<AccountDAO, Integer>{
    
    //List<Customer> findByName(String name);
    List<AccountDAO> findByUserDAO(String userId);
}
