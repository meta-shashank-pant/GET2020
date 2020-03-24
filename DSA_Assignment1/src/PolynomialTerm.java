import java.util.*;

public class PolynomialTerm {
	
	public int coffecient;
	public List<Polynomial> variableList;
	
	public PolynomialTerm(int coeff, List<Polynomial> poly1){
		coffecient = coeff;
		variableList = poly1;
	}
}