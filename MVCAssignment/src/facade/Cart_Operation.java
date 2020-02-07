package facade;
import java.util.*;

import dao.ProductDAO;

public class Cart_Operation {

	private static HashMap<Integer, String[]> cartItems = new HashMap<>();
	
	private Cart_Operation(){}
	
	public static void addOperation(){
		
	}
	
	public static HashMap<Integer, String[]> cart(){
		
		
		return cartItems;
	}
	
	public static String[] get_name(){ return ProductDAO.get_name(); }
	
	public static int[] get_price(){ return ProductDAO.get_price(); }
	
}
