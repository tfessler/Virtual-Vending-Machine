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
        // displayItems();
        // vendProduct("A1");
        // vendProduct("A1");
        // vendProduct("A1");
        // vendProduct("A1");
        // vendProduct("A1");
        // vendProduct("A1");
        // vendProduct("A2");
        // vendProduct("A2");
        // vendProduct("A2");
        // vendProduct("A2");
        // vendProduct("A2");
        // vendProduct("A2");
        // vendProduct("A2");
        // vendProduct("D2");
        // vendProduct("D2");
        // vendProduct("D2");
        // vendProduct("D2");
        // vendProduct("D2");
        // vendProduct("D2");
        // vendProduct("D2");
        // vendProduct("Z2");
        // vendProduct("Z2");
        // vendProduct("Z2");
        // vendProduct("Z2");
        // vendProduct("Z2");
        // vendProduct("Z2");

        //return to main menu?
    }

    public VendingMachine() throws IOException {
        // vendingMachineCoins = new Purchase();
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

    public void displayItems() throws EmptyStackException {
        //Puts contents of vendingInventory map into a TreeMap called vendingInventoryTree
        //The TreeMap sorts the regular Map for display purposes
        this.vendingInventoryTree.putAll(vendingInventory);

        for (Map.Entry<String, Stack> entry : vendingInventoryTree.entrySet()) {

            if (entry.getValue().size() == 0) {
                System.out.println("SLOT: " + entry.getKey() + " - SOLD OUT");
            } else {
                Product productItem = (Product) entry.getValue().peek();
                String productItemStr = "TYPE: " + productItem.getProductType() + " NAME: " + productItem.getProductName() + " PRICE: $" + productItem.getPrimitiveDouble();
                System.out.println("SLOT: " + entry.getKey() + " " + productItemStr + " - QTY REMAINING: " + vendingInventory.get(entry.getKey()).size());
                // String productItem = entry.getValue();
                // System.out.println("Key: " + entry.getKey() + ". Value: " + ((Product)entry.getValue().peek()).toString());
            }
        }
    }

    public void feedMoney(int billInserted) throws IOException {
        Purchase.addMoney(billInserted);
        String billInsertedAsString = "$" + billInserted;
        // adds when money is inserted Logger.logEvent("Feed Money:", billInsertedAsString, getBalanceAsString());
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
                productInfo = "TYPE: " + vendedItem.getProductType() + " NAME: " + vendedItem.getProductName()
                        + " PRICE: $" + vendedItem.getPrimitiveDouble();

                //prints attributes to console
                System.out.println("Vended item: " + productInfo);
                System.out.println("\"" + vendedItem.getSound() + "\"");
                System.out.println();

                //pops the actual object item off the stack
                vendingInventory.get(slot).pop();

                //checks if slot is empty tells the user if empty
            } else if (vendingInventory.get(slot).size() == 0) {
                System.out.println("That slot is empty!");
            }
        }
    }

    // public void selectProduct() throws IOException {
    //
    //     //Instance Variables
    //     Scanner scanner = new Scanner(System.in);
    //     String usersSelectedProduct = "";
    //
    //
    //     //display products again
    //     displayItems();
    //
    //     //ask customer to choose slot
    //     System.out.println("Choose a slot to select your product.");
    //     usersSelectedProduct = scanner.nextLine();
    //         //converts input to uppercase to avoid case sens error
    //         usersSelectedProduct.toUpperCase();
    //
    //     //check if slot actually exists
    //     if (vendingInventory.containsKey(usersSelectedProduct)) {
    //         //check if product is sold out
    //         if (vendingInventory.get(usersSelectedProduct).size() != 0 ) {
    //             //check if machine balance is enough to dispense product
    //             if (purchase.) {
    //
    //             }
    //
    //
    //         } else {
    //             //inform user if so and return to purchase menu
    //         }
    //
    //     } else {
    //         //return to purchase menu if not
    //     }
    //
    //
    //
    //
    //     //if so vend item
    //     //after product is dispensed machine must update balance
    //
    //     //FINISH TRANSACTION
    //     //product is already vended so do the following:
    //     //dispense change
    //     //vending machine balance - fed money
    //     //call giveChange method or whatever its called
    //     //set machine balance back to zero
    //     //return them to the main vending machine menu
    //
    //
    //
    //     // Purchase newPurchase = new Purchase();
    //     // System.out.println("Please Select Product");
    //     // String userSelection = in.nextLine();
    //     // String returnString = newPurchase.purchaseItem(userSelection);
    //     // System.out.println(returnString);
    // }
}








