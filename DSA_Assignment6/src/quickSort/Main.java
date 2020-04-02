package quickSort;

public class Main {

	public static void main(String args[]) {
		EmployeeLinkedList list = new EmployeeLinkedList();
		list.insertEmployee(new Employee("employee1", 12, 10000));
		list.insertEmployee(new Employee("employee2", 33, 10000));
		list.insertEmployee(new Employee("employee3", 25, 5000));
		list.insertEmployee(new Employee("employee4", 25, 16000));
		list.insertEmployee(new Employee("employee5", 25, 23000));
		System.out.println("\nBefore Sorting:");
		list.printList(list);
		list.quickSort();
		System.out.println("\n\nAfter Sorting:");
		list.printList(list);


	}
}
