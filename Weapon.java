//Author: Ryan Woodward
//Date: 9-20-2021
//Class: CST-239

//Notes
//1.) add an ammo capacity attribute for weapons that require resource input.

package store;

public class Weapon extends SalableProduct{
	
		private String _type;// long, medium, short range, or magic
		private double _range;// magic has unlimited, long is 0 to 1000, medium is 0 to 500, close is 0 to 10.
		private double _damage;
		private int _levelRequirement; //determined by damage
		
		
		
		
		public Weapon() {
			super();
			this._type = "blank";
			this._range = 0.0;
			this._damage = 0.0;
			this._levelRequirement = 0;
		}
		
		public Weapon(String name, String description, int quantity, int itemNumber, double price, String type, double range, double damage, int levelReq) {
			super(name, description, quantity, itemNumber, price);
			
			this._type = type;
			this._range = range;
			this._damage = damage;
			this._levelRequirement = levelReq;
		}
		//type is something like sword, gun, staff, etc.
		public String get_type() {
			return _type;
		}
		public void set_type(String _type) {
			this._type = _type;
		}
		public double get_range() {
			return _range;
		}
		public void set_range(double _range) {
			this._range = _range;
		}
		public double get_damage() {
			return _damage;
		}
		public void set_damage(double _damage) {
			this._damage = _damage;
		}
		public int get_levelRequirement() {
			return _levelRequirement;
		}
		public void set_levelRequirement(int _levelRequirement) {
			this._levelRequirement = _levelRequirement;
		}
		
		
		
		
}//Weapon Class
