package musor;

import com.kraskovskij.model.entity.CreditCard;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

//@ManagedBean(name = "cardBean")
//@SessionScoped
public class CreditCardBean implements Serializable {

    private static final String URL = "jdbc:mysql://localhost:3306/paymentsystem";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String SELECT_NEW = "select card_id, number, pin, owner, cash, status from creditcards";
    //private static final String INSERT_NEW = "insert into creditcards values(?, ?, ?, ?, ?, ?)";

    PreparedStatement preparedStatement = null;
    Connection connection = null;
    public List<CreditCard> cards;
    public CreditCard card = new CreditCard();

    //connect to DB and get customer list
    public List<CreditCard> getCreditCardList() throws SQLException {

        cards = new ArrayList<CreditCard>();

        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        if (connection == null)
            throw new SQLException("Can't get database connection");

        cards = readFromDB(connection);
        return cards;
    }

    public List<CreditCard> readFromDB(Connection connection) throws SQLException {

        preparedStatement = connection.prepareStatement(SELECT_NEW);
        ResultSet result = preparedStatement.executeQuery();

        while (result.next()) {
            CreditCard tmp = new CreditCard();
            tmp.setId(result.getInt("card_id"));
            tmp.setNumber(result.getString("number"));
            tmp.setPin(result.getInt("pin"));
            tmp.setOwner(result.getString("owner"));
            tmp.setCash(result.getDouble("cash"));
            tmp.setStatus(result.getBoolean("status"));

            //store all data into a List
            cards.add(tmp);
        }
        return cards;
    }

    public void writeToDB(List<CreditCard> cards, Connection connection, String updateTableSQL) throws SQLException{
        /*for (CreditCard tmp: cards) {
            preparedStatement.setInt(1, tmp.getId());
            preparedStatement.setString(2, tmp.getNumber());
            preparedStatement.setInt(3, tmp.getPin());
            preparedStatement.setString(4, tmp.getOwner());
            preparedStatement.setDouble(5, tmp.getCash());
            preparedStatement.setBoolean(6, tmp.isStatus());

            preparedStatement.execute();
        }*/
    }

    public String findByNumber(CreditCard creditCard) {

        for (CreditCard tmp : cards)
            if (tmp.getNumber().equals(creditCard.getNumber()))
                card = creditCard;
        return "/adminCard.xhtml?faces-redirect=true";
    }

    public void setOneCardToDB(CreditCard card) throws SQLException{
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getId() == card.getId()) {
                cards.set(i, card);
                preparedStatement = connection.prepareStatement("UPDATE creditcards SET NUMBER = ?, OWNER = ?, CASH = ?, STATUS = ?" + " WHERE card_id = ?");
                preparedStatement.setInt(5, card.getId());
                preparedStatement.setString(1, card.getNumber());
                preparedStatement.setString(2, card.getOwner());
                preparedStatement.setDouble(3, card.getCash());
                preparedStatement.setBoolean(4, card.isStatus());
                preparedStatement.executeUpdate();
            }
        }
        //writeToDB(cards, connection);
    }

    public CreditCard getCard() {
        return card;
    }

    public void setCard(CreditCard card) {
        this.card = card;
    }
}
