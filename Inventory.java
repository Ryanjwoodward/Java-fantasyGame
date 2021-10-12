//NOTES:

package store;

import java.util.ArrayList;

/**
 * @author Ryan Woodward
 *
 *         Date: 10-5-2021 Class: CST-239 Description:
 */
public class Inventory {

	private ArrayList<SalableProduct> _inventory;
	private int _trueSize; // trueSize is the actual number of items that are contained within the
							// ArrayList

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

	/**
	 * 
	 * @param itemNumber
	 * @return the idx of the item with the pass itemNumber parameter this should be
	 *         call from get the name or any attribute from an item.
	 */
	public int getItemIdxFromItemNumber(int itemNumber) {
		int idx = 0;

		for (SalableProduct item : _inventory) {

			if (itemNumber == item.get_itemNumber())
				return idx;

			idx++;
		}

		System.out.println("ERROR: getItemIdxFromItemNumber()...");
		return 0;
	}

	/**
	 * 
	 * @return the capacity of the inventory ArrayList, not the true qty items
	 *         contained within it
	 */
	public int getSizeOfInventory() {

		return _inventory.size();
	}

	/**
	 * 
	 * @param item This method will add the passed SalableProduct to the ArrayList,
	 *             only accepts SalableProducts
	 */
	public void add_Item(SalableProduct item) {

		this._trueSize++;
		this._inventory.add(item);
	}

	/**
	 * 
	 * @param itemNumber This method is passed an itemNumber attribute of an object
	 *                   within the Inventory object the item index (in AList) is
	 *                   located and used to remove the item from the ArrayList
	 */
	public void remove_Item(int itemNumber) {

		this._trueSize--;
		int idx = getItemIdxFromItemNumber(itemNumber);
		this._inventory.remove(idx);
	}

	/**
	 * This method is called to remove all items from the Inventroy ArrayList Object
	 */
	public void clearInventory() {

		this._trueSize = 0;
		this._inventory.clear();
	}


	/**
	 * @param index
	 * @return this method returns the item as the pass index
	 */
	public SalableProduct getItemWithIndex(int index) {

		return _inventory.get(index);
	}

	/**
	 * @param itemNumber This method determines the item based on the passed item
	 *                   number then returns that item requested from the inventory
	 * @return
	 */
	public SalableProduct getItemWithItemNumber(int itemNumber) {

		int idx = getItemIdxFromItemNumber(itemNumber);

		return _inventory.get(idx);
	}

	/**
	 * @param invt this toString() is used to print the inventory arrayList object
	 */
	public void toString(Inventory invt) {

		for (int idx = 0; idx < this.get_trueSize(); idx++)

			System.out.println(invt._inventory.get(idx));
	}

	
	/**
	 * A method for sorting ArrayLists.
	 */
	public static void sort(ArrayList<SalableProduct> list){
        list.sort((itm1, itm2) -> itm1.get_name().compareTo(itm2.get_name()));
  
	}
	
	
	/**
	 * @return the _inventory
	 */
	public ArrayList<SalableProduct> get_inventory() {
		return _inventory;
	}

	/**
	 * @return the _trueSize The true size attribute is not the .size() this
	 *         attribute refers to number of items within the Inventory arrayList
	 */
	public int get_trueSize() {
		return _trueSize;
	}

	
}// Inventory Class
