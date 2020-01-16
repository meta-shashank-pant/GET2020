import java.util.Scanner;


public class Strings {
	
	private String str_1, str_2;
	private boolean flag = true;
	
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
	
	private String single_input(){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter String: ");
		String str = scan.nextLine();
		return str;
	}
	
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
	
	private String reverse(String str){
		String output = "";
		for(int i = str.length() - 1; i >= 0; i--){
			output += str.charAt(i);
		}
		return output;
	}
	
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
	
	private String compare_equal_string(String str_1, String str_2){
		
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
