package question1;

import java.util.*;

public class Facade {

	static HashMap<Integer, Employee> emp_collection_facade;
	
	static HashMap<Integer, Employee> naturalSort() {
		return emp_collection_facade;
	}
	
	static boolean insertEmployee(int empId, String name, String address, HashMap<Integer, Employee> emp_collection){
		if(emp_collection.containsKey(empId)) {
			return false;
		}
		emp_collection.put(empId, new Employee(empId, name, address));
		emp_collection_facade = emp_collection;
		return true;
	}

	static void printHashMap(HashMap<Integer, Employee> emp_collection) {
		for(Integer key : emp_collection.keySet()) {
			System.out.println(key + " : " + emp_collection.get(key).name + " : "+emp_collection.get(key).address);
		}
	}

	static HashMap<Integer, Employee> sortByName(HashMap<Integer, Employee> emp_collection) {
		emp_collection_facade = emp_collection;
		List<Integer> mapKeys = new ArrayList<>(emp_collection.keySet());
		List<Employee> mapValues = new ArrayList<>(emp_collection.values());
		Collections.sort(mapValues, new NameComparator());
		Collections.sort(mapKeys);

		LinkedHashMap<Integer, Employee> sortedMap =
				new LinkedHashMap<>();
		
		for(Employee emp : mapValues)
			sortedMap.put(emp.empId, emp);
		

		return sortedMap;
	}
}



class NameComparator implements Comparator<Employee>
{
    public int compare(Employee o1, Employee o2)
    {
       return o1.name.compareTo(o2.name);
   }
}
