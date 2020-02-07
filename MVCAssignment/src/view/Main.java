package view;
import java.util.*;

import controller.Product_Controller;
public class Main {
	
	private static HashMap<Integer, String[]> cartItems = new HashMap<>();
	private static String[] item_name;
	private static int[] item_price;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			takeInput();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void takeInput() throws Exception {
		int choice;
		System.out.println("Welcome to Mart.");
		Scanner scan = new Scanner(System.in);
		System.out.println("1. ADD ITEMS\n2. REMOVE ITEMS\n3. DISPLAY ITEMS\n4. FINAL BILL AND EXIT.");
		choice = scan.nextInt();
		setCartItems(Product_Controller.controller(choice));
		scan.close();
	}
	
	public static String name_info() throws ArrayIndexOutOfBoundsException {
		System.out.println("ADD ITEMS: Enter item id or type 0.");
		Scanner scan = new Scanner(System.in);
		String req_item = null;
		try{
			int id = scan.nextInt();
			req_item = item_name[id];
		}catch(Exception e){
			System.out.println(e);
		}
		scan.close();
		return req_item;
	}

	public static HashMap<Integer, String[]> getCartItems() {
		return cartItems;
	}

	public static void setCartItems(HashMap<Integer, String[]> cartItems) {
		Main.cartItems = cartItems;
	}
	
	public static void billDisplay(Map<Integer, String[]> cartItems){
		System.out.println("Display Bill");
	}


	public String[] getItem_name() {
		return item_name;
	}


	public void setItem_name(String[] item_name) {
		Main.item_name = item_name;
	}


	public int[] getItem_price() {
		return item_price;
	}


	public void setItem_price(int[] item_price) {
		Main.item_price = item_price;
	}
	

}
