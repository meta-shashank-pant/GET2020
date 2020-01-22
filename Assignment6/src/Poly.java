/**
 * This class has methods to perform operations on single variable polynomials.
 * @author Shashank
 * This class is immutable.
 */
public class Poly {

	private final int coefficient[];
	private final int degree[];
	private final int length;
	private final int maxDegree;
	
	/**
	 * Constructor.
	 * @param coefficient is the input array of type integer, holding the coefficients.
	 * @param degree is the input array of type integer, holding the degree.
	 * @param length is the length of the array.
	 */
	public Poly(int coefficient[], int degree[], int length){
		this.coefficient = coefficient;
		this.degree = degree;
		this.length = length;
		this.maxDegree = degree[length-1];
	}
	
	/**
	 * This method is used to evaluate the polynomials.
	 * @param var is the input double, for which the polynomial is solved. 
	 * @return value is of type double and holds the result.
	 */
	public double evaluate(double var){
		double result;
		double output = 0;
		for(int i = 0; i < length; i++){
			result = Math.pow(var, degree[i]);
			result *= coefficient[i];
			output += result;
		}
		return output;
	}
	
	/**
	 * @return value is the max degree in the polynomial equation.
	 */
	public int getMaxDegree(){
		return maxDegree;
	}
	
	/**
	 * @return is the length of the array(coefficient, degree).
	 */
	public int getLength(){
		return length;
	}
	
	/**
	 * @return array is of type integer and holds the coefficient.
	 */
	public int[] getCoefficient(){
		return coefficient;
	}
	
	/**
	 * @return array is of type integer and holds the degree.
	 */
	public int[] getDegree(){
		return degree;
	}
	
	/**
	 * This method will perform addition operation on two polynomials.
	 * @param p1 is input object of type Poly.
	 * @param p2 is input object of type Poly.
	 * @return value is String which shows the result after the addition operation.
	 */
	public static String addPoly(Poly p1, Poly p2){
		int len1 = p1.getLength();
		int len2 = p2.getLength();
		int index = 0, total_len = len1 + len2;
		String result ;
		int[] coeff = new int[len1 + len2];
		int[] deg = new int[len1 + len2];
		
		for(index = 0; index < len1; index++){
			coeff[index] = p1.getCoefficient()[index];
			deg[index] = p1.getDegree()[index];
		}
		for(int i = 0; i < len2; i++){
			coeff[index + i] = p2.getCoefficient()[i];
			deg[index + i] = p2.getDegree()[i];
		}
		
		index = 0;
		int max_deg = p1.getMaxDegree() + p2.getMaxDegree();
		result = addition(coeff, deg, max_deg, total_len);
		return result;
	}
	
	/**
	 * This method is called from addPoly() and multiplyPoly() and will help in performing the addition of similar degree coefficient.
	 * @param coeff is the input array of type integer.
	 * @param deg is the input array of type integer.
	 * @param max_deg is the maximum degree of the polynomial.
	 * @param total_len is the total length of the array.
	 * @return is the string holding final result.
	 */
	private static String addition(int coeff[], int deg[], int max_deg, int total_len){
		int[][] final_output = new int[total_len][2];
		int index = 0;
		String result = "";
		for(int i = 0; i <= max_deg; i++){
			int total_coeff = 0;
			for(int j = 0; j < total_len ; j++){
				if(i == deg[j]){
					total_coeff += coeff[j];
				}
			}
			if(total_coeff != 0){
				final_output[index][0] = i;
				final_output[index][1] = total_coeff;
				index++;
			}
		}
		
		for(int i = index-1; i >= 0; i--){
			if(i != 0)
				result += final_output[i][1] + "x^" + final_output[i][0] + " + ";
			else
				result += final_output[i][1] + "x^" + final_output[i][0] ;
		}
		System.out.print(result);
		return result;
	}
	
	/**
	 * This method will perform multiplication on two polynomials.
	 * @param p1 is input object of type Poly.
	 * @param p2 is input object of type Poly.
	 * @return is the string holding the result of multiplication.
	 */
	public static String multiplyPoly(Poly p1, Poly p2){
		String result = "";
		int index = 0;
		int len1 = p1.getLength(), len2 = p2.getLength();
		int total_len = len1 * len2;
		int max_deg = p1.getMaxDegree() + p2.getMaxDegree();
		int deg[] = new int[len1 * len2];
		int coeff[] = new int[len1 * len2];
		for(int i = 0; i < len1; i++){
			int coeff_val = 0, deg_val = 0;
			for(int j = 0; j < len2; j++){
				deg_val = p1.getDegree()[i] + p2.getDegree()[j];
				coeff_val = p1.getCoefficient()[i] * p2.getCoefficient()[j];
				deg[index] = deg_val;
				coeff[index] = coeff_val;
				if(deg_val > max_deg)
					max_deg = deg_val;
				index++;
			}
		}
		result = addition(coeff, deg, max_deg, total_len);
		return result;
	}
	
}
