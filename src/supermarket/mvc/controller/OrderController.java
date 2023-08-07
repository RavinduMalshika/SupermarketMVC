/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.mvc.controller;

import java.util.ArrayList;
import supermarket.mvc.model.OrderDeatailModel;
import supermarket.mvc.model.OrderModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import supermarket.mvc.db.DBConnection;

/**
 *
 * @author ravin
 */
public class OrderController {
    public String placeOrder(OrderModel orderModel, ArrayList<OrderDeatailModel> orderDeatailModels) throws SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            String orderQuery = "INSERT INTO orders VALUES(?, ?, ?)";
            
            PreparedStatement orderPreparedStatement = connection.prepareStatement(orderQuery);
            orderPreparedStatement.setString(1, orderModel.getOrderId());
            orderPreparedStatement.setString(2, orderModel.getOrderDate());
            orderPreparedStatement.setString(3, orderModel.getCustId());
            
            if(orderPreparedStatement.executeUpdate() > 0){
                boolean isOrderDetailSaved = true;
                String orderDetailQuery = "INSERT INTO orderdetail VALUES(?, ?, ?, ?)";
                
                for (OrderDeatailModel orderDeatailModel : orderDeatailModels) {
                    PreparedStatement odPreparedStatement = connection.prepareStatement(orderDetailQuery);
                    odPreparedStatement.setString(1, orderModel.getOrderId());
                    odPreparedStatement.setString(2, orderDeatailModel.getItemCode());
                    odPreparedStatement.setInt(3, orderDeatailModel.getOrderQty());
                    odPreparedStatement.setInt(4, orderDeatailModel.getDiscount());
                    
                    if(!(odPreparedStatement.executeUpdate() > 0)) {
                        isOrderDetailSaved = false;
                    }
                }
                
                if(isOrderDetailSaved) {
                    boolean isItemUpdated = true;
                    String itemQuery = "UPDATE item SET QtyOnHand = QtyOnHand - ? WHERE ItemCode = ?";
                    
                    for (OrderDeatailModel orderDeatailModel : orderDeatailModels) {
                        PreparedStatement itemPreparedStatement = connection.prepareStatement(itemQuery);
                        itemPreparedStatement.setInt(1, orderDeatailModel.getOrderQty());
                        itemPreparedStatement.setString(2, orderDeatailModel.getItemCode());
                        
                        if(!(itemPreparedStatement.executeUpdate() > 0)) {
                            isItemUpdated = false;
                        }
                    }
                    
                    if(isItemUpdated){
                        connection.commit();
                        return "Success";
                    }else{
                        connection.rollback();
                        return "Item Update Error";
                    }
                } else {
                    connection.rollback();
                    return "Order Detail Save Error";
                }
            } else{
                connection.rollback();
                return "Order Save Error";
            }
        } catch (Exception e) {
            connection.rollback();
            e.printStackTrace();
            return e.getMessage();
        } finally {
            connection.setAutoCommit(true);
        }
    }
}
