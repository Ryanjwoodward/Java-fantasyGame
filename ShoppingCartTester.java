package StoreInvtCartTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import store.ShoppingCart;
import store.Weapon;

public class ShoppingCartTester {

	/**
	 * Test ShoppingCart()
	 */
	@Test
	public void testShoppingCart() {
		ShoppingCart cartTest = new ShoppingCart();
	}
	
	/**
	 * Test ShoppingCart(args)
	 */
	@Test
	public void testShoppingCartOvr() {
		ShoppingCart cartTest = new ShoppingCart(10);
	}
	
	/**
	 * Test get_trueSize()
	 */
	@Test
	public void testGetTrueSize() {
		ShoppingCart cartTest = new ShoppingCart(10);
		cartTest.get_trueSize();
	}
	
	/**
	 * Test add_Item()
	 */
	@Test 
	public void testAddItem() {
		ShoppingCart cartTest = new ShoppingCart(10);
		Weapon wepTest = new Weapon("Test Weapon", "test Wep descr", 9, 9999, 99.99, 999.9, 999.9);
		cartTest.addItem(wepTest, 5);
	}
	
	/**
	 * Test removeItem()
	 */
	@Test
	public void testRemove() {
		ShoppingCart cartTest = new ShoppingCart(10);
		Weapon wepTest = new Weapon("Test Weapon", "test Wep descr", 9, 9999, 99.99, 999.9, 999.9);
		cartTest.addItem(wepTest, 5);
		cartTest.remove_Item(9999);
	}
	
	/**
	 * Test getItemFromItemNumber()
	 */
	@Test
	public void testGetItem() {
		ShoppingCart cartTest = new ShoppingCart(10);
		Weapon wepTest = new Weapon("Test Weapon", "test Wep descr", 9, 9999, 99.99, 999.9, 999.9);
		cartTest.addItem(wepTest, 5);
		cartTest.getItemIdxFromItemNumber(9999);
	}
	
	/**
	 * Test getItemWihIndex()
	 */
	@Test
	public void testGetItmIdx() {
		ShoppingCart cartTest = new ShoppingCart(10);
		Weapon wepTest = new Weapon("Test Weapon", "test Wep descr", 9, 9999, 99.99, 999.9, 999.9);
		cartTest.addItem(wepTest, 5);
		cartTest.getItemWithIndex(0);
	}
	
	/**
	 * Test clearCarT()
	 */
	@Test
	public void testClearCart() {
		ShoppingCart cartTest = new ShoppingCart(10);
		Weapon wepTest = new Weapon("Test Weapon", "test Wep descr", 9, 9999, 99.99, 999.9, 999.9);
		cartTest.addItem(wepTest, 5);
		cartTest.clearCart();
	}
	
	/**
	 * Test getItemWNum
	 */
	@Test
	public void testGetItemWNum() {
		ShoppingCart cartTest = new ShoppingCart(10);
		Weapon wepTest = new Weapon("Test Weapon", "test Wep descr", 9, 9999, 99.99, 999.9, 999.9);
		cartTest.addItem(wepTest, 5);
		cartTest.getItemWithItemNumber(9999);
	}
	
	/**
	 * Test cartToString()
	 */
	@Test
	public void testToString() {
		ShoppingCart cartTest = new ShoppingCart(10);
		cartTest.cartToString(cartTest);
	}
	
	/**
	 * Test checkIfItemInCart()
	 */
	@Test
	public void testCheckInCart() {
		ShoppingCart cartTest = new ShoppingCart(10);
		Weapon wepTest = new Weapon("Test Weapon", "test Wep descr", 9, 9999, 99.99, 999.9, 999.9);
		cartTest.addItem(wepTest, 5);
		cartTest.checkIfItemInCart(9999);
	}
	
	public void main(String[]args) {
		ShoppingCart cartTest;
		testShoppingCart();
		testShoppingCartOvr() ;
		testGetTrueSize();
		testAddItem();
		testRemove();
		testGetItem();
		testGetItmIdx();
		testClearCart();
		testGetItemWNum();
		testToString();
		testCheckInCart();
		System.out.println("ShoppingCartTester.class completed execution....");
	}//main
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//ShoppingCartTester Class
