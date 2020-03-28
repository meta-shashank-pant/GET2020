package Question1;

import java.util.Scanner;

public class Main {

	static String print = "R:\\";
	static Tree tree = new Tree("R");
	static Node pointer = tree.root;
	public static void main(String[] args) throws Exception 
	{ 
		Scanner scan = new Scanner(System.in);
		boolean flag = true;

		while(flag){
			System.out.print(print+"> ");
			String cmd = scan.nextLine();
			String[] commands = cmd.split(" ");
			//System.out.println(commands[0]+"    "+commands[1]);
			try{
				flag = executeCommand(commands[0], commands[1], pointer);
			}
			catch(Exception e){
				flag = executeCommand(commands[0], pointer);
			}
		}

		scan.close();

	}

	private static boolean executeCommand(String cmd, Node node) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = true;
		Tree.initialiseTree(node);
		//System.out.print("\\Single: "+node.key+" \n");
		switch(cmd) {
		case "bk":
			if(node.parent == null)
				System.out.println("This is root, you can not fall back.\n");
			else{
				pointer = pointer.parent;
				print = "R:\\" + Tree.getPath(pointer);
			}
			break;
		case "ls":
			Tree.listCommand(node);
			break;
		case "tree":
			Tree.printTree(node);
			break;
		case "exit":
			flag = false;
			break;
		default:
			System.out.print("Wrong usage OR Command not found!\n");
			break;

		}

		return flag;
	}

	private static boolean executeCommand(String cmd, String arg, Node node) throws Exception {
		// TODO Auto-generated method stub

		Tree.initialiseTree(node);
		//System.out.print("\nMultiple: "+node.key+" \n");
		switch(cmd) {
		case "mkdir": 
			Tree.insertNode(node, arg);
			break;
		case "cd":
			Node tmp = Tree.changeDirectory(node, arg);
			if(tmp == null || tmp == node)
				System.out.print("No directory exist with name " + arg + "\n");
			else{
				pointer = tmp;
				print = print + arg + "\\";
			}
			break;
		case "find":
			Tree.findCommand(node, arg);
			break;
		default:
			System.out.print("Wrong usage OR Command not found!\n");
			break;

		} 
		return true;
	}
}
