//Author: Ryan Woodward
//Date: 9-15-2021
//Class: CST-239

//Notes

//Can use the storefront initializer below but you would have to create you own items
		//from the manager menu the password for which is 'password'
		
		//StoreFront myStore = new StoreFront();
		
		//the format for creating new inventory items is:
		//String name, String description, int quantity, doubl price
		//item numbers are auto generated to be the number of the index they are loacted at in the ArrayList
		
package storeDriver;

import store.*;

public class Driver {
	
	public static void main(String[]args) {
		
		StoreFront myStore = new StoreFront("Skyforge Suppplies", 100);
		
		myStore.updatedMenu();
	}

}//Driver Class
