import java.util.HashMap; 
import java.util.Iterator;
import java.util.Map; 
import java.util.Scanner;
public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> cartItems = new HashMap<>();
		HashMap<String, Integer> items = new HashMap<>();
		items.put("sugar",50);
		items.put("milk",60);
		items.put("juice",30);
		items.put("apple",100);
		items.replace("sugar", 100);
		//print(items);
		//System.out.println(items.get("sugar"));
		addItem(items,cartItems);
	}
	
	public static void print(Map<String, Integer> map) 
    { 
        if (map.isEmpty()) { 
            System.out.println("map is empty"); 
        } 
  
        else { 
            System.out.println(map); 
        } 
    } 
	
	public static void addItem(Map<String, Integer> items, Map<String, Integer> cartItems){
	
		/* This method is used for adding any item into cart.
		 * "cartItem" is the HashMap to store the items into the cart.
		 * "req_item" is the String that will capture the required item by the user.
		 * if condition for checking if the required item is present or not.
		 * */
		System.out.println("Please enter item name to enter into cart");
		
		Scanner scan = new Scanner(System.in);
		String req_item = scan.nextLine().toLowerCase();
		if(items.containsKey(req_item)){
			int amount = items.get(req_item);
			if(cartItems.containsKey(req_item)){
				amount += cartItems.get(req_item);
				cartItems.replace(req_item, amount);
			}else{
				cartItems.put(req_item, amount);
			}
		}else{
			System.out.println("Item not present.");
		}
		
		print(cartItems);
		billDisplay(cartItems);
		addItem(items, cartItems);
		
	}
	
	public static void removeItem(Map<String, Integer> items, Map<String, Integer> cartItems){
		
		System.out.println("REMOVE ITEM: Enter name or type exit.");
		
		Scanner scan = new Scanner(System.in);
		String req_item = scan.nextLine().toLowerCase();
		if(req_item.contains("exit")){
			System.out.println("You are on main menu.");
		}else{
			if(cartItems.containsKey(req_item)){
				int amount = cartItems.get(req_item);
				amount -= items.get(req_item);
				if(amount == 0){
					//remove item.
					cartItems.remove(req_item);
				}else{
					cartItems.replace(req_item, amount);
				}
			}else{
				System.out.println("There is no such item.");
			}
		}
		
	}
	
	public static void billDisplay(Map<String, Integer> cartItems){
		
        Iterator itemIterator = cartItems.entrySet().iterator(); 
  
         
  
        while (itemIterator.hasNext()) { 
            Map.Entry mapElement = (Map.Entry)itemIterator.next(); 
            int marks = (int)mapElement.getValue(); 
            System.out.println(mapElement.getKey() + " : " + marks);
        }
	}

}
