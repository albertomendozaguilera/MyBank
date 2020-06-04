package com.alberto.bank.service;

import com.alberto.bank.repository.UserRepository;
import com.alberto.bank.dto.UserDTO;
import com.alberto.bank.dao.UserDao;
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
        List<UserDao> userDaos = this.userRepository.findAll();
        userDaos.forEach((user) -> {
            userDTOList.add(userToUserDTOConverter.populate(user));
        });
        return userDTOList;
     }


     public UserDTO getUserById(String id) {

         List<UserDao> userDAOS;
         List<UserDTO> userDTOList = new ArrayList();
         UserDTO user = new UserDTO();
         UserDao userDao = new UserDao();

         userDao = this.userRepository.findById(id);
         user = userToUserDTOConverter.populate(userDao);

         return user;
     }
 
     public UserDTO addUser(UserDTO userDTO) {
         return userToUserDTOConverter.populate(userRepository.save(userDTOToUserConverter.populate(userDTO)));
     }
}
