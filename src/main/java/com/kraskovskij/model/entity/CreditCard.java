package com.kraskovskij.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "creditcard")
public class CreditCard {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "number")
    private String number;

    @Column(name = "pin")
    private int pin;

    @Column(name = "owner")
    private String owner;

    @Column(name = "cash")
    private double cash;

    @Column(name = "status")
    private boolean status;

    public CreditCard() {
    }

    public CreditCard(int id, String number, int pin, String owner, double cash, boolean status) {
        this.id = id;
        this.number = number;
        this.pin = pin;
        this.owner = owner;
        this.cash = cash;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CreditCardEntity{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", pin=" + pin +
                ", owner='" + owner + '\'' +
                ", cash=" + cash +
                ", status=" + status +
                '}';
    }
}