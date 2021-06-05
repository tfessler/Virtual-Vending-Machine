package com.techelevator;

import com.sun.source.tree.Tree;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class VendingMachine {

    //Instance Variables

        File inputList;
        TreeMap<String, Stack> vendingInventory = new TreeMap<>();
        Double fedMoney = 0.00;
        String selectedProduct;


    //Constructor
        public VendingMachine(File inputList) {
            this.inputList = inputList;
            //letting me know it received the file
            System.out.println("Success! -- " + inputList.getAbsolutePath());
            //letting me know it received the file
            System.out.println("Loading inventory...");
            setMapFromInputFile(inputList);
            //Now just loop thru the tree map and sout it somehow
            displayItems();
        }


    //Getters & Setters


    //Methods

        private void setMapFromInputFile(File inputList) {

            try {

                Scanner inputScanner = new Scanner(inputList);
                String line;
                Map<String, Stack> vmSlotMap = new HashMap<>();


                while (inputScanner.hasNextLine()) {

                    line = inputScanner.nextLine();
                    String[] strArr = line.split("\\|");

                    // Creating the objects

                    if (strArr[3].equals("Chip")) {
                        Stack<Product> stack = new Stack<Product>();
                        for (int i = 0; i < 5; i++) {
                            Chips chip = new Chips(strArr[03], Double.parseDouble(strArr[2]), strArr[1]);
                            stack.push(chip);
                            //push stack to map
                        }
                        vmSlotMap.put(strArr[0], stack);

                    } else if (strArr[3].equals("Candy")) {
                        Stack<Product> stack = new Stack<Product>();
                        for (int i = 0; i < 5; i++) {
                            Candy candy = new Candy(strArr[03], Double.parseDouble(strArr[2]), strArr[1]);
                            stack.push(candy);
                            //push stack to map
                        }
                        vmSlotMap.put(strArr[0], stack);

                    } else if (strArr[3].equals("Drink")) {
                        Stack<Product> stack = new Stack<Product>();
                        for (int i = 0; i < 5; i++) {
                            Beverage drink = new Beverage(strArr[03], Double.parseDouble(strArr[2]), strArr[1]);
                            stack.push(drink);
                            //push stack to map
                        }
                        vmSlotMap.put(strArr[0], stack);

                    } else if (strArr[3].equals("Gum")) {
                        Stack<Product> stack = new Stack<Product>();
                        for (int i = 0; i < 5; i++) {
                            Gum gum = new Gum(strArr[03], Double.parseDouble(strArr[2]), strArr[1]);
                            stack.push(gum);
                            //push stack to map
                        }
                        vmSlotMap.put(strArr[0], stack);
                    }
                }

                TreeMap<String, Stack> slotTreeMap = new TreeMap<>();
                slotTreeMap.putAll(vmSlotMap);
                this.vendingInventory = slotTreeMap;

            } catch (FileNotFoundException e) {
                System.out.println("Error");
                e.printStackTrace();
            }
        }

        private void displayItems() {
            for (Map.Entry<String, Stack> entry : vendingInventory.entrySet()) {
                System.out.println("Key: " + entry.getKey() + ". Value: " + ((Product)entry.getValue().peek()).toString());
            }
        }

}
