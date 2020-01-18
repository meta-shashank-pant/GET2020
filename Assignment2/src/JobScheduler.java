import java.util.Scanner;

/**
 * Job Scheduler is implemented using FCFS scheduling algorithm.
 * @author Shashank
 * In this class user will give input and on the basis of that the scheduling is performed.
 * Here the assumption is that there will be no more than 100 jobs.
 * User will give input:
 * 1. Number of jobs
 * 2. Burst time of each job.
 * 3. Arrival time of each job.
 * Output screen additionally have:
 * 1. Completion time of each job.
 * 2. Waiting time of each job.
 * 3. Turn around time of each job.
 * 4. Average waiting time.
 * 5. Maximum waiting time.
 */
public class JobScheduler{

	int [] arrival_time = new int[100];
	int [] burst_time = new int[100];
	int [] completion_time = new int[100];
	int [] waiting_time = new int[100];
	int [] turn_around_time = new int[100];
	int [] process_number = new int[100]; 
	int jobs;
	double average_waiting_time;
	int max_waiting_time;
	
	/**
	 * This is the called function from the main function in this class.
	 */
	public void start(){
		
		System.out.println("Welcome to Job Scheduler.");
		input();
		display();
		sort();
		fcfs();
		result();
	}
	
	/**
	 * This function is used to take input, number of jobs.
	 * input function will be used in taking error free input from the user.
	 * to take error free input, Exception Handling is done.
	 */
	public void input(){
		
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
	
	/**
	 * This function is used to take input arrival and burst time of each job.
	 * @param index is the individual job index for which arrival and burst time is fetched from user.
	 */
	public void takeInput(int index){
		
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
	
	/**
	 * sort() function is used to sort the jobs according to the arrival time.
	 * Here, for sorting bubble sort is used.
	 * In accordance to arrival time following attributes will get sorted:
	 * 1. burst time
	 * 2. process number
	 */
	public void sort(){
		
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
	
	/**
	 * In this method FCFS scheduling is performed and the results are stored in following array data structure.
	 * Here, these following attributes are calculated:
	 * 1. Waiting Time 
	 * 2. Turn Around Time = Waiting time + Burst time
	 * 3. Completion Time = Arrival time + Waiting time + Burst time
	 * 4. Maximum waiting time
	 * 5. Average waiting time = Total waiting time / total jobs
	 */
	public void fcfs(){
		
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
	
	/**
	 * This method is used to display Process number, Arrival time, Burst time.
	 */
	public void display(){
		
		System.out.println("Process\tArrival\tBurst");
		for(int i = 0; i < jobs; i++){
			System.out.println("P" + process_number[i] + "\t" + arrival_time[i] + "\t" + burst_time[i]);
		}
	}
	
	/**
	 * This function is used to print the following items on the final screen:
	 * 1. Process number
	 * 2. Arrival time
	 * 3. Burst time
	 * 4. Waiting time
	 * 5. Completion time
	 * 6. Turn around time
	 * 7. Average waiting time
	 * 8. Maximum waiting time
	 */
	public void result(){
		System.out.println("Process\tArrival\tBurst\tWaiting\tComp.\tT.A.T");
		for(int i = 0; i < jobs; i++){
			System.out.println("P" + process_number[i] + "\t" + arrival_time[i] + "\t" + burst_time[i] + "\t" + waiting_time[i] + "\t" 
								+ completion_time[i] + "\t" + turn_around_time[i]);
		}
		System.out.println("Average waiting time: " + average_waiting_time + "\nMaximum waiting time: " + max_waiting_time);
	}
	
}
