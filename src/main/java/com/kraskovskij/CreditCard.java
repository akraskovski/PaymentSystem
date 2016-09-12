package com.kraskovskij;

public class CreditCard {

    private int id;
    private String number;
    private int pin;
    private String owner;
    private double cash;
    private boolean status;

    public CreditCard(String number, int pin, String owner, double cash) {
        this.number = number;
        this.pin = pin;
        this.owner = owner;
        this.cash = cash;
    }

    public CreditCard() {

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
}
