package com.techelevator;


public class Beverage extends Product {

    public Beverage ( String productName, double primitiveDouble, String productType ) {

        super( productName, primitiveDouble, productType );
    }

    String sound = "Glug Glug Yum!";


    @Override
    public String getSound() {
        return sound;
    }
}
