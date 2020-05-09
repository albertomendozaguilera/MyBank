package com.alberto.bank.service;

import com.alberto.bank.dao.UserDao;
import com.alberto.bank.dto.UserDTO;
import com.alberto.bank.model.User;
import java.util.ArrayList;
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
    
    @Autowired
    UserToUserDTOConverter userToUserDTOConverter;
    
    public List<UserDTO> getAllUsers() {
        List<UserDTO> userDTOList = new ArrayList();
        List<User> users = this.userDao.findAll();
        users.forEach((user) -> {
            userDTOList.add(userToUserDTOConverter.populate(user));
        });
         return userDTOList;
     }
 
     public User addUser(User user) {
         return this.userDao.save(user);
     }
}
