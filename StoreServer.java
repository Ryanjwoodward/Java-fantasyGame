package storeDriver;

import store.*;

import java.net.ServerSocket;
import java.net.Socket;

import java.util.*;
import store.*;
import java.net.*;
import java.io.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;

public class StoreServer {

	private Socket _socket;
	private ServerSocket _server;
	private DataInputStream _in;

	static Scanner scan = new Scanner(System.in);
	static StoreFront myStore = new StoreFront(120, "Quark's");
	static ShoppingCart myCart = new ShoppingCart();

	
	public static void main(String[] args) {

		System.out.println("Server main() accessed..."); // [FOR TESTING]
		StoreServer _server = new StoreServer(6666);

	}
	
	/**
	 * @param port
	 * The consructor, called by main, is used as server to communicate with client and the storeFront
	 * Methods, U and R commands can be sent from the client, where store commands are managed in the server
	 * console
	 */
	public StoreServer(int port) {

		try {

			_server = new ServerSocket(port);
			System.out.println("Server Started...");
			System.out.println("Waiting for Client...");

			_socket = _server.accept();
			System.out.println("Client Accepted...");

			_in = new DataInputStream(new BufferedInputStream(_socket.getInputStream()));

			String str = "";
			int invtSelection = 0;

			while (!str.equalsIgnoreCase("S")) {

				System.out.println("\n\tEnter One the following Characters.... \n\tA.) Access Store Front Application\n\tU.) Update the Store Inventory"
						+ "\n\tR.) Display what is in the current Inventory\n\tS.) Stop the program");

				try {
					str = _in.readUTF();
					System.out.println("You Entered: " + str);

					if (str.equalsIgnoreCase("A")) {

						mainMenu();

					} else if (str.equalsIgnoreCase("U")) {

						inventoryUpdate();

					} else if (str.equalsIgnoreCase("R")) {
							
						inventoryRead();
					}

				} catch (IOException ioe) {

					System.out.println(ioe);
				}

			}

			System.out.println("Closing Connection...");
			_socket.close();
			_in.close();

		} catch (IOException ioe) {

			System.out.println(ioe);
		}

	}// runServer Method

	/**
	 * Method onlt to send a specific value to the parse method to print the inventory's contents
	 */
	public void inventoryRead() {

		jsonFileParser(0);
	}

	/**
	 * Method called when updating the inventory
	 */
	public void inventoryUpdate() {

		int choiceInt = 0;

		System.out.println("\t    Available Inventories\n\t--------------------------------"
				+ "\n\t 1.) Elder Scrolls Themed Inventory \n\t 2. Star Trek Themed Inventory"
				+ "\n\t 3.) WWII Themed Inventory");

		choiceInt = scan.nextInt();

		switch (choiceInt) {

		case 1:// Skyrim
			jsonFileParser(1);
			break;
		case 2:// Star Trek
			jsonFileParser(2);
			break;
		case 3:// WW2
			jsonFileParser(3);
			break;
		default:
			System.out.println("\n\t Invalid Entry....");
		}
	}

	public void jsonFileParser(int option) {

		JSONParser jsonParser = new JSONParser();

		if (option == 0) {

			System.out.println("\t\t" + myStore.get_storeName()
					+ " Store Inventory\n\t-------------------------------------------------------------------------");
			myStore.storeToString();

		} else if (option == 1) {

			try (FileReader reader = new FileReader("elderScrollsInvt.json")) {

				Object obj = jsonParser.parse(reader);

				JSONArray inventory = (JSONArray) obj;

				inventory.forEach(item -> parseProduct((JSONObject) item));

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}

		} else if (option == 2) {

			try (FileReader reader = new FileReader("starTrekInvt.json")) {

				Object obj = jsonParser.parse(reader);

				JSONArray inventory = (JSONArray) obj;

				inventory.forEach(item -> parseProduct((JSONObject) item));

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}

		} else if (option == 3) {

			try (FileReader reader = new FileReader("ww2Invt.json")) {

				Object obj = jsonParser.parse(reader);

				JSONArray inventory = (JSONArray) obj;

				inventory.forEach(item -> parseProduct((JSONObject) item));

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}

		} else {

			System.out.println("\n\tERROR: Invalid Entry...");
		}

	}// jsonFileParser

