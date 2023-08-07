package supermarket.mvc.model;

public class OrderModel {
    private String orderId, orderDate, custId;

    public OrderModel() {
    }

    public OrderModel(String orderId, String orderDate, String custId) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.custId = custId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    @Override
    public String toString() {
        return "OrderModel{" + "orderId=" + orderId + ", orderDate=" + orderDate + ", custId=" + custId + '}';
    }
    
}
