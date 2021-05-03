package com.coursework2.petshop;

import com.coursework2.dynamicdatatypes.*;


/**
 * public class 
 * @author James Agbotta
 *
 */
public class PetTest {
	// TODO: Complete all comments

	/**
	 * public static boolean confirmed() This method takes in input from the user
	 * and tests if the value results in a 'y' as the first character. This method
	 * is used for confirming user choices.
	 *
	 * @return tempChar == 'y'; returns if the user input's 1st char == 'y'
	 */
	public static boolean confirmed() {
		char tempChar;
		// means by which the input is in one case to simplify the comparison later.
		try {
			tempChar = Input.getString("").toLowerCase().charAt(0);
			while ((tempChar != 'y') && (tempChar != 'n')) {
				System.out.print("Invalid input, please try again y/n>");
				tempChar = Input.getString("").toLowerCase().charAt(0);
			}
		} // This exception wasn't caught in Input apparently
		catch (java.lang.StringIndexOutOfBoundsException e) {
			tempChar = 'n';
		}
		return (tempChar == 'y');
	}

	public static String stringInputConfirm(String query) {
		String textChoice;
		do {
			textChoice = Input.getString(query);
			System.out.print("" + textChoice + ": Is this correct? y/n");
		} while (!confirmed());
		return textChoice.strip();
	}

	public static int integerInputConfirm(String query) {
		int choice = 0;
		do {
			try {
				choice = Input.getInteger(query);
			} catch (java.lang.NumberFormatException e) {
				System.out.println("Error, setting input to 0");
			}
			System.out.print("" + choice + ": Is this correct? y/n");
		} while (!confirmed());
		return choice;
	}

	public static void main(String[] args) {
		/* initialise objects */
		int menuChoice = 0;
		boolean close = false;
		Product tempProduct;
		Pet tempPet;
		Node tempNode;
		BinaryTree test = new BinaryTree();

		/* Begin interface */

		System.out.println("<--------WELCOME TO THE PET PRODUCT STOCK SYSTEM-------->");
		System.out.println("*********************************************************\n");

		do {
			System.out.println();
			System.out.println("Here are your options:");
			System.out.println("**********************");
			System.out.println((test.getQuantity() == 1) ? ("There is currently " + test.getQuantity() + " entry")
					: ("There are currently " + test.getQuantity() + " entries"));
			System.out.println("*****************************\n");
			System.out.println("1: List Pet Entries\n" + "2: Add a New Pet Entry\n" + "3: Find Pet Product Entries\n"
					+ "0: Exit [Warning! Doing so will clear the system]");
			System.out.println("******************************\n");

			try {
				menuChoice = Input.getInteger("Your choice ->");
			} catch (java.lang.NumberFormatException e) {
				menuChoice = -1;
			}

			/* Parsing the choices in menuChoice */
			System.out.println("\n");
			switch (menuChoice) {
			case 0:
				System.out.print("Do you wish to Quit? You will lose everything.\ny/n>");
				close = confirmed();
				break;
			/* Menu Choice 1, listing the pet types */
			case 1:

				System.out.println("1: List Pet Entries ");
				System.out.println("**********************");

				if (test.getQuantity() == 0)
					System.out.println("There are no entries");
				else
					System.out.println(test.stringUp());
				System.out.println("**********************\n");

				break;
			/* Menu Choice 2, Add a new entry */
			case 2:
				do {
					System.out.println("2: Add a New Pet Entry");
					System.out.println("**********************\n");

					tempPet = new Pet(stringInputConfirm("Please enter the Pet type->")); // have the user input and
																							// confirm input.
					System.out.print("Pet type added. Do you wish to wish to add products? y/n>");
					while (confirmed()) {

						tempProduct = new Product(stringInputConfirm("Please enter the Product ID->"),
								stringInputConfirm("Please enter the product name->"),
								integerInputConfirm("Please enter the quantity of stock->"));
						tempPet.addProduct(tempProduct);
						System.out.print("Product added. Do you wish to wish to add more products? y/n>");
					}
					tempNode = new Node(tempPet);
					test.add(tempNode);
					System.out.print("Do you wish to return to the main menu? y/m>");
				} while (!confirmed());
				break;
			/* Menu Choice 3, Finding an entry */
			case 3:
				do {
					System.out.println("3: Find Pet Product Entries\n");
					System.out.println("**********************\n");

					tempPet = new Pet(stringInputConfirm("Please enter the Pet type you wish to find ->"));
					tempNode = new Node(tempPet);
					if (test.contains(tempNode)) {
						/* Find and edit Menu */
						tempNode = test.find(tempNode);
						tempPet = (Pet) tempNode.getPayload();
						System.out.println("" + tempPet.getType() + " was found.\nHere are some options:");
						do {

							if (test.getQuantity() == 0)
								System.out.println("There are no entries");
							else
								System.out.println(test.stringUp());
							System.out.println("**********************\n");
							close = false;
							System.out.println("*****************************\n");
							System.out.println("1: Show Detailed list\n" + "2: Add a New Product Entry\n"
									+ "3: Remove Product Entry\n" + "4: Remove Pet Entry\n" + "0: Exit");
							System.out.println("******************************\n");
							try {
								menuChoice = Input.getInteger("Your choice ->");
							} catch (java.lang.NumberFormatException e) {
								menuChoice = -1;
							}

							switch (menuChoice) {

							case 0:
								System.out.print("Do you wish to Quit?\ny/n>");
								close = confirmed();
								break;

							case 1:

								System.out.println(
										"Details on: " + tempPet.getType() + "\n" + tempPet.toDetailedString());
								System.out.println("\n");
								break;
							case 2:
								do {

									tempProduct = new Product(stringInputConfirm("Please enter the Product ID->"),
											stringInputConfirm("Please enter the product name->"),
											integerInputConfirm("Please enter the quantity of stock->"));
									tempPet.addProduct(tempProduct);
									System.out.print("Product added. Do you wish to wish to add more products? y/n>");
								} while (confirmed());
								tempNode = new Node(tempPet);
								test.findAndReplace(tempNode);
								break;
							case 3:
								int index;
								do {
									for (int i = 0; i < tempPet.getProductList().length; i++) {
										System.out.println(i + ": " + tempPet.getProduct(i));
									}
									index = integerInputConfirm(
											"Please enter index of the product you wish to remove->");
									if ((0 <= index) && (index < tempPet.getProductList().length)) {
										tempPet.removeProduct(index);
										System.out.print(
												"Product removed. Do you wish to wish to remove more products? y/n>");
									} else
										System.out.print(
												"Product not Found. Do you wish to wish to remove more products? y/n>");
								} while (confirmed());
								tempNode = new Node(tempPet);
								test.findAndReplace(tempNode);
								break;
							case 4:

								tempPet = new Pet(
										stringInputConfirm("Please enter the Pet type you wish to remove ->"));
								tempNode = new Node(tempPet);

								test.remove(tempNode);

								break;
							default:
								System.out.println("Invalid Input!\n\tReturning to Main Menu");
								break;
							}

						} while (!close);
					} else {
						System.out.println("" + tempPet.getType() + " was not found.");
					}

					System.out.print("Do you wish to return to the main menu? y/m>");
				} while (!confirmed());
				close = false;
				break;

			default:
				System.out.println("Invalid Input!\n\tReturning to Main Menu");
				break;

			}

		} while (!close);

		System.out.println("Closing... Have a nice day!");
	}

}
