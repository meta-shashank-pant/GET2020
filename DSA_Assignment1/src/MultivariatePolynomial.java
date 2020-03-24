import java.util.ArrayList;
import java.util.List;

public class MultivariatePolynomial {

	public List<PolynomialTerm> multivariatePolynomial;


	public MultivariatePolynomial(List<PolynomialTerm> termList) {
		multivariatePolynomial = termList;
	}

	int calculatePolynomialDegree()
	{
		int variablePowerSum;
		int degreeOfPolynomial = 0;
		for(PolynomialTerm term : multivariatePolynomial)
		{
			variablePowerSum = 0;
			for(Polynomial variable : term.variableList)
			{
				variablePowerSum += variable.getVariablePower();
			}
			if(degreeOfPolynomial < variablePowerSum)
				degreeOfPolynomial = variablePowerSum;
		}
		return degreeOfPolynomial;
	}

	String displayPolynomial()
	{
		String polynomialString = "";
		for(PolynomialTerm term : multivariatePolynomial)
		{
			polynomialString = polynomialString + term.coffecient;
			for(Polynomial variable : term.variableList)
			{
				polynomialString = polynomialString + "*" + variable.getVaribleName() + "^" + 
						variable.getVariablePower();
			}
			if(term != multivariatePolynomial.get(multivariatePolynomial.size() - 1))
				polynomialString = polynomialString + " + ";
		}

		return polynomialString;
	}

	public static void main(String[] args) {

		List<PolynomialTerm> termList = new ArrayList<>();
		List<Polynomial> variable1 = new ArrayList<>();
		variable1.add(new Polynomial('x', 2));
		variable1.add(new Polynomial('y', 1));
		variable1.add(new Polynomial('z', 1));

		List<Polynomial> variable2 = new ArrayList<>();
		variable2.add(new Polynomial('x', 3));
		variable2.add(new Polynomial('y', 2));

		PolynomialTerm term1 = new PolynomialTerm(4, variable1);
		PolynomialTerm term2 = new PolynomialTerm(3, variable2);

		termList.add(term1);
		termList.add(term2);

		MultivariatePolynomial polynomialObject = new MultivariatePolynomial(termList);
		String polynomialString = polynomialObject.displayPolynomial();
		System.out.println("Multivariable Polynomial = " + polynomialString);
		System.out.println("Degree = " + polynomialObject.calculatePolynomialDegree());
	}
}

