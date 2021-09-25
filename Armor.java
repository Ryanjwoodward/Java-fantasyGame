//Author: Ryan Woodward
//Date: 9-20-2021
//Class: CST-239

//Notes

package store;

public class Armor extends SalableProduct{
	
	private String _type; //light, medium, heavy or clothing
	private int _protectionRating;
	private double _weight;
	
	
	public Armor() {
		super();
		
		this._type = "none";
		this._protectionRating = 0;
		this._weight = 0.0;
	}
	public Armor(String name, String description, int quantity, int itemNumber, double price, String type, int protectRate, double weight) {
		super(name, description, quantity, itemNumber, price);
		
		this._type = type;
		this._protectionRating = protectRate;
		this._weight = weight;
	}
	
	public String get_type() {
		return _type;
	}
	public void set_type(String _type) {
		this._type = _type;
	}
	public int get_protectionRating() {
		return _protectionRating;
	}
	public void set_protectionRating(int _protectionRating) {
		this._protectionRating = _protectionRating;
	}
	public double get_weight() {
		return _weight;
	}
	public void set_weight(double _weight) {
		this._weight = _weight;
	}
	
	

}
