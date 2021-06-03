package com.techelevator;

import java.io.File;
import java.math.BigDecimal;
import java.util.*;

public class VendingMachine {

    //Instance Variables

        //Key-Value map for the <Slot> and <Queue>, the Queue will contain the product objects
        //and we can get the size of the queue to determine if it's empty or not.
        Map<String, Queue> slotMap = new HashMap<>();
        Queue<Product> productList = new LinkedList<Product>();
        Double fedMoney = 0.00;
        String selectedProduct;


    //Constructor
        public VendingMachine(Map slotMap, Queue productList) {
            this.slotMap;
            this.productList;


        }


    //Getters & Setters


    //Methods



}
