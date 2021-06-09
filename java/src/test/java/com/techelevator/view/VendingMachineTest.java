package com.techelevator.view;

import com.techelevator.VendingMachine;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.NoSuchFileException;
import java.util.Scanner;

public class VendingMachineTest {

    @Test
    public void test_blank_input_file() {
        //Arrange
        //vendingmachineTest.csv is an empty file.
        String pathToFile = "C:\\Users\\Student\\Backups for merging\\java-capstone-module-1-team-0\\java\\vendingmachineEmptyTest.csv";
        File inputFile = new File(pathToFile);

        //Act
        VendingMachine vendingMachineTest = new VendingMachine(inputFile);
        vendingMachineTest.displayItems();

        //Assert
        Assert.assertTrue(vendingMachineTest.getVendingInventory().size() == 0);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test_missing_input_file() throws Exception {
        //Arrange
        //missingFile.csv does not exist
        String pathToFile = "C:\\Users\\Student\\Backups for merging\\java-capstone-module-1-team-0\\java\\missingFile.csv";
        File inputFile = new File(pathToFile);

        //Act
        VendingMachine vendingMachineTest = new VendingMachine(inputFile);

        //Assert
        //Assert is in the annotation
    }

    @Test
    public void test_displayItems_correctly() {
        //Arrange
        String pathToFile = "C:\\Users\\Student\\Backups for merging\\java-capstone-module-1-team-0\\java\\vendingmachine.csv";
        File inputFile = new File(pathToFile);
        VendingMachine vendingMachineTest = new VendingMachine(inputFile);

        //Act
        vendingMachineTest.displayItems();

        //Assert
        Assert.assertTrue(vendingMachineTest.getVendingInventory().size() != 0);
    }
}
