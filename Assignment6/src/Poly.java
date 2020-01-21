import java.util.HashMap;
import java.util.Map;

public class Poly {

	private final int coefficient[];
	private final int degree[];
	private final HashMap<Integer, Integer> equation = new HashMap<>();
	
	public Poly(int coefficient[], int degree[]){
		this.coefficient = coefficient;
		this.degree = degree;
		for(int i = 0; i < coefficient.length; i++){
			equation.put(coefficient[i], degree[i]);
		}
	}
	
//	public double evaluate(double var){
//		double result = Math.pow(var, power);
//		result = result * coefficient;
//		result = result + constant;
//		return result;
//	}
//	
//	public int getCoefficient(){
//		return coefficient;
//	}
//	
//	public int getConstant(){
//		return constant;
//	}
//	
//	public int getdegree(){
//		return power;
//	}
//	
//	public void addPoly(Poly p1, Poly p2){
//		int degree1 = p1.getdegree();
//		int degree2 = p2.getdegree();
//		int degree, coefficient, constant;
//		if(degree1 == degree2){
//			coefficient = p1.getCoefficient() + p2.getCoefficient();
//		}
//		constant = p1.getConstant() + p2.getConstant();
//	}
}
