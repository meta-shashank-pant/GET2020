import java.util.Scanner;

public class Assignment1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Press 1 to enter mart.");
		Scanner scan = new Scanner(System.in);
		int flag = scan.nextInt();
		if(flag == 1){
			Cart obj1 = new Cart(flag);
			obj1.start();
		}
		
	}

}
