package com.techelevator;

import com.techelevator.view.Menu;

import java.io.File;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };

	private Menu menu;

	public VendingMachineCLI(Menu menu) {

		this.menu = menu;
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {

				// display vending machine items
				Scanner scanner = new Scanner(System.in);
				String path = (System.getProperty("user.dir") + "\\vendingmachine.csv");
				File inputList = new File(path);

				if (inputList.exists()) {
					System.out.print("Stocking vending machine via: ");
					System.out.println(path);
					VendingMachine vendingMachine = new VendingMachine(inputList);
				} else {
					System.out.println("Inventory file does not exist.");
					System.out.print("Enter absolute path of inventory file: ");
					path = scanner.nextLine();
					File userInputList = new File(path);
					VendingMachine vendingMachine = new VendingMachine(userInputList);
				}


			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
