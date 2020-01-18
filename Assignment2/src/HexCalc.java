import java.util.Scanner;

/**
 * @author Shashank
 * HexCalc class will help in implementation of various operation on hexadecimal numbers.
 * hex_input[] is string array of size 2. For storing 2 hexadecimal number to perform operation.
 * int number will store the result of hexadecimal to decimal conversion.
 * This class is designed for non negative hexadecimal string.
 */
public class HexCalc implements HexCalculator {
	
	private int flag;
	private String hex_input[] = new String[2];
	private int number=0;
	public HexCalc(){
		this.flag = 1;
	}
	
	/**
	 * start() is driver function for this class.
	 * Switch Case statement will help user to perform various task.
	 */
	public void start(){
		
		Scanner scan = new Scanner(System.in);
		int val=1;
		System.out.println("Welcome to HEX Calculator.");
		while(flag != 0){
			System.out.println("\nPress 1: Addition\nPress 2: Subtraction\nPress 3: Multiplication\n"
					+ "Press 4: Division\nPress 5: Compare\nPress 6: Hexadecimal to Decimal\n"
					+ "Press 7: Decimal to Hexadecimal\nPress 8: Exit");
			try{
				val = scan.nextInt();
			}catch(Exception e){
				System.out.println("Invalid Input!, Try again.");
				start();
			}
			switch(val){
			case 1:
				System.out.println("****ADDITION****");
				two_hex_input();
				String add_answer = addition(hex_input[0], hex_input[1]);
				System.out.println(hex_input[0] + " + " + hex_input[1] + " = " + add_answer);
				break;
			case 2:
				System.out.println("****SUBTRACTION****");
				two_hex_input();
				String sub_answer = subtraction(hex_input[0], hex_input[1]);
				System.out.println(hex_input[0] + " - " + hex_input[1] + " = " + sub_answer);
				break;
			case 3:
				System.out.println("****MULTIPLICATION****");
				two_hex_input();
				String mul_answer = multiplication(hex_input[0], hex_input[1]);
				System.out.println(hex_input[0] + " * " + hex_input[1] + " = " + mul_answer);
				break;
			case 4:
				System.out.println("****DIVISION****");
				two_hex_input();
				String div_answer = division(hex_input[0], hex_input[1]);
				String remainder = remainder(hex_input[0], hex_input[1]);
				System.out.println(hex_input[0] + " ÷ " + hex_input[1] + " = " + div_answer + " Remainder " + remainder);
				break;
			case 5:
				System.out.println("****COMPARE****");
				two_hex_input();
				String big_num = compare(hex_input[0], hex_input[1]);
				System.out.println("Comparision result: " + big_num);
				break;
			case 6:
				System.out.println("****HEXADECIMAL TO DECIMAL****");
				single_hex_input();
				int decimal_num = hexadecimalToDecimal(hex_input[0]);
				System.out.println(hex_input[0] + " = " + decimal_num);
				break;
			case 7:
				System.out.println("****DECIMAL TO HEXADECIMAL****");
				String hexadecimal = decimalToHexadecimal();
				System.out.println(number + " = " + hexadecimal);
				break;
			case 8:
				System.out.println("Exit Successfully.");
				flag = 0;
				break;
			default:
				System.out.println("Invalid input!, Try again");
				break;
			}
		}
	}
	
	/**
	 * Compare two hexadecimal strings.			
	 * @param hex_1 is the first hexadecimal input string.
	 * @param hex_2 is the second hexadecimal input string.
	 * @return value will be the larger hexadecimal string.
	 */
	public String compare(String hex_1, String hex_2){
		
		if(hex_1.length() > hex_2.length()){
			return hex_1;
		}else if(hex_1.length() < hex_2.length()){
			return hex_2;
		}else{
			return equalCompare(hex_1, hex_2);
		}
	}
	
