import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HexCalc hex = new HexCalc();
		JobScheduler js = new JobScheduler();
		Scanner scan = new Scanner(System.in);
		System.out.println("Press 1 for Hexadecimal Calculator.\nPress 2 for Job Scheduler.");
		int choice;
		try{
			choice = scan.nextInt();
			if(choice != 1 && choice !=2){
				System.out.println("Invalid Input!");
			}else{
				if(choice == 1){
					hex.start();
				}else{
					js.start();
				}
			}
		}catch(Exception e){
			System.out.println("Invalid Input!");
		}

	}

}
