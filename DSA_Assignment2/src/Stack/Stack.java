package Stack;

public class Stack {

	private static final int SIZE_OF_STACK = 100;
	private String[] stack = new String[SIZE_OF_STACK];

	//pointing to the latest added element of stack
	private int top = -1;


	public void push(String element) throws Exception {

		if (top==(SIZE_OF_STACK-1)){
			throw new Exception ("Stack is full");
		}
		top = top+1;
		stack[top] = element;
	}


	public String pop() throws Exception {

		if (top==-1){
			throw new Exception ("Stack is empty");
		}
		String poppedElement = stack[top];
		top = top-1;
		return poppedElement;
	}


	public Boolean isEmpty(){
		if (top==-1){
			return true;
		}
		return false;
	}


	public String peek() throws Exception{
		if (top==-1){
			throw new Exception ("Stack is empty");
		}
		return stack[top];
	}
}
