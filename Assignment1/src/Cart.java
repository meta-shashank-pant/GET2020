import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
public class Cart {
	/*
	 * The Cart class is the implementation of various function that a cart needs.
	 * Here, item addition, deletion, display and final bill functions are performed.
	 * "cartItems" is used to keep track of elements that are added to the cart.
	 * "items" HashMap is used to hold the elements in the mart along with the price.
	 * "item_name" and "item_price" are array to hold the names and the price of the items, they are used to give each element an id.
	 */
	int flag;
	HashMap<String, Integer> cartItems = new HashMap<>();
	HashMap<String, Integer> items = new HashMap<>();
	String[] item_name = {"sugar", "milk", "juice", "apple", "bat", "soap", "onion", "laptop", "oil"};
	int[] item_price = {50, 60, 30, 100, 200, 150, 100, 50000, 100};
	public Cart(int flag){
	    this.flag = flag;
	    System.out.println("Welcome to the Mart.");
	    for(int i=0;i<item_name.length;i++){
	    	items.put(item_name[i],item_price[i]);
	    }
	}
	
	public void start(){
		/*
		 * This method is invoked from the driver class.
		 * User will interact with this function and will perform various functions.
		 */
		Scanner scan = new Scanner(System.in);
		int val=1;
		while(flag != 0){
			System.out.println("1. ADD ITEMS\n2. REMOVE ITEMS\n3. DISPLAY ITEMS\n4. FINAL BILL AND EXIT.");
			try{
				val = scan.nextInt();
			}catch(Exception e){
				start();
			}
			switch(val){
			case 1:
				printList(item_name,item_price);
				System.out.println("ADD ITEMS: Enter item id or type exit.(Max 100)");
				addItem(items, cartItems, item_name);
				break;
			case 2:
				billDisplay(items,cartItems);
				System.out.println("REMOVE ITEM: Enter id or type exit.");
				removeItem(items, cartItems, item_name);
				break;
			case 3:
				System.out.println("Display Item");
				billDisplay(items,cartItems);
				break;
			case 4:
				System.out.println("Total Bill and Exit");
				billDisplay(items,cartItems);
				System.out.println("Thankyou for shopping with us.");
				flag = 0;
				break;
			default:
				System.out.println("Invalid input!, Try again.");
				break;
			}
		}
		
	}
	
	private void addItem(Map<String, Integer> items, Map<String, Integer> cartItems, String[] item_name){
		
		/* 
		 * "addItem" is used for adding any item into cart.
		 * @param cartItem: It is HashMap to store the items into the cart.
		 * @param items: It is the HashMap storing all items name and prices. 
		 * @param item_name: It is an string array holding the item names and index corresponding will be the unique key of each item.
		 * "req_item" is the String that will capture the required item by the user.
		 * */
		Scanner scan = new Scanner(System.in);
		String req_item;
		int quantity=1;
		try{
			int id = scan.nextInt();
			req_item = item_name[id];
			System.out.print("Quantity -> ");
			quantity = scan.nextInt();
			if(quantity>100 || quantity<1){
				System.out.println("Entered amount should be between 0 to 100.");
				req_item="Wrong";
			}
		}catch(Exception e){
			req_item = scan.nextLine().toLowerCase();
		}
		
		if(req_item.contains("exit")){
			System.out.println("You are on main menu.");
		}else{
			if(items.containsKey(req_item)){
				int amount = quantity * items.get(req_item);
				if(cartItems.containsKey(req_item)){
					amount += cartItems.get(req_item);
					cartItems.replace(req_item, amount);
				}else{
					cartItems.put(req_item, amount);
				}
				System.out.println(quantity + " unit " + req_item + " added successfully!");
			}else{
				System.out.println("Invalid request! \nADD ITEMS: Enter item id or type exit.");
			}
			addItem(items, cartItems, item_name);
		}
		
	}

	private void removeItem(Map<String, Integer> items, Map<String, Integer> cartItems, String[] item_name){
		
		/*
		 * The purpose of this function is to remove an item from the cart.
		 * @param item: HashMap of all the items.
		 * @param cartItems: HashMap of items in cart.
		 */
		Scanner scan = new Scanner(System.in);
		String req_item;
		int quantity=1, current_quant, id;
		label:
		try{
			id = scan.nextInt();
			req_item = item_name[id];
			if(!cartItems.containsKey(req_item)){
				System.out.println(req_item + " is not in cart.");
				break label;
			}
			System.out.print("Quantity -> ");
			quantity = scan.nextInt();
			current_quant = cartItems.get(req_item)/items.get(req_item);
			if(current_quant < quantity){
				System.out.println("Invalid Request.");
				req_item = "Wrong";
			}
		}catch(Exception e){
			req_item = scan.nextLine().toLowerCase();
		}
		if(req_item.contains("exit")){
			System.out.println("You are on main menu.");
		}else{
			if(cartItems.containsKey(req_item)){
				int amount = cartItems.get(req_item);
				amount -= quantity * items.get(req_item);
				if(amount == 0){
					//remove item.
					cartItems.remove(req_item);
				}else{
					cartItems.replace(req_item, amount);
				}
				System.out.println(quantity + " unit " + req_item + " removed successfully!");
			}else{
				System.out.println("Please enter valid expression! \nREMOVE ITEM: Enter item id or type exit.");
			}
			removeItem(items,cartItems, item_name);
		}
		
	}
	
    private void billDisplay(Map<String, Integer> all_items, Map<String, Integer> cartItems){
		/*
		 * Purpose of this function is to display the key and values of HashMap along with the total.
		 * @param cartItems: It holds all the items and their prices in the cartItems HashMap.
		 */
        Iterator<Entry<String, Integer>> itemIterator = cartItems.entrySet().iterator(); 
        int finalBill=0, quantity=0;
        System.out.println("Id\tItem\tPrice\tQuant\tTotal");
         while (itemIterator.hasNext()) { 
            Map.Entry<String, Integer> item = (Entry<String, Integer>)itemIterator.next(); 
            int price = (int)item.getValue();
            int individual_price = all_items.get(item.getKey());
            quantity = price/individual_price;
            int id = getItemId(item.getKey());
            System.out.println(id + "\t" + item.getKey() + "\t" + individual_price+ "\t" + quantity + "\t" + price);
            finalBill += price;
        }
         System.out.println("Total Bill: "+finalBill);
	}
    
    private int getItemId(String name){
    	int size = item_name.length;
    	for(int i = 0; i < size; i++){
    		if(name == item_name[i])
    			return i;
    	}
    	return -1;
    }
    
    	private void printList(String[] item_name, int[] item_price){
    	/*
    	 * This function will print item list along with serial number and price.
    	 * @param item_name is array holding item name.
    	 * @param item_price is array holding item price.
    	 */
    	System.out.println("ID\tName\tPrice");
    	for(int i=0;i<item_name.length;i++){
    		System.out.println(i+"\t"+item_name[i]+"\t"+item_price[i]);
    	}
    }
	
}

