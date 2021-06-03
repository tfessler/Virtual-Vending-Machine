package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Product {

    public Candy (BigDecimal price, String productName ) {
        super( price, productName );
    }

    String sound = "Munch Munch Yum!";


    @Override
    public String getSound() {
        return sound;
    }
}
