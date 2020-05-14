/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alberto.bank.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author wutuf
 */
@Entity
@Table(name="ACCOUNTS")
public class Account implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USERID")
    private User user;
    
    @Column(name = "IBAN")
    @Id
    private String iban;
    
    @Column(name = "NAME", nullable = false, length = 100)
    private String name;
    
    @Column(name = "BALANCE", nullable = false, length = 12)
    private double balance;

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    
    
}
