
package supermarket.mvc.controller;

import supermarket.mvc.model.CustomerModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import supermarket.mvc.db.DBConnection;

public class CustomerController {
    public String saveCustomer(CustomerModel customer)throws SQLException{
       Connection connection =  DBConnection.getInstance().getConnection();
       
       String query = "INSERT INTO Customer VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
       
       PreparedStatement preparedStatement = connection.prepareStatement(query);
       preparedStatement.setString(1, customer.getCustId());
       preparedStatement.setString(2, customer.getCustTitle());
       preparedStatement.setString(3, customer.getCustName());
       preparedStatement.setString(4, customer.getDob());
       preparedStatement.setDouble(5, customer.getSalary());
       preparedStatement.setString(6, customer.getCustAddress());
       preparedStatement.setString(7, customer.getCity());
       preparedStatement.setString(8, customer.getProvince());
       preparedStatement.setString(9, customer.getPostalCode());
       
       if(preparedStatement.executeUpdate() > 0){
           return "Success";
       } else {
           return "Fail";
       }
    }
}