	/**
	 * @param prd THis method is calledin the main and it is used to get each
	 *            attribute of the SalableProducts Objects contained inside. It then
	 *            adds each of these items to the Store Inventory
	 */
	private static void parseProduct(JSONObject prd) {

		String name = (String) prd.get("_name");
		// System.out.println("name: " + name);

		String descr = (String) prd.get("_description");
		// System.out.println("descr: " + descr);

		Long qty = (Long) prd.get("_quantity");
		// System.out.println("qty: " + qty);
		int quantity = Math.toIntExact(qty);

		Long itemNum = (Long) prd.get("_itemNumber");
		// System.out.println("itemNum" + itemNum);
		int itmNumber = Math.toIntExact(itemNum);

		Double price = (Double) prd.get("_price");
		// System.out.println("price: " + price);

		if (itemNum >= 1000 && itemNum < 2000) {// Armor

			Double protRate = (Double) prd.get("_protectionRating");
			// System.out.println("protect: " + protRate);

			Double weight = (Double) prd.get("_weight");
			// System.out.println("weight: " + weight);
			Armor armr = new Armor(name, descr, quantity, itmNumber, price, protRate, weight);
			myStore.addItemToStore(armr);
		} else if (itemNum >= 2000 && itemNum < 3000) {// Health

			Double healthCap = (Double) prd.get("_healthCapacity");
			// System.out.println("hCap: " + healthCap);
			Health hlth = new Health(name, descr, quantity, itmNumber, price, healthCap);
			myStore.addItemToStore(hlth);
		} else if (itemNum >= 3000 && itemNum < 4000) {// Weapon

			Double range = (Double) prd.get("_range");
			// System.out.println("range: " + range);

			Double dmg = (Double) prd.get("_damage");
			// System.out.println("damage: " + dmg);
			Weapon weap = new Weapon(name, descr, quantity, itmNumber, price, range, dmg);
			myStore.addItemToStore(weap);
		}

	}// parseProduct

