//Author: Ryan Woodward
//Date: 9-15-2021
//Class: CST-239

//Notes
//1.) This class is designed to be access only from the Inventory class

package store;

public class SalableProduct {
	
	private String _name;
	private String _description;
	private int _quantity;
	private int _itemNumber;
	private double _price;
	private int _quantityHolder;

	
	public SalableProduct() {
		
		this._name = "default";
		this._description = "none";
		this._quantity = 0;
		this._itemNumber = 0000;
		this._price = 0.0;
	}
	
	public SalableProduct(String name, String description, int quantity, int itemNumber, double price) {
		
		this._name = name;
		this._description = description;
		this._quantity = quantity;
		this._itemNumber = itemNumber;
		this._price = price;
		this._quantityHolder = quantity;
	}
	
	

	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public String get_description() {
		return _description;
	}

	public void set_description(String _description) {
		this._description = _description;
	}

	public int get_quantity() {
		return _quantity;
	}

	public void set_quantity(int _quantity) {
		this._quantity = _quantity;
	}

	public double get_price() {
		return _price;
	}

	public void set_price(double _price) {
		this._price = _price;
	}

	public int get_itemNumber() {
		return _itemNumber;
	}

	public void set_itemNumber(int _itemNumber) {
		this._itemNumber = _itemNumber;
	}

	public int get_quantityHolder() {
		return _quantityHolder;
	}

	public void set_quantityHolder(int _quantityHolder) {
		this._quantityHolder = _quantityHolder;
	}
	
	
}//SalableProduct Class
