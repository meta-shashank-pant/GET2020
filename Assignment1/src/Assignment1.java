import java.util.Scanner;

public class Assignment1 {
	/*
	 * This class is driver class.
	 * Here object of Cart class is initialized and start() method is called.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Press 1 to enter mart.");
		Scanner scan = new Scanner(System.in);
		int flag;
		try{
		    flag = scan.nextInt();
		}catch(Exception e){
			System.out.println("Input is not 1.\nEXIT");
			flag = 2;
		}
		if(flag == 1){
			Cart obj1 = new Cart(flag);
			obj1.start();
		}
		
	}

}
