package com.techelevator;

import java.math.BigDecimal;

public class Gum extends Product {

    public Gum (BigDecimal price, String productName ) {
        super( price, productName );
    }

    String sound = "Chew Chew Yum!";


    @Override
    public String getSound() {
        return sound;
    }
}
