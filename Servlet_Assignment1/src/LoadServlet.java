import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;

@WebServlet("/load")
public class LoadServlet extends HttpServlet{
	
	private String name, email, password, confirmParrword, mobileNumber, gender;
	private static int u_id;
	public void service(HttpServletRequest request, HttpServletResponse response){
		
		this.name = request.getParameter("Name");
		this.email = request.getParameter("EmailID");
		this.password = request.getParameter("Password");
		this.confirmParrword = request.getParameter("ConfirmPassword");
		this.mobileNumber = request.getParameter("MobileNumber");
		this.gender = request.getParameter("Gender");
		loadDatabase();
		try {
			response.sendRedirect("Vehicle.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static int getId(){
		System.out.println("+++ User ID is : "+u_id);
		return u_id;
	}
	
	private void loadDatabase(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/parkingdata","root","root");
			Statement stmt = con.createStatement();
			String query = "insert into user_info (name, email, password, mobile, gender) "
					+ "values(\""+name+"\", \"" +email+"\", \""
					+ password+"\", \""+mobileNumber+"\", \""+ gender +"\")";
			System.out.println(query);
			stmt.executeUpdate(query);
			PreparedStatement ps = con.prepareStatement("select u_id from user_info where email = ?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				u_id = rs.getInt(1);
			}
			con.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
}
