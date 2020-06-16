package com.alberto.bank.repository;


import com.alberto.bank.dao.AccountDAO;
import com.alberto.bank.dao.LoanDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<LoanDAO, Integer> {
    List<LoanDAO> findByAccountDAO(AccountDAO accountDAO);
}
