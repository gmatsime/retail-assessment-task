package com.spring.retail.controller;

import com.spring.retail.model.*;
import com.spring.retail.service.BillCalculator;
import com.spring.retail.service.DiscountCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.spring.retail.service.BillCalculatorService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DiscountCalculatorController {

    @Autowired
    private BillCalculatorService billCalculatorService;


    @GetMapping("/bill")
    public double getTotalbill(User user,Bill bill){

         user= new User(UserType.CUSTOMER, LocalDate.parse("2012-10-07"));

        List <Item> itemList=new ArrayList<>();
        itemList.add(new Item(ItemType.CLOTHING,100.00));
        itemList.add(new Item(ItemType.ELECTRONICS,100.00));
        itemList.add(new Item(ItemType.GROCERY,98.90));
        itemList.add(new Item(ItemType.GROCERY,100.00));

         bill=new Bill();
        bill.setItems(itemList);

        BillCalculator billCalculator=new BillCalculatorService();

        double totalBill=billCalculator.totalBill(user,bill);
        return billCalculatorService.totalBill(user,bill);


    }
    @GetMapping("/user")
    public User getUser(){

       return  new User(UserType.CUSTOMER, LocalDate.parse("2012-10-07"));
    }

    @GetMapping("/b")
    public Bill getBill(){


        List <Item> itemList=new ArrayList<>();
        itemList.add(new Item(ItemType.CLOTHING,100.00));
        itemList.add(new Item(ItemType.ELECTRONICS,100.00));
        itemList.add(new Item(ItemType.GROCERY,98.90));
        itemList.add(new Item(ItemType.GROCERY,100.00));

       Bill bill=new Bill();
        bill.setItems(itemList);

        return bill;
    }
    @PostMapping("/apply")
    public double getDiscount(@RequestBody DiscountRequest discountRequest){

        return billCalculatorService.totalBill(discountRequest.user,discountRequest.bill);
    }

}
