package store;

/**
 * @author Ryan Woodward
 *
 *         Date: 10-5-2021 Class: CST-239 Description:
 */
public class Health extends SalableProduct implements Comparable<SalableProduct> {

	private double _healthCapacity;

	/**
	 * Default constructor initializes attributes with default values
	 */
	public Health() {

		super();
		this._healthCapacity = 0.0;
	}

	/**
	 * @param _name
	 * @param _description
	 * @param _quantity
	 * @param _itemNumber
	 * @param _price
	 */
	public Health(String _name, String _description, int _quantity, int _itemNumber, double _price, double healthCap) {
		super(_name, _description, _quantity, _itemNumber, _price);

		this._healthCapacity = healthCap;
	}

	/**
	 * @param hlth Health class' Copy Constructor;
	 */
	public Health(Health hlth) {
		this(hlth.get_name(), hlth.get_description(), hlth.get_quantity(), hlth.get_itemNumber(), hlth.get_price(),
				hlth._healthCapacity);
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

	@Override
	/**
	 * General toString()
	 */
	public String toString() {
		return "[Health]..." + super.toString() + "Health Capacity: " + _healthCapacity;
	}

	/**
	 *CompareTo method to compare two Healh Objects by Name.
	 */
	public int compareTo(SalableProduct product) {
		return this.get_name().compareToIgnoreCase(product.get_name());
	}

}// Health Class
