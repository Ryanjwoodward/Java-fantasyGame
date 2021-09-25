//Author: Ryan Woodward
//Date: 9-15-2021
//Class: CST-239

//Notes
//1._ Scanners and lengthy descriptions of names do not work if there is a space, use '_' 
//		for now--- scanner for strings that accepts white space.
//2.) When browsing the inventory of the store include all attibutes of the salableProduct derived classes
//3.) add escape sequence throughout the program so if a user wants to exit at any time they can.
//4.) when removing an item from the cart, the item's quantity is reduced *2 the quantity added rather than updated the quantity

package store;

import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {

	private ArrayList<SalableProduct> _inventory;
	private int _inventoryIndexCounter = 0;
	private Scanner scan = new Scanner(System.in);

	// ------------------------------------------------------------------------
	// METHODS
	// ------------------------------------------------------------------------
	public Inventory() {

		this._inventory = new ArrayList<SalableProduct>(50);

	}

	public Inventory(int sizeOfInventory) {

		this._inventory = new ArrayList<SalableProduct>(sizeOfInventory);
	}

	// This method is called to create items and add them to the store inventory
	public void addItem_Inventory(String name, String descr, int quant, int itemNum, double price) {

		this._inventory.add(new SalableProduct(name, descr, quant, _inventoryIndexCounter, price));
		this._inventoryIndexCounter++;
	}

	// -----------------------------------------------------------------------
	// This method will be called to add an item to the shoppingCart.
	public void add_Item(SalableProduct item) {

		this._inventory.add(item);
		this._inventoryIndexCounter++;
	}

	// This method is called from within the manager menu, it walks the user through
	// creating a new object then calls the addItemTOInventory()
	public void createAddItem() {

		int userSelect = 0, itmQuanty = 0, itmNumr = 0, itmLvl = 0;
		String itmName = "", itmDescr ="", itmType ="";
		double itmPrc = 0, itmRange = 0, itmDmg = 0;
		
		//'itmLvl' is 'levelRequirement' in Weapon and 'protectionRating' in Armor
		//'itmRange' is 'range' in Weapon and 'HealthCap' in Health and 'Weight' in Armor
		
		SalableProduct newItem;

		do {
			System.out.print("\n\t     Create and Add an Item\n\t----------------------------");
			System.out.print(
					"\n\t Do you want to create a: \n\t    1.) Weapon\n\t    2.) Health\n\t    3.) Armor\n\t    4.) Misc. ");
			userSelect = scan.nextInt();
			
			if(userSelect > 0 && userSelect < 5) {
				
				System.out.print("\n\t Enter the 'name' of the item: ");
				itmName = scan.next();

				System.out.print("\n\t Enter a brief 'description' of the item: ");
				itmDescr = scan.next();

				System.out.print("\n\t Enter the 'quantity' of the item: ");
				itmQuanty = scan.nextInt();

				System.out.print("\n\t Enter the 'item number'(Only first 4 digits): ");
				itmNumr = scan.nextInt();

				System.out.print("\n\t Enter the 'price' of the item: ");
				itmPrc = scan.nextDouble();
			}
			
			switch(userSelect) {
			
			case 1://weapon
				
				System.out.print("\n\t Is the weapon:\n\t    1.) Long Range\n\t    2.) Medium range\n\t    3.) Close Range\n\t    4.) Magic");
				userSelect = scan.nextInt();
				
				if(userSelect < 0 || userSelect > 4){
					System.out.print("\n\t ERROR: Invalid value entered... Restarting...");
					userSelect = 0;
					
				}else {
					
					if(userSelect == 1) {
						itmType = "Long-Range";
						itmRange = 1000;
						
						
					}	
					
					if(userSelect == 2) {
						itmType = "Medium-Range";
						itmRange = 500;
					}
					
					if(userSelect == 3) {
						itmRange = 10;
						itmType = "Close-Range";
					}
					
					if(userSelect == 4) {
						itmRange = 100000;
						itmType = "Magic";
					}
				}
				
				System.out.print("\n\t What is the damage cap on this weapon?");
				itmDmg = scan.nextDouble();
				
				if(itmDmg < 0) {
					
					System.out.print("\n\t ERROR: Invalid value entered... Restarting...");
					userSelect = 0;
				}else {
					
					if(itmDmg > 100) {
						
						itmLvl = 10;
					}else if(itmDmg < 100 && itmDmg > 50) {
					
						itmLvl = 5;
					}else if(itmDmg < 50) {
						
						itmLvl = 0;
					}
					
					
					newItem = new Weapon(itmName, itmDescr, itmQuanty, itmNumr, itmPrc, itmType, itmRange, itmDmg, itmLvl);
					this.add_Item(newItem);
					
				}
				
				
				break;
				
			case 2://health
				
				System.out.println("\n\t Is the health type:\n\t    1.) Potion\n\t    2.) Food\n\t    3.) Med-Kit");
				userSelect = scan.nextInt();
				
				if(userSelect < 0 || userSelect > 4){
					System.out.print("\n\t ERROR: Invalid value entered... Restarting...");
					userSelect = 0;
					
				}else {
					
					if(userSelect == 1) 
						itmType = "Potion";
					
					if(userSelect == 2)
						itmType = "Food";
					
					if(userSelect == 3)
						itmType = "Med-Kit";
					
					System.out.print("\n\t What is the health cap of this item: ");
					itmRange = scan.nextDouble();
					
					if(itmRange < 0 || itmRange > 1000) {
						
						System.out.print("\n\t ERROR: Invalid value entered... Restarting...");
						userSelect = 0;
					}else {
						
						
						newItem = new Health(itmName, itmDescr, itmQuanty, itmNumr, itmPrc, itmType, itmRange);
						this.add_Item(newItem);
			
					}
				}
				
				break;
				
			case 3://armor
				
				System.out.println("\n\t Is the armor type:\n\t    1.) Light\n\t    2.) Heavy\n\t    3.) Medium\n\t    4.)Other");
				userSelect = scan.nextInt();
				
				if(userSelect < 0 || userSelect > 4){
					System.out.print("\n\t ERROR: Invalid value entered... Restarting...");
					userSelect = 0;
					
				}else {
					
					if(userSelect == 1) {
						itmType = "Light";
						itmLvl = 2;
					}
					
					if(userSelect == 2) {
						itmType = "Heavy";
						itmLvl = 4;
					}
					
					if(userSelect == 3) {
						itmType = "Medium";
						itmLvl = 3;
					}
					
					if(userSelect == 4) {
						itmType = "Other";
						itmLvl = 1;
					}
					
					System.out.print("\n\t What is the weight of this armor: ");
					itmRange = scan.nextDouble();
					
					if(itmRange < 0 || itmRange > 300) {
						
						System.out.print("\n\t ERROR: Invalid value entered... Restarting...");
						userSelect = 0;
					}else {
						
						
						newItem = new Armor(itmName, itmDescr, itmQuanty, itmNumr, itmPrc, itmType, itmLvl, itmRange);
						this.add_Item(newItem);
			
					}
				}
				
				break;
				
			case 4://misc
			
				this.addItem_Inventory(itmName, itmDescr, itmQuanty, itmNumr, itmPrc);
				
				break;
			
			default:
				
				System.out.print("\n\t ERROR: Invalid value entered... Restarting...");
				userSelect = 0;
			}

		} while (userSelect == 0);
	}
	// -----------------------------------------------------------------------

	public void setItemQuantity(int index, int quantity) {

		this._inventory.get(index).set_quantity(quantity);
	}

	public String getItemName(int index) {

		return this.getItem(index).get_name();
	}

	public void removeItemFromCart(Inventory invt, ShoppingCart shoCar) {

		boolean check = false;
		int runnerInt, itmQ, idx;

		do {
			System.out.println("\n\t    Remove Items from Your Cart\n\t-------------------------------------");
			System.out.print("\t Enter the item number: ");
			runnerInt = scan.nextInt();

			if (runnerInt > 9999 || runnerInt < 0) {

				System.out.print("ERROR: invalid item number\n");
				check = true;
			}

		} while (check);

		idx = shoCar.findItemIndex(runnerInt);

		do {
			System.out.print("\n\t Enter quantity to remove: ");
			itmQ = scan.nextInt();

			if (itmQ > shoCar.getItemQuantity(idx)) {
				check = true;
				System.out.print("\n\t ERROR: value entered greater than available quantity.\n");
			} else if (itmQ <= 0) {

				check = true;
				System.out.print("\n\t ERROR: invalid value entered.\n");
			}
		} while (check);

		shoCar.removeAnItem(idx);

		idx = invt.findItemIndex(runnerInt);
		int idx2 = invt.getItemQuantity(idx) + itmQ;
		invt.setQuantityHolder(idx, idx2);

	}

	public void addItemToCart(Inventory invt, ShoppingCart shoCar) {

		boolean check = false;
		int runnerInt;// item Number
		int itmQ; // itmQ becomes the quantity of the item,
		int idx;// idx is the index where the items are located

		do {
			System.out.println("\n\t    Add Items to Your Cart\n\t-------------------------------------");
			System.out.print("\t Enter the item number: ");
			runnerInt = scan.nextInt();

			if (runnerInt > 9999 || runnerInt < 0) {

				System.out.print("ERROR: invalid item number\n");
				check = true;
			}

		} while (check);

		idx = invt.findItemIndex(runnerInt);

		do {

			System.out.print("\n\t Enter desired quantity: ");
			itmQ = scan.nextInt();

			if (itmQ > invt.getItemQuantity(idx)) {
				check = true;
				System.out.print("\n\t ERROR: value entered greater than available quantity.\n");
			} else if (itmQ <= 0) {

				check = true;
				System.out.print("\n\t ERROR: invalid value entered.\n");
			}
		} while (check);

		int idx2 = invt.findItemIndex(runnerInt);
		int updatedQ = (invt.getItem(idx2).get_quantity()) - itmQ;

		invt.getItem(idx2).set_quantityHolder(updatedQ);

		shoCar.add_Item(invt.getItem(idx));
		idx = shoCar.findItemIndex(runnerInt);
		shoCar.setItemQuantity(idx, itmQ);

	}

	// ----------------------------------------------
	// this method has to work with the item-number and search the entire list
	// for the matching item number and return that item.
	public SalableProduct getItem(int index) {

		return _inventory.get(index);
	}

	public int getItemQuantity(int index) {

		return this.getItem(index).get_quantity();
	}

	public int getQuantityHolder(int index) {

		return this.getItem(index).get_quantityHolder();
	}

	public void setQuantityHolder(int index, int newQuantity) {

		this.getItem(index).set_quantityHolder(newQuantity);
	}

	public void removeAnItem(int index) {

		this._inventoryIndexCounter--;
		int idx = this.findItemIndex(index);
		this._inventory.remove(idx);
	}

	// this search return the index of the item match by item number.
	public int findItemIndex(int itemNum) {

		for (int idx = 0; idx < this.getTrueSize(); idx++) {

			if (itemNum == _inventory.get(idx).get_itemNumber()) {

				return idx;
			}
		}

		return 0;
	}

	// ----------------------------------------------

	public int getTrueSize() {

		return this._inventoryIndexCounter;
	}

	public void removeAllItems() {

		this._inventoryIndexCounter = 0;

		this._inventory.clear();
	}

	public int sizeOfInventory() {

		return _inventory.size();
	}

	public void printInventory(Inventory invt) {

		for (int count = 0; count < invt.getTrueSize(); count++) {
			// System.out.println("INVENTORY-----index: " + count + " QUANTHolder: " +
			// invt.getQuantityHolder(count));

			System.out.print("\t" + (count + 1) + ".) " + invt.getItemName(count) + ": "
					+ invt.getItem(count).get_description() + ". Qty: " + invt.getQuantityHolder(count) + ". Price: "
					+ invt.getItem(count).get_price() + "\n");
		}
	}

	public void printEntireCart(ShoppingCart invt) {

		for (int count = 0; count < invt.getTrueSize(); count++) {

			// System.out.println("PRINT CART:-----index: " + count + " QUANTHolder: " +
			// invt.getQuantityHolder(count));

			System.out.print("\t" + (count + 1) + ".) " + invt.getItemName(count) + ": "
					+ invt.getItem(count).get_description() + ". Qty: " + invt.getItemQuantity(count) + ". Price: "
					+ invt.getItem(count).get_price() + "\n");
		}
	}

}// Inventory Class

