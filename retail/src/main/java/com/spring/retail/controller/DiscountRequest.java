package com.spring.retail.controller;

import com.spring.retail.model.Bill;
import com.spring.retail.model.Item;
import com.spring.retail.model.User;

import java.util.List;

public class DiscountRequest
{
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Bill getItemList() {
        return bill;
    }

    public void setItemList(Bill bill) {
        this.bill = bill;
    }

    User user;
    Bill bill;
}
