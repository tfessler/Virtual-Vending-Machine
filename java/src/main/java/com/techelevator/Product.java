package com.techelevator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Product {

    private BigDecimal price;
    private String productName;
    private double primitiveDouble;

    public Product( String productName, double primitiveDouble) {
        this.productName = productName;
        this.primitiveDouble = primitiveDouble;
        BigDecimal price = new BigDecimal(primitiveDouble).setScale(2, RoundingMode.HALF_UP);
        //conversion here double to bigdec
    }



    public double getPrimitiveDouble() {

        return primitiveDouble;
    }

    public BigDecimal getPrice() {

        return price;
    }

    public String getProductName() {

        return productName;
    }

    public abstract String getSound();


    public BigDecimal setScale(int newScale, RoundingMode roundingMode) {
        return (BigDecimal.valueOf(primitiveDouble));
    }
}