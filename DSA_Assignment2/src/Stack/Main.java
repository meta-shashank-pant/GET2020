package Stack;

public class Main {

	public static void main(String[] args) {

		Evaluate expression = new Evaluate();
		try{
			System.out.println(expression.evaluateExpression("0 || 0"));	
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}

}
