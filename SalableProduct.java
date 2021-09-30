package store;

/**
 * @author Ryan Woodward
 *
 * Date: 9-15-2021
 * Class: SalableProduct Class, it the Object that fills the Inventory Class' ArrayList. Parent Class to Armor, Health, and weapon
 */

public class SalableProduct {
	
	private String _name;
	private String _description;
	private int _quantity;
	private int _itemNumber;
	private double _price;
	private int _quantityHolder;

	
	
	/**
	 * Default Constructor initiates the attributes with default values
	 */
	public SalableProduct() {
		
		this._name = "default";
		this._description = "none";
		this._quantity = 0;
		this._itemNumber = 0000;
		this._price = 0.0;
	}
	

	/**
	 * @param _name
	 * @param _description
	 * @param _quantity
	 * @param _itemNumber
	 * @param _price
	 *
	 *Non-default constructor initiates the attributes of a new SalableProduct object with passed parameters
	 *The quantity holder is the same as quantity.
	 */
	public SalableProduct(String _name, String _description, int _quantity, int _itemNumber, double _price) {
		
		this._name = _name;
		this._description = _description;
		this._quantity = _quantity;
		this._itemNumber = _itemNumber;
		this._price = _price;
		this._quantityHolder = _quantity;
	}

	/**
	 * @return the _name
	 */
	public String get_name() {
		return _name;
	}

	/**
	 * @param _name the _name to set
	 */
	public void set_name(String _name) {
		this._name = _name;
	}

	/**
	 * @return the _description
	 */
	public String get_description() {
		return _description;
	}

	/**
	 * @param _description the _description to set
	 */
	public void set_description(String _description) {
		this._description = _description;
	}

	/**
	 * @return the _quantity
	 */
	public int get_quantity() {
		return _quantity;
	}

	/**
	 * @param _quantity the _quantity to set
	 */
	public void set_quantity(int _quantity) {
		this._quantity = _quantity;
	}

	/**
	 * @return the _itemNumber
	 */
	public int get_itemNumber() {
		return _itemNumber;
	}

	/**
	 * @param _itemNumber the _itemNumber to set
	 */
	public void set_itemNumber(int _itemNumber) {
		this._itemNumber = _itemNumber;
	}

	/**
	 * @return the _price
	 */
	public double get_price() {
		return _price;
	}

	/**
	 * @param _price the _price to set
	 */
	public void set_price(double _price) {
		this._price = _price;
	}

	/**
	 * @return the _quantityHolder
	 */
	public int get_quantityHolder() {
		return _quantityHolder;
	}

	/**
	 * @param _quantityHolder the _quantityHolder to set
	 */
	public void set_quantityHolder(int _quantityHolder) {
		this._quantityHolder = _quantityHolder;
	}
	
	
}//SalableProduct Class
