package com.spring.retail.model;


import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;

public class User {

    public User(UserType userType, LocalDate registrationDate) {
        this.userType = userType;
        this.registrationDate = registrationDate;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public UserType userType;

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public LocalDate registrationDate;

    public boolean isLoyalCustomer(LocalDate dateRegistered) {

        int EMPLOYEE_DISCOUNTABLE_YEARS = 2;
        Period period;
        LocalDate currentDate = LocalDate.now();

        period = Period.between(dateRegistered, currentDate);
        if (period.getYears() <= EMPLOYEE_DISCOUNTABLE_YEARS) {

            return false;
        }
        return true;
    }
    }


