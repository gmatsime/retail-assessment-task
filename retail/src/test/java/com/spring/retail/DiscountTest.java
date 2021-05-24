package com.spring.retail;

import com.spring.retail.model.*;
import com.spring.retail.service.BillCalculator;
import com.spring.retail.service.BillCalculatorService;
import com.spring.retail.service.DiscountCalculator;
import org.junit.*;
import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class DiscountTest {

@Test
    public void testCalculateGroceriesTotalOnly(){
        List <Item> itemList=new ArrayList<>();
        itemList.add(new Item(ItemType.GROCERY,100.00));
        itemList.add(new Item(ItemType.GROCERY,100.00));
        itemList.add(new Item(ItemType.CLOTHING,100.00));
        itemList.add(new Item(ItemType.GROCERY,100.00));

        Bill bill=new Bill();
        bill.setItems(itemList);
        DiscountCalculator discountCalculator= new DiscountCalculator();
        double total=discountCalculator.totalTobePaidByType(bill,ItemType.GROCERY);
        Assert.assertEquals(300,total,0);
    }

    @Test
    public void testCalculateNonGroceriesTotalOnly(){
        List <Item> itemList=new ArrayList<>();
        itemList.add(new Item(ItemType.CLOTHING,100.00));
        itemList.add(new Item(ItemType.ELECTRONICS,100.00));
        itemList.add(new Item(ItemType.ELECTRONICS,100.00));

        User user= new User(UserType.AFFILIATE, LocalDate.parse("2018-10-07"));

        Bill bill=new Bill();
        bill.setItems(itemList);
        DiscountCalculator discountCalculator= new DiscountCalculator();
        double total=discountCalculator.totalBill(user,bill);
        assertEquals(300,total,0);
    }

    @Test
    public void testCalculateAllTypesItems(){
        List <Item> itemList=new ArrayList<>();
        itemList.add(new Item(ItemType.GROCERY,100.00));
        itemList.add(new Item(ItemType.ELECTRONICS,100.00));
        itemList.add(new Item(ItemType.CLOTHING,100.00));
        itemList.add(new Item(ItemType.HOMEWARE,100.00));
        itemList.add(new Item(ItemType.GROCERY,100.00));

        User user= new User(UserType.AFFILIATE, LocalDate.parse("2018-10-07"));
        Bill bill=new Bill();
        bill.setItems(itemList);
        DiscountCalculator discountCalculator= new DiscountCalculator();
        double total=discountCalculator.totalBill(user,bill);
        assertEquals(500,total,0);

    }

    @Test
   public void getUserDiscountPercentage(){

        List <Item> itemList=new ArrayList<>();
        itemList.add(new Item(ItemType.CLOTHING,100.00));
        itemList.add(new Item(ItemType.ELECTRONICS,100.00));
        itemList.add(new Item(ItemType.ELECTRONICS,100.00));

        User user= new User(UserType.AFFILIATE, LocalDate.parse("2018-10-07"));

        Bill bill=new Bill();
        bill.setItems(itemList);
        DiscountCalculator discountCalculator= new DiscountCalculator();
        double total=discountCalculator.getDiscountPercentage(user);
        assertEquals(0.1,total,0);

    }

    @Test
    public void testCalculateBillDiscount(){

        List <Item> itemList=new ArrayList<>();
        itemList.add(new Item(ItemType.CLOTHING,100.00));
        itemList.add(new Item(ItemType.ELECTRONICS,100.00));
        itemList.add(new Item(ItemType.ELECTRONICS,100.00));

        User user= new User(UserType.AFFILIATE, LocalDate.parse("2018-10-07"));

        Bill bill=new Bill();
        bill.setItems(itemList);
        DiscountCalculator discountCalculator= new DiscountCalculator();
        double total=discountCalculator.calculateBillDiscount(990,100,5);
        assertEquals(45,total,0);
    }

    @Test
    public void testCalculateDiscount(){


        DiscountCalculator discountCalculator= new DiscountCalculator();
        double total=discountCalculator.calculateDiscount(1000,0.5);
        assertEquals(500,total,0);
    }

    @Test
    public void testGetDiscountEmployeePercentage(){


        User user= new User(UserType.EMPLOYEE, LocalDate.parse("2018-10-07"));
        DiscountCalculator discountCalculator= new DiscountCalculator();
        double total=discountCalculator.getDiscountPercentage(user);
        assertEquals(0.3,total,0);
    }

    @Test
    public void testGetDiscountAffiliatePercentage(){


        User user= new User(UserType.AFFILIATE, LocalDate.parse("2018-10-07"));
        DiscountCalculator discountCalculator= new DiscountCalculator();
        double total=discountCalculator.getDiscountPercentage(user);
        assertEquals(0.1,total,0);
    }

    @Test
    public void testGetDiscountCustomerLess2yrsPercentage(){


        User user= new User(UserType.CUSTOMER, LocalDate.parse("2020-10-07"));
        DiscountCalculator discountCalculator= new DiscountCalculator();
        double total=discountCalculator.getDiscountPercentage(user);
        assertEquals(0.00,total,0);
    }

    @Test
    public void testGetDiscountCustomerOver2yrsPercentage(){


        User user= new User(UserType.CUSTOMER, LocalDate.parse("2012-10-07"));
        DiscountCalculator discountCalculator= new DiscountCalculator();
        double total=discountCalculator.getDiscountPercentage(user);
        assertEquals(0.05,total,0);
    }

    @Test
    public void testBillCalculatorService(){

        User user= new User(UserType.CUSTOMER, LocalDate.parse("2012-10-07"));

        List <Item> itemList=new ArrayList<>();
        itemList.add(new Item(ItemType.CLOTHING,100.00));
        itemList.add(new Item(ItemType.ELECTRONICS,100.00));
        itemList.add(new Item(ItemType.GROCERY,98.90));
        itemList.add(new Item(ItemType.GROCERY,100.00));

        Bill bill=new Bill();
        bill.setItems(itemList);

        BillCalculator billCalculator=new BillCalculatorService();

        double totalBill=billCalculator.totalBill(user,bill);
        assertEquals(373.90,totalBill,0);

    }
}
