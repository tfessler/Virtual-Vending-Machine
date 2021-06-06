package com.techelevator;
import java.io.IOException;
import java.util.HashMap;

public class Purchase {


    private double balance;

    public double getBalance() {
        return balance;
    }

    public void addMoney(double amountToDeposit) {
        this.balance += amountToDeposit;
    }

    public Purchase() {
        balance = 0;
    }

    //declared to use later in other classes

    private HashMap<Integer, Double> changeReturned;

    public static void addMoney(int billInserted) {

    }

    //constructor
    public void Purchase (HashMap<Integer, Double> changeReturned, double fedMoney, double productPrice){
        this.changeReturned=changeReturned;
    }





    //Dollars to make change from = 1, 2, 5, and 10
    //Coin values = .01, .05, .10, .25 in Big Decimal?


    //I'll make the class main method accept BigDecimal
    //Need to declare a public method to be able to grab from class

    //i'll make a map with the initial values of the change at 0, so far example 0 quarters, 0 dimes, 0 nickles, 0 pennies(there shouldn't be any pennies)
    //as the initial value of the returned money is counted i'll minus the amount of the coin and add it to the list



    public static HashMap changeReturned(double getFedMoney, double getProductPrice) {
        HashMap<String, Integer> coinCount = new HashMap<String, Integer>();
        //coinCount.put("quarters", 0 );
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;

//could've used modulus to check divisibility by 25, 10, 5 and added that way
       double initialChange = getFedMoney - getProductPrice;
       if(initialChange >= 0) {
           while(initialChange >= .25) {
               quarters += 1;
               initialChange -= .25;
           }
           while(initialChange >= .10) {
                   dimes += 1;
                   initialChange -= .10;
           }
           while(initialChange >= .05) {
               nickels += 1;
               initialChange -= .05;
           }

           coinCount.put("quarters", quarters);
           coinCount.put("dimes", dimes);
           coinCount.put("nickels", nickels);
           return coinCount;

           }
        return coinCount;
    }
    public static void displaysChange(HashMap<String, Integer> changeReturned){
        System.out.println("Your change is... ");
        System.out.println("quarters: " + changeReturned.get("quarters"));
        System.out.println("dimes: " + changeReturned.get("dimes"));
        System.out.println("nickels: " + changeReturned.get("nickels"));
        System.out.println("..all change has been dispensed, please come again!");


    }

    public HashMap<Integer, Double> getChangeReturned() {
        return changeReturned;
    }

    public String purchaseItem(String slot) throws IOException {
        VendingMachine newVendingMachine = new VendingMachine();
        try {
            if (!newVendingMachine.getVendingInventory().containsKey(slot)) {
                System.out.println("That slot is empty!");
                //} else if ( fed money < vendedItem cost ) { //use maps price value with slot key
                return "Please Insert Additional Funds \n";
            } else {
                //  Double balanceBeforePurchase = vendingMachineCoins.balance;
                // subtractFromInventory(slotLocation); need a method to remove the inventory
                // subtractMoney(slotLocation);          use method in purchase to subtract the product price from fedMoney then produce change
                String successfulPurchase = "Thank You For Purchasing ";
                //+ .getName() +  .getSound());
                // need .logEvent(.getName() + "  " + slot, balanceBeforePurchase, getBalanceAsString());
                return successfulPurchase;
            }

        } catch (NullPointerException e){
            return "Please Make A Valid Selection \n";}
    }






    }
