package musor;

import com.kraskovskij.model.entity.CreditCard;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import java.util.List;
import org.hibernate.service.ServiceRegistry;

import java.io.Serializable;

//@ManagedBean
//@SessionScoped
public class CreditCardUtil implements Serializable{

    private Session session = null;
    private List<CreditCard> cards;
    public CreditCardUtil() {
/*
        //session create
        session = createHibernateSession();

        //reading information from database table
        if(session != null){
            cards = readFromDB();
            if (session.isOpen())
                session.close();
        }*/
    }

    private Session createHibernateSession(){

        SessionFactory sessionFactory = null;
        ServiceRegistry serviceRegistry = null;

        try{
            try{
                Configuration cfg = new Configuration().addResource("creditcard.hbm.xml").configure();
                serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
                sessionFactory = cfg.buildSessionFactory(serviceRegistry);
            } catch (Throwable e){
                System.err.println("Failed to create sessionFactory object." + e);
                throw new ExceptionInInitializerError(e);
            }
            session = sessionFactory.openSession();
            System.out.println("Session creating...");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return session;
    }

    /*private List<CreditCard> readFromDB() {

        System.out.println("Reading information from database...");
        String query = "select p from " + CreditCard.class.getSimpleName() + " p";

        @SuppressWarnings("unchecked")
        List<CreditCard> list = (List<CreditCard>)session.createQuery(query).list();
        //System.out.println(list);
        //System.out.println(list.get(0).getOwner());
        return list;
    }*/

    public List<CreditCard> getCards() {
        return cards;
    }

    public void setCards(List<CreditCard> cards) {
        this.cards = cards;
    }
}
