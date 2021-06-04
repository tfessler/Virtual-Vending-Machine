package com.techelevator;


public class Chips extends Product {

    public Chips ( String productName, double primitiveDouble, String productType ) {
        super( productName, primitiveDouble, productType );
    }

    String sound = "Crunch Crunch, Yum!";


    @Override
    public String getSound() {
        return sound;
    }
}
