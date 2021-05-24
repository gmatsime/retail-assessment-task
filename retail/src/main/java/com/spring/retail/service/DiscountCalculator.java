package com.spring.retail.service;

import com.spring.retail.model.*;

import java.util.List;

public class DiscountCalculator {

    private static double EMPLOYEE_DISC_PERCENTAGE = 0.30;
    private static double AFFILIATE_DISC_PERCENTAGE = 0.10;
    private static double CUSTOMER_DISC_PERCENTAGE = 0.05;

    public DiscountCalculator() {
    }


    public double totalBill(User user, Bill bill) {

             double totalPrice;

        totalPrice = bill.getItems().stream().mapToDouble(Item::getPrice).sum();


        return totalPrice;
    }


    public double totalTobePaidByType(Bill bill, ItemType type){

         double total=0;

        List<Item> b= bill.getItems();
         if (type!= null){
             for (Item i :b)
             {

                 if( i.getItemType().equals(ItemType.GROCERY))
                         total=i.getPrice()+total;

             }


             //total=bill.getItems().stream().mapToDouble(Item::getPrice).sum();
         }

         return total;
    }


    public double getDiscountPercentage(User user) {

        if (user == null) {
            throw new NullPointerException("User cannot be null");
        }

        UserType userType = user.getUserType();
        double discount = 0;

        switch (userType) {
            case EMPLOYEE:
                discount = EMPLOYEE_DISC_PERCENTAGE;

                break;
            case AFFILIATE:
                discount = AFFILIATE_DISC_PERCENTAGE;
                break;
            case CUSTOMER:

                if (user.isLoyalCustomer(user.registrationDate)) {

                    discount = CUSTOMER_DISC_PERCENTAGE;
                }
                return discount;

                default:
                break;
        }
        return discount;
    }


    public double calculateBillDiscount(double totalAmountOnBill,double hundredDollarBill,double discountAmount){

        double value=Math.floor(totalAmountOnBill/hundredDollarBill) *discountAmount;
        return value;
    }

    public double calculateDiscount(double totalBillAmount,double discount){

        if(discount >=1.0){

            throw new IllegalArgumentException("Discounts are only below 50%");

        }

        double discountedValue=totalBillAmount *discount ;
        double discountedBill=totalBillAmount-discountedValue;

        return discountedBill;

    }
}