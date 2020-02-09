package dao;

import java.util.HashMap;

public class ProductDAO {
	
	private static ProductDAO daoInstance = null;
	private HashMap<Integer, String[]> items = new HashMap<Integer, String[]>();

	String[] item_name = {"Sugar", "Milk", "Juice", "Apple", "Bat", "Soap", "Onion", "Laptop", "Oil"};
	int[] item_price = {50, 60, 30, 100, 200, 150, 100, 50000, 100};
	String[] item_type = {"Grocery","Dairy Product","Drinks","Fruit","Sports","Body Product","Vegetable","Electronics","Grocery"};

	private ProductDAO(){
		for(int i=0; i < item_name.length;i++){
			items.put(i+11, new String[]{item_name[i], item_type[i], item_price[i]+""});
		}
	}
	
	public static ProductDAO getInstance(){
		if(daoInstance == null)
			daoInstance = new ProductDAO();
		return daoInstance;
	}
	
	public HashMap<Integer, String[]> get_items(){ return items; }
//	
//	public static int[] get_price(){ return item_price; }
	
}
