import java.util.Scanner;
public class HexCalc {

	static int flag;
	static String hex_input[] = new String[2];
	static int number=0;
	public HexCalc(){
		this.flag = 1;
	}
	
	public static void start(){
		/*
		 * start() is driver function for this class.
		 * Switch Case statement will help user to perform various task.
		 */
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
	
	public static String compare(String hex_1, String hex_2){
		
		if(hex_1.length() > hex_2.length()){
			return hex_1;
		}else if(hex_1.length() < hex_2.length()){
			return hex_2;
		}else{
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
	}
	
	public static String decimalToHexadecimal(){
		Scanner scan = new Scanner(System.in);
		int int_number;
		String result;
		System.out.println("Enter integer number: ");
		try{
			int_number = scan.nextInt();
			number = int_number;
			result = Integer.toHexString(number);
		}catch(Exception e){
			System.out.println("Invalid Input!!!");
			result = "0";
		}
		return result;
	}
	
	public static void single_hex_input(){
		Scanner scan = new Scanner(System.in);
		Boolean flag;
		System.out.print("Enter hexadecimal number: ");
		hex_input[0] = scan.nextLine();
		flag = isHexNumber(hex_input[0]);
		if(!flag){
			single_hex_input();
		}
	}
	
	public static void two_hex_input(){
		Scanner scan = new Scanner(System.in);
		Boolean flag;
		System.out.print("Enter 1st hexadecimal number: ");
		hex_input[0] = scan.nextLine();
		flag = isHexNumber(hex_input[0]);
		if(!flag){
			two_hex_input();
		}
		System.out.print("Enter 2nd hexadecimal number: ");
		hex_input[1] = scan.nextLine();
		flag = isHexNumber(hex_input[1]);
		if(!flag){
			System.out.print("");
			two_hex_input();
		}
	}
	
	private static boolean isHexNumber (String hex_string) {
		  try {
		    Long.parseLong(hex_string, 16);
		    return true;
		  }
		  catch (NumberFormatException ex) {
		    System.out.println("Not hexadecimal! ");
		    return false;
		  }
	}
	
	static int hexadecimalToDecimal(String hexVal) 
    {    
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
	
	public static String addition(String hex_1, String hex_2){
		
		int int_result;
		int_result = hexadecimalToDecimal(hex_1) + hexadecimalToDecimal(hex_2);
		String result = Integer.toHexString(int_result);
		return result;
	}
	
	public static String subtraction(String hex_1, String hex_2){
		
		int int_result;
		int_result = hexadecimalToDecimal(hex_1) - hexadecimalToDecimal(hex_2);
		String result="";
		if(int_result < 0){
			result = "-";
		}
		result += Integer.toHexString(Math.abs(int_result));
		return result;
	}
	
	public static String multiplication(String hex_1, String hex_2){
		
		int int_result;
		int_result = hexadecimalToDecimal(hex_1) * hexadecimalToDecimal(hex_2);
		String result = Integer.toHexString(int_result);
		return result;
	}
	
	public static String division(String hex_1, String hex_2){
		
		int int_result;
		int_result = hexadecimalToDecimal(hex_1) / hexadecimalToDecimal(hex_2);
		String result = Integer.toHexString(int_result);
		return result;
	}
	
	public static String remainder(String hex_1, String hex_2){
		
		int int_result;
		int_result = hexadecimalToDecimal(hex_1) % hexadecimalToDecimal(hex_2);
		String result = Integer.toHexString(int_result);
		return result;
	}
}
