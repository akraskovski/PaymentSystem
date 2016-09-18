package com.kraskovskij.model.dao;

import java.util.List;

import com.kraskovskij.model.util.HibernateUtil;
import com.kraskovskij.model.entity.CreditCard;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CreditCardDAO {

    Session session = null;

    public CreditCardDAO() {
        this.session = HibernateUtil.getSessionFactory().openSession();
        //Check if mistakes
    }

    public List<CreditCard> getAllCards() {

        String query = "select p from " + CreditCard.class.getSimpleName() + " p";
        session.beginTransaction();
        @SuppressWarnings("unchecked")
        List<CreditCard> result = session.createQuery(query).list();
        session.getTransaction().commit();
        return result;
    }

    public void updateOneCard(CreditCard card) {

        session.beginTransaction();
        String SQLQuery = "update creditcard set number = :numberParam, owner = :ownerParam, cash = :cashParam, status = :statusParam where id = :idCode";
        Query query = session.createSQLQuery(SQLQuery);

        query.setParameter("numberParam", card.getNumber());
        query.setParameter("ownerParam", card.getOwner());
        query.setParameter("cashParam", card.getCash());
        query.setParameter("statusParam", card.isStatus());
        query.setParameter("idCode", card.getId());

        query.executeUpdate();

        session.getTransaction().commit();
        //session.close();
    }

}
