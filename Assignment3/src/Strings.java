import java.util.Scanner;

/**
 * Strings class is used to perform different operations on String.
 * @author Shashank
 * This class has the method to perform certain opeations like:
 * -> Compare string, Reverse string, Replace lower case with upper case and vice-versa, Largest word in the string. 
 */
public class Strings {
	
	private String str_1, str_2;
	private boolean flag = true;
	
	/**
	 * start() is the driver method in this class, it is called from main() method.
	 * Here, variable "val" will hold the user choice among various options like:
	 * 1. Compare String
	 * 2. Reverse String
	 * 3. Replace lower case with upper case and vice versa
	 * 4. Largest word
	 * Required Output string is displayed to user in this function.
	 */
	public void start(){
		
		Scanner scan = new Scanner(System.in);
		String output;
		int val=1;
		while(flag){
			System.out.println("1. COMPARE STRINGS\n2. REVERSE STRING\n3. REPLACE LOWERCASE WITH UPPERCASE AND VICE-VERSA\n"
					+ "4. LARGEST WORD\n5. EXIT");
			try{
				val = scan.nextInt();
			}catch(Exception e){
				start();
			}
			switch(val){
			case 1:
				System.out.println("Compare Two Strings: ");
				str_1 = single_input();
				str_2 = single_input();
				output = compare_string(str_1, str_2);
				System.out.println("-> " + output);
				break;
			case 2:
				System.out.println("Reverse String.");
				str_1 = single_input();
				output = reverse(str_1);
				System.out.println("-> " + output);
				break;
			case 3:
				System.out.println("Replace Lowercase with Uppercase and vice-versa");
				str_1 = single_input();
				output = replace_lowercase_uppercase(str_1);
				System.out.println("-> " + output);
				break;
			case 4:
				System.out.println("Find Largest Word.");
				str_1 = single_input();
				output = largest_word(str_1);
				System.out.println("-> " + output);
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
	 * This method is used to get the string input form the user and return the input.
	 * @return  str is of type string.
	 */
	private String single_input(){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter String: ");
		String str = scan.nextLine();
		return str;
	}
	
	/**
	 * This method is for getting the largest word from the string.
	 * @param str is the input string on which the operation is performed.
	 * @return output is the largest word of type string.
	 */
	private String largest_word(String str){
		String output = "";
		int max = 0;
		for (String word : str.split(" ")){
			if(max <= word.length()){
				max = word.length();
				output = word;
			}
		}
		return output;
	}
	
	/**
	 * This method is for replacing the upper case alphabet in the string with lower case and vice-versa.
	 * @param str is the input string on which operation is to be performed.
	 * @return output is the resultant string generated.
	 * Here, integer value is added and subtracted in order to get the ascii value of the required alphabet.
	 */
	private String replace_lowercase_uppercase(String str){
		
		int str_length = str.length();
		String output = "";
		for (int i = 0; i < str_length; i++) 
		{   
			int temp;
			char char_val;
			if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') 
			{ 
				 temp = str.charAt(i) + 32;
				 char_val = (char)temp;
				 output += char_val;
			}
			else if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z'){
				temp = str.charAt(i) - 32;
				char_val = (char)temp;
				output += char_val;
			}else{
				output += str.charAt(i);
			}
		}
		return output;
	}
	
	/**
	 * This method is for generating the reverse string of the input string.
	 * @param str is the input string on which operation is performed.
	 * @return output is the reversed string.
	 */
	private String reverse(String str){
		String output = "";
		for(int i = str.length() - 1; i >= 0; i--){
			output += str.charAt(i);
		}
		return output;
	}
	
	/**
	 * This method is used for comparing two string if they are equal or not.
	 * @param str_1 is the first input string.
	 * @param str_2 is the second input string.
	 * @return output is the argument telling whether strings are equal or not.
	 */
	private String compare_string(String str_1, String str_2){
		
		String output;
		if(str_1.length() == str_2.length()){
			output = compare_equal_string(str_1, str_2);
			return output;
		}else{
			output = "Strings are not equal.";
			return output;
		}
	}

	/**
	 * This method is called form compare_string() method, in case length of both strings are equal.
	 * @param str_1 is the first input string.
	 * @param str_2 is the second input string.
	 * @return output is the argument telling whether strings are equal or not.
	 */
	String compare_equal_string(String str_1, String str_2){
		
		int len = str_1.length();
		String output;
		for(int i = 0; i < len; i++){
			if((str_1.charAt(i) > str_2.charAt(i)) || (str_1.charAt(i) < str_2.charAt(i))){
				output = "Strings are not equal.";
				return output;
			}else{
				continue;
			}
		}
		output = "EQUAL!!!";
		return output;
	}
}
