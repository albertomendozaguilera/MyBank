package com.alberto.bank.repository;

import com.alberto.bank.dao.AccountDAO;

import java.util.List;

import com.alberto.bank.dao.UserDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author wutuf
 */
@Repository
public interface AccountRepository extends JpaRepository<AccountDAO, Integer>{
    List<AccountDAO> findByUserDAO(UserDao userId);
}
