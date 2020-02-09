package controller;
import java.util.*;

import view.Main;
import e_num.Status;
import facade.Cart_Operation;

public class Product_Controller {
	
	private Product_Controller(){}
	
	public static HashMap<Integer, String[]> get_items() { return Cart_Operation.get_items(); }

	public static HashMap<Integer, String[]> getCart() { return Cart_Operation.sendCart(); }
	
	public static Status controller(int choice) {
		boolean flag = true;
		int key, qty;
		Status response = null;
		while(flag){
			switch(choice){
			case 1:
				try {
					Main.printItems();
					key = Main.getKey();
					if(key == 0)
						return Status.OK;
					else if(key == -1)
						return Status.EXIT;
					qty = Main.getQty();
					if(qty == 0)
						return Status.OK;
					else if(key == -1)
						return Status.EXIT;
					//Add Operation
					response = Cart_Operation.addItems(key, qty);
					return response;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					response = Status.ERROR;
				}
				flag = false;
				break;
			case 2:
				try {
					Main.printCart();
					key = Main.getKey();
					if(key == 0)
						return Status.OK;
					else if(key == -1)
						return Status.EXIT;
					qty = Main.getQty();
					if(qty == 0)
						return Status.OK;
					else if(key == -1)
						return Status.EXIT;
					//Delete Operation
					response = Cart_Operation.deleteItem(key, qty);
					return response;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					response = Status.ERROR;
				}
				break;
			case 3:
				Main.printCart();
				response = Status.EXIT;
				flag = false;
				break;
			case 4:
				Main.displayBill();
				response = Status.EXIT;
				flag = false;
				break;
			default:
				response = Status.WRONG_CASE;
				break;
			}
		}
		return response;
	}
}
