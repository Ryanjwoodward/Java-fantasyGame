package salableProductsTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import store.SalableProduct;
import store.Weapon;

public class SalableProductTest {

	SalableProduct spTest = new Weapon();//Can adjust to any SProcut Derivative class
	
	/**
	 * Tests the get_name() in SalableProduct Class
	 */
	@Test
	public void testSPGetName() {
		SalableProduct spTest = new Weapon();
		spTest.get_name();
	}

	/**
	 * Test the set_name() in SalableProduct Class
	 */
	@Test
	public void testSPSetName() {
		SalableProduct spTest = new Weapon();
		spTest.set_name("SP_Test Name");
	}
	
	/**
	 * Tests the get_description() in SalableProduct Class
	 */
	@Test
	public void testGetDescr() {
		SalableProduct spTest = new Weapon();
		spTest.get_description();
	}
	
	/**
	 * Test the set_decription() in SalableProduct Class
	 */
	@Test
	public void testSetDescr() {
		SalableProduct spTest = new Weapon();
		spTest.set_description("SP_Test Descr");
	}
	
	/**
	 * Tests get_quantity() in SalableProduct Class
	 */
	@Test
	public void testGetQty() {
		SalableProduct spTest = new Weapon();
		spTest.get_quantity();
	}
	
	/**
	 * Tests the set_quantity() in SalableProduct Class
	 */
	@Test
	public void testSetQty() {
		SalableProduct spTest = new Weapon();
		spTest.set_quantity(2007);
	}
	
	/**
	 * Test the get_price() in SalableProduct Class
	 */
	@Test
	public void testGetPrice() {
		SalableProduct spTest = new Weapon();
		spTest.get_price();
	}
	
	/**
	 * Tests the set_price() in SalableProduct class
	 */
	@Test
	public void testSetPrice() {
		SalableProduct spTest = new Weapon();
		spTest.set_price(50.01);
	}
	
	//I've omitted the toString test, because the SalableProduct toString is called from 
	//it's derivative classes
	
	
	//I've omitted the priceCompareTo test as well, for sake of my convenience
	
	/**
	 * main to run the test class
	 * @param args
	 */
	public void main(String[]args) {
		SalableProduct spTest;
		testSPSetName();
		testSPGetName();
		testSetDescr();
		testGetDescr();
		testSetQty();
		testGetQty();
		testGetPrice();
		testSetPrice();
		System.out.println("SalableProduct.class completed execution....");
	}
	
	
}//SalableProductTests Class
