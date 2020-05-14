/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alberto.bank.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.*;

/**
 *
 * @author wutuf
 */
@Entity
@Table(name="ACCOUNTS")
public class Account implements Serializable {
    
    @Column(name = "IBAN")
    @Id
    private String iban;
    
    @ManyToOne
    @JoinColumn(name = "ID")
    @Column (name = "USERID")
    private String userID;
    
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

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
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