	/**
	 * Compare two hexadecimal strings when the length of strings are equal.
	 * @param hex_1 is the first hexadecimal input string.
	 * @param hex_2 is the second hexadecimal input string.
	 * @return the maximum number, if any, otherwise return "Both numbers are equal.".
	 */
	public String equalCompare(String hex_1, String hex_2){
		
		int len = hex_1.length();
		for(int i = 0; i < len; i++){
			if(hex_1.charAt(i) > hex_2.charAt(i)){
				return hex_1;
			}else if(hex_1.charAt(i) < hex_2.charAt(i)){
				return hex_2;
			}else{
				continue;
			}
		}
		return "Both numbers are equal.";
	}
	
	/**
	 * This function will perform decimal to hexadecimal conversion.
	 * In this function, integer input is taken from user and passed to decToHexa(number) function.
	 * @return result will have the hexadecimal string.
	 */
	public String decimalToHexadecimal(){
		
		Scanner scan = new Scanner(System.in);
		int int_number;
		String result;
		System.out.println("Enter integer number: ");
		try{
			int_number = scan.nextInt();
			number = int_number;
			result = decToHexa(number);
		}catch(Exception e){
			System.out.println("Invalid Input!!!");
			result = "0";
		}
		
		return result;
	}
	
	/**
	 * This function will take input from decimalToHexadecimal() and then perform conversion.
	 * @param n is the input integer.
	 * @return output is the string output.
	 */
	public String decToHexa(int number) {
		
		char[] hexaDeciNum = new char[100]; 
		String output = "";
		int i = 0;
		if(number == 0){
			output = "0";
			return output;
		}
		while(number != 0) 
		{    
			int temp  = 0; 
			temp = number % 16; 
			if(temp < 10) 
			{ 
				hexaDeciNum[i] = (char)(temp + 48); 
				i++; 
			} 
			else
			{ 
				hexaDeciNum[i] = (char)(temp + 55); 
				i++; 
			} 
			number = number / 16; 
		} 
       
		for(int j=i-1; j>=0; j--) 
			output += hexaDeciNum[j]; 
		return output;
	} 
	
	/**
	 * This function is used for taking single valid hexadecimal input.
	 * Taken input will be stored in hex_input string array.
	 */
	public void single_hex_input(){
		
		Scanner scan = new Scanner(System.in);
		Boolean flag;
		System.out.print("Enter hexadecimal number: ");
		hex_input[0] = scan.nextLine();
		flag = isHexNumber(hex_input[0]);
		if(!flag){
			single_hex_input();
		}
	}
	
	/**
	 * This function is used to take 2 valid hexadecimal input.
	 * The function isHexNumber() will check if the entered input is hexadecimal or not.
	 * The valid inputs will be stored in hex_input[] array. 
	 */
	public void two_hex_input(){
		
		Scanner scan = new Scanner(System.in);
		Boolean isHex;
		System.out.print("Enter 1st hexadecimal number: ");
		hex_input[0] = scan.nextLine();
		isHex = isHexNumber(hex_input[0]);
		if(!isHex){
			two_hex_input();
		}
		System.out.print("Enter 2nd hexadecimal number: ");
		hex_input[1] = scan.nextLine();
		isHex = isHexNumber(hex_input[1]);
		if(!isHex){
			System.out.print("");
			two_hex_input();
		}
	}
	
	/**
	 * This function is used to check if a number is valid hexadecimal number.
	 * @param hex_string is the input string.
	 * @return value is boolean, that means true if number is hexadecimal otherwise false.
	 */
	public boolean isHexNumber(String hex_string){
		
		  try {
		    Long.parseLong(hex_string, 16);
		    return true;
		  }
		  catch (NumberFormatException ex) {
		    System.out.println("Not hexadecimal! ");
		    return false;
		  }
	}
	
