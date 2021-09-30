//Notes
//Normally I do not like implementing a menu for the user to interact with from within the main()
//method. 
	
package storeDriver;

import store.*;
import java.util.Scanner;

/**
 * @author Ryan Woodward
 *
 * Date: 9-15-2021 Edited 9-27-2021
 * Class: CST-239
 */
public class Driver {
	
	static Scanner scan = new Scanner(System.in);
	static StoreFront myStore = new StoreFront("Skyforge Suppplies", 100);
	static ShoppingCart myCart = new ShoppingCart();
	
	public static void main(String[]args) {
		
		boolean userCase = true;
		int userInt = 0;
		
		
		
		
		do {
			
			System.out.print("\n\n\t       Welcome to " + myStore.get_storeName() + "\n\t------------------------------------------------");
			System.out.print("\n\t 1.) Display Store Inventory\n\t 2.) Display Shopping Cart Contents"
					+ "\n\t 3.) Add an Item to Cart\n\t 4.) Remove an Item from Cart\n\t 5.) Checkout"
					+ "\n\t 6.) Create new Item for Inventory\n\t 7.) EXIT Program");
			
			userInt = scan.nextInt();
			
			switch(userInt) {
			
			case 1://Display Store Inventory
				
				System.out.print("\n\n\t        " + myStore.get_storeName() + " Inventory\n\t-------------------------------------\n");
				myStore.storeToString();
				userCase = true;
				break;
				
			case 2://Display Shopping Cart
				
				System.out.print("\n\n\t      " + myCart.get_name() + " Contents\n\t----------------------------------------\n");
				myCart.toString(myCart);
				userCase = true;
				break;
				
			case 3://Add an item to the shoppingCart
			
					//userInt = myStore.get_storeInventory().findItemIndex(userInt);
					//myCart.add_Item(myStore.get_storeInventory().getItem(userInt));
					
				myCart.addItemToCart(myStore.get_storeInventory(), myCart);
				userCase = true;
				break;
				
			case 4://Remove an Item from the ShoppingCart
				
				myCart.removeItemFromCart(myStore.get_storeInventory(), myCart);
				userCase = true;
				break;
				
			case 5://Checkout and Leave the store
				
				System.out.print("\n\n\t      " + myCart.get_name() + " Contents\n\t----------------------------------------\n");
				myCart.toString(myCart);
				
				System.out.print("\n\t    Thanks For Shopping with us!\n\\n\t Exiting the Program. Auf Wiedersehen!");
				userCase = false;
				
				break;
				
			case 6://Create a new item and add it to the Store Inventory
				
				myStore.get_storeInventory().createThenAddItem();
				break;
				
			case 7://Exit the Program
				
				System.out.print("\n\t Exiting Program. Auf Widersehen!");
				userCase = false;
				break;
				
			default:
				
				System.out.print("\n\t ERROR: Invalid value entered. Restarting...");
				userCase = true;
			}
			
		}while(userCase);
		
		printState();
	}//main -end
	
	public static void printState() {
		
		System.out.print("\n\tHere is the states \n \n INVENTORY:\n-----------------------------------\n");
		
		myStore.get_storeInventory().toString(myStore.get_storeInventory());
		
		System.out.print("\n\tCART\n------------------------------------------------");
		myCart.toString(myCart);
	}
	

}//Driver Class
