package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;

public class Logger {

    public void logChange(BigDecimal availableFedMoney) {
        printToLogFile("Dispensed Change $" + availableFedMoney.toString(), availableFedMoney, new BigDecimal("0.00"));
    }

    public void logFedMoney(BigDecimal fedMoney, BigDecimal initialBalance) {
        BigDecimal endingBalance = initialBalance.add(fedMoney);
        printToLogFile("FEED $" + fedMoney, initialBalance, endingBalance);
    }


    public void LogPurchase(String slot, Product productName, Product productType, BigDecimal initialBalance) {
        BigDecimal endingBalance = initialBalance.subtract(productName.getPrice());
        String line = productName.getProductName() + productType.getProductType() + "  " + slot;
        printToLogFile(line, initialBalance, endingBalance);
    }

    private void printToLogFile(String line, BigDecimal beginning, BigDecimal end) {


        //Define new Log File
        File logFile = new File("log.txt");

        //Check if the log file does not exist, if not then create it
        if (!logFile.exists()) {
            try {
                logFile.createNewFile();

            } catch (IOException e) {
                System.out.println("Unable to create the Log File");
                e.printStackTrace();
            }
        //Check if Directory exists with file name 'log.txt'
        } else if (logFile.exists() && logFile.isDirectory()) {
            System.out.println("The Directory with name 'log.txt' exists.");
        }

        try (FileOutputStream lines = new FileOutputStream(logFile, true);
             PrintWriter pw = new PrintWriter(logFile)) {
                pw.println("This is the Vending Machine transaction history");
                pw.append(String.format(new SimpleDateFormat("MM/dd/YYYY hh:mm:ss a").format(new java.util.Date())));
                pw.append(String.format(line));
                pw.append(String.format("$" + beginning.toString()));
                pw.append(String.format("$" + end.toString()));

             } catch (IOException e) {
            System.out.println("Log File has been closed! Could not get transaction History.");
        }
    }
}