	/**
	 * The mainMenu() is the how the user interacts with the storefront,
	 * shoppingcart, and inventory classes
	 */
	public void mainMenu() {
		System.out.println("main menu accessed...");
		boolean mainRunner = true; // This variable is used for the condition of the do-While for mainMenu()

		int userEntered_ItemNumber = 0, userEntered_Qty = 0, userValue = 0; // These variables are used to store any
																			// user input for Item Number of Quantity

		SalableProduct prd, prd2;
		int itmNumb;

		do {

			System.out.print("\n\n\t       Welcome to " + myStore.get_storeName()
					+ "\n\t------------------------------------------------");
			System.out.println("\n\t 1.) Display Store Inventory\n\t 2.) Display Shopping Cart Contents"
					+ "\n\t 3.) Add an Item to Cart\n\t 4.) Update Qty or Remove Item from Cart\n\t 5.) Clear Shopping Cart\n\t 6.) Sort Inventory"
					+ "\n\t 7.) Create new Item for Inventory\n\t 8.) EXIT Program");

			userEntered_ItemNumber = scan.nextInt();

			switch (userEntered_ItemNumber) {

			case 1:// Display Store Inventory

				System.out.println("\t\t" + myStore.get_storeName()
						+ " Store Inventory\n\t-------------------------------------------------------------------------");
				myStore.storeToString();

				break;

			case 2:// Display Shopping Cart

				System.out.println(
						"\t\t     ShoppingCart Inventory\n\t-------------------------------------------------------------------------");
				myCart.cartToString(myCart);
				break;

			// ----------------------------------------------------------------------------------------------------------------------------
			// ----------------------------------------------------------------------------------------------------------------------------
			case 3:// Add an item to the shoppingCart

				System.out.print("\n\t What is the 'item number': ");
				userEntered_ItemNumber = scan.nextInt();

				System.out.print("\n\t Enter desired 'Quantity': ");
				userEntered_Qty = scan.nextInt();

				// Gets the item based upon the entered item number and store it in prd
				prd = myStore.getItemFromStoreInventory(userEntered_ItemNumber);

				// Error Checking: item number must be between 0 and 9999 and the requested Qty
				// cannot be greater than available
				if (userEntered_ItemNumber < 0 || userEntered_ItemNumber > 9999
						|| prd.get_quantity() < userEntered_Qty) {

					System.out.println("\n\tERROR: Ivalid values entered... Returning to Main menu...");
					mainRunner = true;
				} else {

					if (prd instanceof Weapon) {

						Weapon wpn = new Weapon((Weapon) prd);

						if (!(myCart.checkIfItemInCart(userEntered_ItemNumber))) {

							myCart.addItem(wpn, userEntered_Qty);
							prd.set_quantity((prd.get_quantity() - userEntered_Qty));
						} else {

							System.out.print("\n\t That item is already in your cart."
									+ "\n\t Would you like to update the Quantity? (1 = Yes, 2 = No):");
							userValue = scan.nextInt();

							switch (userValue) {
							case 1:

								System.out.print("\n\t Enter the desired quantity: ");
								userEntered_Qty = scan.nextInt();

								// This line sets the item quantity by getting the item quantity and adding the
								// entered value
								myCart.getItemWithItemNumber(userEntered_ItemNumber).set_quantity(
										(myCart.getItemWithItemNumber(userEntered_ItemNumber).get_quantity()
												+ userEntered_Qty));
								prd.set_quantity((prd.get_quantity() - userEntered_Qty));

								break;
							default:
								System.out.print("\n\t ERROR: Invalid value entered. Returning to Main menu...");
								mainRunner = true;
							}

						}
					} else if (prd instanceof Armor) {

						Armor armr = new Armor((Armor) prd);

						if (!(myCart.checkIfItemInCart(userEntered_ItemNumber))) {

							myCart.addItem(armr, userEntered_Qty);
							prd.set_quantity((prd.get_quantity() - userEntered_Qty));
						} else {

							System.out.print("\n\t That item is already in your cart."
									+ "\n\t Would you like to update the Quantity? (1 = Yes, 2 = No):");
							userValue = scan.nextInt();

							switch (userValue) {
							case 1:

								System.out.print("\n\t Enter the desired quantity: ");
								userEntered_Qty = scan.nextInt();

								// This line sets the item quantity by getting the item quantity and adding the
								// entered value
								myCart.getItemWithItemNumber(userEntered_ItemNumber).set_quantity(
										(myCart.getItemWithItemNumber(userEntered_ItemNumber).get_quantity()
												+ userEntered_Qty));
								prd.set_quantity((prd.get_quantity() - userEntered_Qty));

								break;
							default:
								System.out.print("\n\t ERROR: Invalid value entered. Returning to Main menu...");
								mainRunner = true;
							}

						}

					} else if (prd instanceof Health) {

						Health hlth = new Health((Health) prd);

						if (!(myCart.checkIfItemInCart(userEntered_ItemNumber))) {

							myCart.addItem(hlth, userEntered_Qty);
							prd.set_quantity((prd.get_quantity() - userEntered_Qty));
						} else {

							System.out.print("\n\t That item is already in your cart."
									+ "\n\t Would you like to update the Quantity? (1 = Yes, 2 = No):");
							userValue = scan.nextInt();

							switch (userValue) {
							case 1:

								System.out.print("\n\t Enter the desired quantity: ");
								userEntered_Qty = scan.nextInt();

								// This line sets the item quantity by getting the item quantity and adding the
								// entered value
								myCart.getItemWithItemNumber(userEntered_ItemNumber).set_quantity(
										(myCart.getItemWithItemNumber(userEntered_ItemNumber).get_quantity()
												+ userEntered_Qty));
								prd.set_quantity((prd.get_quantity() - userEntered_Qty));

								break;
							default:
								System.out.print("\n\t ERROR: Invalid value entered. Returning to Main menu...");
								mainRunner = true;
							}
						}

					} else {

						System.out.println("\n\tERROR: Unknown Object Type. Returning to Main Menu...");
						mainRunner = true;
					}
				}
				break;

			// ----------------------------------------------------------------------------------------------------------------------------
			// ----------------------------------------------------------------------------------------------------------------------------
			case 4:// Remove an Item from the ShoppingCart or Update Qty

				System.out.print("\n\t Enter the products 'Item Number' you wish to Update/Remove: ");
				userEntered_ItemNumber = scan.nextInt();
				prd = myStore.getItemFromStoreInventory(userEntered_ItemNumber);

				if (userEntered_ItemNumber < 0 || userEntered_ItemNumber > 9999) {

					System.out.print("\n\t ERROR: Invalid Entry. Returning to Main Menu...");
					mainRunner = true;
				} else {

					do {

						System.out.print("\n\t Enter the 'Quantity' you want removed from your cart: ");
						userEntered_Qty = scan.nextInt();

						if (userEntered_Qty > myCart.getItemWithItemNumber(userEntered_ItemNumber).get_quantity()) {

							System.out.print("\n\t ERROR: Invalid Qty for item: " + userEntered_ItemNumber + "...");
							mainRunner = true;
						} else if (userEntered_Qty == myCart.getItemWithItemNumber(userEntered_ItemNumber)
								.get_quantity()) {

							myCart.remove_Item(userEntered_ItemNumber);
							prd.set_quantity(prd.get_quantity() + userEntered_Qty);
							mainRunner = false;
						} else if (userEntered_Qty < myCart.getItemWithItemNumber(userEntered_ItemNumber)
								.get_quantity()) {

							prd.set_quantity(prd.get_quantity() + userEntered_Qty);
							myCart.getItemWithItemNumber(userEntered_ItemNumber)
									.set_quantity(myCart.getItemWithItemNumber(userEntered_ItemNumber).get_quantity()
											- userEntered_Qty);
							mainRunner = false;
						}

					} while (mainRunner);

					mainRunner = true;
				}

				break;

			// ----------------------------------------------------------------------------------------------------------------------------
			// ----------------------------------------------------------------------------------------------------------------------------
			case 5:// Clear the cart

				System.out.print("\n\t Clearing your Shopping Cart...");

				// This loop returns all the quantities to their original state within the
				// Inventory
				for (int idx = 0; idx < myCart.get_trueSize(); idx++) {

					prd = myCart.getItemWithIndex(idx);
					itmNumb = prd.get_itemNumber();

					prd2 = myStore.getItemFromStoreInventory(itmNumb);
					itmNumb = prd2.get_quantity();

					prd2.set_quantity((itmNumb + prd.get_quantity()));
				}

				myCart.clearCart();

				break;

			// ----------------------------------------------------------------------------------------------------------------------------
			// ----------------------------------------------------------------------------------------------------------------------------
			case 6:// Sort the Inventory by alphabet

				do {
					System.out.print(
							"\n\t   There are four ways to sort the inventory: \n\t---------------------------------------------------------------");
					System.out.print(
							"\n\t 1.) Alphabetically By Product Name\n\t 2.) Reverse Alphabetically By Product Name\n\t 3.)"
									+ " By Price, Least to Greatest\n\t 4.) By Price, Greatest to least\n\t 5.) Return to Main Menu");
					userValue = scan.nextInt();

					switch (userValue) {

					case 1:// Sort Inventory alphabetically by name
						myStore.callNameSort();
						mainRunner = false;
						break;

					case 2:// sort inventroy reverse alphabetically by name
						myStore.callNameReverseSort();
						mainRunner = false;
						break;

					case 3:// sort by Price L to G
						myStore.callPriceSort();
						mainRunner = false;
						break;

					case 4:// sort by price G to L
						myStore.callPriceReverseSort();
						mainRunner = false;
						break;

					case 5:
						System.out.print("\n\t Returning to Main Menu");
						mainRunner = false;
						break;

					default:
						System.out.print("\n\t ERROR: Invalid value entered... Restarting...");
						mainRunner = true;
					}

				} while (mainRunner);
				mainRunner = true;

				break;

			// ----------------------------------------------------------------------------------------------------------------------------
			// ----------------------------------------------------------------------------------------------------------------------------
			case 7:// Create a new item and add it to the Store Inventory

				System.out.print(
						"\n\t  Select the item type:\n\t----------------------------\n\t 1.) Weapon\n\t 2.) Armor\n\t 3.) Health");
				itmNumb = scan.nextInt();

				String newName, newDescr;
				int newQuant, newItmNum;
				double newPrice, newRange, newDmg, newHealthCap, newPrtctRate, newWeight;

				if (itmNumb < 1 || itmNumb > 3) {

					System.out.print("\n\t ERROR: Invalid Value Entered. Returning to Main Menu...");

				} else {

					System.out.print("\n\t Enter the 'Name': ");
					newName = scan.next();
					System.out.print("\n\t Enter brief Description: ");
					newDescr = scan.nextLine();
					System.out.print("\n\t Enter the 'quantity': ");
					newQuant = scan.nextInt();
					System.out.print("\n\t Enter the 'Item Number': ");
					newItmNum = scan.nextInt();
					System.out.print("\n\t Enter the 'Price': ");
					newPrice = scan.nextDouble();

					switch (itmNumb) {

					case 1:// Weapon

						System.out.print("\n\t Enter the Weapons' 'Range': ");
						newRange = scan.nextDouble();
						System.out.print("\n\t Enter the Weapons' Damage: ");
						newDmg = scan.nextDouble();

						Weapon woopin = new Weapon(newName, newDescr, newQuant, newItmNum, newPrice, newRange, newDmg);
						myStore.addItemToStore(woopin);

						break;

					case 2:// Armor

						System.out.print("\n\t Enter the 'Protection Rating': ");
						newPrtctRate = scan.nextDouble();
						System.out.print("\n\t Enter the 'Weight': ");
						newWeight = scan.nextDouble();

						Armor armour = new Armor(newName, newDescr, newQuant, newItmNum, newPrice, newPrtctRate,
								newWeight);
						myStore.addItemToStore(armour);

						break;

					case 3:// Health

						System.out.print("\n\t Enter the 'Health Capacity': ");
						newHealthCap = scan.nextDouble();

						Health help = new Health(newName, newDescr, newQuant, newItmNum, newPrice, newHealthCap);
						myStore.addItemToStore(help);
						break;

					default:

						System.out.print("\n\t ERROR: Unknown. Returning to main menu...");
						mainRunner = true;
					}
				}

				break;

			// ----------------------------------------------------------------------------------------------------------------------------
			// ----------------------------------------------------------------------------------------------------------------------------
			case 8:// Exit the Program

				System.out.print("\n\t Exiting Program. Auf Widersehen!");
				mainRunner = false;
				break;

			// ----------------------------------------------------------------------------------------------------------------------------
			// ----------------------------------------------------------------------------------------------------------------------------
			default: // Error Checking. Ensure that the program persists if an invalid value ie
						// entered

				System.out.print("\n\t ERROR: Invalid value entered. Restarting...");
				mainRunner = true;
			}

		} while (mainRunner);
	}// mainMenu()

	
}// StoreServer Class
