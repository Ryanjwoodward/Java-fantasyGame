package store;

/**
 * @author Ryan Woodward
 *
 *         Date: 10-5-2021 Class: CST-239 Description:
 */
public class Weapon extends SalableProduct implements Comparable<SalableProduct> {

	private double _range; // This attribute refers to the distance the weapon can be used
	private double _damage; // This attribute refers to the damage the weapon deals
	// private int _levelRequirement; //This attribute refers to the required level
	// in order for someone to wield it

	/**
	 * Default Constructor initializes attributes with default values
	 */
	public Weapon() {

		super();
		this._range = 0.0;
		this._damage = 0.0;
	}

	/**
	 * @param _name
	 * @param _description
	 * @param _quantity
	 * @param _itemNumber
	 * @param _price
	 */
	public Weapon(String _name, String _description, int _quantity, int _itemNumber, double _price, double range,double damage) {
		super(_name, _description, _quantity, _itemNumber, _price);

		this._range = range;
		this._damage = damage;
	}

	/**
	 * @param wpn Weapon Class' Copy Constructor
	 */
	public Weapon(Weapon wpn) {
		this(wpn.get_name(), wpn.get_description(), wpn.get_quantity(), wpn.get_itemNumber(), wpn.get_price(),
				wpn._range, wpn._damage);
	}

	/**
	 * @return the _range
	 */
	public double get_range() {
		return _range;
	}

	/**
	 * @param _range the _range to set
	 */
	public void set_range(double _range) {
		this._range = _range;
	}

	/**
	 * @return the _damage
	 */
	public double get_damage() {
		return _damage;
	}

	/**
	 * @param _damage the _damage to set
	 */
	public void set_damage(double _damage) {
		this._damage = _damage;
	}

	@Override
	/**
	 * toString- general
	 */
	public String toString() {
		return "[Weapon]..." + super.toString() + "Weapon Range: " + _range + "...Damage: " + _damage;
	}

	/**
	 *CompareTo method to compare two Weapon Objects by Name.
	 */
	public int compareTo(SalableProduct product) {
		return this.get_name().compareToIgnoreCase(product.get_name());
	}

}// Weapon Class
