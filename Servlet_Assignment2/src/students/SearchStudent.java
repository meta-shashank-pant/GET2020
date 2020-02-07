package students;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import students.Database;

public class SearchStudent extends HttpServlet{
	
private static final long serialVersionUID=1L;
	
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		String firstname=req.getParameter("firstname");
		System.out.println(firstname);
		
		String lastname=req.getParameter("lastname");
		System.out.println(lastname);
		String query="select * from addStudent";
		
		String fname2="";
		String lname2="";
		String userData="";
		
		
		try {
			Connection con = Database.worker();			
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			PrintWriter out=res.getWriter();
			
			int flag=0;
			while(rs.next()){
				fname2="";
				lname2="";
				userData="";
				fname2=rs.getString(1);
				lname2=rs.getString(2);
				if(firstname.equals(fname2)&&lastname.equals(lname2)) {
					flag=1;
					System.out.println("success");
					
					userData=rs.getString(1)+"  "+rs.getString(2)+" : "+rs.getString(3)+" : "+rs.getString(4)+" : "+rs.getString(5)+" : "+rs.getString(6);
					out.println(userData);
					break;
				}
			}
			if(flag==0){
				System.out.println("Invalid email and password");
				
				out.println("Invalid email and password");
			}
		
			st.close();
			con.close();
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.println("invalid");
		} 
		
	}

}
