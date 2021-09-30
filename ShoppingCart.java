//Author: Ryan Woodward
//Date: 9-15-2021
//Class: CST-239

//Notes

package store;

public class ShoppingCart extends Inventory {

	private String _name;

	/**
	 * Default Constructor
	 */
	public ShoppingCart() {

		super(50);
		this._name = "shoppyCart";
	}
	
	/**
	 * @param sizeOfInventory
	 * @param name
	 * 
	 * default constructor is used to create a shoppingCart with parameter name and inventory size
	 */
	public ShoppingCart(int sizeOfInventory, String name) {
		super(sizeOfInventory);
		
		this._name = name;
	}

	/**
	 * @return the _name
	 */
	public String get_name() {
		return _name;
	}
	
	
	

	
	
	
	
	
	
	
	
}//ShoppingCart Class
