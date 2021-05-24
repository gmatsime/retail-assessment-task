package com.spring.retail.model;

import org.springframework.stereotype.Component;

public class Item {
    public Item() {
    }

    public Item(ItemType itemType, double price) {
        this.itemType = itemType;
        this.price = price;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private ItemType itemType;
    private double price;
}
