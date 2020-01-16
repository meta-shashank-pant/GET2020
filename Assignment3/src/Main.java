import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Strings str = new Strings();
		Marksheet ms = new Marksheet();
		Area area = new Area();
		Scanner scan = new Scanner(System.in);
		System.out.println("Press 1 for String Operation.\nPress 2 for Marksheet.\nPress 3 for Area Calculation.");
		int choice;
		try{
			choice = scan.nextInt();
			if(choice != 1 && choice !=2 && choice != 3){
				System.out.println("Invalid Input!");
			}else{
				if(choice == 1){
					str.start();
				}else if(choice == 2){
					ms.start();
				}else{
					area.start();
				}
			}
		}catch(Exception e){
			System.out.println("Invalid Input!");
		}

	}

}
