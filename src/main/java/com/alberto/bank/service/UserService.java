package com.alberto.bank.service;

import com.alberto.bank.dao.UserDao;
import com.alberto.bank.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author wutuf
 */
@Service
public class UserService {
    
    @Autowired
     UserDao userDao;
    
    public List<User> getAllUsers() {
         return this.userDao.findAll();
     }
 
     public User addUser(User user) {
         return this.userDao.save(user);
     }
}
