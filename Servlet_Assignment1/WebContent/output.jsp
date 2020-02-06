<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.IOException, java.sql.Connection, java.sql.DriverManager, java.sql.PreparedStatement, java.sql.ResultSet,javax.servlet.http.Cookie" %>
<%@ page import="javax.servlet.annotation.WebServlet, javax.servlet.http.HttpServlet, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Metacube</title>
	<link rel="stylesheet" href="style.css">
  	<link href='http://fonts.googleapis.com/css?family=Nunito:400,300' rel='stylesheet' type='text/css'>
</head>
<body>

	<%
		int u_id = 1;
		String emp_id = null, name = null, mobile = null, gender = null, v_name = null, v_type = null, v_num = null;
		int[] cycle = {5, 100, 500};
		int[] motor_cycle = {10, 200, 1000};
		int[] four_wheeler = {20, 500, 3500};
		String plan, currency="";
		double price = 0;
		double base = 0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/parkingdata","root","root");
			Cookie cookies[] = request.getCookies();
			for(Cookie c: cookies){
				if(c.getName().equals("u_id"))
					u_id = Integer.parseInt(c.getValue());
			}
			PreparedStatement ps = con.prepareStatement("select * from user_info where u_id = ?");
			ps.setInt(1, u_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				name = rs.getString(2);
				mobile = rs.getString(5);
				gender = rs.getString(6);
			}
			ps = con.prepareStatement("select * from vehicle_info where u_id = ?");
			ps.setInt(1, u_id);
			rs = ps.executeQuery();
			while(rs.next()){
				emp_id = rs.getString(3);
				v_type = rs.getString(5);
				v_name = rs.getString(4);
				v_num = rs.getString(6);
				currency = rs.getString(8);
			}
			int vehicle[];
			if(v_type.equals("Cycle"))
				vehicle = cycle;
			else if(v_type.equals("MotorCycle"))
				vehicle = motor_cycle;
			else
				vehicle = four_wheeler;
			
			if(currency.equals("USD"))
				base = 0.014;
			else if(currency.equals("INR"))
				base = 1.0;
			else if(currency.equals("YEN"))
				base = 1.54;
			
			plan = request.getParameter("plan");
			if(plan.equals("daily"))
				price = base * vehicle[0];
			else if(plan.equals("monthly"))
				price = base  * vehicle[1];
			else if(plan.equals("yearly"))
				price = base  * vehicle[2];
			
		}catch(Exception e){
			e.printStackTrace();
		}
	%>
	<table align = "center">
            <tr>
                <th colspan="3">Metacube Parking Receipt</th>
            </tr>
            <tr>
                <th>Employee ID : </th>
                <td colspan = "2"><%= emp_id %></td>
                
            </tr>
            <tr>
                <th>Name : </th>
                <td colspan = "2"><%= name %></td>
                
            </tr>
            <tr>
                <th>Mobile Number : </th>
                <td colspan = "2"><%= mobile %></td>
                
            </tr>
            <tr>
                <th>Gender : </th>
                <td colspan = "2"><%= gender %></td>
                
            </tr>
            <tr>
                <th>Vehicle Name : </th>
                <td colspan = "2"><%= v_name %></td>
                
            </tr>
            <tr>
                <th>Vehicle Number : </th>
                <td colspan = "2"><%= v_num %></td>
                
            </tr>
            <tr>
                <th>Vehicle Type : </th>
                <td colspan = "2"><%= v_type %></td>
                
            </tr>
            <tr>
                <th colspan = "2">Total Price : </th>
                <td colspan = "2"><%= price %></td>
                
            </tr>
            
        </table>
</body>
</html>