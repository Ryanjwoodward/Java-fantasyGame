//Author: Ryan Woodward
//Date: 9-15-2021
//Class: CST-239

//Notes
//5.) the value of the item reflected  in the inventory is incorrect
// to correct this create a method to update quanity clal in the child class and reflect the call to it in inventory.
//6.) I want to implement try..catch blocks for exception handling, limited experience in this
//8.) add an add item method in the shoppingCar class that the add item calls. then have it adjuts
//the inventory quantity as weel.
package store;

import java.util.Scanner;

public class StoreFront {

	private Inventory _storeInventory;
	private String _storeName;
	private ShoppingCart _shoppingCart;
	private Scanner scanr = new Scanner(System.in);

	public StoreFront() {

		_storeInventory = new Inventory();
		this._storeName = "Duke's Food Stall";
		_shoppingCart = new ShoppingCart();
	
	}

	public StoreFront(String storeName, int inventorySize) {

		_storeInventory = new Inventory(inventorySize);
		this._storeName = storeName;
		_shoppingCart = new ShoppingCart();
		
		//Health class calls: str, str, int, int, dbl,{str, dbl}
		//Weapon Class calls: str, str, int, int, dbl,{ str, dbl, dbl, int}
		//Armor Class calls:  str, str, int, int, dbl, {str, int, dbl}
		
		//Health items
		SalableProduct item1 = new Health("Apples", "Gala", 50, 1171, 2.0, "food", 5.0);
		SalableProduct item2 = new Health("Apples", "Red Delicious", 50, 1172, 2.0, "food", 5.0);
		SalableProduct item3 = new Health("Health Potion", "Minor Health Potion", 22, 1173, 10.2, "potion", 20.0);
		SalableProduct item4 = new Health("Health Potion", "Ultimate Health Potion", 3, 1174, 1000.0, "potion", 100.0);
		SalableProduct item5 = new Health("Med Pack", "Medium Med Pack", 10, 1175, 27.0, "medkit", 45.0);
		
		//Weapon items
		SalableProduct item6 = new Weapon("Gladius", "medium sized blade", 2, 1176, 120.0, "close range", 5.0, 50.0, 0);
		SalableProduct item7 = new Weapon("Zweihander", "two-hand sword", 1, 1177, 300.0, "close range", 7.0, 75.0, 0);
		SalableProduct item8 = new Weapon("Ar-15", "Tac-Rifle", 1, 1178, 500.0, "long range", 500.0, 20.0, 5);
		SalableProduct item9 = new Weapon("Bazooka", "Rocket Launcher", 1, 1179, 600.0, "medium range", 100.0, 300.0, 9);
		SalableProduct item10 = new Weapon("Meteor", "Summon meteor spell", 1, 1180, 200.0, "magic", 10000, 400.0, 12);
		
		//Armor items
		SalableProduct item11 = new Armor("Robes", "Mage Robes - Moderate", 1, 1181, 130.0, "light", 50, 1.5);
		SalableProduct item12 = new Armor("Breastplate", "Daedric Chestplate ", 1, 1182, 600.0, "Heavy Armor", 180, 30.0);
		SalableProduct item13 = new Armor("Kevlar", "Bullet Proof Clothing", 1, 1183, 120.0, "Medium Armor", 90, 10.0);
		SalableProduct item14 = new Armor("Red T-shirt", "Regular Poly-Cotton Blend", 200, 1184, 10.0, "No Armor", 0, 1.5);
		SalableProduct item15 = new Armor("Leather Armor", "Boiled Leather", 3, 1185, 80.0, "Medium Armor", 60, 10.5);
		
		_storeInventory.add_Item(item1);
		_storeInventory.add_Item(item2);
		_storeInventory.add_Item(item3);
		_storeInventory.add_Item(item4);
		_storeInventory.add_Item(item5);
		_storeInventory.add_Item(item6);
		_storeInventory.add_Item(item7);
		_storeInventory.add_Item(item8);
		_storeInventory.add_Item(item9);
		_storeInventory.add_Item(item10);
		_storeInventory.add_Item(item11);
		_storeInventory.add_Item(item12);
		_storeInventory.add_Item(item13);
		_storeInventory.add_Item(item14);
		_storeInventory.add_Item(item15);
		
		
		
	}
	
	public String get_storeName() {
		return _storeName;
	}

	public void set_storeName(String _storeName) {
		this._storeName = _storeName;
	}
	
	// ----------------------------------------------------------------------
	// Shopping Cart Operations
	// ----------------------------------------------------------------------
	public void add_anItem() {
		
		_shoppingCart.addItemToCart(_storeInventory, _shoppingCart);
	}
		
