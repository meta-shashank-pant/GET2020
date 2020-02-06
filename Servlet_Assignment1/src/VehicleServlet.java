import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/v_info")
public class VehicleServlet extends HttpServlet {

	private String v_name, v_number, v_identifiction, v_type, currency;
	private String emp_id;
	private static int u_id = LoadServlet.getId();
	
	public void service(HttpServletRequest request, HttpServletResponse response){
		
		try {
			this.emp_id =request.getParameter("empId");
			this.v_name = request.getParameter("VehicleName");
			this.v_number = request.getParameter("VehicleNumber");
			this.v_identifiction = request.getParameter("Identification");
			this.v_type = request.getParameter("VehicleType");
			this.currency = request.getParameter("VehicleCurrency");
			loadDatabase();
			Cookie cookie = new Cookie("u_id",u_id+"");
			response.addCookie(cookie);
			response.sendRedirect("ChoosePlan.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void loadDatabase(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/parkingdata","root","root");
			PreparedStatement ps = con.prepareStatement("insert into vehicle_info (u_id, emp_id, v_name, v_type, v_number, v_identification, currency_type)"
					+ " values (?,?,?,?,?,?,?)");
			ps.setInt(1, u_id);
			ps.setString(2, emp_id);
			ps.setString(3, v_name);
			ps.setString(4, v_type);
			ps.setString(5, v_number);
			ps.setString(6, v_identifiction);
			ps.setString(7, currency);
			ps.executeUpdate();
			ResultSet rs = ps.executeQuery("select * from vehicle_info");
			while(rs.next()){
				System.out.println(rs.getInt(1)+" --- "+rs.getString(2)+" --- "+rs.getString(3)+" --- "+rs.getString(4)+" --- "+rs.getString(5)+" --- "+rs.getString(6));
			}
			con.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}

}
