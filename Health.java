package store;

/**
 * @author Ryan Woodward
 *
 * Class: CST-239
 * Description: Health class is a child class to the SalableProduct. Thhis class add items to restore a characters health
 * Type: potion, food, of med-pack. HealthCappacity: is how much health the item can restore.
 */

public class Health extends SalableProduct{

	private String _type;//potion food, med pack
	private double _healthCapacity;
	
	
	/**
	 * Default constructor uses default values from super() and its own attributes
	 */
	public Health() {
		super();
		
		this._type = "none";
		this._healthCapacity = 0.0;
	}
	
	/**
	 * 
	 * @param name
	 * @param description
	 * @param quantity
	 * @param itemNumber
	 * @param price
	 * @param type
	 * @param healthCap
	 * 
	 * This overloaded constructore calls the SalableProduct overloaded constructor, and uses passed parameters
	 * type and healthCapacity to initialize it's own attributes
	 */
	public Health(String name, String description, int quantity, int itemNumber, double price, String type, double healthCap) {
		super(name, description, quantity, itemNumber, price);
		
		this._type = type;
		this._healthCapacity = healthCap;
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
	 * @return the _healthCapacity
	 */
	public double get_healthCapacity() {
		return _healthCapacity;
	}
	/**
	 * @param _healthCapacity the _healthCapacity to set
	 */
	public void set_healthCapacity(double _healthCapacity) {
		this._healthCapacity = _healthCapacity;
	}
	
	
}//Health Class
