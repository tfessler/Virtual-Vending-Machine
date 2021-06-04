package com.techelevator.view;

import java.util.HashMap;

public class Purchase {


    private double fedMoney;
    private double productPrice;


    public void Change (HashMap<Integer, Double> changeReturned, double fedMoney, double productPrice) {
        this.fedMoney = fedMoney;
        this.productPrice = productPrice;
    }
    public double getFedDouble() {
        return fedMoney;
    }

    public void setFedDouble(double fedDouble) {
        this.fedMoney = fedDouble;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }








}
