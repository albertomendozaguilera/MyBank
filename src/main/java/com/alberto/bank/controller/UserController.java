package com.alberto.bank.controller;

import com.alberto.bank.model.User;
import com.alberto.bank.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author wutuf
 */
@RestController
@RequestMapping("/user")
public class UserController {
    
     @Autowired
     UserService userService;
 
     @RequestMapping(value = "/all", method = RequestMethod.GET)
     public List<User> getAllUsers() {
         return userService.getAllUsers();
     }
 
     @RequestMapping(value = "/adduser", method = RequestMethod.POST,
             consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
     @ResponseBody()
     public User addNewUser(@RequestBody User user) {
         return this.userService.addUser(user);
     }
}
