package com.alberto.bank.dao;

import com.alberto.bank.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author wutuf
 */
@Repository
public interface UserDao extends JpaRepository<User, Integer>{

}
