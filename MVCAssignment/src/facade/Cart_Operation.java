package facade;

import java.util.*;

import e_num.*;
import dao.ProductDAO;

public class Cart_Operation {
	
	private static HashMap<Integer, String[]> cartItems = new HashMap<>();
	private static HashMap<Integer, String[]> items = ProductDAO.getInstance().get_items();
	
	private Cart_Operation(){}
	
	public static HashMap<Integer, String[]> cart(){
		return cartItems;
	}
	
	public static Status addItems(int key, int qty) throws Exception {
		String value[] = new String[4];
		if(items.containsKey(key)){
			value[0] = items.get(key)[0];
			value[1] = items.get(key)[1];
			value[2] = items.get(key)[2];
			if(cartItems.containsKey(key))
				value[3] = Integer.parseInt(cartItems.get(key)[3]) + qty + "";
			else
				value[3] = qty + "";
			cartItems.put(key, value);
			return Status.SUCCESS_ADITION;
		}
		return Status.ITEM_NOT_FOUND;
	}
	
	public static Status deleteItem(int key, int qty) throws Exception {
		if(cartItems.containsKey(key)){
			int curr_qty = Integer.parseInt(cartItems.get(key)[3]);
			if(curr_qty == qty)
				cartItems.remove(key);
			else if(curr_qty > qty){
				curr_qty -= qty;
				cartItems.get(key)[3] = qty + "";
			}else{
				return Status.FAILURE_DELETION;
			}
			return Status.SUCCESS_DELETION;
		}
		return Status.ITEM_NOT_FOUND;
	}
	
	public static HashMap<Integer, String[]> sendCart(){
		return cartItems;
	}
	
	public static HashMap<Integer, String[]> get_items(){ return items; }
	
	
}
