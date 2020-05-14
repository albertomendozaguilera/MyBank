package com.alberto.bank.dao;

import com.alberto.bank.model.PaymentTransactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author wutuf
 */
@Repository
public interface PaymentTransactionsDao extends JpaRepository<PaymentTransactions, Integer>{
    
}