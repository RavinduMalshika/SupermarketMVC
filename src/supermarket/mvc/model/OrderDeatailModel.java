package supermarket.mvc.model;

public class OrderDeatailModel {
    private String orderId, itemCode;
    private Integer orderQty, discount;

    public OrderDeatailModel() {
    }

    public OrderDeatailModel(String orderId, String itemCode, Integer orderQty, Integer discount) {
        this.orderId = orderId;
        this.itemCode = itemCode;
        this.orderQty = orderQty;
        this.discount = discount;
    } 
    
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Integer getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(Integer orderQty) {
        this.orderQty = orderQty;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "OrderDeatailModel{" + "orderId=" + orderId + ", itemCode=" + itemCode + ", orderQty=" + orderQty + ", discount=" + discount + '}';
    }
    
}
