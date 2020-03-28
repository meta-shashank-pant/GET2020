package Question1;

class Tree 
{ 
	// Root of Binary Tree 
	Node root; 
	// Constructors 
	Tree(String key) 
	{ 
		root = new Node(key); 
	} 

	Tree() 
	{ 
		root = null; 
	}
	
	static String getPath(Node node) throws Exception {
		String output[] = new String[20];
		String result = "";
		int count = 0;
		while(true){
			if(node.parent == null){
				break;
			}else{
				output[count] = node.key;
				count ++;
				node = node.parent;
			}
		}
		for(int i = count-1; i >= 0; i--)
			result += output[i]+"\\";
		return result;
	}
	
	static void insertNode(Node node, String key) throws Exception {
		for(int i = 0; i < 11; i++){
			if(node.sub_node[i] != null){
				if(node.sub_node[i].key.equals(key)){
					System.out.println("Duplicate folder is not allowed in same directory.");
					return;
				}
			}
			if(node.sub_node[i] == null){
				node.sub_node[i] = new Node(key);
				return;
			}
		}
		System.out.println("Sub folder exceeded the limit.");
	}
	
	static Node changeDirectory(Node node, String key) throws Exception {
		for(int i = 0; i < 11; i++){
			if(node.sub_node[i] == null)
				return null;
			else if(node.sub_node[i].key.equals(key)){
				return node.sub_node[i];
			}
		}
		return null;
	}
	
	static void listCommand(Node node) throws Exception {
		for(int i = 0; i < 11; i++){
			if(node.sub_node[i] != null){
				System.out.println(node.sub_node[i].date+"  "+node.sub_node[i].key);
			}else{
				return;
			}
		}
	}
	
	static void initialiseTree(Node root) throws Exception{
		
		try{
			for(int i = 0; i < 11; i++){
				if(root.sub_node[i] != null){
					initialiseTree(root.sub_node[i]);
					root.sub_node[i].parent = root;
					//System.out.println("Value : "+root.sub_node[i].key+"  parent: "+root.sub_node[i].parent.key);
				}
				else
					return;
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	static void findCommand(Node node, String arg) throws Exception {
		try{
			for(int i = 0; i < 11; i++){
				if(node.sub_node[i] != null){
					findCommand(node.sub_node[i], arg);
					if(node.sub_node[i].key.contains(arg)){
						System.out.println(".\\"+getPath(node.sub_node[i]));
					}
				}
				else
					return;
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	static void printTree(Node root) throws Exception {
		for(int i = 0; i < 11; i++){
			if(root.sub_node[i] != null){
				printTree(root.sub_node[i]);
				System.out.println("Value : "+root.sub_node[i].key+"  parent: "+root.sub_node[i].parent.key);
			}
			else
				return;
		}
	}
	
} 