//-----------------------------------------------------------------------------
//-----------------------------------------------------------------------------
/*
 * OLD CODE
 * 
 * 
 * public void createAddItem() {
 * 
 * String userStr = ""; String userStr2 = ""; int userInt = 0; int userInt2 =0;
 * 
 * System.out.
 * println("\t    Add a new item to the inventory:\n\t--------------------------------------"
 * ); System.out.print("\tEnter the 'name' of the item: "); userStr =
 * scan.next();
 * System.out.print("\n\tEnter a brief 'Description' of the item: "); userStr2 =
 * scan.next(); System.out.print("\n\tEnter the 'quantity' of the item: ");
 * userInt = scan.nextInt();
 * System.out.print("\n\tEnter the 'price' of the item: "); userInt2 =
 * scan.nextInt();
 * 
 * addItemToInventory(userStr, userStr2, userInt, userInt2); }
 * 
 * 
 * // This search return the item based upon the item number private
 * SalableProduct searchTheList(int itemNum) { System.out.
 * println("<-------------searchTheList() accessed------------------>"); for
 * (int idx = 0; idx < this.getTrueSize(); idx++) {
 * 
 * if (itemNum == _inventory.get(idx).get_itemNumber()) {
 * 
 * return _inventory.get(idx); } }
 * 
 * return null; }
 * 
 */
//-----------------------------------------------------------------------------
//-----------------------------------------------------------------------------
