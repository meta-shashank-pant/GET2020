import java.util.Iterator;
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
			System.out.println("\n\n1. ADD ITEMS\n2. REMOVE ITEMS\n3. DISPLAY ITEMS\n4. FINAL BILL AND EXIT.");
			val = scan.nextInt();
			switch(val){
			case 1:
				System.out.println("Add Item");
				addItem(items, cartItems);
				break;
			case 2:
				System.out.println("Remove Item");
				removeItem(items, cartItems);
				break;
			case 3:
				System.out.println("Display Item");
				billDisplay(cartItems);
				break;
			case 4:
				System.out.println("Total Bill and Exit");
				billDisplay(cartItems);
				System.out.println("Thankyou for shopping with us.");
				flag = 0;
				break;
			default:
				System.out.println("Unidentified Value(Exit)");
				flag = 0;
				break;
			}
		}

	}
	
	public static void addItem(Map<String, Integer> items, Map<String, Integer> cartItems){
		
		/* 
		 * This method is used for adding any item into cart.
		 * @param cartItem: It is HashMap to store the items into the cart.
		 * @param items: It is the HashMap storing all items name and prices. 
		 * "req_item" is the String that will capture the required item by the user.
		 * */
		
		System.out.println("ADD ITEMS: Enter name or type exit.");
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
				System.out.println(req_item+" added successfully!\n");
			}else{
				System.out.println("Sorry! "+req_item+" not available.\n");
			}
			addItem(items, cartItems);
		}
		
	}

	public static void removeItem(Map<String, Integer> items, Map<String, Integer> cartItems){
		
		/*
		 * The purpose of this function is to remove an item from the cart.
		 * @param item: HashMap of all the items.
		 * @param cartItems: HashMap of items in cart.
		 */
		
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
				System.out.println(req_item+" removed successfully!");
			}else{
				System.out.println("There is no such item.");
			}
			removeItem(items,cartItems);
		}
		
	}
	
    public static void billDisplay(Map<String, Integer> cartItems){
		/*
		 * Purpose of this function is to display the key and values of HashMap along with the total.
		 * @param cartItems: It holds all the items and their prices in the cartItems HashMap.
		 */
        Iterator itemIterator = cartItems.entrySet().iterator(); 
        int finalBill=0;
         while (itemIterator.hasNext()) { 
            Map.Entry item = (Map.Entry)itemIterator.next(); 
            int price = (int)item.getValue(); 
            System.out.println(item.getKey() + " : " + price);
            finalBill += price;
        }
         System.out.println("Total Bill: "+finalBill);
	}
	

}

