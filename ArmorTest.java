package salableProductsTesting;

import store.Armor;
import static org.junit.Assert.*;

import org.junit.Test;

public class ArmorTest {

	Armor armTest;
	
	/**
	 * Tests the default Constructor in the Armor Class
	 */
	@Test
	public void testArmorConstructor() {
		Armor armTest = new Armor();
	}

	/**
	 * Test the overloaded constructor in the Armor class
	 */
	@Test
	public void testArmorOvrldConstructor() {
		Armor armTest = new Armor("Armor Test Piece", "ATP_descr", 999, 9999, 999.99, 9999.99, 99.9);
	}
	
	/**
	 * Tests the copyConstructor in Armor Class
	 */
	@Test
	public void testArmorCopyConstructor() {
		Armor armTest = new Armor();
		armTest = new Armor(armTest);
	}
	
	/**
	 * Test the get_weight() method in Armor Class
	 */
	public void testGetWeight() {
		Armor armTest = new Armor();
		armTest.get_weight();
		System.out.println("Here: " + armTest.get_weight());
	}
	
	/**
	 * Tests the set_weight method in the Armor class
	 */
	@Test
	public  void testSetWeight() {
		Armor armTest = new Armor();
		armTest.set_weight(50.01);
	}
	
	/**
	 * Test get_protectionRating() method in the armor class
	 */
	@Test
	public  void testGetProtRate() {
		Armor armTest = new Armor();
		armTest.get_protectionRating();
	}
	
	/**
	 * Test the set_protectionRating() in the armor class
	 */
	@Test
	public void testSetProtRate() {
		Armor armTest = new Armor();
		armTest.set_protectionRating(51.01);
	}
	
	/**
	 * Tests the toString() in Armor class
	 */
	@Test
	public  void testArmorToString() {
		Armor armTest = new Armor();
		armTest.toString();
	}
	
	public void main(String[]args) {
		Armor armTest;
		testArmorConstructor();
		testArmorOvrldConstructor(); 
		testSetWeight(); 
		testGetWeight();
		testSetProtRate();
		testGetProtRate();
		testArmorToString();
		testArmorCopyConstructor();
		System.out.println("ArmorTest.class completed execution....");
	}
	
}//ArmorTest
