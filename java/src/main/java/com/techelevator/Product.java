package com.techelevator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Product {

    private BigDecimal price;
    private String productName;
    private double primitiveDouble;
    private String productType;

    public Product( String productName, double primitiveDouble, String productType ) {
        this.productName = productName;
        this.primitiveDouble = primitiveDouble;
        this.productType = productType;
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

    public String getProductType() {
        return productType;
    }

    public abstract String getSound();


    public BigDecimal setScale(int newScale, RoundingMode roundingMode) {
        return (BigDecimal.valueOf(primitiveDouble));
    }

  /*  @Override
    public String toString() {
        String itemInfo;
        itemInfo = this.productType + ", " + this.productName + ", " + "$" + this.primitiveDouble;

       return itemInfo;
        // return getProductName();
    }*/
}