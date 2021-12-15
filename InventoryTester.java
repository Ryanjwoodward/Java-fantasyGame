package StoreInvtCartTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import store.Inventory;
import store.Weapon;

public class InventoryTester {

	/**
	 * Tests Inventory Default Constructor
	 */
	@Test
	public void testInventory() {
		Inventory invtTest = new Inventory();
	}

	/**
	 * Tests Inventory overloaded constructor
	 */
	@Test
	public void testInventoryOverConstructor() {
		Inventory invTest = new Inventory(10);
	}
	
	/**
	 * Tests get_trueSize() from Inventory
	 */
	@Test
	public void testGetTrueSize() {
		Inventory invtTest = new Inventory();
		invtTest.get_trueSize();
	}
	
	/**
	 * Tests getItemFromItemNumber() from Inventory
	 */
	@Test
	public void testGetItemIdx() {
		//!!!!!!
	}
	
	/**
	 * Tests getSizeOfInventory() in Inventory Class
	 */
	@Test
	public void testGetSize() {
		Inventory invtTest = new Inventory();
		invtTest.get_trueSize();
	}
	
	/**
	 * Tests add_item() in Inventory Class
	 */
	@Test
	public void testAddItem() {
		Inventory invtTest = new Inventory();
		Weapon wepTest = new Weapon("Test Weapon", "test Wep descr", 9, 9999, 99.99, 999.9, 999.9);
		invtTest.add_Item(wepTest);
	}
	
	/**
	 * Tests remove_Item() from Inventory Class
	 */
	@Test
	public void testRemoveitem() {
		Inventory invtTest = new Inventory();
		Weapon wepTest = new Weapon("Test Weapon", "test Wep descr", 9, 9999, 99.99, 999.9, 999.9);
		invtTest.add_Item(wepTest);
		invtTest.remove_Item(9999);
	}
	
	/**
	 * Tests clearInventory() from Inventory Class
	 */
	@Test
	public void testClear() {
		Inventory invtTest = new Inventory();
		Weapon wepTest = new Weapon("Test Weapon", "test Wep descr", 9, 9999, 99.99, 999.9, 999.9);
		invtTest.clearInventory();
	}
	
	/**
	 * Tests getItemWithIndex() from Inventory Class
	 */
	@Test
	public void testGetItem() {
		Inventory invtTest = new Inventory();
		Weapon wepTest = new Weapon("Test Weapon", "test Wep descr", 9, 9999, 99.99, 999.9, 999.9);
		invtTest.add_Item(wepTest);
		invtTest.getItemWithIndex(0);
	}
	
	/**
	 * Test getItemWithItemNumber() from Inventory Class
	 */
	@Test
	public void testGetItemWNum() {
		Inventory invtTest = new Inventory();
		Weapon wepTest = new Weapon("Test Weapon", "test Wep descr", 9, 9999, 99.99, 999.9, 999.9);
		invtTest.add_Item(wepTest);
		invtTest.getItemWithItemNumber(9999);
	}
	
	/**
	 * Tests toString() fron Inventory Class
	 */
	@Test
	public void testToString() {
		Inventory invtTest = new Inventory();
		Weapon wepTest = new Weapon("Test Weapon", "test Wep descr", 9, 9999, 99.99, 999.9, 999.9);
		invtTest.add_Item(wepTest);
		invtTest.toString(invtTest);
	}
	
	/**
	 * Test orderNameSort() from Inventory Class
	 */
	@Test
	public void testOrderNameSort() {
		Inventory invtTest = new Inventory();
		Inventory.orderNameSort(invtTest);
	}
	
	/**
	 * Test reverseNameSort() from Inventory Class
	 */
	@Test
	public void testReverseName() {
		Inventory invtTest = new Inventory();
		Inventory.reverseNameSort(invtTest);
	}
	
	/**
	 * Test ordeerPriceSort() from Inventory Class
	 */
	@Test
	public void testOrderPrice() {
		Inventory invtTest = new Inventory();
		invtTest.orderPriceSort(invtTest);
	}
	
	/**
	 * Test reversePriceSort() from Inventroy Class
	 */
	@Test
	public void testReversePrice() {
		Inventory invtTest = new Inventory();
		invtTest.reversePriceSort(invtTest);
	}
	
	public void main(String[]args) {
		Inventory invtTest;
		 testInventory();
		 testInventoryOverConstructor();
		 testGetTrueSize();
		 testGetItemIdx();
		 testGetSize(); 
		 testAddItem();
		 testRemoveitem();
		 testClear();
		 testGetItem();
		 testGetItemWNum();
		 testToString();
		 testOrderNameSort();
		 testReverseName();
		 testOrderPrice();
		 testReversePrice(); 
		 System.out.println("InventoryTester.class completed execution....");
	}
}//InventoryTester
