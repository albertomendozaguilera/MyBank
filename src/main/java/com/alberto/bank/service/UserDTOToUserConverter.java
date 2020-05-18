package com.alberto.bank.service;

import com.alberto.bank.dto.UserDTO;
import com.alberto.bank.dao.UserDao;
import org.springframework.stereotype.Service;

/**
 *
 * @author wutuf
 */
@Service
public class UserDTOToUserConverter {
    public UserDao populate(UserDTO userDTO){
        UserDao userDAO = new UserDao();
        userDAO.setId(userDTO.getId());
        userDAO.setName(userDTO.getName());
        userDAO.setEmail(userDTO.getEmail());
        userDAO.setBlacklist(isBlacklisted(userDTO.isBlacklist()));
        return userDAO;
    } 
    
    private String isBlacklisted(boolean blacklist){
        return blacklist ? "1" : "0";
    }
}
