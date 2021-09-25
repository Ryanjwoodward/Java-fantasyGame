//Author: Ryan Woodward
//Date: 9-20-2021
//Class: CST-239

//Notes

package store;

public class Health extends SalableProduct{

	private String _type;//potion food, med pack
	private double _healthCapacity;
	
	
	public Health() {
		super();
		
		this._type = "none";
		this._healthCapacity = 0.0;
	}
	
	public Health(String name, String description, int quantity, int itemNumber, double price, String type, double healthCap) {
		super(name, description, quantity, itemNumber, price);
		
		this._type = type;
		this._healthCapacity = healthCap;
	}
	
	public String get_type() {
		return _type;
	}
	public void set_type(String _type) {
		this._type = _type;
	}
	public double get_healthReturn() {
		return _healthCapacity;
	}
	public void set_healthReturn(double _healthReturn) {
		this._healthCapacity = _healthReturn;
	}
	
	
}//Health Class
