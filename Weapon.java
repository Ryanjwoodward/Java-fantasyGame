//Notes
//1.) adjust range to be the mid,short,long and type to be the variety such as gun, sword, etc.
package store;

/**
 * @author Ryan Woodward
 *
 * Date: 9/20/2021 Edited 9-27-2021
 * Class: CST-239
 * Description: Weapon class is a child class to the SalableProduct. This adds weapon qualities to the product. 
 */


public class Weapon extends SalableProduct implements Comparable{
	
		private String _type;// long, medium, short range, or magic
		private double _range;// magic has unlimited, long is 0 to 1000, medium is 0 to 500, close is 0 to 10.
		private double _damage;
		private int _levelRequirement; //determined by damage
		
		
		
		/**
		 * Default constructor initializes attributes with super() and default values.
		 */
		public Weapon() {
			super();
			this._type = "blank";
			this._range = 0.0;
			this._damage = 0.0;
			this._levelRequirement = 0;
		}
		
		
		/**
		 * 
		 * @param name
		 * @param description
		 * @param quantity
		 * @param itemNumber
		 * @param price
		 * @param type
		 * @param range
		 * @param damage
		 * @param levelReq
		 * 
		 * Overloaded constructor initializes new Weapon object with passed parameters to super() and own
		 * attributes type, range, damage, and levelRequirement
		 */
		public Weapon(String name, String description, int quantity, int itemNumber, double price, String type, double range, double damage, int levelReq) {
			super(name, description, quantity, itemNumber, price);
			
			this._type = type;
			this._range = range;
			this._damage = damage;
			this._levelRequirement = levelReq;
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


		/**
		 * @return the _levelRequirement
		 */
		public int get_levelRequirement() {
			return _levelRequirement;
		}


		/**
		 * @param _levelRequirement the _levelRequirement to set
		 */
		public void set_levelRequirement(int _levelRequirement) {
			this._levelRequirement = _levelRequirement;
		}
		
		

		/**
		 * toString() method calls the super.toString() to print it's inherited attributes
		 */
		@Override
		public String toString() {
			return super.toString() + "Item Type: Weapon (" + _type + "). Range: " + _range + " Damage: " + _damage + ". Level Requirement: " + _levelRequirement;
		}


		/**
		 * The compareTo Method added through implementing the Comparable interface
		 */
		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		
		
}//Weapon Class
