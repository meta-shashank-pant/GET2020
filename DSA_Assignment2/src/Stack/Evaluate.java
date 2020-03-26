package Stack;


public class Evaluate {

	private Stack operator = new Stack();

	private Stack operand = new Stack();

	public int evaluateExpression(String inputExpression) throws Exception{

		if (inputExpression == null){
			throw new Exception ("Invalid input");
		}

		String[] inputArray = inputExpression.split(" ");

		for (int iterator = 0 ; iterator < inputArray.length ; iterator++){
			if ("(".equals(inputArray[iterator])){
				operator.push(inputArray[iterator]);
			}
			else if (")".equals(inputArray[iterator])){
				while (!"(".equals(operator.peek())){

					operand.push(Integer.toString(createBinaryExpression(operator, operand)));
				}

				operator.pop();
			}	

			else if (isOperator(inputArray[iterator])){
				while ((!operator.isEmpty()) && getOperatorPrecedence(inputArray[iterator]) 
						>= getOperatorPrecedence(operator.peek()) && (!"(".equals(operator.peek())) ){
					operand.push(Integer.toString(createBinaryExpression(operator, operand)));
				}	
				operator.push(inputArray[iterator]);
			}
			else{
				//pushing operands to stack
				operand.push(inputArray[iterator]);
			}	
		}

		while (!operator.isEmpty()){
			operand.push(Integer.toString(createBinaryExpression(operator, operand)));
		}
		return Integer.parseInt(operand.pop());
	}

	private boolean isOperator(String operator) {
		switch (operator){
		case "+":
		case "-":
		case "*":
		case "/":
		case "%":
		case ">":
		case ">=":
		case "<":
		case "<=":
		case "&&":
		case "||":
		case "==":
		case "!=":
			return true;
		default :
			return false;
		}
	}

	private int getOperatorPrecedence(String operator){
		int operatorPrecedence = 0;
		switch (operator){
		case "*":
		case "/":
		case "%":
			operatorPrecedence = 1;
			break;
		case "+":
		case "-":
			operatorPrecedence = 2;
			break;
		case "==":
		case "!=":
			operatorPrecedence = 3;
			break;
		case ">":
		case "<":
		case ">=":
		case "<=":
			operatorPrecedence = 4;
			break;
		case "&&":
			operatorPrecedence =5;
			break;
		case "||":
			operatorPrecedence = 6;
			break;
		}
		return operatorPrecedence;	
	}

	private int createBinaryExpression(Stack operator, Stack operand) throws Exception{
		if ((operator==null)||(operand==null)){
			throw new Exception ("Null stacks");
		}

		
		
		return (solveBinaryExpression(operand.pop(), operand.pop(), operator.pop()));
	}

	private int solveBinaryExpression(String operand1, String operand2, String operator) throws Exception {
		int result=0;
		int firstOperand = Integer.parseInt(operand1);
		int secondOperand = Integer.parseInt(operand2);
		switch (operator){
		case "+":
			result = secondOperand+firstOperand;
			break;
		case "-":
			result = secondOperand-firstOperand;
			break;
		case "*":
			result = secondOperand*firstOperand;
			break;
		case "/":
			result = secondOperand/firstOperand;
			break;
		case "%":
			result = secondOperand%firstOperand;
			break;
		case ">":
			if (secondOperand>firstOperand){
				result = 1;
			}
			else{
				result =0;
			}
			break;
		case ">=":
			if (secondOperand>=firstOperand){
				result = 1;
			}
			else{
				result =0;
			}
			break;	
		case "<":
			if (secondOperand<firstOperand){
				result = 1;
			}
			else{
				result =0;
			}
			break;	
		case "<=":
			if (secondOperand<=firstOperand){
				result = 1;
			}
			else{
				result =0;
			}
			break;	
		case "==":
			if (secondOperand==firstOperand){
				result = 1;
			}
			else{
				result =0;
			}
			break;	
		case "!=":
			if (secondOperand!=firstOperand){
				result = 1;
			}
			else{
				result = 0;
			}
			break;	
		case "&&":
			if ((secondOperand==0)||(firstOperand==0)){
				result = 0;
			}
			else{
				result =1;
			}
			break;	
		case "||":
			if ((secondOperand>=1)||(firstOperand>=1)){
				result = 1;
			}
			else{
				result =0;
			}
			break;		
		default :
			throw new Exception ("Invalid operator");
		}
		return result;
	}

}
