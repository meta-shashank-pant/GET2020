package students;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
//import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import students.Database;

public class FilterStudent  extends HttpServlet{
	
	private static final long serialVersionUID=1L;	
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
				
		String query="select count(firstName),class from addStudent group by class order by count(firstName) DESC";
	
		String userData="";
		
		try {
			Connection con = Database.worker();			
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);	
			PrintWriter out=res.getWriter();
			
			out.println("studs  class");
			while(rs.next()){
				userData="";
				userData=rs.getString(1)+"  "+rs.getString(2);		
				System.out.println("success");
				out.println(userData);
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
