import java.util.Scanner;


public class Marksheet {

	private boolean flag = true;
	private int[] student_grade  = new int[100];
	private String[] student_name = new String[100];
	
	public void start(){
		
		Scanner scan = new Scanner(System.in);
		int val=1;
		int number_of_student = get_n();
		int output;
		double result;
		String formatted_output;
		set_names_grades(number_of_student);
		while(flag){
			System.out.println("1. AVERAGE GRADE\n2. MAXIMUM GRADE\n3. MINIMUM GRADE\n"
					+ "4. STUDENT PASSED( % )\n5. EXIT");
			try{
				val = scan.nextInt();
			}catch(Exception e){
				start();
			}
			switch(val){
			case 1:
				System.out.println("Average Grade: ");
				result = get_average(number_of_student);
				formatted_output = String.format("%.2f", result);
				System.out.println("-> " + formatted_output);
				break;
			case 2:
				System.out.println("Maximum Grade: ");
				output = get_maximum_grade(number_of_student);
				System.out.println("-> " + output + "\nStudent name: ");
				get_name(output, number_of_student);
				break;
			case 3:
				System.out.println("Minimum Grade: ");
				output = get_minimum_grade(number_of_student);
				System.out.println("-> " + output + "\nStudent name: ");
				get_name(output, number_of_student);
				break;
			case 4:
				System.out.println("Student passed( % ): ");
				result = get_passed_student(number_of_student);
				formatted_output = String.format("%.2f", result);
				System.out.println("-> " + formatted_output + "%");
				break;
			case 5:
				System.out.println("Sucessfully Exit.");
				flag = false;
				break;
			default:
				System.out.println("Invalid input!, Try again.");
				break;
			}
		}

	}
	
	private int get_n(){
		
		Scanner scan = new Scanner(System.in);
		int output = 0;
		System.out.print("Enter number of student(Max 100): ");
		try{
			output = scan.nextInt();
			if(output <= 0 || output > 100){
				System.out.println("Invalid argument! ");
				get_n();
			}
		}catch(Exception e){
			System.out.println("Invalid argument! ");
			get_n();
		}
		return output;
	}
	
	private void set_names_grades(int number_of_student){
		
		for(int i = 0; i < number_of_student; i++){
			set_name(i);
			set_grade(i);
		}
	}
	
	private void set_grade(int index){
		
		Scanner scan = new Scanner(System.in);
		int grade;
		System.out.print("[" + (index+1) + "]" + "Enter grade(0 <= grade <= 100): ");
		try{
			grade = scan.nextInt();
			if(grade >= 0 && grade <= 100){
				student_grade[index] = grade;
			}else{
				System.out.println("Invalid argument! ");
				set_grade(index);
			}
		}catch(Exception e){
			System.out.println("Invalid argument! ");
			set_grade(index);
		}
	}
	
	private void set_name(int index){
		
		Scanner scan = new Scanner(System.in);
		String name;
		System.out.print("[" + (index+1) + "]" + "Enter name: ");
		name = scan.nextLine();
		student_name[index] = name;
	
	}
	
	private double get_average(int num_of_student){
		
		double result = 0;
		for(int i = 0; i < num_of_student; i++){
			result += student_grade[i];
		}
		try{
			result = result / num_of_student;
		}catch(ArithmeticException e){
			System.out.print("Arithmetic Exception!!!");
		}
		return result;
	}
	
	private int get_maximum_grade(int num_of_student){
		
		int max_output = student_grade[0];
		for(int i = 0; i < num_of_student; i++){
			if(max_output <= student_grade[i]){
				max_output = student_grade[i];
			}
		}
		return max_output;
	}
	
	private int get_minimum_grade(int num_of_student){
		
		int min_output = student_grade[0];
		for(int i = 0; i < num_of_student; i++){
			if(min_output >= student_grade[i]){
				min_output = student_grade[i];
			}
		}
		return min_output;
	}
	
	private void get_name(int grade, int num_of_student){
		
		for(int i = 0; i < num_of_student; i++){
			if(grade == student_grade[i]){
				System.out.println(student_name[i]);
			}
		}
	}
	
	private double get_passed_student(int num_of_student){
		double output = 0;
		int count = 0, passing_number = 40;
		for(int i = 0; i < num_of_student; i++){
			if(student_grade[i] >= passing_number){
				count += 1;
			}
		}
		try{
			output = (count * 100 )/ num_of_student;
		}catch(ArithmeticException e){
			System.out.print("Arithmetic Exception!!!");
		}
		return output;
	}
	
}
