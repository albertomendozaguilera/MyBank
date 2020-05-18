package com.alberto.bank.repository;

import com.alberto.bank.dao.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author wutuf
 */
@Repository
public interface UserRepository extends JpaRepository<UserDAO, Integer>{

}
