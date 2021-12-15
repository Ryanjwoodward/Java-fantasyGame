package StoreInvtCartTesting;

import static org.junit.Assert.*;
import org.junit.Test;

import store.*;

public class StoreFrontTester {

	/**
	 * Tests default Constructor of StoreFront Class
	 */
	@Test
	public void testStoreFront() {
		StoreFront storeTest = new StoreFront();
	}
	
	/**
	 * Tests overloaded constructor in StoreFront Class
	 */
	@Test
	public void testOverldStoreFront()  {
		StoreFront storeTest = new StoreFront(100, "Test Store");
	}
	
	/**
	 * Tests get_storeName() from StoreFront Class
	 */
	@Test
	public void testGetStoreName()  {
		StoreFront storeTest = new StoreFront();
		storeTest.get_storeName();
	}
	
	/**
	 * Tests set_storeName() from StoreFront Class
	 */
	@Test
	public void testSetStoreName()  {
		StoreFront storeTest = new StoreFront();
		storeTest.set_storeName("Test Store");
	}
	
	/**
	 * Tests storeToString() in StoreFront Class
	 */
	@Test
	public void testStoreToString() {
		StoreFront storeTest = new StoreFront();
		storeTest.storeToString();
	}
	
	/**
	 * Tests the addItemToStore() in StoreFront Class
	 */
	@Test
	public void testAddItem() {
		StoreFront storeTest = new StoreFront();
		Weapon wepTest = new Weapon("Test Weapon", "test Wep descr", 9, 9999, 99.99, 999.9, 999.9);
		storeTest.addItemToStore(wepTest);
	}
	
	/**
	 * Tests getItemFromStoreInventory() from StoreFront
	 */
	@Test
	public void testGetItem() {
		StoreFront storeTest = new StoreFront();
		Weapon wepTest = new Weapon("Test Weapon", "test Wep descr", 9, 9999, 99.99, 999.9, 999.9);
		storeTest.addItemToStore(wepTest);
		storeTest.getItemFromStoreInventory(9999);
	}
	
	/**
	 * Tests callNameSort() in StoreFront Class
	 */
	@Test
	public void testCallNameSort() {
		StoreFront storeTest = new StoreFront();
		storeTest.callNameSort();
	}
	
	/**
	 * Tests callNameReverseSort() in StoreFront Class
	 */
	@Test
	public void testCallNameReverseSort() {
		StoreFront storeTest = new StoreFront();
		storeTest.callNameReverseSort();
	}
	
	/**
	 * Tests callPriceSort() in StoreFront Class
	 */
	@Test
	public void testCallPriceSort() {
		StoreFront storeTest = new StoreFront();
		storeTest.callPriceSort();
	}
	
	/**
	 * Tests callPriceReverseSort() in StoreFront class
	 */
	@Test
	public void testCallPriceReverseSort() {
		StoreFront storeTest = new StoreFront();
		storeTest.callPriceReverseSort();
	}
	
	public void main(String[]args) {
		StoreFront storeTest;
		testStoreFront();
		testOverldStoreFront();
		testGetStoreName();
		testSetStoreName();
		testStoreToString();
		testAddItem();
		testGetItem(); 
		testCallNameSort();
		testCallNameReverseSort();
		testCallPriceSort();
		testCallPriceReverseSort(); 
		System.out.println("StoreFrontTester.class completed execution....");
	}
	
}//StoreFrontTester Class
