//NOTES:

package store;

import java.util.ArrayList;

import org.json.simple.JSONArray;

/**
 * @author Ryan Woodward
 *
 * Date: 10-5-2021
 * Class:  CST-239
 * Description:
 */
public class StoreFront {
	
	private Inventory _storeInventory;
	private String _storeName;
	
	/**
	 * Default constructor initializes the store with inventory size of 50 and generic name
	 */
	public StoreFront() {
		
		_storeInventory = new Inventory();
		this._storeName = "My Store";
	}
	
	/**
	 * @param _storeInventory
	 * @param _storeName
	 */
	public StoreFront(int inventorySize, String _storeName) {
		
		_storeInventory = new Inventory(inventorySize);
		this._storeName = _storeName;
	}
	
	/**
	 * @return the _storeName
	 */
	public String get_storeName() {
		return _storeName;
	}

	/**
	 * @param _storeName the _storeName to set
	 */
	public void set_storeName(String _storeName) {
		this._storeName = _storeName;
	}
	
	//Store Related Inventory Operations
	
	/**
	 * This toString is called by the StoreFront to print the storefront's inventory.
	 */
	public void storeToString() {
		
		_storeInventory.toString(_storeInventory);
	}
	
	/**
	 * 
	 * @param itemNumber passed to Inventory method to obtain an item
	 * @return the item from the inventory method to the method call
	 */
	public SalableProduct getItemFromStoreInventory(int itemNumber) {
		
		return _storeInventory.getItemWithItemNumber(itemNumber);
	}
	
	/**
	 * @param product
	 *	This method is used to add an item to the storeInventory by passing
	 *the desired items' itemNumber. That is sent the the inventory and
	 *handled in the Inventory class
	 */
	public void addItemToStore(SalableProduct product) {
		
		_storeInventory.add_Item(product);
	}	
	
	
	/**
	 * This method is used to communicate the method in the inventory class
	 * to sort the ivnentory arrayList alphabetically by Name
	 */
	public void callNameSort() {
		_storeInventory.orderNameSort(_storeInventory);
	}
	
	/**
	 * This method is used to communicate the method in the inventory class
	 * to sort the ivnentory arrayList reverse alphabetically by Name
	 */
	public void callNameReverseSort() {
		_storeInventory.reverseNameSort(_storeInventory);
	}
	
	/**
	 * This method is used to communicate the method in the inventory class
	 * to sort the ivnentory arrayList numerically by Price
	 */
	public void callPriceSort() {
		this._storeInventory.orderPriceSort(_storeInventory);
	}
	
	/**
	 * This method is used to communicate the method in the inventory class
	 * to sort the ivnentory arrayList numerically, greatest to least, by price
	 */
	public void callPriceReverseSort() {
		this._storeInventory.reversePriceSort(_storeInventory);
		
	}

	
}//StoreFront Class
