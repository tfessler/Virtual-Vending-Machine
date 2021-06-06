package com.techelevator;

import com.techelevator.view.Menu;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class VendingMachineCLI {

	//Instance Variables
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };
	private static final String PURCHASE_MENU_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_FEED_MONEY,
			PURCHASE_MENU_SELECT_PRODUCT, PURCHASE_MENU_FINISH_TRANSACTION };

	private Purchase purchase = new Purchase();
	private Menu menu;
	private VendingMachine vendingMachine = new VendingMachine();

	//Constructors
	public VendingMachineCLI(Menu menu, Purchase purchase, VendingMachine vendingMachine) throws IOException {
		this.menu = menu;
		this.purchase = purchase;
		this.vendingMachine = vendingMachine;
	}

	//Methods
	public void run() throws IOException {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {

				vendingMachine.displayItems();
				// OLD CODE to display vending machine items
				// Scanner scanner = new Scanner(System.in);
				// String path = (System.getProperty("user.dir") + "\\vendingmachine.csv");
				// File inputList = new File(path);
				//
				// if (inputList.exists()) {
				// 	System.out.print("Stocking vending machine via: ");
				// 	System.out.println(path);
				// 	VendingMachine vendingMachine = new VendingMachine(inputList);
				// } else {
				// 	System.out.println("Inventory file does not exist.");
				// 	System.out.print("Enter absolute path of inventory file: ");
				// 	path = scanner.nextLine();
				// 	File userInputList = new File(path);
				// 	VendingMachine vendingMachine = new VendingMachine(userInputList);
				// }
			}

			else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				label:
				while (true) {

					String choice2 = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
					// System.out.println("Current Balance: " + purchase.getBalance());

					switch (choice2) {
						case PURCHASE_MENU_FEED_MONEY:
							purchase.feedMoney(); //insert feed money method;

							break;
						case PURCHASE_MENU_SELECT_PRODUCT:
							menu.selectProduct();
							break;
						case PURCHASE_MENU_FINISH_TRANSACTION:
							//	menu.; insert finish transaction method here
							//	menu.; insert the weird sound message here
							break label;
					}
				}
			}
		}
	}

	//Main Runner
	public static void main(String[] args) throws IOException {

		//Instance Variables
		File inputList;

		// Checks for inventory file before running the Vending Machine
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the Vending Machine.");
		System.out.println("Checking for inventory file...");

		String path = (System.getProperty("user.dir") + "\\vendingmachine.csv");
		inputList = new File(path);

		if (inputList.exists()) {
			System.out.print("Stocking vending machine via: ");
			System.out.println(path);
		} else {
			System.out.println("Inventory file does not exist.");
			System.out.print("Enter absolute path of inventory file: ");
			path = scanner.nextLine();
			inputList = new File(path);
		}

		//Instantiates all the objects only once: Menu, Purchase, Vending Machine, and Logger
		Menu menu = new Menu(System.in, System.out);
		Purchase purchase = new Purchase(System.in, System.out);
		VendingMachine vendingMachine = new VendingMachine(inputList);
		//Log log = new Log(params) will go here
		//Log will need to be added to the VendingMachineCLI constructor and
		//the param will need to be passed into the constructor below this line \/
		VendingMachineCLI cli = new VendingMachineCLI(menu, purchase, vendingMachine);
		cli.run();
	}
}
