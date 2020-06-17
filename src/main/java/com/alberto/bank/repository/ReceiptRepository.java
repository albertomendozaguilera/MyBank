package com.alberto.bank.repository;


import com.alberto.bank.dao.LoanDAO;
import com.alberto.bank.dao.ReceiptDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReceiptRepository extends JpaRepository<ReceiptDAO, Integer> {
    List<ReceiptDAO> findByLoanDAO(LoanDAO loanId);
}
