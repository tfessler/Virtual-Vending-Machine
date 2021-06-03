package com.techelevator;

import java.math.BigDecimal;

public class Chips extends Product {

    public Chips ( BigDecimal price, String productName ) {
        super( price, productName);
    }

    String sound = "Crunch Crunch, Yum!";


    @Override
    public String getSound() {
        return sound;
    }
}
