package students;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import students.Database;

public class ShowStudent extends HttpServlet {
	
private static final long serialVersionUID=1L;	
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
				
		String query="select * from addStudent";

		String userData="";
		ArrayList<StudentDetails> lister=new ArrayList<StudentDetails>();
		
		try {
			Connection con = Database.worker();			
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);	
			PrintWriter out=res.getWriter();
			//out.println("<style>body{background:url('121420.jpg');background-size:'cover';}</style><body>");
		
			
			while(rs.next()){
				userData="";
				//mail2="";
				//pass2="";
				//mail2=rs.getString(2);
				//pass2=rs.getString(3);
				userData=" "+rs.getString(2)+" : "+rs.getString(3)+" : "+rs.getString(4)+" : "+rs.getString(5)+" : "+rs.getString(6);		
				//System.out.println(userData);
				
					//flag=1;
				StudentDetails sd=new StudentDetails(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
				lister.add(sd);	
				System.out.println("success");
				out.println("<table><tr><th>FirstName</th><th>LastName</th><th>FatherName</th><th>Mail</th><th>Class</th><th>Age</th></tr></table>");
				out.println("<a href='student4.jsp'>"+rs.getString(1)+"</a>");
				out.print(userData);
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
