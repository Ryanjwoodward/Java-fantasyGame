package store;

 /**
 * @author Ryan Woodward
 *
 * Date: 9/20/2021
 * Class: CST-239
 * Description: Armor class is a child class to the SalableProduct. This adds armor qualities to the product. 
 * Type: Light, Medium, Heavy, Clothing. Protection Rating (defensive point value to deduct form damage). Weight is how heavy the armor piece is.
 */

public class Armor extends SalableProduct{
	
	private String _type; //light, medium, heavy or clothing
	private int _protectionRating;
	private double _weight;
	
	/**
	 * Default constructor uses default values from super() and its own attributes
	 */
	public Armor() {
		super();
		
		this._type = "none";
		this._protectionRating = 0;
		this._weight = 0.0;
	}
	
	/**
	 * 
	 * @param name  this is the name of the Armor piece (from SalableProduct)
	 * @param description this is the description of the product (from SalableProduct)
	 * @param quantity this is the quantity of the item (from SalableProduct)
	 * @param itemNumber this is the item number (from SalableProduct)
	 * @param price the price of the item (from SalableProduct)
	 * @param type unique to Armor
	 * @param protectRate (unique to Armor)
	 * @param weight (unique to Armor0
	 * 
	 * Non-default constructor initializes attributes with super() and with passed parameters type
	 * protectionrating, and weight
	 */
	public Armor(String name, String description, int quantity, int itemNumber, double price, String type, int protectRate, double weight) {
		super(name, description, quantity, itemNumber, price);
		
		this._type = type;
		this._protectionRating = protectRate;
		this._weight = weight;
	}

	/**
	 * @return the _type
	 */
	public String get_type() {
		return _type;
	}

	/**
	 * @param _type the _type to set
	 */
	public void set_type(String _type) {
		this._type = _type;
	}

	/**
	 * @return the _protectionRating
	 */
	public int get_protectionRating() {
		return _protectionRating;
	}

	/**
	 * @param _protectionRating the _protectionRating to set
	 */
	public void set_protectionRating(int _protectionRating) {
		this._protectionRating = _protectionRating;
	}

	/**
	 * @return the _weight
	 */
	public double get_weight() {
		return _weight;
	}

	/**
	 * @param _weight the _weight to set
	 */
	public void set_weight(double _weight) {
		this._weight = _weight;
	}

	/**
	 * tostring, calls super.toString()
	 */
	@Override
	public String toString() {
		return  super.toString() + "Item Type: Armor (" + _type + "). protectionRating: " + _protectionRating + ". Weight: " + _weight;
	}
	
	
	
	

}//Armor Class
