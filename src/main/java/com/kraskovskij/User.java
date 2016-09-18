package com.kraskovskij;

import com.kraskovskij.model.entity.CreditCard;

public class User {

    private String USERNAME;
    private String PASSWORD;
    private String NAME;
    private String SURNAME;

    CreditCard card = new CreditCard();

    public User(String USERNAME, String PASSWORD, String NAME, String SURNAME, CreditCard card) {
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;
        this.NAME = NAME;
        this.SURNAME = SURNAME;
        this.card = card;
    }

    public User(String USERNAME, String PASSWORD, String NAME, String SURNAME) {
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;
        this.NAME = NAME;
        this.SURNAME = SURNAME;
    }

    public User(String USERNAME, String PASSWORD) {
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;
    }

    public User() {

    }

    public CreditCard getCard() {
        return card;
    }

    public void setCard(CreditCard card) {
        this.card = card;
    }

    public String getUSERNAME() {

        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getSURNAME() {
        return SURNAME;
    }

    public void setSURNAME(String SURNAME) {
        this.SURNAME = SURNAME;
    }
}
