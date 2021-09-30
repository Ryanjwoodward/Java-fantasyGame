//Notes


package store;

/**
 * @author Ryan Woodward
 *
 * Date: Start 9-15-2021. Edited 9-23-2021. Edited 9-27-2021
 * Class: StoreFront Class is the primary menu class for this project, it has an inventory attribute that maintains the stores' inventory. it also communicates with a shoppingCart Object.
 */

public class StoreFront {

	private Inventory _storeInventory;
	private String _storeName;

	/**
	 * default Constructor, calls the default constructor of the Inventory class, and gives generic name to the store.
	 */
	public StoreFront() {

		_storeInventory = new Inventory();
		this._storeName = "Java Store";

	}

	/**
	 * @param inventorySize
	 * @param _storeName
	 * 
	 * Non-Default Constructor creates a storeFront Object with Inventory(ArrayList) with size of 'inventorySize'
	 *  and assigns it a _name of storeName
	 */
	public StoreFront(String storeName, int inventorySize) {

		_storeInventory = new Inventory(inventorySize);
		this._storeName = storeName;
		
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
	
	}//overloaded Constructor

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
	 * This method is used to call the toString within the Inventory class to display
	 * the Inventory's ArrayList elements.
	 */
	public void storeToString() {
		
		_storeInventory.toString(_storeInventory);
	}

	/**
	 * @return the _storeInventory
	 */
	public Inventory get_storeInventory() {
		return _storeInventory;
	}

	/**
	 * @param _storeInventory the _storeInventory to set
	 */
	public void set_storeInventory(Inventory _storeInventory) {
		this._storeInventory = _storeInventory;
	}
	
	

}// StoreFront Class

