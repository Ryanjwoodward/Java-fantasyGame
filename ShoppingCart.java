//NOTES:

package store;

import java.util.ArrayList;

/**
 * @author Ryan Woodward
 * Date: 10-5-2021 
 * Class: CST-239 
 * Description:
 */
public class ShoppingCart<T> {

	private ArrayList<T> _shoppingCart;
	private int _trueSize;

	/**
	 * default constructor initializes _shoppingCart ArrayList Attribute with a
	 * capacity of 50
	 */
	public ShoppingCart() {

		this._shoppingCart = new ArrayList<T>(50);
		this._trueSize = 0;
	}

	/**
	 * @param cartCapacity overloaded constructor initializes the _shoppingCart
	 *                     ArrayList attribute with a capacity determined by the
	 *                     user
	 */
	public ShoppingCart(int cartCapacity) {

		this._shoppingCart = new ArrayList<T>(cartCapacity);
		this._trueSize = 0;
	}
	
	/**
	 * @return the _trueSize
	 */
	public int get_trueSize() {
		return _trueSize;
	}

	/**
	 * @param item this method is passed a salable product and then adds that passed
	 *             item to the shopping cart
	 */
	public void addItem(SalableProduct item, int qtyAdded) {

		this._shoppingCart.add((T) item);
		this._trueSize++;
		item.set_quantity(qtyAdded);
	}

	/**
	 * @param itemNumber
	 * this method takes a salableProduct objects itemNumber and finds the index of this item
	 * within the shopping cart and then removes it from the cart.
	 */
	public void remove_Item(int itemNumber) {

		this._trueSize--;
		int idx = getItemIdxFromItemNumber(itemNumber);
		this._shoppingCart.remove(idx);
	}
	
	/**
	 * 
	 * @param itemNumber
	 * @return the idx of the item with the pass itemNumber parameter this should be
	 *         call from get the name or any attribute from an item.
	 */
	public int getItemIdxFromItemNumber(int itemNumber) {
		int idx = 0;

		for (T item : _shoppingCart) {

			if (itemNumber == ((SalableProduct) item).get_itemNumber())
				return idx;

			idx++;
		}

		System.out.println("ERROR: Shopping Cart getItemIdxFromItemNumber()...");
		return 0;
	}
	
	/**
	 * @param index
	 * @return
	 * This method simply return the item at the passed index of the ArrayList
	 */
	public SalableProduct getItemWithIndex(int index) {
		return (SalableProduct) _shoppingCart.get(index);
	}

	/**
	 * This method is called to remove all the items from the shoppingCart ArrayList Object
	 */
	public void clearCart() {
		
		this._trueSize = 0;
		this._shoppingCart.clear();
	}
	
	/**
	 * @param itemNumber
	 *This method determines the item based on the passed item number 
	 *then returns that item requested from the shoppingcart
	 * @return
	 */
	public SalableProduct getItemWithItemNumber(int itemNumber) {
		
		int idx = getItemIdxFromItemNumber(itemNumber);
		
		return (SalableProduct) _shoppingCart.get(idx);
	}
	
	/**
	 * @param cart
	 * toString prints all the contents of the cart
	 */
	public void cartToString(ShoppingCart cart) {
		
		for(int idx = 0; idx < this.get_trueSize(); idx++) {

			System.out.println(cart._shoppingCart.get(idx).toString());
		}
	}
	
	/**
	 * 
	 * @param itemNumber of the item we are trying to locate in the cart
	 * @return t/f if the item is found in the shoppingCart
	 */
	public boolean checkIfItemInCart(int itemNumber) {
		
		if(this.get_trueSize() == 0)
			return false;
		
		for(int idx = 0;idx < this.get_trueSize(); idx++) {
			
			if(((SalableProduct) _shoppingCart.get(idx)).get_itemNumber() == itemNumber)
				return true;
		}
		
		return false;
	}


}// ShoppingCart