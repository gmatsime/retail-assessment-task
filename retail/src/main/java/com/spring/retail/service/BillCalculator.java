package com.spring.retail.service;

import com.spring.retail.model.Bill;
import com.spring.retail.model.Item;
import com.spring.retail.model.User;

import java.util.List;

public interface BillCalculator {

    double totalBill(User user, Bill bill);
}
