package salableProductsTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import store.Health;

public class HealthTest {

	Health hthTest;
	
	/**
	 * Test the defauly Constructor in the Health Class
	 */
	@Test
	public void testHealthConstructor() {
		hthTest = new Health();
	}
	
	/**
	 * Test the overloaded Constructor in Health Class
	 */
	@Test
	public void testHealthOverldConstructor() {
		hthTest = new Health();
	}

	/**
	 * Test the copy constructor in the Health class
	 */
	@Test
	public void testHealthCopyConstructor() {
		hthTest = new Health();
		hthTest = new Health(hthTest);
	}

	/**
	 * Test the get_healthCapacity() in Health Class
	 */
	@Test
	public void testGetHealthCap() {
		hthTest = new Health();
		hthTest.get_healthCapacity();
	}
	
	/**
	 * Test the set_healthCapacity() in Health Class
	 */
	@Test
	public void testSetHealthCap() {
		hthTest = new Health();
		hthTest.set_healthCapacity(50.01);
	}
	
	/**
	 * Test the toString() in the Health Class
	 */
	@Test
	public void testHealthToString() {
		hthTest = new Health();
		hthTest.toString();
	}
	
	/**
	 * main to run the test class
	 * @param args
	 */
	public  void main(String[]args) {
		Health hthTest;
		testHealthConstructor();
		testHealthOverldConstructor();
		testSetHealthCap();
		testGetHealthCap();
		testHealthToString();
		testHealthCopyConstructor();
		System.out.println("HealthTest.class completed execution....");
	}


}//TestHealth Class

