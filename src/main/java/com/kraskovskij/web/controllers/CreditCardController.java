package com.kraskovskij.web.controllers;

import com.kraskovskij.model.dao.CreditCardDAO;
import com.kraskovskij.model.entity.CreditCard;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ApplicationScoped
public class CreditCardController implements Serializable {

    private CreditCardDAO creditCardDAO;
    private List<CreditCard> cards;
    private CreditCard card;

    public CreditCardController() {
        cards = getCardsFromDB();
    }

    private List<CreditCard> getCardsFromDB() {

        creditCardDAO = new CreditCardDAO();
        List<CreditCard> cards = creditCardDAO.getAllCards();
        return cards;
    }

    public String findByNum(CreditCard creditCard) {

        for (CreditCard tmp : cards)
            if (tmp.getNumber().equals(creditCard.getNumber()))
                card = creditCard;
        return "/adminCard.xhtml?faces-redirect=true";
    }


    //getters and setters
    public List<CreditCard> getCards() {
        return cards;
    }

    public void setCards(List<CreditCard> cards) {
        this.cards = cards;
    }

    public CreditCard getCard() {
        return card;
    }

    public void setCard(CreditCard card) {
        this.card = card;
    }

    public void setOneCardToDB(){

        for (CreditCard tmp: cards)
            if(tmp.getId() == card.getId())
                card = tmp;

        creditCardDAO = new CreditCardDAO();
        creditCardDAO.updateOneCard(card);
    }
}
