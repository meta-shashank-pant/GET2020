package question2;

public class Employee {

	private int employeeId;
	private double salary;
	private int age;

	public Employee(int id, double salary, int age){
		this.employeeId = id;
		this.salary = salary;
		this.age = age;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public double getSalary() {
		return salary;
	}

	public int getAge() {
		return age;
	}

	public String toString(){

		return "Employee id: "+employeeId+ " Employee Salary : "+salary+" Employee Age : "+age;
	}

	@Override
	public boolean equals(Object obj) 
	{ 

		if(this == obj) 
			return true; 

		if(obj == null || obj.getClass()!= this.getClass()) 
			return false; 

		// type casting of the argument.  
		Employee emp = (Employee) obj; 

		return (emp.employeeId == this.employeeId && emp.age == this.age && emp.salary == this.salary); 
	}


	@Override
	public int hashCode() 
	{ 
		return this.employeeId;
	}
}
