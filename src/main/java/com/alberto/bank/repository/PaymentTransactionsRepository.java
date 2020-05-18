package com.alberto.bank.repository;

import com.alberto.bank.dao.PaymentTransactionsDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author wutuf
 */
@Repository
public interface PaymentTransactionsRepository extends JpaRepository<PaymentTransactionsDAO, Integer>{
    
}