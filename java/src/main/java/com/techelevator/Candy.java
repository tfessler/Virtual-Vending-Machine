package com.techelevator;


public class Candy extends Product {

    public Candy ( String productName, double primitiveDouble ) {

        super( productName, primitiveDouble );
    }

    String sound = "Munch Munch Yum!";


    @Override
    public String getSound() {
        return sound;
    }
}
