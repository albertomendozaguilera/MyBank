package com.alberto.bank.controller;

import com.alberto.bank.dto.UserDTO;
import com.alberto.bank.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author wutuf
 */
@RestController
@RequestMapping("/user")
public class UserController {
    
     @Autowired
     UserService userService;
 
     @RequestMapping(value = "/byid", method = RequestMethod.GET)
     public List<UserDTO> getUserFromId(@RequestParam(value = "userId") String userId) {
         return userService.getUserById(userId);
     }
 
     @RequestMapping(value = "/adduser", method = RequestMethod.POST,
             consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
     @ResponseBody()
     public UserDTO addNewUser(@RequestBody UserDTO userDTO) {
         return this.userService.addUser(userDTO);
     }
}
