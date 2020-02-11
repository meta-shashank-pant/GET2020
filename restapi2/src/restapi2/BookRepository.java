package restapi2;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class BookRepository {
	
	List<Book> books;
	Connection con=null;

	
	public BookRepository()
	{		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/books","root","root");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public List<Book> getBooks()
	{
		List<Book> books=new ArrayList<>();
		String query1="select * from book";
		try{
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query1);
		while(rs.next())
		{
			Book a=new Book();
			a.setId(rs.getInt(1));
			a.setTitle(rs.getString(2));
			a.setWriter(rs.getString(3));
			a.setPublisher(rs.getString(4));
			a.setPublishedYear(rs.getInt(5));
			
			books.add(a);
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return books; 
	}
	
	public Book getBook(String title)
	{
		String query1="select * from book where title='"+title+"'";
		Book a=new Book();
		try{
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query1);
		if(rs.next())
		{
			a.setId(rs.getInt(1));
			a.setTitle(rs.getString(2));
			a.setWriter(rs.getString(3));
			a.setPublisher(rs.getString(4));
			a.setPublishedYear(rs.getInt(5));			
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return a; 
		
	}
	
	public Book getBookById(int id)
	{
		String query1="select * from book where id="+id;
		Book a=new Book();
		try{
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query1);
		if(rs.next())
		{
			a.setId(rs.getInt(1));
			a.setTitle(rs.getString(2));
			a.setWriter(rs.getString(3));
			a.setPublisher(rs.getString(4));
			a.setPublishedYear(rs.getInt(5));			
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return a; 
		
	}
	
	public void create(Book a1)
	{
		String query1="insert into book values(?,?,?,?,?)";
		try{
			PreparedStatement st=con.prepareStatement(query1);
			st.setInt(1, a1.getId());
			st.setString(2, a1.getTitle());
			st.setString(3, a1.getWriter());
			st.setString(4, a1.getPublisher());
			st.setInt(5, a1.getPublishedYear());
			
			st.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
	}
	
	public void update(Book a1)
	{
		//String query1="update book set title=?,writer=? where id=? ";
		String query1="update book set title=?,publishedyear=? where id=?";
		try{
			PreparedStatement st=con.prepareStatement(query1);
			st.setString(1, a1.getTitle());
			st.setInt(2, a1.getPublishedYear());
			st.setInt(3, a1.getId());			
			st.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}

	public void deleteAll() {
		String query1="delete from book";
		try{
			PreparedStatement st=con.prepareStatement(query1);
			st.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
		
	}

	public void deleteOne(int id) {
		String query1="delete from book where id=?";
		try{
			PreparedStatement st=con.prepareStatement(query1);
			st.setInt(1,id);
			st.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
	}
	
}
