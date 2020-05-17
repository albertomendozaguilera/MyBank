package com.alberto.bank.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;


/**
 *
 * @author wutuf
 */
@Entity
@Table(name = "USERS")
public class UserDAO implements Serializable {

    @Column(name = "ID")
    @Id
    private String id;
    
    @Column(name = "NAME", nullable = false, length = 100)
    private String name;
    
    @Column(name = "EMAIL", nullable = false,length = 500)
    private String email;
    
    @Column(name = "BLACKLIST", nullable = false,length = 1)
    private String blacklist;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<AccountDAO> accountDAOS;
    
    public UserDAO(){
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getBlacklist() {
        return blacklist;
    }

    public void setBlacklist(String blacklist) {
        this.blacklist = blacklist;
    }

    public List<AccountDAO> getAccountDAOS() {
        return accountDAOS;
    }

    public void setAccountDAOS(List<AccountDAO> accountDAOS) {
        this.accountDAOS = accountDAOS;
    }
    
    
    
}
