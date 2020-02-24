package ServletFile;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.EmployeeDao;
import Models.Employee;


@WebServlet("/friend")
public class FriendServlet extends HttpServlet {
	   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String emailId = (String) session.getAttribute("emailId");
		String password = (String) session.getAttribute("password");
		int empId = EmployeeDao.getEmployeeId(emailId, password);
		System.out.println(empId);
		List<Employee> employees = EmployeeDao.searchFriends(empId);
		/*for (Employee emp : employees) {
			out.println(emp.getEmpFirstName() + " " + emp.getEmpLastName() + " " + emp.getGender() + " " + emp.getEmailId() + " " + emp.getMobileNumber() + " " + emp.getOrgName());
		}*/
		session.setAttribute("friends", employees);
		response.sendRedirect("friends.jsp");
	}

}
