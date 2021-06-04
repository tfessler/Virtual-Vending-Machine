package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class VendingMachine {

    //Instance Variables

        //Key-Value map for the <Slot> and <Queue>, the Queue will contain the product objects
        //and we can get the size of the queue to determine if it's empty or not.
        File inputList;
        Map<String, Queue> slotMap = new HashMap<String, Queue>();
        Queue<Product> productList = new LinkedList<Product>();
        Double fedMoney = 0.00;
        String selectedProduct;


    //Constructor
        public VendingMachine(File inputList) {
            this.inputList = inputList;
            //letting me know it received the file
            System.out.println("Success! -- " + inputList.getAbsolutePath());
            //letting me know it received the file
            System.out.println("Loading inventory...");
            convertInputFileToMap(inputList);
        }


    //Getters & Setters


    //Methods

        private Map<String, Queue> convertInputFileToMap(File inputList) {

            try {

                String line;
                Scanner inputScanner = new Scanner(inputList);

                while (inputScanner.hasNextLine()) {
                    line = inputScanner.nextLine();
                    String[] strArr = line.split("\\|");

                    // Creating the objects
                    // System.out.println(Arrays.toString(strArr));
                    String objectName;

                    if (strArr[3] == "Chip") {
                        int chipCounter = 0;
                        objectName = "Chip" + strArr[0];
                        Chips chip = new Chips(strArr[2], strArr[1]);

                    }

                }


            } catch (FileNotFoundException e) {
                System.out.println("Error");
                e.printStackTrace();
            }


            return null;
        }

}
