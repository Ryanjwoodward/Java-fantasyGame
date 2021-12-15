package salableProductsTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import store.Weapon;

public class WeaponTest {

	Weapon wepTest;
	
	/**
	 * Tests the default Constructor in the Weapon Class
	 */
	@Test
	public void testWeaponConstructor() {
		wepTest = new Weapon();
	}
	
	/**
	 * Test the overloaded constructor in the Weapon Class
	 */
	@Test
	public void testWeaponOverldConstructor() {
		wepTest = new Weapon("Test Weapon", "test Wep descr", 9, 9998, 99.99, 999.9, 999.9);
	}
	
	/**
	 * Test the copy Constructor in the Weapon Class
	 */
	@Test
	public void testWeaponCopyConstructor() {
		wepTest = new Weapon();
		wepTest = new Weapon(wepTest);
	}
	
	/**
	 * Test the get_range() in weapon class
	 */
	@Test
	public void testGetRange() {
		wepTest = new Weapon();
		wepTest.get_range();
	}
	
	/**
	 * Teest the setRange() in Weapon class
	 */
	@Test
	public void testSetRange() {
		wepTest = new Weapon();
		wepTest.set_range(50.01);
	}
	
	/**
	 * Test the get_damage() in Weapon Class
	 */
	@Test
	public void testGetDamage() {
		wepTest = new Weapon();
		wepTest.get_damage();
	}
	
	/**
	 * Test the set_damage() in Weapon Class
	 */
	@Test
	public void testSetDamage() {
		wepTest = new Weapon();
		wepTest.set_damage(50.01);
	}
	
	/**
	 * Test the toString() in Weapon Class
	 */
	@Test
	public void testWeaponToString() {
		wepTest = new Weapon();
		wepTest.toString();
	}
	
	/**
	 * main to run the test class
	 * @param args
	 */
	public void main(String[]args) {
		Weapon wepTest;
		testWeaponConstructor();
		testWeaponOverldConstructor();
		testSetRange();
		testGetRange();
		testSetDamage();
		testGetDamage();
		testWeaponToString();
		testWeaponCopyConstructor();
		System.out.println("WeaponTest.class completed execution....");
	}
	
	
}//WeaponTest Class
