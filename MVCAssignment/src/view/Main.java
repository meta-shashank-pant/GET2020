package view;
import java.util.*;
import java.util.Map.Entry;

import controller.Product_Controller;
import e_num.Status;
public class Main {
	
	private static HashMap<Integer, String[]> cartItems = new HashMap<>();
	private static HashMap<Integer, String[]> items = new HashMap<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true){
			try {

				getItems(Product_Controller.get_items());
				int choice = takeInput();
				Status response = Product_Controller.controller(choice);
				if(response == Status.EXIT){
					System.out.println("Exit Success.");
					break;
				}else if(response == Status.SUCCESS_ADITION)
					System.out.println("Item added successfully.");
				else if(response == Status.SUCCESS_DELETION)
					System.out.println("Item removed successfully.");
				else if(response == Status.FAILURE_DELETION)
					System.out.println("Wrong Quantity.");
				else if(response == Status.ITEM_NOT_FOUND)
					System.out.println("Item not found.");
				else if(response == Status.WRONG_CASE)
					System.out.println("Invalid Operation.");
				else if(response == Status.ERROR)
					System.out.println("Error in Input.");
				else if(response == Status.OK)
					continue;
				else
					System.out.println("Something gone wrong!");
				getCart();
				printCart();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println("Thanks for shopping!");
	}
	
	/**
	 * This method will get the items hashmap.
	 * @param get_items is the hashmap.
	 */
	private static void getItems(HashMap<Integer, String[]> get_items) {
		// TODO Auto-generated method stub
		items = get_items;
	}
	
	/**
	 * This method is used to get the cart items.
	 */
	public static void getCart(){
		cartItems = Product_Controller.getCart();
	}
	
	/**
	 * This method is used for printing the item hashmap.
	 */
	public static void printItems(){
		Iterator<Entry<Integer, String[]>> itemIterator = items.entrySet().iterator();
		System.out.format("%2s%20s%20s%10s\n","ID","Name","Type","Price");
		System.out.println("-----------------------------------------------------");
		while(itemIterator.hasNext()){
			Map.Entry<Integer, String[]> item = (Map.Entry<Integer, String[]>)itemIterator.next();
			//System.out.println(item.getKey()+"\t"+item.getValue()[0]+"\t"+item.getValue()[1]+"\t"+item.getValue()[2]);
			System.out.format("%2d%20s%20s%10s\n", item.getKey(),item.getValue()[0],item.getValue()[1],item.getValue()[2]);
		}
	}
	
	/**
	 * This method is used to print the cart items.
	 */
	public static void printCart(){
		Iterator<Entry<Integer, String[]>> itemIterator = cartItems.entrySet().iterator();
		System.out.format("%2s%20s%20s%10s%10s\n","ID","Name","Type","Price","Quantity");
		System.out.println("-----------------------------------------------------");
		while(itemIterator.hasNext()){
			Map.Entry<Integer, String[]> item = (Map.Entry<Integer, String[]>)itemIterator.next();
			//System.out.println(item.getKey()+"\t"+item.getValue()[0]+"\t"+item.getValue()[1]+"\t"+item.getValue()[2]);
			System.out.format("%2d%20s%20s%10s%10s\n", item.getKey(),item.getValue()[0],item.getValue()[1],item.getValue()[2],item.getValue()[3]);
		}
	}
	
	/**
	 * This method is used to display the bill.
	 */
	public static void displayBill(){
		Iterator<Entry<Integer, String[]>> itemIterator = cartItems.entrySet().iterator();
		System.out.format("%2s%20s%20s%10s%10s%10s\n","ID","Name","Type","Price","Quantity","Total");
		System.out.println("-----------------------------------------------------");
		int grandtotal = 0;
		while(itemIterator.hasNext()){
			Map.Entry<Integer, String[]> item = (Map.Entry<Integer, String[]>)itemIterator.next();
			int total = Integer.parseInt(item.getValue()[2]) * Integer.parseInt(item.getValue()[3]);
			grandtotal += total;
			System.out.format("%2d%20s%20s%10s%10s%10d\n", item.getKey(),item.getValue()[0],item.getValue()[1],item.getValue()[2],item.getValue()[3],total);
		}
		
		System.out.println("Grand Total: "+grandtotal);
	}
	
	/**
	 * This method is used to take the input choice from the user.
	 * @return the integer choice from the user.
	 * @throws Exception
	 */
	public static int takeInput() throws Exception {
		int choice;
		System.out.println("Welcome to Mart.");
		Scanner scan = new Scanner(System.in);
		System.out.println("1. ADD ITEMS\n2. REMOVE ITEMS\n3. DISPLAY ITEMS\n4. FINAL BILL AND EXIT.");
		choice = scan.nextInt();
		return choice;
	}
	
	/**
	 * This method is used to get the key.
	 * @return is the integer value holding the key.
	 * @throws Exception
	 */
	public static int getKey() throws Exception{
		System.out.println("\nEnter the Item ID OR Press -1 to EXIT OR Press 0 to go BACK: ");
		int key;
		Scanner scan = new Scanner(System.in);
		try{
			key = scan.nextInt();
			return key;
		}catch(Exception e){
			System.out.println(e);
		}
		return 0;
	}
	
	/**
	 * This method is used to get the quantity.
	 * @return value is of type integer holding quantity.
	 * @throws Exception
	 */
	public static int getQty() throws Exception {
		System.out.println("Enter the quantity OR Press -1 to EXIT OR Press 0 to go BACK: ");
		int quantity;
		Scanner scan = new Scanner(System.in);
		try{
			quantity = scan.nextInt();
			if(quantity > 100 || quantity < 1){
				System.out.println("Quantity should be between 1 and 100. ");
				return 0;
			}
			return quantity;
		}catch (Exception e){
			System.out.println(e);
			return 0;
		}
	}

}
