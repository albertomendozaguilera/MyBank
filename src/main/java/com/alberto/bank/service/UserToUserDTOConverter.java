package com.alberto.bank.service;

import com.alberto.bank.dto.UserDTO;
import com.alberto.bank.dao.UserDAO;
import org.springframework.stereotype.Service;

/**
 *
 * @author wutuf
 */
@Service
public class UserToUserDTOConverter {
    
    public UserDTO populate(UserDAO userDAO){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userDAO.getId());
        userDTO.setName(userDAO.getName());
        userDTO.setEmail(userDAO.getEmail());
        userDTO.setBlacklist(isBlacklisted(userDAO.getBlacklist()));
        return userDTO;
    } 
    
    private boolean isBlacklisted(String blacklist){
        return !blacklist.equals("0");
    }
}
