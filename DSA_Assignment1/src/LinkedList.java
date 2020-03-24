
/**
 * This class is used to implement linked list using class.
 * @author Shashank
 * In this class user can only insert and view the data value.
 */
public class LinkedList {
	Node head; // head of list 

	//This is the structure of the node.
	class Node { 

		int data; 
		Node next; 

		// Constructor 
		Node(int d) 
		{ 
			data = d; 
			next = null; 
		} 
	} 

	// This method will perform the insertion.
	public LinkedList insert(LinkedList list, int data) { 
		// Create a new node with given data 
		Node new_node = new Node(data); 
		new_node.next = null; 

		//If linked list is empty it will make new node as a head.
		if (list.head == null) { 
			list.head = new_node; 
		} 
		else { 
			//Otherwise traverse to the last and add the node at the end.
			Node last = list.head; 
			while (last.next != null) { 
				last = last.next; 
			} 

			// Insert the new_node at last node 
			last.next = new_node; 
		} 

		// Return the list by head 
		return list; 
	} 

	// Method to print the LinkedList. 
	public void printList(LinkedList list) { 
		Node currNode = list.head; 

		System.out.print("LinkedList: "); 

		// Traverse through the LinkedList 
		while (currNode != null) { 
			// Print the data at current node 
			System.out.print(currNode.data + " -> "); 

			// Go to next node 
			currNode = currNode.next; 
		} 
		System.out.print("Null");
	} 

	public LinkedList sub_list(LinkedList list,int l, int r) {

		Node currNode = list.head;
		int num = 1;
		LinkedList new_list = new LinkedList();
		while(currNode != null){
			if(num >= l && num <= r){
				new_list.insert(new_list, currNode.data);
			}

			currNode = currNode.next;
			num++;
		}

		return new_list;
	}

	public LinkedList rotate(LinkedList list, int k) {
		// If the linked list is empty 
		if (list.head == null) 
			return list; 

		Node tmp = list.head; 
		int len = 1; 
		while (tmp.next != null) 
		{ 
			tmp = tmp.next; 
			len++; 
		} 

		if (k > len) 
			k = k % len; 

		k = len - k; 

		if (k == 0) 
			return list; 

		Node current = list.head; 
		int cnt = 1; 
		while (cnt < k && current != null) 
		{ 
			current = current.next; 
			cnt++; 
		} 
		if (current == null) 
			return list; 
		Node kthnode = current; 
		tmp.next = head; 
		head = kthnode.next; 
		kthnode.next = null; 

		return list; 	
	}

	public LinkedList insertList(LinkedList list1, LinkedList list2, int pos) {

		LinkedList list = new LinkedList();
		Node node1 = list1.head;
		Node node2 = list2.head;
		int index = 1;
		while(node1 != null) {

			if(index == pos){
				while(node2 != null) {
					list.insert(list, node2.data);
					node1 = node1.next;
					node2 = node2.next;
				}
			}else{
				list.insert(list, node1.data);
				node1 = node1.next;
			}

			index++;

		}

		return list;
	}

	public boolean checkLoop(LinkedList list) {

		Node slow_p = head, fast_p = head; 
		while (slow_p != null && fast_p != null && fast_p.next != null) { 
			slow_p = slow_p.next; 
			fast_p = fast_p.next.next; 
			if (slow_p == fast_p) { 
				return true; 
			}
		} 
		return false;
	}
}
