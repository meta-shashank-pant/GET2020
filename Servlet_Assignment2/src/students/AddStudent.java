package students;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import java.sql.*;

import students.Database;

public class AddStudent extends HttpServlet{
	
	private static final long serialVersionUID=1L;
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		
		String firstname=req.getParameter("firstName");
		
		HttpSession session=req.getSession();
		
		session.setAttribute("firstname",firstname);
		
		String query3="insert into addStudent values(?,?,?,?,?,?)";
		try {
			Connection con=Database.worker();
			PreparedStatement st2=con.prepareStatement(query3);
			st2.setString(1, req.getParameter("firstName"));
			st2.setString(2, req.getParameter("lastName"));
			st2.setString(3, req.getParameter("fatherName"));
			st2.setString(4,req.getParameter("email"));
			st2.setString(5,req.getParameter("class"));
			st2.setString(6,req.getParameter("age"));
			
			st2.executeUpdate();
			PrintWriter out=res.getWriter();
			out.println("Insertion done ");
			
			res.sendRedirect("student2.jsp");
			st2.close();
			con.close();
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
