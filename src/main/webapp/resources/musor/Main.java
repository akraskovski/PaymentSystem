package musor;

import com.kraskovskij.CreditCard;
import com.kraskovskij.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@ManagedBean
@SessionScoped
public class Main {
    User uzer;
    String tmp123 = "Hello!";

    public String getTmp123() {
        return tmp123;
    }

    public void setTmp123(String tmp123) {
        this.tmp123 = tmp123;
    }

    public Main() {
        uzer = new User("Kraskovskij1234t", "124359083475", "Artem", "Kraskovskij");
    }
    public User getUzer() {
        return uzer;
    }

    public void setUzer(User uzer) {
        this.uzer = uzer;
    }

    static DBWorker dbWorker = new DBWorker();
    static User uzik = new User();

    public static User getUzik() {
        return uzik;
    }

    public static void setUzik(User uzik) {
        Main.uzik = uzik;
    }

    static CreditCard tmp = new CreditCard();

    /*public static void main (String[] args){
        readFromDB();
    }*/
    public static void readFromDB()
    {
        /*Reading information from database*/
        String query = "select * from cardsinfo";
        try {
            Statement statement = dbWorker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                uzik.card.setId(resultSet.getInt("id"));
                uzik.card.setNumber(resultSet.getString("number"));
                uzik.card.setPin(resultSet.getInt("pin"));
                uzik.card.setCash(resultSet.getDouble("cash"));
                //uzik.card.add(tmp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //System.out.println(uzik.card.getNumber());

        /*--------------------------------*/
    }
    public static String test(){
        return "Xueviy text";
    }
}