	public void remove_anItem() {
		
		_shoppingCart.removeItemFromCart(_storeInventory, _shoppingCart);
	}

	//----------------------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------
	//This menu is designed for milestone 2
	public void updatedMenu() {
		
		int userSelection = 0;
		String userString = "";
		
		do {
		
		System.out.print("\n\t     Welcome to " + get_storeName() + "\n\t----------------------------------------");
		System.out.print("\n\t 1.) Browse the Store\n\t 2.) Add an item to Shopping Cart\n\t 3.) Cancel an item in Shopping Cart\n\t"
				+ " 4.) Display Shopping Cart\n\t 5.) Finalize Transaction\n\t 6.) Create a new item\n\t 7.) EXIT the program"); 
		
		userSelection = scanr.nextInt();
		
			if(userSelection <= 7 && userSelection > 0){
				
	//Switch	//--------------------------------------------------------------------------------------------
				//--------------------------------------------------------------------------------------------
				switch(userSelection) {
				
				case 1://Browse the inventory, prints the entire store inventory
					
					System.out.print("\n\t     Store Inventory\n\t---------------------\n");
					_storeInventory.printInventory(_storeInventory);
					
					break;
				
				//--------------------------------------------------------------------------------------------
				//--------------------------------------------------------------------------------------------
				case 2://Add an item to the user's shopping cart

					add_anItem();
					
					break;
				
				//--------------------------------------------------------------------------------------------
				//--------------------------------------------------------------------------------------------
				case 3://remove an item from the user's shopping cart
					
					remove_anItem();
					break;
					
				//--------------------------------------------------------------------------------------------
				//--------------------------------------------------------------------------------------------
				case 4://display the users entire cart
					
					System.out.print("\n\t     Your Shopping Cart\n\t------------------------------\n");
					_shoppingCart.printEntireCart(_shoppingCart);
					
					break;
					
				//--------------------------------------------------------------------------------------------
				//--------------------------------------------------------------------------------------------
				case 5://finalize the transaction. Updates the store's inventory to reflect change in quantity and empties the cart.
						//displays farewell message displays the inventory and the cart then exits the program.
					
					System.out.print("Ready to finalize your selection and EXIT the Store?(Y/N): ");
					userString = scanr.next();
					
					if(userString.equalsIgnoreCase("y")) {
						
						System.out.print("\n\t     What you will be taking with you\n\t---------------------------------\n");
						_shoppingCart.printEntireCart(_shoppingCart);
						
						
						
						userSelection = 7;
						
					}else if(userString.equalsIgnoreCase("n")) {
						
						System.out.print("\n\t Returning to menu...");
						userSelection = 0;
					}else {
						
						System.out.print("\n\t Error: ivalid character entered...restarting");
						userSelection = 0;
					}
					
					break;
				
				//--------------------------------------------------------------------------------------------
				//--------------------------------------------------------------------------------------------
				case 6://create a new item. guides the user through a process to create their own items.
					
					_storeInventory.createAddItem();
					break;
				
					//--------------------------------------------------------------------------------------------
				//--------------------------------------------------------------------------------------------
				case 7://Exit the program
					
					System.out.print("\n\t Exiting Program....Auf Wiedersehen!");
					userSelection = 7;
					
					break;
				
				//--------------------------------------------------------------------------------------------
				//--------------------------------------------------------------------------------------------
				case 8: //Extra if needed later
					break;
				case 9://Extra if needed later
					break;
				default:
					
					System.out.print("\n\tERROR: Reason - unknown. Restarting");
					userSelection = 0;
				}
				
			}else {//if user enters invalid value on the menu
				
				System.out.print("\n\t ERROR: Invalid value entered. Entries must be 1 to 7. Restarting");
				userSelection = 0;
			}

		
		}while(userSelection != 7);//runs the menu until user enters '7'
		
		System.out.println("Exiting the Program...Auf Widersehen!");
	}//updatedMenu

}// StoreFront Class


