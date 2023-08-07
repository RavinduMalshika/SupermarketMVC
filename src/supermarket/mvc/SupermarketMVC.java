package supermarket.mvc;

import com.sun.glass.ui.Cursor;
import supermarket.mvc.view.CustomerView;
import supermarket.mvc.view.ItemView;
import supermarket.mvc.view.OrderView;

public class SupermarketMVC {
    public static void main(String[] args) {
        new CustomerView().setVisible(true);
    }
    
}
