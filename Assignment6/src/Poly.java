
public class Poly {

	private final int coefficient[];
	private final int degree[];
	private final int length;
	private final int maxDegree;
	
	public Poly(int coefficient[], int degree[], int length){
		this.coefficient = coefficient;
		this.degree = degree;
		this.length = length;
		this.maxDegree = degree[length-1];
	}
	
	
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
	
	public int getMaxDegree(){
		return maxDegree;
	}
	
	public int getLength(){
		return length;
	}
	
	public int[] getCoefficient(){
		return coefficient;
	}
	
	public int[] getDegree(){
		return degree;
	}
	
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
	
	public void print(int a[]){
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
	}
}
