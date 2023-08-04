package supermarket.mvc.controller;

import supermarket.mvc.model.ItemModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import supermarket.mvc.db.DBConnection;

public class ItemController {
    public String saveItem(ItemModel item) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        
        String query = "INSERT INTO Item VALUES(?, ?, ?, ?, ?)";
        
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, item.getItemCode());
        preparedStatement.setString(2, item.getItemDesc());
        preparedStatement.setString(3, item.getPackSize());
        preparedStatement.setDouble(4, item.getUnitPrice());
        preparedStatement.setInt(5, item.getQtyOnHand());
        
        if(preparedStatement.executeUpdate() > 0){
            return "Success";
        } else {
            return "Fail";
        }
    }
    
    public ArrayList<ItemModel> getAllItems() throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        
        String query = "SELECT * FROM Item";
        
        PreparedStatement statement = connection.prepareStatement(query);
        
        ResultSet rst = statement.executeQuery();
        
        ArrayList<ItemModel> items = new ArrayList<>();
        
        while(rst.next()){
            ItemModel im = new ItemModel(rst.getString(1), 
                    rst.getString(2), 
                    rst.getString(3), 
                    rst.getDouble(4), 
                    rst.getInt(5));
            items.add(im);
        }
        return items;
    }
    
    public ItemModel getItem(String itemCode) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        
        String query = "SELECT * FROM Item WHERE ItemCode = ?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, itemCode);
        
        ResultSet rst = preparedStatement.executeQuery();
        
        while(rst.next()){
            ItemModel im = new ItemModel(rst.getString(1), 
                    rst.getString(2), 
                    rst.getString(3), 
                    rst.getDouble(4), 
                    rst.getInt(5));
            return im;
        }
        return null;
    }
        
    public String updateItem(ItemModel item) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        
        String query = "UPDATE Item SET Description = ?, PackSize = ?, UnitPrice = ?, QtyOnHand = ? WHERE ItemCode = ?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, item.getItemDesc());
        preparedStatement.setString(2, item.getPackSize());
        preparedStatement.setDouble(3, item.getUnitPrice());
        preparedStatement.setInt(4, item.getQtyOnHand());
        preparedStatement.setString(5, item.getItemCode());
        
        if(preparedStatement.executeUpdate() > 0){
            return "Success";
        } else {
            return "Fail";
        }
    }
    
    public String deleteItem(ItemModel item) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        
        String query = "DELETE FROM Item WHERE ItemCode = ?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, item.getItemCode());
        
        if(preparedStatement.executeUpdate() > 0){
            return "Success";
        } else {
            return "Fail";
        }
    }
}
