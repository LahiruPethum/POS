package com.pos.dto;


public class ItemDTO {

    private int itemId;

    private String itemName;

    private double sellingPrice;

    private boolean activeState;

    public ItemDTO() {
    }

    public ItemDTO(int itemId, String itemName, double sellingPrice, boolean activeState) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.sellingPrice = sellingPrice;
        this.activeState = activeState;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public boolean isActiveState() {
        return activeState;
    }

    public void setActiveState(boolean activeState) {
        this.activeState = activeState;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", sellingPrice=" + sellingPrice +
                ", activeState=" + activeState +
                '}';
    }
}
