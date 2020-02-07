package controller;
import java.util.*;

import facade.Cart_Operation;

public class Product_Controller {
	
	private static HashMap<Integer, String[]> cartItems = new HashMap<>();
	
	private Product_Controller(){}
	
	public static String[] get_name(){ return Cart_Operation.get_name(); }
	
	public static int[] get_price(){ return Cart_Operation.get_price(); }
	
	public static HashMap<Integer, String[]> controller(int choice) {
		boolean flag = true;
		while(flag){
			switch(choice){
			case 1:
				//printList(item_name,item_price);
				System.out.println("ADD ITEMS: Enter item id or type exit.");
				//addItem(items, cartItems, item_name);
				break;
			case 2:
				//printList(item_name,item_price);
				System.out.println("REMOVE ITEM: Enter id or type exit.");
				//removeItem(items, cartItems, item_name);
				break;
			case 3:
				System.out.println("Display Item");
				//billDisplay(items,cartItems);
				break;
			case 4:
				System.out.println("Total Bill and Exit");
				//billDisplay(items,cartItems);
				System.out.println("Thankyou for shopping with us.");
				flag = false;
				break;
			default:
				System.out.println("Invalid input!, Try again.");
				break;
			}
		}
		
		return cartItems;
	}
}
