package com.techelevator.view;

import com.techelevator.Purchase;
import com.techelevator.VendingMachine;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	private PrintWriter out;
	private Scanner in;

	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
	}

	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while (choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}

	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if (selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch (NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will be null
		}
		if (choice == null) {
			out.println(System.lineSeparator() + "*** " + userInput + " is not a valid option ***" + System.lineSeparator());
		}
		return choice;
	}

	private void displayMenuOptions(Object[] options) {
		out.println();
		for (int i = 0; i < options.length; i++) {
			int optionNum = i + 1;
			out.println(optionNum + ") " + options[i]);
		}
		out.print(System.lineSeparator() + "Please choose an option >>> ");
		out.flush();
	}
	private Object choicesPurchaseMenuOptions(Object[] options) {
		Object choice = null;
		while (choice == null) {
			displayMenuPurchaseMenu(options);
			choice = choicesPurchaseMenuOptions(options);
		}


		return choice;
	}


	public Object getUserChoiceInputPurchaseMenu(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if (selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch (NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will
			// be null
		}
		if (choice == null) {
			out.println("\n*** " + userInput + " is not a valid option ***\n");
		}
		return choice;
	}

	private void displayMenuPurchaseMenu(Object[] options) {
		for (int i = 0; i < options.length; i++) {
			int optionNum = i + 1;
			out.println(optionNum + ") " + options[i]);
		}
		//out.println("Current Money Provided: " + displayCurrentBalance());
		out.print("\nPlease choose an option >>> ");
		out.flush();

	}

	public void feedMoney() throws IOException {
		System.out.println("Please Insert U.S. Dollar Bills");
		try {
			int moneyInserted = in.nextInt();
			in.nextLine();
			if (moneyInserted == 1 || moneyInserted == 2 || moneyInserted == 5 || moneyInserted == 10) {
				VendingMachine.fedMoney(moneyInserted);
				System.out.println("Thank You For inserting $" + moneyInserted + ".00");
			} else {
				System.out.println("Please Insert Valid Currency");
			}
		} catch (InputMismatchException e) {
			System.out.println("Please Insert Valid Currency");
		}

	}

	public void selectProduct() throws IOException {
		System.out.println("Please Select Product");
		String userSelection = in.nextLine();
		String returnString = VendingMachine.purchaseItem(userSelection);
		System.out.println(returnString);

	}





}
