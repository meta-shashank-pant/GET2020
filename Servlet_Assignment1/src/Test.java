import java.sql.*;
import java.util.Scanner;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan  = new Scanner(System.in);
		int s_no = 0, marks = 0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temp","root","root");
			Statement stmt = con.createStatement();
			System.out.println("Enter 1");
			s_no = scan.nextInt();
			System.out.println("Enter 2");
			marks = scan.nextInt();
			System.out.println("Enter 3(String)");
			String name = scan.next();
			scan.close();
			String param1 = "insert into demo values("+s_no+", \"" +name+"\"," +marks+")";
			stmt.executeUpdate(param1);
			ResultSet rs = stmt.executeQuery("select * from demo");
			while(rs.next()){
				System.out.println(rs.getInt(1)+" --- "+rs.getString(2)+" --- "+rs.getInt(3));
			}
			con.close();
		}catch(Exception e){
			System.out.println(e);
		}
		
	}

}
