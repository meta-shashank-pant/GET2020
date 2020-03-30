package question1;

import java.util.HashMap;

public class Main {

	public static void main(String args[]) {
		HashMap<Integer, Employee> emp_collection = new HashMap<>();
		
		//By default 5 employees in employee collection.
		emp_collection.put(1, new Employee(1, "Shashank", "Jaipur"));
		emp_collection.put(2, new Employee(2, "Peter", "London"));
		emp_collection.put(3, new Employee(3, "Monika", "Utah"));
		emp_collection.put(4, new Employee(4, "Albus", "Berlin"));
		emp_collection.put(5, new Employee(5, "Alie", "Prague"));
		
		
		//insert an employee 
//		boolean result = Facade.insertEmployee(8, "jason", "dublin", emp_collection);
//		if(result)
//			System.out.println("Successful Insertion!");
//		else
//			System.out.println("Employee Id not unique!");
		
		Facade.insertEmployee(7, "Jason", "dublin", emp_collection);
		Facade.insertEmployee(9, "Jason", "dublin", emp_collection);
		
		//display the list of employees with details
		Facade.printHashMap(emp_collection);
		
		//sorted by name
		System.out.println("\nSORTING BY NAME: ");
		emp_collection = Facade.sortByName(emp_collection);
		Facade.printHashMap(emp_collection);
		
		//natural sort
		System.out.println("\nNATURAL SORT");
		emp_collection = Facade.naturalSort();
		Facade.printHashMap(emp_collection);
	}
}
