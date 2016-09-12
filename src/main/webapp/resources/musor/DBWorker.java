package musor;

import com.kraskovskij.User;
import com.mysql.fabric.jdbc.FabricMySQLDriver;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.sql.*;

@ManagedBean(eager = true)
@SessionScoped
public class DBWorker implements Serializable{

    private static final String URL = "jdbc:mysql://localhost:3306/creditcards?autoReconnect=true&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private Connection connection;
    private User uzik = new User();

    public DBWorker(){
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            //System.out.println("Driver error.");
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            //System.out.println("Connection sucessfull");
        } catch (SQLException e){
            e.printStackTrace();
        }
        reading();
        //test();
    }
    public void test(){
        uzik.card.setNumber("123 1283 837434 82838");
    }
    public void reading()
    {
        String query = "select * from cardsinfo";
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                //uzik.card.setId(resultSet.getInt("id"));
                uzik.card.setNumber(resultSet.getString("number"));
                //uzik.card.setPin(resultSet.getInt("pin"));
                //uzik.card.setCash(resultSet.getDouble("cash"));
                //uzik.card.add(tmp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection() {
        return connection;
    }

    public User getUzik() {
        return uzik;
    }

    public void setUzik(User uzik) {
        this.uzik = uzik;
    }
}
