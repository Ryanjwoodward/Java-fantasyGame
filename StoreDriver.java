//NOTES:

//1.) in the remove item, code needs to be added so that once removed the item quantity is updated in the inventory.

package storeDriver;

import store.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;


 /* @author Ryan Woodward
 *
 * Date: 10-5-2021
 * Class: CST-239
 * Description:
 */
public class StoreDriver {
	
	static Scanner scan = new Scanner(System.in);
	static StoreFront myStore = new StoreFront(100,"Skyforge Supplies");
	static ShoppingCart myCart = new ShoppingCart();
	
	public static void main(String[] args) throws FileNotFoundException {
		
		
		
		Armor item1 = new Armor("Daedric Armor", "Heavy Daedric Plate Armor", 1, 1010, 10.00, 600.0, 50.0);
		Armor item2 = new Armor("Stahlrim Armor", "Heavy Stahlrim Plate Armor", 1, 1020, 20.00, 400.0, 30.0);
		Health item3 = new Health("Health Potion", "Minor Potion", 20, 2030, 20.0, 50.0);
		Health item4 = new Health("Cheese Wheel", "an entire wheel of Goat cheese", 14, 2040, 5.0, 4.0);
		Weapon item5 = new Weapon("Orcish Axe", "Orchalcum Axe", 5, 3050, 40.00, 8.0, 35.0);
		Weapon item6 = new Weapon("Long Bow", "Wooden Bow", 10, 3060, 10.0, 200.0, 12.0);
		
		/*
		 * myStore.addItemToStore(item1); myStore.addItemToStore(item2);
		 * myStore.addItemToStore(item3); myStore.addItemToStore(item4);
		 * myStore.addItemToStore(item5); myStore.addItemToStore(item6);
		 */
		
		//----------------------------------------------------------------------------------
		//This code block creates a list adds the above items then writes them to the JSON file
		ArrayList<SalableProduct> list = new ArrayList<SalableProduct>(6);
		list.add(item1);
		list.add(item2);
		list.add(item3);
		list.add(item4);
		list.add(item5);
		list.add(item6);

		
		ObjectMapper objMapr = new ObjectMapper();

		try {
			objMapr.writeValue(new FileOutputStream("storeInvt.json"), list);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.print("ERROR");
		}

		//--------------------------------------------------------------------------
		//This portion is for reading the JSON file that was created above
		JSONParser jsonParser = new JSONParser();

		try (FileReader reader = new FileReader("storeInvt.json")) {

			Object obj = jsonParser.parse(reader);

			JSONArray inventory = (JSONArray) obj;

			inventory.forEach(item -> parseProduct((JSONObject) item));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mainMenu();
	}//main method
	
	//---------------------JSON METHODS-----------------------------------
	
private static void parseProduct(JSONObject prd) {
		
		String name = (String)prd.get("_name");
		System.out.println("name: " + name);
		
		String descr = (String)prd.get("_description");
		System.out.println("descr: " + descr);
		
		Long qty = (Long)prd.get("_quantity");
		System.out.println("qty: " + qty);
		int quantity = Math.toIntExact(qty);
		
		Long itemNum = (Long)prd.get("_itemNumber");
		System.out.println("itemNum" + itemNum);
		int itmNumber = Math.toIntExact(itemNum);
		
		Double price = (Double)prd.get("_price");
		System.out.println("price: " + price);
		
		if(itemNum >= 1000 && itemNum < 2000) {//Armor
			
			Double protRate = (Double)prd.get("_protectionRating");
			System.out.println("protect: " + protRate);
			
			Double weight = (Double)prd.get("_weight");
			System.out.println("weight: " + weight);
			Armor armr = new Armor(name, descr,quantity,itmNumber,price,protRate,weight);
			myStore.addItemToStore(armr);
		}else if(itemNum >= 2000 && itemNum < 3000){//Health
			
			Double healthCap = (Double)prd.get("_healthCapacity");
			System.out.println("hCap: " + healthCap);
			Health hlth = new Health(name,descr,quantity,itmNumber,price,healthCap);
			myStore.addItemToStore(hlth);
		}else if(itemNum >= 3000 && itemNum < 4000){//Weapon
			
			Double range = (Double)prd.get("_range");
			System.out.println("range: " + range);
			
			Double dmg = (Double)prd.get("_damage");
			System.out.println("damage: " + dmg);
			Weapon weap = new Weapon(name,descr,quantity,itmNumber,price,range,dmg);
			myStore.addItemToStore(weap);
		}
		
		
	}//parseProduct

	//Add item by using these qualities above into a new object.
	
	
	
	
	

	
	//----------------------END JSON METHODS--------------------------------
	
/**
 * The mainMenu() is the how the user interacts with the storefront, shoppingcart, and inventory classes
 */
public static void mainMenu() {
		
		boolean mainRunner = true; //This variable is used for the condition of the do-While for mainMenu()
		
		int userEntered_ItemNumber = 0, userEntered_Qty = 0, userValue = 0; // These variables are used to store any user input for Item Number of Quantity
		
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
				
			// ----------------------------------------------------------------------------------------------------------------------------
			// ----------------------------------------------------------------------------------------------------------------------------
			case 3:// Add an item to the shoppingCart

				System.out.print("\n\t What is the 'item number': ");
				userEntered_ItemNumber = scan.nextInt();

				System.out.print("\n\t Enter desired 'Quantity': ");
				userEntered_Qty = scan.nextInt();

				// Gets the item based upon the entered item number and store it in prd
				prd = myStore.getItemFromStoreInventory(userEntered_ItemNumber);

				// Error Checking: item number must be between 0 and 9999 and the requested Qty
				// cannot be greater than available			
				if (userEntered_ItemNumber < 0 || userEntered_ItemNumber > 9999
						|| prd.get_quantity() < userEntered_Qty) {

					System.out.println("\n\tERROR: Ivalid values entered... Returning to Main menu...");
					mainRunner = true;
				} else {

					if (prd instanceof Weapon) {

						Weapon wpn = new Weapon((Weapon) prd);
		
						if (!(myCart.checkIfItemInCart(userEntered_ItemNumber))) {

							myCart.addItem(wpn, userEntered_Qty);
							prd.set_quantity((prd.get_quantity() - userEntered_Qty));
						} else {

							System.out.print("\n\t That item is already in your cart."
									+ "\n\t Would you like to update the Quantity? (1 = Yes, 2 = No):");
							userValue = scan.nextInt();

							switch (userValue) {
							case 1:

								System.out.print("\n\t Enter the desired quantity: ");
								userEntered_Qty = scan.nextInt();

								// This line sets the item quantity by getting the item quantity and adding the
								// entered value
								myCart.getItemWithItemNumber(userEntered_ItemNumber).set_quantity((myCart.getItemWithItemNumber(userEntered_ItemNumber).get_quantity()+ userEntered_Qty));
								prd.set_quantity((prd.get_quantity() - userEntered_Qty));

								break;
							default:
								System.out.print("\n\t ERROR: Invalid value entered. Returning to Main menu...");
								mainRunner = true;
							}

						}
					} else if (prd instanceof Armor) {

						Armor armr = new Armor((Armor) prd);

						if (!(myCart.checkIfItemInCart(userEntered_ItemNumber))) {

							myCart.addItem(armr, userEntered_Qty);
							prd.set_quantity((prd.get_quantity() - userEntered_Qty));
						} else {

							System.out.print("\n\t That item is already in your cart."
									+ "\n\t Would you like to update the Quantity? (1 = Yes, 2 = No):");
							userValue = scan.nextInt();

							switch (userValue) {
							case 1:

								System.out.print("\n\t Enter the desired quantity: ");
								userEntered_Qty = scan.nextInt();

								// This line sets the item quantity by getting the item quantity and adding the
								// entered value
								myCart.getItemWithItemNumber(userEntered_ItemNumber).set_quantity(
										(myCart.getItemWithItemNumber(userEntered_ItemNumber).get_quantity()
												+ userEntered_Qty));
								prd.set_quantity((prd.get_quantity() - userEntered_Qty));

								break;
							default:
								System.out.print("\n\t ERROR: Invalid value entered. Returning to Main menu...");
								mainRunner = true;
							}

						}

					} else if (prd instanceof Health) {

						Health hlth = new Health((Health) prd);

						if (!(myCart.checkIfItemInCart(userEntered_ItemNumber))) {

							myCart.addItem(hlth, userEntered_Qty);
							prd.set_quantity((prd.get_quantity() - userEntered_Qty));
						} else {

							System.out.print("\n\t That item is already in your cart."
									+ "\n\t Would you like to update the Quantity? (1 = Yes, 2 = No):");
							userValue = scan.nextInt();

							switch (userValue) {
							case 1:

								System.out.print("\n\t Enter the desired quantity: ");
								userEntered_Qty = scan.nextInt();

								// This line sets the item quantity by getting the item quantity and adding the
								// entered value
								myCart.getItemWithItemNumber(userEntered_ItemNumber).set_quantity((myCart.getItemWithItemNumber(userEntered_ItemNumber).get_quantity()+ userEntered_Qty));
								prd.set_quantity((prd.get_quantity() - userEntered_Qty));

								break;
							default:
								System.out.print("\n\t ERROR: Invalid value entered. Returning to Main menu...");
								mainRunner = true;
							}
						}

					} else {

						System.out.println("\n\tERROR: Unknown Object Type. Returning to Main Menu...");
						mainRunner = true;
					}
				}
				break;

			//----------------------------------------------------------------------------------------------------------------------------	
			//----------------------------------------------------------------------------------------------------------------------------		
			case 4://Remove an Item from the ShoppingCart or Update Qty
				
				System.out.print("\n\t Enter the products 'Item Number' you wish to Update/Remove: ");
				userEntered_ItemNumber = scan.nextInt();
				
				if(userEntered_ItemNumber < 0 || userEntered_ItemNumber > 9999) {
				
					System.out.print("\n\t ERROR: Invalid Entry. Returning to Main Menu...");
					mainRunner = true;
				}else if(userEntered_Qty == 1) {
					
					myCart.remove_Item(userEntered_ItemNumber);
					
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
				
			//----------------------------------------------------------------------------------------------------------------------------	
			//----------------------------------------------------------------------------------------------------------------------------	
			default: //Error Checking. Ensure that the program persists if an invalid value ie entered
				
				System.out.print("\n\t ERROR: Invalid value entered. Restarting...");
				mainRunner = true;
			}
			
		}while(mainRunner);
	}

		
	
}//StoreDriver Class

/*
 
 
 
 
		Armor arm = new Armor("Psijic Staff", "a mahogany staff", 17, 1090, 2.0, 230,37);
		
		ObjectMapper om = new ObjectMapper();
		
		String armJson= 
				"{\"_name\": \"Staff\", \"_description\": \"a staff\", \"_quantity\": 17, \"_itemNumber\": 1090, \"_price\": 2.0, \"_protectionRating\": 230.0, \"_weight\": 37.0}";
		
		try {
			Armor copyArm = om.readValue(armJson, Armor.class);
			System.out.println(copyArm);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
 
 
 
 
 
 
 
 
 
 
 
 **/
 