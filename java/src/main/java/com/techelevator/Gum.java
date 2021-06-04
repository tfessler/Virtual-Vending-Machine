package com.techelevator;


public class Gum extends Product {

    public Gum ( String productName, double primitiveDouble ) {

        super( productName, primitiveDouble );
    }

    String sound = "Chew Chew Yum!";


    @Override
    public String getSound() {
        return sound;
    }
}
