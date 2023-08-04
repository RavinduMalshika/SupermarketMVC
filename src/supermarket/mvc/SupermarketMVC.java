package supermarket.mvc;

import com.sun.glass.ui.Cursor;
import supermarket.mvc.view.CustomerView;
import supermarket.mvc.view.ItemView;

public class SupermarketMVC {
    public static void main(String[] args) {
        new CustomerView().setVisible(true);
        new ItemView().setVisible(true);
    }
    
}