	/**
	 * This function will convert hexadecimal number to decimal.
	 * @param hexVal is hexadecimal input string.
	 * @return dec_val is the integer value equivalent of hexVal.
	 */
	public int hexadecimalToDecimal(String hexVal){
		
		int len = hexVal.length(); 
		int base = 1; 
		int dec_val = 0; 
		for (int i=len-1; i>=0; i--) 
		{     
			if (hexVal.charAt(i) >= '0' && hexVal.charAt(i) <= '9') 
			{ 
				dec_val += (hexVal.charAt(i) - 48)*base; 
				base = base * 16; 
			} 
			else if (hexVal.charAt(i) >= 'A' && hexVal.charAt(i) <= 'F') 
			{ 
				dec_val += (hexVal.charAt(i) - 55)*base; 
				base = base*16; 
			}
			else if(hexVal.charAt(i) >= 'a' && hexVal.charAt(i) <= 'f'){
				dec_val += (hexVal.charAt(i) - 87)*base; 
				base = base*16;
			}
		} 
		return dec_val; 
	} 
	
	/**
	 * This method will perform addition of hexadecimal numbers.
	 * @param hex_1 is the first hexadecimal input string.
	 * @param hex_2 is the second hexadecimal input string.
	 * @return result is the hexadecimal string that contains the answer.
	 * Here, hexadecimal string is converted into decimal string and then added.
	 */
	public String addition(String hex_1, String hex_2){
		
		int int_result;
		int_result = hexadecimalToDecimal(hex_1) + hexadecimalToDecimal(hex_2);
		String result = Integer.toHexString(int_result);
		return result;
	}
	
	/**
	 * This method will perform subtraction of hexadecimal numbers.
	 * @param hex_1 is the first hexadecimal input string.
	 * @param hex_2 is the second hexadecimal input string.
	 * @return result is the hexadecimal string that contains the answer.
	 * Here, hexadecimal string is converted into decimal string and then subtracted.
	 */
	public String subtraction(String hex_1, String hex_2){
		
		int int_result;
		int_result = hexadecimalToDecimal(hex_1) - hexadecimalToDecimal(hex_2);
		String result="";
		if(int_result < 0){
			result = "-";
		}
		result += Integer.toHexString(Math.abs(int_result));
		return result;
	}
	
	/**
	 * This method will perform multiplication of hexadecimal numbers.
	 * @param hex_1 is the first hexadecimal input string.
	 * @param hex_2 is the second hexadecimal input string.
	 * @return result is the hexadecimal string that contains the answer.
	 * Here, hexadecimal string is converted into decimal string and then multiplied.
	 */
	public String multiplication(String hex_1, String hex_2){
		
		int int_result;
		int_result = hexadecimalToDecimal(hex_1) * hexadecimalToDecimal(hex_2);
		String result = Integer.toHexString(int_result);
		return result;
	}
	
	/**
	 * This method will perform division of hexadecimal numbers.
	 * @param hex_1 is the first hexadecimal input string.
	 * @param hex_2 is the second hexadecimal input string.
	 * @return result is the hexadecimal string that contains the answer.
	 * Here, hexadecimal string is converted into decimal string and then divided.
	 */
	public String division(String hex_1, String hex_2){
		
		int int_result;
		int_result = hexadecimalToDecimal(hex_1) / hexadecimalToDecimal(hex_2);
		String result = Integer.toHexString(int_result);
		return result;
	}
	
	/**
	 * This method is used to get remainder of hexadecimal number.
	 * @param hex_1 is the first hexadecimal input string.
	 * @param hex_2 is the second hexadecimal input string.
	 * @return result is the hexadecimal string that contains the answer.
	 * Here, hexadecimal string is converted into decimal string and then modulus operation is applied.
	 */
	public String remainder(String hex_1, String hex_2){
		
		int int_result;
		int_result = hexadecimalToDecimal(hex_1) % hexadecimalToDecimal(hex_2);
		String result = Integer.toHexString(int_result);
		return result;
	}
}
