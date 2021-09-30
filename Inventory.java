//Notes

package store;

/**
 * @author Ryan Woodward
 *
 * Class: CST-239
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {

	// -----------------------------------------------------------------------------------------
	// ATTRIBUTES
	// -----------------------------------------------------------------------------------------

	private ArrayList<SalableProduct> _inventory;
	private int _inventoryIndexCounter = 0;
	private Scanner scan = new Scanner(System.in);

	// ----------------------------------------------------------------------------------------
	// CONSTRUCTORS
	// ----------------------------------------------------------------------------------------

	/**
	 * Default Constructor creates a new Inventory object (ArrayList) with size of
	 * 50 elements
	 */
	public Inventory() {

		this._inventory = new ArrayList<SalableProduct>(50);

	}

	/**
	 * @param sizeOfInventory
	 * 
	 *                        the only passed parameter is the size of the
	 *                        inventory, the quantity of elements within the
	 *                        ArrayList
	 */
	public Inventory(int sizeOfInventory) {

		this._inventory = new ArrayList<SalableProduct>(sizeOfInventory);
	}

	// -----------------------------------------------------------------------------------------
	// GETTERS and SETTERS
	// -----------------------------------------------------------------------------------------
	/**
	 * 
	 * @param index
	 * @param quantity set item quantity based upon the items location(index) in the
	 *                 arrayList
	 */
	public void setItemQuantity(int index, int quantity) {

		this._inventory.get(index).set_quantity(quantity);
	}

	/**
	 * 
	 * @param index
	 * @return
	 * 
	 *         return the item name based upon the passed index (location of item in
	 *         the arrayList)
	 */
	public String getItemName(int index) {

		return this.getItem(index).get_name();

	}

	/**
	 * 
	 * @param index
	 * @return
	 * 
	 *         this method is used to return the item at the specified index. best
	 *         used with the findIndex() method which locates an the index with the
	 *         specifies itemNumber.
	 */
	public SalableProduct getItem(int index) {

		return _inventory.get(index);
	}

	/**
	 * 
	 * @param index
	 * @return
	 * 
	 *         this method will return the quantity of an item but the index of the
	 *         item (not itemNumber) must be passed
	 */
	public int getItemQuantity(int index) {

		return this.getItem(index).get_quantity();
	}

	/**
	 * 
	 * @param index
	 * @return
	 * 
	 *         this method will return the quantity of an item but the index of the
	 *         item (not itemNumber) must be passed the quantityHolder attribute is
	 *         maintained like the quantity.
	 */
	public int getQuantityHolder(int index) {

		return this.getItem(index).get_quantityHolder();
	}

	/**
	 * 
	 * @param index
	 * @param newQuantity
	 * 
	 *                    This method is called to adjust the quantityHolder
	 *                    attribute, it is essentially the quantity but will always
	 *                    have the correct quantity if there are issues displaying
	 *                    the quantity attribute.
	 */
	public void setQuantityHolder(int index, int newQuantity) {

		this.getItem(index).set_quantityHolder(newQuantity);
	}

	/**
	 * 
	 * @return
	 * 
	 *         This method returns the actual number of non-null elements within th
	 *         arrayList Object.
	 */
	public int getTrueSize() {

		return this._inventoryIndexCounter;
	}

	/**
	 * This method is not so much a setter rather an incrementer, it will incremet
	 * the truesize by 1
	 */
	public void setTrueSize(int amt1) {
		if (amt1 >= 1)
			this._inventoryIndexCounter++;

		if (amt1 <= 0)
			this._inventoryIndexCounter--;

	}

	/**
	 * 
	 * @return
	 * 
	 *         This method calls the arrayList .size() method to return the length
	 *         of the arrayList, not the actual number of items held.
	 */
	public int getSizeOfInventory() {

		return _inventory.size();
	}

	// -----------------------------------------------------------------------------------------
	// METHODS
	// -----------------------------------------------------------------------------------------

	/**
	 * @param item
	 * 
	 *             This method is for when the item to work with is already created.
	 *             It can then be add directly to the inventory by passing it to
	 *             this method. The _inventoryIndexCounter counts the elements
	 *             within the inventory arrayList
	 */
	public void add_Item(SalableProduct item) {

		this._inventory.add(item);
		this._inventoryIndexCounter++;
	}

	/**
	 * 
	 * @param index
	 * 
	 *              This method is used to remove an item from the cart or
	 *              Ivnentory, not going to be called by itself unless the user
	 *              wants to remove an item from the storeInventory.
	 */
	public void removeAnItem(int index) {

		this._inventoryIndexCounter--;
		int idx = this.findItemIndex(index);
		this._inventory.remove(idx);
	}

	/**
	 * This method can be called to remove all items from an inventory.
	 */
	public void removeAllItems() {

		this._inventoryIndexCounter = 0;

		this._inventory.clear();
	}

	/**
	 * 
	 * @param itemNum
	 * @return
	 * 
	 *         this method searches the arrayList object and returns the index of
	 *         the item matched by item number.
	 */
	public int findItemIndex(int itemNum) {

		for (int idx = 0; idx < this.getTrueSize(); idx++) {

			if (itemNum == _inventory.get(idx).get_itemNumber()) {

				return idx;
			}
		}

		System.out.print("\n\tERROR: There is no item with that Item Number.");
		return -1;
	}

	/**
	 * This method is called is the user wants to create a new SalableProduct Object
	 * (Including Child classes) to add to the store inventory.
	 */
	public void createThenAddItem() {

		int userSelect = 0, itmQuanty = 0, itmNumr = 0, itmLvl = 0;
		String itmName = "", itmDescr = "", itmType = "";
		double itmPrc = 0, itmRange = 0, itmDmg = 0;

		// 'itmLvl' is 'levelRequirement' in Weapon and 'protectionRating' in Armor
		// 'itmRange' is 'range' in Weapon and 'HealthCap' in Health and 'Weight' in
		// Armor

		SalableProduct newItem;

		do {
			System.out.print("\n\t     Create and Add an Item\n\t----------------------------");
			System.out.print(
					"\n\t Do you want to create a: \n\t    1.) Weapon\n\t    2.) Health\n\t    3.) Armor\n\t    4.) Misc. ");
			userSelect = scan.nextInt();

			if (userSelect > 0 && userSelect < 5) {

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

			switch (userSelect) {

			case 1:// weapon

				System.out.print(
						"\n\t Is the weapon:\n\t    1.) Long Range\n\t    2.) Medium range\n\t    3.) Close Range\n\t    4.) Magic");
				userSelect = scan.nextInt();

				if (userSelect < 0 || userSelect > 4) {
					System.out.print("\n\t ERROR: Invalid value entered... Restarting...");
					userSelect = 0;

				} else {

					if (userSelect == 1) {
						itmType = "Long-Range";
						itmRange = 1000;

					}

					if (userSelect == 2) {
						itmType = "Medium-Range";
						itmRange = 500;
					}

					if (userSelect == 3) {
						itmRange = 10;
						itmType = "Close-Range";
					}

					if (userSelect == 4) {
						itmRange = 100000;
						itmType = "Magic";
					}
				}

				System.out.print("\n\t What is the damage cap on this weapon?");
				itmDmg = scan.nextDouble();

				if (itmDmg < 0) {

					System.out.print("\n\t ERROR: Invalid value entered... Restarting...");
					userSelect = 0;
				} else {

					if (itmDmg > 100) {

						itmLvl = 10;
					} else if (itmDmg < 100 && itmDmg > 50) {

						itmLvl = 5;
					} else if (itmDmg < 50) {

						itmLvl = 0;
					}

					newItem = new Weapon(itmName, itmDescr, itmQuanty, itmNumr, itmPrc, itmType, itmRange, itmDmg,
							itmLvl);
					this.add_Item(newItem);

				}

				break;

			case 2:// health

				System.out.println("\n\t Is the health type:\n\t    1.) Potion\n\t    2.) Food\n\t    3.) Med-Kit");
				userSelect = scan.nextInt();

				if (userSelect < 0 || userSelect > 4) {
					System.out.print("\n\t ERROR: Invalid value entered... Restarting...");
					userSelect = 0;

				} else {

					if (userSelect == 1)
						itmType = "Potion";

					if (userSelect == 2)
						itmType = "Food";

					if (userSelect == 3)
						itmType = "Med-Kit";

					System.out.print("\n\t What is the health cap of this item: ");
					itmRange = scan.nextDouble();

					if (itmRange < 0 || itmRange > 1000) {

						System.out.print("\n\t ERROR: Invalid value entered... Restarting...");
						userSelect = 0;
					} else {

						newItem = new Health(itmName, itmDescr, itmQuanty, itmNumr, itmPrc, itmType, itmRange);
						this.add_Item(newItem);

					}
				}

				break;

			case 3:// armor

				System.out.println(
						"\n\t Is the armor type:\n\t    1.) Light\n\t    2.) Heavy\n\t    3.) Medium\n\t    4.)Other");
				userSelect = scan.nextInt();

				if (userSelect < 0 || userSelect > 4) {
					System.out.print("\n\t ERROR: Invalid value entered... Restarting...");
					userSelect = 0;

				} else {

					if (userSelect == 1) {
						itmType = "Light";
						itmLvl = 2;
					}

					if (userSelect == 2) {
						itmType = "Heavy";
						itmLvl = 4;
					}

					if (userSelect == 3) {
						itmType = "Medium";
						itmLvl = 3;
					}

					if (userSelect == 4) {
						itmType = "Other";
						itmLvl = 1;
					}

					System.out.print("\n\t What is the weight of this armor: ");
					itmRange = scan.nextDouble();

					if (itmRange < 0 || itmRange > 300) {

						System.out.print("\n\t ERROR: Invalid value entered... Restarting...");
						userSelect = 0;
					} else {

						newItem = new Armor(itmName, itmDescr, itmQuanty, itmNumr, itmPrc, itmType, itmLvl, itmRange);
						this.add_Item(newItem);

					}
				}

				break;

			case 4:// misc

				newItem = new SalableProduct(itmName, itmDescr, itmQuanty, itmNumr, itmPrc);
				this.add_Item(newItem);

				break;

			default:

				System.out.print("\n\t ERROR: Invalid value entered... Restarting...");
				userSelect = 0;
			}

		} while (userSelect == 0);

	}// createThenAddItem method -End

	/**
	 * 
	 * @param invt
	 * @param shoCar
	 * 
	 *               This method walks the user through removing items that were
	 *               previously added.
	 */
	public void removeItemFromCart(Inventory invt, ShoppingCart shoCar) {

		boolean check = false;
		int runnerInt, itmQ, idx;

		if (shoCar.getTrueSize() <= 0) {// added to ensure that the we are not working with an empty shoppingCart
			check = true;
			System.out.print("ERROR: There are no items in the cart.");
		}

		while (!check) {

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

				if (itmQ > shoCar.getItemQuantity(idx)) {// Erro check Qty to remove from cart cannot be greater than
															// Qty in cart
					check = true;
					System.out.print("\n\t ERROR: value entered greater than available quantity.\n");

				} else if (itmQ <= 0) {// Erro check, the Qty to remove cant be 0

					check = true;
					System.out.print("\n\t ERROR: invalid value entered.\n");

				} else if (itmQ == shoCar.getItemQuantity(idx)) {// if Qty in Cart is same Qty to remove

					// removes the item completely from the shoppingCart
					shoCar.removeAnItem(runnerInt);
					shoCar.setTrueSize(-1);

					// this updates the qty of the inventory by adding the Qty (itmQ) removed from
					// cart back to the inventory
					invt.setQuantityHolder(invt.findItemIndex(runnerInt),
							(invt.getQuantityHolder(invt.findItemIndex(runnerInt)) + itmQ));
					check = false;

				} else if (itmQ < shoCar.getItemQuantity(idx)) {

					// this updates the shoppingCart qty by remove itmQ from the items Qty
					shoCar.setItemQuantity(idx, (shoCar.getItemQuantity(idx) - itmQ));

					// this updates the qty of the inventory by adding the Qty (itmQ) removed from
					// cart back to the inventory
					invt.setQuantityHolder(invt.findItemIndex(runnerInt),
							(invt.getQuantityHolder(invt.findItemIndex(runnerInt)) + itmQ));
					check = false;
				}

			} while (check);

			check = true;

		} // initial while

	}// removeItemFromCart -end

	/**
	 * 
	 * @param invt
	 * @param shoCar
	 * 
	 *               This method walks the user through adding an item to the cart
	 *               (and adjusting quantities of the cart and store Inventory)
	 */
	public void addItemToCart(Inventory invt, ShoppingCart shoCar) {

		boolean check = false;
		int runnerInt;// item Number
		int itmQ; // itmQ becomes the quantity of the item,
		int idx;// idx is the index where the items are located

		// This initial do-while is to error check the itemNumber entered
		do {
			System.out.println("\n\t    Add Items to Your Cart\n\t-------------------------------------");
			System.out.print("\t Enter the item number: ");
			runnerInt = scan.nextInt();

			if (runnerInt > 9999 || runnerInt < 0) {

				System.out.print("ERROR: invalid item number\n");
				check = true;
			}

		} while (check);

		// This statement locates the index of the element specified by the itemNumber
		idx = invt.findItemIndex(runnerInt);

		// This second do-while is error checking for the quantity (to add)
		// entered by the user if entered is greater then available Qty then ERROR
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
		/*
		 * At this point in the method:
		 * 
		 * 'idx' = the index of the element we want to add 'itmQ' = the quantity that
		 * will be added to the Cart 'runnerInt' = the ItemNumber of item wanted
		 */

		// gets the item from the storeInventory (based on the index) and adds it to the
		// shoppingCart arrayList
		shoCar.add_Item(invt.getItem(idx));

		// sets the quantityHolder of the item we are adding to the cart and sets that
		// as the new quantity.
		invt.getItem(invt.findItemIndex(runnerInt))
				.set_quantityHolder((invt.getItemQuantity(invt.findItemIndex(runnerInt))) - itmQ);

		// sets the quantity of the item just added to the shoppingCart to the desired
		// (entered) quantity above (runnerInt)
		shoCar.getItem(shoCar.findItemIndex(runnerInt)).set_quantity(itmQ);

	}// addItemToCart -end

	// ------------------------------------------------------------------
	// TO STRING
	// ------------------------------------------------------------------
	/**
	 * 
	 * @param invt
	 * 
	 *             This toString method is designed for the storeFront's inventory.
	 *             it will print to correct quantities post adding and removing
	 */
	public void toString(Inventory invt) {

		for (int count = 0; count < invt.getTrueSize(); count++) {
			// System.out.println("INVENTORY-----index: " + count + " QUANTHolder: " +
			// invt.getQuantityHolder(count));

			System.out.print("\t" + (count + 1) + ".) " + invt.getItemName(count) + ": "
					+ invt.getItem(count).get_description() + ". Qty: " + invt.getQuantityHolder(count) + ". Price: "
					+ invt.getItem(count).get_price() + "\n");
		}
	}

	/**
	 * 
	 * @param invt
	 * 
	 *             This method is used to print the Inventory object passed, all the
	 *             elements within the arrayList will be displayed
	 */
	public void toString(ShoppingCart invt) {

		for (int count = 0; count < invt.getTrueSize(); count++) {

			System.out.print("\t" + (count + 1) + ".) " + invt.getItemName(count) + ": "
					+ invt.getItem(count).get_description() + ". Qty: " + invt.getItemQuantity(count) + ". Price: "
					+ invt.getItem(count).get_price() + "\n");
		}
	}

}// Inventory Class
