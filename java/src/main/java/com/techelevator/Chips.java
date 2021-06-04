package com.techelevator;


public class Chips extends Product {

    public Chips ( String productName, double primitiveDouble ) {
        super( productName, primitiveDouble);
    }

    String sound = "Crunch Crunch, Yum!";


    @Override
    public String getSound() {
        return sound;
    }
}
