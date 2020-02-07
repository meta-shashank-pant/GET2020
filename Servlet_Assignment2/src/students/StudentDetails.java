package students;

public class StudentDetails {
	
	private String firstname;
	private String lastname;
	private String fathername;
	private String email;
	private String class1;
	private String age;
	
	public StudentDetails(String a,String b,String c,String d,String e,String f)
	{
		firstname=a;
		lastname=b;
		fathername=c;
		email=d;
		class1=e;
		age=f;
	}
	
	public String fname()
	{
		return firstname;
	}
	
	public String lname()
	{
		return lastname;
	}
	
	public String fatname()
	{
		return fathername;
	}
	
	public String mailer()
	{
		return email;
	}
	
	public String class1()
	{
		return class1;
	}
	
	public String age()
	{
		return age;
	}

}
