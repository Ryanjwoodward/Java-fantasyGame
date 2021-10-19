//NOTES:

//1.) add an adjust quantity method.
//2.) if the user adds an item then wants to add the same item again havea method that works to adjust quantity rather than
//		just simpply adding it again

package store;

import java.util.ArrayList;

/**
 * @author Ryan Woodward
 * Date: 10-5-2021 
 * Class: CST-239 
 * Description:
 */
public class ShoppingCart {

	private ArrayList<SalableProduct> _shoppingCart;
	private int _trueSize;

	/**
	 * default constructor initializes _shoppingCart ArrayList Attribute with a
	 * capacity of 50
	 */
	public ShoppingCart() {

		this._shoppingCart = new ArrayList<SalableProduct>(50);
		this._trueSize = 0;
	}

	/**
	 * @param cartCapacity overloaded constructor initializes the _shoppingCart
	 *                     ArrayList attribute with a capacity determined by the
	 *                     user
	 */
	public ShoppingCart(int cartCapacity) {

		this._shoppingCart = new ArrayList<SalableProduct>(cartCapacity);
		this._trueSize = 0;
	}

	/**
	 * @param item this method is passed a salable product and then adds that passed
	 *             item to the shopping cart
	 */
	public void addItem(SalableProduct item, int qtyAdded) {

		this._shoppingCart.add(item);
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

		for (SalableProduct item : _shoppingCart) {

			if (itemNumber == item.get_itemNumber())
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
		return _shoppingCart.get(index);
	}

	/**
	 * @return the _trueSize
	 */
	public int get_trueSize() {
		return _trueSize;
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
		
		return _shoppingCart.get(idx);
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
	
	

}// ShoppingCart