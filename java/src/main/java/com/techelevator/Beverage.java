package com.techelevator;


public class Beverage extends Product {

    public Beverage ( String productName, double primitiveDouble ) {

        super( productName, primitiveDouble );
    }

    String sound = "Glug Glug Yum!";


    @Override
    public String getSound() {
        return sound;
    }
}
