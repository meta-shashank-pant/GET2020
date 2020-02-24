package ServletFile;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.EmployeeDao;
import DAO.PassDao;
import DAO.VehicleDao;
import Models.Employee;
import Models.Pass;
import Models.Vehicle;


@WebServlet("/login")
public class Login extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String emailId = request.getParameter("emailId");
		String password = request.getParameter("password");
		
		if (EmployeeDao.isValidEmail(emailId, password)) {
			
			HttpSession session = request.getSession();
			session.setAttribute("emailId", emailId);
			session.setAttribute("password", password);
			
			Employee emp = EmployeeDao.getEmployee(emailId, password);
			session.setAttribute("employee", emp);
			
			int empId = emp.getEid();
			Pass empPass = PassDao.getPassDetails(empId);
			System.out.println(empPass.getPassType());
			session.setAttribute("employeePass", empPass);
			
			Vehicle empVehicle = VehicleDao.getVehicle(empId);
			session.setAttribute("employeeVehicle", empVehicle);
			
			response.sendRedirect("homepage.jsp");
		} else {
			response.sendRedirect("login.jsp");
		}
		
	}

}
