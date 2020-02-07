package students;
import java.sql.*;

public class Database {
	
public static Connection worker()throws Exception,ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");	
		
		return con;
		
	}	

}
