package com.alberto.bank.dao;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "PAYMENT_WAYSS")
public class PaymentWayDAO implements Serializable {
    @Column(name = "COD")
    @Id
    private String cod;

    @Column(name = "DESCRIPTION", nullable = false, length = 100)
    private String description;

    @Column(name = "NUM_RECEIPTS", nullable = false,length = 3)
    private int numReceipts;

    @Column(name = "COMISSION", nullable = false,length = 7)
    private double comission;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumReceipts() {
        return numReceipts;
    }

    public void setNumReceipts(int numReceipts) {
        this.numReceipts = numReceipts;
    }

    public double getComission() {
        return comission;
    }

    public void setComission(double comission) {
        this.comission = comission;
    }
}
