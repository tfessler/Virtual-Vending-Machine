package com.techelevator;

import java.math.BigDecimal;

public class Beverage extends Product {

    public Beverage ( BigDecimal price, String productName ) {
        super( price, productName );
    }

    String sound = "Glug Glug Yum!";


    @Override
    public String getSound() {
        return sound;
    }
}
