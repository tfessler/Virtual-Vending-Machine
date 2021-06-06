package com.techelevator.view;

import com.techelevator.Product;
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
	public Object getChoiceFromOptionsPurchaseMenu(Object[] options) {
		Object choice = null;
		while (choice == null) {
			displayMenuPurchaseMenu(options);
			choice = getChoiceFromOptions(options);
		}


		return choice;
	}


	/*public Object getUserChoiceInputPurchaseMenu(Object[] options) {
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
	}*/

	private void displayMenuPurchaseMenu(Object[] options) {
		Purchase balance = new Purchase();
		for (int i = 0; i < options.length; i++) {
			int optionNum = i + 1;
			out.println(optionNum + ") " + options[i]);
		}
		out.println("Current Money Provided: " + balance);
		out.print("\nPlease choose an option \n1) Feed Money \n2) Select Product \n3)Finish Transaction ");
		out.flush();

	}

	public void feedMoney() throws IOException {
		System.out.println("Please Insert U.S. Dollar Bills ($1 ,$2 ,$5, or $10)" );
		VendingMachine newVendingMachine = new VendingMachine();
		try {
			int moneyInserted = in.nextInt();
			in.nextLine();
			if (moneyInserted == 1 || moneyInserted == 2 || moneyInserted == 5 || moneyInserted == 10) {
				System.out.println("Thank You For inserting $" + moneyInserted + ".00");
			} else {
				System.out.println("Please Insert Valid Currency");
			}
		} catch (InputMismatchException e) {
			System.out.println("Please Insert Valid Currency");
		}

	}


	public void finishTransaction() throws IOException {
		//System.out.println(Purchase.displaysChange());
	}

	public void returnSoundMessages() {
		//no way to grab sounds for each product need to make a map
		}


//need a way to select product
	public void selectProduct() throws IOException {
		Purchase newPurchase = new Purchase();
		System.out.println("Please Select Product");
		String userSelection = in.nextLine();
		String returnString = newPurchase.purchaseItem(userSelection);
		System.out.println(returnString);
	}

}
