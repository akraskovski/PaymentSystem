package musor;

import com.kraskovskij.CreditCard;
import com.kraskovskij.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class WelcomeBean implements Serializable{

    private User user;
    private CreditCard card;

    public WelcomeBean() {
        card = new CreditCard("4585 6589 5478 5465 5554", 7486, 150.6, true);
        user = new User("artemDev", "121296", "Artem", "Kraskovskij", card);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
