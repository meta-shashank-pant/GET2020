import java.util.Scanner;

/**
 * This class will record names and grades of n student and then perform certain operations on that data.
 * @author Shashank
 * There is 2 array integer array to hold student grades and string array for student names.
 * User can perform set of operations on data like:
 * -> Average grade, Maximum Grade, Minimum Grade, Student Passed.
 */
public class Marksheet {

	private boolean flag = true;
	private int[] student_grade  = new int[100];
	private String[] student_name = new String[100];
	
	/**
	 * start() is the driver method in this class, it is called from main() method.
	 * Here, variable "val" will hold the user choice among various options like:
	 * 1. Average grade 
	 * 2. Maximum Grade and Student name/names.
	 * 3. Minimum Grade and Student name/names.
	 * 4. Student passed(%)
	 * Required Output string is formatted and displayed to user in this function.
	 */
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
	
	/**
	 * This method will take input from user, that is total number of student.
	 * @return value is the total number of student.
	 * Here, a user can perform operation on 100 students at a time.
	 */
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
	
	/**
	 * This method is used to make entry of student name and their corresponding grade.
	 * @param number_of_student is the total number of student, input of type integer.
	 */
	private void set_names_grades(int number_of_student){
		
		for(int i = 0; i < number_of_student; i++){
			set_name(i);
			set_grade(i);
		}
	}
	
	/**
	 * This method is called from set_names_grades() and has main objective of setting grade for a student.
	 * @param index is the input unique number for any student and on the basis of that grades are filled.
	 * @exception is handled here as user is only allowed to enter integer and not any other data type.
	 * Here condition is checked that grade should be between 0 and 100 both inclusive.
	 */
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
	
	/**
	 * This method is called from set_names_grades() and has main objective of setting name for a student.
	 * @param index is the input unique number for any student and on the basis of that names are filled.
	 * name is filled in the student_name, string array.
	 */
	private void set_name(int index){
		
		Scanner scan = new Scanner(System.in);
		String name;
		System.out.print("[" + (index+1) + "]" + "Enter name: ");
		name = scan.nextLine();
		student_name[index] = name;
	}
	
	/**
	 * This method is for calculating the average grade of all students.
	 * @param num_of_student is the integer input, that is number of students.
	 * @return result is of type double and holds the average grade.
	 * @exception Here arithmetic exception is handled.
	 */
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
	
	/**
	 * This method is used to get maximum grade from all given grade.
	 * @param num_of_student is the integer input, that is number of students.
	 * @return result is of type double and holds the maximum grade.
	 */
	private int get_maximum_grade(int num_of_student){
		
		int max_output = student_grade[0];
		for(int i = 0; i < num_of_student; i++){
			if(max_output <= student_grade[i]){
				max_output = student_grade[i];
			}
		}
		return max_output;
	}
	
	/**
	 * This method is used to get minimum grade from all given grade.
	 * @param num_of_student is the integer input, that is number of students.
	 * @return result is of type double and holds the minimum grade.
	 */
	private int get_minimum_grade(int num_of_student){
		
		int min_output = student_grade[0];
		for(int i = 0; i < num_of_student; i++){
			if(min_output >= student_grade[i]){
				min_output = student_grade[i];
			}
		}
		return min_output;
	}
	
	/**
	 * This method is used for getting the names of the student corresponding to the maximum and minimum grades.
	 * @param grade is the input grade for which student names will be identified.
	 * @param num_of_student is the integer input for total number of students.
	 */
	private void get_name(int grade, int num_of_student){
		
		for(int i = 0; i < num_of_student; i++){
			if(grade == student_grade[i]){
				System.out.println(student_name[i]);
			}
		}
	}
	
	/**
	 * This method is used to calculated the percent of passed students.
	 * @param num_of_student is the integer input for total number of student.
	 * @return output is the percent of student passed and the return value is of type double.
	 * The criteria for passing the exam is to score grade more than or equal to 40.
	 */
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
