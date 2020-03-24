
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList();
		list.insert(list, 2); 
		list.insert(list, 3); 
		list.insert(list, 4); 
		list.insert(list, 5); 
		list.insert(list, 6); 
		list.insert(list, 7);
		list.insert(list, 8);

//		list.printList(list);
//		System.out.println();
//		list.printList(modifyList(list, 2, 5, 2));;
		
//		list.head.next.next.next = list.head.next;
//		System.out.println(list.checkLoop(list));

		
	}

	public static LinkedList modifyList(LinkedList list, int l, int r, int n){
		LinkedList new_list = list.sub_list(list, l, r);
		new_list = new_list.rotate(new_list, n);
		new_list = new_list.insertList(list, new_list, l);
		return new_list;
	}

}
