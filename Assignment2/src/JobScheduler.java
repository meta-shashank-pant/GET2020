import java.util.Scanner;
public class JobScheduler {

	static int [] arrival_time = new int[100];
	static int [] burst_time = new int[100];
	static int [] completion_time = new int[100];
	static int [] waiting_time = new int[100];
	static int [] turn_around_time = new int[100];
	static int [] process_number = new int[100]; 
	static int jobs;
	static double average_waiting_time;
	static int max_waiting_time;
	public static void start(){
		System.out.println("Welcome to Job Scheduler.");
		input();
		display();
		sort();
		fcfs();
		result();
	}
	
	public static void input(){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number of jobs: ");
		jobs = 0;
		try{
			jobs = scan.nextInt();
		}catch(Exception e){
			System.out.println("Invalid Input!");
			input();
		}
		for(int i = 0; i < jobs; i++){
			process_number[i] = i+1;
			takeInput(i);
		}
	}
	
	public static void takeInput(int index){
		
		Scanner scan = new Scanner(System.in);
		try{
			System.out.print("[" + (index + 1) + "]" + "Arrival time: ");
			arrival_time[index] = scan.nextInt();
			System.out.print("[" + (index + 1) + "]" + "Burst time: ");
			burst_time[index] = scan.nextInt();
		}catch(Exception e){
			System.out.println("Invalid Input!");
			takeInput(index);
		}
	}
	
	public static void sort(){
		
        for (int i = 0; i < jobs-1; i++)
            for (int j = 0; j < jobs-i-1; j++)
                if (arrival_time[j] > arrival_time[j+1])
                {
                    int temp1 = arrival_time[j];
                    arrival_time[j] = arrival_time[j+1];
                    arrival_time[j+1] = temp1;
                    
                    int temp2 = burst_time[j];
                    burst_time[j] = burst_time[j+1];
                    burst_time[j+1] = temp2;
                    
                    int temp3 = process_number[j];
                    process_number[j] = process_number[j+1];
                    process_number[j+1] = temp3;
                }
	}
	
	public static void fcfs(){
		
		waiting_time[0] = 0;
		int total_burst = 0, difference, idel_time = 0;
		for(int i = 0; i < jobs-1; i++){
			total_burst += burst_time[i];
			difference = total_burst - arrival_time[i+1];
			if(difference > 0){
				waiting_time[i+1] = difference + idel_time;
			}else{
				idel_time += Math.abs(difference);
				waiting_time[i+1] = 0;
			}
		}
		
		for(int i = 0; i < jobs; i++){
			turn_around_time[i] = waiting_time[i] + burst_time[i];
			completion_time[i] = arrival_time[i] + waiting_time[i] + burst_time[i];
		}
		
		double total_waiting_time = 0;
		max_waiting_time = waiting_time[0];
		for(int i = 0; i < jobs; i++){
			total_waiting_time += waiting_time[i];
			if(max_waiting_time < waiting_time[i]){
				max_waiting_time = waiting_time[i];
			}
		}
		average_waiting_time = total_waiting_time / jobs;
	}
	
	public static void display(){
		
		System.out.println("Process\tArrival\tBurst");
		for(int i = 0; i < jobs; i++){
			System.out.println("P" + process_number[i] + "\t" + arrival_time[i] + "\t" + burst_time[i]);
		}
	}
	
	public static void result(){
		System.out.println("Process\tArrival\tBurst\tWaiting\tComp.\tT.A.T");
		for(int i = 0; i < jobs; i++){
			System.out.println("P" + process_number[i] + "\t" + arrival_time[i] + "\t" + burst_time[i] + "\t" + waiting_time[i] + "\t" 
								+ completion_time[i] + "\t" + turn_around_time[i]);
		}
		System.out.println("Average waiting time: " + average_waiting_time + "\nMaximum waiting time: " + max_waiting_time);
	}
	
}
