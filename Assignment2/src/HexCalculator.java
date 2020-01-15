
public interface HexCalculator {

	public void start();
	public String compare(String hex_1, String hex_2);
	public String equalCompare(String hex_1, String hex_2);
	public String decimalToHexadecimal();
	public String decToHexa(int n);
	public void single_hex_input();
	public void two_hex_input();
	public boolean isHexNumber (String hex_string);
	public int hexadecimalToDecimal(String hexVal);
	public String addition(String hex_1, String hex_2);
	public String subtraction(String hex_1, String hex_2);
	public String multiplication(String hex_1, String hex_2);
	public String division(String hex_1, String hex_2);
	public String remainder(String hex_1, String hex_2);
}
