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
        System.out.println("Success! -- " + inputList.getAbsolutePath());
        System.out.println("Loading inventory...");
        setMapFromInputFile(inputList);
    }

    public VendingMachine() throws IOException {
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

   /* public double getFedMoney() {
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
    }*/


    //Methods
    public void setMapFromInputFile(File inputList) {

        try {

            Scanner inputScanner = new Scanner(inputList);
            String line;
            Map<String, Stack> vmSlotMap = new HashMap<>();

            if (!inputScanner.hasNextLine()) {
                System.out.println("SLOT: A1 is EMPTY!");
                System.out.println("SLOT: A2 is EMPTY!");
                System.out.println("SLOT: A3 is EMPTY!");
                System.out.println("SLOT: A4 is EMPTY!");
                System.out.println("SLOT: B1 is EMPTY!");
                System.out.println("SLOT: B2 is EMPTY!");
                System.out.println("SLOT: B3 is EMPTY!");
                System.out.println("SLOT: B4 is EMPTY!");
                System.out.println("SLOT: C1 is EMPTY!");
                System.out.println("SLOT: C2 is EMPTY!");
                System.out.println("SLOT: C3 is EMPTY!");
                System.out.println("SLOT: C4 is EMPTY!");
                System.out.println("SLOT: D1 is EMPTY!");
                System.out.println("SLOT: D2 is EMPTY!");
                System.out.println("SLOT: D3 is EMPTY!");
                System.out.println("SLOT: D4 is EMPTY!");
                System.out.println("All slots are currently sold out. Please stock your inventory file before you load it into the machine :P");

            } else {

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
            }
            this.vendingInventory = vmSlotMap;

        } catch (FileNotFoundException e) {
            System.out.println("Error. The specified file was not found.");
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
            }
        }
    }

    public void vendProduct(String slot) {

        //Instance Variables
        Product vendedItem;
        String productInfo = "";

        //Check to see if slot contains product
        //Check the map for key value 'slot'
        if (vendingInventory.containsKey(slot)) {

            //The maps value for 'slot' will be a stack
            //Access that stack if not empty
            if (vendingInventory.get(slot).size() != 0) {

                //Peeks at the item on top of the stack and casts it to a Product class
                vendedItem = (Product) vendingInventory.get(slot).peek();

                //Uses getters from the Product class casting to access the object's attributes
                productInfo = "TYPE: " + vendedItem.getProductType() + " NAME: " + vendedItem.getProductName()
                        + " PRICE: $" + vendedItem.getPrimitiveDouble();

                //Prints attributes to console
                System.out.println("Vended item: " + productInfo);
                System.out.println("\"" + vendedItem.getSound() + "\"");
                System.out.println();

                //Pops the actual object item off the stack
                vendingInventory.get(slot).pop();

                //Checks if slot is empty and tells the user if so
            } else if (vendingInventory.get(slot).size() == 0) {
                System.out.println("That slot is empty!");
            }
        }
    }
}








