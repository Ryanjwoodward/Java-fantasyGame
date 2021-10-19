//NOTES:

package storeDriver;

import store.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


/**
 * @author Ryan Woodward
 *
 * Date: 10-5-2021
 * Class: CST-239
 * Description:
 */
public class StoreDriver {
	
	static Scanner scan = new Scanner(System.in);
	static StoreFront myStore = new StoreFront(100,"Skyforge Suppplies");
	static ShoppingCart myCart = new ShoppingCart();
	
	public static void main(String[] args) {
		
		mainMenu();
	}//main method
	
/**
 * The mainMenu() is the how the user interacts with the storefront, shoppingcart, and inventory classes
 */
public static void mainMenu() {
	/*
	Armor item1 = new Armor("Daedric Armor", "Daedric Plate Armor", 1, 1010, 10.00, 600.0, 50.0);
	Armor item2 = new Armor("Stahlrim Armor", "Stahlrim Plate Armor", 1, 1020, 20.00, 400.0, 30.0);
	Health item3 = new Health("Health Potion", "Minor Potion", 20, 1030, 20.0, 50.0);
	Health item4 = new Health("Chesse Wheel", "an entire wheel of Goat cheese", 14, 1040, 5.0, 4.0);
	Weapon item5 = new Weapon("Orcish Axe", "Orchalcum Axe", 5, 1050, 40.00, 8.0, 35.0);
	Weapon item6 = new Weapon("Long Bow", "Wooden Bow", 10, 1060, 10.0, 200.0, 12.0);

	 myStore.get_storeInventory().add_Item(item1);
	 myStore.get_storeInventory().add_Item(item2);
	 myStore.get_storeInventory().add_Item(item3);
	 myStore.get_storeInventory().add_Item(item4);
	 myStore.get_storeInventory().add_Item(item5);
	 myStore.get_storeInventory().add_Item(item6);
	 */
		
		boolean mainRunner = true;
		int userEntered_ItemNumber = 0, userEntered_Qty = 0;
		SalableProduct prd, prd2;
		int itmNumb;
		
		do {
			
			System.out.print("\n\n\t       Welcome to " + myStore.get_storeName() + "\n\t------------------------------------------------");
			System.out.println("\n\t 1.) Display Store Inventory\n\t 2.) Display Shopping Cart Contents"
					+ "\n\t 3.) Add an Item to Cart\n\t 4.) Update Qty or Remove Item from Cart\n\t 5.) Clear Shopping Cart\n\t 6.) Sort Inventory (Alphabetically)"
					+ "\n\t 7.) Create new Item for Inventory\n\t 8.) EXIT Program");
			
			userEntered_ItemNumber = scan.nextInt();
			
			switch(userEntered_ItemNumber) {
			
			case 1://Display Store Inventory
				
				System.out.println("\t\t" + myStore.get_storeName() +" Store Inventory\n\t-------------------------------------------------------------------------");
				myStore.storeToString();
				
				break;
				
			case 2://Display Shopping Cart
				
				System.out.println("\t\t     ShoppingCart Inventory\n\t-------------------------------------------------------------------------");
				myCart.cartToString(myCart);
				break;
				
			//----------------------------------------------------------------------------------------------------------------------------	
			//----------------------------------------------------------------------------------------------------------------------------
			case 3://Add an item to the shoppingCart
				
				System.out.print("\n\t What is the 'item number': ");
				userEntered_ItemNumber = scan.nextInt();
				
				System.out.print("\n\t Enter desired 'Quantity': ");
				userEntered_Qty = scan.nextInt();
				
				//Gets the item based upon the entered item number and store it in prd
				prd = myStore.getItemFromStoreInventory(userEntered_ItemNumber);
				
				//Error Checking: item number must be between 0 and 9999 and the requested Qty cannot be greater than available
				if(userEntered_ItemNumber < 0 || userEntered_ItemNumber > 9999 || prd.get_quantity() < userEntered_Qty ) {
					
					System.out.println("\n\tERROR: Ivalid values entered... Returning to Main menu...");
					mainRunner = true;
				}else {
					
					
					if(prd instanceof Weapon) {
						
						Weapon wpn = new Weapon();
						myCart.addItem(wpn, userEntered_Qty);
						prd.set_quantity((prd.get_quantity()- userEntered_Qty));
						
					}else if(prd instanceof Armor) {
						
						Armor armr = new Armor((Armor)prd);
						myCart.addItem(armr, userEntered_Qty);
						prd.set_quantity((prd.get_quantity()- userEntered_Qty));
						
					}else if(prd instanceof Health) {
						
						Health hlth = new Health((Health)prd);
						myCart.addItem(hlth, userEntered_Qty);
						prd.set_quantity((prd.get_quantity()- userEntered_Qty));
						
					}else {
						
						System.out.println("\n\tERROR: Unknown Object Type. Returning to Main Menu...");
						mainRunner =true;
					}				
				}
				
				break;
			
			//----------------------------------------------------------------------------------------------------------------------------	
			//----------------------------------------------------------------------------------------------------------------------------		
			case 4://Remove an Item from the ShoppingCart or Update Qty
				
				System.out.print("\n\t Enter the products 'Item Number' you wish to Update/Remove: ");
				userEntered_ItemNumber = scan.nextInt();
				
				System.out.print("\n\t Do you wish to 1.) Remove or 2.) Update: ");
				userEntered_Qty = scan.nextInt();
				
				if(userEntered_ItemNumber < 0 || userEntered_ItemNumber > 9999 || userEntered_Qty < 1 || userEntered_Qty > 2) {
				
					System.out.print("\n\t ERROR: Invalid Entry. Returning to Main Menu...");
					mainRunner = true;
				}else if(userEntered_Qty == 1) {
					
					myCart.remove_Item(userEntered_ItemNumber);
					
				}else if(userEntered_Qty == 2) {//************************************************!!!!!!!!!!!!!!!!!!!!!!!!
					//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
					//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
					
					System.out.print("\n\t Enter the new Quantity of the item: ");
					userEntered_Qty = scan.nextInt();
					
					System.out.print("NOT ADDED YET, ONLY REMOVE WORKS");
					//if (enteredQty >= get Qty remove()
				}
				
				break;
				
			//----------------------------------------------------------------------------------------------------------------------------	
			//----------------------------------------------------------------------------------------------------------------------------		
			case 5://Clear the cart 
				
				System.out.print("\n\t Clearing your Shopping Cart...");
				
				//This loop returns all the quantities to their original state within the Inventory
				for(int idx = 0; idx < myCart.get_trueSize(); idx++) {
					
					prd = myCart.getItemWithIndex(idx);
					itmNumb = prd.get_itemNumber();
					
					prd2 = myStore.getItemFromStoreInventory(itmNumb);
					itmNumb = prd2.get_quantity();
					
					prd2.set_quantity((itmNumb + prd.get_quantity()));
				}
				
				myCart.clearCart();
				
				break;
			
			//----------------------------------------------------------------------------------------------------------------------------	
			//----------------------------------------------------------------------------------------------------------------------------	
			case 6:// Sort the Inventory by alphabet
				
				//Calls the sort method below t sort all the items by Name.
				//myStore.get_storeInventory().sort(myStore.get_storeInventory().get_inventory());

				break;
				
			//----------------------------------------------------------------------------------------------------------------------------	
			//----------------------------------------------------------------------------------------------------------------------------	
			case 7://Create a new item and add it to the Store Inventory
				
				System.out.print("\n\t  Select the item type:\n\t----------------------------\n\t 1.) Weapon\n\t 2.) Armor\n\t 3.) Health");
				itmNumb = scan.nextInt();
				
				String newName, newDescr;
				int newQuant, newItmNum;
				double newPrice, newRange, newDmg, newHealthCap, newPrtctRate, newWeight;
				
				if(itmNumb < 1 || itmNumb > 3) {
					
					System.out.print("\n\t ERROR: Invalid Value Entered. Returning to Main Menu...");
					
				}else {
					
					System.out.print("\n\t Enter the 'Name': ");
					newName = scan.next();
					System.out.print("\n\t Enter brief Description: ");
					newDescr = scan.nextLine();
					System.out.print("\n\t Enter the 'quantity': ");
					newQuant = scan.nextInt();
					System.out.print("\n\t Enter the 'Item Number': ");
					newItmNum = scan.nextInt();
					System.out.print("\n\t Enter the 'Price': ");
					newPrice = scan.nextDouble();
					
					
					switch(itmNumb) {
						
					case 1://Weapon
						
						System.out.print("\n\t Enter the Weapons' 'Range': ");
						newRange = scan.nextDouble();
						System.out.print("\n\t Enter the Weapons' Damage: ");
						newDmg = scan.nextDouble();
		
						Weapon woopin = new Weapon(newName, newDescr, newQuant, newItmNum, newPrice, newRange, newDmg);
						myStore.addItemToStore(woopin);
						
						break;
						
					case 2://Armor
						
						System.out.print("\n\t Enter the 'Protection Rating': ");
						newPrtctRate = scan.nextDouble();
						System.out.print("\n\t Enter the 'Weight': ");
						newWeight = scan.nextDouble();
						
						Armor armour = new Armor(newName, newDescr, newQuant, newItmNum, newPrice, newPrtctRate, newWeight);
						myStore.addItemToStore(armour);
						
						break;
						
					case 3://Health
						
						System.out.print("\n\t Enter the 'Health Capacity': ");
						newHealthCap = scan.nextDouble();
						
						Health help = new Health(newName, newDescr, newQuant, newItmNum, newPrice, newHealthCap);
						myStore.addItemToStore(help);
						break;
						
					default:
						
						System.out.print("\n\t ERROR: Unknown. Returning to main menu...");
						mainRunner = true;
					}
				}
				
				break;
			
			//----------------------------------------------------------------------------------------------------------------------------	
			//----------------------------------------------------------------------------------------------------------------------------	
			case 8://Exit the Program
				
				System.out.print("\n\t Exiting Program. Auf Widersehen!");
				mainRunner = false;
				break;
				
			default:
				
				System.out.print("\n\t ERROR: Invalid value entered. Restarting...");
				mainRunner = true;
			}
			
		}while(mainRunner);
	}

		
	
}//StoreDriver Class
