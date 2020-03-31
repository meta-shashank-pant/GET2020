package question1;

public class Main {

	public static void main(String args[]) {
		String filePath = "C:\\Users\\Shashank\\Desktop\\Data Structure\\DSA_Assignment5\\src\\question1\\pairs.json";

		BST bst = new BST(filePath);

		Node obj = new Node(4, "John");
		
		//System.out.println(bst.findMin(bst.root).getKey());

		//Adding nodes to the BST.
		bst.add(obj, bst.root);

		System.out.println();
		System.out.println("Word deleted from dictinary with key : 45 ");
		Node objdeleted = bst.delete(45, bst.root);
		System.out.println("\nDeleted value is "+objdeleted.getValue());
		System.out.println("Sorted List After Deletion according to Key is:");
		bst.sortedList(bst.root);		
		for (int i = 0; i < bst.sortedListValues.size(); i++) {
			System.out.println(bst.sortedListValues.get(i).getKey()+"\t"+bst.sortedListValues.get(i).getValue());
		}

		System.out.println();

		System.out.println("Searching value in tree With The Key : 2");
		String objToSearch = bst.getValue(2, bst.root);
		if (objToSearch == null)
			System.out.println("Given key is not found.. Wrong input key!!.. So null value returned!!..");
		else
			System.out.println(objToSearch);
		System.out.println();

		// Clear before Every call or the new Range will be added with the previous data.
		bst.sortedListRangeValues.clear();
		bst.sortedListRange(bst.root, 1, 4);
		System.out.println("Sorted list of the Dictionary according to Keys in the specified range (1,4) is:");
		for (int i = 0; i < bst.sortedListRangeValues.size(); i++) {
			System.out.println(bst.sortedListRangeValues.get(i).getKey()
					+"\t"+ bst.sortedListRangeValues.get(i).getValue());
		}

		System.out.println();
		bst.sortedListRangeValues.clear();
		bst.sortedListRange(bst.root, 8, 34);
		System.out.println("Sorted list of the Dictionary according to Keys in the specified range (8,34) is:");
		for (int i = 0; i < bst.sortedListRangeValues.size(); i++) {
			System.out.println(bst.sortedListRangeValues.get(i).getKey()
					+"\t"+ bst.sortedListRangeValues.get(i).getValue());
		}
	}
}
