package com.techelevator;


public class Gum extends Product {

    public Gum ( String productName, double primitiveDouble, String productType ) {

        super( productName, primitiveDouble, productType );
    }

    String sound = "Chew Chew Yum!";


    @Override
    public String getSound() {
        return sound;
    }
}
