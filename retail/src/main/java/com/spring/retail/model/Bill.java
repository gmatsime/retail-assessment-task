package com.spring.retail.model;

import java.util.List;

public class Bill {

    public List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
