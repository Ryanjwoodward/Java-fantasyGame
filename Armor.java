package store;

/**
 * @author Ryan Woodward
 *
 *         Date: 10-5-2021 Class: CST-239 Description:
 */
public class Armor extends SalableProduct implements Comparable<SalableProduct>{

	private double _weight; // This attribute refers to the type of armor, not just the wiehgt. (Light, medium, heavy)
	private double _protectionRating; // This attribute refers to the amount of damage deducted from an attack.

	/**
	 * Default Constructor initializes attributes with default values
	 */
	public Armor() {
		super();
		this._protectionRating = 0;
		this._weight = 0.0;
	}

	/**
	 * @param _name
	 * @param _description
	 * @param _quantity
	 * @param _itemNumber
	 * @param _price
	 */
	public Armor(String _name, String _description, int _quantity, int _itemNumber, double _price, double protectRate,
			double weight) {
		super(_name, _description, _quantity, _itemNumber, _price);

		this._protectionRating = protectRate;
		this._weight = weight;
	}

	/**
	 * @param armr This is a copy constructor.
	 */
	public Armor(Armor armr) {

		this(armr.get_name(), armr.get_description(), armr.get_quantity(), armr.get_itemNumber(), armr.get_price(),
				armr._protectionRating, armr._weight);
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
	 * @return the _protectionRating
	 */
	public double get_protectionRating() {
		return _protectionRating;
	}

	/**
	 * @param _protectionRating the _protectionRating to set
	 */
	public void set_protectionRating(double _protectionRating) {
		this._protectionRating = _protectionRating;
	}

	@Override
	/**
	 * This is the general toString() Will call the super.invtToString if calling
	 * object is Inventory.
	 */
	public String toString() {
		return "[Armor]..." + super.toString() + "weight: " + _weight + "...Protection Rating: " + _protectionRating;
	}
	
	/**
	 *CompareTo method to compare two Armor Objects by Name.
	 */
	public int compareTo(SalableProduct product) {
		return this.get_name().compareToIgnoreCase(product.get_name());
	}
		 
}// Armor Class
