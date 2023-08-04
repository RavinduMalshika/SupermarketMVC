package supermarket.mvc.model;

public class ItemModel {
    private String itemCode, itemDesc, packSize;
    private Double unitPrice;
    private Integer QtyOnHand;

    public ItemModel() {
    }

    public ItemModel(String itemCode, String itemDesc, String packSize, Double unitPrice, Integer QtyOnHand) {
        this.itemCode = itemCode;
        this.itemDesc = itemDesc;
        this.packSize = packSize;
        this.unitPrice = unitPrice;
        this.QtyOnHand = QtyOnHand;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public String getPackSize() {
        return packSize;
    }

    public void setPackSize(String packSize) {
        this.packSize = packSize;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQtyOnHand() {
        return QtyOnHand;
    }

    public void setQtyOnHand(Integer QtyOnHand) {
        this.QtyOnHand = QtyOnHand;
    }

    @Override
    public String toString() {
        return "ItemModel{" + "itemCode=" + itemCode + ", itemDesc=" + itemDesc + ", packSize=" + packSize + ", unitPrice=" + unitPrice + ", QtyOnHand=" + QtyOnHand + '}';
    }
}
