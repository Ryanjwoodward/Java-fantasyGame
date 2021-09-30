//Author: Ryan Woodward
//Date: 9-15-2021
//Class: CST-239

//Notes

package store;

import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCart{

	private ArrayList<SalableProduct> _shoppingCart;
	private int _cartID;
	private String _name;
	private int _inventoryIndexCounter;
	private Scanner scan = new Scanner(System.in);
	
	
	//---------------------------------------------------------------
	//CONSTRUCTORS
	//---------------------------------------------------------------
	
	/**
	 * Default Constructor
	 */
	public ShoppingCart() {

		_shoppingCart = new ArrayList<SalableProduct>(50);
		this._cartID = 0000;
		this._name = "shoppyCart";
	}
	
	/**
	 * @param sizeOfInventory
	 * @param name
	 * 
	 * default constructor is used to create a shoppingCart with parameter name and inventory size
	 */
	public ShoppingCart(int sizeOfCart, int id, String name) {
		
		_shoppingCart = new ArrayList<SalableProduct>(sizeOfCart);
		this._cartID = id;
		this._name = name;
	}

	//---------------------------------------------------------------
	//GETTERS and SETTERS
	//---------------------------------------------------------------
	
	/**
	 * @return the _name
	 */
	public String get_name() {
		return _name;
	}

	/**
	 * @return the _shoppingCart
	 */
	public ArrayList<SalableProduct> get_shoppingCart() {
		return _shoppingCart;
	}

	/**
	 * @param _shoppingCart the _shoppingCart to set
	 */
	public void set_shoppingCart(ArrayList<SalableProduct> _shoppingCart) {
		this._shoppingCart = _shoppingCart;
	}

	/**
	 * @return the _cartID
	 */
	public int get_cartID() {
		return _cartID;
	}

	/**
	 * @param _cartID the _cartID to set
	 */
	public void set_cartID(int _cartID) {
		this._cartID = _cartID;
	}

	/**
	 * @param _name the _name to set
	 */
	public void set_name(String _name) {
		this._name = _name;
	}
	
	/**
	 * 
	 * @return the size (capacity)
	 * of the shopping cart object, arrayList
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
	 * @param index
	 * @param quantity set item quantity based upon the items location(index) in the
	 *                 arrayList
	 */
	public void setItemQuantity(int index, int quantity) {

		this._shoppingCart.get(index).set_quantity(quantity);
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

		return _shoppingCart.get(index);
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
	
	//---------------------------------------------------------------
	//METHODS
	//---------------------------------------------------------------
	/**
	 * @param item
	 * 
	 *             This method is for when the item to work with is already created.
	 *             It can then be add directly to the inventory by passing it to
	 *             this method. The _inventoryIndexCounter counts the elements
	 *             within the inventory arrayList
	 */
	public void add_Item(SalableProduct item) {

		this._shoppingCart.add(item);
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
		this._shoppingCart.remove(idx);
	}
	
	/**
	 * This method can be called to remove all items from an inventory.
	 */
	public void removeAllItems() {

		this._inventoryIndexCounter = 0;

		this._shoppingCart.clear();
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

			if (itemNum == _shoppingCart.get(idx).get_itemNumber()) {

				return idx;
			}
		}

		System.out.print("\n\tERROR: There is no item with that Item Number.");
		return -1;
	}
	
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

	
	
	//---------------------------------------------------------------
	//TO STRING
	//---------------------------------------------------------------
	
	public void toString(ShoppingCart invt) {

		for (int count = 0; count < invt.getTrueSize(); count++) {

			System.out.print("\t" + (count + 1) + ".) " + invt.getItemName(count) + ": "
					+ invt.getItem(count).get_description() + ". Qty: " + invt.getItemQuantity(count) + ". Price: "
					+ invt.getItem(count).get_price() + "\n");
		}
	}
	

	
	
	
	
	
	
	
	
}//ShoppingCart Class
