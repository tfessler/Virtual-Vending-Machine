package com.techelevator;

import com.techelevator.view.Menu;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };
	private static final String PURCHASE_MENU_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_FEED_MONEY,
			PURCHASE_MENU_SELECT_PRODUCT, PURCHASE_MENU_FINISH_TRANSACTION };


	private Menu menu;

	public VendingMachineCLI(Menu menu) {

		this.menu = menu;
	}

	public void run() throws IOException {
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
			}


			else if (choice.equals(MAIN_MENU_OPTION_PURCHASE))
				label:while (true) {

					String choice2 = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);


					switch (choice2) {
						case PURCHASE_MENU_FEED_MONEY:
							menu.feedMoney(); //insert feed money method;

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







	public void main(String[] args) throws IOException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
