package com.alberto.bank.repository;

import com.alberto.bank.dao.AccountDAO;
import com.alberto.bank.dao.PaymentTransactionsDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author wutuf
 */
@Repository
public interface PaymentTransactionsRepository extends JpaRepository<PaymentTransactionsDAO, Integer>{
    List<PaymentTransactionsDAO> findByAccountDAO(AccountDAO accountIban);

    @Procedure("TR_UPDATE_ACCOUNT_QUANTITY")
    int insertPaymentTransaction(String originAccount, double quantity, String concept, String destinyAccount, String beneficiary);
}