package musor;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class ItemBean implements Serializable{

    //private static final long serialVersionUID = 1L;

    private List<String> items;
    private String buttonName = "Click";

    public String getButtonName() {
        return buttonName;
    }

    public List<String> getItems(){
        items = new ArrayList<String>();
        items.add("ID");
        items.add("Card number");
        items.add("PIN");
        items.add("Cash");
        return items;
    }
}