//-----------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------
//<<<<<<<<<<<<<<<<-----------------OLD CODE---------------------->>>>>>>>>>>>>>>>
/*
 
 
 // ------------------------------------------------------------------
	// Menu Operations Methods 
	// ------------------------------------------------------------------
	//
	  //The General Operations Menu is for employees of the store to access.
	 
	public void storeOperationsMenu() {
		
		boolean check = true;
		int userSelect = 0, userInt;
		String userStr;
		do {
		System.out.println("\n\t    StoreFront Operations Menu\n\t------------------------------------");
		System.out.print("\t 1.) Check Store Name\n\t 2.) Check if an item is in stock"
				+ "\n\t 3.) Manager menu\n\t 4.) Shopper Menu\n\t 5.) EXIT Proram");

		userSelect = scanr.nextInt();

		if (userSelect == 1) {

			userStr = get_storeName();
			System.out.println("\n\t The Store name is currently: " + userStr);

		} else if (userSelect == 2) {

			System.out.print("\n\t What is the 'Item Number': ");
			userSelect = scanr.nextInt();
			
			int idx = _storeInventory.findItemIndex(userSelect);
			
			System.out.print("\n\t" + _storeInventory.getItemName(idx) + ". Qty: " 
			+ _storeInventory.getItemQuantity(idx) + ".\n");
			
		

		}else if (userSelect == 3) {
			System.out.print("\n\tA password is require to acces this menu: ");
			userStr = scanr.next();
			
			if(userStr.contentEquals("password")) {
			managerMenu();
			}else {
				
				System.out.print("\n\tReturning to General Menu...");
				storeOperationsMenu();
			}
		}else if(userSelect == 4) {
			
			System.out.println("\n\tTransferring to Shopper Menu...");
			shopperMenu();
			
			
		}else if(userSelect == 5) {
			
			System.out.print("\n\tExiting Program. Auf Wiedersehen!");
			check = false;
		}
		}while(check);
	}// generalOperationsMenu

	/*
	 * The Manager menu is designed for only managers to access, sensitive data is
	 * accessible from here
	 
	public void managerMenu() {
		// update item quant, remove item form invent, clear invent, create a new item
		int runnerInt = 0;
		int userInt = 0;
		double userDbl = 0.0;
		String userStr = "";
		;

		do {

			System.out.println("\n\t    Manager Access Menu\n\t-------------------------------");
			System.out.print(
					"\t 1.) Update and Item's 'quantity\n\t 2.) Update Item's Price\n\t 3.) Remove an Item from Store Inventory"
							+ "\n\t 4.) Create new Item and Add to Inventory\n\t 5.) Clear store Inventory"
							+ "\n\t 6.) Change the Store's name\n\t 7.) General Menu");
			runnerInt = scanr.nextInt();

			switch (runnerInt) {

			case 1:
				System.out.println("\t    Item Quantity Change\n\t------------------------------");
				System.out.print("\n\t Enter the Item Number: ");
				runnerInt = scanr.nextInt();

				System.out.print("\n\t Enter the quantity: ");
				userInt = scanr.nextInt();

				_storeInventory.getItem(runnerInt).set_quantity(userInt);
				System.out.println("The new quantity of " + _storeInventory.getItemName(runnerInt) + " is "
						+ _storeInventory.getItemQuantity(runnerInt));
				runnerInt = 0;
				
				break;

			case 2:
				
				System.out.println("\n\t    Item Price Change\n\t------------------------------");
				System.out.print("\t Enter the Item Number: ");
				runnerInt = scanr.nextInt();

				System.out.print("\n\t Enter the New Price: ");
				userDbl = scanr.nextDouble();

				runnerInt = _storeInventory.findItemIndex(runnerInt);
				_storeInventory.getItem(runnerInt).set_price(userDbl);
				
				runnerInt = 0;
				
				break;

			case 3:
				System.out.println("\t    Remove Item from Inventory\n\t--------------------------------");
				System.out.print("\n\t Enter the Item Number: ");
				runnerInt = scanr.nextInt();

				_storeInventory.removeAnItem(runnerInt);
				runnerInt = 0;
				
				break;

			case 4:

				_storeInventory.createAddItem();
				
				runnerInt = 0;

				break;

			case 5:
				System.out.println(
						"    WARNING: Are you certain you wanted to remove the store's entire inventory (Y/N)");
				userStr = scanr.next();

				if (userStr.equalsIgnoreCase("Y")) {

					_storeInventory.removeAllItems();
					System.out.println("\n\t The stores inventory has been cleared");
				} else {

					System.out.println("Operation Cancelled.");
				}
				runnerInt = 0;
				
				break;

			case 6:
				System.out.println("\n\t    Store Name Change\n\t------------------------------");
				System.out.print("\t The store name is currently " + get_storeName());
				System.out.print("\n\t Do you want to change it (Y/N):");
				userStr = scanr.next();

				if (userStr.equalsIgnoreCase("Y")) {

					System.out.print("\n\t What is the new store name: ");
					userStr = scanr.next();

					set_storeName(userStr);
					System.out.println("\n\t The stores is now called: " + get_storeName());
				} else {

					System.out.println("Operation Cancelled.");
				}
				runnerInt = 0;
				
				break;

			case 7:
				
				storeOperationsMenu();
				
				break;

			default:
			}
		} while (runnerInt == 0);
	}// mangerMenu

	
	 // Shopper Menu, Designed to be the primary runner of the class, called alone by
	 //the driver. supports all functions necessary for shopper. Add item to Cart,
	 //Remove Item from Cart, Browse (lists inventory)
	 
	public void shopperMenu() {
		int runnerInt = 0;
		int itmQ = 0;
		do {

			System.out.println(
					"\n\t    Welcome to " + get_storeName() + "\n\t-------------------------------------------------");
			System.out.print("\t 1.) Cart Status\n\t 2.) Browse the store\n\t 3.) Add Items to your Cart"
					+ "\n\t 4.) Remove Items from your cart\n\t 5.) Price an Item\n\t 6.) Checkout and EXIT program\n\t 7.) Return to Operations Menu");

			runnerInt = scanr.nextInt();

			switch (runnerInt) {

			case 1: // Cart status
				
				System.out.println("\n\t       What is in Your Cart\n\t-----------------------------------------------");
				
				_shoppingCart.printEntireCart(_shoppingCart);
			

				runnerInt = 0;
				break;
			case 2: // Browse the inventory

				System.out.println("\n\t       Store Inventory\n\t-----------------------------------------------");
				
					_storeInventory.printEntireCart(_storeInventory);
				
				runnerInt = 0;
				break;

			case 3: // Add items to cart

				boolean check = false;
				do {
					System.out.println("\n\t    Add Items to Your Cart\n\t-------------------------------------");
					System.out.print("\t Enter the item number: ");
					runnerInt = scanr.nextInt();

					if (runnerInt > 9999 || runnerInt < 0) {

						System.out.print("ERROR: invalid item number\n");
						check = true;
					}

				} while (check);
				int idx = _storeInventory.findItemIndex(runnerInt);

				
				addItemToCart();

				runnerInt = 0;
				break;
			case 4: // remove items from cart

				check = false;

				do {
					System.out.println("\n\t    Remove Items from Your Cart\n\t-------------------------------------");
					System.out.print("\t Enter the item number: ");
					runnerInt = scanr.nextInt();

					if (runnerInt > 9999 || runnerInt < 0) {

						System.out.print("ERROR: invalid item number\n");
						check = true;
					}

				} while (check);

				 idx = _shoppingCart.findItemIndex(runnerInt);
				
				do {
					System.out.print("\n\t Enter quantity to remove: ");
					itmQ = scanr.nextInt();

					if (itmQ > _shoppingCart.getItemQuantity(idx)) {
						check = true;
						System.out.print("\n\t ERROR: value entered greater than available quantity.\n");
					} else if (itmQ <= 0) {

						check = true;
						System.out.print("\n\t ERROR: invalid value entered.\n");
					}
				} while (check);
				
				removeItemFromCart();

				runnerInt = 0;
				break;
			case 5: // price an item
				
				check = true;
				do {
				System.out.println("\n\t    Price an Item\n\t--------------------------");
				System.out.print("\t Enter the Item Number: ");
				runnerInt = scanr.nextInt();
				
				if(runnerInt < 0 || runnerInt > 9999) {
					
					System.out.print("\n\t ERROR: Invalid value entered...restarting");
					check = true;
				}else {
					
					runnerInt = _storeInventory.findItemIndex(runnerInt);
					System.out.println("\n\t Item: " + _storeInventory.getItem(runnerInt).get_name()
							+ ". Price: " + _storeInventory.getItemName(runnerInt));
					
					check = false;
				}
				
				
				
				}while(check);
				
				
				
				break;
			case 6: // checkout and exit program
				
				if(_shoppingCart.getTrueSize() == 0) {
					
					System.out.println("EXTING STORE... Auf Wiedersehen!");
				}else {
					
					System.out.println("Thanks For Shopping at " + get_storeName() + " Auf Widersehen!");
					_shoppingCart.removeAllItems();
				}

				break;
				
			case 7:
					storeOperationsMenu();
					runnerInt = 1;
			default: // error check

				System.out.println("ERROR: Invalid value. Restarting...");
				runnerInt = 0;
				break;
			}

		} while (runnerInt == 0);
	}
	
 
 
 
 
 
 
 
 
 
 
 
		
 */
