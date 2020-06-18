package com.alberto.bank.repository;

import com.alberto.bank.dao.AccountDAO;
import com.alberto.bank.dao.PaymentTransactionsDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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

    @Procedure("SP_INSERT_PAYMENT_TRANSACTION")
    void insertPaymentTransaction(String originAccount, double quantity, String concept, String destinyAccount, String beneficiary);
//    @Query(nativeQuery = true,value = "call TR_UPDATE_ACCOUNT_QUANTITY")  // call store procedure
//    void callProcedureTransaction();
}