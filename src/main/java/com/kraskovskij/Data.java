package com.kraskovskij;

import com.kraskovskij.model.entity.CreditCard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "data", eager = true)
@SessionScoped
public class Data implements Serializable {

    private static final long serialVersionUID = 1L;

    public int id;
    public String data;
    public CreditCard card = new CreditCard();

    public String moveToSomePage(){
        return data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String findNum(String number){
        List<CreditCard> cards = new ArrayList<CreditCard>();
        for (CreditCard tmp: cards) {
            if (tmp.getNumber().equals(number))
                card = tmp;
        }
        return "/adminCard.xhtml?faces-redirect=true";
    }

    public CreditCard getCard() {
        return card;
    }

    public void setCard(CreditCard card) {
        this.card = card;
    }
}
