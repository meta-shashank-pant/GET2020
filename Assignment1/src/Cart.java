import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
public class Cart {
	
	static int flag;
	static HashMap<String, Integer> cartItems = new HashMap<>();
	static HashMap<String, Integer> items = new HashMap<>();
	
	public Cart(int flag){
	    this.flag = flag;
	    System.out.println("Welcome to the Mart.");
	    items.put("sugar",50);
		items.put("milk",60);
		items.put("juice",30);
		items.put("apple",100);
	}
	
	public static void start(){
		Scanner scan = new Scanner(System.in);
		int val;
		while(flag != 0){
			val = scan.nextInt();
			switch(val){
			case 1:
				System.out.println("Add Item");
				addItem(items, cartItems);
				break;
			case 2:
				System.out.println("Remove Item");
				removeItem();
				break;
			case 3:
				System.out.println("Display Item");
				displayItem(cartItems);
				break;
			case 4:
				System.out.println("Total Bill and Exit");
				totalBill();
				flag = 0;
				break;
			default:
				System.out.println("Unidentified Value(Exit)");
				flag = 0;
				break;
			}
		}

	}
	
	public static void displayItem(Map<String, Integer> map) 
    { 
		/*
		 * This method is used for displaying the items in the hashmap.
		 */
		
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
		
		System.out.println("Please enter item name to enter into cart OR Type exit to exit.");
		Scanner scan = new Scanner(System.in);
		String req_item = scan.nextLine().toLowerCase();
		
		if(req_item.contains("exit")){
			System.out.println("You are on main menu.");
		}else{
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
			
			displayItem(cartItems);
			addItem(items, cartItems);
		}
		
	}

	
	public static void removeItem(){}
	
	public static void totalBill(){}
	

}

