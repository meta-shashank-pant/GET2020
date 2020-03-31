package question1;

public class Node {

	private int key;
	private String value;
	public Node left;
	public Node right;

	public Node(int key, String value) {
		this.key = key;
		this.value = value;
		this.left = null;
		this.right = null;
	}


	public int getKey() {
		return this.key;
	}


	public String getValue() {
		return this.value;
	}


	public void setKey(int key) {
		this.key = key;
	}


	public void setValue(String value) {
		this.value = value;
	}

}