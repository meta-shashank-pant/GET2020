package question1;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;




import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



public class BST implements DictionaryInterface {

	public Node root;

	ArrayList<Node> sortedListValues = new ArrayList<Node>();
	ArrayList<Node> sortedListRangeValues = new ArrayList<Node>();

	//constructor
	public BST(String filepath) {
		this.root = null;
		this.readJSon(filepath);
	}


	//Read json file
	public void readJSon(String filepath) {

		try {
			JSONParser parser = new JSONParser();
			Object object = parser.parse(new FileReader(filepath));
			JSONArray listOfObjects = (JSONArray) object;
			@SuppressWarnings("unchecked")
			Iterator<JSONObject> itr = listOfObjects.iterator();

			while (itr.hasNext()) {
				JSONObject obj = itr.next();
				Node node = new Node(Integer.parseInt((String) obj.get("key")),
						(String) obj.get("value"));

				System.out.println(node.getKey() + "\t" + node.getValue());
				this.add(node, root);
			}

		} catch (Exception e) {
			System.out.println(e);

		}

	}


	public Node add(Node node, Node root) {

		if (node == null){
			throw new NullPointerException();
		}

		if (this.root == null) {
			this.root = node;
			return this.root;
		}

		if (root == null) {
			return node;
		}
		if (node.getKey() < root.getKey()) {
			root.left = add(node, root.left);
		} else if (node.getKey() > root.getKey()) {
			root.right = add(node, root.right);
		}
		return root;
	}


	
	public Node findMin(Node node) {

		if (node == null){
			throw new NullPointerException();
		}

		Node prev = null;
		while (node.left != null) {
			prev = node;
			node = node.left;
		}
		if (prev != null) {
			prev.left = null;
		}
		return node;
	}


	@Override
	public Node delete(int key, Node root) {

		// base case
		if (root == null){
			return root;
		}

		if (key < root.getKey())
			root.left = delete(key, root.left);

		else if (key > root.getKey())
			root.right = delete(key, root.right);
		else {
			// Node having 1 child
			if (root.left == null && root.right != null) {
				return root.right;
			}
			if (root.left != null && root.right == null) {
				return root.left;
			}

			// Node having two child
			if (root.left != null && root.right != null) {
				Node node = findMin(root.right);
				root.setKey(node.getKey());
				root.setValue(node.getValue());
				return root;
			}
		}
		return root;
	}


	@Override
	public String getValue(int Key, Node root) {

		while (root != null) {
			if (Key < root.getKey())
				root = root.left;
			else if (Key > root.getKey()) {
				root = root.right;
			} else {
				return root.getValue();
			}
		}
		return null;

	}


	
	@Override
	public void sortedList(Node root) {
		if (root != null) {
			sortedList(root.left);
			sortedListValues.add(root);
			sortedList(root.right);
		}
	}


	@Override
	public void sortedListRange(Node root, int k1, int k2) {

		if (root != null) {
			sortedListRange(root.left, k1, k2);
			if (root.getKey() >= k1 && root.getKey() <= k2)
				sortedListRangeValues.add(root);
			sortedListRange(root.right, k1, k2);
		}
	}

}
