public class Polynomial {
	
	public int degree;
	public char variable;
	
	public Polynomial(char var, int deg){
		degree = deg;
		variable = var;
	}
	
	/**
	 * This method returns the name of the variable
	 * @return An char variable , name of the variable.
	 */
	public char getVaribleName() {
		return variable;
	}
	/**
	 * This method returns the power of the variable
	 * @return An Integer variable, The degree of Variable.
	 */
	public int getVariablePower() {
		return degree;
	}
}