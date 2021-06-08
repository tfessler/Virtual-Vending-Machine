package com.techelevator;
import com.techelevator.view.Menu;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Purchase {

    //Instance Variables
    private Scanner in = new Scanner(System.in);
    private PrintWriter out;
    private double balance;
    //add BigDec variable and convert the balance to it and call it back into the Current Balance in feedMoney

    //declared to use later in other classes
        //(this old comment was above the private HashMap line below,
        // so I kept it meant something to Tracy)
    private HashMap<Integer, Double> changeReturned;


    //Constructors
    public Purchase(InputStream input, OutputStream output) {
        this.out = new PrintWriter(output);
        this.in = new Scanner(input);
    }

    public Purchase() {
        balance = 0;
    }

        // //constructor (this was down below in the code but said it was never used, doesn't look right
        // public void Purchase (HashMap<Integer, Double> changeReturned, double fedMoney, double productPrice){
        //     this.changeReturned=changeReturned;
        // }


    //Getters & Setters
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public HashMap<Integer, Double> getChangeReturned() {
        return changeReturned;
    }


    //Methods
    // public void addMoney(double amountToDeposit) {
    //     this.balance += amountToDeposit;
    // }

    // public static void addMoney(int billInserted) {
    //     //nothing here yet
    //
    //     //Dollars to make change from = 1, 2, 5, and 10
    //     //Coin values = .01, .05, .10, .25 in Big Decimal?
    //
    //     //I'll make the class main method accept BigDecimal
    //     //Need to declare a public method to be able to grab from class
    //
    //     //i'll make a map with the initial values of the change at 0, so far example 0 quarters, 0 dimes, 0 nickles, 0 pennies(there shouldn't be any pennies)
    //     //as the initial value of the returned money is counted i'll minus the amount of the coin and add it to the list
    //
    // }

    public HashMap changeReturned(double vendingMachineBalance) {
        HashMap<String, Integer> coinCount = new HashMap<String, Integer>();

        //coinCount.put("quarters", 0 );

        int quarters = 0;
        int dimes = 0;
        int nickels = 0;

        //could've used modulus to check divisibility by 25, 10, 5 and added that way

        if(vendingMachineBalance >= 0) {
            while(vendingMachineBalance >= .25) {
                quarters += 1;
                vendingMachineBalance -= .25;
            }
            while(vendingMachineBalance >= .10) {
                dimes += 1;
                vendingMachineBalance -= .10;
            }
            while(vendingMachineBalance >= .05) {
            nickels += 1;
            vendingMachineBalance -= .05;
            }

            coinCount.put("quarters", quarters);
            coinCount.put("dimes", dimes);
            coinCount.put("nickels", nickels);
            return coinCount;
        }
        return coinCount;
    }

    public void feedMoney() throws IOException {
        System.out.println("Please Insert U.S. Dollar Bills ($1 ,$2 ,$5, or $10)" );
        try {
            int moneyInserted = in.nextInt();
            in.nextLine();
            if (moneyInserted == 1 || moneyInserted == 2 || moneyInserted == 5 || moneyInserted == 10) {
                System.out.println("Thank You For inserting $" + moneyInserted + ".00");
                this.balance += moneyInserted;
                System.out.println("Current balance: $" + this.balance);
            } else {
                System.out.println("Please Insert Valid Currency");
            }
        } catch (InputMismatchException e) {
            System.out.println("Please Insert Valid Currency");
        }
    }

    public void displaysChange(HashMap<String, Integer> changeReturned){
        System.out.println("Your change is... ");
        System.out.println("QUARTERS: " + changeReturned.get("quarters"));
        System.out.println("DIMES: " + changeReturned.get("dimes"));
        System.out.println("NICKELS: " + changeReturned.get("nickels"));
        System.out.println("...All change has been dispensed, please come again!");
        this.balance = 0;
    }

    public void purchaseItem(String slot) throws IOException {
        // VendingMachine newVendingMachine = new VendingMachine();

        //if item is in stock
            //call the vendingMachine.vend() method

        //if not in stock
            //tell the user the slot is empty


        // Old code Tracy had
        // try {
        //     if (!newVendingMachine.getVendingInventory().containsKey(slot)) {
        //         System.out.println("That slot is empty!");
        //         //} else if ( fed money < vendedItem cost ) { //use maps price value with slot key
        //         return "Please Insert Additional Funds \n";
        //     } else {
        //         //  Double balanceBeforePurchase = vendingMachineCoins.balance;
        //         // subtractFromInventory(slotLocation); need a method to remove the inventory
        //         // subtractMoney(slotLocation);          use method in purchase to subtract the product price from fedMoney then produce change
        //         String successfulPurchase = "Thank You For Purchasing ";
        //         //+ .getName() +  .getSound());
        //         // need .logEvent(.getName() + "  " + slot, balanceBeforePurchase, getBalanceAsString());
        //         return successfulPurchase;
        //     }
        //
        // } catch (NullPointerException e){
        //     return "Please Make A Valid Selection \n";}
    }

}
