/**
 * MathProblem class is for calculating the hcf(Highest common divisor) and lcm(Least common multiplier).
 * @author Shashank
 * Every method is implemented with the concept of recursion.
 */
public class MathProblem {
	
	/**
	 * Highest common divisor is calculated of num_1 and num_2.
	 * @param num_1 is the input number of type integer.
	 * @param num_2 is the input number of type integer.
	 * @return is the hcf in type integer.
	 */
	public int hcf(int num_1, int num_2) {
		int rem = num_1 % num_2;
		if(rem == 0){
			return num_2;
		}else{
			return hcf(num_2, rem);
		}
	}
	
	/**
	 * Least common multiplier of num_1 and num_2 is calculated here.
	 * @param num_1 is the input number of type integer.
	 * @param num_2 is the input number of type integer.
	 * @return is the lcm of num_1 and num_2 of type integer.
	 */
	public int lcm(int num_1, int num_2) {
		int output = num_1 * num_2;
		output = output / hcf(num_1, num_2);
		return output;
	}
}
