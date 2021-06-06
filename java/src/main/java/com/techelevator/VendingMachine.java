package com.techelevator;

import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

public class VendingMachine {

    //Instance Variables
        private File inputList;
        private TreeMap<String, Stack> vendingInventoryTree = new TreeMap<>();
        private Map<String, Stack> vendingInventory = new HashMap<>();
        private double fedMoney = 0.00;
        private Purchase vendingMachineCoins;
        private String selectedProduct;


    //Constructors
        public VendingMachine(File inputList) {
            this.inputList = inputList;
            //letting me know it received the file
            System.out.println("Success! -- " + inputList.getAbsolutePath());
            //letting me know it received the file
            System.out.println("Loading inventory...");
            setMapFromInputFile(inputList);
            displayItems();
            vendProduct("A1");
            vendProduct("A1");
            vendProduct("A1");
            vendProduct("A1");
            vendProduct("A1");
            vendProduct("A1");
            vendProduct("A2");
            vendProduct("A2");
            vendProduct("A2");
            vendProduct("A2");
            vendProduct("A2");
            vendProduct("A2");
            vendProduct("A2");
            vendProduct("D2");
            vendProduct("D2");
            vendProduct("D2");
            vendProduct("D2");
            vendProduct("D2");
            vendProduct("D2");
            vendProduct("D2");
            vendProduct("Z2");
            vendProduct("Z2");
            vendProduct("Z2");
            vendProduct("Z2");
            vendProduct("Z2");
            vendProduct("Z2");


            //return to main menu?





        }
    public VendingMachine() throws IOException {
            vendingMachineCoins = new Purchase();
    }// not sure what i was thinking here?


    public void feedMoney(int billInserted) throws IOException {
        Purchase.addMoney(billInserted);
        String billInsertedAsString = "$" + billInserted;
        // adds when money is inserted Logger.logEvent("Feed Money:", billInsertedAsString, getBalanceAsString());
    }



    //Getters & Setters
        public File getInputList() {
            return inputList;
        }

        public void setInputList(File inputList) {
            this.inputList = inputList;
        }

        public TreeMap<String, Stack> getVendingInventoryTree() {
            return vendingInventoryTree;
        }

        public void setVendingInventoryTree(TreeMap<String, Stack> vendingInventoryTree) {
            this.vendingInventoryTree = vendingInventoryTree;
        }

        public Map<String, Stack> getVendingInventory() {
            return vendingInventory;
        }

        public void setVendingInventory(Map<String, Stack> vendingInventory) {
            this.vendingInventory = vendingInventory;
        }

        public double getFedMoney() {
            return fedMoney;
        }

        public void setFedMoney(double fedMoney) {
            this.fedMoney = fedMoney + vendingMachineCoins.getBalance();
        }

        public String getSelectedProduct() {
            return selectedProduct;
        }

        public void setSelectedProduct(String selectedProduct) {
            this.selectedProduct = selectedProduct;
        }


    //Methods
        public void setMapFromInputFile(File inputList) {

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
                this.vendingInventory = vmSlotMap;

            } catch (FileNotFoundException e) {
                System.out.println("Error");
                e.printStackTrace();
            }
        }

        public void displayItems() {
            //Puts contents of vendingInventory map into a TreeMap called vendingInventoryTree
            //The TreeMap sorts the regular Map for display purposes
            this.vendingInventoryTree.putAll(vendingInventory);

            for (Map.Entry<String, Stack> entry : vendingInventoryTree.entrySet()) {
                // String productItem = entry.getValue();
                System.out.println("Key: " + entry.getKey() + ". Value: " + entry.getValue().peek());
                // String productItem = entry.getValue();
                // System.out.println("Key: " + entry.getKey() + ". Value: " + ((Product)entry.getValue().peek()).toString());
            }
        }

        public void vendProduct(String slot) {

            //Instance Variables
            Product vendedItem;
            String productInfo = "";

            //check to see if slot contains product
            //check the map for key value 'slot'
            if (vendingInventory.containsKey(slot)) {
                //the maps value for 'slot' will be a stack
                //access that stack if not empty
                if (vendingInventory.get(slot).size() != 0) {
                    //pop that stack
                    //vendedItem = vendingInventory.get(slot).pop().toString();

                    //peeks at the item on top of the stack and casts it to a Product class
                    vendedItem = (Product) vendingInventory.get(slot).peek();

                    //uses getters from the Product class casting to access the object's attributes
                    productInfo = vendedItem.getProductType() + ", " + vendedItem.getProductName()
                            + ", " + vendedItem.getPrimitiveDouble();

                    //prints attributes to console
                    System.out.println("Vended item: " + productInfo);
                    System.out.println(vendedItem.getSound());

                    //pops the actual object item off the stack
                    vendingInventory.get(slot).pop();

                    //checks if slot is empty tells the user if empty
                } else if (vendingInventory.get(slot).size() == 0) {
                    System.out.println("That slot is empty!");
                }
            }


            //return popped item sound
            //sout 'vended item'

            // Stack stack = new Stack();
            // stack = vendingInventory.get(slot)
            // if (stack.size() != 0) {
            //     stack.pop()
            //
            // }


            //pop product off stack

            //display in console product was vended

            //display in console the noise

            //log

        }

    }








