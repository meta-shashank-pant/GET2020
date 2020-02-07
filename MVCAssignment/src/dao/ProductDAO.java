package dao;

public class ProductDAO {

	static String[] item_name = {"sugar", "milk", "juice", "apple", "bat", "soap", "onion", "laptop", "oil"};
	static int[] item_price = {50, 60, 30, 100, 200, 150, 100, 50000, 100};
	
	public static String[] get_name(){ return item_name; }
	
	public static int[] get_price(){ return item_price;}
	
}
