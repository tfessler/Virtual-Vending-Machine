package com.techelevator;
import com.techelevator.view.Menu;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
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



    //Getters & Setters
    public double getBalance() {
        DecimalFormat commaFormat;
        commaFormat = new DecimalFormat("#,###.##");
        return Double.parseDouble(commaFormat.format(balance));
    }

    public void setBalance(double balance) {
        DecimalFormat commaFormat;
        commaFormat = new DecimalFormat("#,###.##");
        this.balance = Double.parseDouble(commaFormat.format(balance));
    }

    public HashMap<Integer, Double> getChangeReturned() {
        return changeReturned;
    }


    public HashMap changeReturned(double vendingMachineBalance) {
        HashMap<String, Integer> coinCount = new HashMap<String, Integer>();

        int quarters = 0;
        int dimes = 0;
        int nickels = 0;

        //could've used modulus to check divisibility by 25, 10, 5 and added that way

        if(vendingMachineBalance >= 0) {
            while(vendingMachineBalance >= .25) {
                quarters += 1;
                vendingMachineBalance -= .25;
                //could add += newVendingMachineBalance
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



}
