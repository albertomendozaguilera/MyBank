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
    
}
