package Question1;
import java.util.*;
class Node 
{ 
	String key; 
	Node sub_node[] = new Node[10]; 
	Node parent;
	Date date;
	@SuppressWarnings("unused")
	public Node(String item) 
	{ 
		key = item; 
		parent = null;
		this.date = new Date();
		for(Node node: sub_node)
			node = null;
	} 
	
	public Node() {
		// TODO Auto-generated constructor stub
	}
} 



//Tree tree = new Tree(); 
//
///*create root*/
//tree.root = new Node(1); 
//tree.root.sub_node[0] = new Node(2);
//tree.root.sub_node[1] = new Node(3);
//tree.root.sub_node[2] = new Node(4);
//tree.root.sub_node[0].sub_node[0] = new Node(5);
//tree.root.sub_node[0].sub_node[1] = new Node(9);
//tree.root.sub_node[2].sub_node[0] = new Node(6);
//tree.root.sub_node[2].sub_node[1] = new Node(7);
//try {
//	Tree.initialiseTree(tree.root);
//} catch (Exception e) {
//	// TODO Auto-generated catch block
//	System.out.println(e.getMessage());
//}
