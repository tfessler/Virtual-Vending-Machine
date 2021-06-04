package com.techelevator;


public class Candy extends Product {

    public Candy ( String productName, double primitiveDouble, String productType ) {

        super( productName, primitiveDouble, productType );
    }

    String sound = "Munch Munch Yum!";


    @Override
    public String getSound() {
        return sound;
    }
}
