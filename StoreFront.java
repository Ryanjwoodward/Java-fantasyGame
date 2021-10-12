//NOTES:

//1.) get better at commit daily changes to Github
package store;

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

	/**
	 * @return the _storeInventory
	 */
	public Inventory get_storeInventory() {
		return _storeInventory;
	}

}//StoreFront Class
