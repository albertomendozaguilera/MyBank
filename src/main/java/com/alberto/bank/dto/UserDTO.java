/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alberto.bank.dto;

/**
 *
 * @author Sergio
 */
public class UserDTO {
    
    private String id;
    private String name;
    private String email;
    private boolean blacklist;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isBlacklist() {
        return blacklist;
    }

    public void setBlacklist(boolean blacklist) {
        this.blacklist = blacklist;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
