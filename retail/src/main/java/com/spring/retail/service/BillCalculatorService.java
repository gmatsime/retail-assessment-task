package com.spring.retail.service;

import com.spring.retail.model.Bill;
import com.spring.retail.model.Item;
import com.spring.retail.model.ItemType;
import com.spring.retail.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BillCalculatorService implements BillCalculator {
    @Override
    public double totalBill(User user, Bill bill) {


        DiscountCalculator discountCalculator = new DiscountCalculator();

        //calculate total Amount to be paid before discounting
        double totalAmountOnBill = discountCalculator.totalBill(user, bill);

        //calculate total to be paid of grocery items on the list
       double groceries=discountCalculator.totalTobePaidByType(bill, ItemType.GROCERY);

        //subtract the groceries amount from the total bill to get non grocery items bill
        double nonGroceryAmount= totalAmountOnBill-groceries;

        //get the discount % depending on the type of user
        double userDiscount= discountCalculator.getDiscountPercentage(user);

        //calculate bill discount using total amount on the bill ,get how many hundred dollar bills there
        //are in the total multiple the number by 5 dollars
       double billDiscount= discountCalculator.calculateBillDiscount(totalAmountOnBill,100,5);


       //check if there are items that are non grocery and calculate the discount based on the
        //user discount
       if(nonGroceryAmount>0){
           nonGroceryAmount =discountCalculator.calculateDiscount(nonGroceryAmount,userDiscount);
       }

       double finalPayableAmount=(nonGroceryAmount+groceries)-billDiscount;

        return finalPayableAmount;

    }
}
