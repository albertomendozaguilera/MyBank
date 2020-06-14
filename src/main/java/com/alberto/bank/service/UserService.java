package com.alberto.bank.service;

import com.alberto.bank.repository.UserRepository;
import com.alberto.bank.dto.UserDTO;
import com.alberto.bank.dao.UserDAO;
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
    UserRepository userRepository;
    
    @Autowired
    UserToUserDTOConverter userToUserDTOConverter;
    
    @Autowired
    UserDTOToUserConverter userDTOToUserConverter;
    
    public List<UserDTO> getAllUsers() {
        List<UserDTO> userDTOList = new ArrayList();
        List<UserDAO> userDaos = this.userRepository.findAll();
        userDaos.forEach((user) -> {
            userDTOList.add(userToUserDTOConverter.populate(user));
        });
        return userDTOList;
     }


     public UserDTO getUserById(String id) {

         UserDTO user;
         UserDAO userDao;

         userDao = this.userRepository.findById(id);
         user = userToUserDTOConverter.populate(userDao);

         return user;
     }
 
     public void addUser(UserDTO userDTO) {
        userRepository.save(userDTOToUserConverter.populate(userDTO));
     }
}
